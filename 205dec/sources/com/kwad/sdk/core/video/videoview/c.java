package com.kwad.sdk.core.video.videoview;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface c {
    boolean Gj();

    int getBufferPercentage();

    long getCurrentPosition();

    long getDuration();

    boolean isIdle();

    boolean isPaused();

    void pause();

    void release();

    void restart();

    void setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a aVar);

    void start();
}
