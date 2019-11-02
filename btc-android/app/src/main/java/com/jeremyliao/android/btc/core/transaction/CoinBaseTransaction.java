package com.jeremyliao.android.btc.core.transaction;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class CoinBaseTransaction implements Transaction {

    private static final String CBT_FLAG = "cbt_flag";

    @Override
    public byte[] asByte() {
        return CBT_FLAG.getBytes();
    }
}
