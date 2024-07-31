package com.kwad.components.core.p317o;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.p325a.C8883b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.C9800f;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.C10455g;
import com.kwad.sdk.core.report.C10464n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11103l;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.o.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8766a {

    /* renamed from: Rk */
    private static boolean f28474Rk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.o.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C8768a {

        /* renamed from: Rm */
        private static final C8766a f28476Rm = new C8766a();
    }

    protected C8766a() {
    }

    /* renamed from: G */
    public static C10464n m29919G(long j) {
        return new C10464n(j);
    }

    /* renamed from: a */
    private static C10464n m29916a(long j, AdTemplate adTemplate, String str) {
        return new C10464n(j, adTemplate, str);
    }

    /* renamed from: b */
    private static C10464n m29904b(long j, AdTemplate adTemplate) {
        return new C10464n(j, adTemplate);
    }

    /* renamed from: qi */
    public static C8766a m29888qi() {
        return C8768a.f28476Rm;
    }

    /* renamed from: aD */
    public final void m29910aD(int i) {
        C10464n m29919G = m29919G(10104L);
        m29919G.ayc = i;
        C10455g.m26032a(m29919G);
    }

    /* renamed from: aE */
    public final void m29909aE(int i) {
        C10464n m29919G = m29919G(10107L);
        m29919G.ayd = i;
        C10455g.m26032a(m29919G);
    }

    /* renamed from: ae */
    public final void m29908ae(Context context) {
        C10464n m29919G = m29919G(11L);
        JSONArray[] m24276c = InstalledAppInfoManager.m24276c(context, C10251d.m26510yG());
        m29919G.axU = m24276c[0];
        m29919G.axV = m24276c[1];
        C10455g.m26032a(m29919G);
    }

    /* renamed from: au */
    public final void m29907au(@NonNull AdTemplate adTemplate) {
        C10455g.m26032a(m29904b(10007L, adTemplate));
    }

    /* renamed from: av */
    public final void m29906av(@NonNull AdTemplate adTemplate) {
        C10455g.m26032a(m29904b(10208L, adTemplate));
    }

    /* renamed from: aw */
    public final void m29905aw(@NonNull AdTemplate adTemplate) {
        C10455g.m26032a(m29904b(10209L, adTemplate));
    }

    /* renamed from: c */
    public final void m29900c(@NonNull AdTemplate adTemplate, int i, int i2) {
        C10464n m29904b = m29904b(10002L, adTemplate);
        m29904b.m26015EN();
        if (C10487e.m25649dI(adTemplate)) {
            m29904b.ayb = C10483a.m25977K(C10487e.m25641dQ(adTemplate));
        } else {
            m29904b.ayb = C10487e.m25639dS(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            m29904b.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            C10331c.printStackTraceOnly(e);
        }
        C10455g.m26032a(m29904b);
    }

    /* renamed from: e */
    public final void m29896e(@NonNull JSONObject jSONObject, int i) {
        C10464n m29919G = m29919G(10201L);
        C11126t.putValue(jSONObject, "appChangeType", i);
        m29919G.ayf = jSONObject;
        C10455g.m26032a(m29919G);
    }

    /* renamed from: f */
    public final void m29894f(AdTemplate adTemplate, int i, String str) {
        C10464n m29904b = m29904b(10109L, adTemplate);
        m29904b.ayd = 1;
        m29904b.aye = str;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: g */
    public final void m29892g(@NonNull AdTemplate adTemplate, long j) {
        C10464n m29904b = m29904b(10202L, adTemplate);
        m29904b.ayk = j;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: h */
    public final void m29891h(AdTemplate adTemplate, long j) {
        C10464n m29904b = m29904b(10206L, adTemplate);
        m29904b.ayA = j;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: i */
    public final void m29890i(AdTemplate adTemplate, long j) {
        C10464n m29904b = m29904b(10207L, adTemplate);
        m29904b.ayB = j;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: m */
    public final C10464n m29889m(String str, String str2) {
        C10464n m29919G = m29919G(12200L);
        m29919G.ayJ = str;
        m29919G.ayK = str2;
        return m29919G;
    }

    /* renamed from: qj */
    public final void m29887qj() {
        if (f28474Rk) {
            return;
        }
        f28474Rk = true;
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.o.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10464n m29919G = C8766a.m29919G(8L);
                m29919G.ayC = C9800f.m27754Ay();
                C10455g.m26032a(m29919G);
            }
        });
    }

    /* renamed from: qk */
    public final void m29886qk() {
        C10455g.m26032a(m29919G(10101L));
    }

    /* renamed from: ql */
    public final void m29885ql() {
        C10455g.m26032a(m29919G(10106L));
    }

    /* renamed from: a */
    public final void m29913a(@NonNull AdTemplate adTemplate, String str, String str2) {
        C10464n m29904b = m29904b(10003L, adTemplate);
        m29904b.ayb = str;
        m29904b.errorMsg = str2;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: b */
    public final void m29903b(@NonNull AdTemplate adTemplate, int i, int i2) {
        C10464n m29904b = m29904b(12006L, adTemplate);
        m29904b.f29573Xt = i;
        m29904b.apY = i2;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: g */
    public final void m29893g(@NonNull AdTemplate adTemplate, int i, String str) {
        C10464n m29904b = m29904b(107L, adTemplate);
        m29904b.errorCode = i;
        m29904b.errorMsg = str;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: e */
    public final void m29898e(AdTemplate adTemplate, int i) {
        C10464n m29904b = m29904b(10108L, adTemplate);
        m29904b.ayd = i;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: f */
    public final void m29895f(@NonNull AdTemplate adTemplate, int i) {
        if (C10251d.m26532Cw()) {
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            C10464n m29919G = m29919G(20000L);
            m29919G.timestamp = System.currentTimeMillis();
            m29919G.ayL = i;
            m29919G.trace = m25641dQ.trace;
            m29919G.ayM = BuildConfig.VERSION_CODE;
            m29919G.posId = C10487e.m25648dJ(adTemplate);
            C10455g.m26032a(m29919G);
        }
    }

    /* renamed from: a */
    public final void m29918a(int i, @NonNull AdTemplate adTemplate, String str) {
        C10455g.m26032a(m29916a(i, adTemplate, str));
    }

    /* renamed from: b */
    public final void m29901b(@NonNull AdTemplate adTemplate, String str, String str2) {
        C10464n m29904b = m29904b(10005L, adTemplate);
        if (C10487e.m25649dI(adTemplate)) {
            m29904b.ayb = C10483a.m25977K(C10487e.m25641dQ(adTemplate));
        } else {
            m29904b.ayb = C10487e.m25639dS(adTemplate);
        }
        m29904b.ayb = str;
        m29904b.errorMsg = str2;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: a */
    public final void m29914a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        C10464n m29904b = m29904b(10203L, adTemplate);
        m29904b.f29571VU = j;
        m29904b.blockDuration = j2;
        m29904b.axR = i;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: e */
    public final void m29897e(String str, String str2, boolean z) {
        C10455g.m26031a(m29889m(str, str2), z);
    }

    /* renamed from: a */
    public final void m29911a(boolean z, List<Integer> list) {
        C10464n m29919G = m29919G(10204L);
        m29919G.aym = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num);
            }
            m29919G.ayl = jSONArray;
        }
        C10455g.m26032a(m29919G);
    }

    /* renamed from: c */
    public final void m29899c(@NonNull JSONArray jSONArray) {
        C10464n m29919G = m29919G(10200L);
        m29919G.ayg = jSONArray;
        C10455g.m26032a(m29919G);
    }

    /* renamed from: b */
    public final void m29902b(@NonNull AdTemplate adTemplate, long j, int i) {
        C10464n m29904b = m29904b(104L, adTemplate);
        m29904b.clickTime = C11103l.m23772em(adTemplate);
        m29904b.ayq = j;
        m29904b.ayr = i;
        C10455g.m26032a(m29904b);
    }

    /* renamed from: a */
    public final void m29912a(SceneImpl sceneImpl, boolean z, String str) {
        C10464n m29919G = m29919G(10216L);
        m29919G.aym = z;
        m29919G.ayn = str;
        m29919G.adScene = sceneImpl;
        C10455g.m26032a(m29919G);
    }

    /* renamed from: a */
    public final void m29915a(C8883b c8883b) {
        C10464n m29919G = m29919G(10215L);
        m29919G.f29566Ra = c8883b.f28742Ra;
        m29919G.f29567Rh = c8883b.f28743Rh;
        m29919G.f29568Ri = c8883b.f28744Ri;
        m29919G.f29569Rj = c8883b.f28745Rj;
        C10455g.m26032a(m29919G);
    }

    /* renamed from: a */
    public final void m29917a(long j, int i) {
        if (C10251d.m26532Cw()) {
            C10464n m29919G = m29919G(20000L);
            m29919G.timestamp = System.currentTimeMillis();
            m29919G.ayL = i;
            m29919G.posId = j;
            m29919G.ayM = BuildConfig.VERSION_CODE;
            C10455g.m26032a(m29919G);
        }
    }
}
