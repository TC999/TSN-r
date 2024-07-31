package com.bytedance.msdk.api.nativeAd;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTVideoListener extends ITTAdatperCallback {
    void onVideoCompleted();

    void onVideoError(AdError adError);

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
