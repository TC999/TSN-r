package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.EmptyCallback;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ILiveOuterPreviewCoverView {
    void cancelAutoEnterGuide(boolean z3);

    View getView();

    void onShow();

    void release();

    void setCustomBottomView(View view);

    void setOnDislikeCallback(EmptyCallback emptyCallback);

    void stream(String str);
}
