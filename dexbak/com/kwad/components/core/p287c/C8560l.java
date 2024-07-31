package com.kwad.components.core.p287c;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.components.core.c.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8560l implements InterfaceC8547c {
    @Nullable
    @WorkerThread
    /* renamed from: d */
    public static AdResultData m30355d(C8927a c8927a) {
        C8544a m30401mu = C8544a.m30401mu();
        if (m30401mu == null) {
            return null;
        }
        int adNum = c8927a.getAdNum();
        List<C8555h> m30404a = m30401mu.m30404a(String.valueOf(c8927a.getPosId()), System.currentTimeMillis() / 1000, C8551e.m30381s(c8927a.getPosId()).m30384mB());
        if (C10251d.m26530Cy()) {
            m30354k(m30404a);
        }
        if (m30404a == null || m30404a.size() <= 0) {
            return null;
        }
        Collections.sort(m30404a);
        return C8555h.m30367j(m30404a.subList(0, Math.min(m30404a.size(), adNum)));
    }

    /* renamed from: k */
    private static void m30354k(List<C8555h> list) {
        if (list == null) {
            return;
        }
        Iterator<C8555h> it = list.iterator();
        while (it.hasNext()) {
            C8555h next = it.next();
            if (C8554g.m30373mF().m30377a(next)) {
                C10331c.m26254d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.m30360mM());
                it.remove();
            }
        }
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8547c
    /* renamed from: c */
    public final void mo30345c(final C8927a c8927a) {
        GlobalThreadPools.m25601FH().submit(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.c.l.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                AdResultData m30355d = C8560l.m30355d(c8927a);
                if (m30355d != null && !m30355d.isAdResultDataEmpty()) {
                    C8927a.m29593a(c8927a, m30355d, true);
                    return;
                }
                C8927a c8927a2 = c8927a;
                C8569n.m30346a(c8927a2, new C8557j(c8927a2));
            }
        });
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8547c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }
}
