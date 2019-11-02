package com.jeremyliao.android.btc.core;

import com.jeremyliao.android.btc.utils.ByteUtils;

/**
 * Created by liaohailiang on 2019-10-31.
 */
public class BlockHeader {
    private byte[] bytes = new byte[80];

    private byte[] get(int offset, int length) {
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = bytes[offset + i];
        }
        return result;
    }

    private void put(byte[] src, int offset, int length) {
        for (int i = 0; i < length; i++) {
            bytes[offset + i] = src[i];
        }
    }

    public byte[] getVersion() {
        return get(0, 4);
    }

    public void setVersion(byte[] src) {
        put(src, 0, 4);
    }

    public byte[] getPreviousBlockHash() {
        return get(4, 32);
    }

    public void setPreviousBlockHash(byte[] src) {
        put(src, 4, 32);
    }

    public byte[] getMerkleRoot() {
        return get(36, 32);
    }

    public void setMerkleRoot(byte[] src) {
        put(src, 36, 32);
    }

    public byte[] getTimestamp() {
        return get(68, 4);
    }

    public void setTimestamp(byte[] src) {
        put(src, 68, 4);
    }

    public byte[] getBits() {
        return get(72, 4);
    }

    public void setBits(byte[] src) {
        put(src, 72, 4);
    }

    public byte[] getNounce() {
        return get(76, 4);
    }

    public void setNounce(byte[] src) {
        put(src, 76, 4);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public static final class Builder {
        private static final int VERSION = 1;
        private BlockHeader blockHeader;

        public Builder() {
            blockHeader = new BlockHeader();
            blockHeader.setVersion(ByteUtils.int2Bytes(VERSION));
        }

        public Builder previousBlockHash(byte[] hash) {
            blockHeader.setPreviousBlockHash(hash);
            return this;
        }

        public Builder merkleRoot(byte[] root) {
            blockHeader.setMerkleRoot(root);
            return this;
        }

        public Builder timestamp(int timestamp) {
            blockHeader.setTimestamp(ByteUtils.int2Bytes(timestamp));
            return this;
        }

        public Builder bits(int bits) {
            blockHeader.setBits(ByteUtils.int2Bytes(bits));
            return this;
        }

        public Builder nounce(int nounce) {
            blockHeader.setNounce(ByteUtils.int2Bytes(nounce));
            return this;
        }

        public BlockHeader build() {
            return blockHeader;
        }


    }
}
