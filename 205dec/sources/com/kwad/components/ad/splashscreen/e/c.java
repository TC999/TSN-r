package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class c {
    public static void a(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i5 >= 0) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), i5);
            }
            marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 16.0f);
        }
    }

    public static boolean z(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.skipButtonPosition == 0;
    }

    public static boolean a(Context context, int i4, int i5) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i6 = displayMetrics.widthPixels;
        int i7 = displayMetrics.heightPixels;
        int a4 = com.kwad.sdk.c.a.a.a(context, 10.0f);
        return Math.abs(i4 - i6) <= a4 && Math.abs(i5 - i7) <= a4;
    }
}
