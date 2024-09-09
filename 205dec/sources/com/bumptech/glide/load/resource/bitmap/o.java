package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableToBitmapConverter.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17458a = "DrawableToBitmap";

    /* renamed from: b  reason: collision with root package name */
    private static final com.bumptech.glide.load.engine.bitmap_recycle.e f17459b = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DrawableToBitmapConverter.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a extends com.bumptech.glide.load.engine.bitmap_recycle.f {
        a() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f, com.bumptech.glide.load.engine.bitmap_recycle.e
        public void d(Bitmap bitmap) {
        }
    }

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static com.bumptech.glide.load.engine.u<Bitmap> a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i4, int i5) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z3 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = b(eVar, current, i4, i5);
            z3 = true;
        }
        if (!z3) {
            eVar = f17459b;
        }
        return f.d(bitmap, eVar);
    }

    @Nullable
    private static Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i4, int i5) {
        if (i4 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i5 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i4 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i5 = drawable.getIntrinsicHeight();
            }
            Lock i6 = z.i();
            i6.lock();
            Bitmap e4 = eVar.e(i4, i5, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(e4);
                drawable.setBounds(0, 0, i4, i5);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return e4;
            } finally {
                i6.unlock();
            }
        }
    }
}
