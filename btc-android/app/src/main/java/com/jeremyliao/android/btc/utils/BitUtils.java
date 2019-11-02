package com.jeremyliao.android.btc.utils;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class BitUtils {

    public static void fillByteBy0(byte[] target) {
        if (target == null || target.length == 0) {
            return;
        }
        for (int i = 0; i < target.length; i++) {
            target[i] = 0;
        }
    }

    public static void fillByteBy1(byte[] target) {
        if (target == null || target.length == 0) {
            return;
        }
        for (int i = 0; i < target.length; i++) {
            target[i] = (byte) 0xff;
        }
    }

    public static void setBit0(byte[] target, int offset) {
        if (target == null || target.length == 0) {
            return;
        }
        int byteOffset = offset / 8;
        int bitOffset = offset % 8;
        if (byteOffset >= target.length) {
            return;
        }
        byte dest = target[byteOffset];
        int ret = ~(1 << (7 - bitOffset));
        byte and = (byte) ret;
        dest = (byte) (dest & and);
        target[byteOffset] = dest;
    }

    public static void setBit1(byte[] target, int offset) {
        if (target == null || target.length == 0) {
            return;
        }
        int byteOffset = offset / 8;
        int bitOffset = offset % 8;
        if (byteOffset >= target.length) {
            return;
        }
        byte dest = target[byteOffset];
        int ret = 1 << (7 - bitOffset);
        byte or = (byte) ret;
        dest = (byte) (dest | or);
        target[byteOffset] = dest;
    }

    public static void fillMultiBit0(byte[] target, int num) {
        for (int i = 0; i < num; i++) {
            setBit0(target, i);
        }
    }

}
