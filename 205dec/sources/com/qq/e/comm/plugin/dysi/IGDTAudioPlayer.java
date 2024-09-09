package com.qq.e.comm.plugin.dysi;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface IGDTAudioPlayer {
    int currentTime();

    int duration();

    void free();

    int isPlaying();

    void pause();

    void play();

    void prepareAudioPlayer(String str, String str2);

    void setNumberOfLoops(int i4);

    void setVolume(double d4);

    void stop();
}
