package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IStandalonePreviewView {
    View getView();

    void release();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z);

    void show();

    void stream();
}
