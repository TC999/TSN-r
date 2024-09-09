package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WaterDropHeader extends ViewGroup implements e {

    /* renamed from: g  reason: collision with root package name */
    private static final float f47636g = 0.8f;

    /* renamed from: a  reason: collision with root package name */
    private RefreshState f47637a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f47638b;

    /* renamed from: c  reason: collision with root package name */
    private WaterDropView f47639c;

    /* renamed from: d  reason: collision with root package name */
    private com.scwang.smartrefresh.layout.internal.a f47640d;

    /* renamed from: e  reason: collision with root package name */
    private MaterialProgressDrawable f47641e;

    /* renamed from: f  reason: collision with root package name */
    private int f47642f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a extends AnimatorListenerAdapter {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* renamed from: com.scwang.smartrefresh.header.WaterDropHeader$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class C0929a extends AnimatorListenerAdapter {
            C0929a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WaterDropHeader.this.f47639c.setVisibility(8);
                WaterDropHeader.this.f47639c.setAlpha(1.0f);
            }
        }

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaterDropHeader.this.f47639c.animate().alpha(0.0f).setListener(new C0929a());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f47645a;

        b(h hVar) {
            this.f47645a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            WaterDropHeader waterDropHeader = WaterDropHeader.this;
            waterDropHeader.f47642f = (waterDropHeader.f47642f + 30) % 360;
            WaterDropHeader.this.invalidate();
            if (WaterDropHeader.this.f47637a == RefreshState.Refreshing || WaterDropHeader.this.f47637a == RefreshState.RefreshReleased) {
                this.f47645a.getLayout().postDelayed(this, 100L);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47647a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f47647a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47647a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47647a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47647a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47647a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47647a[RefreshState.RefreshFinish.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public WaterDropHeader(Context context) {
        super(context);
        this.f47642f = 0;
        B(context);
    }

    private void B(Context context) {
        com.scwang.smartrefresh.layout.util.c cVar = new com.scwang.smartrefresh.layout.util.c();
        WaterDropView waterDropView = new WaterDropView(context);
        this.f47639c = waterDropView;
        addView(waterDropView, -1, -1);
        this.f47639c.e(0);
        com.scwang.smartrefresh.layout.internal.a aVar = new com.scwang.smartrefresh.layout.internal.a();
        this.f47640d = aVar;
        aVar.setBounds(0, 0, cVar.a(20.0f), cVar.a(20.0f));
        this.f47638b = new ImageView(context);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, this.f47638b);
        this.f47641e = materialProgressDrawable;
        materialProgressDrawable.f(-1);
        this.f47641e.setAlpha(255);
        this.f47641e.g(-1, -16737844, -48060, -10053376, -5609780, -30720);
        this.f47638b.setImageDrawable(this.f47641e);
        addView(this.f47638b, cVar.a(30.0f), cVar.a(30.0f));
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f47637a = refreshState2;
        int i4 = c.f47647a[refreshState2.ordinal()];
        if (i4 == 1) {
            this.f47639c.setVisibility(0);
        } else if (i4 == 2) {
            this.f47639c.setVisibility(0);
        } else if (i4 == 4) {
            this.f47639c.setVisibility(0);
        } else if (i4 != 6) {
        } else {
            this.f47639c.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f47637a == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((getWidth() / 2) - (this.f47640d.e() / 2), (this.f47639c.getMaxCircleRadius() + this.f47639c.getPaddingTop()) - (this.f47640d.b() / 2));
            canvas.rotate(this.f47642f, this.f47640d.e() / 2, this.f47640d.b() / 2);
            this.f47640d.draw(canvas);
            canvas.restore();
        }
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.e
    public void i(float f4, int i4, int i5, int i6) {
        RefreshState refreshState = this.f47637a;
        if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.RefreshReleased) {
            return;
        }
        this.f47639c.f(Math.max(i4, 0), i5 + i6);
        this.f47639c.postInvalidate();
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
        Animator a4 = this.f47639c.a();
        a4.addListener(new a());
        a4.start();
        hVar.getLayout().postDelayed(new b(hVar), 100L);
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f47639c.getMeasuredWidth();
        int i8 = measuredWidth / 2;
        int i9 = measuredWidth2 / 2;
        int i10 = i8 - i9;
        this.f47639c.layout(i10, 0, i10 + measuredWidth2, this.f47639c.getMeasuredHeight() + 0);
        int measuredWidth3 = this.f47638b.getMeasuredWidth();
        int measuredHeight = this.f47638b.getMeasuredHeight();
        int i11 = measuredWidth3 / 2;
        int i12 = i8 - i11;
        int i13 = i9 - i11;
        int i14 = (measuredWidth2 - measuredWidth3) / 2;
        if (i13 + measuredHeight > this.f47639c.getBottom() - i14) {
            i13 = (this.f47639c.getBottom() - i14) - measuredHeight;
        }
        this.f47638b.layout(i12, i13, measuredWidth3 + i12, measuredHeight + i13);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        ViewGroup.LayoutParams layoutParams = this.f47638b.getLayoutParams();
        this.f47638b.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        this.f47639c.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), Integer.MIN_VALUE), i5);
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(this.f47638b.getMeasuredWidth(), this.f47639c.getMeasuredHeight()), i4), ViewGroup.resolveSize(Math.max(this.f47638b.getMeasuredHeight(), this.f47639c.getMeasuredHeight()), i5));
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f47639c.setIndicatorColor(iArr[0]);
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        return 0;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        this.f47639c.f(i4, i6 + i5);
        this.f47639c.postInvalidate();
        float f5 = i5;
        double min = Math.min(1.0f, Math.abs((i4 * 1.0f) / f5));
        Double.isNaN(min);
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        double max2 = Math.max(0.0f, Math.min(Math.abs(i4) - i5, f5 * 2.0f) / f5) / 4.0f;
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        this.f47641e.m(true);
        this.f47641e.k(0.0f, Math.min(0.8f, max * 0.8f));
        this.f47641e.e(Math.min(1.0f, max));
        this.f47641e.h((((0.4f * max) - 0.25f) + (((float) (max2 - pow)) * 2.0f * 2.0f)) * 0.5f);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47642f = 0;
        B(context);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47642f = 0;
        B(context);
    }

    @RequiresApi(21)
    public WaterDropHeader(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47642f = 0;
        B(context);
    }
}
