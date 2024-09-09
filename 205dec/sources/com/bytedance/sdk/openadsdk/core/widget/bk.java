package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private int f35384c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f35385f;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private Paint f35386k;

    /* renamed from: p  reason: collision with root package name */
    private RectF f35387p;

    /* renamed from: r  reason: collision with root package name */
    private int f35388r;
    private float[] sr;
    private LinearGradient ux;

    /* renamed from: w  reason: collision with root package name */
    private int f35389w;
    private int[] xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {
        private int ev;
        private int gd;
        private float[] sr;
        private LinearGradient ux;
        private int[] xv;

        /* renamed from: c  reason: collision with root package name */
        private int f35390c = i.r(ls.getContext(), "tt_ssxinmian8");

        /* renamed from: w  reason: collision with root package name */
        private int f35393w = i.r(ls.getContext(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        private int f35391f = 10;

        /* renamed from: r  reason: collision with root package name */
        private int f35392r = 16;

        public c() {
            this.ev = 0;
            this.gd = 0;
            this.ev = 0;
            this.gd = 0;
        }

        public c c(int i4) {
            this.f35390c = i4;
            return this;
        }

        public c sr(int i4) {
            this.ev = i4;
            return this;
        }

        public c ux(int i4) {
            this.gd = i4;
            return this;
        }

        public c w(int i4) {
            this.f35393w = i4;
            return this;
        }

        public c xv(int i4) {
            this.f35391f = i4;
            return this;
        }

        public c c(int[] iArr) {
            this.xv = iArr;
            return this;
        }

        public bk c() {
            return new bk(this.f35390c, this.xv, this.sr, this.f35393w, this.ux, this.f35391f, this.f35392r, this.ev, this.gd);
        }
    }

    public bk(int i4, int[] iArr, float[] fArr, int i5, LinearGradient linearGradient, int i6, int i7, int i8, int i9) {
        this.f35384c = i4;
        this.xv = iArr;
        this.sr = fArr;
        this.f35389w = i5;
        this.ux = linearGradient;
        this.f35385f = i6;
        this.f35388r = i7;
        this.ev = i8;
        this.gd = i9;
    }

    private void c() {
        int[] iArr;
        Paint paint = new Paint();
        this.f35386k = paint;
        boolean z3 = true;
        paint.setAntiAlias(true);
        this.f35386k.setShadowLayer(this.f35388r, this.ev, this.gd, this.f35389w);
        if (this.f35387p != null && (iArr = this.xv) != null && iArr.length > 1) {
            float[] fArr = this.sr;
            z3 = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.f35386k;
            LinearGradient linearGradient = this.ux;
            if (linearGradient == null) {
                RectF rectF = this.f35387p;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.xv, z3 ? this.sr : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.f35386k.setColor(this.f35384c);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f35387p == null) {
            Rect bounds = getBounds();
            int i4 = bounds.left;
            int i5 = this.f35388r;
            int i6 = this.ev;
            int i7 = this.gd;
            this.f35387p = new RectF((i4 + i5) - i6, (bounds.top + i5) - i7, (bounds.right - i5) - i6, (bounds.bottom - i5) - i7);
        }
        if (this.f35386k == null) {
            c();
        }
        RectF rectF = this.f35387p;
        int i8 = this.f35385f;
        canvas.drawRoundRect(rectF, i8, i8, this.f35386k);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        Paint paint = this.f35386k;
        if (paint != null) {
            paint.setAlpha(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.f35386k;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void c(View view, c cVar) {
        if (view == null || cVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(cVar.c());
    }
}
