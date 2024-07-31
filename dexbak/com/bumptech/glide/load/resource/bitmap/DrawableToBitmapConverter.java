package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

/* renamed from: com.bumptech.glide.load.resource.bitmap.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class DrawableToBitmapConverter {

    /* renamed from: a */
    private static final String f14141a = "DrawableToBitmap";

    /* renamed from: b */
    private static final BitmapPool f14142b = new C3723a();

    /* compiled from: DrawableToBitmapConverter.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.o$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3723a extends BitmapPoolAdapter {
        C3723a() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        /* renamed from: d */
        public void mo44924d(Bitmap bitmap) {
        }
    }

    private DrawableToBitmapConverter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static Resource<Bitmap> m44926a(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = m44925b(bitmapPool, current, i, i2);
            z = true;
        }
        if (!z) {
            bitmapPool = f14142b;
        }
        return BitmapResource.m44977d(bitmap, bitmapPool);
    }

    @Nullable
    /* renamed from: b */
    private static Bitmap m44925b(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(f14141a, 5)) {
                Log.w(f14141a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(f14141a, 5)) {
                Log.w(f14141a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock m44893i = TransformationUtils.m44893i();
            m44893i.lock();
            Bitmap mo45373e = bitmapPool.mo45373e(i, i2, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(mo45373e);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return mo45373e;
            } finally {
                m44893i.unlock();
            }
        }
    }
}
