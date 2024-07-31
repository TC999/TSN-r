package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.sdk.utils.bq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11067bq {
    /* renamed from: a */
    public static boolean m23853a(View view, int i, boolean z) {
        return view != null && m23852b(view, i, z) && m23851cs(view.getContext());
    }

    /* renamed from: b */
    private static boolean m23852b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity m24559dn = C10887l.m24559dn(view.getContext());
        if ((m24559dn == null || !m24559dn.isFinishing()) && view.isShown() && view.getVisibility() == 0 && (!z || view.hasWindowFocus())) {
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                long height = rect.height() * rect.width();
                long height2 = view.getHeight() * view.getWidth();
                if (height2 > 0 && height * 100 >= i * height2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: cs */
    private static boolean m23851cs(Context context) {
        return C11022ao.m24092Ma().m24091cs(context);
    }

    /* renamed from: o */
    public static boolean m23850o(View view, int i) {
        return view != null && m23852b(view, i, true) && view.hasWindowFocus() && m23851cs(view.getContext());
    }
}
