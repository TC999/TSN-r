package com.tencent.libavif;

import android.graphics.Bitmap;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class AvifImage {
    private long duration;
    private volatile long nImage;

    public AvifImage(long j4, long j5) {
        this.nImage = j4;
        this.duration = j5;
    }

    private static native int convertToNV21Data0(long j4, byte[] bArr);

    private static native void destroy0(long j4);

    private static native void getBitmap0(long j4, Bitmap bitmap, boolean z3);

    private static native int getDepth0(long j4);

    private static native int getHeight0(long j4);

    private static native int getWidth0(long j4);

    private static native int getYuvFormat0(long j4);

    private static native int getYuvRange0(long j4);

    private static native boolean hasAlpha0(long j4);

    public byte[] convertToNV21Data() {
        byte[] bArr = new byte[(getWidth() * getHeight()) + (((getWidth() + 1) / 2) * ((getHeight() + 1) / 2) * 2)];
        convertToNV21Data0(this.nImage, bArr);
        return bArr;
    }

    public void destroy() {
        synchronized (this) {
            if (this.nImage != 0) {
                destroy0(this.nImage);
                this.nImage = 0L;
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            destroy();
        } finally {
            super.finalize();
        }
    }

    public Bitmap getBitmap(boolean z3) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        getBitmap0(this.nImage, createBitmap, z3);
        return createBitmap;
    }

    public int getDepth() {
        return getDepth0(this.nImage);
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return getHeight0(this.nImage);
    }

    public int getWidth() {
        return getWidth0(this.nImage);
    }

    public int getYuvFormat() {
        return getYuvFormat0(this.nImage);
    }

    public boolean hasAlpha() {
        return hasAlpha0(this.nImage);
    }

    public Bitmap getBitmap(Bitmap bitmap, boolean z3) {
        getBitmap0(this.nImage, bitmap, z3);
        return bitmap;
    }
}
