package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.C3770j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.InterfaceC3731b, Animatable, Animatable2Compat {

    /* renamed from: l */
    public static final int f14192l = -1;

    /* renamed from: m */
    public static final int f14193m = 0;

    /* renamed from: n */
    private static final int f14194n = 119;

    /* renamed from: a */
    private final C3727a f14195a;

    /* renamed from: b */
    private boolean f14196b;

    /* renamed from: c */
    private boolean f14197c;

    /* renamed from: d */
    private boolean f14198d;

    /* renamed from: e */
    private boolean f14199e;

    /* renamed from: f */
    private int f14200f;

    /* renamed from: g */
    private int f14201g;

    /* renamed from: h */
    private boolean f14202h;

    /* renamed from: i */
    private Paint f14203i;

    /* renamed from: j */
    private Rect f14204j;

    /* renamed from: k */
    private List<Animatable2Compat.AnimationCallback> f14205k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.resource.gif.GifDrawable$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3727a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a */
        final GifFrameLoader f14206a;

        C3727a(GifFrameLoader gifFrameLoader) {
            this.f14206a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i, i2, bitmap);
    }

    /* renamed from: b */
    private Drawable.Callback m44859b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    /* renamed from: d */
    private Rect m44857d() {
        if (this.f14204j == null) {
            this.f14204j = new Rect();
        }
        return this.f14204j;
    }

    /* renamed from: i */
    private Paint m44852i() {
        if (this.f14203i == null) {
            this.f14203i = new Paint(2);
        }
        return this.f14203i;
    }

    /* renamed from: l */
    private void m44849l() {
        List<Animatable2Compat.AnimationCallback> list = this.f14205k;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.f14205k.get(i).onAnimationEnd(this);
            }
        }
    }

    /* renamed from: n */
    private void m44847n() {
        this.f14200f = 0;
    }

    /* renamed from: s */
    private void m44842s() {
        C3770j.m44395a(!this.f14198d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f14195a.f14206a.m44817f() == 1) {
            invalidateSelf();
        } else if (this.f14196b) {
        } else {
            this.f14196b = true;
            this.f14195a.f14206a.m44800w(this);
            invalidateSelf();
        }
    }

    /* renamed from: t */
    private void m44841t() {
        this.f14196b = false;
        this.f14195a.f14206a.m44799x(this);
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.InterfaceC3731b
    /* renamed from: a */
    public void mo44796a() {
        if (m44859b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (m44854g() == m44855f() - 1) {
            this.f14200f++;
        }
        int i = this.f14201g;
        if (i == -1 || this.f14200f < i) {
            return;
        }
        m44849l();
        stop();
    }

    /* renamed from: c */
    public ByteBuffer m44858c() {
        return this.f14195a.f14206a.m44821b();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f14205k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f14198d) {
            return;
        }
        if (this.f14202h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m44857d());
            this.f14202h = false;
        }
        canvas.drawBitmap(this.f14195a.f14206a.m44820c(), (Rect) null, m44857d(), m44852i());
    }

    /* renamed from: e */
    public Bitmap m44856e() {
        return this.f14195a.f14206a.m44818e();
    }

    /* renamed from: f */
    public int m44855f() {
        return this.f14195a.f14206a.m44817f();
    }

    /* renamed from: g */
    public int m44854g() {
        return this.f14195a.f14206a.m44819d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f14195a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14195a.f14206a.m44813j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14195a.f14206a.m44809n();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* renamed from: h */
    public Transformation<Bitmap> m44853h() {
        return this.f14195a.f14206a.m44814i();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f14196b;
    }

    /* renamed from: j */
    public int m44851j() {
        return this.f14195a.f14206a.m44810m();
    }

    /* renamed from: k */
    boolean m44850k() {
        return this.f14198d;
    }

    /* renamed from: m */
    public void m44848m() {
        this.f14198d = true;
        this.f14195a.f14206a.m44822a();
    }

    /* renamed from: o */
    public void m44846o(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f14195a.f14206a.m44805r(transformation, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f14202h = true;
    }

    /* renamed from: p */
    void m44845p(boolean z) {
        this.f14196b = z;
    }

    /* renamed from: q */
    public void m44844q(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            int m44812k = this.f14195a.f14206a.m44812k();
            this.f14201g = m44812k != 0 ? m44812k : -1;
            return;
        }
        this.f14201g = i;
    }

    /* renamed from: r */
    public void m44843r() {
        C3770j.m44395a(!this.f14196b, "You cannot restart a currently running animation.");
        this.f14195a.f14206a.m44804s();
        start();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f14205k == null) {
            this.f14205k = new ArrayList();
        }
        this.f14205k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        m44852i().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m44852i().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        C3770j.m44395a(!this.f14198d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f14199e = z;
        if (!z) {
            m44841t();
        } else if (this.f14197c) {
            m44842s();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f14197c = true;
        m44847n();
        if (this.f14199e) {
            m44842s();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f14197c = false;
        m44841t();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f14205k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new C3727a(new GifFrameLoader(Glide.m45744d(context), gifDecoder, i, i2, transformation, bitmap)));
    }

    GifDrawable(C3727a c3727a) {
        this.f14199e = true;
        this.f14201g = -1;
        this.f14195a = (C3727a) C3770j.m44392d(c3727a);
    }

    @VisibleForTesting
    GifDrawable(GifFrameLoader gifFrameLoader, Paint paint) {
        this(new C3727a(gifFrameLoader));
        this.f14203i = paint;
    }
}
