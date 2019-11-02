package com.jeremyliao.android.btc.core;

import com.jeremyliao.android.btc.utils.EncryptUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class MerkleTree {

    private List<byte[]> datas;
    private byte[] result;

    public static byte[] merkleTreeHash(List<byte[]> inputs) {
        if (inputs == null || inputs.size() == 0) {
            return null;
        }
        if (inputs.size() == 1) {
            return EncryptUtils.encryptSHA256(inputs.get(0));
        }
        List<byte[]> tempInputs = new ArrayList<>(inputs);
        while (true) {
            List<byte[]> outputs = innerMerkleTreeHash(tempInputs);
            if (outputs.size() == 1) {
                return EncryptUtils.encryptSHA256(outputs.get(0));
            } else {
                tempInputs = outputs;
            }
        }
    }

    private static List<byte[]> innerMerkleTreeHash(List<byte[]> inputs) {
        List<byte[]> outputs = new ArrayList<>();
        int counts = (inputs.size() + 1) / 2;
        for (int i = 0; i < counts; i++) {
            int index = 2 * i;
            byte[] hash1 = EncryptUtils.encryptSHA256(inputs.get(index));
            if (index + 1 < inputs.size()) {
                byte[] hash2 = EncryptUtils.encryptSHA256(inputs.get(index + 1));
                byte[] mergedHash = Arrays.copyOf(hash1, hash1.length + hash2.length);
                System.arraycopy(hash2, 0, mergedHash, hash1.length, hash2.length);
                outputs.add(mergedHash);
            } else {
                outputs.add(hash1);
            }
        }
        return outputs;
    }
}
