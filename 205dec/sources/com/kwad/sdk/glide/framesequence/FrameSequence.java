package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FrameSequence implements Serializable {
    private static final AtomicBoolean ISLOADED;
    private int mDefaultLoopCount;
    private int mFrameCount;
    private int mHeight;
    private long mNativeFrameSequence;
    private boolean mOpaque;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class State implements Serializable {
        private long mNativeState;

        public State(long j4) {
            this.mNativeState = j4;
        }

        public void destroy() {
            long j4 = this.mNativeState;
            if (j4 != 0) {
                FrameSequence.nativeDestroyState(j4);
                this.mNativeState = 0L;
            }
        }

        public long getFrame(int i4, Bitmap bitmap, int i5) {
            if (bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                long j4 = this.mNativeState;
                if (j4 != 0) {
                    return FrameSequence.nativeGetFrame(j4, i4, bitmap, i5);
                }
                throw new IllegalStateException("attempted to draw destroyed FrameSequenceState");
            }
            throw new IllegalArgumentException("Bitmap passed must be non-null and ARGB_8888");
        }
    }

    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ISLOADED = atomicBoolean;
        try {
            System.loadLibrary("framesequencev2");
            atomicBoolean.set(true);
        } catch (Throwable unused) {
            ISLOADED.set(false);
        }
    }

    public FrameSequence() {
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr) {
        if (ISLOADED.get()) {
            return decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Nullable
    public static FrameSequence decodeByteBuffer(ByteBuffer byteBuffer) {
        if (ISLOADED.get()) {
            if (byteBuffer != null) {
                if (!byteBuffer.isDirect()) {
                    if (byteBuffer.hasArray()) {
                        return decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                    }
                    throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
                }
                return nativeDecodeByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
            }
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Nullable
    public static FrameSequence decodeStream(InputStream inputStream) {
        if (ISLOADED.get()) {
            if (inputStream != null) {
                return nativeDecodeStream(inputStream, new byte[16384]);
            }
            throw new IllegalArgumentException();
        }
        return null;
    }

    public static boolean isEnable() {
        return ISLOADED.get();
    }

    private static native long nativeCreateState(long j4);

    private static native FrameSequence nativeDecodeByteArray(byte[] bArr, int i4, int i5);

    private static native FrameSequence nativeDecodeByteBuffer(ByteBuffer byteBuffer, int i4, int i5);

    private static native FrameSequence nativeDecodeStream(InputStream inputStream, byte[] bArr);

    private static native void nativeDestroyFrameSequence(long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroyState(long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeGetFrame(long j4, int i4, Bitmap bitmap, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public State createState() {
        long j4 = this.mNativeFrameSequence;
        if (j4 != 0) {
            long nativeCreateState = nativeCreateState(j4);
            if (nativeCreateState == 0) {
                return null;
            }
            return new State(nativeCreateState);
        }
        throw new IllegalStateException("attempted to use incorrectly built FrameSequence");
    }

    public void destroy() {
        long j4 = this.mNativeFrameSequence;
        if (j4 != 0) {
            nativeDestroyFrameSequence(j4);
        }
    }

    public int getDefaultLoopCount() {
        return this.mDefaultLoopCount;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }

    private FrameSequence(long j4, int i4, int i5, boolean z3, int i6, int i7) {
        this.mNativeFrameSequence = j4;
        this.mWidth = i4;
        this.mHeight = i5;
        this.mOpaque = z3;
        this.mFrameCount = i6;
        this.mDefaultLoopCount = i7;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr, int i4, int i5) {
        if (ISLOADED.get()) {
            if (bArr != null) {
                if (i4 >= 0 && i5 >= 0 && i4 + i5 <= bArr.length) {
                    return nativeDecodeByteArray(bArr, i4, i5);
                }
                throw new IllegalArgumentException("invalid offset/length parameters");
            }
            throw new IllegalArgumentException();
        }
        return null;
    }
}
