package cn.jpush.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class RoundedImageView extends ImageView {
    private int defaultRadius;
    private float height;
    private int leftBottomRadius;
    private int leftTopRadius;
    private int radius;
    private int rightBottomRadius;
    private int rightTopRadius;
    private float width;

    public RoundedImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context, attributeSet);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.defaultRadius = 45;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int i4 = this.defaultRadius;
        this.leftTopRadius = i4;
        this.rightTopRadius = i4;
        this.rightBottomRadius = i4;
        this.leftBottomRadius = i4;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int max = Math.max(this.leftTopRadius, this.leftBottomRadius) + Math.max(this.rightTopRadius, this.rightBottomRadius);
        int max2 = Math.max(this.leftTopRadius, this.rightTopRadius) + Math.max(this.leftBottomRadius, this.rightBottomRadius);
        if (this.width >= max && this.height > max2) {
            Path path = new Path();
            path.moveTo(this.leftTopRadius, 0.0f);
            path.lineTo(this.width - this.rightTopRadius, 0.0f);
            float f4 = this.width;
            path.quadTo(f4, 0.0f, f4, this.rightTopRadius);
            path.lineTo(this.width, this.height - this.rightBottomRadius);
            float f5 = this.width;
            float f6 = this.height;
            path.quadTo(f5, f6, f5 - this.rightBottomRadius, f6);
            path.lineTo(this.leftBottomRadius, this.height);
            float f7 = this.height;
            path.quadTo(0.0f, f7, 0.0f, f7 - this.leftBottomRadius);
            path.lineTo(0.0f, this.leftTopRadius);
            path.quadTo(0.0f, 0.0f, this.leftTopRadius, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.width = getWidth();
        this.height = getHeight();
    }

    public void setRadius(int i4, int i5, int i6, int i7) {
        this.leftTopRadius = i4;
        this.rightTopRadius = i5;
        this.rightBottomRadius = i6;
        this.leftBottomRadius = i7;
        invalidate();
    }
}
