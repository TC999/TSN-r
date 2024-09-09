package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends RecyclerView.fz {

    /* renamed from: f  reason: collision with root package name */
    private final float f30592f;
    protected PointF xv;

    /* renamed from: c  reason: collision with root package name */
    protected final LinearInterpolator f30591c = new LinearInterpolator();

    /* renamed from: w  reason: collision with root package name */
    protected final DecelerateInterpolator f30593w = new DecelerateInterpolator();
    protected int sr = 0;
    protected int ux = 0;

    public f(Context context) {
        this.f30592f = c(context.getResources().getDisplayMetrics());
    }

    private int w(int i4, int i5) {
        int i6 = i4 - i5;
        if (i4 * i6 <= 0) {
            return 0;
        }
        return i6;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fz
    protected void c() {
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fz
    protected void c(View view, RecyclerView.u uVar, RecyclerView.fz.c cVar) {
        int w3 = w(view, xv());
        int c4 = c(view, sr());
        int c5 = c((int) Math.sqrt((w3 * w3) + (c4 * c4)));
        if (c5 > 0) {
            cVar.update(-w3, -c4, c5, this.f30593w);
        }
    }

    protected int sr() {
        PointF pointF = this.xv;
        if (pointF != null) {
            float f4 = pointF.y;
            if (f4 != 0.0f) {
                return f4 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fz
    protected void w() {
        this.ux = 0;
        this.sr = 0;
        this.xv = null;
    }

    protected int xv() {
        PointF pointF = this.xv;
        if (pointF != null) {
            float f4 = pointF.x;
            if (f4 != 0.0f) {
                return f4 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w(int i4) {
        return (int) Math.ceil(Math.abs(i4) * this.f30592f);
    }

    public int w(View view, int i4) {
        RecyclerView.gd ux = ux();
        if (ux == null || !ux.xv()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return c(ux.r(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, ux.gd(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, ux.n(), ux.ls() - ux.z(), i4);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fz
    protected void c(int i4, int i5, RecyclerView.u uVar, RecyclerView.fz.c cVar) {
        if (p() == 0) {
            f();
            return;
        }
        this.sr = w(this.sr, i4);
        int w3 = w(this.ux, i5);
        this.ux = w3;
        if (this.sr == 0 && w3 == 0) {
            c(cVar);
        }
    }

    protected float c(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(int i4) {
        double w3 = w(i4);
        Double.isNaN(w3);
        return (int) Math.ceil(w3 / 0.3356d);
    }

    protected void c(RecyclerView.fz.c cVar) {
        PointF sr = sr(gd());
        if (sr != null && (sr.x != 0.0f || sr.y != 0.0f)) {
            c(sr);
            this.xv = sr;
            this.sr = (int) (sr.x * 10000.0f);
            this.ux = (int) (sr.y * 10000.0f);
            cVar.update((int) (this.sr * 1.2f), (int) (this.ux * 1.2f), (int) (w(10000) * 1.2f), this.f30591c);
            return;
        }
        cVar.c(gd());
        f();
    }

    public int c(int i4, int i5, int i6, int i7, int i8) {
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 == 1) {
                    return i7 - i5;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i9 = i6 - i4;
            if (i9 > 0) {
                return i9;
            }
            int i10 = i7 - i5;
            if (i10 < 0) {
                return i10;
            }
            return 0;
        }
        return i6 - i4;
    }

    public int c(View view, int i4) {
        RecyclerView.gd ux = ux();
        if (ux == null || !ux.sr()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return c(ux.ev(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, ux.p(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, ux.ck(), ux.gb() - ux.ba(), i4);
    }
}
