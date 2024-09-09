package com.bykv.vk.component.ttvideo.player;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class PlaybackParams {
    protected static final int DEFAULT_VALUE = -1;
    private int mDescribeContents = -1;
    private int mAudioFallbackMode = -1;
    private float mPitch = -1.0f;
    private float mSpeed = -1.0f;

    public PlaybackParams allowDefaults() {
        return this;
    }

    public int describeContents() {
        return this.mDescribeContents;
    }

    public int getAudioFallbackMode() {
        return this.mAudioFallbackMode;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public PlaybackParams setAudioFallbackMode(int i4) {
        this.mAudioFallbackMode = i4;
        return this;
    }

    public PlaybackParams setPitch(float f4) {
        this.mPitch = f4;
        return this;
    }

    public PlaybackParams setSpeed(float f4) {
        this.mSpeed = f4;
        return this;
    }
}
