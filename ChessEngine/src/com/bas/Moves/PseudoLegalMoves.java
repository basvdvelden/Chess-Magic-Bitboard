package com.bas.Moves;

import com.bas.Util;

public class PseudoLegalMoves {

    private final long[] bishopMoveMasks = this.genBishopMoveMasks();
    private final long[] rookMoveMasks = this.genRookMoveMasks();

    private long[] genBishopMoveMasks() {
        final long[] masks = new long[64];

        for (int bitIndex = 0; bitIndex < 64; bitIndex ++) {
            masks[bitIndex] = this.getBishopPseudoMovesFrom(bitIndex);
        }
        return masks;
    }

    private long[] genRookMoveMasks() {
        final long[] masks = new long[64];

        for (int bitIndex = 0; bitIndex < 64; bitIndex ++) {
            masks[bitIndex] = this.getRookPseudoMovesFrom(bitIndex);
        }
        return masks;
    }

    public long getBishopPseudoMovesFrom(int bitIndex) {
        long bishopLoc = 1L << bitIndex;
        long pseudoMoves = bishopLoc;

        if (this.canGoNoEast(bitIndex)) {
            int sq = bitIndex + 7;
            while (sq < 56) {
                pseudoMoves |= 1L << sq;
                if ((sq - 1) % 8 == 0) {
                    break;
                }
                sq += 7;
            }
        }

        if (this.canGoSoEast(bitIndex)) {
            int sq = bitIndex - 9;
            while (sq > 8) {
                pseudoMoves |= 1L << sq;
                if ((sq - 1) % 8 == 0) {
                    break;
                }
                sq -= 9;
            }
        }

        if (this.canGoSoWest(bitIndex)) {
            int sq = bitIndex - 7;
            while (sq > 8) {
                pseudoMoves |= 1L << sq;
                if ((sq + 2) % 8 == 0) {
                    break;
                }
                sq -= 7;
            }
        }

        if (this.canGoNoWest(bitIndex)) {
            int sq = bitIndex + 9;
            while (sq < 56) {
                pseudoMoves |= 1L << sq;
                if ((sq + 2) % 8 == 0) {
                    break;
                }
                sq += 9;
            }
        }
        pseudoMoves &= ~bishopLoc;
        return pseudoMoves;
    }

    private boolean canGoNoEast(int bitIndex) {
        return ((bitIndex + 7) + 1) % 8 != 0;
    }

    private boolean canGoSoEast(int bitIndex) {
        return ((bitIndex - 9) + 1) % 8 != 0 && (bitIndex - 9) % 8 != 0;
    }

    private boolean canGoSoWest(int bitIndex) {
        return (bitIndex - 7) % 8 != 0 && ((bitIndex - 7) + 1) % 8 != 0;
    }

    private boolean canGoNoWest(int bitIndex) {
        return (bitIndex + 9) % 8 != 0;
    }

    public long getRookPseudoMovesFrom(int bitIndex) {
        long rookLoc = 1L << bitIndex;
        long rookMoves = rookLoc;

        if (this.canGoNorth(bitIndex)) {
            int sq = bitIndex + 8;
            while (this.canGoNorth(sq - 8)) {
                rookMoves |= 1L << sq;
                sq += 8;
            }
        }
        if (this.canGoEast(bitIndex)) {
            int sq = bitIndex - 1;
            while (this.canGoEast(sq + 1)) {
                rookMoves |= 1L << sq;
                sq -= 1;
            }
        }
        if (this.canGoSouth(bitIndex)) {
            int sq = bitIndex - 8;
            while (this.canGoSouth(sq + 8)) {
                rookMoves |= 1L << sq;
                sq -= 8;
            }
        }
        if (this.canGoWest(bitIndex)) {
            int sq = bitIndex + 1;
            while (this.canGoWest(sq - 1)) {
                rookMoves |= 1L << sq;
                sq += 1;
            }
        }
        return rookMoves &= ~rookLoc;
    }

    private boolean canGoNorth(int bitIndex) {
        return bitIndex < 48;
    }

    private boolean canGoEast(int bitIndex) {
        if ((bitIndex + 8) % 8 == 0) {
            return false;
        } else return (bitIndex + 7) % 8 != 0;
    }

    private boolean canGoSouth(int bitIndex) {
        return bitIndex > 15;
    }

    private boolean canGoWest(int bitIndex) {
        if ((bitIndex + 1) % 8 == 0) {
            return false;
        } else return (bitIndex + 2) % 8 != 0;
    }

    private long[][] generateBishopOccupancy() {
        long[][] bishopOcc = new long[64][];

        for(int bitIndex = 0; bitIndex < 64; bitIndex ++) {
            int[] setBitsInOcc = Util.getBitIndices(this.bishopMoveMasks[bitIndex]);
            int variationCount = 2^Long.bitCount(this.bishopMoveMasks[bitIndex]);
            bishopOcc[bitIndex] = new long[variationCount];

            for (int varInd = 0; varInd < variationCount; varInd ++) {
                int currVarInd = varInd;
                while()
            }
        }
        return null;
    }
}
