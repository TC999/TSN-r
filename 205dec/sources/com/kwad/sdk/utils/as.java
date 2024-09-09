package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class as {
    public static int at(Context context, String str) {
        Resources cu = cu(context);
        if (cu == null) {
            cu = context.getResources();
        }
        return cu.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources cu(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.KO().getResources();
    }

    public static int getAppIconId(Context context) {
        int i4;
        try {
            i4 = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i4 = 0;
        }
        return i4 <= 0 ? at(context, "ksad_notification_small_icon") : i4;
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp() ? "com.kwad.sdk" : context.getPackageName();
    }
}
