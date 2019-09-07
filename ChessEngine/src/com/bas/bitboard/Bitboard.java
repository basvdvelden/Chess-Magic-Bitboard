package com.bas.bitboard;

public class Bitboard {

    private final byte WHITE = 0;
    private final byte BLACK = 1;
    private final long[][] board = new long[7][2];
    private static final long[] WHITE_PIECES = {0x8L, 0x10L, 0x81L, 0x24L, 0x42L, 0xFF00L, 0x20000000199L};
    private static final long[] BLACK_PIECES = {0x800000000000000L, 0x1000000000000000L, 0x8100000000000000L, 0x2400000000000000L, 0x4200000000000000L, 0xFF000000000000L, 0x9900020000000000L};

    public Bitboard() {
    }

    public long[][] genBoard() {
        for(int i = 0; i < this.board.length; i++) {
            this.board[i][WHITE] = WHITE_PIECES[i];
            this.board[i][BLACK] = BLACK_PIECES[i];
        }
        return null;
    }

    public long[][] getBoard() {
        return this.board;
    }
}
