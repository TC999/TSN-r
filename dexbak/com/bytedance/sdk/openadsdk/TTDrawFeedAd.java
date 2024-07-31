package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TTDrawFeedAd extends TTFeedAd {

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    void setCanInterruptVideoPlay(boolean z);

    void setDrawVideoListener(DrawVideoListener drawVideoListener);

    void setPauseIcon(Bitmap bitmap, int i);
}
