package com.kwad.sdk.core.adlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.core.adlog.p386a.C9895a;
import com.kwad.sdk.core.adlog.p386a.C9896b;
import com.kwad.sdk.core.adlog.p387b.C9906c;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.track.C10516a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11126t;
import com.tencent.bugly.BUGLY;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.adlog.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9901b {
    /* renamed from: Bf */
    public static void m27396Bf() {
        GlobalThreadPools.m25601FH().execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9895a m27402Bl = C9896b.m27405Bi().m27402Bl();
                if (m27402Bl != null) {
                    JSONObject jSONObject = m27402Bl.apq;
                    C11126t.putValue(jSONObject, "retryCount", m27402Bl.retryCount);
                    C11126t.putValue(jSONObject, "cacheType", 1);
                    C9901b.m27394a(m27402Bl.url, jSONObject, m27402Bl.apr, m27402Bl);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m27395a(@NonNull final C9912a c9912a) {
        GlobalThreadPools.m25601FH().execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9893a c9893a = new C9893a(C9912a.this);
                C9901b.m27394a(c9893a.getUrl(), c9893a.getBody(), C9912a.this, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m27394a(String str, JSONObject jSONObject, @NonNull C9912a c9912a, @Nullable C9895a c9895a) {
        AdTemplate adTemplate = c9912a.adTemplate;
        int i = c9912a.aoM;
        try {
            C9906c.m27372a(adTemplate, i, c9895a);
            if (!C11013ag.isNetworkConnected(ServiceProvider.getContext())) {
                C10331c.m26246w("AdLogRequestManager", "no network while report log");
                C9906c.m27371a(adTemplate, i, str, 100004, "no network", c9895a);
                C9896b.m27405Bi().m27399a(c9895a, str, jSONObject, c9912a, 100004, "no network");
            } else if (C11064bn.m23857hb(str)) {
                C9906c.m27367b(adTemplate, i, str, 100001, "", c9895a);
            } else {
                C10415c doPost = C10756f.m24902xT().doPost(str, (Map<String, String>) null, jSONObject);
                AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
                adLogRequestResult.parseResult(doPost.avs);
                int i2 = doPost.code;
                if (i2 != 200) {
                    int m27621cb = C9825d.m27621cb(i2);
                    String str2 = doPost.avs;
                    C9906c.m27365d(adTemplate, i, str, m27621cb, str2, c9895a);
                    C9896b.m27405Bi().m27399a(c9895a, str, jSONObject, c9912a, m27621cb, str2);
                } else if (adLogRequestResult.isResultOk()) {
                    C9906c.m27368b(adTemplate, i, c9895a);
                    m27393b(c9912a);
                    C9896b.m27405Bi().m27404Bj();
                } else if (adLogRequestResult.isCheatingFlow()) {
                    adTemplate.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                    C9906c.m27366c(adTemplate, i, str, adLogRequestResult.result, adLogRequestResult.errorMsg, c9895a);
                } else {
                    int i3 = adLogRequestResult.result;
                    String str3 = adLogRequestResult.errorMsg;
                    C10331c.m26246w("AdLogRequestManager", "request fail code:" + i3 + ", errorMsg:" + str3 + ", url=" + str);
                    C9906c.m27366c(adTemplate, i, str, i3, str3, c9895a);
                    C9896b.m27405Bi().m27399a(c9895a, str, jSONObject, c9912a, i3, str3);
                }
            }
        } catch (Throwable th) {
            C9906c.m27367b(adTemplate, i, "", BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH, C11064bn.m23856t(th), c9895a);
            C10331c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    private static void m27393b(@NonNull C9912a c9912a) {
        try {
            C10516a.m25567d(c9912a);
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
