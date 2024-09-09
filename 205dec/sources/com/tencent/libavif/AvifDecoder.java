package com.tencent.libavif;

import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class AvifDecoder {
    private volatile long nDecoder;

    private AvifDecoder(long j4) {
        this.nDecoder = j4;
    }

    private void checkDecoder() {
        if (this.nDecoder == 0) {
            throw new IllegalStateException("Native Decoder already destroyed");
        }
    }

    private static native long createDecoderByteArray0(byte[] bArr, int i4, int i5);

    private static native long createDecoderByteBuffer0(ByteBuffer byteBuffer, int i4, int i5);

    private static native void destroy0(long j4);

    public static AvifDecoder fromByteArray(byte[] bArr) {
        return fromByteArray(bArr, 0, bArr.length);
    }

    public static AvifDecoder fromByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            if (!byteBuffer.isDirect()) {
                if (byteBuffer.hasArray()) {
                    return fromByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
            }
            long createDecoderByteBuffer0 = createDecoderByteBuffer0(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
            if (createDecoderByteBuffer0 == 0) {
                return null;
            }
            return new AvifDecoder(createDecoderByteBuffer0);
        }
        throw new IllegalArgumentException("buffer==null");
    }

    private static native long getCropedImage0(long j4, int i4, int i5, int i6, int i7);

    private static native int getDepth0(long j4);

    private static native String getDiag0(long j4);

    public static AvifFormat getFormat(byte[] bArr) {
        int format0 = getFormat0(bArr, 0, bArr.length);
        AvifFormat avifFormat = AvifFormat.FORMAT_INVAILD;
        switch (format0) {
            case 1:
                return AvifFormat.FORMAT_JPEG;
            case 2:
                return AvifFormat.FORMAT_GIF;
            case 3:
                return AvifFormat.FORMAT_PNG;
            case 4:
                return AvifFormat.FORMAT_BMP;
            case 5:
                return AvifFormat.FORMAT_WEBP;
            case 6:
                return AvifFormat.FORMAT_TIFF;
            case 7:
                return AvifFormat.FORMAT_HEVC;
            case 8:
                return AvifFormat.FORMAT_WXGF;
            case 9:
                return AvifFormat.FORMAT_SHARPP;
            case 10:
                return AvifFormat.FORMAT_HEIC;
            case 11:
                return AvifFormat.FORMAT_TPG;
            case 12:
                return AvifFormat.FORMAT_AVIF;
            case 13:
                return AvifFormat.FORMAT_AVIS;
            default:
                return avifFormat;
        }
    }

    private static native int getFormat0(byte[] bArr, int i4, int i5);

    private static native int getHeight0(long j4);

    private static native long getImage0(long j4);

    private static native int getImageCount0(long j4);

    private static native long getImageDuration0(long j4);

    private static native int getImageIndex0(long j4);

    private static native int getImageLimit0(long j4);

    private static native long getNthImageDuration0(long j4, int i4);

    private static native long getRectedImage0(long j4, int i4, int i5, int i6, int i7, int i8);

    private static native long getScaledImage0(long j4, int i4, int i5);

    private static native int getWidth0(long j4);

    private static native boolean hasAlpha0(long j4);

    public static boolean isAvif(byte[] bArr) {
        return getFormat0(bArr, 0, bArr.length) == 12;
    }

    public static boolean isAvis(byte[] bArr) {
        return getFormat0(bArr, 0, bArr.length) == 13;
    }

    private static native int nextImage0(long j4);

    private static native int nthImage0(long j4, int i4);

    private static native void reset0(long j4);

    private static native boolean scaleImage0(long j4, int i4, int i5);

    private static native void setMaxThread0(long j4, int i4);

    public void destroy() {
        synchronized (this) {
            if (this.nDecoder != 0) {
                destroy0(this.nDecoder);
                this.nDecoder = 0L;
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

    public AvifImage getCropedImage(int i4, int i5, int i6, int i7) {
        checkDecoder();
        return new AvifImage(getCropedImage0(this.nDecoder, i4, i5, i6, i7), getImageDuration0(this.nDecoder));
    }

    public int getDepth() {
        checkDecoder();
        return getDepth0(this.nDecoder);
    }

    public String getDiag() {
        checkDecoder();
        return getDiag0(this.nDecoder);
    }

    public int getHeight() {
        checkDecoder();
        return getHeight0(this.nDecoder);
    }

    public AvifImage getImage() {
        checkDecoder();
        return new AvifImage(getImage0(this.nDecoder), getImageDuration0(this.nDecoder));
    }

    public int getImageCount() {
        checkDecoder();
        return getImageCount0(this.nDecoder);
    }

    public long getImageDuration() {
        checkDecoder();
        return getImageDuration0(this.nDecoder);
    }

    public int getImageIndex() {
        checkDecoder();
        return getImageIndex0(this.nDecoder);
    }

    public long getNthImageDuration(int i4) {
        checkDecoder();
        return getNthImageDuration0(this.nDecoder, i4);
    }

    public AvifImage getRectedImage(int i4, int i5, int i6, int i7, int i8) {
        checkDecoder();
        return new AvifImage(getRectedImage0(this.nDecoder, i4, i5, i6, i7, i8), getImageDuration0(this.nDecoder));
    }

    public AvifImage getScaledImage(int i4, int i5) {
        checkDecoder();
        return new AvifImage(getScaledImage0(this.nDecoder, i4, i5), getImageDuration0(this.nDecoder));
    }

    public int getWidth() {
        checkDecoder();
        return getWidth0(this.nDecoder);
    }

    public boolean hasAlpha() {
        checkDecoder();
        return hasAlpha0(this.nDecoder);
    }

    public int nextImage() {
        checkDecoder();
        return nextImage0(this.nDecoder);
    }

    public int nthImage(int i4) {
        checkDecoder();
        return nthImage0(this.nDecoder, i4);
    }

    public void reset() {
        checkDecoder();
        reset0(this.nDecoder);
    }

    public boolean scaleImage(int i4, int i5) {
        checkDecoder();
        return scaleImage0(this.nDecoder, i4, i5);
    }

    public void setMaxThread(int i4) {
        checkDecoder();
        setMaxThread0(this.nDecoder, i4);
    }

    public static AvifDecoder fromByteArray(byte[] bArr, int i4, int i5) {
        long createDecoderByteArray0 = createDecoderByteArray0(bArr, i4, i5);
        if (createDecoderByteArray0 == 0) {
            return null;
        }
        return new AvifDecoder(createDecoderByteArray0);
    }
}
