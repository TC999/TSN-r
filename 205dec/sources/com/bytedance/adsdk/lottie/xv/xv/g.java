package com.bytedance.adsdk.lottie.xv.xv;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.h;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class g extends a {
    private final Paint D;
    private final Rect E;
    private final Rect F;
    private final h G;
    private com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> H;
    private com.bytedance.adsdk.lottie.c.w.c<Bitmap, Bitmap> I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.Paint, h0.a] */
    public g(com.bytedance.adsdk.lottie.d dVar, sr srVar) {
        super(dVar, srVar);
        this.D = new h0.a(3);
        this.E = new Rect();
        this.F = new Rect();
        this.G = dVar.C(srVar.q());
    }

    private Bitmap K() {
        Bitmap j4;
        com.bytedance.adsdk.lottie.c.w.c<Bitmap, Bitmap> cVar = this.I;
        if (cVar == null || (j4 = cVar.j()) == null) {
            Bitmap e02 = this.f25929p.e0(this.f25930q.q());
            if (e02 != null) {
                return e02;
            }
            h hVar = this.G;
            if (hVar != null) {
                return hVar.d();
            }
            return null;
        }
        return j4;
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    public void B(Canvas canvas, Matrix matrix, int i4) {
        Bitmap K = K();
        if (K == null || K.isRecycled() || this.G == null) {
            return;
        }
        float a4 = com.bytedance.adsdk.lottie.f.b.a();
        this.D.setAlpha(i4);
        com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> cVar = this.H;
        if (cVar != null) {
            this.D.setColorFilter(cVar.j());
        }
        canvas.save();
        canvas.concat(matrix);
        this.E.set(0, 0, K.getWidth(), K.getHeight());
        if (this.f25929p.b0()) {
            this.F.set(0, 0, (int) (this.G.a() * a4), (int) (this.G.e() * a4));
        } else {
            this.F.set(0, 0, (int) (K.getWidth() * a4), (int) (K.getHeight() * a4));
        }
        canvas.drawBitmap(K, this.E, this.F, this.D);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a, com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        super.b(rectF, matrix, z3);
        if (this.G != null) {
            float a4 = com.bytedance.adsdk.lottie.f.b.a();
            rectF.set(0.0f, 0.0f, this.G.a() * a4, this.G.e() * a4);
            this.f25928o.mapRect(rectF);
        }
    }
}
