package com.jeremyliao.android.btc.core;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class BlockChain {

    public static BlockChain getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final BlockChain instance = new BlockChain();
    }

    private BlockChain() {
    }

    private List<Block> blocks = new LinkedList<>();
    private int currentBits = 24;

    public List<Block> getBlocks() {
        return blocks;
    }

    public int getCurrentBits() {
        return currentBits;
    }
}
