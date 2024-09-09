package cn.jiguang.api;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface JAnalyticsAction {
    void dispatchPause(Context context);

    void dispatchResume(Context context);

    void dispatchStatus(Context context, String str);
}
