package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.c0;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.a;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseRequestOptions.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int A = -1;
    private static final int B = 2;
    private static final int C = 4;
    private static final int D = 8;
    private static final int E = 16;
    private static final int F = 32;
    private static final int G = 64;
    private static final int H = 128;
    private static final int I = 256;
    private static final int J = 512;
    private static final int K = 1024;

    /* renamed from: L  reason: collision with root package name */
    private static final int f17879L = 2048;
    private static final int M = 4096;
    private static final int N = 8192;
    private static final int O = 16384;
    private static final int P = 32768;
    private static final int Q = 65536;
    private static final int R = 131072;
    private static final int S = 262144;
    private static final int T = 524288;
    private static final int U = 1048576;

    /* renamed from: a  reason: collision with root package name */
    private int f17880a;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Drawable f17884e;

    /* renamed from: f  reason: collision with root package name */
    private int f17885f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Drawable f17886g;

    /* renamed from: h  reason: collision with root package name */
    private int f17887h;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17892m;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Drawable f17894o;

    /* renamed from: p  reason: collision with root package name */
    private int f17895p;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17899t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private Resources.Theme f17900u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f17901v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f17902w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f17903x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f17905z;

    /* renamed from: b  reason: collision with root package name */
    private float f17881b = 1.0f;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.engine.j f17882c = com.bumptech.glide.load.engine.j.f17107e;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private Priority f17883d = Priority.NORMAL;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17888i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f17889j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f17890k = -1;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private com.bumptech.glide.load.c f17891l = com.bumptech.glide.signature.b.c();

    /* renamed from: n  reason: collision with root package name */
    private boolean f17893n = true;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    private com.bumptech.glide.load.f f17896q = new com.bumptech.glide.load.f();
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.i<?>> f17897r = new CachedHashCodeArrayMap();
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    private Class<?> f17898s = Object.class;

    /* renamed from: y  reason: collision with root package name */
    private boolean f17904y = true;

    @NonNull
    private T A0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar, boolean z3) {
        T L0 = z3 ? L0(downsampleStrategy, iVar) : s0(downsampleStrategy, iVar);
        L0.f17904y = true;
        return L0;
    }

    private T B0() {
        return this;
    }

    @NonNull
    private T C0() {
        if (!this.f17899t) {
            return B0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    private boolean d0(int i4) {
        return e0(this.f17880a, i4);
    }

    private static boolean e0(int i4, int i5) {
        return (i4 & i5) != 0;
    }

    @NonNull
    private T q0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return A0(downsampleStrategy, iVar, false);
    }

    @NonNull
    private T z0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return A0(downsampleStrategy, iVar, true);
    }

    @NonNull
    @CheckResult
    public T A(@Nullable Drawable drawable) {
        if (this.f17901v) {
            return (T) clone().A(drawable);
        }
        this.f17894o = drawable;
        this.f17895p = 0;
        this.f17880a = (this.f17880a | 8192) & (-16385);
        return C0();
    }

    @NonNull
    @CheckResult
    public T B() {
        return z0(DownsampleStrategy.f17375a, new r());
    }

    @NonNull
    @CheckResult
    public T C(@NonNull DecodeFormat decodeFormat) {
        com.bumptech.glide.util.j.d(decodeFormat);
        return (T) D0(n.f17442g, decodeFormat).D0(com.bumptech.glide.load.resource.gif.h.f17561a, decodeFormat);
    }

    @NonNull
    @CheckResult
    public T D(@IntRange(from = 0) long j4) {
        return D0(c0.f17392g, Long.valueOf(j4));
    }

    @NonNull
    @CheckResult
    public <Y> T D0(@NonNull com.bumptech.glide.load.e<Y> eVar, @NonNull Y y3) {
        if (this.f17901v) {
            return (T) clone().D0(eVar, y3);
        }
        com.bumptech.glide.util.j.d(eVar);
        com.bumptech.glide.util.j.d(y3);
        this.f17896q.e(eVar, y3);
        return C0();
    }

    @NonNull
    public final com.bumptech.glide.load.engine.j E() {
        return this.f17882c;
    }

    @NonNull
    @CheckResult
    public T E0(@NonNull com.bumptech.glide.load.c cVar) {
        if (this.f17901v) {
            return (T) clone().E0(cVar);
        }
        this.f17891l = (com.bumptech.glide.load.c) com.bumptech.glide.util.j.d(cVar);
        this.f17880a |= 1024;
        return C0();
    }

    public final int F() {
        return this.f17885f;
    }

    @NonNull
    @CheckResult
    public T F0(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f17901v) {
            return (T) clone().F0(f4);
        }
        if (f4 >= 0.0f && f4 <= 1.0f) {
            this.f17881b = f4;
            this.f17880a |= 2;
            return C0();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Nullable
    public final Drawable G() {
        return this.f17884e;
    }

    @NonNull
    @CheckResult
    public T G0(boolean z3) {
        if (this.f17901v) {
            return (T) clone().G0(true);
        }
        this.f17888i = !z3;
        this.f17880a |= 256;
        return C0();
    }

    @Nullable
    public final Drawable H() {
        return this.f17894o;
    }

    @NonNull
    @CheckResult
    public T H0(@Nullable Resources.Theme theme) {
        if (this.f17901v) {
            return (T) clone().H0(theme);
        }
        this.f17900u = theme;
        this.f17880a |= 32768;
        return C0();
    }

    public final int I() {
        return this.f17895p;
    }

    @NonNull
    @CheckResult
    public T I0(@IntRange(from = 0) int i4) {
        return D0(com.bumptech.glide.load.model.stream.b.f17350b, Integer.valueOf(i4));
    }

    public final boolean J() {
        return this.f17903x;
    }

    @NonNull
    @CheckResult
    public T J0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return K0(iVar, true);
    }

    @NonNull
    public final com.bumptech.glide.load.f K() {
        return this.f17896q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T K0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar, boolean z3) {
        if (this.f17901v) {
            return (T) clone().K0(iVar, z3);
        }
        p pVar = new p(iVar, z3);
        N0(Bitmap.class, iVar, z3);
        N0(Drawable.class, pVar, z3);
        N0(BitmapDrawable.class, pVar.c(), z3);
        N0(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(iVar), z3);
        return C0();
    }

    public final int L() {
        return this.f17889j;
    }

    @NonNull
    @CheckResult
    final T L0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        if (this.f17901v) {
            return (T) clone().L0(downsampleStrategy, iVar);
        }
        u(downsampleStrategy);
        return J0(iVar);
    }

    public final int M() {
        return this.f17890k;
    }

    @NonNull
    @CheckResult
    public <Y> T M0(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar) {
        return N0(cls, iVar, true);
    }

    @Nullable
    public final Drawable N() {
        return this.f17886g;
    }

    @NonNull
    <Y> T N0(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar, boolean z3) {
        if (this.f17901v) {
            return (T) clone().N0(cls, iVar, z3);
        }
        com.bumptech.glide.util.j.d(cls);
        com.bumptech.glide.util.j.d(iVar);
        this.f17897r.put(cls, iVar);
        this.f17893n = true;
        int i4 = this.f17880a | 2048 | 65536;
        this.f17880a = i4;
        this.f17904y = false;
        if (z3) {
            this.f17880a = i4 | 131072;
            this.f17892m = true;
        }
        return C0();
    }

    public final int O() {
        return this.f17887h;
    }

    @NonNull
    @CheckResult
    public T O0(@NonNull com.bumptech.glide.load.i<Bitmap>... iVarArr) {
        if (iVarArr.length > 1) {
            return K0(new com.bumptech.glide.load.d(iVarArr), true);
        }
        if (iVarArr.length == 1) {
            return J0(iVarArr[0]);
        }
        return C0();
    }

    @NonNull
    public final Priority P() {
        return this.f17883d;
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T P0(@NonNull com.bumptech.glide.load.i<Bitmap>... iVarArr) {
        return K0(new com.bumptech.glide.load.d(iVarArr), true);
    }

    @NonNull
    public final Class<?> Q() {
        return this.f17898s;
    }

    @NonNull
    @CheckResult
    public T Q0(boolean z3) {
        if (this.f17901v) {
            return (T) clone().Q0(z3);
        }
        this.f17905z = z3;
        this.f17880a |= 1048576;
        return C0();
    }

    @NonNull
    public final com.bumptech.glide.load.c R() {
        return this.f17891l;
    }

    @NonNull
    @CheckResult
    public T R0(boolean z3) {
        if (this.f17901v) {
            return (T) clone().R0(z3);
        }
        this.f17902w = z3;
        this.f17880a |= 262144;
        return C0();
    }

    public final float S() {
        return this.f17881b;
    }

    @Nullable
    public final Resources.Theme T() {
        return this.f17900u;
    }

    @NonNull
    public final Map<Class<?>, com.bumptech.glide.load.i<?>> U() {
        return this.f17897r;
    }

    public final boolean V() {
        return this.f17905z;
    }

    public final boolean W() {
        return this.f17902w;
    }

    protected boolean X() {
        return this.f17901v;
    }

    public final boolean Y() {
        return d0(4);
    }

    public final boolean Z() {
        return this.f17899t;
    }

    public final boolean a0() {
        return this.f17888i;
    }

    @NonNull
    @CheckResult
    public T b(@NonNull a<?> aVar) {
        if (this.f17901v) {
            return (T) clone().b(aVar);
        }
        if (e0(aVar.f17880a, 2)) {
            this.f17881b = aVar.f17881b;
        }
        if (e0(aVar.f17880a, 262144)) {
            this.f17902w = aVar.f17902w;
        }
        if (e0(aVar.f17880a, 1048576)) {
            this.f17905z = aVar.f17905z;
        }
        if (e0(aVar.f17880a, 4)) {
            this.f17882c = aVar.f17882c;
        }
        if (e0(aVar.f17880a, 8)) {
            this.f17883d = aVar.f17883d;
        }
        if (e0(aVar.f17880a, 16)) {
            this.f17884e = aVar.f17884e;
            this.f17885f = 0;
            this.f17880a &= -33;
        }
        if (e0(aVar.f17880a, 32)) {
            this.f17885f = aVar.f17885f;
            this.f17884e = null;
            this.f17880a &= -17;
        }
        if (e0(aVar.f17880a, 64)) {
            this.f17886g = aVar.f17886g;
            this.f17887h = 0;
            this.f17880a &= -129;
        }
        if (e0(aVar.f17880a, 128)) {
            this.f17887h = aVar.f17887h;
            this.f17886g = null;
            this.f17880a &= -65;
        }
        if (e0(aVar.f17880a, 256)) {
            this.f17888i = aVar.f17888i;
        }
        if (e0(aVar.f17880a, 512)) {
            this.f17890k = aVar.f17890k;
            this.f17889j = aVar.f17889j;
        }
        if (e0(aVar.f17880a, 1024)) {
            this.f17891l = aVar.f17891l;
        }
        if (e0(aVar.f17880a, 4096)) {
            this.f17898s = aVar.f17898s;
        }
        if (e0(aVar.f17880a, 8192)) {
            this.f17894o = aVar.f17894o;
            this.f17895p = 0;
            this.f17880a &= -16385;
        }
        if (e0(aVar.f17880a, 16384)) {
            this.f17895p = aVar.f17895p;
            this.f17894o = null;
            this.f17880a &= -8193;
        }
        if (e0(aVar.f17880a, 32768)) {
            this.f17900u = aVar.f17900u;
        }
        if (e0(aVar.f17880a, 65536)) {
            this.f17893n = aVar.f17893n;
        }
        if (e0(aVar.f17880a, 131072)) {
            this.f17892m = aVar.f17892m;
        }
        if (e0(aVar.f17880a, 2048)) {
            this.f17897r.putAll(aVar.f17897r);
            this.f17904y = aVar.f17904y;
        }
        if (e0(aVar.f17880a, 524288)) {
            this.f17903x = aVar.f17903x;
        }
        if (!this.f17893n) {
            this.f17897r.clear();
            this.f17892m = false;
            this.f17880a = this.f17880a & (-2049) & (-131073);
            this.f17904y = true;
        }
        this.f17880a |= aVar.f17880a;
        this.f17896q.d(aVar.f17896q);
        return C0();
    }

    public final boolean b0() {
        return d0(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c0() {
        return this.f17904y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return Float.compare(aVar.f17881b, this.f17881b) == 0 && this.f17885f == aVar.f17885f && com.bumptech.glide.util.k.d(this.f17884e, aVar.f17884e) && this.f17887h == aVar.f17887h && com.bumptech.glide.util.k.d(this.f17886g, aVar.f17886g) && this.f17895p == aVar.f17895p && com.bumptech.glide.util.k.d(this.f17894o, aVar.f17894o) && this.f17888i == aVar.f17888i && this.f17889j == aVar.f17889j && this.f17890k == aVar.f17890k && this.f17892m == aVar.f17892m && this.f17893n == aVar.f17893n && this.f17902w == aVar.f17902w && this.f17903x == aVar.f17903x && this.f17882c.equals(aVar.f17882c) && this.f17883d == aVar.f17883d && this.f17896q.equals(aVar.f17896q) && this.f17897r.equals(aVar.f17897r) && this.f17898s.equals(aVar.f17898s) && com.bumptech.glide.util.k.d(this.f17891l, aVar.f17891l) && com.bumptech.glide.util.k.d(this.f17900u, aVar.f17900u);
        }
        return false;
    }

    public final boolean f0() {
        return d0(256);
    }

    public final boolean g0() {
        return this.f17893n;
    }

    @NonNull
    public T h() {
        if (this.f17899t && !this.f17901v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f17901v = true;
        return k0();
    }

    public final boolean h0() {
        return this.f17892m;
    }

    public int hashCode() {
        return com.bumptech.glide.util.k.p(this.f17900u, com.bumptech.glide.util.k.p(this.f17891l, com.bumptech.glide.util.k.p(this.f17898s, com.bumptech.glide.util.k.p(this.f17897r, com.bumptech.glide.util.k.p(this.f17896q, com.bumptech.glide.util.k.p(this.f17883d, com.bumptech.glide.util.k.p(this.f17882c, com.bumptech.glide.util.k.r(this.f17903x, com.bumptech.glide.util.k.r(this.f17902w, com.bumptech.glide.util.k.r(this.f17893n, com.bumptech.glide.util.k.r(this.f17892m, com.bumptech.glide.util.k.o(this.f17890k, com.bumptech.glide.util.k.o(this.f17889j, com.bumptech.glide.util.k.r(this.f17888i, com.bumptech.glide.util.k.p(this.f17894o, com.bumptech.glide.util.k.o(this.f17895p, com.bumptech.glide.util.k.p(this.f17886g, com.bumptech.glide.util.k.o(this.f17887h, com.bumptech.glide.util.k.p(this.f17884e, com.bumptech.glide.util.k.o(this.f17885f, com.bumptech.glide.util.k.l(this.f17881b)))))))))))))))))))));
    }

    @NonNull
    @CheckResult
    public T i() {
        return L0(DownsampleStrategy.f17376b, new com.bumptech.glide.load.resource.bitmap.j());
    }

    public final boolean i0() {
        return d0(2048);
    }

    @NonNull
    @CheckResult
    public T j() {
        return z0(DownsampleStrategy.f17379e, new com.bumptech.glide.load.resource.bitmap.k());
    }

    public final boolean j0() {
        return com.bumptech.glide.util.k.v(this.f17890k, this.f17889j);
    }

    @NonNull
    @CheckResult
    public T k() {
        return L0(DownsampleStrategy.f17379e, new l());
    }

    @NonNull
    public T k0() {
        this.f17899t = true;
        return B0();
    }

    @NonNull
    @CheckResult
    public T l0(boolean z3) {
        if (this.f17901v) {
            return (T) clone().l0(z3);
        }
        this.f17903x = z3;
        this.f17880a |= 524288;
        return C0();
    }

    @Override // 
    @CheckResult
    /* renamed from: m */
    public T clone() {
        try {
            T t3 = (T) super.clone();
            com.bumptech.glide.load.f fVar = new com.bumptech.glide.load.f();
            t3.f17896q = fVar;
            fVar.d(this.f17896q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t3.f17897r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f17897r);
            t3.f17899t = false;
            t3.f17901v = false;
            return t3;
        } catch (CloneNotSupportedException e4) {
            throw new RuntimeException(e4);
        }
    }

    @NonNull
    @CheckResult
    public T m0() {
        return s0(DownsampleStrategy.f17376b, new com.bumptech.glide.load.resource.bitmap.j());
    }

    @NonNull
    @CheckResult
    public T n(@NonNull Class<?> cls) {
        if (this.f17901v) {
            return (T) clone().n(cls);
        }
        this.f17898s = (Class) com.bumptech.glide.util.j.d(cls);
        this.f17880a |= 4096;
        return C0();
    }

    @NonNull
    @CheckResult
    public T n0() {
        return q0(DownsampleStrategy.f17379e, new com.bumptech.glide.load.resource.bitmap.k());
    }

    @NonNull
    @CheckResult
    public T o0() {
        return s0(DownsampleStrategy.f17376b, new l());
    }

    @NonNull
    @CheckResult
    public T p0() {
        return q0(DownsampleStrategy.f17375a, new r());
    }

    @NonNull
    @CheckResult
    public T q() {
        return D0(n.f17445j, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public T r(@NonNull com.bumptech.glide.load.engine.j jVar) {
        if (this.f17901v) {
            return (T) clone().r(jVar);
        }
        this.f17882c = (com.bumptech.glide.load.engine.j) com.bumptech.glide.util.j.d(jVar);
        this.f17880a |= 4;
        return C0();
    }

    @NonNull
    @CheckResult
    public T r0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return K0(iVar, false);
    }

    @NonNull
    @CheckResult
    public T s() {
        return D0(com.bumptech.glide.load.resource.gif.h.f17562b, Boolean.TRUE);
    }

    @NonNull
    final T s0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        if (this.f17901v) {
            return (T) clone().s0(downsampleStrategy, iVar);
        }
        u(downsampleStrategy);
        return K0(iVar, false);
    }

    @NonNull
    @CheckResult
    public T t() {
        if (this.f17901v) {
            return (T) clone().t();
        }
        this.f17897r.clear();
        this.f17892m = false;
        this.f17893n = false;
        this.f17880a = (this.f17880a & (-2049) & (-131073)) | 65536;
        this.f17904y = true;
        return C0();
    }

    @NonNull
    @CheckResult
    public <Y> T t0(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar) {
        return N0(cls, iVar, false);
    }

    @NonNull
    @CheckResult
    public T u(@NonNull DownsampleStrategy downsampleStrategy) {
        return D0(DownsampleStrategy.f17382h, com.bumptech.glide.util.j.d(downsampleStrategy));
    }

    @NonNull
    @CheckResult
    public T u0(int i4) {
        return v0(i4, i4);
    }

    @NonNull
    @CheckResult
    public T v(@NonNull Bitmap.CompressFormat compressFormat) {
        return D0(com.bumptech.glide.load.resource.bitmap.e.f17402c, com.bumptech.glide.util.j.d(compressFormat));
    }

    @NonNull
    @CheckResult
    public T v0(int i4, int i5) {
        if (this.f17901v) {
            return (T) clone().v0(i4, i5);
        }
        this.f17890k = i4;
        this.f17889j = i5;
        this.f17880a |= 512;
        return C0();
    }

    @NonNull
    @CheckResult
    public T w(@IntRange(from = 0, to = 100) int i4) {
        return D0(com.bumptech.glide.load.resource.bitmap.e.f17401b, Integer.valueOf(i4));
    }

    @NonNull
    @CheckResult
    public T w0(@DrawableRes int i4) {
        if (this.f17901v) {
            return (T) clone().w0(i4);
        }
        this.f17887h = i4;
        this.f17886g = null;
        this.f17880a = (this.f17880a | 128) & (-65);
        return C0();
    }

    @NonNull
    @CheckResult
    public T x(@DrawableRes int i4) {
        if (this.f17901v) {
            return (T) clone().x(i4);
        }
        this.f17885f = i4;
        this.f17884e = null;
        this.f17880a = (this.f17880a | 32) & (-17);
        return C0();
    }

    @NonNull
    @CheckResult
    public T x0(@Nullable Drawable drawable) {
        if (this.f17901v) {
            return (T) clone().x0(drawable);
        }
        this.f17886g = drawable;
        this.f17887h = 0;
        this.f17880a = (this.f17880a | 64) & (-129);
        return C0();
    }

    @NonNull
    @CheckResult
    public T y(@Nullable Drawable drawable) {
        if (this.f17901v) {
            return (T) clone().y(drawable);
        }
        this.f17884e = drawable;
        this.f17885f = 0;
        this.f17880a = (this.f17880a | 16) & (-33);
        return C0();
    }

    @NonNull
    @CheckResult
    public T y0(@NonNull Priority priority) {
        if (this.f17901v) {
            return (T) clone().y0(priority);
        }
        this.f17883d = (Priority) com.bumptech.glide.util.j.d(priority);
        this.f17880a |= 8;
        return C0();
    }

    @NonNull
    @CheckResult
    public T z(@DrawableRes int i4) {
        if (this.f17901v) {
            return (T) clone().z(i4);
        }
        this.f17895p = i4;
        this.f17894o = null;
        this.f17880a = (this.f17880a | 16384) & (-8193);
        return C0();
    }
}
