package com.bas;

public class Util {

    public static int getBitIndex(long board) {
        return Long.numberOfTrailingZeros(board);
    }

    public static int[] getBitIndices(long board) {
        int[] bitIndices = new int[Long.bitCount(board)];

        for (int i = 0; i < bitIndices.length; i ++) {
            bitIndices[i] = Long.numberOfTrailingZeros(board);
            board &= board - 1;
        }

        return bitIndices;
    }
}
