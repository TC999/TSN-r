package com.bytedance.sdk.openadsdk;

import android.content.Context;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TTDislikeController {
    @Deprecated
    void onDislikeEvent(Context context, boolean z);

    void onDislikeSelected(FilterWord filterWord);

    @Deprecated
    void openWebPage(Context context, boolean z);
}
