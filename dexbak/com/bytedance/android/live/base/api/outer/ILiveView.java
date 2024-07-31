package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ILiveView {
    View getView();

    void onDislike();

    void openLive();

    void release();

    void reportShow();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z);

    void show();

    void stream();
}
