package com.bytedance.adsdk.lottie.xv.xv;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d extends a {
    private final RectF D;
    private final Paint E;
    private final float[] F;
    private final Path G;
    private final sr H;
    private com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.graphics.Paint, h0.a] */
    public d(com.bytedance.adsdk.lottie.d dVar, sr srVar) {
        super(dVar, srVar);
        this.D = new RectF();
        ?? aVar = new h0.a();
        this.E = aVar;
        this.F = new float[8];
        this.G = new Path();
        this.H = srVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(srVar.g());
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    public void B(Canvas canvas, Matrix matrix, int i4) {
        int alpha = Color.alpha(this.H.g());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i4 / 255.0f) * (((alpha / 255.0f) * (this.f25937x.a() == null ? 100 : this.f25937x.a().j().intValue())) / 100.0f) * 255.0f);
        this.E.setAlpha(intValue);
        com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> cVar = this.I;
        if (cVar != null) {
            this.E.setColorFilter(cVar.j());
        }
        if (intValue > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.H.r();
            float[] fArr2 = this.F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.H.r();
            this.F[5] = this.H.k();
            float[] fArr3 = this.F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.H.k();
            matrix.mapPoints(this.F);
            this.G.reset();
            Path path = this.G;
            float[] fArr4 = this.F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.G;
            float[] fArr5 = this.F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.G;
            float[] fArr6 = this.F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.G;
            float[] fArr7 = this.F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.G;
            float[] fArr8 = this.F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.G.close();
            canvas.drawPath(this.G, this.E);
        }
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a, com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        super.b(rectF, matrix, z3);
        this.D.set(0.0f, 0.0f, this.H.r(), this.H.k());
        this.f25928o.mapRect(this.D);
        rectF.set(this.D);
    }
}
