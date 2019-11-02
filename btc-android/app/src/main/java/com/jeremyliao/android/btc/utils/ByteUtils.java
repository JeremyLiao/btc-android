package com.jeremyliao.android.btc.utils;

import java.nio.ByteBuffer;

/**
 * Created by liaohailiang on 2019-10-31.
 */
public class ByteUtils {

    public static byte[] int2Bytes(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static int bytes2Int(byte[] src) {
        return ((ByteBuffer) ByteBuffer.allocate(4).put(src, 0, 4).flip()).getInt();
    }

    public static boolean equals(byte[] src, byte[] dest) {
        if (src == null && dest == null) {
            return true;
        }
        if (src == null || dest == null) {
            return false;
        }
        if (src.length != dest.length) {
            return false;
        }
        for (int i = 0; i < src.length; i++) {
            if (src[i] != dest[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThan(byte[] array1, byte[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            int ret = getUnsignedByte(array1[i]) - getUnsignedByte(array2[i]);
            if (ret < 0) {
                return true;
            } else if (ret > 0) {
                return false;
            }
        }
        return false;
    }

    private static int getUnsignedByte(byte b) {
        return b & 0x0FF;
    }

}
