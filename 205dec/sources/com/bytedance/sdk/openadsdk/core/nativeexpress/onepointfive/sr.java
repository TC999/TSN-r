package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.a;
import com.bytedance.sdk.component.widget.recycler.ev;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends a {
    private int sr = 0;
    private boolean ux = false;

    /* renamed from: w  reason: collision with root package name */
    private ev f34161w;
    private RecyclerView xv;

    private ev sr(RecyclerView.gd gdVar) {
        if (this.f34161w == null) {
            this.f34161w = ev.c(gdVar);
        }
        return this.f34161w;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    protected com.bytedance.sdk.component.widget.recycler.f w(RecyclerView.gd gdVar) {
        if (gdVar instanceof RecyclerView.fz.w) {
            return new com.bytedance.sdk.component.widget.recycler.f(this.xv.getContext()) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.sr.1
                @Override // com.bytedance.sdk.component.widget.recycler.f, com.bytedance.sdk.component.widget.recycler.RecyclerView.fz
                protected void c(View view, RecyclerView.u uVar, RecyclerView.fz.c cVar) {
                    sr srVar = sr.this;
                    int[] c4 = srVar.c(srVar.xv.getLayoutManager(), view);
                    int i4 = c4[0];
                    int i5 = c4[1];
                    int c5 = c(Math.max(Math.abs(i4), Math.abs(i5)));
                    if (c5 > 0) {
                        cVar.update(i4, i5, c5, ((com.bytedance.sdk.component.widget.recycler.f) this).f30593w);
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.f
                protected float c(DisplayMetrics displayMetrics) {
                    return 30.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    public void c(RecyclerView recyclerView) throws IllegalStateException {
        try {
            this.xv = recyclerView;
            super.c(recyclerView);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private float w(RecyclerView.gd gdVar, ev evVar) {
        int i4 = gdVar.i();
        if (i4 == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        for (int i7 = 0; i7 < i4; i7++) {
            View ev = gdVar.ev(i7);
            int sr = gdVar.sr(ev);
            if (sr != -1) {
                if (sr < i5) {
                    view = ev;
                    i5 = sr;
                }
                if (sr > i6) {
                    view2 = ev;
                    i6 = sr;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(evVar.w(view), evVar.w(view2)) - Math.min(evVar.c(view), evVar.c(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i6 - i5) + 1);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    public int[] c(RecyclerView.gd gdVar, View view) {
        int[] iArr = new int[2];
        if (gdVar.xv()) {
            iArr[0] = c(view, sr(gdVar));
        } else {
            iArr[0] = 0;
        }
        return iArr;
    }

    private int c(View view, ev evVar) {
        return evVar.c(view) - evVar.xv();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    public int c(RecyclerView.gd gdVar, int i4, int i5) {
        int eq;
        View c4;
        int sr;
        int i6;
        PointF xv;
        int i7;
        if (!(gdVar instanceof RecyclerView.fz.w) || (eq = gdVar.eq()) == 0 || (c4 = c(gdVar)) == null || (sr = gdVar.sr(c4)) == -1 || (xv = ((RecyclerView.fz.w) gdVar).xv(eq - 1)) == null) {
            return -1;
        }
        int ls = gdVar.ls() / sr(gdVar).ux(c4);
        if (gdVar.xv()) {
            i7 = c(gdVar, sr(gdVar), i4, 0);
            if (i7 > ls) {
                i7 = ls;
            }
            int i8 = -ls;
            if (i7 < i8) {
                i7 = i8;
            }
            if (xv.x < 0.0f) {
                i7 = -i7;
            }
        } else {
            i7 = 0;
        }
        if (i7 == 0) {
            return -1;
        }
        int i9 = sr + i7;
        int i10 = i9 >= 0 ? i9 : 0;
        return i10 >= eq ? i6 : i10;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.a
    public View c(RecyclerView.gd gdVar) {
        return c(gdVar, sr(gdVar));
    }

    private View c(RecyclerView.gd gdVar, ev evVar) {
        com.bytedance.sdk.component.widget.recycler.ux uxVar;
        int p3;
        if (!(gdVar instanceof com.bytedance.sdk.component.widget.recycler.ux) || (p3 = (uxVar = (com.bytedance.sdk.component.widget.recycler.ux) gdVar).p()) == -1 || uxVar.bk() == gdVar.eq() - 1) {
            return null;
        }
        View w3 = gdVar.w(p3);
        return (evVar.w(w3) < evVar.ux(w3) / 2 || evVar.w(w3) <= 0) ? gdVar.w(p3 + 1) : w3;
    }

    private int c(RecyclerView.gd gdVar, ev evVar, int i4, int i5) {
        double ceil;
        int[] w3 = w(i4, i5);
        float w4 = w(gdVar, evVar);
        if (w4 <= 0.0f) {
            return 0;
        }
        int i6 = w3[0];
        if (i6 > 0) {
            ceil = Math.floor(i6 / w4);
        } else {
            ceil = Math.ceil(i6 / w4);
        }
        return (int) ceil;
    }
}
