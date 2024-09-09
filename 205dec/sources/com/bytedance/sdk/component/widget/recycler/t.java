package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.c.w.sr;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t {

    /* renamed from: c  reason: collision with root package name */
    final com.bytedance.sdk.component.widget.recycler.c.w.c<RecyclerView.j, c> f30604c = new com.bytedance.sdk.component.widget.recycler.c.w.c<>();

    /* renamed from: w  reason: collision with root package name */
    final com.bytedance.sdk.component.widget.recycler.c.w.xv<RecyclerView.j> f30605w = new com.bytedance.sdk.component.widget.recycler.c.w.xv<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(RecyclerView.j jVar);

        void c(RecyclerView.j jVar, RecyclerView.f.xv xvVar, RecyclerView.f.xv xvVar2);

        void w(RecyclerView.j jVar, RecyclerView.f.xv xvVar, RecyclerView.f.xv xvVar2);

        void xv(RecyclerView.j jVar, RecyclerView.f.xv xvVar, RecyclerView.f.xv xvVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f30604c.clear();
        this.f30605w.xv();
    }

    public void ev(RecyclerView.j jVar) {
        f(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView.j jVar) {
        c cVar = this.f30604c.get(jVar);
        if (cVar != null) {
            cVar.f30606c &= -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(RecyclerView.j jVar) {
        int w3 = this.f30605w.w() - 1;
        while (true) {
            if (w3 < 0) {
                break;
            } else if (jVar == this.f30605w.xv(w3)) {
                this.f30605w.c(w3);
                break;
            } else {
                w3--;
            }
        }
        c remove = this.f30604c.remove(jVar);
        if (remove != null) {
            c.c(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sr(RecyclerView.j jVar) {
        c cVar = this.f30604c.get(jVar);
        return (cVar == null || (cVar.f30606c & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ux(RecyclerView.j jVar) {
        c cVar = this.f30604c.get(jVar);
        if (cVar == null) {
            cVar = c.c();
            this.f30604c.put(jVar, cVar);
        }
        cVar.f30606c |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.xv w(RecyclerView.j jVar) {
        return c(jVar, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.xv xv(RecyclerView.j jVar) {
        return c(jVar, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {
        static sr.c<c> sr = new sr.w(20);

        /* renamed from: c  reason: collision with root package name */
        int f30606c;

        /* renamed from: w  reason: collision with root package name */
        RecyclerView.f.xv f30607w;
        RecyclerView.f.xv xv;

        private c() {
        }

        static c c() {
            c c4 = sr.c();
            return c4 == null ? new c() : c4;
        }

        static void w() {
            do {
            } while (sr.c() != null);
        }

        static void c(c cVar) {
            cVar.f30606c = 0;
            cVar.f30607w = null;
            cVar.xv = null;
            sr.c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(RecyclerView.j jVar, RecyclerView.f.xv xvVar) {
        c cVar = this.f30604c.get(jVar);
        if (cVar == null) {
            cVar = c.c();
            this.f30604c.put(jVar, cVar);
        }
        cVar.f30606c |= 2;
        cVar.f30607w = xvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv(RecyclerView.j jVar, RecyclerView.f.xv xvVar) {
        c cVar = this.f30604c.get(jVar);
        if (cVar == null) {
            cVar = c.c();
            this.f30604c.put(jVar, cVar);
        }
        cVar.xv = xvVar;
        cVar.f30606c |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.j jVar, RecyclerView.f.xv xvVar) {
        c cVar = this.f30604c.get(jVar);
        if (cVar == null) {
            cVar = c.c();
            this.f30604c.put(jVar, cVar);
        }
        cVar.f30607w = xvVar;
        cVar.f30606c |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        c.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(RecyclerView.j jVar) {
        c cVar = this.f30604c.get(jVar);
        return (cVar == null || (cVar.f30606c & 1) == 0) ? false : true;
    }

    private RecyclerView.f.xv c(RecyclerView.j jVar, int i4) {
        c w3;
        RecyclerView.f.xv xvVar;
        int c4 = this.f30604c.c(jVar);
        if (c4 >= 0 && (w3 = this.f30604c.w(c4)) != null) {
            int i5 = w3.f30606c;
            if ((i5 & i4) != 0) {
                int i6 = (i4 ^ (-1)) & i5;
                w3.f30606c = i6;
                if (i4 == 4) {
                    xvVar = w3.f30607w;
                } else if (i4 == 8) {
                    xvVar = w3.xv;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i6 & 12) == 0) {
                    this.f30604c.xv(c4);
                    c.c(w3);
                }
                return xvVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j4, RecyclerView.j jVar) {
        this.f30605w.w(j4, jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.j c(long j4) {
        return this.f30605w.c(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(w wVar) {
        for (int size = this.f30604c.size() - 1; size >= 0; size--) {
            RecyclerView.j c4 = this.f30604c.c(size);
            c xv = this.f30604c.xv(size);
            int i4 = xv.f30606c;
            if ((i4 & 3) == 3) {
                wVar.c(c4);
            } else if ((i4 & 1) != 0) {
                RecyclerView.f.xv xvVar = xv.f30607w;
                if (xvVar == null) {
                    wVar.c(c4);
                } else {
                    wVar.c(c4, xvVar, xv.xv);
                }
            } else if ((i4 & 14) == 14) {
                wVar.w(c4, xv.f30607w, xv.xv);
            } else if ((i4 & 12) == 12) {
                wVar.xv(c4, xv.f30607w, xv.xv);
            } else if ((i4 & 4) != 0) {
                wVar.c(c4, xv.f30607w, null);
            } else if ((i4 & 8) != 0) {
                wVar.w(c4, xv.f30607w, xv.xv);
            }
            c.c(xv);
        }
    }
}
