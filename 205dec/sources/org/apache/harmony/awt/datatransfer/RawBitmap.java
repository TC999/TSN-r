package org.apache.harmony.awt.datatransfer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class RawBitmap {
    public final int bMask;
    public final int bits;
    public final Object buffer;
    public final int gMask;
    public final int height;
    public final int rMask;
    public final int stride;
    public final int width;

    public RawBitmap(int i4, int i5, int i6, int i7, int i8, int i9, int i10, Object obj) {
        this.width = i4;
        this.height = i5;
        this.stride = i6;
        this.bits = i7;
        this.rMask = i8;
        this.gMask = i9;
        this.bMask = i10;
        this.buffer = obj;
    }

    public int[] getHeader() {
        return new int[]{this.width, this.height, this.stride, this.bits, this.rMask, this.gMask, this.bMask};
    }

    public RawBitmap(int[] iArr, Object obj) {
        this.width = iArr[0];
        this.height = iArr[1];
        this.stride = iArr[2];
        this.bits = iArr[3];
        this.rMask = iArr[4];
        this.gMask = iArr[5];
        this.bMask = iArr[6];
        this.buffer = obj;
    }
}
