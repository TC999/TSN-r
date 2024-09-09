package com.kwad.sdk.i;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.az;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class a {

    /* renamed from: com.kwad.sdk.i.a$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 extends az {
        AnonymousClass1() {
        }

        public final void doTask() {
            a.qT();
        }
    }

    /* renamed from: com.kwad.sdk.i.a$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass2 extends com.kwad.sdk.f.b<JSONObject, JSONObject> {
        AnonymousClass2() {
        }

        private static JSONObject o(JSONObject jSONObject) {
            return jSONObject.optJSONObject("sdkTTPerfMonitor");
        }

        public final /* synthetic */ Object apply(Object obj) {
            return o((JSONObject) obj);
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.i.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class C0711a extends com.kwad.sdk.commercial.c.a {
        public String aGE;
        public int aKM;
        public String sdkVersion;
    }

    @KsJson
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class b extends com.kwad.sdk.commercial.c.a {
        public int aKN;
        public String aKO;
        public String aKP;
        public String aKQ;
        public String aKR;
        public String aKS;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        h.Jc().Je();
        h.Jc().Jh().a(str, map, str2);
        h.Jc().Jf();
    }

    public static String al(String str) {
        h.Jc().Je();
        String al = h.Jc().Jh().al(str);
        h.Jc().Jf();
        return al;
    }
}
