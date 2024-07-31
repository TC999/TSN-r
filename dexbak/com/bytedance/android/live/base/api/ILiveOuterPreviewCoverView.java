package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.EmptyCallback;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ILiveOuterPreviewCoverView {
    void cancelAutoEnterGuide(boolean z);

    View getView();

    void onShow();

    void release();

    void setCustomBottomView(View view);

    void setOnDislikeCallback(EmptyCallback emptyCallback);

    void stream(String str);
}
