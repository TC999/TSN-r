package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.t;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static C0686a aoK;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* renamed from: com.kwad.sdk.commercial.j.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0686a extends com.kwad.sdk.core.response.a.a {
        public List<String> aoL;
    }

    private static C0686a AU() {
        String yW = ((h) ServiceProvider.get(h.class)).yW();
        if (!TextUtils.isEmpty(yW)) {
            aoK = (C0686a) t.b(yW, new c<C0686a>() { // from class: com.kwad.sdk.commercial.j.a.1
                private static C0686a AV() {
                    return new C0686a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ C0686a AW() {
                    return AV();
                }
            });
        }
        return aoK;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static boolean cL(String str) {
        List<String> list;
        C0686a AU = AU();
        if (AU == null || (list = AU.aoL) == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void n(AdTemplate adTemplate, int i4, String str) {
        try {
            a(adTemplate, b.AX().cn(4).co(i4).cM(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, int i4, String str) {
        try {
            a(adTemplate, b.AX().cn(1).co(i4).cM(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z3, b bVar) {
        if (cL(bVar.aoN)) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z3 ? "ad_client_error_log" : "ad_client_apm_log").i(z3 ? 1.0d : 0.001d).a(d.aS(adTemplate)).N("ad_sdk_track_performance", "status").u(bVar));
    }

    public static void a(AdTemplate adTemplate, int i4, String str, int i5, int i6) {
        try {
            a(adTemplate, b.AX().cn(2).co(i4).cM(str).cp(i6).setErrorCode(i5).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i4, String str, String str2, int i5, String str3, int i6) {
        try {
            a(adTemplate, true, b.AX().cn(3).co(i4).cM(str).cN(str2).setErrorCode(i5).setErrorMsg(str3).cp(i6).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
