package com.qq.e.lib.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.qq.e.lib.a.c.b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a<Decoder extends b<?, ?>> extends Drawable implements Animatable, b.j {

    /* renamed from: m  reason: collision with root package name */
    private static final String f47254m = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private final Decoder f47256d;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f47259g;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f47255c = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private final DrawFilter f47257e = new PaintFlagsDrawFilter(0, 3);

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f47258f = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    private final Handler f47260h = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f47261i = new RunnableC0921a();

    /* renamed from: j  reason: collision with root package name */
    private boolean f47262j = true;

    /* renamed from: k  reason: collision with root package name */
    private final Set<WeakReference<Drawable.Callback>> f47263k = new HashSet();

    /* renamed from: l  reason: collision with root package name */
    private boolean f47264l = false;

    /* compiled from: A */
    /* renamed from: com.qq.e.lib.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0921a implements Runnable {
        RunnableC0921a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.invalidateSelf();
        }
    }

    public a(com.qq.e.lib.a.f.b bVar) {
        this.f47255c.setAntiAlias(true);
        this.f47256d = a(bVar, this);
    }

    private void b() {
        ArrayList<WeakReference> arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z3 = false;
        for (WeakReference weakReference : new HashSet(this.f47263k)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z3 = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        for (WeakReference weakReference2 : arrayList) {
            this.f47263k.remove(weakReference2);
        }
        if (z3) {
            return;
        }
        this.f47263k.add(new WeakReference<>(callback));
    }

    private void c() {
        this.f47256d.a(this);
        if (this.f47262j) {
            this.f47256d.o();
        } else if (this.f47256d.l()) {
        } else {
            this.f47256d.o();
        }
    }

    private void d() {
        this.f47256d.b(this);
        if (this.f47262j) {
            this.f47256d.q();
        } else {
            this.f47256d.r();
        }
    }

    protected abstract Decoder a(com.qq.e.lib.a.f.b bVar, b.j jVar);

    @Override // com.qq.e.lib.a.c.b.j
    public void a() {
    }

    @Override // com.qq.e.lib.a.c.b.j
    public void a(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.f47259g;
            if (bitmap == null || bitmap.isRecycled()) {
                this.f47259g = Bitmap.createBitmap(this.f47256d.d().width() / this.f47256d.h(), this.f47256d.d().height() / this.f47256d.h(), Bitmap.Config.ARGB_8888);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.f47259g.getByteCount()) {
                Log.e(f47254m, "onRender:Buffer not large enough for pixels");
                return;
            }
            this.f47259g.copyPixelsFromBuffer(byteBuffer);
            this.f47260h.post(this.f47261i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f47259g;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.f47257e);
        canvas.drawBitmap(this.f47259g, this.f47258f, this.f47255c);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f47264l) {
            return -1;
        }
        try {
            return this.f47256d.d().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f47264l) {
            return -1;
        }
        try {
            return this.f47256d.d().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        for (WeakReference weakReference : new HashSet(this.f47263k)) {
            Drawable.Callback callback = (Drawable.Callback) weakReference.get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f47256d.l();
    }

    @Override // com.qq.e.lib.a.c.b.j
    public void onStart() {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f47255c.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i4, int i5, int i6, int i7) {
        super.setBounds(i4, i5, i6, i7);
        boolean c4 = this.f47256d.c(getBounds().width(), getBounds().height());
        this.f47258f.setScale(((getBounds().width() * 1.0f) * this.f47256d.h()) / this.f47256d.d().width(), ((getBounds().height() * 1.0f) * this.f47256d.h()) / this.f47256d.d().height());
        if (c4) {
            this.f47259g = Bitmap.createBitmap(this.f47256d.d().width() / this.f47256d.h(), this.f47256d.d().height() / this.f47256d.h(), Bitmap.Config.ARGB_8888);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f47255c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        b();
        if (this.f47262j) {
            if (z3) {
                if (!isRunning()) {
                    c();
                }
            } else if (isRunning()) {
                d();
            }
        }
        return super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f47256d.l()) {
            this.f47256d.q();
        }
        this.f47256d.n();
        c();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d();
    }
}
