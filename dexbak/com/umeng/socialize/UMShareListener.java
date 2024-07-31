package com.umeng.socialize;

import com.umeng.socialize.bean.SHARE_MEDIA;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface UMShareListener {
    void onCancel(SHARE_MEDIA share_media);

    void onError(SHARE_MEDIA share_media, Throwable th);

    void onResult(SHARE_MEDIA share_media);

    void onStart(SHARE_MEDIA share_media);
}
