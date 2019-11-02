package com.jeremyliao.android.btc;

import com.jeremyliao.android.btc.core.BlockHeader;
import com.jeremyliao.android.btc.core.ProofOfWork;
import com.jeremyliao.android.btc.core.TradeProcess;
import com.jeremyliao.android.btc.utils.BitUtils;
import com.jeremyliao.android.btc.utils.ByteUtils;
import com.jeremyliao.android.btc.utils.EncryptUtils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class MainTest {

    @Test
    public void testMainProcess() {
        for (int i = 0; i < 10; i++) {
            TradeProcess process = new TradeProcess();
            process.call();
        }
    }
}