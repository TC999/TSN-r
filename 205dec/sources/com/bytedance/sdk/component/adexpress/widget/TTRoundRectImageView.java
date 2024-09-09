package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTRoundRectImageView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private Paint f29637c;
    private Matrix sr;

    /* renamed from: w  reason: collision with root package name */
    private int f29638w;
    private int xv;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap c(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap c4 = c(drawable);
            if (c4 != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(c4, tileMode, tileMode);
                float f4 = 1.0f;
                if (c4.getWidth() != getWidth() || c4.getHeight() != getHeight()) {
                    f4 = Math.max((getWidth() * 1.0f) / c4.getWidth(), (getHeight() * 1.0f) / c4.getHeight());
                }
                this.sr.setScale(f4, f4);
                bitmapShader.setLocalMatrix(this.sr);
                this.f29637c.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f29638w, this.xv, this.f29637c);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    public void setXRound(int i4) {
        this.f29638w = i4;
        postInvalidate();
    }

    public void setYRound(int i4) {
        this.xv = i4;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f29638w = 25;
        this.xv = 25;
        Paint paint = new Paint();
        this.f29637c = paint;
        paint.setAntiAlias(true);
        this.f29637c.setFilterBitmap(true);
        this.sr = new Matrix();
    }
}
