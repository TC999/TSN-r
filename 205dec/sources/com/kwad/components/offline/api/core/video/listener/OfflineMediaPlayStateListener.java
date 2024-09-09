package com.kwad.components.offline.api.core.video.listener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface OfflineMediaPlayStateListener {
    void onMediaPlayCompleted();

    void onMediaPlayError(int i4, int i5);

    void onMediaPlayPaused();

    void onMediaPlayProgress(long j4, long j5);

    void onMediaPlayStart();

    void onMediaPlaying();

    void onMediaPrepared();

    void onMediaPreparing();
}
