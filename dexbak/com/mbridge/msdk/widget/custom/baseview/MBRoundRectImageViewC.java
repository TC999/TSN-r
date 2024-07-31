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
import com.mbridge.msdk.widget.custom.p517b.DensityUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBRoundRectImageViewC extends MBImageView {

    /* renamed from: a */
    private Paint f32555a;

    public MBRoundRectImageViewC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32555a = new Paint();
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
            int m20579a = DensityUtil.m20579a(getContext(), 10.0f);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(createBitmap2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            RectF rectF = new RectF(0.0f, 0.0f, createBitmap.getWidth(), createBitmap.getHeight());
            float f = m20579a;
            canvas2.drawRoundRect(rectF, f, f, paint);
            Rect rect = new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight());
            this.f32555a.reset();
            canvas.drawBitmap(createBitmap2, rect, rect, this.f32555a);
            return;
        }
        super.onDraw(canvas);
    }
}
