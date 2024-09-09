package com.kwad.sdk.api.core;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ViewUtil {
    public static int px2dip(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
