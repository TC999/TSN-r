package org.apache.harmony.awt.datatransfer;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RawBitmap {
    public final int bMask;
    public final int bits;
    public final Object buffer;
    public final int gMask;
    public final int height;
    public final int rMask;
    public final int stride;
    public final int width;

    public RawBitmap(int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        this.width = i;
        this.height = i2;
        this.stride = i3;
        this.bits = i4;
        this.rMask = i5;
        this.gMask = i6;
        this.bMask = i7;
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
