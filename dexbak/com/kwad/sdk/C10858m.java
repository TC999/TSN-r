package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.sdk.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10858m {
    private static boolean all;
    private static long alm;

    /* renamed from: a */
    public static void m24624a(Throwable th, String str) {
        try {
            C10848l.m24644a(C11160a.aTR, str);
            C8571a.reportSdkCaughtException(th);
        } catch (Throwable unused) {
        }
        m24622av(ServiceProvider.m24363KO());
        C10331c.m26254d("SDKRevertHelper", "onInitError revert");
    }

    /* renamed from: au */
    public static void m24623au(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - alm;
        C10331c.m26254d("SDKRevertHelper", "onException revert time: " + elapsedRealtime);
        if (elapsedRealtime < 10000) {
            m24622av(context);
        }
    }

    /* renamed from: av */
    private static void m24622av(Context context) {
        m24620b(context, "curversion", "");
    }

    /* renamed from: aw */
    private static SdkConfig m24621aw(Context context) {
        SdkConfig sdkConfig;
        try {
            sdkConfig = SdkConfig.create(m24619c(context, "sdkconfig", ""));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            sdkConfig = null;
        }
        return sdkConfig == null ? new SdkConfig.Builder().build() : sdkConfig;
    }

    /* renamed from: b */
    private static void m24620b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).apply();
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    /* renamed from: c */
    private static String m24619c(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void checkInitSDK(Context context) {
        try {
            if (C10829k.m24699zd().m24700ys()) {
                return;
            }
            KsAdSDK.init(context, m24621aw(context));
        } catch (Throwable th) {
            C8571a.reportSdkCaughtException(th);
        }
    }

    /* renamed from: l */
    public static void m24618l(Throwable th) {
        m24624a(th, Log.getStackTraceString(th));
    }

    /* renamed from: zG */
    public static void m24617zG() {
        if (all) {
            return;
        }
        all = true;
        alm = SystemClock.elapsedRealtime();
    }
}
