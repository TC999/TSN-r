package com.umeng.socialize.shareboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocializeImageView extends ImageButton {
    public static int BG_SHAPE_CIRCULAR = 1;
    public static int BG_SHAPE_NONE = 0;
    public static int BG_SHAPE_ROUNDED_SQUARE = 2;
    private int mAngle;
    private int mBgShape;
    private int mIconPressedColor;
    private boolean mIsPressEffect;
    private boolean mIsSelected;
    private int mNormalColor;
    protected Paint mNormalPaint;
    private int mPressedColor;
    protected Paint mPressedPaint;
    private RectF mSquareRect;

    public SocializeImageView(Context context) {
        super(context);
        init();
    }

    private void drawCircle(Canvas canvas, Paint paint) {
        float measuredWidth = getMeasuredWidth() / 2;
        canvas.drawCircle(measuredWidth, measuredWidth, measuredWidth, paint);
    }

    private void drawRect(Canvas canvas, Paint paint) {
        if (this.mSquareRect == null) {
            RectF rectF = new RectF();
            this.mSquareRect = rectF;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.mSquareRect.bottom = getMeasuredWidth();
        }
        RectF rectF2 = this.mSquareRect;
        int i = this.mAngle;
        canvas.drawRoundRect(rectF2, i, i, paint);
    }

    private void init() {
        setBackground(null);
        setClickable(false);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    protected int dip2px(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mIsPressEffect) {
            if (isPressed()) {
                if (BG_SHAPE_NONE == this.mBgShape) {
                    int i = this.mIconPressedColor;
                    if (i != 0) {
                        setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
                        return;
                    }
                    return;
                }
                this.mIsSelected = true;
                invalidate();
            } else if (BG_SHAPE_NONE == this.mBgShape) {
                clearColorFilter();
            } else {
                this.mIsSelected = false;
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        int i = this.mBgShape;
        if (i == BG_SHAPE_NONE) {
            super.onDraw(canvas);
            return;
        }
        if (this.mIsSelected) {
            if (this.mIsPressEffect && (paint = this.mPressedPaint) != null) {
                if (i == BG_SHAPE_CIRCULAR) {
                    drawCircle(canvas, paint);
                } else if (i == BG_SHAPE_ROUNDED_SQUARE) {
                    drawRect(canvas, paint);
                }
            }
        } else if (i == BG_SHAPE_CIRCULAR) {
            drawCircle(canvas, this.mNormalPaint);
        } else if (i == BG_SHAPE_ROUNDED_SQUARE) {
            drawRect(canvas, this.mNormalPaint);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        setBackgroundColor(i, 0);
    }

    public void setBackgroundShape(int i) {
        setBackgroundShape(i, 0);
    }

    public void setPressEffectEnable(boolean z) {
        this.mIsPressEffect = z;
    }

    public void setPressedColor(int i) {
        setPressEffectEnable(i != 0);
        this.mIconPressedColor = i;
    }

    public void setBackgroundColor(int i, int i2) {
        this.mNormalColor = i;
        this.mPressedColor = i2;
        setPressEffectEnable(i2 != 0);
        if (this.mNormalColor != 0) {
            Paint paint = new Paint();
            this.mNormalPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mNormalPaint.setAntiAlias(true);
            this.mNormalPaint.setColor(i);
        }
        if (this.mPressedColor != 0) {
            Paint paint2 = new Paint();
            this.mPressedPaint = paint2;
            paint2.setStyle(Paint.Style.FILL);
            this.mPressedPaint.setAntiAlias(true);
            this.mPressedPaint.setColor(i2);
        }
    }

    public void setBackgroundShape(int i, int i2) {
        this.mBgShape = i;
        if (i != BG_SHAPE_ROUNDED_SQUARE) {
            this.mAngle = 0;
            return;
        }
        this.mAngle = (int) ((i2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public SocializeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SocializeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public SocializeImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
