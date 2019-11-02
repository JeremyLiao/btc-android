package com.jeremyliao.android.btc;

import com.jeremyliao.android.btc.utils.BitUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class BitConvertTest {
    @Test
    public void testSetBit1() {
        byte[] target = new byte[1];
        assertEquals(target[0], 0);
        BitUtils.fillByteBy1(target);
        assertEquals(target[0], (byte) (0xff));
        BitUtils.fillByteBy0(target);
        assertEquals(target[0], 0);
    }

    @Test
    public void testSetBit2() {
        byte[] target = new byte[1];
        BitUtils.fillByteBy1(target);
        BitUtils.setBit0(target, 0);
        assertEquals(target[0], (byte) (0x7f));
    }

    @Test
    public void testSetBit3() {
        byte[] target = new byte[1];
        BitUtils.fillByteBy1(target);
        BitUtils.setBit0(target, 3);
        assertEquals(target[0], (byte) (0xef));
    }

    @Test
    public void testSetBit4() {
        byte[] target = new byte[1];
        BitUtils.setBit1(target, 0);
        assertEquals(target[0], (byte) (0x80));
    }

    @Test
    public void testSetBit5() {
        byte[] target = new byte[1];
        BitUtils.setBit1(target, 7);
        assertEquals(target[0], (byte) (0x01));
    }

    @Test
    public void testSetBit6() {
        byte[] target = new byte[1];
        BitUtils.fillByteBy1(target);
        BitUtils.setBit0(target, 7);
        assertEquals(target[0], (byte) (0xfe));
    }

    @Test
    public void testSetBit7() {
        byte[] target = new byte[1];
        BitUtils.fillByteBy1(target);
        BitUtils.fillMultiBit0(target, 1);
        assertEquals(target[0], (byte) (0x7f));
    }

    @Test
    public void testSetBit8() {
        byte[] target = new byte[1];
        BitUtils.fillByteBy1(target);
        BitUtils.fillMultiBit0(target, 4);
        assertEquals(target[0], (byte) (0x0f));
    }

    @Test
    public void testSetBit9() {
        byte[] target = new byte[1];
        BitUtils.fillByteBy1(target);
        BitUtils.fillMultiBit0(target, 8);
        assertEquals(target[0], (byte) (0x00));
    }

    @Test
    public void testSetBit10() {
        byte[] target = new byte[2];
        BitUtils.fillByteBy1(target);
        BitUtils.fillMultiBit0(target, 8);
        assertEquals(target[0], (byte) (0x00));
        assertEquals(target[1], (byte) (0xff));
    }

    @Test
    public void testSetBit11() {
        byte[] target = new byte[2];
        BitUtils.fillByteBy1(target);
        BitUtils.fillMultiBit0(target, 16);
        assertEquals(target[0], (byte) (0x00));
        assertEquals(target[1], (byte) (0x00));
    }
}