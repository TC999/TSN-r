package com.bykv.vk.component.ttvideo.player;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeObject {
    protected long mNativeObj = 0;

    @CalledByNative
    private long getNativeObj() {
        return this.mNativeObj;
    }

    private native void nativeRelease(long j4);

    protected void finalize() throws Throwable {
    }

    public synchronized void release() {
        long j4 = this.mNativeObj;
        if (j4 != 0) {
            nativeRelease(j4);
            this.mNativeObj = 0L;
        }
    }

    protected void setNativeObj(long j4) {
        this.mNativeObj = j4;
    }
}
