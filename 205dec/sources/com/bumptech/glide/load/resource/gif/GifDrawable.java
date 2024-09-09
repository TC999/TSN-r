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
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.resource.gif.f;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class GifDrawable extends Drawable implements f.b, Animatable, Animatable2Compat {

    /* renamed from: l  reason: collision with root package name */
    public static final int f17509l = -1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f17510m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f17511n = 119;

    /* renamed from: a  reason: collision with root package name */
    private final a f17512a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17513b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17514c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17515d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17516e;

    /* renamed from: f  reason: collision with root package name */
    private int f17517f;

    /* renamed from: g  reason: collision with root package name */
    private int f17518g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17519h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f17520i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f17521j;

    /* renamed from: k  reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f17522k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        final f f17523a;

        a(f fVar) {
            this.f17523a = fVar;
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
    public GifDrawable(Context context, GifDecoder gifDecoder, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.i<Bitmap> iVar, int i4, int i5, Bitmap bitmap) {
        this(context, gifDecoder, iVar, i4, i5, bitmap);
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f17521j == null) {
            this.f17521j = new Rect();
        }
        return this.f17521j;
    }

    private Paint i() {
        if (this.f17520i == null) {
            this.f17520i = new Paint(2);
        }
        return this.f17520i;
    }

    private void l() {
        List<Animatable2Compat.AnimationCallback> list = this.f17522k;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f17522k.get(i4).onAnimationEnd(this);
            }
        }
    }

    private void n() {
        this.f17517f = 0;
    }

    private void s() {
        j.a(!this.f17515d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f17512a.f17523a.f() == 1) {
            invalidateSelf();
        } else if (this.f17513b) {
        } else {
            this.f17513b = true;
            this.f17512a.f17523a.w(this);
            invalidateSelf();
        }
    }

    private void t() {
        this.f17513b = false;
        this.f17512a.f17523a.x(this);
    }

    @Override // com.bumptech.glide.load.resource.gif.f.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f17517f++;
        }
        int i4 = this.f17518g;
        if (i4 == -1 || this.f17517f < i4) {
            return;
        }
        l();
        stop();
    }

    public ByteBuffer c() {
        return this.f17512a.f17523a.b();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f17522k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f17515d) {
            return;
        }
        if (this.f17519h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f17519h = false;
        }
        canvas.drawBitmap(this.f17512a.f17523a.c(), (Rect) null, d(), i());
    }

    public Bitmap e() {
        return this.f17512a.f17523a.e();
    }

    public int f() {
        return this.f17512a.f17523a.f();
    }

    public int g() {
        return this.f17512a.f17523a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f17512a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17512a.f17523a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17512a.f17523a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public com.bumptech.glide.load.i<Bitmap> h() {
        return this.f17512a.f17523a.i();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f17513b;
    }

    public int j() {
        return this.f17512a.f17523a.m();
    }

    boolean k() {
        return this.f17515d;
    }

    public void m() {
        this.f17515d = true;
        this.f17512a.f17523a.a();
    }

    public void o(com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.f17512a.f17523a.r(iVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f17519h = true;
    }

    void p(boolean z3) {
        this.f17513b = z3;
    }

    public void q(int i4) {
        if (i4 <= 0 && i4 != -1 && i4 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i4 == 0) {
            int k4 = this.f17512a.f17523a.k();
            this.f17518g = k4 != 0 ? k4 : -1;
            return;
        }
        this.f17518g = i4;
    }

    public void r() {
        j.a(!this.f17513b, "You cannot restart a currently running animation.");
        this.f17512a.f17523a.s();
        start();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f17522k == null) {
            this.f17522k = new ArrayList();
        }
        this.f17522k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        i().setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        i().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        j.a(!this.f17515d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f17516e = z3;
        if (!z3) {
            t();
        } else if (this.f17514c) {
            s();
        }
        return super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f17514c = true;
        n();
        if (this.f17516e) {
            s();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f17514c = false;
        t();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f17522k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, com.bumptech.glide.load.i<Bitmap> iVar, int i4, int i5, Bitmap bitmap) {
        this(new a(new f(com.bumptech.glide.d.d(context), gifDecoder, i4, i5, iVar, bitmap)));
    }

    GifDrawable(a aVar) {
        this.f17516e = true;
        this.f17518g = -1;
        this.f17512a = (a) j.d(aVar);
    }

    @VisibleForTesting
    GifDrawable(f fVar, Paint paint) {
        this(new a(fVar));
        this.f17520i = paint;
    }
}
