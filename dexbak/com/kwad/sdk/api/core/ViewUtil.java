package com.kwad.sdk.api.core;

import android.content.Context;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ViewUtil {
    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
