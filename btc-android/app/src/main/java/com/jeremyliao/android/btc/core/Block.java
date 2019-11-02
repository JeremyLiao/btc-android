package com.jeremyliao.android.btc.core;

import com.jeremyliao.android.btc.core.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class Block {

    private BlockHeader header;
    private List<Transaction> transactions;

    public BlockHeader getHeader() {
        return header;
    }

    public void setHeader(BlockHeader header) {
        this.header = header;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<byte[]> getTransactionsAsByteArray() {
        if (transactions == null || transactions.size() == 0) {
            return null;
        }
        List<byte[]> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            result.add(transaction.asByte());
        }
        return result;
    }
}
