package com.mbridge.msdk.widget.custom.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBRoundRectImageViewC extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f41242a;

    public MBRoundRectImageViewC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41242a = new Paint();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            int width = getWidth();
            int height = getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(width / bitmap.getWidth(), height / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            int a4 = com.mbridge.msdk.widget.custom.b.a.a(getContext(), 10.0f);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(createBitmap2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            RectF rectF = new RectF(0.0f, 0.0f, createBitmap.getWidth(), createBitmap.getHeight());
            float f4 = a4;
            canvas2.drawRoundRect(rectF, f4, f4, paint);
            Rect rect = new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight());
            this.f41242a.reset();
            canvas.drawBitmap(createBitmap2, rect, rect, this.f41242a);
            return;
        }
        super.onDraw(canvas);
    }
}
