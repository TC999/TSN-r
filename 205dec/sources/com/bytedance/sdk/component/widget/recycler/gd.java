package com.bytedance.sdk.component.widget.recycler;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends a {

    /* renamed from: w  reason: collision with root package name */
    private ev f30594w;
    private ev xv;

    private ev sr(RecyclerView.gd gdVar) {
        ev evVar = this.f30594w;
        if (evVar == null || evVar.f30589c != gdVar) {
            this.f30594w = ev.w(gdVar);
        }
        return this.f30594w;
    }

    private ev ux(RecyclerView.gd gdVar) {
        ev evVar = this.xv;
        if (evVar == null || evVar.f30589c != gdVar) {
            this.xv = ev.c(gdVar);
        }
        return this.xv;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    public int[] c(RecyclerView.gd gdVar, View view) {
        int[] iArr = new int[2];
        if (gdVar.xv()) {
            iArr[0] = c(gdVar, view, ux(gdVar));
        } else {
            iArr[0] = 0;
        }
        if (gdVar.sr()) {
            iArr[1] = c(gdVar, view, sr(gdVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    protected f w(RecyclerView.gd gdVar) {
        if (gdVar instanceof RecyclerView.fz.w) {
            return new f(this.f30560c.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.gd.1
                @Override // com.bytedance.sdk.component.widget.recycler.f, com.bytedance.sdk.component.widget.recycler.RecyclerView.fz
                protected void c(View view, RecyclerView.u uVar, RecyclerView.fz.c cVar) {
                    gd gdVar2 = gd.this;
                    int[] c4 = gdVar2.c(gdVar2.f30560c.getLayoutManager(), view);
                    int i4 = c4[0];
                    int i5 = c4[1];
                    int c5 = c(Math.max(Math.abs(i4), Math.abs(i5)));
                    if (c5 > 0) {
                        cVar.update(i4, i5, c5, ((f) this).f30593w);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.bytedance.sdk.component.widget.recycler.f
                public int w(int i4) {
                    return Math.min(100, super.w(i4));
                }

                @Override // com.bytedance.sdk.component.widget.recycler.f
                protected float c(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    private View w(RecyclerView.gd gdVar, ev evVar) {
        int i4 = gdVar.i();
        View view = null;
        if (i4 == 0) {
            return null;
        }
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < i4; i6++) {
            View ev = gdVar.ev(i6);
            int c4 = evVar.c(ev);
            if (c4 < i5) {
                view = ev;
                i5 = c4;
            }
        }
        return view;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    public View c(RecyclerView.gd gdVar) {
        if (gdVar.sr()) {
            return c(gdVar, sr(gdVar));
        }
        if (gdVar.xv()) {
            return c(gdVar, ux(gdVar));
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    public int c(RecyclerView.gd gdVar, int i4, int i5) {
        int sr;
        PointF xv;
        int eq = gdVar.eq();
        if (eq == 0) {
            return -1;
        }
        View view = null;
        if (gdVar.sr()) {
            view = w(gdVar, sr(gdVar));
        } else if (gdVar.xv()) {
            view = w(gdVar, ux(gdVar));
        }
        if (view == null || (sr = gdVar.sr(view)) == -1) {
            return -1;
        }
        boolean z3 = false;
        boolean z4 = !gdVar.xv() ? i5 <= 0 : i4 <= 0;
        if ((gdVar instanceof RecyclerView.fz.w) && (xv = ((RecyclerView.fz.w) gdVar).xv(eq - 1)) != null && (xv.x < 0.0f || xv.y < 0.0f)) {
            z3 = true;
        }
        return z3 ? z4 ? sr - 1 : sr : z4 ? sr + 1 : sr;
    }

    private int c(RecyclerView.gd gdVar, View view, ev evVar) {
        int ux;
        int c4 = evVar.c(view) + (evVar.ux(view) / 2);
        if (gdVar.ia()) {
            ux = evVar.xv() + (evVar.f() / 2);
        } else {
            ux = evVar.ux() / 2;
        }
        return c4 - ux;
    }

    private View c(RecyclerView.gd gdVar, ev evVar) {
        int ux;
        int i4 = gdVar.i();
        View view = null;
        if (i4 == 0) {
            return null;
        }
        if (gdVar.ia()) {
            ux = evVar.xv() + (evVar.f() / 2);
        } else {
            ux = evVar.ux() / 2;
        }
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < i4; i6++) {
            View ev = gdVar.ev(i6);
            int abs = Math.abs((evVar.c(ev) + (evVar.ux(ev) / 2)) - ux);
            if (abs < i5) {
                view = ev;
                i5 = abs;
            }
        }
        return view;
    }
}
