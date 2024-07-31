package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.acse.ottn.C1239R;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RoundRectImageView extends ImageView {

    /* renamed from: a */
    private Paint f3414a;

    /* renamed from: b */
    private Paint f3415b;

    /* renamed from: c */
    private float f3416c;

    public RoundRectImageView(Context context) {
        this(context, null);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3416c = 0.0f;
        if (!isInEditMode()) {
            m55849a(context, attributeSet);
        }
        Paint paint = new Paint();
        this.f3414a = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f3415b = paint2;
        paint2.setAntiAlias(true);
    }

    /* renamed from: a */
    private int m55850a(int i) {
        return (int) (i * getContext().getResources().getDisplayMetrics().density);
    }

    /* renamed from: a */
    public static Bitmap m55847a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale((i * 1.0f) / bitmap.getWidth(), (i2 * 1.0f) / bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f = i4;
        RectF rectF = new RectF(f, f, i - i4, i2 - i4);
        float f2 = i3;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (i4 > 0) {
            Paint paint2 = new Paint(1);
            paint.setAntiAlias(true);
            paint2.setColor(-16711936);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f);
            canvas.drawRoundRect(rectF, f2, f2, paint2);
        }
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m55846a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* renamed from: a */
    private void m55849a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1239R.styleable.RoundRectImageView);
        try {
            this.f3416c = obtainStyledAttributes.getDimension(C1239R.styleable.RoundRectImageView_image_radius, -1.6711936E7f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public Bitmap m55848a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap m55848a = m55848a(m55846a(drawable), this.f3416c);
        Rect rect = new Rect(0, 0, m55848a.getWidth(), m55848a.getHeight());
        Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
        this.f3414a.reset();
        this.f3414a.setAntiAlias(true);
        canvas.drawBitmap(m55848a, rect, rect2, this.f3414a);
    }

    public void setRadius(int i) {
        this.f3416c = m55850a(i);
    }
}
