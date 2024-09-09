package com.google.zxing.aztec.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP;
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE;
    private final byte[] text;
    static final String[] MODE_NAMES = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] LATCH_TABLE = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, 5, 256);
        CHAR_MAP = iArr;
        iArr[0][32] = 1;
        for (int i4 = 65; i4 <= 90; i4++) {
            CHAR_MAP[0][i4] = (i4 - 65) + 2;
        }
        CHAR_MAP[1][32] = 1;
        for (int i5 = 97; i5 <= 122; i5++) {
            CHAR_MAP[1][i5] = (i5 - 97) + 2;
        }
        CHAR_MAP[2][32] = 1;
        for (int i6 = 48; i6 <= 57; i6++) {
            CHAR_MAP[2][i6] = (i6 - 48) + 2;
        }
        int[][] iArr2 = CHAR_MAP;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i7 = 0; i7 < 28; i7++) {
            CHAR_MAP[3][iArr3[i7]] = i7;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i8 = 0; i8 < 31; i8++) {
            if (iArr4[i8] > 0) {
                CHAR_MAP[4][iArr4[i8]] = i8;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(int.class, 6, 6);
        SHIFT_TABLE = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = SHIFT_TABLE;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    private static Collection<State> simplifyStates(Iterable<State> iterable) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            boolean z3 = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                State state2 = (State) it.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    z3 = false;
                    break;
                } else if (state.isBetterThanOrEqualTo(state2)) {
                    it.remove();
                }
            }
            if (z3) {
                linkedList.add(state);
            }
        }
        return linkedList;
    }

    private void updateStateForChar(State state, int i4, Collection<State> collection) {
        char c4 = (char) (this.text[i4] & 255);
        boolean z3 = CHAR_MAP[state.getMode()][c4] > 0;
        State state2 = null;
        for (int i5 = 0; i5 <= 4; i5++) {
            int i6 = CHAR_MAP[i5][c4];
            if (i6 > 0) {
                if (state2 == null) {
                    state2 = state.endBinaryShift(i4);
                }
                if (!z3 || i5 == state.getMode() || i5 == 2) {
                    collection.add(state2.latchAndAppend(i5, i6));
                }
                if (!z3 && SHIFT_TABLE[state.getMode()][i5] >= 0) {
                    collection.add(state2.shiftAndAppend(i5, i6));
                }
            }
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c4] == 0) {
            collection.add(state.addBinaryShiftChar(i4));
        }
    }

    private static void updateStateForPair(State state, int i4, int i5, Collection<State> collection) {
        State endBinaryShift = state.endBinaryShift(i4);
        collection.add(endBinaryShift.latchAndAppend(4, i5));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, i5));
        }
        if (i5 == 3 || i5 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - i5).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i4).addBinaryShiftChar(i4 + 1));
        }
    }

    private Collection<State> updateStateListForChar(Iterable<State> iterable, int i4) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            updateStateForChar(state, i4, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private static Collection<State> updateStateListForPair(Iterable<State> iterable, int i4, int i5) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            updateStateForPair(state, i4, i5, linkedList);
        }
        return simplifyStates(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.common.BitArray encode() {
        /*
            r8 = this;
            com.google.zxing.aztec.encoder.State r0 = com.google.zxing.aztec.encoder.State.INITIAL_STATE
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = 0
        L8:
            byte[] r3 = r8.text
            int r4 = r3.length
            if (r2 >= r4) goto L4c
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L15
            r5 = r3[r4]
            goto L16
        L15:
            r5 = 0
        L16:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L38
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L34
            r6 = 46
            if (r3 == r6) goto L30
            r6 = 58
            if (r3 == r6) goto L2c
        L2a:
            r3 = 0
            goto L3d
        L2c:
            if (r5 != r7) goto L2a
            r3 = 5
            goto L3d
        L30:
            if (r5 != r7) goto L2a
            r3 = 3
            goto L3d
        L34:
            if (r5 != r7) goto L2a
            r3 = 4
            goto L3d
        L38:
            r3 = 10
            if (r5 != r3) goto L2a
            r3 = 2
        L3d:
            if (r3 <= 0) goto L45
            java.util.Collection r0 = updateStateListForPair(r0, r2, r3)
            r2 = r4
            goto L49
        L45:
            java.util.Collection r0 = r8.updateStateListForChar(r0, r2)
        L49:
            int r2 = r2 + 1
            goto L8
        L4c:
            com.google.zxing.aztec.encoder.HighLevelEncoder$1 r1 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.google.zxing.aztec.encoder.State r0 = (com.google.zxing.aztec.encoder.State) r0
            byte[] r1 = r8.text
            com.google.zxing.common.BitArray r0 = r0.toBitArray(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.HighLevelEncoder.encode():com.google.zxing.common.BitArray");
    }
}
