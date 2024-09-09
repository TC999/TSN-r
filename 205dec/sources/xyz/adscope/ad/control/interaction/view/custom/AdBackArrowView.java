package xyz.adscope.ad.control.interaction.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import xyz.adscope.ad.R;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdBackArrowView extends View {
    private static final int ARROW_STYLE_MATERIAL_DESIGN = 1;
    private static final int ARROW_STYLE_WECHAT_DESIGN = 2;
    private static final int DEFAULT_MIN_WIDTH = 150;
    private float mArrowLineLength;
    private Path mArrowPath;
    private float mArrowStartDistance;
    private float mArrowStrokeWidth;
    private int mArrowStyle;
    private int mColor;
    private Paint mPaint;
    private int mViewHeight;
    private int mViewWidth;

    public AdBackArrowView(Context context) {
        this(context, null);
    }

    public static int dip2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int handleMeasure(int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(150, size);
        }
        return 150;
    }

    private void init(Context context, @Nullable AttributeSet attributeSet, int i4) {
        initAttr(context, attributeSet, i4);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.mArrowStrokeWidth);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    private void initAttr(Context context, @Nullable AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.adscope_back_arrow_view, i4, 0);
        this.mColor = obtainStyledAttributes.getColor(R.styleable.adscope_back_arrow_view_adscope_bav_color, Color.argb(255, 0, 0, 0));
        this.mArrowStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.adscope_back_arrow_view_adscope_bav_stroke_width, dip2px(context, 2.0f));
        this.mArrowStyle = obtainStyledAttributes.getInt(R.styleable.adscope_back_arrow_view_adscope_bav_arrow_style, 1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((this.mViewWidth / 2.0f) - this.mArrowStartDistance, this.mViewHeight / 2);
        canvas.rotate(45.0f);
        if (this.mArrowPath == null) {
            this.mArrowPath = new Path();
        }
        this.mArrowPath.reset();
        this.mArrowPath.lineTo(0.0f, this.mArrowLineLength);
        this.mArrowPath.moveTo(0.0f, 0.0f);
        this.mArrowPath.lineTo(-this.mArrowLineLength, 0.0f);
        if (this.mArrowStyle == 1) {
            this.mArrowPath.moveTo(0.0f, 0.0f);
            Path path = this.mArrowPath;
            float f4 = this.mArrowLineLength;
            path.lineTo(f4, -f4);
        }
        this.mArrowPath.close();
        canvas.drawPath(this.mArrowPath, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        setMeasuredDimension(handleMeasure(i4), handleMeasure(i5));
    }

    @Override // android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.mViewWidth = i4;
        this.mViewHeight = i5;
        float min = Math.min(i4, i5) / 2.0f;
        int i8 = this.mArrowStyle;
        if (i8 == 1) {
            this.mArrowStartDistance = min / 3.0f;
        } else if (i8 == 2) {
            this.mArrowStartDistance = min / 4.0f;
        }
        this.mArrowLineLength = min * 0.63f;
    }

    public void setViewColor(int i4) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i4);
            invalidate();
        }
    }

    public AdBackArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdBackArrowView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context, attributeSet, i4);
    }
}
