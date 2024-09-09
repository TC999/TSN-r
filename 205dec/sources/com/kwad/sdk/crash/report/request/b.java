package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void onError(int i4, String str);

        void onSuccess();
    }

    public static void a(final List<ReportEvent> list, @Nullable final CountDownLatch countDownLatch, final a aVar) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "CrashReportRequestManager request");
        if (list == null || list.size() <= 0) {
            return;
        }
        new l<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: HZ */
            public com.kwad.sdk.crash.report.request.a createRequest() {
                return new com.kwad.sdk.crash.report.request.a(list) { // from class: com.kwad.sdk.crash.report.request.b.1.1
                    @Override // com.kwad.sdk.core.network.b
                    public final boolean enableCrashReport() {
                        return false;
                    }
                };
            }

            @NonNull
            private static CrashReportResult fD(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CrashReportResult crashReportResult = new CrashReportResult();
                crashReportResult.parseJson(jSONObject);
                return crashReportResult;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableCrashReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ CrashReportResult parseData(String str) {
                return fD(str);
            }
        }.request(new o<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
            private void Ia() {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            private void s(int i4, String str) {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(i4, str);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i4, String str) {
                s(i4, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                Ia();
            }
        });
    }

    public static void a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch) {
        a(list, countDownLatch, null);
    }
}
