package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Pair;
import android.view.View;
import com.qq.e.dl.l.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class x extends com.qq.e.dl.l.a<b> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new x(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends View implements com.qq.e.dl.l.e<x> {

        /* renamed from: c  reason: collision with root package name */
        private final float[] f42631c;

        /* renamed from: d  reason: collision with root package name */
        private final RectF f42632d;

        /* renamed from: e  reason: collision with root package name */
        private final Paint f42633e;

        /* renamed from: f  reason: collision with root package name */
        private final Path f42634f;

        /* renamed from: g  reason: collision with root package name */
        private int f42635g;

        /* renamed from: h  reason: collision with root package name */
        private int f42636h;

        /* renamed from: i  reason: collision with root package name */
        private int f42637i;

        /* renamed from: j  reason: collision with root package name */
        private int f42638j;

        /* renamed from: k  reason: collision with root package name */
        private float f42639k;

        /* renamed from: l  reason: collision with root package name */
        private x f42640l;

        public b(Context context) {
            super(context);
            this.f42631c = new float[]{0.0f, 360.0f, 360.0f, 180.0f};
            this.f42632d = new RectF();
            this.f42633e = new Paint();
            this.f42634f = new Path();
        }

        private void b(Canvas canvas) {
            this.f42633e.reset();
            this.f42633e.setAntiAlias(true);
            this.f42633e.setDither(true);
            this.f42633e.setColor(this.f42637i);
            this.f42633e.setStyle(Paint.Style.STROKE);
            this.f42633e.setStrokeCap(Paint.Cap.ROUND);
            this.f42633e.setStrokeWidth(this.f42638j);
            float f4 = this.f42631c[2] * this.f42639k;
            canvas.drawArc(this.f42632d, a() ? this.f42631c[0] : this.f42631c[3] - (f4 / 2.0f), f4, false, this.f42633e);
        }

        void c(int i4) {
            this.f42635g = i4;
            postInvalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float f4 = this.f42638j * 1.5f;
            float min = Math.min(getWidth(), getHeight()) - (f4 * 2.0f);
            float f5 = min / 2.0f;
            RectF rectF = this.f42632d;
            rectF.top = f4;
            rectF.left = f4;
            float f6 = min + f4;
            rectF.right = f6;
            rectF.bottom = f6;
            a(canvas);
            if (b()) {
                a(canvas, f5, f4);
            }
            if (this.f42639k > 0.0f) {
                b(canvas);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i4, int i5) {
            com.qq.e.dl.l.k.a i6 = this.f42640l.i();
            Pair<Integer, Integer> d4 = i6.d(i4, i5);
            super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
            Pair<Integer, Integer> c4 = i6.c(i4, i5);
            if (c4 != null) {
                super.onMeasure(((Integer) c4.first).intValue(), ((Integer) c4.second).intValue());
            }
        }

        @Override // android.view.View
        public void setBackgroundColor(int i4) {
            this.f42636h = i4;
            postInvalidate();
        }

        private void a(Canvas canvas) {
            this.f42633e.reset();
            this.f42633e.setAntiAlias(true);
            this.f42633e.setDither(true);
            this.f42633e.setColor(this.f42636h);
            this.f42633e.setStyle(Paint.Style.STROKE);
            this.f42633e.setStrokeCap(b() ? Paint.Cap.BUTT : Paint.Cap.ROUND);
            this.f42633e.setStrokeWidth(this.f42638j);
            RectF rectF = this.f42632d;
            float[] fArr = this.f42631c;
            canvas.drawArc(rectF, fArr[0], fArr[2], false, this.f42633e);
        }

        private void a(Canvas canvas, float f4, float f5) {
            this.f42633e.reset();
            this.f42633e.setAntiAlias(true);
            this.f42633e.setDither(true);
            this.f42633e.setColor(this.f42639k >= 1.0f ? this.f42637i : this.f42636h);
            this.f42633e.setStyle(Paint.Style.FILL);
            this.f42633e.setStrokeWidth(1.0f);
            a(this.f42634f, f4, f5, this.f42631c[0], true);
            canvas.drawPath(this.f42634f, this.f42633e);
            a(this.f42634f, f4, f5, this.f42631c[1], false);
            canvas.drawPath(this.f42634f, this.f42633e);
        }

        private boolean b() {
            return this.f42635g == 1;
        }

        void b(int i4) {
            this.f42638j = i4;
            postInvalidate();
        }

        private void a(Path path, float f4, float f5, double d4, boolean z3) {
            double d5 = (d4 * 3.141592653589793d) / 180.0d;
            float cos = (float) Math.cos(d5);
            float sin = (float) Math.sin(d5);
            float f6 = f4 * cos;
            float f7 = f4 * sin;
            float f8 = f4 + f5;
            float f9 = f8 * cos;
            float f10 = f8 * sin;
            float f11 = f4 - f5;
            float f12 = f11 * cos;
            float f13 = f11 * sin;
            float f14 = sin * f5;
            float f15 = z3 ? f6 + f14 : f6 - f14;
            float f16 = f5 * cos;
            float f17 = z3 ? f7 - f16 : f7 + f16;
            float centerX = this.f42632d.centerX();
            float centerY = this.f42632d.centerY();
            path.reset();
            path.moveTo(f15 + centerX, f17 + centerY);
            path.lineTo(f9 + centerX, f10 + centerY);
            path.lineTo(f12 + centerX, f13 + centerY);
            path.close();
        }

        private boolean a() {
            return this.f42635g == 2;
        }

        void a(float f4, float f5) {
            float[] fArr = this.f42631c;
            fArr[0] = f4;
            fArr[1] = f5;
            float f6 = f5 - f4;
            fArr[2] = f6;
            fArr[3] = f4 + (f6 / 2.0f);
            postInvalidate();
        }

        void a(float f4) {
            this.f42639k = f4;
            postInvalidate();
        }

        void a(int i4) {
            this.f42637i = i4;
            postInvalidate();
        }

        @Override // com.qq.e.dl.l.e
        public void a(x xVar) {
            this.f42640l = xVar;
        }
    }

    public x(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public b a(com.qq.e.dl.a aVar) {
        return new b(aVar.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == -1640131257) {
            if (str.equals("renderRange")) {
                c4 = 2;
            }
            c4 = '\uffff';
        } else if (hashCode == -968653863) {
            if (str.equals("progressf")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else if (hashCode == 1573) {
            if (str.equals("16")) {
                c4 = 3;
            }
            c4 = '\uffff';
        } else if (hashCode == 109780401) {
            if (str.equals("style")) {
                c4 = 1;
            }
            c4 = '\uffff';
        } else if (hashCode != 1575) {
            if (hashCode == 1576 && str.equals("19")) {
                c4 = 4;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("18")) {
                c4 = 5;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            ((b) this.f47039w).a(gVar.d(new JSONObject[0]));
        } else if (c4 == 1) {
            ((b) this.f47039w).c(gVar.b(new JSONObject[0]));
        } else if (c4 != 2) {
            if (c4 == 3) {
                ((b) this.f47039w).setBackgroundColor(com.qq.e.dl.k.n.a(gVar));
            } else if (c4 == 4) {
                ((b) this.f47039w).a(com.qq.e.dl.k.n.a(gVar));
            } else if (c4 != 5) {
                return super.a(str, gVar);
            } else {
                ((b) this.f47039w).b(gVar.f(new JSONObject[0]).d());
            }
        } else if (gVar.c(new JSONObject[0]) instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) gVar.c(new JSONObject[0]);
            ((b) this.f47039w).a((float) jSONArray.optDouble(0, 0.0d), (float) jSONArray.optDouble(1, 360.0d));
        }
        return true;
    }
}
