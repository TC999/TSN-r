package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import java.nio.ByteBuffer;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeAudioProcessor extends AudioProcessor {
    protected long mNativeWrapper = 0;

    @CalledByNative
    private long getNativeWrapper() {
        return this.mNativeWrapper;
    }

    @CalledByNative
    public static boolean isNativeAudioProcessor(AudioProcessor audioProcessor) {
        return audioProcessor instanceof NativeAudioProcessor;
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioClose() {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioOpen(int i4, int i5, int i6, int i7) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioProcess(ByteBuffer[] byteBufferArr, int i4, long j4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioRelease(int i4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @CalledByNative
    public void setNativeWrapper(long j4) {
        this.mNativeWrapper = j4;
    }
}
