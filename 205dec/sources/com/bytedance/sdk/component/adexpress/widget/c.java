package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Interpolator {

    /* renamed from: c  reason: collision with root package name */
    protected PointF f29649c;
    protected PointF sr;
    protected PointF ux;

    /* renamed from: w  reason: collision with root package name */
    protected PointF f29650w;
    protected PointF xv;

    public c(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.xv = new PointF();
        this.sr = new PointF();
        this.ux = new PointF();
        float f4 = pointF.x;
        if (f4 >= 0.0f && f4 <= 1.0f) {
            float f5 = pointF2.x;
            if (f5 >= 0.0f && f5 <= 1.0f) {
                this.f29649c = pointF;
                this.f29650w = pointF2;
                return;
            }
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    private float sr(float f4) {
        PointF pointF = this.ux;
        PointF pointF2 = this.f29649c;
        float f5 = pointF2.x * 3.0f;
        pointF.x = f5;
        PointF pointF3 = this.sr;
        float f6 = ((this.f29650w.x - pointF2.x) * 3.0f) - f5;
        pointF3.x = f6;
        PointF pointF4 = this.xv;
        float f7 = (1.0f - pointF.x) - f6;
        pointF4.x = f7;
        return f4 * (pointF.x + ((pointF3.x + (f7 * f4)) * f4));
    }

    private float xv(float f4) {
        return this.ux.x + (f4 * ((this.sr.x * 2.0f) + (this.xv.x * 3.0f * f4)));
    }

    protected float c(float f4) {
        PointF pointF = this.ux;
        PointF pointF2 = this.f29649c;
        float f5 = pointF2.y * 3.0f;
        pointF.y = f5;
        PointF pointF3 = this.sr;
        float f6 = ((this.f29650w.y - pointF2.y) * 3.0f) - f5;
        pointF3.y = f6;
        PointF pointF4 = this.xv;
        float f7 = (1.0f - pointF.y) - f6;
        pointF4.y = f7;
        return f4 * (pointF.y + ((pointF3.y + (f7 * f4)) * f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        return c(w(f4));
    }

    protected float w(float f4) {
        float f5 = f4;
        for (int i4 = 1; i4 < 14; i4++) {
            float sr = sr(f5) - f4;
            if (Math.abs(sr) < 0.001d) {
                break;
            }
            f5 -= sr / xv(f5);
        }
        return f5;
    }

    public c(float f4, float f5, float f6, float f7) {
        this(new PointF(f4, f5), new PointF(f6, f7));
    }
}
