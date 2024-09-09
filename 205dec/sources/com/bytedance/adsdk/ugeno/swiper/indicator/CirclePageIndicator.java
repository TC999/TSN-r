package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class CirclePageIndicator extends View implements com.bytedance.adsdk.ugeno.swiper.indicator.a {

    /* renamed from: a  reason: collision with root package name */
    private float f26241a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f26242b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f26243c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f26244d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f26245e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager.i f26246f;

    /* renamed from: g  reason: collision with root package name */
    private int f26247g;

    /* renamed from: h  reason: collision with root package name */
    private int f26248h;

    /* renamed from: i  reason: collision with root package name */
    private float f26249i;

    /* renamed from: j  reason: collision with root package name */
    private int f26250j;

    /* renamed from: k  reason: collision with root package name */
    private int f26251k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f26252l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f26253m;

    /* renamed from: n  reason: collision with root package name */
    private int f26254n;

    /* renamed from: o  reason: collision with root package name */
    private float f26255o;

    /* renamed from: p  reason: collision with root package name */
    private int f26256p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f26257q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f26258a;

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int i4) {
                return new c[i4];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f26258a);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private c(Parcel parcel) {
            super(parcel);
            this.f26258a = parcel.readInt();
        }
    }

    private int a(int i4) {
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824 || (viewPager = this.f26245e) == null) {
            return size;
        }
        int b4 = viewPager.getAdapter().b();
        float f4 = this.f26241a;
        int paddingLeft = (int) (getPaddingLeft() + getPaddingRight() + (b4 * 2 * f4) + ((b4 - 1) * f4) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int b(int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f26241a * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void c(int i4, float f4, int i5) {
        this.f26247g = i4;
        this.f26249i = f4;
        invalidate();
        ViewPager.i iVar = this.f26246f;
        if (iVar != null) {
            iVar.c(i4, f4, i5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void ev(int i4) {
        if (this.f26253m || this.f26250j == 0) {
            this.f26247g = i4;
            this.f26248h = i4;
            invalidate();
        }
        ViewPager.i iVar = this.f26246f;
        if (iVar != null) {
            iVar.ev(i4);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void gd(int i4) {
        this.f26250j = i4;
        ViewPager.i iVar = this.f26246f;
        if (iVar != null) {
            iVar.gd(i4);
        }
    }

    public int getFillColor() {
        return this.f26244d.getColor();
    }

    public int getOrientation() {
        return this.f26251k;
    }

    public int getPageColor() {
        return this.f26242b.getColor();
    }

    public float getRadius() {
        return this.f26241a;
    }

    public int getStrokeColor() {
        return this.f26243c.getColor();
    }

    public float getStrokeWidth() {
        return this.f26243c.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int b4;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        float f4;
        float f5;
        super.onDraw(canvas);
        ViewPager viewPager = this.f26245e;
        if (viewPager == null || (b4 = viewPager.getAdapter().b()) == 0) {
            return;
        }
        if (this.f26247g >= b4) {
            setCurrentItem(b4 - 1);
            return;
        }
        if (this.f26251k == 0) {
            height = getWidth();
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
            paddingLeft = getPaddingTop();
        } else {
            height = getHeight();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            paddingLeft = getPaddingLeft();
        }
        float f6 = this.f26241a;
        float f7 = 3.0f * f6;
        float f8 = paddingLeft + f6;
        float f9 = paddingTop + f6;
        if (this.f26252l) {
            f9 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((b4 * f7) / 2.0f);
        }
        if (this.f26243c.getStrokeWidth() > 0.0f) {
            f6 -= this.f26243c.getStrokeWidth() / 2.0f;
        }
        for (int i4 = 0; i4 < b4; i4++) {
            float f10 = (i4 * f7) + f9;
            if (this.f26251k == 0) {
                f5 = f8;
            } else {
                f5 = f10;
                f10 = f8;
            }
            if (this.f26242b.getAlpha() > 0) {
                canvas.drawCircle(f10, f5, f6, this.f26242b);
            }
            float f11 = this.f26241a;
            if (f6 != f11) {
                canvas.drawCircle(f10, f5, f11, this.f26243c);
            }
        }
        boolean z3 = this.f26253m;
        float f12 = (z3 ? this.f26248h : this.f26247g) * f7;
        if (!z3) {
            f12 += this.f26249i * f7;
        }
        if (this.f26251k == 0) {
            float f13 = f9 + f12;
            f4 = f8;
            f8 = f13;
        } else {
            f4 = f9 + f12;
        }
        canvas.drawCircle(f8, f4, this.f26241a, this.f26244d);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        if (this.f26251k == 0) {
            setMeasuredDimension(a(i4), b(i5));
        } else {
            setMeasuredDimension(b(i4), a(i5));
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        int i4 = cVar.f26258a;
        this.f26247g = i4;
        this.f26248h = i4;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f26258a = this.f26247g;
        return cVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.f26245e;
        if (viewPager == null || viewPager.getAdapter().b() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x3 = motionEvent.getX(motionEvent.findPointerIndex(this.f26256p));
                    float f4 = x3 - this.f26255o;
                    if (!this.f26257q && Math.abs(f4) > this.f26254n) {
                        this.f26257q = true;
                    }
                    if (this.f26257q) {
                        this.f26255o = x3;
                        if (this.f26245e.B() || this.f26245e.G()) {
                            this.f26245e.N(f4);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f26255o = motionEvent.getX(actionIndex);
                        this.f26256p = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.f26256p) {
                            this.f26256p = motionEvent.getPointerId(actionIndex2 == 0 ? 1 : 0);
                        }
                        this.f26255o = motionEvent.getX(motionEvent.findPointerIndex(this.f26256p));
                    }
                }
            }
            if (!this.f26257q) {
                int b4 = this.f26245e.getAdapter().b();
                float width = getWidth();
                float f5 = width / 2.0f;
                float f6 = width / 6.0f;
                if (this.f26247g > 0 && motionEvent.getX() < f5 - f6) {
                    if (action != 3) {
                        this.f26245e.setCurrentItem(this.f26247g - 1);
                    }
                    return true;
                } else if (this.f26247g < b4 - 1 && motionEvent.getX() > f5 + f6) {
                    if (action != 3) {
                        this.f26245e.setCurrentItem(this.f26247g + 1);
                    }
                    return true;
                }
            }
            this.f26257q = false;
            this.f26256p = -1;
            if (this.f26245e.B()) {
                this.f26245e.I();
            }
        } else {
            this.f26256p = motionEvent.getPointerId(0);
            this.f26255o = motionEvent.getX();
        }
        return true;
    }

    public void setCentered(boolean z3) {
        this.f26252l = z3;
        invalidate();
    }

    public void setCurrentItem(int i4) {
        ViewPager viewPager = this.f26245e;
        if (viewPager != null) {
            viewPager.setCurrentItem(i4);
            this.f26247g = i4;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setFillColor(int i4) {
        this.f26244d.setColor(i4);
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.i iVar) {
        this.f26246f = iVar;
    }

    public void setOrientation(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.f26251k = i4;
        requestLayout();
    }

    public void setPageColor(int i4) {
        this.f26242b.setColor(i4);
        invalidate();
    }

    public void setRadius(float f4) {
        this.f26241a = f4;
        invalidate();
    }

    public void setSnap(boolean z3) {
        this.f26253m = z3;
        invalidate();
    }

    public void setStrokeColor(int i4) {
        this.f26243c.setColor(i4);
        invalidate();
    }

    public void setStrokeWidth(float f4) {
        this.f26243c.setStrokeWidth(f4);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f26245e;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() != null) {
            this.f26245e = viewPager;
            viewPager.setOnPageChangeListener(this);
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
}
