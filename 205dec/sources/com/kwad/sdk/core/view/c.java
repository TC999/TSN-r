package com.kwad.sdk.core.view;

import android.view.View;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private List<b> aDH = new CopyOnWriteArrayList();

    public final void a(b bVar) {
        this.aDH.add(bVar);
    }

    public final void b(b bVar) {
        this.aDH.remove(bVar);
    }

    public final void j(View view, boolean z3) {
        for (b bVar : this.aDH) {
            bVar.i(view, z3);
        }
    }
}
