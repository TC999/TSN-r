package com.kwad.components.offline.api.core.adlive.listener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z3);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j4);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
