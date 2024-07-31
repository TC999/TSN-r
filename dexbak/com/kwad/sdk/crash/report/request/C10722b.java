package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.report.request.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10722b {

    /* renamed from: com.kwad.sdk.crash.report.request.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10726a {
        void onError(int i, String str);

        void onSuccess();
    }

    /* renamed from: a */
    public static void m25027a(final List<ReportEvent> list, @Nullable final CountDownLatch countDownLatch, final InterfaceC10726a interfaceC10726a) {
        C10331c.m26254d("AdExceptionCollector", "CrashReportRequestManager request");
        if (list == null || list.size() <= 0) {
            return;
        }
        new AbstractC10436l<C10721a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: HZ */
            public C10721a createRequest() {
                return new C10721a(list) { // from class: com.kwad.sdk.crash.report.request.b.1.1
                    @Override // com.kwad.sdk.core.network.AbstractC10410b
                    public final boolean enableCrashReport() {
                        return false;
                    }
                };
            }

            @NonNull
            /* renamed from: fD */
            private static CrashReportResult m25025fD(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CrashReportResult crashReportResult = new CrashReportResult();
                crashReportResult.parseJson(jSONObject);
                return crashReportResult;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            public final boolean enableCrashReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ CrashReportResult parseData(String str) {
                return m25025fD(str);
            }
        }.request(new AbstractC10439o<C10721a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
            /* renamed from: Ia */
            private void m25024Ia() {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                InterfaceC10726a interfaceC10726a2 = interfaceC10726a;
                if (interfaceC10726a2 != null) {
                    interfaceC10726a2.onSuccess();
                }
            }

            /* renamed from: s */
            private void m25023s(int i, String str) {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                InterfaceC10726a interfaceC10726a2 = interfaceC10726a;
                if (interfaceC10726a2 != null) {
                    interfaceC10726a2.onError(i, str);
                }
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
                m25023s(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m25024Ia();
            }
        });
    }

    /* renamed from: a */
    public static void m25028a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch) {
        m25027a(list, countDownLatch, null);
    }
}
