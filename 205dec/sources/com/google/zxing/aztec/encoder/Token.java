package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class Token {
    static final Token EMPTY = new SimpleToken(null, 0, 0);
    private final Token previous;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token(Token token) {
        this.previous = token;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Token add(int i4, int i5) {
        return new SimpleToken(this, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Token addBinaryShift(int i4, int i5) {
        return new BinaryShiftToken(this, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void appendTo(BitArray bitArray, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Token getPrevious() {
        return this.previous;
    }
}
