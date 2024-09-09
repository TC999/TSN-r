package com.qq.e.ads.nativ;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j4, int i4, int i5);

    void reportVideoPause(long j4);

    void reportVideoPreload();

    void reportVideoResume(long j4);

    void reportVideoStart();
}
