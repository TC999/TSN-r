package com.kwad.components.offline.api.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.utils.TkViewRCHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RcFrameLayout extends FrameLayout {
    private float mRatio;
    private TkViewRCHelper mViewRCHelper;
    private boolean widthBasedRatio;

    public RcFrameLayout(@NonNull Context context) {
        super(context);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    private float[] getRadius(float f4, float f5, float f6, float f7) {
        return new float[]{f4, f4, f5, f5, f6, f6, f7, f7};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TkViewRCHelper tkViewRCHelper = new TkViewRCHelper();
        this.mViewRCHelper = tkViewRCHelper;
        tkViewRCHelper.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    protected boolean enableFirstVisible() {
        return true;
    }

    public boolean isWidthBasedRatio() {
        return this.widthBasedRatio;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i5 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i4) * this.mRatio), 1073741824);
            } else {
                i4 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i5) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.mViewRCHelper.onSizeChanged(i4, i5);
    }

    public void setRadius(float f4) {
        this.mViewRCHelper.setRadius(f4);
        postInvalidate();
    }

    public void setRatio(float f4) {
        this.mRatio = f4;
    }

    public void setWidthBasedRatio(boolean z3) {
        this.widthBasedRatio = z3;
    }

    public void setRadius(float f4, float f5, float f6, float f7) {
        this.mViewRCHelper.setRadius(getRadius(f4, f5, f6, f7));
        postInvalidate();
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }

    public RcFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mRatio = 0.0f;
        this.widthBasedRatio = true;
        init(context, null);
    }
}
