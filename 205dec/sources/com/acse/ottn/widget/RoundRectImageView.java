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
import com.acse.ottn.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class RoundRectImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f6961a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f6962b;

    /* renamed from: c  reason: collision with root package name */
    public float f6963c;

    public RoundRectImageView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundRectImageView);
        try {
            this.f6963c = obtainStyledAttributes.getDimension(R.styleable.RoundRectImageView_image_radius, -1.6711936E7f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a4 = a(a(drawable), this.f6963c);
            Rect rect = new Rect(0, 0, a4.getWidth(), a4.getHeight());
            Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
            this.f6961a.reset();
            this.f6961a.setAntiAlias(true);
            canvas.drawBitmap(a4, rect, rect2, this.f6961a);
            return;
        }
        super.onDraw(canvas);
    }

    public void setRadius(int i4) {
        this.f6963c = a(i4);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6963c = 0.0f;
        if (!isInEditMode()) {
            a(context, attributeSet);
        }
        Paint paint = new Paint();
        this.f6961a = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f6962b = paint2;
        paint2.setAntiAlias(true);
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i4, int i5, int i6, int i7) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale((i4 * 1.0f) / bitmap.getWidth(), (i5 * 1.0f) / bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f4 = i7;
        RectF rectF = new RectF(f4, f4, i4 - i7, i5 - i7);
        float f5 = i6;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        if (i7 > 0) {
            Paint paint2 = new Paint(1);
            paint.setAntiAlias(true);
            paint2.setColor(-16711936);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f4);
            canvas.drawRoundRect(rectF, f5, f5, paint2);
        }
        return createBitmap;
    }

    public Bitmap a(Bitmap bitmap, float f4) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f4, f4, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public final int a(int i4) {
        return (int) (i4 * getContext().getResources().getDisplayMetrics().density);
    }
}
