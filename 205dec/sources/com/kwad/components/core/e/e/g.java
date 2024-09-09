package com.kwad.components.core.e.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {
    private final List<f> Lu;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static final g Lv = new g((byte) 0);
    }

    /* synthetic */ g(byte b4) {
        this();
    }

    public static g or() {
        return a.Lv;
    }

    public final void a(f fVar) {
        this.Lu.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.Lu.remove(fVar);
        }
    }

    public final void os() {
        for (f fVar : this.Lu) {
            fVar.show();
        }
    }

    public final void ot() {
        for (f fVar : this.Lu) {
            fVar.dismiss();
        }
    }

    private g() {
        this.Lu = new CopyOnWriteArrayList();
    }
}
