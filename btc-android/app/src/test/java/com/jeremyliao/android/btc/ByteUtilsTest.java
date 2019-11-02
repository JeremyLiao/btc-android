package com.jeremyliao.android.btc;

import com.jeremyliao.android.btc.core.ProofOfWork;
import com.jeremyliao.android.btc.utils.BitUtils;
import com.jeremyliao.android.btc.utils.ByteUtils;
import com.jeremyliao.android.btc.utils.EncryptUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class ByteUtilsTest {

    @Test
    public void testLessThan1() {
        byte[] target = ProofOfWork.getPOWTarget(5);
        byte[] bytes = EncryptUtils.encryptSHA256("helloworld".getBytes());
        assertFalse(ByteUtils.lessThan(bytes, target));
        BitUtils.fillMultiBit0(bytes, 5);
        assertTrue(ByteUtils.lessThan(bytes, target));
    }

    @Test
    public void testIntByteConvert() {
        for (int i = -10; i < 10; i++) {
            int ret = ByteUtils.bytes2Int(ByteUtils.int2Bytes(i));
            assertEquals(i, ret);
        }
    }
}