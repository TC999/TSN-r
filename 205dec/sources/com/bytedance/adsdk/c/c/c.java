package com.bytedance.adsdk.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.adsdk.c.c.a;
import com.bytedance.adsdk.c.c.a.g;
import com.bytedance.adsdk.c.c.b;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c<Decoder extends a.g<?, ?>> extends Drawable implements a.g.j, com.bytedance.adsdk.c.c.b {

    /* renamed from: l  reason: collision with root package name */
    private static final String f25262l = c.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final Paint f25263a;

    /* renamed from: b  reason: collision with root package name */
    private final Decoder f25264b;

    /* renamed from: c  reason: collision with root package name */
    private final DrawFilter f25265c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f25266d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<b.a> f25267e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f25268f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f25269g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f25270h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25271i;

    /* renamed from: j  reason: collision with root package name */
    private final Set<WeakReference<Drawable.Callback>> f25272j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25273k;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                Iterator it = new ArrayList(c.this.f25267e).iterator();
                while (it.hasNext()) {
                    ((b.a) it.next()).a(c.this);
                }
            } else if (i4 != 2) {
            } else {
                Iterator it2 = new ArrayList(c.this.f25267e).iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).b(c.this);
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.invalidateSelf();
        }
    }

    public c(g0.b bVar) {
        Paint paint = new Paint();
        this.f25263a = paint;
        this.f25265c = new PaintFlagsDrawFilter(0, 3);
        this.f25266d = new Matrix();
        this.f25267e = new HashSet();
        this.f25269g = new a(Looper.getMainLooper());
        this.f25270h = new b();
        this.f25271i = true;
        this.f25272j = new HashSet();
        this.f25273k = false;
        paint.setAntiAlias(true);
        this.f25264b = f(bVar, this);
    }

    private void d() {
        this.f25264b.I(this);
        if (this.f25271i) {
            this.f25264b.t();
        } else {
            this.f25264b.F();
        }
    }

    private void e() {
        ArrayList<WeakReference> arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z3 = false;
        for (WeakReference weakReference : new HashSet(this.f25272j)) {
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
            this.f25272j.remove(weakReference2);
        }
        if (z3) {
            return;
        }
        this.f25272j.add(new WeakReference<>(callback));
    }

    private void g() {
        this.f25264b.l(this);
        if (this.f25271i) {
            this.f25264b.o();
        } else if (this.f25264b.x()) {
        } else {
            this.f25264b.o();
        }
    }

    @Override // com.bytedance.adsdk.c.c.a.g.j
    public void a(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.f25268f;
            if (bitmap == null || bitmap.isRecycled()) {
                this.f25268f = Bitmap.createBitmap(this.f25264b.q().width() / this.f25264b.a(), this.f25264b.q().height() / this.f25264b.a(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.f25268f.getByteCount()) {
                Log.e(f25262l, "onRender:Buffer not large enough for pixels");
                return;
            }
            this.f25268f.copyPixelsFromBuffer(byteBuffer);
            this.f25269g.post(this.f25270h);
        }
    }

    @Override // com.bytedance.adsdk.c.c.a.g.j
    public void c() {
        Message.obtain(this.f25269g, 1).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f25268f;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.f25265c);
        canvas.drawBitmap(this.f25268f, this.f25266d, this.f25263a);
    }

    protected abstract Decoder f(g0.b bVar, a.g.j jVar);

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f25273k) {
            return -1;
        }
        try {
            return this.f25264b.q().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f25273k) {
            return -1;
        }
        try {
            return this.f25264b.q().width();
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
        for (WeakReference weakReference : new HashSet(this.f25272j)) {
            Drawable.Callback callback = (Drawable.Callback) weakReference.get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f25264b.x();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f25263a.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i4, int i5, int i6, int i7) {
        super.setBounds(i4, i5, i6, i7);
        boolean J = this.f25264b.J(getBounds().width(), getBounds().height());
        this.f25266d.setScale(((getBounds().width() * 1.0f) * this.f25264b.a()) / this.f25264b.q().width(), ((getBounds().height() * 1.0f) * this.f25264b.a()) / this.f25264b.q().height());
        if (J) {
            this.f25268f = Bitmap.createBitmap(this.f25264b.q().width() / this.f25264b.a(), this.f25264b.q().height() / this.f25264b.a(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f25263a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        e();
        if (this.f25271i) {
            if (z3) {
                if (!isRunning()) {
                    g();
                }
            } else if (isRunning()) {
                d();
            }
        }
        return super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f25264b.x()) {
            this.f25264b.t();
        }
        this.f25264b.w();
        g();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d();
    }

    @Override // com.bytedance.adsdk.c.c.a.g.j
    public void w() {
        Message.obtain(this.f25269g, 2).sendToTarget();
    }
}
