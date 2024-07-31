package com.p518qq.p519e.comm.p520pi;

import java.util.Map;

/* renamed from: com.qq.e.comm.pi.AdData */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface AdData {

    /* renamed from: com.qq.e.comm.pi.AdData$VideoPlayer */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    String getDesc();

    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    <T> T getProperty(Class<T> cls);

    String getProperty(String str);

    String getTitle();

    int getVideoDuration();

    void setECPMLevel(String str);
}
