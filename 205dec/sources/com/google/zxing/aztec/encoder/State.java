package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i4, int i5, int i6) {
        this.token = token;
        this.mode = i4;
        this.binaryShiftByteCount = i5;
        this.bitCount = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State addBinaryShiftChar(int i4) {
        Token token = this.token;
        int i5 = this.mode;
        int i6 = this.bitCount;
        if (i5 == 4 || i5 == 2) {
            int i7 = HighLevelEncoder.LATCH_TABLE[i5][0];
            int i8 = 65535 & i7;
            int i9 = i7 >> 16;
            token = token.add(i8, i9);
            i6 += i9;
            i5 = 0;
        }
        int i10 = this.binaryShiftByteCount;
        State state = new State(token, i5, i10 + 1, i6 + ((i10 == 0 || i10 == 31) ? 18 : i10 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i4 + 1) : state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State endBinaryShift(int i4) {
        int i5 = this.binaryShiftByteCount;
        return i5 == 0 ? this : new State(this.token.addBinaryShift(i4 - i5, i5), this.mode, 0, this.bitCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBitCount() {
        return this.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMode() {
        return this.mode;
    }

    Token getToken() {
        return this.token;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBetterThanOrEqualTo(State state) {
        int i4;
        int i5 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i6 = state.binaryShiftByteCount;
        if (i6 > 0 && ((i4 = this.binaryShiftByteCount) == 0 || i4 > i6)) {
            i5 += 10;
        }
        return i5 <= state.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State latchAndAppend(int i4, int i5) {
        int i6 = this.bitCount;
        Token token = this.token;
        int i7 = this.mode;
        if (i4 != i7) {
            int i8 = HighLevelEncoder.LATCH_TABLE[i7][i4];
            int i9 = 65535 & i8;
            int i10 = i8 >> 16;
            token = token.add(i9, i10);
            i6 += i10;
        }
        int i11 = i4 == 2 ? 4 : 5;
        return new State(token.add(i5, i11), i4, 0, i6 + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State shiftAndAppend(int i4, int i5) {
        Token token = this.token;
        int i6 = this.mode;
        int i7 = i6 == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[i6][i4], i7).add(i5, 5), this.mode, 0, this.bitCount + i7 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitArray toBitArray(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList();
        for (Token token = endBinaryShift(bArr.length).token; token != null; token = token.getPrevious()) {
            linkedList.addFirst(token);
        }
        BitArray bitArray = new BitArray();
        for (Token token2 : linkedList) {
            token2.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}
