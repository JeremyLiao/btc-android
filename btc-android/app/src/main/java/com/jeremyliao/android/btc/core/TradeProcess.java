package com.jeremyliao.android.btc.core;

import com.jeremyliao.android.btc.core.transaction.CoinBaseTransaction;
import com.jeremyliao.android.btc.core.transaction.Transaction;
import com.jeremyliao.android.btc.utils.ByteUtils;
import com.jeremyliao.android.btc.utils.EncryptUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class TradeProcess implements Callable<Block> {

    @Override
    public Block call() {
        Block block = new Block();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new CoinBaseTransaction());
        block.setTransactions(transactions);
        BlockHeader.Builder builder = new BlockHeader.Builder()
                .merkleRoot(MerkleTree.merkleTreeHash(block.getTransactionsAsByteArray()))
                .bits(BlockChain.getInstance().getCurrentBits())
                .timestamp((int) System.currentTimeMillis());
        List<Block> blocks = BlockChain.getInstance().getBlocks();
        if (blocks.size() > 0) {
            Block previousBlock = blocks.get(blocks.size() - 1);
            builder.previousBlockHash(EncryptUtils.encryptSHA256(previousBlock.getHeader().getBytes()));
        }
        block.setHeader(builder.build());
        int nounce = 0;
        byte[] powTarget = ProofOfWork.getPOWTarget(ByteUtils.bytes2Int(block.getHeader().getBits()));
        while (true) {
            block.getHeader().setNounce(ByteUtils.int2Bytes(nounce));
            byte[] bytes = EncryptUtils.encryptSHA256(EncryptUtils.encryptSHA256(block.getHeader().getBytes()));
            if (ByteUtils.lessThan(bytes, powTarget)) {
                System.out.println("pow target: " + EncryptUtils.bytes2HexString(powTarget));
                System.out.println("find coin: " + EncryptUtils.bytes2HexString(bytes));
                BlockChain.getInstance().getBlocks().add(block);
                return block;
            }
            nounce++;
        }
    }
}
