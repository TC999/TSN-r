package com.mbridge.msdk.foundation.tools;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: com.mbridge.msdk.foundation.tools.al */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ViewUtil {
    /* renamed from: a */
    public static void m21933a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
