package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.view.C10593c;
import com.kwad.sdk.core.view.InterfaceC10594d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11008ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSFrameLayout extends FrameLayout implements InterfaceC10594d, InterfaceC11147e, InterfaceC11153i {

    /* renamed from: UJ */
    private final AtomicBoolean f29687UJ;
    private C10593c aCG;
    private final C11008ac.C11009a aCH;
    private InterfaceC11153i aSA;
    private View aSB;
    private C11149g aSz;
    private float mRatio;
    private C11151h mViewRCHelper;
    private boolean widthBasedRatio;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.f29687UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new C11008ac.C11009a();
        this.aCG = new C10593c();
        this.widthBasedRatio = true;
        init(context, null);
    }

    private View getPvView() {
        View view = this.aSB;
        return view == null ? this : view;
    }

    private static float[] getRadius(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    /* renamed from: tl */
    private void m23563tl() {
        try {
            if (this.f29687UJ.getAndSet(false)) {
                mo23565ac();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: tm */
    private void m23562tm() {
        try {
            if (this.f29687UJ.getAndSet(true)) {
                return;
            }
            mo23564ad();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @CallSuper
    /* renamed from: A */
    public void mo23527A(View view) {
        InterfaceC11153i interfaceC11153i = this.aSA;
        if (interfaceC11153i != null) {
            interfaceC11153i.mo23527A(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    /* renamed from: ac */
    public void mo23565ac() {
        this.aSz.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    /* renamed from: ad */
    public void mo23564ad() {
        this.aSz.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.aCH.m24146z(getWidth(), getHeight());
            this.aCH.m24148f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aCH.m24147g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11147e
    @MainThread
    public C11008ac.C11009a getTouchCoords() {
        return this.aCH;
    }

    public float getVisiblePercent() {
        return this.aSz.getVisiblePercent();
    }

    @Override // com.kwad.sdk.core.view.InterfaceC10594d
    @NonNull
    public C10593c getWindowFocusChangeHelper() {
        return this.aCG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = C9659R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            obtainStyledAttributes.recycle();
        }
        C11149g c11149g = new C11149g(getPvView(), this);
        this.aSz = c11149g;
        c11149g.m23533ce(true);
        C11151h c11151h = new C11151h();
        this.mViewRCHelper = c11151h;
        c11151h.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m23563tl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m23562tm();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m23563tl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.aSz.m23535b(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.aSz.m23540NS();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m23562tm();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.aCG.m25357j(this, z);
    }

    public void setAllCorner(boolean z) {
        this.mViewRCHelper.getCornerConf().setAllCorner(z);
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public void setViewVisibleListener(InterfaceC11153i interfaceC11153i) {
        this.aSA = interfaceC11153i;
    }

    public void setVisiblePercent(float f) {
        this.aSz.setVisiblePercent(f);
    }

    public void setWidthBasedRatio(boolean z) {
        this.widthBasedRatio = z;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mViewRCHelper.setRadius(getRadius(f, f2, f3, f4));
        postInvalidate();
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29687UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new C11008ac.C11009a();
        this.aCG = new C10593c();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29687UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new C11008ac.C11009a();
        this.aCG = new C10593c();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, View view) {
        super(context);
        this.f29687UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new C11008ac.C11009a();
        this.aCG = new C10593c();
        this.widthBasedRatio = true;
        this.aSB = view;
        init(context, null);
    }
}
