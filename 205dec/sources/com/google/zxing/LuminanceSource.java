package com.google.zxing;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    /* JADX INFO: Access modifiers changed from: protected */
    public LuminanceSource(int i4, int i5) {
        this.width = i4;
        this.height = i5;
    }

    public LuminanceSource crop(int i4, int i5, int i6, int i7) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i4, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i4 = this.width;
        byte[] bArr = new byte[i4];
        StringBuilder sb = new StringBuilder(this.height * (i4 + 1));
        for (int i5 = 0; i5 < this.height; i5++) {
            bArr = getRow(i5, bArr);
            for (int i6 = 0; i6 < this.width; i6++) {
                int i7 = bArr[i6] & 255;
                sb.append(i7 < 64 ? '#' : i7 < 128 ? '+' : i7 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
