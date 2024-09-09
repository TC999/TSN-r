package com.kwad.components.core.o;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static boolean Rk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.o.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class C0641a {
        private static final a Rm = new a();
    }

    protected a() {
    }

    public static n G(long j4) {
        return new n(j4);
    }

    private static n a(long j4, AdTemplate adTemplate, String str) {
        return new n(j4, adTemplate, str);
    }

    private static n b(long j4, AdTemplate adTemplate) {
        return new n(j4, adTemplate);
    }

    public static a qi() {
        return C0641a.Rm;
    }

    public final void aD(int i4) {
        n G = G(10104L);
        G.ayc = i4;
        g.a2(G);
    }

    public final void aE(int i4) {
        n G = G(10107L);
        G.ayd = i4;
        g.a2(G);
    }

    public final void ae(Context context) {
        n G = G(11L);
        JSONArray[] c4 = InstalledAppInfoManager.c(context, d.yG());
        G.axU = c4[0];
        G.axV = c4[1];
        g.a2(G);
    }

    public final void au(@NonNull AdTemplate adTemplate) {
        g.a2(b(10007L, adTemplate));
    }

    public final void av(@NonNull AdTemplate adTemplate) {
        g.a2(b(10208L, adTemplate));
    }

    public final void aw(@NonNull AdTemplate adTemplate) {
        g.a2(b(10209L, adTemplate));
    }

    public final void c(@NonNull AdTemplate adTemplate, int i4, int i5) {
        n b4 = b(10002L, adTemplate);
        b4.EN();
        if (e.dI(adTemplate)) {
            b4.ayb = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        } else {
            b4.ayb = e.dS(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i4);
            jSONObject.put("extra", i5);
            b4.errorMsg = jSONObject.toString();
        } catch (JSONException e4) {
            c.printStackTraceOnly(e4);
        }
        g.a2(b4);
    }

    public final void e(@NonNull JSONObject jSONObject, int i4) {
        n G = G(10201L);
        t.putValue(jSONObject, "appChangeType", i4);
        G.ayf = jSONObject;
        g.a2(G);
    }

    public final void f(AdTemplate adTemplate, int i4, String str) {
        n b4 = b(10109L, adTemplate);
        b4.ayd = 1;
        b4.aye = str;
        g.a2(b4);
    }

    public final void g(@NonNull AdTemplate adTemplate, long j4) {
        n b4 = b(10202L, adTemplate);
        b4.ayk = j4;
        g.a2(b4);
    }

    public final void h(AdTemplate adTemplate, long j4) {
        n b4 = b(10206L, adTemplate);
        b4.ayA = j4;
        g.a2(b4);
    }

    public final void i(AdTemplate adTemplate, long j4) {
        n b4 = b(10207L, adTemplate);
        b4.ayB = j4;
        g.a2(b4);
    }

    public final n m(String str, String str2) {
        n G = G(12200L);
        G.ayJ = str;
        G.ayK = str2;
        return G;
    }

    public final void qj() {
        if (Rk) {
            return;
        }
        Rk = true;
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.o.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                n G = a.G(8L);
                G.ayC = f.Ay();
                g.a2(G);
            }
        });
    }

    public final void qk() {
        g.a2(G(10101L));
    }

    public final void ql() {
        g.a2(G(10106L));
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b4 = b(10003L, adTemplate);
        b4.ayb = str;
        b4.errorMsg = str2;
        g.a2(b4);
    }

    public final void b(@NonNull AdTemplate adTemplate, int i4, int i5) {
        n b4 = b(12006L, adTemplate);
        b4.Xt = i4;
        b4.apY = i5;
        g.a2(b4);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i4, String str) {
        n b4 = b(107L, adTemplate);
        b4.errorCode = i4;
        b4.errorMsg = str;
        g.a2(b4);
    }

    public final void e(AdTemplate adTemplate, int i4) {
        n b4 = b(10108L, adTemplate);
        b4.ayd = i4;
        g.a2(b4);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i4) {
        if (d.Cw()) {
            AdInfo dQ = e.dQ(adTemplate);
            n G = G(20000L);
            G.timestamp = System.currentTimeMillis();
            G.ayL = i4;
            G.trace = dQ.trace;
            G.ayM = BuildConfig.VERSION_CODE;
            G.posId = e.dJ(adTemplate);
            g.a2(G);
        }
    }

    public final void a(int i4, @NonNull AdTemplate adTemplate, String str) {
        g.a2(a(i4, adTemplate, str));
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        n b4 = b(10005L, adTemplate);
        if (e.dI(adTemplate)) {
            b4.ayb = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        } else {
            b4.ayb = e.dS(adTemplate);
        }
        b4.ayb = str;
        b4.errorMsg = str2;
        g.a2(b4);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j4, long j5, int i4) {
        n b4 = b(10203L, adTemplate);
        b4.VU = j4;
        b4.blockDuration = j5;
        b4.axR = i4;
        g.a2(b4);
    }

    public final void e(String str, String str2, boolean z3) {
        g.a(m(str, str2), z3);
    }

    public final void a(boolean z3, List<Integer> list) {
        n G = G(10204L);
        G.aym = z3;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num);
            }
            G.ayl = jSONArray;
        }
        g.a2(G);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        n G = G(10200L);
        G.ayg = jSONArray;
        g.a2(G);
    }

    public final void b(@NonNull AdTemplate adTemplate, long j4, int i4) {
        n b4 = b(104L, adTemplate);
        b4.clickTime = l.em(adTemplate);
        b4.ayq = j4;
        b4.ayr = i4;
        g.a2(b4);
    }

    public final void a(SceneImpl sceneImpl, boolean z3, String str) {
        n G = G(10216L);
        G.aym = z3;
        G.ayn = str;
        G.adScene = sceneImpl;
        g.a2(G);
    }

    public final void a(b bVar) {
        n G = G(10215L);
        G.Ra = bVar.Ra;
        G.Rh = bVar.Rh;
        G.Ri = bVar.Ri;
        G.Rj = bVar.Rj;
        g.a2(G);
    }

    public final void a(long j4, int i4) {
        if (d.Cw()) {
            n G = G(20000L);
            G.timestamp = System.currentTimeMillis();
            G.ayL = i4;
            G.posId = j4;
            G.ayM = BuildConfig.VERSION_CODE;
            g.a2(G);
        }
    }
}
