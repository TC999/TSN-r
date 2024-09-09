package com.qq.e.comm.plugin.dysi;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface IGDTVideoPlayer {
    public static final String KEY_VIDEO_PLAYER = "GDTVideoPlayer";
    public static final String METHOD_INIT = "onVideoViewInit";

    int currentTime();

    int duration();

    boolean isPlaying();

    void pause();

    void pauseAndLock();

    void play();

    void speed(double d4);

    void stop();

    void unlockAndPlay();
}
