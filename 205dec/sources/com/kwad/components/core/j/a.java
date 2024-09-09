package com.kwad.components.core.j;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private CopyOnWriteArrayList<b> Mk = new CopyOnWriteArrayList<>();
    private volatile boolean Ml;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.j.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class C0637a {
        private static final a Mm = new a();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {
        private final c Mn;
        public boolean Mo;

        public b(c cVar) {
            this.Mn = cVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c {
        void bk();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Mo;
    }

    public static a oG() {
        return C0637a.Mm;
    }

    public final void a(b bVar) {
        if (this.Mk.contains(bVar)) {
            return;
        }
        if (!this.Ml) {
            this.Ml = true;
            bVar.Mo = true;
        }
        this.Mk.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Mo) {
            bVar.Mo = false;
            this.Ml = false;
        }
        this.Mk.remove(bVar);
        if (this.Mk.size() == 0 || this.Ml) {
            return;
        }
        this.Mk.get(0).Mo = true;
        this.Ml = true;
        this.Mk.get(0).Mn.bk();
    }
}
