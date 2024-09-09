package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class SimpleToken extends Token {
    private final short bitCount;
    private final short value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleToken(Token token, int i4, int i5) {
        super(token);
        this.value = (short) i4;
        this.bitCount = (short) i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public String toString() {
        short s3 = this.value;
        short s4 = this.bitCount;
        int i4 = (s3 & ((1 << s4) - 1)) | (1 << s4);
        return "<" + Integer.toBinaryString(i4 | (1 << this.bitCount)).substring(1) + '>';
    }
}
