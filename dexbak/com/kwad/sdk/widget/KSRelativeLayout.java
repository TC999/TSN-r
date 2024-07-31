package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11008ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSRelativeLayout extends RelativeLayout implements InterfaceC11153i {

    /* renamed from: UJ */
    private final AtomicBoolean f29690UJ;
    private final C11008ac.C11009a aCH;
    private InterfaceC11153i aSA;
    private C11149g aSz;
    private float mRatio;
    private C11151h mViewRCHelper;

    public KSRelativeLayout(@NonNull Context context) {
        super(context);
        this.f29690UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new C11008ac.C11009a();
        init(context, null);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = C9659R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            obtainStyledAttributes.recycle();
        }
        C11149g c11149g = new C11149g(this, this);
        this.aSz = c11149g;
        c11149g.m23533ce(true);
        C11151h c11151h = new C11151h();
        this.mViewRCHelper = c11151h;
        c11151h.initAttrs(context, attributeSet);
    }

    /* renamed from: tl */
    private void m23549tl() {
        if (this.f29690UJ.getAndSet(false)) {
            mo23551ac();
        }
    }

    /* renamed from: tm */
    private void m23548tm() {
        if (this.f29690UJ.getAndSet(true)) {
            return;
        }
        mo23550ad();
    }

    @Override // com.kwad.sdk.widget.InterfaceC11153i
    @CallSuper
    /* renamed from: A */
    public final void mo23527A(View view) {
        InterfaceC11153i interfaceC11153i = this.aSA;
        if (interfaceC11153i != null) {
            interfaceC11153i.mo23527A(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    /* renamed from: ac */
    public void mo23551ac() {
        this.aSz.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    /* renamed from: ad */
    public void mo23550ad() {
        this.aSz.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
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

    @MainThread
    public C11008ac.C11009a getTouchCoords() {
        return this.aCH;
    }

    public float getVisiblePercent() {
        return this.aSz.getVisiblePercent();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m23549tl();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m23548tm();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m23549tl();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.aSz.m23535b(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.aSz.m23540NS();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m23548tm();
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

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29690UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new C11008ac.C11009a();
        init(context, attributeSet);
    }

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29690UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new C11008ac.C11009a();
        init(context, attributeSet);
    }
}
