package com.google.zxing;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private static final int THUMBNAIL_SCALE_FACTOR = 2;
    private final int dataHeight;
    private final int dataWidth;
    private final int left;

    /* renamed from: top  reason: collision with root package name */
    private final int f37339top;
    private final byte[] yuvData;

    public PlanarYUVLuminanceSource(byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, boolean z3) {
        super(i8, i9);
        if (i6 + i8 <= i4 && i7 + i9 <= i5) {
            this.yuvData = bArr;
            this.dataWidth = i4;
            this.dataHeight = i5;
            this.left = i6;
            this.f37339top = i7;
            if (z3) {
                reverseHorizontal(i8, i9);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    private void reverseHorizontal(int i4, int i5) {
        byte[] bArr = this.yuvData;
        int i6 = (this.f37339top * this.dataWidth) + this.left;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = (i4 / 2) + i6;
            int i9 = (i6 + i4) - 1;
            int i10 = i6;
            while (i10 < i8) {
                byte b4 = bArr[i10];
                bArr[i10] = bArr[i9];
                bArr[i9] = b4;
                i10++;
                i9--;
            }
            i7++;
            i6 += this.dataWidth;
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i4, int i5, int i6, int i7) {
        return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + i4, this.f37339top + i5, i6, i7, false);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i4 = this.dataWidth;
        if (width == i4 && height == this.dataHeight) {
            return this.yuvData;
        }
        int i5 = width * height;
        byte[] bArr = new byte[i5];
        int i6 = (this.f37339top * i4) + this.left;
        if (width == i4) {
            System.arraycopy(this.yuvData, i6, bArr, 0, i5);
            return bArr;
        }
        for (int i7 = 0; i7 < height; i7++) {
            System.arraycopy(this.yuvData, i6, bArr, i7 * width, width);
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
            System.arraycopy(this.yuvData, ((i4 + this.f37339top) * this.dataWidth) + this.left, bArr, 0, width);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i4);
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public int[] renderThumbnail() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] iArr = new int[width * height];
        byte[] bArr = this.yuvData;
        int i4 = (this.f37339top * this.dataWidth) + this.left;
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = i5 * width;
            for (int i7 = 0; i7 < width; i7++) {
                iArr[i6 + i7] = ((bArr[(i7 << 1) + i4] & 255) * 65793) | (-16777216);
            }
            i4 += this.dataWidth << 1;
        }
        return iArr;
    }
}
