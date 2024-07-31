package com.kwad.components.p208ad.splashscreen.p284f;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.splashscreen.f.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8486c {
    /* renamed from: a */
    public static void m30631a(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = C10751a.m24924a(view.getContext(), 16.0f);
            marginLayoutParams.leftMargin = C10751a.m24924a(view.getContext(), 16.0f);
        }
    }

    /* renamed from: z */
    public static boolean m30630z(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.skipButtonPosition == 0;
    }

    /* renamed from: a */
    public static boolean m30632a(Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int m24924a = C10751a.m24924a(context, 10.0f);
        return Math.abs(i - i3) <= m24924a && Math.abs(i2 - i4) <= m24924a;
    }
}
