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
import com.scwang.smartrefresh.header.storehouse.StoreHouseBarItem;
import com.scwang.smartrefresh.header.storehouse.StoreHousePath;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.C11925c;
import java.util.ArrayList;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StoreHouseHeader extends View implements RefreshHeader {

    /* renamed from: u */
    private static final float f33153u = 0.7f;

    /* renamed from: v */
    private static final float f33154v = 0.4f;

    /* renamed from: w */
    private static final float f33155w = 1.0f;

    /* renamed from: x */
    private static final float f33156x = 0.4f;

    /* renamed from: y */
    private static final int f33157y = 400;

    /* renamed from: a */
    public ArrayList<StoreHouseBarItem> f33158a;

    /* renamed from: b */
    private int f33159b;

    /* renamed from: c */
    private float f33160c;

    /* renamed from: d */
    private int f33161d;

    /* renamed from: e */
    private int f33162e;

    /* renamed from: f */
    private float f33163f;

    /* renamed from: g */
    private int f33164g;

    /* renamed from: h */
    private int f33165h;

    /* renamed from: i */
    private int f33166i;

    /* renamed from: j */
    private int f33167j;

    /* renamed from: k */
    private int f33168k;

    /* renamed from: l */
    private int f33169l;

    /* renamed from: m */
    private Transformation f33170m;

    /* renamed from: n */
    private boolean f33171n;

    /* renamed from: o */
    private RunnableC11855b f33172o;

    /* renamed from: p */
    private int f33173p;

    /* renamed from: q */
    private int f33174q;

    /* renamed from: r */
    private Matrix f33175r;

    /* renamed from: s */
    private RefreshKernel f33176s;

    /* renamed from: t */
    private Runnable f33177t;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.scwang.smartrefresh.header.StoreHouseHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11855b implements Runnable {

        /* renamed from: a */
        private int f33178a;

        /* renamed from: b */
        private int f33179b;

        /* renamed from: c */
        private int f33180c;

        /* renamed from: d */
        private int f33181d;

        /* renamed from: e */
        private boolean f33182e;

        private RunnableC11855b() {
            this.f33178a = 0;
            this.f33179b = 0;
            this.f33180c = 0;
            this.f33181d = 0;
            this.f33182e = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m20162c() {
            this.f33182e = true;
            this.f33178a = 0;
            this.f33181d = StoreHouseHeader.this.f33168k / StoreHouseHeader.this.f33158a.size();
            this.f33179b = StoreHouseHeader.this.f33169l / this.f33181d;
            this.f33180c = (StoreHouseHeader.this.f33158a.size() / this.f33179b) + 1;
            run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public void m20161d() {
            this.f33182e = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f33178a % this.f33179b;
            for (int i2 = 0; i2 < this.f33180c; i2++) {
                int i3 = (this.f33179b * i2) + i;
                if (i3 <= this.f33178a) {
                    StoreHouseBarItem storeHouseBarItem = StoreHouseHeader.this.f33158a.get(i3 % StoreHouseHeader.this.f33158a.size());
                    storeHouseBarItem.setFillAfter(false);
                    storeHouseBarItem.setFillEnabled(true);
                    storeHouseBarItem.setFillBefore(false);
                    storeHouseBarItem.setDuration(400L);
                    storeHouseBarItem.m20028f(1.0f, 0.4f);
                }
            }
            this.f33178a++;
            if (!this.f33182e || StoreHouseHeader.this.f33176s == null) {
                return;
            }
            StoreHouseHeader.this.f33176s.mo2081n().getLayout().postDelayed(this, this.f33181d);
        }
    }

    public StoreHouseHeader(Context context) {
        super(context);
        this.f33158a = new ArrayList<>();
        this.f33159b = -1;
        this.f33160c = 1.0f;
        this.f33161d = -1;
        this.f33162e = -1;
        this.f33163f = 0.0f;
        this.f33164g = 0;
        this.f33165h = 0;
        this.f33166i = 0;
        this.f33167j = 0;
        this.f33168k = 1000;
        this.f33169l = 1000;
        this.f33170m = new Transformation();
        this.f33171n = false;
        this.f33172o = new RunnableC11855b();
        this.f33173p = -1;
        this.f33174q = 0;
        this.f33175r = new Matrix();
        m20180B(context, null);
    }

    /* renamed from: A */
    private void m20181A() {
        this.f33171n = true;
        this.f33172o.m20162c();
        invalidate();
    }

    /* renamed from: B */
    private void m20180B(Context context, AttributeSet attributeSet) {
        C11925c c11925c = new C11925c();
        this.f33159b = c11925c.m19767a(1.0f);
        this.f33161d = c11925c.m19767a(40.0f);
        this.f33162e = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        this.f33174q = -13421773;
        m20168N(-3355444);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.StoreHouseHeader);
        this.f33159b = obtainStyledAttributes.getDimensionPixelOffset(C11852R.styleable.StoreHouseHeader_shhLineWidth, this.f33159b);
        this.f33161d = obtainStyledAttributes.getDimensionPixelOffset(C11852R.styleable.StoreHouseHeader_shhDropHeight, this.f33161d);
        int i = C11852R.styleable.StoreHouseHeader_shhText;
        if (obtainStyledAttributes.hasValue(i)) {
            m20178D(obtainStyledAttributes.getString(i));
        } else {
            m20178D("StoreHouse");
        }
        obtainStyledAttributes.recycle();
        setMinimumHeight(this.f33165h + C11925c.m19766b(40.0f));
    }

    /* renamed from: G */
    private void m20175G() {
        this.f33171n = false;
        this.f33172o.m20161d();
    }

    /* renamed from: H */
    private void m20174H(RefreshLayout refreshLayout) {
    }

    /* renamed from: I */
    private void m20173I() {
        Runnable runnable = this.f33177t;
        if (runnable != null) {
            runnable.run();
            this.f33177t = null;
        }
    }

    private int getBottomOffset() {
        return getPaddingBottom() + C11925c.m19766b(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + C11925c.m19766b(10.0f);
    }

    private void setProgress(float f) {
        this.f33163f = f;
    }

    /* renamed from: C */
    public StoreHouseHeader m20179C(ArrayList<float[]> arrayList) {
        boolean z = this.f33158a.size() > 0;
        this.f33158a.clear();
        C11925c c11925c = new C11925c();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = arrayList.get(i);
            PointF pointF = new PointF(c11925c.m19767a(fArr[0]) * this.f33160c, c11925c.m19767a(fArr[1]) * this.f33160c);
            PointF pointF2 = new PointF(c11925c.m19767a(fArr[2]) * this.f33160c, c11925c.m19767a(fArr[3]) * this.f33160c);
            f = Math.max(Math.max(f, pointF.x), pointF2.x);
            f2 = Math.max(Math.max(f2, pointF.y), pointF2.y);
            StoreHouseBarItem storeHouseBarItem = new StoreHouseBarItem(i, pointF, pointF2, this.f33173p, this.f33159b);
            storeHouseBarItem.m20032b(this.f33162e);
            this.f33158a.add(storeHouseBarItem);
        }
        this.f33164g = (int) Math.ceil(f);
        this.f33165h = (int) Math.ceil(f2);
        if (z) {
            requestLayout();
        }
        return this;
    }

    /* renamed from: D */
    public StoreHouseHeader m20178D(String str) {
        m20177E(str, 25);
        return this;
    }

    /* renamed from: E */
    public StoreHouseHeader m20177E(String str, int i) {
        m20179C(StoreHousePath.m20025c(str, i * 0.01f, 14));
        return this;
    }

    /* renamed from: F */
    public StoreHouseHeader m20176F(int i) {
        String[] stringArray = getResources().getStringArray(i);
        ArrayList<float[]> arrayList = new ArrayList<>();
        for (String str : stringArray) {
            String[] split = str.split(",");
            float[] fArr = new float[4];
            for (int i2 = 0; i2 < 4; i2++) {
                fArr[i2] = Float.parseFloat(split[i2]);
            }
            arrayList.add(fArr);
        }
        m20179C(arrayList);
        return this;
    }

    /* renamed from: J */
    public StoreHouseHeader m20172J(int i) {
        this.f33161d = i;
        return this;
    }

    /* renamed from: K */
    public StoreHouseHeader m20171K(int i) {
        this.f33159b = i;
        for (int i2 = 0; i2 < this.f33158a.size(); i2++) {
            this.f33158a.get(i2).m20029e(i);
        }
        return this;
    }

    /* renamed from: L */
    public StoreHouseHeader m20170L(int i) {
        this.f33168k = i;
        this.f33169l = i;
        return this;
    }

    /* renamed from: M */
    public StoreHouseHeader m20169M(float f) {
        this.f33160c = f;
        return this;
    }

    /* renamed from: N */
    public StoreHouseHeader m20168N(@ColorInt int i) {
        this.f33173p = i;
        for (int i2 = 0; i2 < this.f33158a.size(); i2++) {
            this.f33158a.get(i2).m20030d(i);
        }
        return this;
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        if (refreshState2 == RefreshState.ReleaseToRefresh) {
            m20174H(refreshLayout);
        } else if (refreshState2 == RefreshState.None) {
            m20173I();
        }
    }

    public int getLoadingAniDuration() {
        return this.f33168k;
    }

    public float getScale() {
        return this.f33160c;
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
        setProgress(f * 0.8f);
        invalidate();
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        m20181A();
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        int i3 = this.f33174q;
        if (i3 != 0) {
            refreshKernel.mo2092c(i3);
        }
        this.f33176s = refreshKernel;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f33176s = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f33163f;
        int save = canvas.save();
        int size = this.f33158a.size();
        if (isInEditMode()) {
            f = 1.0f;
        }
        for (int i = 0; i < size; i++) {
            canvas.save();
            StoreHouseBarItem storeHouseBarItem = this.f33158a.get(i);
            PointF pointF = storeHouseBarItem.f33411a;
            float f2 = this.f33166i + pointF.x;
            float f3 = this.f33167j + pointF.y;
            if (this.f33171n) {
                storeHouseBarItem.getTransformation(getDrawingTime(), this.f33170m);
                canvas.translate(f2, f3);
            } else if (f == 0.0f) {
                storeHouseBarItem.m20032b(this.f33162e);
            } else {
                float f4 = (i * 0.3f) / size;
                float f5 = 0.3f - f4;
                if (f != 1.0f && f < 1.0f - f5) {
                    float min = f > f4 ? Math.min(1.0f, (f - f4) / 0.7f) : 0.0f;
                    float f6 = 1.0f - min;
                    float f7 = f2 + (storeHouseBarItem.f33412b * f6);
                    float f8 = f3 + ((-this.f33161d) * f6);
                    this.f33175r.reset();
                    this.f33175r.postRotate(360.0f * min);
                    this.f33175r.postScale(min, min);
                    this.f33175r.postTranslate(f7, f8);
                    storeHouseBarItem.m20031c(min * 0.4f);
                    canvas.concat(this.f33175r);
                } else {
                    canvas.translate(f2, f3);
                    storeHouseBarItem.m20031c(0.4f);
                }
            }
            storeHouseBarItem.m20033a(canvas);
            canvas.restore();
        }
        if (this.f33171n) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
        this.f33166i = (getMeasuredWidth() - this.f33164g) / 2;
        this.f33167j = (getMeasuredHeight() - this.f33165h) / 2;
        this.f33161d = getMeasuredHeight() / 2;
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f33174q = iArr[0];
            RefreshKernel refreshKernel = this.f33176s;
            if (refreshKernel != null) {
                refreshKernel.mo2092c(iArr[0]);
            }
            if (iArr.length > 1) {
                m20168N(iArr[1]);
            }
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        m20175G();
        for (int i = 0; i < this.f33158a.size(); i++) {
            this.f33158a.get(i).m20032b(this.f33162e);
        }
        return 0;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        setProgress(f * 0.8f);
        invalidate();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33158a = new ArrayList<>();
        this.f33159b = -1;
        this.f33160c = 1.0f;
        this.f33161d = -1;
        this.f33162e = -1;
        this.f33163f = 0.0f;
        this.f33164g = 0;
        this.f33165h = 0;
        this.f33166i = 0;
        this.f33167j = 0;
        this.f33168k = 1000;
        this.f33169l = 1000;
        this.f33170m = new Transformation();
        this.f33171n = false;
        this.f33172o = new RunnableC11855b();
        this.f33173p = -1;
        this.f33174q = 0;
        this.f33175r = new Matrix();
        m20180B(context, attributeSet);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33158a = new ArrayList<>();
        this.f33159b = -1;
        this.f33160c = 1.0f;
        this.f33161d = -1;
        this.f33162e = -1;
        this.f33163f = 0.0f;
        this.f33164g = 0;
        this.f33165h = 0;
        this.f33166i = 0;
        this.f33167j = 0;
        this.f33168k = 1000;
        this.f33169l = 1000;
        this.f33170m = new Transformation();
        this.f33171n = false;
        this.f33172o = new RunnableC11855b();
        this.f33173p = -1;
        this.f33174q = 0;
        this.f33175r = new Matrix();
        m20180B(context, attributeSet);
    }

    @RequiresApi(21)
    public StoreHouseHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33158a = new ArrayList<>();
        this.f33159b = -1;
        this.f33160c = 1.0f;
        this.f33161d = -1;
        this.f33162e = -1;
        this.f33163f = 0.0f;
        this.f33164g = 0;
        this.f33165h = 0;
        this.f33166i = 0;
        this.f33167j = 0;
        this.f33168k = 1000;
        this.f33169l = 1000;
        this.f33170m = new Transformation();
        this.f33171n = false;
        this.f33172o = new RunnableC11855b();
        this.f33173p = -1;
        this.f33174q = 0;
        this.f33175r = new Matrix();
        m20180B(context, attributeSet);
    }
}
