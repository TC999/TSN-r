package com.bytedance.msdk.api.fullVideo;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTFullVideoAdLoadCallback {
    void onFullVideoAdLoad();

    void onFullVideoCached();

    void onFullVideoLoadFail(AdError adError);
}
