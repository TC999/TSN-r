package com.bytedance.adsdk.lottie.xv.xv;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.c.c.o;
import com.bytedance.adsdk.lottie.s;
import java.util.Collections;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends a {
    private final o D;
    private final f E;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.bytedance.adsdk.lottie.d dVar, sr srVar, f fVar, com.bytedance.adsdk.lottie.e eVar) {
        super(dVar, srVar);
        this.E = fVar;
        o oVar = new o(dVar, this, new com.bytedance.adsdk.lottie.xv.w.e("__container", srVar.t(), false), eVar);
        this.D = oVar;
        oVar.c(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    void B(Canvas canvas, Matrix matrix, int i4) {
        this.D.a(canvas, matrix, i4);
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a, com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        super.b(rectF, matrix, z3);
        this.D.b(rectF, this.f25928o, z3);
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    public com.bytedance.adsdk.lottie.xv.w.c q() {
        com.bytedance.adsdk.lottie.xv.w.c q3 = super.q();
        return q3 != null ? q3 : this.E.q();
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    public s.w u() {
        s.w u3 = super.u();
        return u3 != null ? u3 : this.E.u();
    }
}
