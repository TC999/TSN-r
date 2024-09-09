package com.kwad.sdk.core.imageloader.core.assist;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i4, int i5) {
        this.width = i4;
        this.height = i5;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageSize scale(float f4) {
        return new ImageSize((int) (this.width * f4), (int) (this.height * f4));
    }

    public ImageSize scaleDown(int i4) {
        return new ImageSize(this.width / i4, this.height / i4);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.width);
        sb.append("x");
        sb.append(this.height);
        return sb.toString();
    }

    public ImageSize(int i4, int i5, int i6) {
        if (i6 % 180 == 0) {
            this.width = i4;
            this.height = i5;
            return;
        }
        this.width = i5;
        this.height = i4;
    }
}
