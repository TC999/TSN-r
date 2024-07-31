package com.kwad.components.offline.api.core.adlive.listener;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
