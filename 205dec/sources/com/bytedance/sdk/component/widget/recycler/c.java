package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.c.w.sr;
import com.bytedance.sdk.component.widget.recycler.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements r.c {

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<w> f30569c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    final r f30570f;

    /* renamed from: r  reason: collision with root package name */
    private sr.c<w> f30571r;
    Runnable sr;
    final boolean ux;

    /* renamed from: w  reason: collision with root package name */
    final ArrayList<w> f30572w;
    final InterfaceC0458c xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.component.widget.recycler.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0458c {
        RecyclerView.j c(int i4);

        void c(int i4, int i5);

        void c(int i4, int i5, Object obj);

        void c(w wVar);

        void sr(int i4, int i5);

        void w(int i4, int i5);

        void w(w wVar);

        void xv(int i4, int i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        int f30573c;
        int sr;

        /* renamed from: w  reason: collision with root package name */
        int f30574w;
        Object xv;

        w(int i4, int i5, int i6, Object obj) {
            this.f30573c = i4;
            this.f30574w = i5;
            this.sr = i6;
            this.xv = obj;
        }

        String c() {
            int i4 = this.f30573c;
            return i4 != 1 ? i4 != 2 ? i4 != 4 ? i4 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            w wVar = (w) obj;
            int i4 = this.f30573c;
            if (i4 != wVar.f30573c) {
                return false;
            }
            if (i4 == 8 && Math.abs(this.sr - this.f30574w) == 1 && this.sr == wVar.f30574w && this.f30574w == wVar.sr) {
                return true;
            }
            if (this.sr == wVar.sr && this.f30574w == wVar.f30574w) {
                Object obj2 = this.xv;
                if (obj2 != null) {
                    if (!obj2.equals(wVar.xv)) {
                        return false;
                    }
                } else if (wVar.xv != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f30573c * 31) + this.f30574w) * 31) + this.sr;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + c() + ",s:" + this.f30574w + "c:" + this.sr + ",p:" + this.xv + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InterfaceC0458c interfaceC0458c) {
        this(interfaceC0458c, false);
    }

    private void f(w wVar) {
        r(wVar);
    }

    private void r(w wVar) {
        this.f30572w.add(wVar);
        int i4 = wVar.f30573c;
        if (i4 == 1) {
            this.xv.xv(wVar.f30574w, wVar.sr);
        } else if (i4 == 2) {
            this.xv.w(wVar.f30574w, wVar.sr);
        } else if (i4 == 4) {
            this.xv.c(wVar.f30574w, wVar.sr, wVar.xv);
        } else if (i4 == 8) {
            this.xv.sr(wVar.f30574w, wVar.sr);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + wVar);
        }
    }

    private void sr(w wVar) {
        int i4 = wVar.f30574w;
        int i5 = wVar.sr + i4;
        int i6 = i4;
        char c4 = '\uffff';
        int i7 = 0;
        while (i4 < i5) {
            if (this.xv.c(i4) != null || sr(i4)) {
                if (c4 == 0) {
                    ux(c(4, i6, i7, wVar.xv));
                    i6 = i4;
                    i7 = 0;
                }
                c4 = 1;
            } else {
                if (c4 == 1) {
                    r(c(4, i6, i7, wVar.xv));
                    i6 = i4;
                    i7 = 0;
                }
                c4 = 0;
            }
            i7++;
            i4++;
        }
        if (i7 != wVar.sr) {
            Object obj = wVar.xv;
            c(wVar);
            wVar = c(4, i6, i7, obj);
        }
        if (c4 == 0) {
            ux(wVar);
        } else {
            r(wVar);
        }
    }

    private void ux(w wVar) {
        int i4;
        int i5 = wVar.f30573c;
        if (i5 != 1 && i5 != 8) {
            int w3 = w(wVar.f30574w, i5);
            int i6 = wVar.f30574w;
            int i7 = wVar.f30573c;
            if (i7 == 2) {
                i4 = 0;
            } else if (i7 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + wVar);
            } else {
                i4 = 1;
            }
            int i8 = 1;
            for (int i9 = 1; i9 < wVar.sr; i9++) {
                int w4 = w(wVar.f30574w + (i4 * i9), wVar.f30573c);
                int i10 = wVar.f30573c;
                if (i10 == 2 ? w4 == w3 : i10 == 4 && w4 == w3 + 1) {
                    i8++;
                } else {
                    w c4 = c(i10, w3, i8, wVar.xv);
                    c(c4, i6);
                    c(c4);
                    if (wVar.f30573c == 4) {
                        i6 += i8;
                    }
                    w3 = w4;
                    i8 = 1;
                }
            }
            Object obj = wVar.xv;
            c(wVar);
            if (i8 > 0) {
                w c5 = c(wVar.f30573c, w3, i8, obj);
                c(c5, i6);
                c(c5);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        c(this.f30569c);
        c(this.f30572w);
        this.ev = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f30570f.c(this.f30569c);
        int size = this.f30569c.size();
        for (int i4 = 0; i4 < size; i4++) {
            w wVar = this.f30569c.get(i4);
            int i5 = wVar.f30573c;
            if (i5 == 1) {
                f(wVar);
            } else if (i5 == 2) {
                xv(wVar);
            } else if (i5 == 4) {
                sr(wVar);
            } else if (i5 == 8) {
                w(wVar);
            }
            Runnable runnable = this.sr;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f30569c.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv() {
        int size = this.f30572w.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.xv.w(this.f30572w.get(i4));
        }
        c(this.f30572w);
        this.ev = 0;
    }

    c(InterfaceC0458c interfaceC0458c, boolean z3) {
        this.f30571r = new sr.w(30);
        this.f30569c = new ArrayList<>();
        this.f30572w = new ArrayList<>();
        this.ev = 0;
        this.xv = interfaceC0458c;
        this.ux = z3;
        this.f30570f = new r(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this.f30572w.isEmpty() || this.f30569c.isEmpty()) ? false : true;
    }

    void c(w wVar, int i4) {
        this.xv.c(wVar);
        int i5 = wVar.f30573c;
        if (i5 == 2) {
            this.xv.c(i4, wVar.sr);
        } else if (i5 == 4) {
            this.xv.c(i4, wVar.sr, wVar.xv);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private void xv(w wVar) {
        boolean z3;
        char c4;
        int i4 = wVar.f30574w;
        int i5 = wVar.sr + i4;
        char c5 = '\uffff';
        int i6 = i4;
        int i7 = 0;
        while (i6 < i5) {
            if (this.xv.c(i6) != null || sr(i6)) {
                if (c5 == 0) {
                    ux(c(2, i4, i7, null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                c4 = 1;
            } else {
                if (c5 == 1) {
                    r(c(2, i4, i7, null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                c4 = 0;
            }
            if (z3) {
                i6 -= i7;
                i5 -= i7;
                i7 = 1;
            } else {
                i7++;
            }
            i6++;
            c5 = c4;
        }
        if (i7 != wVar.sr) {
            c(wVar);
            wVar = c(2, i4, i7, null);
        }
        if (c5 == 0) {
            ux(wVar);
        } else {
            r(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i4) {
        return (i4 & this.ev) != 0;
    }

    int c(int i4, int i5) {
        int size = this.f30572w.size();
        while (i5 < size) {
            w wVar = this.f30572w.get(i5);
            int i6 = wVar.f30573c;
            if (i6 == 8) {
                int i7 = wVar.f30574w;
                if (i7 == i4) {
                    i4 = wVar.sr;
                } else {
                    if (i7 < i4) {
                        i4--;
                    }
                    if (wVar.sr <= i4) {
                        i4++;
                    }
                }
            } else {
                int i8 = wVar.f30574w;
                if (i8 > i4) {
                    continue;
                } else if (i6 == 2) {
                    int i9 = wVar.sr;
                    if (i4 < i8 + i9) {
                        return -1;
                    }
                    i4 -= i9;
                } else if (i6 == 1) {
                    i4 += wVar.sr;
                }
            }
            i5++;
        }
        return i4;
    }

    private void w(w wVar) {
        r(wVar);
    }

    private int w(int i4, int i5) {
        int i6;
        int i7;
        for (int size = this.f30572w.size() - 1; size >= 0; size--) {
            w wVar = this.f30572w.get(size);
            int i8 = wVar.f30573c;
            if (i8 == 8) {
                int i9 = wVar.f30574w;
                int i10 = wVar.sr;
                if (i9 < i10) {
                    i7 = i9;
                    i6 = i10;
                } else {
                    i6 = i9;
                    i7 = i10;
                }
                if (i4 < i7 || i4 > i6) {
                    if (i4 < i9) {
                        if (i5 == 1) {
                            wVar.f30574w = i9 + 1;
                            wVar.sr = i10 + 1;
                        } else if (i5 == 2) {
                            wVar.f30574w = i9 - 1;
                            wVar.sr = i10 - 1;
                        }
                    }
                } else if (i7 == i9) {
                    if (i5 == 1) {
                        wVar.sr = i10 + 1;
                    } else if (i5 == 2) {
                        wVar.sr = i10 - 1;
                    }
                    i4++;
                } else {
                    if (i5 == 1) {
                        wVar.f30574w = i9 + 1;
                    } else if (i5 == 2) {
                        wVar.f30574w = i9 - 1;
                    }
                    i4--;
                }
            } else {
                int i11 = wVar.f30574w;
                if (i11 <= i4) {
                    if (i8 == 1) {
                        i4 -= wVar.sr;
                    } else if (i8 == 2) {
                        i4 += wVar.sr;
                    }
                } else if (i5 == 1) {
                    wVar.f30574w = i11 + 1;
                } else if (i5 == 2) {
                    wVar.f30574w = i11 - 1;
                }
            }
        }
        for (int size2 = this.f30572w.size() - 1; size2 >= 0; size2--) {
            w wVar2 = this.f30572w.get(size2);
            if (wVar2.f30573c == 8) {
                int i12 = wVar2.sr;
                if (i12 == wVar2.f30574w || i12 < 0) {
                    this.f30572w.remove(size2);
                    c(wVar2);
                }
            } else if (wVar2.sr <= 0) {
                this.f30572w.remove(size2);
                c(wVar2);
            }
        }
        return i4;
    }

    private boolean sr(int i4) {
        int size = this.f30572w.size();
        for (int i5 = 0; i5 < size; i5++) {
            w wVar = this.f30572w.get(i5);
            int i6 = wVar.f30573c;
            if (i6 == 8) {
                if (c(wVar.sr, i5 + 1) == i4) {
                    return true;
                }
            } else if (i6 == 1) {
                int i7 = wVar.f30574w;
                int i8 = wVar.sr + i7;
                while (i7 < i8) {
                    if (c(i7, i5 + 1) == i4) {
                        return true;
                    }
                    i7++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public int xv(int i4) {
        int size = this.f30569c.size();
        for (int i5 = 0; i5 < size; i5++) {
            w wVar = this.f30569c.get(i5);
            int i6 = wVar.f30573c;
            if (i6 != 1) {
                if (i6 == 2) {
                    int i7 = wVar.f30574w;
                    if (i7 <= i4) {
                        int i8 = wVar.sr;
                        if (i7 + i8 > i4) {
                            return -1;
                        }
                        i4 -= i8;
                    } else {
                        continue;
                    }
                } else if (i6 == 8) {
                    int i9 = wVar.f30574w;
                    if (i9 == i4) {
                        i4 = wVar.sr;
                    } else {
                        if (i9 < i4) {
                            i4--;
                        }
                        if (wVar.sr <= i4) {
                            i4++;
                        }
                    }
                }
            } else if (wVar.f30574w <= i4) {
                i4 += wVar.sr;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i4, int i5, Object obj) {
        if (i5 < 1) {
            return false;
        }
        this.f30569c.add(c(4, i4, i5, obj));
        this.ev |= 4;
        return this.f30569c.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ux() {
        xv();
        int size = this.f30569c.size();
        for (int i4 = 0; i4 < size; i4++) {
            w wVar = this.f30569c.get(i4);
            int i5 = wVar.f30573c;
            if (i5 == 1) {
                this.xv.w(wVar);
                this.xv.xv(wVar.f30574w, wVar.sr);
            } else if (i5 == 2) {
                this.xv.w(wVar);
                this.xv.c(wVar.f30574w, wVar.sr);
            } else if (i5 == 4) {
                this.xv.w(wVar);
                this.xv.c(wVar.f30574w, wVar.sr, wVar.xv);
            } else if (i5 == 8) {
                this.xv.w(wVar);
                this.xv.sr(wVar.f30574w, wVar.sr);
            }
            Runnable runnable = this.sr;
            if (runnable != null) {
                runnable.run();
            }
        }
        c(this.f30569c);
        this.ev = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sr() {
        return this.f30569c.size() > 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.r.c
    public w c(int i4, int i5, int i6, Object obj) {
        w c4 = this.f30571r.c();
        if (c4 == null) {
            return new w(i4, i5, i6, obj);
        }
        c4.f30573c = i4;
        c4.f30574w = i5;
        c4.sr = i6;
        c4.xv = obj;
        return c4;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.r.c
    public void c(w wVar) {
        if (this.ux) {
            return;
        }
        wVar.xv = null;
        this.f30571r.c(wVar);
    }

    void c(List<w> list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            c(list.get(i4));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(int i4) {
        return c(i4, 0);
    }
}
