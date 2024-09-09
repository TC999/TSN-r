package com.bykv.vk.component.ttvideo.player;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class LoadControl extends NativeObject {
    @CalledByNative
    protected abstract int onCodecStackSelected(int i4);

    @CalledByNative
    protected abstract int onFilterStackSelected(int i4);

    @CalledByNative
    protected abstract int onTrackSelected(int i4);

    @CalledByNative
    protected abstract boolean shouldStartPlayback(long j4, float f4, boolean z3);
}
