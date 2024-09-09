package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import com.bykv.vk.component.ttvideo.player.MediaTransport;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeMediaTransport extends MediaTransport {
    @CalledByNative
    private static boolean isNativeMediaTransport(MediaTransport mediaTransport) {
        return mediaTransport instanceof NativeMediaTransport;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaTransport
    protected void sendPacket(MediaTransport.MediaPacket mediaPacket) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
