package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* compiled from: SameImageTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class w {
    public static Bitmap a(Bitmap bitmap, int i4, int i5) {
        if (i5 == 0) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(bitmap2);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, width, height);
                RectF rectF = new RectF(rect);
                float f4 = i5;
                paint.setAntiAlias(true);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-12434878);
                canvas.drawRoundRect(rectF, f4, f4, paint);
                if (i4 == 2) {
                    canvas.drawRect(0.0f, height - i5, width, height, paint);
                }
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
            } catch (Error | Exception unused) {
            }
        }
        return bitmap2;
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                    RenderScript create = RenderScript.create(com.mbridge.msdk.foundation.controller.a.f().j());
                    ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
                    Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                    create2.setRadius(25.0f);
                    create2.setInput(createFromBitmap);
                    create2.forEach(createFromBitmap2);
                    createFromBitmap2.copyTo(createBitmap);
                    create.destroy();
                    return createBitmap;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
