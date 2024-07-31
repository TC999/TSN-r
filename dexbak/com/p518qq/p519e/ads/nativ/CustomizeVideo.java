package com.p518qq.p519e.ads.nativ;

/* renamed from: com.qq.e.ads.nativ.CustomizeVideo */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j, int i, int i2);

    void reportVideoPause(long j);

    void reportVideoPreload();

    void reportVideoResume(long j);

    void reportVideoStart();
}
