package com.kwad.sdk;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.core.request.g;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.ay;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l {
    private static int alh;

    /* renamed from: com.kwad.sdk.l$10  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass10 extends com.kwad.sdk.f.b<JSONObject, Boolean> {
        AnonymousClass10() {
        }

        private static Boolean f(JSONObject jSONObject) {
            return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
        }

        public final /* synthetic */ Object apply(Object obj) {
            return f((JSONObject) obj);
        }
    }

    /* renamed from: com.kwad.sdk.l$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ KsInitCallback amg;
        final /* synthetic */ e amh;

        AnonymousClass4(KsInitCallback ksInitCallback, e eVar) {
            this.amg = ksInitCallback;
            this.amh = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                KsInitCallback ksInitCallback = this.amg;
                e eVar = this.amh;
                ksInitCallback.onFail(eVar.code, eVar.msg);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ KsInitCallback amg;

        AnonymousClass5(KsInitCallback ksInitCallback) {
            this.amg = ksInitCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                m.ae(SystemClock.elapsedRealtime() - l.a(l.zJ()));
                this.amg.onSuccess();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$6  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ KsInitCallback amg;
        final /* synthetic */ e amh;

        AnonymousClass6(KsInitCallback ksInitCallback, e eVar) {
            this.amg = ksInitCallback;
            this.amh = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                KsInitCallback ksInitCallback = this.amg;
                e eVar = this.amh;
                ksInitCallback.onFail(eVar.code, eVar.msg);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$7  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass7 implements Runnable {
        final /* synthetic */ KsInitCallback amg;

        AnonymousClass7(KsInitCallback ksInitCallback) {
            this.amg = ksInitCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.amg.onSuccess();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$8  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass8 implements g.b {
        final /* synthetic */ com.kwad.sdk.f.a ami;

        AnonymousClass8(com.kwad.sdk.f.a aVar) {
            this.ami = aVar;
        }

        @Override // com.kwad.components.core.request.g.a
        public final void d(@NonNull SdkConfigData sdkConfigData) {
            com.kwad.sdk.core.e.c.i("KSAdSDK", "onConfigRefresh()");
            try {
                l.a(l.this, sdkConfigData);
                com.kwad.sdk.f.a aVar = this.ami;
                if (aVar != null) {
                    aVar.accept(null);
                }
            } catch (Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }
        }

        public final void qW() {
            com.kwad.sdk.core.e.c.i("KSAdSDK", "onCacheLoaded()");
            l.b(l.this);
        }

        @Override // com.kwad.components.core.request.g.b
        public final void qX() {
            try {
                com.kwad.sdk.f.a aVar = this.ami;
                if (aVar != null) {
                    aVar.accept(null);
                }
            } catch (Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$9  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass9 implements com.kwad.sdk.collector.h {
        AnonymousClass9() {
        }

        @Override // com.kwad.sdk.collector.h
        public final void c(@NonNull JSONArray jSONArray) {
            com.kwad.components.core.o.a.qI().c(jSONArray);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class a {
        private static final l amj = new l((byte) 0);
    }

    public static void Y(long j4) {
        final long currentTimeMillis = j4 > 0 ? System.currentTimeMillis() - j4 : -1L;
        alh++;
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.l.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.b.a("ad_client_apm_log", com.kwai.adclient.kscommerciallogger.model.a.aTJ, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(l.alh).setInitStatus(0));
            }
        });
    }

    public static void Z(final long j4) {
        if (j4 > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            j4 = -1;
        }
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.l.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.b.a("ad_client_apm_log", com.kwai.adclient.kscommerciallogger.model.a.aTJ, new SDKInitMsg().setTotalDurationTime(j4).setInitCount(l.alh).setInitStatus(1));
            }
        });
    }

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.l.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.commercial.b.a("ad_client_error_log", com.kwai.adclient.kscommerciallogger.model.d.this, new SDKInitMsg().setInitCount(l.alh).setErrorReason(str).setInitStatus(2));
            }
        });
    }
}
