package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class a extends RecyclerView.a {

    /* renamed from: c  reason: collision with root package name */
    RecyclerView f30560c;

    /* renamed from: w  reason: collision with root package name */
    private Scroller f30561w;
    private final RecyclerView.t xv = new RecyclerView.t() { // from class: com.bytedance.sdk.component.widget.recycler.a.1

        /* renamed from: c  reason: collision with root package name */
        boolean f30562c = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
        public void c(RecyclerView recyclerView, int i4) {
            super.c(recyclerView, i4);
            if (i4 == 0 && this.f30562c) {
                this.f30562c = false;
                a.this.c();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
        public void c(RecyclerView recyclerView, int i4, int i5) {
            if (i4 == 0 && i5 == 0) {
                return;
            }
            this.f30562c = true;
        }
    };

    private void w() throws IllegalStateException {
        if (this.f30560c.getOnFlingListener() == null) {
            this.f30560c.c(this.xv);
            this.f30560c.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private void xv() {
        this.f30560c.w(this.xv);
        this.f30560c.setOnFlingListener(null);
    }

    public abstract int c(RecyclerView.gd gdVar, int i4, int i5);

    public abstract View c(RecyclerView.gd gdVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public boolean c(int i4, int i5) {
        RecyclerView.gd layoutManager = this.f30560c.getLayoutManager();
        if (layoutManager == null || this.f30560c.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f30560c.getMinFlingVelocity();
        return (Math.abs(i5) > minFlingVelocity || Math.abs(i4) > minFlingVelocity) && w(layoutManager, i4, i5);
    }

    public abstract int[] c(RecyclerView.gd gdVar, View view);

    protected RecyclerView.fz xv(RecyclerView.gd gdVar) {
        return w(gdVar);
    }

    public void c(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f30560c;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                xv();
            }
            this.f30560c = recyclerView;
            if (recyclerView != null) {
                w();
                this.f30561w = new Scroller(this.f30560c.getContext(), new DecelerateInterpolator());
                c();
            }
        }
    }

    public int[] w(int i4, int i5) {
        this.f30561w.fling(0, 0, i4, i5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f30561w.getFinalX(), this.f30561w.getFinalY()};
    }

    private boolean w(RecyclerView.gd gdVar, int i4, int i5) {
        RecyclerView.fz xv;
        int c4;
        if (!(gdVar instanceof RecyclerView.fz.w) || (xv = xv(gdVar)) == null || (c4 = c(gdVar, i4, i5)) == -1) {
            return false;
        }
        xv.xv(c4);
        gdVar.c(xv);
        return true;
    }

    void c() {
        RecyclerView.gd layoutManager;
        View c4;
        RecyclerView recyclerView = this.f30560c;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (c4 = c(layoutManager)) == null) {
            return;
        }
        int[] c5 = c(layoutManager, c4);
        if (c5[0] == 0 && c5[1] == 0) {
            return;
        }
        this.f30560c.c(c5[0], c5[1]);
    }

    @Deprecated
    protected f w(RecyclerView.gd gdVar) {
        if (gdVar instanceof RecyclerView.fz.w) {
            return new f(this.f30560c.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.a.2
                @Override // com.bytedance.sdk.component.widget.recycler.f, com.bytedance.sdk.component.widget.recycler.RecyclerView.fz
                protected void c(View view, RecyclerView.u uVar, RecyclerView.fz.c cVar) {
                    a aVar = a.this;
                    RecyclerView recyclerView = aVar.f30560c;
                    if (recyclerView != null) {
                        int[] c4 = aVar.c(recyclerView.getLayoutManager(), view);
                        int i4 = c4[0];
                        int i5 = c4[1];
                        int c5 = c(Math.max(Math.abs(i4), Math.abs(i5)));
                        if (c5 > 0) {
                            cVar.update(i4, i5, c5, ((f) this).f30593w);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.f
                protected float c(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
