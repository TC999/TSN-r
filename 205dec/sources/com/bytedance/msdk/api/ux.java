package com.bytedance.msdk.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    public static int c(Context context, float f4) {
        if (context == null) {
            return 0;
        }
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int w(Context context, float f4) {
        if (context == null) {
            return 0;
        }
        float f5 = context.getResources().getDisplayMetrics().density;
        if (f5 <= 0.0f) {
            f5 = 1.0f;
        }
        return (int) ((f4 / f5) + 0.5f);
    }

    public static void c(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
