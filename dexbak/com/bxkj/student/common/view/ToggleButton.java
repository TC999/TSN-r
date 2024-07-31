package com.bxkj.student.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ToggleButton extends CompoundButton {
    private static final String TAG = "ToggleButton";
    private Paint backgroundPaint;
    private Path backgroundPath;
    private int color_off;
    private int color_on;
    private float padding;
    private Path toggleDrawPath;
    private Paint togglePaint;
    private Path togglePath_off;
    private Path togglePath_on;

    public ToggleButton(Context context) {
        this(context, null);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C4215R.styleable.ToggleButton);
        this.color_on = obtainStyledAttributes.getColor(1, -16711936);
        this.color_off = obtainStyledAttributes.getColor(0, -3355444);
        this.padding = obtainStyledAttributes.getDimension(2, 1.0f);
        obtainStyledAttributes.recycle();
    }

    private void initPaints() {
        this.backgroundPaint.setColor(isChecked() ? this.color_on : this.color_off);
        this.togglePaint.setColor(-1);
    }

    private void initPath() {
        int height = getHeight();
        int width = getWidth();
        if (height <= 0 || width <= 0) {
            return;
        }
        int min = Math.min(width, height) / 2;
        this.backgroundPath.reset();
        this.togglePath_on.reset();
        this.togglePath_off.reset();
        int i = min * 2;
        float f = i;
        RectF rectF = new RectF(0.0f, 0.0f, f, f);
        float f2 = width - i;
        float f3 = width;
        float f4 = height;
        RectF rectF2 = new RectF(f2, 0.0f, f3, f4);
        this.backgroundPath.addArc(rectF, 90.0f, 180.0f);
        this.backgroundPath.addRect(min, 0.0f, width - min, f4, Path.Direction.CCW);
        this.backgroundPath.addArc(rectF2, 270.0f, 180.0f);
        float f5 = this.padding;
        RectF rectF3 = new RectF(f2 - f5, f5, f3 - f5, f4 - f5);
        float f6 = this.padding;
        RectF rectF4 = new RectF(f6, f6, f - f6, f - f6);
        this.togglePath_on.addArc(rectF3, 90.0f, 360.0f);
        this.togglePath_off.addArc(rectF4, 90.0f, 360.0f);
        this.toggleDrawPath.set(isChecked() ? this.togglePath_on : this.togglePath_off);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.backgroundPath, this.backgroundPaint);
        canvas.drawPath(this.toggleDrawPath, this.togglePaint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (mode != 1073741824) {
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 50.0f, displayMetrics), 1073741824);
        }
        if (mode2 != 1073741824) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 30.0f, displayMetrics), 1073741824);
        }
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initPath();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        Paint paint = this.backgroundPaint;
        if (paint != null) {
            paint.setColor(checked ? this.color_on : this.color_off);
        }
        Path path = this.toggleDrawPath;
        if (path != null) {
            path.reset();
            this.toggleDrawPath.set(checked ? this.togglePath_on : this.togglePath_off);
        }
        invalidate();
    }

    public void setColor_off(int color_off) {
        this.color_off = color_off;
    }

    public void setColor_on(int color_on) {
        this.color_on = color_on;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.backgroundPaint = new Paint(1);
        this.togglePaint = new Paint(1);
        this.backgroundPath = new Path();
        this.togglePath_on = new Path();
        this.togglePath_off = new Path();
        this.toggleDrawPath = new Path();
        setClickable(true);
        initAttrs(attrs);
        initPaints();
    }
}
