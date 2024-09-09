package com.umeng.social.tool;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ComposeTool {
    public static ComposeDirection direction = ComposeDirection.CUSTOM;
    public static int textColor = -16777216;
    public static int textsize = 18;
    public static int backgroundColor = -1;
    public static Typeface typeface = Typeface.DEFAULT;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum ComposeDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        LEFTUP,
        LEFTDOWN,
        RIGHTUP,
        RIGHTDOWN,
        CUSTOM
    }

    public static Bitmap createCompose(Bitmap bitmap, Bitmap bitmap2, boolean z3, int i4) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(z3 ? Math.max(width, width2) : width2 + width + i4, z3 ? height2 + height + i4 : Math.max(height, height2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (z3) {
            canvas.drawBitmap(bitmap2, 0.0f, height + i4, (Paint) null);
        } else {
            canvas.drawBitmap(bitmap2, width + i4, 0.0f, (Paint) null);
        }
        return createBitmap;
    }

    public static Bitmap createTextImage(String str, Bitmap bitmap, int i4, int i5) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textsize);
        textPaint.setDither(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(typeface);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        textPaint.getTextBounds(str, 0, str.length(), new Rect());
        Bitmap copy = bitmap.copy(config, true);
        Bitmap createBitmap = Bitmap.createBitmap(width + (i4 * 2), height + staticLayout.getHeight() + (i5 * 4), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(backgroundColor);
        float f4 = i4;
        canvas.drawBitmap(copy, f4, staticLayout.getHeight() + (i5 * 3), (Paint) null);
        canvas.translate(f4, i5);
        staticLayout.draw(canvas);
        return createBitmap;
    }

    public static Bitmap createWaterMask(Bitmap bitmap, Bitmap bitmap2, int i4, int i5) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        int i6 = (width / 2) - (width2 / 2);
        int i7 = (height / 2) - (height2 / 2);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (direction == ComposeDirection.CUSTOM) {
            canvas.drawBitmap(bitmap2, i4, i5, (Paint) null);
        } else if (direction == ComposeDirection.UP) {
            canvas.drawBitmap(bitmap2, i6, 0.0f, (Paint) null);
        } else if (direction == ComposeDirection.DOWN) {
            canvas.drawBitmap(bitmap2, i6, height - height2, (Paint) null);
        } else if (direction == ComposeDirection.LEFT) {
            canvas.drawBitmap(bitmap2, 0.0f, i7, (Paint) null);
        } else if (direction == ComposeDirection.RIGHT) {
            canvas.drawBitmap(bitmap2, width - width2, i7, (Paint) null);
        } else if (direction == ComposeDirection.LEFTUP) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        } else if (direction == ComposeDirection.LEFTDOWN) {
            canvas.drawBitmap(bitmap2, 0.0f, height - height2, (Paint) null);
        } else if (direction == ComposeDirection.RIGHTUP) {
            canvas.drawBitmap(bitmap2, width - width2, 0.0f, (Paint) null);
        } else if (direction == ComposeDirection.RIGHTDOWN) {
            canvas.drawBitmap(bitmap2, width - width2, height - height2, (Paint) null);
        }
        return createBitmap;
    }
}
