package com.bykv.vk.component.ttvideo.player;

import java.nio.ByteBuffer;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class MediaTransport extends NativeObject {
    public static final int FILTER_AUDIO = 2;
    public static final int FILTER_VIDEO = 1;

    @Keep
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class MediaPacket {
        public static final int CODEC_ID_AAC = 2;
        public static final int CODEC_ID_BYTE_VC1 = 1;
        public static final int CODEC_ID_H264 = 0;
        public static final int FLAG_CONFIG_FRAME = 1;
        public static final int FLAG_IS_DECODED_ONLY = 3;
        public static final int FLAG_KEY_FRAME = 2;
        public ByteBuffer mBuffer;
        public int mCodecId;
        public int mFlags;
        public boolean mIsAccessUnit;
        public boolean mIsVideo;
        public int mOffset;
        public long mPresentationTimeMs;
        public int mSize;

        @CalledByNative("MediaPacket")
        public void set(ByteBuffer byteBuffer, boolean z3, boolean z4, int i4, int i5, long j4, int i6, int i7) {
            this.mBuffer = byteBuffer;
            this.mOffset = i4;
            this.mSize = i5;
            this.mPresentationTimeMs = j4;
            this.mFlags = i6;
            this.mIsVideo = z3;
            this.mCodecId = i7;
            this.mIsAccessUnit = z4;
        }
    }

    private native void nativeSetFilterType(int i4);

    @CalledByNative
    protected abstract void sendPacket(MediaPacket mediaPacket);

    public void setFilterType(int i4) {
        nativeSetFilterType(i4);
    }
}
