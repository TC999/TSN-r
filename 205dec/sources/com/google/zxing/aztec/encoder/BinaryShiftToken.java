package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class BinaryShiftToken extends Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinaryShiftToken(Token token, int i4, int i5) {
        super(token);
        this.binaryShiftStart = (short) i4;
        this.binaryShiftByteCount = (short) i5;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        int i4 = 0;
        while (true) {
            short s3 = this.binaryShiftByteCount;
            if (i4 >= s3) {
                return;
            }
            if (i4 == 0 || (i4 == 31 && s3 <= 62)) {
                bitArray.appendBits(31, 5);
                short s4 = this.binaryShiftByteCount;
                if (s4 > 62) {
                    bitArray.appendBits(s4 - 31, 16);
                } else if (i4 == 0) {
                    bitArray.appendBits(Math.min((int) s4, 31), 5);
                } else {
                    bitArray.appendBits(s4 - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + i4], 8);
            i4++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.binaryShiftStart);
        sb.append("::");
        sb.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        sb.append('>');
        return sb.toString();
    }
}
