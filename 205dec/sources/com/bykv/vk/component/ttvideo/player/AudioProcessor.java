package com.bykv.vk.component.ttvideo.player;

import java.nio.ByteBuffer;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class AudioProcessor extends NativeObject {
    public static final int AV_PCM_FMT_DBL = 4;
    public static final int AV_PCM_FMT_DBLP = 9;
    public static final int AV_PCM_FMT_FLT = 3;
    public static final int AV_PCM_FMT_FLTP = 8;
    public static final int AV_PCM_FMT_NONE = -1;
    public static final int AV_PCM_FMT_S16 = 1;
    public static final int AV_PCM_FMT_S16P = 6;
    public static final int AV_PCM_FMT_S32 = 2;
    public static final int AV_PCM_FMT_S32P = 7;
    public static final int AV_PCM_FMT_U8 = 0;
    public static final int AV_PCM_FMT_U8P = 5;
    public static final int RELEASE_REASEON_OSPLAYER_CREATED = 1;
    public static final int RELEASE_REASEON_TTPLAYER_NORMAL_CALL = 2;

    @CalledByNative
    public abstract void audioClose();

    @CalledByNative
    public abstract void audioOpen(int i4, int i5, int i6, int i7);

    @CalledByNative
    public abstract void audioProcess(ByteBuffer[] byteBufferArr, int i4, long j4);

    @CalledByNative
    public abstract void audioRelease(int i4);
}
