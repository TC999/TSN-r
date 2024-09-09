package com.kwad.components.core.c;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ay;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l implements c {
    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.request.model.a aVar) {
        a mu = a.mu();
        if (mu == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> a4 = mu.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.s(aVar.getPosId()).mB());
        if (com.kwad.sdk.core.config.d.Cy()) {
            k(a4);
        }
        if (a4 == null || a4.size() <= 0) {
            return null;
        }
        Collections.sort(a4);
        return h.j(a4.subList(0, Math.min(a4.size(), adNum)));
    }

    private static void k(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (g.mF().a(next)) {
                com.kwad.sdk.core.e.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.mM());
                it.remove();
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final void c(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.FH().submit(new ay() { // from class: com.kwad.components.core.c.l.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                AdResultData d4 = l.d(aVar);
                if (d4 != null && !d4.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, d4, true);
                    return;
                }
                com.kwad.components.core.request.model.a aVar2 = aVar;
                n.a(aVar2, new j(aVar2));
            }
        });
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }
}
