package com.kwad.components.core.s;

import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private Set<b> Ta;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static c Tb = new c((byte) 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void onPageClose();
    }

    /* synthetic */ c(byte b4) {
        this();
    }

    public static c qZ() {
        return a.Tb;
    }

    public final void a(b bVar) {
        this.Ta.add(bVar);
    }

    public final void b(b bVar) {
        this.Ta.remove(bVar);
    }

    public final void ra() {
        if (this.Ta.size() == 0) {
            return;
        }
        for (b bVar : this.Ta) {
            bVar.onPageClose();
        }
    }

    private c() {
        this.Ta = new HashSet();
    }
}
