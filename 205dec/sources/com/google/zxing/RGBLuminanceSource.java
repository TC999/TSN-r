package com.google.zxing;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;

    /* renamed from: top  reason: collision with root package name */
    private final int f37340top;

    public RGBLuminanceSource(int i4, int i5, int[] iArr) {
        super(i4, i5);
        this.dataWidth = i4;
        this.dataHeight = i5;
        this.left = 0;
        this.f37340top = 0;
        int i6 = i4 * i5;
        this.luminances = new byte[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = iArr[i7];
            this.luminances[i7] = (byte) (((((i8 >> 16) & 255) + ((i8 >> 7) & 510)) + (i8 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i4, int i5, int i6, int i7) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i4, this.f37340top + i5, i6, i7);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i4 = this.dataWidth;
        if (width == i4 && height == this.dataHeight) {
            return this.luminances;
        }
        int i5 = width * height;
        byte[] bArr = new byte[i5];
        int i6 = (this.f37340top * i4) + this.left;
        if (width == i4) {
            System.arraycopy(this.luminances, i6, bArr, 0, i5);
            return bArr;
        }
        for (int i7 = 0; i7 < height; i7++) {
            System.arraycopy(this.luminances, i6, bArr, i7 * width, width);
            i6 += this.dataWidth;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i4, byte[] bArr) {
        if (i4 >= 0 && i4 < getHeight()) {
            int width = getWidth();
            if (bArr == null || bArr.length < width) {
                bArr = new byte[width];
            }
            System.arraycopy(this.luminances, ((i4 + this.f37340top) * this.dataWidth) + this.left, bArr, 0, width);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i4);
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    private RGBLuminanceSource(byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i8, i9);
        if (i8 + i6 <= i4 && i9 + i7 <= i5) {
            this.luminances = bArr;
            this.dataWidth = i4;
            this.dataHeight = i5;
            this.left = i6;
            this.f37340top = i7;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
