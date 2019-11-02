package com.jeremyliao.android.btc;

import com.jeremyliao.android.btc.core.BlockHeader;
import com.jeremyliao.android.btc.utils.ByteUtils;
import com.jeremyliao.android.btc.utils.EncryptUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class BlockHeaderTest {

    @Test
    public void testByteInt() {
        int timeMillis = (int) System.currentTimeMillis();
        int anInt = ByteUtils.bytes2Int(ByteUtils.int2Bytes(timeMillis));
        Assert.assertEquals(timeMillis, anInt);
    }

    @Test
    public void testVersion() {
        BlockHeader header = new BlockHeader();
        byte[] version = header.getVersion();
        Assert.assertEquals(version.length, 4);
        header.setVersion(EncryptUtils.hexString2Bytes("02000000"));
        version = header.getVersion();
        Assert.assertEquals(EncryptUtils.bytes2HexString(version), "02000000");
    }

    @Test
    public void testTimestamp() {
        BlockHeader header = new BlockHeader();
        byte[] timestamp = header.getTimestamp();
        Assert.assertEquals(timestamp.length, 4);
        int timeMillis = (int) System.currentTimeMillis();
        header.setTimestamp(ByteUtils.int2Bytes(timeMillis));
        timestamp = header.getTimestamp();
        Assert.assertEquals(ByteUtils.bytes2Int(timestamp), timeMillis);
    }

    @Test
    public void testBits() {
        BlockHeader header = new BlockHeader();
        byte[] bits = header.getBits();
        Assert.assertEquals(bits.length, 4);
        header.setBits(EncryptUtils.hexString2Bytes("02000000"));
        bits = header.getBits();
        Assert.assertEquals(EncryptUtils.bytes2HexString(bits), "02000000");
    }

    @Test
    public void testNounce() {
        BlockHeader header = new BlockHeader();
        byte[] nounce = header.getNounce();
        Assert.assertEquals(nounce.length, 4);
        header.setNounce(EncryptUtils.hexString2Bytes("02000000"));
        nounce = header.getNounce();
        Assert.assertEquals(EncryptUtils.bytes2HexString(nounce), "02000000");
    }
}