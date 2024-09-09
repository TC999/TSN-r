package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.gd;
import com.bytedance.sdk.component.widget.recycler.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends ux {
    private final gd fz;
    private c gb;

    /* renamed from: i  reason: collision with root package name */
    private int f32305i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f32306j;
    private int ls;

    /* renamed from: n  reason: collision with root package name */
    private final RecyclerView.k f32307n;

    /* renamed from: q  reason: collision with root package name */
    private boolean f32308q;

    /* renamed from: s  reason: collision with root package name */
    public boolean f32309s;

    /* renamed from: u  reason: collision with root package name */
    private int f32310u;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(boolean z3, int i4);

        void c(boolean z3, int i4, boolean z4);
    }

    public xv(Context context, int i4, boolean z3) {
        super(context, i4, z3);
        this.f32308q = false;
        this.f32309s = true;
        this.f32306j = true;
        this.f32307n = new RecyclerView.k() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xv.1
            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
            public void c(View view) {
                if (xv.this.gb == null || xv.this.i() != 1) {
                    return;
                }
                xv.this.gb.c();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
            public void w(View view) {
                if (xv.this.gb != null) {
                    xv.this.gb.c(xv.this.f32310u >= 0, xv.this.sr(view));
                }
            }
        };
        this.fz = new gd();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void k(int i4) {
        boolean z3;
        c cVar;
        this.f32305i = i4;
        if (i4 == 0) {
            View c4 = this.fz.c(this);
            if (c4 != null) {
                int sr = sr(c4);
                z3 = this.ls == sr;
                this.ls = sr;
            } else {
                z3 = true;
            }
            if (this.f32308q) {
                this.f32308q = false;
                this.f32306j = this.f32309s;
                if (!z3 && (cVar = this.gb) != null) {
                    boolean z4 = this.f32310u >= 0;
                    int i5 = this.ls;
                    cVar.c(z4, i5, i5 == eq() - 1);
                }
            }
        }
        if (i4 == 2) {
            this.f32308q = true;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ux, com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public boolean sr() {
        return this.f32306j;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void xv(RecyclerView recyclerView) {
        super.xv(recyclerView);
        this.fz.c(recyclerView);
        recyclerView.c(this.f32307n);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ux, com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void c(RecyclerView recyclerView, RecyclerView.fp fpVar) {
        super.c(recyclerView, fpVar);
        try {
            sr srVar = (sr) recyclerView.sr(this.ls);
            if (srVar != null) {
                srVar.xv();
            }
        } catch (Exception e4) {
            a.xv("cubic detached exception:" + e4.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ux, com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int w(int i4, RecyclerView.fp fpVar, RecyclerView.u uVar) {
        this.f32310u = i4;
        return super.w(i4, fpVar, uVar);
    }

    public void xv(boolean z3) {
        this.f32309s = z3;
        if (z3 || this.f32305i == 0) {
            this.f32306j = z3;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ux, com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int c(int i4, RecyclerView.fp fpVar, RecyclerView.u uVar) {
        this.f32310u = i4;
        return super.c(i4, fpVar, uVar);
    }

    public void c(c cVar) {
        this.gb = cVar;
    }
}
