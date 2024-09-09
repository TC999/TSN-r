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
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KSFrameLayout extends FrameLayout implements com.kwad.sdk.core.view.d, e, i {
    private final AtomicBoolean UJ;
    private com.kwad.sdk.core.view.c aCG;
    private final ac.a aCH;
    private i aSA;
    private View aSB;
    private g aSz;
    private float mRatio;
    private h mViewRCHelper;
    private boolean widthBasedRatio;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        this.aCG = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        init(context, null);
    }

    private View getPvView() {
        View view = this.aSB;
        return view == null ? this : view;
    }

    private static float[] getRadius(float f4, float f5, float f6, float f7) {
        return new float[]{f4, f4, f5, f5, f6, f6, f7, f7};
    }

    private void tl() {
        try {
            if (this.UJ.getAndSet(false)) {
                ac();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void tm() {
        try {
            if (this.UJ.getAndSet(true)) {
                return;
            }
            ad();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @CallSuper
    public void A(View view) {
        i iVar = this.aSA;
        if (iVar != null) {
            iVar.A(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void ac() {
        this.aSz.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void ad() {
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

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public ac.a getTouchCoords() {
        return this.aCH;
    }

    public float getVisiblePercent() {
        return this.aSz.getVisiblePercent();
    }

    @Override // com.kwad.sdk.core.view.d
    @NonNull
    public com.kwad.sdk.core.view.c getWindowFocusChangeHelper() {
        return this.aCG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i4 = R.attr.ksad_ratio;
            int[] iArr = {i4};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i4), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(getPvView(), this);
        this.aSz = gVar;
        gVar.ce(true);
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tm();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        tl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i5 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i4) * this.mRatio), 1073741824);
            } else {
                i4 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i5) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
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

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        this.aCG.j(this, z3);
    }

    public void setAllCorner(boolean z3) {
        this.mViewRCHelper.getCornerConf().setAllCorner(z3);
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

    public void setWidthBasedRatio(boolean z3) {
        this.widthBasedRatio = z3;
    }

    public final void setRadius(float f4, float f5, float f6, float f7) {
        this.mViewRCHelper.setRadius(getRadius(f4, f5, f6, f7));
        postInvalidate();
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        this.aCG = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        this.aCG = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, View view) {
        super(context);
        this.UJ = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aCH = new ac.a();
        this.aCG = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        this.aSB = view;
        init(context, null);
    }
}
