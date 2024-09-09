package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import java.util.ArrayList;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class StoreHouseHeader extends View implements e {

    /* renamed from: u  reason: collision with root package name */
    private static final float f47572u = 0.7f;

    /* renamed from: v  reason: collision with root package name */
    private static final float f47573v = 0.4f;

    /* renamed from: w  reason: collision with root package name */
    private static final float f47574w = 1.0f;

    /* renamed from: x  reason: collision with root package name */
    private static final float f47575x = 0.4f;

    /* renamed from: y  reason: collision with root package name */
    private static final int f47576y = 400;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<com.scwang.smartrefresh.header.storehouse.a> f47577a;

    /* renamed from: b  reason: collision with root package name */
    private int f47578b;

    /* renamed from: c  reason: collision with root package name */
    private float f47579c;

    /* renamed from: d  reason: collision with root package name */
    private int f47580d;

    /* renamed from: e  reason: collision with root package name */
    private int f47581e;

    /* renamed from: f  reason: collision with root package name */
    private float f47582f;

    /* renamed from: g  reason: collision with root package name */
    private int f47583g;

    /* renamed from: h  reason: collision with root package name */
    private int f47584h;

    /* renamed from: i  reason: collision with root package name */
    private int f47585i;

    /* renamed from: j  reason: collision with root package name */
    private int f47586j;

    /* renamed from: k  reason: collision with root package name */
    private int f47587k;

    /* renamed from: l  reason: collision with root package name */
    private int f47588l;

    /* renamed from: m  reason: collision with root package name */
    private Transformation f47589m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f47590n;

    /* renamed from: o  reason: collision with root package name */
    private b f47591o;

    /* renamed from: p  reason: collision with root package name */
    private int f47592p;

    /* renamed from: q  reason: collision with root package name */
    private int f47593q;

    /* renamed from: r  reason: collision with root package name */
    private Matrix f47594r;

    /* renamed from: s  reason: collision with root package name */
    private g f47595s;

    /* renamed from: t  reason: collision with root package name */
    private Runnable f47596t;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f47597a;

        /* renamed from: b  reason: collision with root package name */
        private int f47598b;

        /* renamed from: c  reason: collision with root package name */
        private int f47599c;

        /* renamed from: d  reason: collision with root package name */
        private int f47600d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f47601e;

        private b() {
            this.f47597a = 0;
            this.f47598b = 0;
            this.f47599c = 0;
            this.f47600d = 0;
            this.f47601e = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f47601e = true;
            this.f47597a = 0;
            this.f47600d = StoreHouseHeader.this.f47587k / StoreHouseHeader.this.f47577a.size();
            this.f47598b = StoreHouseHeader.this.f47588l / this.f47600d;
            this.f47599c = (StoreHouseHeader.this.f47577a.size() / this.f47598b) + 1;
            run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            this.f47601e = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4 = this.f47597a % this.f47598b;
            for (int i5 = 0; i5 < this.f47599c; i5++) {
                int i6 = (this.f47598b * i5) + i4;
                if (i6 <= this.f47597a) {
                    com.scwang.smartrefresh.header.storehouse.a aVar = StoreHouseHeader.this.f47577a.get(i6 % StoreHouseHeader.this.f47577a.size());
                    aVar.setFillAfter(false);
                    aVar.setFillEnabled(true);
                    aVar.setFillBefore(false);
                    aVar.setDuration(400L);
                    aVar.f(1.0f, 0.4f);
                }
            }
            this.f47597a++;
            if (!this.f47601e || StoreHouseHeader.this.f47595s == null) {
                return;
            }
            StoreHouseHeader.this.f47595s.n().getLayout().postDelayed(this, this.f47600d);
        }
    }

    public StoreHouseHeader(Context context) {
        super(context);
        this.f47577a = new ArrayList<>();
        this.f47578b = -1;
        this.f47579c = 1.0f;
        this.f47580d = -1;
        this.f47581e = -1;
        this.f47582f = 0.0f;
        this.f47583g = 0;
        this.f47584h = 0;
        this.f47585i = 0;
        this.f47586j = 0;
        this.f47587k = 1000;
        this.f47588l = 1000;
        this.f47589m = new Transformation();
        this.f47590n = false;
        this.f47591o = new b();
        this.f47592p = -1;
        this.f47593q = 0;
        this.f47594r = new Matrix();
        B(context, null);
    }

    private void A() {
        this.f47590n = true;
        this.f47591o.c();
        invalidate();
    }

    private void B(Context context, AttributeSet attributeSet) {
        c cVar = new c();
        this.f47578b = cVar.a(1.0f);
        this.f47580d = cVar.a(40.0f);
        this.f47581e = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        this.f47593q = -13421773;
        N(-3355444);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StoreHouseHeader);
        this.f47578b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhLineWidth, this.f47578b);
        this.f47580d = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhDropHeight, this.f47580d);
        int i4 = R.styleable.StoreHouseHeader_shhText;
        if (obtainStyledAttributes.hasValue(i4)) {
            D(obtainStyledAttributes.getString(i4));
        } else {
            D("StoreHouse");
        }
        obtainStyledAttributes.recycle();
        setMinimumHeight(this.f47584h + c.b(40.0f));
    }

    private void G() {
        this.f47590n = false;
        this.f47591o.d();
    }

    private void H(h hVar) {
    }

    private void I() {
        Runnable runnable = this.f47596t;
        if (runnable != null) {
            runnable.run();
            this.f47596t = null;
        }
    }

    private int getBottomOffset() {
        return getPaddingBottom() + c.b(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + c.b(10.0f);
    }

    private void setProgress(float f4) {
        this.f47582f = f4;
    }

    public StoreHouseHeader C(ArrayList<float[]> arrayList) {
        boolean z3 = this.f47577a.size() > 0;
        this.f47577a.clear();
        c cVar = new c();
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            float[] fArr = arrayList.get(i4);
            PointF pointF = new PointF(cVar.a(fArr[0]) * this.f47579c, cVar.a(fArr[1]) * this.f47579c);
            PointF pointF2 = new PointF(cVar.a(fArr[2]) * this.f47579c, cVar.a(fArr[3]) * this.f47579c);
            f4 = Math.max(Math.max(f4, pointF.x), pointF2.x);
            f5 = Math.max(Math.max(f5, pointF.y), pointF2.y);
            com.scwang.smartrefresh.header.storehouse.a aVar = new com.scwang.smartrefresh.header.storehouse.a(i4, pointF, pointF2, this.f47592p, this.f47578b);
            aVar.b(this.f47581e);
            this.f47577a.add(aVar);
        }
        this.f47583g = (int) Math.ceil(f4);
        this.f47584h = (int) Math.ceil(f5);
        if (z3) {
            requestLayout();
        }
        return this;
    }

    public StoreHouseHeader D(String str) {
        E(str, 25);
        return this;
    }

    public StoreHouseHeader E(String str, int i4) {
        C(com.scwang.smartrefresh.header.storehouse.b.c(str, i4 * 0.01f, 14));
        return this;
    }

    public StoreHouseHeader F(int i4) {
        String[] stringArray = getResources().getStringArray(i4);
        ArrayList<float[]> arrayList = new ArrayList<>();
        for (String str : stringArray) {
            String[] split = str.split(",");
            float[] fArr = new float[4];
            for (int i5 = 0; i5 < 4; i5++) {
                fArr[i5] = Float.parseFloat(split[i5]);
            }
            arrayList.add(fArr);
        }
        C(arrayList);
        return this;
    }

    public StoreHouseHeader J(int i4) {
        this.f47580d = i4;
        return this;
    }

    public StoreHouseHeader K(int i4) {
        this.f47578b = i4;
        for (int i5 = 0; i5 < this.f47577a.size(); i5++) {
            this.f47577a.get(i5).e(i4);
        }
        return this;
    }

    public StoreHouseHeader L(int i4) {
        this.f47587k = i4;
        this.f47588l = i4;
        return this;
    }

    public StoreHouseHeader M(float f4) {
        this.f47579c = f4;
        return this;
    }

    public StoreHouseHeader N(@ColorInt int i4) {
        this.f47592p = i4;
        for (int i5 = 0; i5 < this.f47577a.size(); i5++) {
            this.f47577a.get(i5).d(i4);
        }
        return this;
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        if (refreshState2 == RefreshState.ReleaseToRefresh) {
            H(hVar);
        } else if (refreshState2 == RefreshState.None) {
            I();
        }
    }

    public int getLoadingAniDuration() {
        return this.f47587k;
    }

    public float getScale() {
        return this.f47579c;
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.e
    public void i(float f4, int i4, int i5, int i6) {
        setProgress(f4 * 0.8f);
        invalidate();
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
        A();
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
        int i6 = this.f47593q;
        if (i6 != 0) {
            gVar.c(i6);
        }
        this.f47595s = gVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f47595s = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f4 = this.f47582f;
        int save = canvas.save();
        int size = this.f47577a.size();
        if (isInEditMode()) {
            f4 = 1.0f;
        }
        for (int i4 = 0; i4 < size; i4++) {
            canvas.save();
            com.scwang.smartrefresh.header.storehouse.a aVar = this.f47577a.get(i4);
            PointF pointF = aVar.f47796a;
            float f5 = this.f47585i + pointF.x;
            float f6 = this.f47586j + pointF.y;
            if (this.f47590n) {
                aVar.getTransformation(getDrawingTime(), this.f47589m);
                canvas.translate(f5, f6);
            } else if (f4 == 0.0f) {
                aVar.b(this.f47581e);
            } else {
                float f7 = (i4 * 0.3f) / size;
                float f8 = 0.3f - f7;
                if (f4 != 1.0f && f4 < 1.0f - f8) {
                    float min = f4 > f7 ? Math.min(1.0f, (f4 - f7) / 0.7f) : 0.0f;
                    float f9 = 1.0f - min;
                    float f10 = f5 + (aVar.f47797b * f9);
                    float f11 = f6 + ((-this.f47580d) * f9);
                    this.f47594r.reset();
                    this.f47594r.postRotate(360.0f * min);
                    this.f47594r.postScale(min, min);
                    this.f47594r.postTranslate(f10, f11);
                    aVar.c(min * 0.4f);
                    canvas.concat(this.f47594r);
                } else {
                    canvas.translate(f5, f6);
                    aVar.c(0.4f);
                }
            }
            aVar.a(canvas);
            canvas.restore();
        }
        if (this.f47590n) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
        this.f47585i = (getMeasuredWidth() - this.f47583g) / 2;
        this.f47586j = (getMeasuredHeight() - this.f47584h) / 2;
        this.f47580d = getMeasuredHeight() / 2;
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f47593q = iArr[0];
            g gVar = this.f47595s;
            if (gVar != null) {
                gVar.c(iArr[0]);
            }
            if (iArr.length > 1) {
                N(iArr[1]);
            }
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        G();
        for (int i4 = 0; i4 < this.f47577a.size(); i4++) {
            this.f47577a.get(i4).b(this.f47581e);
        }
        return 0;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        setProgress(f4 * 0.8f);
        invalidate();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47577a = new ArrayList<>();
        this.f47578b = -1;
        this.f47579c = 1.0f;
        this.f47580d = -1;
        this.f47581e = -1;
        this.f47582f = 0.0f;
        this.f47583g = 0;
        this.f47584h = 0;
        this.f47585i = 0;
        this.f47586j = 0;
        this.f47587k = 1000;
        this.f47588l = 1000;
        this.f47589m = new Transformation();
        this.f47590n = false;
        this.f47591o = new b();
        this.f47592p = -1;
        this.f47593q = 0;
        this.f47594r = new Matrix();
        B(context, attributeSet);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47577a = new ArrayList<>();
        this.f47578b = -1;
        this.f47579c = 1.0f;
        this.f47580d = -1;
        this.f47581e = -1;
        this.f47582f = 0.0f;
        this.f47583g = 0;
        this.f47584h = 0;
        this.f47585i = 0;
        this.f47586j = 0;
        this.f47587k = 1000;
        this.f47588l = 1000;
        this.f47589m = new Transformation();
        this.f47590n = false;
        this.f47591o = new b();
        this.f47592p = -1;
        this.f47593q = 0;
        this.f47594r = new Matrix();
        B(context, attributeSet);
    }

    @RequiresApi(21)
    public StoreHouseHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47577a = new ArrayList<>();
        this.f47578b = -1;
        this.f47579c = 1.0f;
        this.f47580d = -1;
        this.f47581e = -1;
        this.f47582f = 0.0f;
        this.f47583g = 0;
        this.f47584h = 0;
        this.f47585i = 0;
        this.f47586j = 0;
        this.f47587k = 1000;
        this.f47588l = 1000;
        this.f47589m = new Transformation();
        this.f47590n = false;
        this.f47591o = new b();
        this.f47592p = -1;
        this.f47593q = 0;
        this.f47594r = new Matrix();
        B(context, attributeSet);
    }
}
