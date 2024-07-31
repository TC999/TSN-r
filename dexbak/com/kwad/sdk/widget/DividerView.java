package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.C9659R;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DividerView extends View {
    public static int ORIENTATION_HORIZONTAL = 0;
    public static int ORIENTATION_VERTICAL = 1;
    private int aSn;
    private Paint mPaint;
    private int orientation;

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_DividerView, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C9659R.styleable.ksad_DividerView_ksad_dashGap, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(C9659R.styleable.ksad_DividerView_ksad_dashLength, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(C9659R.styleable.ksad_DividerView_ksad_dashThickness, 3);
            this.aSn = obtainStyledAttributes.getColor(C9659R.styleable.ksad_DividerView_ksad_color, ViewCompat.MEASURED_STATE_MASK);
            this.orientation = obtainStyledAttributes.getInt(C9659R.styleable.ksad_DividerView_ksad_orientation, ORIENTATION_HORIZONTAL);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(this.aSn);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(dimensionPixelSize3);
            this.mPaint.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.orientation == ORIENTATION_HORIZONTAL) {
            float height = getHeight() * 0.5f;
            canvas.drawLine(0.0f, height, getWidth(), height, this.mPaint);
            return;
        }
        float width = getWidth() * 0.5f;
        canvas.drawLine(width, 0.0f, width, getHeight(), this.mPaint);
    }

    public void setDividerColor(int i) {
        this.aSn = i;
        this.mPaint.setColor(i);
        postInvalidate();
    }

    public DividerView(Context context) {
        this(context, null);
    }
}
