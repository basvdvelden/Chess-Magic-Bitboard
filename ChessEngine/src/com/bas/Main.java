package com.bas;

import com.bas.Moves.PseudoLegalMoves;

public class Main {
    public static void main(String[] args) {
        PseudoLegalMoves move = new PseudoLegalMoves();
        long moves = move.getRookPseudoMovesFrom(54);
        String binary = Long.toBinaryString(moves);
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < 64 - binary.length(); i ++) {
            builder.append("0");
        }
        binary = builder.toString() + binary;
        int sq = 0;
        for (int i = 0; i < 8; i ++) {
            for (int j = sq; j < sq + 8; j++) {
                System.out.print(binary.charAt(j) + "  ");
            }
            System.out.println();
            sq += 8;
        }

    }
}
