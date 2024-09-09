package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    final InterfaceC0459w f30630c;

    /* renamed from: w  reason: collision with root package name */
    final c f30631w = new c();
    final List<View> xv = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.component.widget.recycler.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0459w {
        int c();

        int c(View view);

        void c(int i4);

        void c(View view, int i4);

        void c(View view, int i4, ViewGroup.LayoutParams layoutParams);

        void sr(View view);

        View w(int i4);

        RecyclerView.j w(View view);

        void w();

        void xv(int i4);

        void xv(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(InterfaceC0459w interfaceC0459w) {
        this.f30630c = interfaceC0459w;
    }

    private boolean ev(View view) {
        if (this.xv.remove(view)) {
            this.f30630c.sr(view);
            return true;
        }
        return false;
    }

    private int f(int i4) {
        if (i4 < 0) {
            return -1;
        }
        int c4 = this.f30630c.c();
        int i5 = i4;
        while (i5 < c4) {
            int ux = i4 - (i5 - this.f30631w.ux(i5));
            if (ux == 0) {
                while (this.f30631w.xv(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += ux;
        }
        return -1;
    }

    private void r(View view) {
        this.xv.add(view);
        this.f30630c.xv(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, boolean z3) {
        c(view, -1, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View sr(int i4) {
        return this.f30630c.w(i4);
    }

    public String toString() {
        return this.f30631w.toString() + ", hidden list:" + this.xv.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ux(int i4) {
        int f4 = f(i4);
        this.f30631w.sr(f4);
        this.f30630c.xv(f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View w(int i4) {
        return this.f30630c.w(f(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View xv(int i4) {
        int size = this.xv.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.xv.get(i5);
            RecyclerView.j w3 = this.f30630c.w(view);
            if (w3.ev() == i4 && !w3.s() && !w3.i()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        long f30632c = 0;

        /* renamed from: w  reason: collision with root package name */
        c f30633w;

        c() {
        }

        private void w() {
            if (this.f30633w == null) {
                this.f30633w = new c();
            }
        }

        void c(int i4) {
            if (i4 >= 64) {
                w();
                this.f30633w.c(i4 - 64);
                return;
            }
            this.f30632c |= 1 << i4;
        }

        void insert(int i4, boolean z3) {
            if (i4 >= 64) {
                w();
                this.f30633w.insert(i4 - 64, z3);
                return;
            }
            long j4 = this.f30632c;
            boolean z4 = (Long.MIN_VALUE & j4) != 0;
            long j5 = (1 << i4) - 1;
            this.f30632c = ((j4 & (j5 ^ (-1))) << 1) | (j4 & j5);
            if (z3) {
                c(i4);
            } else {
                w(i4);
            }
            if (z4 || this.f30633w != null) {
                w();
                this.f30633w.insert(0, z4);
            }
        }

        boolean sr(int i4) {
            if (i4 >= 64) {
                w();
                return this.f30633w.sr(i4 - 64);
            }
            long j4 = 1 << i4;
            long j5 = this.f30632c;
            boolean z3 = (j5 & j4) != 0;
            long j6 = j5 & (j4 ^ (-1));
            this.f30632c = j6;
            long j7 = j4 - 1;
            this.f30632c = (j6 & j7) | Long.rotateRight((j7 ^ (-1)) & j6, 1);
            c cVar = this.f30633w;
            if (cVar != null) {
                if (cVar.xv(0)) {
                    c(63);
                }
                this.f30633w.sr(0);
            }
            return z3;
        }

        public String toString() {
            if (this.f30633w == null) {
                return Long.toBinaryString(this.f30632c);
            }
            return this.f30633w.toString() + "xx" + Long.toBinaryString(this.f30632c);
        }

        int ux(int i4) {
            c cVar = this.f30633w;
            if (cVar == null) {
                return Long.bitCount(i4 >= 64 ? this.f30632c : this.f30632c & ((1 << i4) - 1));
            }
            return i4 < 64 ? Long.bitCount(this.f30632c & ((1 << i4) - 1)) : cVar.ux(i4 - 64) + Long.bitCount(this.f30632c);
        }

        boolean xv(int i4) {
            if (i4 < 64) {
                return (this.f30632c & (1 << i4)) != 0;
            }
            w();
            return this.f30633w.xv(i4 - 64);
        }

        void w(int i4) {
            if (i4 >= 64) {
                c cVar = this.f30633w;
                if (cVar != null) {
                    cVar.w(i4 - 64);
                    return;
                }
                return;
            }
            this.f30632c &= (1 << i4) ^ (-1);
        }

        void c() {
            this.f30632c = 0L;
            c cVar = this.f30633w;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i4, boolean z3) {
        int f4;
        if (i4 < 0) {
            f4 = this.f30630c.c();
        } else {
            f4 = f(i4);
        }
        this.f30631w.insert(f4, z3);
        if (z3) {
            r(view);
        }
        this.f30630c.c(view, f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sr(View view) {
        int c4 = this.f30630c.c(view);
        if (c4 >= 0) {
            this.f30631w.c(c4);
            r(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w() {
        return this.f30630c.c() - this.xv.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(View view) {
        int c4 = this.f30630c.c(view);
        if (c4 == -1) {
            ev(view);
            return true;
        } else if (this.f30631w.xv(c4)) {
            this.f30631w.sr(c4);
            ev(view);
            this.f30630c.c(c4);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ux(View view) {
        int c4 = this.f30630c.c(view);
        if (c4 >= 0) {
            if (this.f30631w.xv(c4)) {
                this.f30631w.w(c4);
                ev(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(View view) {
        int c4 = this.f30630c.c(view);
        if (c4 == -1 || this.f30631w.xv(c4)) {
            return -1;
        }
        return c4 - this.f30631w.ux(c4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int xv() {
        return this.f30630c.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean xv(View view) {
        return this.xv.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view) {
        int c4 = this.f30630c.c(view);
        if (c4 >= 0) {
            if (this.f30631w.sr(c4)) {
                ev(view);
            }
            this.f30630c.c(c4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4) {
        int f4 = f(i4);
        View w3 = this.f30630c.w(f4);
        if (w3 != null) {
            if (this.f30631w.sr(f4)) {
                ev(w3);
            }
            this.f30630c.c(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f30631w.c();
        for (int size = this.xv.size() - 1; size >= 0; size--) {
            this.f30630c.sr(this.xv.get(size));
            this.xv.remove(size);
        }
        this.f30630c.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i4, ViewGroup.LayoutParams layoutParams, boolean z3) {
        int f4;
        if (i4 < 0) {
            f4 = this.f30630c.c();
        } else {
            f4 = f(i4);
        }
        this.f30631w.insert(f4, z3);
        if (z3) {
            r(view);
        }
        this.f30630c.c(view, f4, layoutParams);
    }
}
