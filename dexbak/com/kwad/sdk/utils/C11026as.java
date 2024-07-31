package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.stub.StubApp;

/* renamed from: com.kwad.sdk.utils.as */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11026as {
    /* renamed from: at */
    public static int m24082at(Context context, String str) {
        Resources m24081cu = m24081cu(context);
        if (m24081cu == null) {
            m24081cu = context.getResources();
        }
        return m24081cu.getIdentifier(str, "drawable", context.getPackageName());
    }

    /* renamed from: cu */
    public static Resources m24081cu(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.m24363KO().getResources();
    }

    public static int getAppIconId(Context context) {
        int i;
        try {
            i = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i = 0;
        }
        return i <= 0 ? m24082at(context, "ksad_notification_small_icon") : i;
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    private static String getPackageName(Context context) {
        return ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp() ? "com.kwad.sdk" : context.getPackageName();
    }
}
