package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m {
    private static boolean all;
    private static long alm;

    /* renamed from: com.kwad.sdk.m$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 extends az {
        final /* synthetic */ long aml;

        AnonymousClass1(long j4) {
            this.aml = j4;
        }

        public final void doTask() {
            com.kwad.sdk.commercial.b.a("ad_client_apm_log", com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setLaunchIntervalTime(this.aml).setInitCount(m.An()).setInitStatus(0));
        }
    }

    /* renamed from: com.kwad.sdk.m$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass2 extends az {
        final /* synthetic */ long amm;

        AnonymousClass2(long j4) {
            this.amm = j4;
        }

        public final void doTask() {
            com.kwad.sdk.commercial.b.a("ad_client_apm_log", com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(this.amm).setInitCount(m.An()).setInitStatus(1));
        }
    }

    /* renamed from: com.kwad.sdk.m$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass3 extends az {
        final /* synthetic */ long amm;

        AnonymousClass3(long j4) {
            this.amm = j4;
        }

        public final void doTask() {
            com.kwad.sdk.commercial.b.a("ad_client_apm_log", com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(this.amm).setInitCount(m.An()).setInitStatus(3));
        }
    }

    /* renamed from: com.kwad.sdk.m$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass4 extends az {
        final /* synthetic */ long amm;

        AnonymousClass4(long j4) {
            this.amm = j4;
        }

        public final void doTask() {
            com.kwad.sdk.commercial.b.a("ad_client_apm_log", com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(this.amm).setInitCount(m.An()).setInitStatus(4));
        }
    }

    /* renamed from: com.kwad.sdk.m$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass5 extends az {
        final /* synthetic */ long amm;

        AnonymousClass5(long j4) {
            this.amm = j4;
        }

        public final void doTask() {
            com.kwad.sdk.commercial.b.a("ad_client_apm_log", com.kwai.adclient.kscommerciallogger.model.a.aUQ, new SDKInitMsg().setTotalDurationTime(this.amm).setInitCount(m.An()).setInitStatus(5));
        }
    }

    /* renamed from: com.kwad.sdk.m$6  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass6 extends az {
        final /* synthetic */ String JZ;
        final /* synthetic */ com.kwai.adclient.kscommerciallogger.model.d amn;

        AnonymousClass6(com.kwai.adclient.kscommerciallogger.model.d dVar, String str) {
            this.amn = dVar;
            this.JZ = str;
        }

        public final void doTask() {
            com.kwad.sdk.commercial.b.a("ad_client_error_log", this.amn, new SDKInitMsg().setInitCount(m.An()).setErrorReason(this.JZ).setInitStatus(2));
        }
    }

    public static void a(Throwable th, String str) {
        try {
            l.a(com.kwai.adclient.kscommerciallogger.model.a.aTR, str);
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        } catch (Throwable unused) {
        }
        av(ServiceProvider.KO());
        com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onInitError revert");
    }

    public static void au(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - alm;
        com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onException revert time: " + elapsedRealtime);
        if (elapsedRealtime < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            av(context);
        }
    }

    private static void av(Context context) {
        b(context, "curversion", "");
    }

    private static SdkConfig aw(Context context) {
        SdkConfig sdkConfig;
        try {
            sdkConfig = SdkConfig.create(c(context, "sdkconfig", ""));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            sdkConfig = null;
        }
        return sdkConfig == null ? new SdkConfig.Builder().build() : sdkConfig;
    }

    private static void b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    private static String c(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void checkInitSDK(Context context) {
        try {
            if (k.zd().ys()) {
                return;
            }
            KsAdSDK.init(context, aw(context));
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    public static void l(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }

    public static void zG() {
        if (all) {
            return;
        }
        all = true;
        alm = SystemClock.elapsedRealtime();
    }
}
