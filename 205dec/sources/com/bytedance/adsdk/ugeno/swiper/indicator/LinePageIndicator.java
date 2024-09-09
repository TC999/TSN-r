package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LinePageIndicator extends View implements com.bytedance.adsdk.ugeno.swiper.indicator.a {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f26268a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f26269b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f26270c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPager.i f26271d;

    /* renamed from: e  reason: collision with root package name */
    private int f26272e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26273f;

    /* renamed from: g  reason: collision with root package name */
    private float f26274g;

    /* renamed from: h  reason: collision with root package name */
    private float f26275h;

    /* renamed from: i  reason: collision with root package name */
    private int f26276i;

    /* renamed from: j  reason: collision with root package name */
    private float f26277j;

    /* renamed from: k  reason: collision with root package name */
    private int f26278k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f26279l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f26280a;

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
            parcel.writeInt(this.f26280a);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private c(Parcel parcel) {
            super(parcel);
            this.f26280a = parcel.readInt();
        }
    }

    private int a(int i4) {
        float f4;
        ViewPager viewPager;
        int b4;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824 || (viewPager = this.f26270c) == null) {
            f4 = size;
        } else {
            f4 = getPaddingLeft() + getPaddingRight() + (viewPager.getAdapter().b() * this.f26274g) + ((b4 - 1) * this.f26275h);
            if (mode == Integer.MIN_VALUE) {
                f4 = Math.min(f4, size);
            }
        }
        return (int) Math.ceil(f4);
    }

    private int b(int i4) {
        float min;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824) {
            min = size;
        } else {
            float strokeWidth = this.f26269b.getStrokeWidth() + getPaddingTop() + getPaddingBottom();
            min = mode == Integer.MIN_VALUE ? Math.min(strokeWidth, size) : strokeWidth;
        }
        return (int) Math.ceil(min);
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void c(int i4, float f4, int i5) {
        ViewPager.i iVar = this.f26271d;
        if (iVar != null) {
            iVar.c(i4, f4, i5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void ev(int i4) {
        this.f26272e = i4;
        invalidate();
        ViewPager.i iVar = this.f26271d;
        if (iVar != null) {
            iVar.ev(i4);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void gd(int i4) {
        ViewPager.i iVar = this.f26271d;
        if (iVar != null) {
            iVar.gd(i4);
        }
    }

    public float getGapWidth() {
        return this.f26275h;
    }

    public float getLineWidth() {
        return this.f26274g;
    }

    public int getSelectedColor() {
        return this.f26269b.getColor();
    }

    public float getStrokeWidth() {
        return this.f26269b.getStrokeWidth();
    }

    public int getUnselectedColor() {
        return this.f26268a.getColor();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int b4;
        super.onDraw(canvas);
        ViewPager viewPager = this.f26270c;
        if (viewPager == null || (b4 = viewPager.getAdapter().b()) == 0) {
            return;
        }
        if (this.f26272e >= b4) {
            setCurrentItem(b4 - 1);
            return;
        }
        float f4 = this.f26274g;
        float f5 = this.f26275h;
        float f6 = f4 + f5;
        float f7 = (b4 * f6) - f5;
        float paddingTop = getPaddingTop();
        float paddingLeft = getPaddingLeft();
        float paddingRight = getPaddingRight();
        float height = paddingTop + (((getHeight() - paddingTop) - getPaddingBottom()) / 2.0f);
        if (this.f26273f) {
            paddingLeft += (((getWidth() - paddingLeft) - paddingRight) / 2.0f) - (f7 / 2.0f);
        }
        int i4 = 0;
        while (i4 < b4) {
            float f8 = paddingLeft + (i4 * f6);
            canvas.drawLine(f8, height, f8 + this.f26274g, height, i4 == this.f26272e ? this.f26269b : this.f26268a);
            i4++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(a(i4), b(i5));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f26272e = cVar.f26280a;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f26280a = this.f26272e;
        return cVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.f26270c;
        if (viewPager == null || viewPager.getAdapter().b() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x3 = motionEvent.getX(motionEvent.findPointerIndex(this.f26278k));
                    float f4 = x3 - this.f26277j;
                    if (!this.f26279l && Math.abs(f4) > this.f26276i) {
                        this.f26279l = true;
                    }
                    if (this.f26279l) {
                        this.f26277j = x3;
                        if (this.f26270c.B() || this.f26270c.G()) {
                            this.f26270c.N(f4);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f26277j = motionEvent.getX(actionIndex);
                        this.f26278k = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex2) == this.f26278k) {
                            this.f26278k = motionEvent.getPointerId(actionIndex2 == 0 ? 1 : 0);
                        }
                        this.f26277j = motionEvent.getX(motionEvent.findPointerIndex(this.f26278k));
                    }
                }
            }
            if (!this.f26279l) {
                int b4 = this.f26270c.getAdapter().b();
                float width = getWidth();
                float f5 = width / 2.0f;
                float f6 = width / 6.0f;
                if (this.f26272e > 0 && motionEvent.getX() < f5 - f6) {
                    if (action != 3) {
                        this.f26270c.setCurrentItem(this.f26272e - 1);
                    }
                    return true;
                } else if (this.f26272e < b4 - 1 && motionEvent.getX() > f5 + f6) {
                    if (action != 3) {
                        this.f26270c.setCurrentItem(this.f26272e + 1);
                    }
                    return true;
                }
            }
            this.f26279l = false;
            this.f26278k = -1;
            if (this.f26270c.B()) {
                this.f26270c.I();
            }
        } else {
            this.f26278k = motionEvent.getPointerId(0);
            this.f26277j = motionEvent.getX();
        }
        return true;
    }

    public void setCentered(boolean z3) {
        this.f26273f = z3;
        invalidate();
    }

    public void setCurrentItem(int i4) {
        ViewPager viewPager = this.f26270c;
        if (viewPager != null) {
            viewPager.setCurrentItem(i4);
            this.f26272e = i4;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setGapWidth(float f4) {
        this.f26275h = f4;
        invalidate();
    }

    public void setLineWidth(float f4) {
        this.f26274g = f4;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.i iVar) {
        this.f26271d = iVar;
    }

    public void setSelectedColor(int i4) {
        this.f26269b.setColor(i4);
        invalidate();
    }

    public void setStrokeWidth(float f4) {
        this.f26269b.setStrokeWidth(f4);
        this.f26268a.setStrokeWidth(f4);
        invalidate();
    }

    public void setUnselectedColor(int i4) {
        this.f26268a.setColor(i4);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f26270c;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.r(null);
        }
        if (viewPager.getAdapter() != null) {
            this.f26270c = viewPager;
            viewPager.r(this);
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
}
