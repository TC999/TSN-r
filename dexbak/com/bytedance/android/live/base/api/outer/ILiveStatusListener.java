package com.bytedance.android.live.base.api.outer;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ILiveStatusListener {
    void onError(String str);

    void onFirstFrame();

    void onLiveStatusChange(boolean z);

    void onPrepare();

    void onRoomInvalid();

    void onVideoSizeChanged(int i, int i2);
}
