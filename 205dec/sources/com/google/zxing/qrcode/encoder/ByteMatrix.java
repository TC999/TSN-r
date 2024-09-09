package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i4, int i5) {
        this.bytes = (byte[][]) Array.newInstance(byte.class, i5, i4);
        this.width = i4;
        this.height = i5;
    }

    public void clear(byte b4) {
        for (int i4 = 0; i4 < this.height; i4++) {
            for (int i5 = 0; i5 < this.width; i5++) {
                this.bytes[i4][i5] = b4;
            }
        }
    }

    public byte get(int i4, int i5) {
        return this.bytes[i5][i4];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void set(int i4, int i5, byte b4) {
        this.bytes[i5][i4] = b4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i4 = 0; i4 < this.height; i4++) {
            for (int i5 = 0; i5 < this.width; i5++) {
                byte b4 = this.bytes[i4][i5];
                if (b4 == 0) {
                    sb.append(" 0");
                } else if (b4 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void set(int i4, int i5, int i6) {
        this.bytes[i5][i4] = (byte) i6;
    }

    public void set(int i4, int i5, boolean z3) {
        this.bytes[i5][i4] = z3 ? (byte) 1 : (byte) 0;
    }
}
