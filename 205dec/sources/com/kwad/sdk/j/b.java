package com.kwad.sdk.j;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.commercial.c.a {
        public String aFq;
        public int aJF;
        public String sdkVersion;
    }

    @KsJson
    /* renamed from: com.kwad.sdk.j.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0715b extends com.kwad.sdk.commercial.c.a {
        public int aJG;
        public String aJH;
        public String aJI;
        public String aJJ;
        public String aJK;
        public String aJL;
    }

    public static void Jt() {
        g.execute(new ay() { // from class: com.kwad.sdk.j.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.Ju();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ju() {
        a a4;
        JSONObject jSONObject = (JSONObject) d.Ca().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.b.2
            private static JSONObject o(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return o(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C0715b c0715b = new C0715b();
        try {
            c0715b.parseJson(jSONObject);
            if (c0715b.aJG == 1 && (a4 = a(ServiceProvider.getContext().getClassLoader(), c0715b)) != null) {
                com.kwad.sdk.commercial.b.d(c.AJ().cu("ad_client_apm_log").i(0.01d).N("ad_sdk_tt_sdk_info", "sv").u(a4).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static a a(ClassLoader classLoader, C0715b c0715b) {
        Class<?> a4 = s.a(c0715b.aJH, classLoader);
        if (a4 == null) {
            return null;
        }
        a aVar = new a();
        aVar.aJF = s.classExists(c0715b.aJI) ? 1 : 0;
        Object callStaticMethod = s.callStaticMethod(a4, c0715b.aJJ, new Object[0]);
        aVar.sdkVersion = (String) s.callMethod(callStaticMethod, c0715b.aJK, new Object[0]);
        aVar.aFq = (String) s.callMethod(callStaticMethod, c0715b.aJL, new Object[0]);
        return aVar;
    }
}
