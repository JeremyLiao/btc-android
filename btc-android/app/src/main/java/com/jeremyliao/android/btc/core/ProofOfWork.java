package com.jeremyliao.android.btc.core;

import com.jeremyliao.android.btc.utils.BitUtils;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class ProofOfWork {

    public static byte[] work(BlockHeader header) {
        return null;
    }

    public static byte[] getPOWTarget(int hardIndex) {
        byte[] target = new byte[32];
        BitUtils.fillByteBy1(target);
        BitUtils.fillMultiBit0(target, hardIndex);
        return target;
    }
}
