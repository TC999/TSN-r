package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.online.monitor.block.C10706e;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.kwad.sdk.crash.online.monitor.p428a.C10698c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.online.monitor.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10694a {
    private static volatile boolean hasInit;

    /* renamed from: HN */
    private static C10698c m25103HN() {
        C10698c c10698c = new C10698c();
        C10696a c10696a = new C10696a();
        c10698c.aHd = c10696a;
        c10696a.aGU = 5;
        return c10698c;
    }

    static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    /* renamed from: cH */
    public static void m25102cH(final String str) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (C10694a.hasInit) {
                    return;
                }
                C10331c.m26254d("perfMonitor.MonitorManager", "configStr:" + str);
                C10698c m25101fr = C10694a.m25101fr(str);
                C10331c.m26254d("perfMonitor.MonitorManager", m25101fr.toJson().toString());
                C10706e.m25077d(m25101fr.aHd);
                C10694a.access$002(true);
            }
        });
    }

    /* renamed from: fr */
    public static C10698c m25101fr(String str) {
        if (TextUtils.isEmpty(str)) {
            return m25103HN();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C10698c c10698c = new C10698c();
            c10698c.parseJson(jSONObject);
            return c10698c;
        } catch (Exception e) {
            C10331c.m26245w("perfMonitor.MonitorManager", e);
            return m25103HN();
        }
    }
}
