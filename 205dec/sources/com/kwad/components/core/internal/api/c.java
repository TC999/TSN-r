package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    @NonNull
    private List<b> Mh = new CopyOnWriteArrayList();
    private boolean Mi = false;
    private boolean Mj = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Mh.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Mh.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.Mj);
        if (this.Mj) {
            return;
        }
        for (b bVar : this.Mh) {
            bVar.c(aVar);
        }
        this.Mj = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.Mi);
        if (this.Mi) {
            return;
        }
        for (b bVar : this.Mh) {
            bVar.d(aVar);
        }
        this.Mi = true;
    }
}
