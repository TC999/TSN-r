package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.utils.Error;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface VideoEngineCallback {
    public static final int AFTER_FIRST_FRAME = 1;
    public static final int BEFORE_FIRST_FRAME = 0;
    public static final int BUFFERING_TYPE_DECODER = 1;
    public static final int BUFFERING_TYPE_NET = 0;

    void onBufferEnd(int i4);

    void onBufferStart(int i4, int i5, int i6);

    void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i4);

    void onCompletion(TTVideoEngine tTVideoEngine);

    void onError(Error error);

    void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i4);

    void onMDLHitCache(String str, long j4);

    void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i4);

    void onPrepare(TTVideoEngine tTVideoEngine);

    void onPrepared(TTVideoEngine tTVideoEngine);

    void onRenderSeekComplete(int i4);

    void onRenderStart(TTVideoEngine tTVideoEngine);

    void onRetry(int i4);

    void onUseMDLCacheEnd();

    void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i4, int i5);
}
