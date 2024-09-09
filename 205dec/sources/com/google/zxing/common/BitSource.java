package com.google.zxing.common;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i4) {
        if (i4 > 0 && i4 <= 32 && i4 <= available()) {
            int i5 = this.bitOffset;
            int i6 = 0;
            if (i5 > 0) {
                int i7 = 8 - i5;
                int i8 = i4 < i7 ? i4 : i7;
                int i9 = i7 - i8;
                byte[] bArr = this.bytes;
                int i10 = this.byteOffset;
                int i11 = (((255 >> (8 - i8)) << i9) & bArr[i10]) >> i9;
                i4 -= i8;
                int i12 = i5 + i8;
                this.bitOffset = i12;
                if (i12 == 8) {
                    this.bitOffset = 0;
                    this.byteOffset = i10 + 1;
                }
                i6 = i11;
            }
            if (i4 > 0) {
                while (i4 >= 8) {
                    int i13 = i6 << 8;
                    byte[] bArr2 = this.bytes;
                    int i14 = this.byteOffset;
                    i6 = (bArr2[i14] & 255) | i13;
                    this.byteOffset = i14 + 1;
                    i4 -= 8;
                }
                if (i4 > 0) {
                    int i15 = 8 - i4;
                    int i16 = (i6 << i4) | ((((255 >> i15) << i15) & this.bytes[this.byteOffset]) >> i15);
                    this.bitOffset += i4;
                    return i16;
                }
                return i6;
            }
            return i6;
        }
        throw new IllegalArgumentException(String.valueOf(i4));
    }
}
