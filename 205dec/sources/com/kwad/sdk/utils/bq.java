package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bq {
    public static boolean a(View view, int i4, boolean z3) {
        return view != null && b(view, i4, z3) && cs(view.getContext());
    }

    private static boolean b(View view, int i4, boolean z3) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity dn = com.kwad.sdk.n.l.dn(view.getContext());
        if ((dn == null || !dn.isFinishing()) && view.isShown() && view.getVisibility() == 0 && (!z3 || view.hasWindowFocus())) {
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                long height = rect.height() * rect.width();
                long height2 = view.getHeight() * view.getWidth();
                if (height2 > 0 && height * 100 >= i4 * height2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean cs(Context context) {
        return ao.Ma().cs(context);
    }

    public static boolean o(View view, int i4) {
        return view != null && b(view, i4, true) && view.hasWindowFocus() && cs(view.getContext());
    }
}
