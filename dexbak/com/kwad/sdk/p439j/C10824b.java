package com.kwad.sdk.p439j;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.p434g.AbstractC10762b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11124s;
import com.kwai.adclient.kscommerciallogger.model.C11160a;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.j.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10824b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @KsJson
    /* renamed from: com.kwad.sdk.j.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10827a extends AbstractC9822a {
        public String aFq;
        public int aJF;
        public String sdkVersion;
    }

    @KsJson
    /* renamed from: com.kwad.sdk.j.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10828b extends AbstractC9822a {
        public int aJG;
        public String aJH;
        public String aJI;
        public String aJJ;
        public String aJK;
        public String aJL;
    }

    /* renamed from: Jt */
    public static void m24720Jt() {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.j.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10824b.m24719Ju();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ju */
    public static void m24719Ju() {
        C10827a m24718a;
        JSONObject jSONObject = (JSONObject) C10251d.m26554Ca().getAppConfigData(null, new AbstractC10762b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.b.2
            /* renamed from: o */
            private static JSONObject m24716o(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.p434g.AbstractC10762b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return m24716o(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C10828b c10828b = new C10828b();
        try {
            c10828b.parseJson(jSONObject);
            if (c10828b.aJG == 1 && (m24718a = m24718a(ServiceProvider.getContext().getClassLoader(), c10828b)) != null) {
                C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_tt_sdk_info", "sv").m27625u(m24718a).m27632a(C11160a.aTL));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    /* renamed from: a */
    private static C10827a m24718a(ClassLoader classLoader, C10828b c10828b) {
        Class<?> m23706a = C11124s.m23706a(c10828b.aJH, classLoader);
        if (m23706a == null) {
            return null;
        }
        C10827a c10827a = new C10827a();
        c10827a.aJF = C11124s.classExists(c10828b.aJI) ? 1 : 0;
        Object callStaticMethod = C11124s.callStaticMethod(m23706a, c10828b.aJJ, new Object[0]);
        c10827a.sdkVersion = (String) C11124s.callMethod(callStaticMethod, c10828b.aJK, new Object[0]);
        c10827a.aFq = (String) C11124s.callMethod(callStaticMethod, c10828b.aJL, new Object[0]);
        return c10827a;
    }
}
