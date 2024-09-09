package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KSLinearLayout extends LinearLayout implements i {
    private final AtomicBoolean UJ;
    private final ac.a aCH;
    private i aSA;
    private g aSz;
    private float mRatio;
    private h mViewRCHelper;

    public KSLinearLayout(@NonNull Context context) {
        super(context);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        init(context, null);
    }

    @CallSuper
    private void ac() {
        this.aSz.onAttachedToWindow();
    }

    @CallSuper
    private void ad() {
        this.aSz.onDetachedFromWindow();
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i4 = R.attr.ksad_ratio;
            int[] iArr = {i4};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i4), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(this, this);
        this.aSz = gVar;
        gVar.ce(true);
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    private void tl() {
        if (this.UJ.getAndSet(false)) {
            ac();
        }
    }

    private void tm() {
        if (this.UJ.getAndSet(true)) {
            return;
        }
        ad();
    }

    @Override // com.kwad.sdk.widget.i
    @CallSuper
    public final void A(View view) {
        i iVar = this.aSA;
        if (iVar != null) {
            iVar.A(view);
        }
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
            this.aCH.z(getWidth(), getHeight());
            this.aCH.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aCH.g(motionEvent.getX(), motionEvent.getY());
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
    public ac.a getTouchCoords() {
        return this.aCH;
    }

    public float getVisiblePercent() {
        return this.aSz.getVisiblePercent();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tl();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tm();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        tl();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (this.mRatio != 0.0f) {
            i5 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i4) * this.mRatio), 1073741824);
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        this.aSz.b(i4, i5, i6, i7);
        super.onSizeChanged(i4, i5, i6, i7);
        this.aSz.NS();
        this.mViewRCHelper.onSizeChanged(i4, i5);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        tm();
    }

    public void setRadius(float f4) {
        this.mViewRCHelper.setRadius(f4);
        postInvalidate();
    }

    public void setRatio(float f4) {
        this.mRatio = f4;
    }

    public void setViewVisibleListener(i iVar) {
        this.aSA = iVar;
    }

    public void setVisiblePercent(float f4) {
        this.aSz.setVisiblePercent(f4);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        init(context, attributeSet);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        init(context, attributeSet);
    }
}
