package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeSubInfo extends SubInfo {
    @CalledByNative
    private static boolean isNativeSubInfo(SubInfo subInfo) {
        return subInfo instanceof NativeSubInfo;
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubInfoCallback(int i4, int i5, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubInfoCallback2(int i4, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubLoadFinished(int i4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubSwitchCompleted(int i4, int i5) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
