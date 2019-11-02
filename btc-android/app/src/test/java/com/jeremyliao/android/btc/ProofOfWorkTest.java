package com.jeremyliao.android.btc;

import com.jeremyliao.android.btc.core.ProofOfWork;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class ProofOfWorkTest {

    @Test
    public void getPOWTarget1() {
        byte[] target = ProofOfWork.getPOWTarget(7);
        assertEquals(target[0], (byte) (0x01));
        for (int i = 1; i < target.length; i++) {
            assertEquals(target[i], (byte) (0xff));
        }
    }

    @Test
    public void getPOWTarget2() {
        byte[] target = ProofOfWork.getPOWTarget(15);
        assertEquals(target[0], (byte) (0x00));
        assertEquals(target[1], (byte) (0x01));
        for (int i = 2; i < target.length; i++) {
            assertEquals(target[i], (byte) (0xff));
        }
    }

    @Test
    public void getPOWTarget3() {
        byte[] target = ProofOfWork.getPOWTarget(23);
        assertEquals(target[0], (byte) (0x00));
        assertEquals(target[1], (byte) (0x00));
        assertEquals(target[2], (byte) (0x01));
        for (int i = 3; i < target.length; i++) {
            assertEquals(target[i], (byte) (0xff));
        }
    }
}