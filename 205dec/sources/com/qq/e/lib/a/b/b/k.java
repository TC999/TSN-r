package com.qq.e.lib.a.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k extends com.qq.e.lib.a.c.a<com.qq.e.lib.a.b.c.a, com.qq.e.lib.a.b.c.b> {

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ boolean f47302i = !k.class.desiredAssertionStatus();

    public k(com.qq.e.lib.a.b.c.a aVar) {
        super(aVar);
    }

    @Override // com.qq.e.lib.a.c.a
    public Bitmap a(Canvas canvas, Paint paint, int i4, Bitmap bitmap, com.qq.e.lib.a.b.c.b bVar) {
        Bitmap decodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i4;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.qq.e.lib.a.b.c.a) this.f47304a).reset();
            try {
                decodeStream = BitmapFactory.decodeStream(((com.qq.e.lib.a.b.c.a) this.f47304a).a(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i4;
                options2.inMutable = true;
                decodeStream = BitmapFactory.decodeStream(((com.qq.e.lib.a.b.c.a) this.f47304a).a(), null, options2);
            }
            try {
                if (!f47302i && decodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
                return decodeStream;
            } catch (IOException e4) {
                e = e4;
                bitmap2 = decodeStream;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            return bitmap2;
        }
    }
}
