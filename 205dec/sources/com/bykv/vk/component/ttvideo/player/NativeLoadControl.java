package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeLoadControl extends LoadControl {
    @CalledByNative
    private static boolean isNativeLoadControl(LoadControl loadControl) {
        return loadControl instanceof NativeLoadControl;
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onCodecStackSelected(int i4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onFilterStackSelected(int i4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onTrackSelected(int i4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected boolean shouldStartPlayback(long j4, float f4, boolean z3) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
