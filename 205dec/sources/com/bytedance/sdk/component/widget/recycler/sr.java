package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    static final ThreadLocal<sr> f30597c = new ThreadLocal<>();
    static Comparator<w> ux = new Comparator<w>() { // from class: com.bytedance.sdk.component.widget.recycler.sr.1
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(w wVar, w wVar2) {
            RecyclerView recyclerView = wVar.sr;
            if ((recyclerView == null) != (wVar2.sr == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z3 = wVar.f30602c;
            if (z3 != wVar2.f30602c) {
                return z3 ? -1 : 1;
            }
            int i4 = wVar2.f30603w - wVar.f30603w;
            if (i4 != 0) {
                return i4;
            }
            int i5 = wVar.xv - wVar2.xv;
            if (i5 != 0) {
                return i5;
            }
            return 0;
        }
    };
    long sr;
    long xv;

    /* renamed from: w  reason: collision with root package name */
    ArrayList<RecyclerView> f30599w = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<w> f30598f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        public boolean f30602c;
        public RecyclerView sr;
        public int ux;

        /* renamed from: w  reason: collision with root package name */
        public int f30603w;
        public int xv;

        w() {
        }

        public void c() {
            this.f30602c = false;
            this.f30603w = 0;
            this.xv = 0;
            this.sr = null;
            this.ux = 0;
        }
    }

    public void c(RecyclerView recyclerView) {
        this.f30599w.add(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV Prefetch");
            if (!this.f30599w.isEmpty()) {
                int size = this.f30599w.size();
                long j4 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    RecyclerView recyclerView = this.f30599w.get(i4);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j4 = Math.max(recyclerView.getDrawingTime(), j4);
                    }
                }
                if (j4 != 0) {
                    c(TimeUnit.MILLISECONDS.toNanos(j4) + this.sr);
                }
            }
        } finally {
            this.xv = 0L;
            com.bytedance.sdk.component.widget.recycler.c.c.c.c();
        }
    }

    public void w(RecyclerView recyclerView) {
        this.f30599w.remove(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements RecyclerView.gd.c {

        /* renamed from: c  reason: collision with root package name */
        int f30600c;
        int sr;

        /* renamed from: w  reason: collision with root package name */
        int f30601w;
        int[] xv;

        void c(int i4, int i5) {
            this.f30600c = i4;
            this.f30601w = i5;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd.c
        public void w(int i4, int i5) {
            if (i4 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i5 >= 0) {
                int i6 = this.sr * 2;
                int[] iArr = this.xv;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.xv = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i6 >= iArr.length) {
                    int[] iArr3 = new int[i6 * 2];
                    this.xv = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.xv;
                iArr4[i6] = i4;
                iArr4[i6 + 1] = i5;
                this.sr++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        void c(RecyclerView recyclerView, boolean z3) {
            this.sr = 0;
            int[] iArr = this.xv;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.gd gdVar = recyclerView.f30492t;
            if (recyclerView.bk == null || gdVar == null || !gdVar.fp()) {
                return;
            }
            if (z3) {
                if (!recyclerView.f30480f.sr()) {
                    gdVar.c(recyclerView.bk.c(), this);
                }
            } else if (!recyclerView.i()) {
                gdVar.c(this.f30600c, this.f30601w, recyclerView.ba, this);
            }
            int i4 = this.sr;
            if (i4 > gdVar.fp) {
                gdVar.fp = i4;
                gdVar.ia = z3;
                recyclerView.ux.w();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(int i4) {
            if (this.xv != null) {
                int i5 = this.sr * 2;
                for (int i6 = 0; i6 < i5; i6 += 2) {
                    if (this.xv[i6] == i4) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            int[] iArr = this.xv;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.sr = 0;
        }
    }

    private void w(long j4) {
        for (int i4 = 0; i4 < this.f30598f.size(); i4++) {
            w wVar = this.f30598f.get(i4);
            if (wVar.sr == null) {
                return;
            }
            c(wVar, j4);
            wVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView recyclerView, int i4, int i5) {
        if (recyclerView.isAttachedToWindow() && this.xv == 0) {
            this.xv = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f30495z.c(i4, i5);
    }

    private void c() {
        w wVar;
        int size = this.f30599w.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView = this.f30599w.get(i5);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f30495z.c(recyclerView, false);
                i4 += recyclerView.f30495z.sr;
            }
        }
        this.f30598f.ensureCapacity(i4);
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView2 = this.f30599w.get(i7);
            if (recyclerView2.getWindowVisibility() == 0) {
                c cVar = recyclerView2.f30495z;
                int abs = Math.abs(cVar.f30600c) + Math.abs(cVar.f30601w);
                for (int i8 = 0; i8 < cVar.sr * 2; i8 += 2) {
                    if (i6 >= this.f30598f.size()) {
                        wVar = new w();
                        this.f30598f.add(wVar);
                    } else {
                        wVar = this.f30598f.get(i6);
                    }
                    int[] iArr = cVar.xv;
                    int i9 = iArr[i8 + 1];
                    wVar.f30602c = i9 <= abs;
                    wVar.f30603w = abs;
                    wVar.xv = i9;
                    wVar.sr = recyclerView2;
                    wVar.ux = iArr[i8];
                    i6++;
                }
            }
        }
        Collections.sort(this.f30598f, ux);
    }

    static boolean c(RecyclerView recyclerView, int i4) {
        int xv = recyclerView.f30490r.xv();
        for (int i5 = 0; i5 < xv; i5++) {
            RecyclerView.j ux2 = RecyclerView.ux(recyclerView.f30490r.sr(i5));
            if (ux2.f30533f == i4 && !ux2.s()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.j c(RecyclerView recyclerView, int i4, long j4) {
        if (c(recyclerView, i4)) {
            return null;
        }
        RecyclerView.fp fpVar = recyclerView.ux;
        try {
            recyclerView.a();
            RecyclerView.j c4 = fpVar.c(i4, false, j4);
            if (c4 != null) {
                if (c4.u() && !c4.s()) {
                    fpVar.c(c4.sr);
                } else {
                    fpVar.c(c4, false);
                }
            }
            return c4;
        } finally {
            recyclerView.w(false);
        }
    }

    private void c(RecyclerView recyclerView, long j4) {
        if (recyclerView != null) {
            if (recyclerView.f30484j && recyclerView.f30490r.xv() != 0) {
                recyclerView.xv();
            }
            c cVar = recyclerView.f30495z;
            cVar.c(recyclerView, true);
            if (cVar.sr != 0) {
                try {
                    com.bytedance.sdk.component.widget.recycler.c.c.c.c("RV Nested Prefetch");
                    recyclerView.ba.c(recyclerView.bk);
                    for (int i4 = 0; i4 < cVar.sr * 2; i4 += 2) {
                        c(recyclerView, cVar.xv[i4], j4);
                    }
                } finally {
                    com.bytedance.sdk.component.widget.recycler.c.c.c.c();
                }
            }
        }
    }

    private void c(w wVar, long j4) {
        RecyclerView.j c4 = c(wVar.sr, wVar.ux, wVar.f30602c ? Long.MAX_VALUE : j4);
        if (c4 == null || c4.ux == null || !c4.u() || c4.s()) {
            return;
        }
        c(c4.ux.get(), j4);
    }

    void c(long j4) {
        c();
        w(j4);
    }
}
