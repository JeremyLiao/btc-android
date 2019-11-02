package com.jeremyliao.android.btc;

import com.jeremyliao.android.btc.core.MerkleTree;
import com.jeremyliao.android.btc.utils.EncryptUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by liaohailiang on 2019-11-01.
 */
public class MerkleTreeTest {

    @Test
    public void testMerkleTreeHash1() {
        List<byte[]> inputs = new ArrayList<>();
        inputs.add("A".getBytes());
        byte[] mth = MerkleTree.merkleTreeHash(inputs);
        System.out.println("MerkleTree: " + EncryptUtils.bytes2HexString(mth));
    }

    @Test
    public void testMerkleTreeHash2() {
        List<byte[]> inputs = new ArrayList<>();
        inputs.add("A".getBytes());
        inputs.add("B".getBytes());
        inputs.add("C".getBytes());
        inputs.add("D".getBytes());
        byte[] mth = MerkleTree.merkleTreeHash(inputs);
        System.out.println("MerkleTree: " + EncryptUtils.bytes2HexString(mth));
    }

    @Test
    public void testMerkleTreeHash3() {
        List<byte[]> inputs = new ArrayList<>();
        inputs.add("A".getBytes());
        inputs.add("B".getBytes());
        inputs.add("C".getBytes());
        inputs.add("D".getBytes());
        inputs.add("E".getBytes());
        byte[] mth = MerkleTree.merkleTreeHash(inputs);
        System.out.println("MerkleTree: " + EncryptUtils.bytes2HexString(mth));
    }
}