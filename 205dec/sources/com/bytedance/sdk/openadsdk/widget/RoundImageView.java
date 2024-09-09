package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class RoundImageView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private int f36363c;

    /* renamed from: w  reason: collision with root package name */
    private int f36364w;
    private int xv;

    public RoundImageView(Context context) {
        super(context);
        this.f36363c = 0;
        this.f36364w = 0;
        this.xv = 0;
    }

    private Bitmap c(Bitmap bitmap, int i4) {
        Bitmap createBitmap;
        int i5 = i4 * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else {
            createBitmap = height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        }
        if (createBitmap != null) {
            bitmap = createBitmap;
        }
        if (bitmap.getWidth() != i5 || bitmap.getHeight() != i5) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i5, i5, true);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        int i4;
        Bitmap bitmap3;
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
            return;
        }
        try {
            bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        } catch (Throwable unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.f36363c == 0) {
            this.f36363c = getWidth();
        }
        if (this.f36364w == 0) {
            this.f36364w = getHeight();
        }
        int i5 = this.f36363c;
        int i6 = this.f36364w;
        if (i5 >= i6) {
            i5 = i6;
        }
        try {
            bitmap3 = c(bitmap2, i5 / 2);
        } catch (Throwable unused2) {
            bitmap3 = null;
        }
        if (bitmap3 == null) {
            super.onDraw(canvas);
        } else {
            canvas.drawBitmap(bitmap3, (this.f36363c / 2) - i4, (this.f36364w / 2) - i4, (Paint) null);
        }
    }
}
