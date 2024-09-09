package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.request.target.m;
import com.bumptech.glide.request.target.p;
import com.bumptech.glide.request.target.r;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestBuilder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i<TranscodeType> extends com.bumptech.glide.request.a<i<TranscodeType>> implements Cloneable, h<i<TranscodeType>> {
    protected static final com.bumptech.glide.request.h I0 = new com.bumptech.glide.request.h().r(com.bumptech.glide.load.engine.j.f17105c).y0(Priority.LOW).G0(true);
    @Nullable
    private Object A0;
    @Nullable
    private List<com.bumptech.glide.request.g<TranscodeType>> B0;
    @Nullable
    private i<TranscodeType> C0;
    @Nullable
    private i<TranscodeType> D0;
    @Nullable
    private Float E0;
    private boolean F0;
    private boolean G0;
    private boolean H0;
    private final Context V;
    private final j W;
    private final Class<TranscodeType> X;
    private final d Y;
    private final f Z;
    @NonNull

    /* renamed from: p0  reason: collision with root package name */
    private k<?, ? super TranscodeType> f16769p0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestBuilder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16770a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16771b;

        static {
            int[] iArr = new int[Priority.values().length];
            f16771b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16771b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16771b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16771b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f16770a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16770a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16770a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16770a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16770a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16770a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16770a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16770a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public i(@NonNull d dVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.F0 = true;
        this.Y = dVar;
        this.W = jVar;
        this.X = cls;
        this.V = context;
        this.f16769p0 = jVar.E(cls);
        this.Z = dVar.i();
        d1(jVar.C());
        b(jVar.D());
    }

    private com.bumptech.glide.request.d U0(p<TranscodeType> pVar, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return V0(pVar, gVar, null, this.f16769p0, aVar.P(), aVar.M(), aVar.L(), aVar, executor);
    }

    private com.bumptech.glide.request.d V0(p<TranscodeType> pVar, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, @Nullable com.bumptech.glide.request.e eVar, k<?, ? super TranscodeType> kVar, Priority priority, int i4, int i5, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.request.b bVar;
        com.bumptech.glide.request.b bVar2;
        if (this.D0 != null) {
            bVar2 = new com.bumptech.glide.request.b(eVar);
            bVar = bVar2;
        } else {
            bVar = null;
            bVar2 = eVar;
        }
        com.bumptech.glide.request.d W0 = W0(pVar, gVar, bVar2, kVar, priority, i4, i5, aVar, executor);
        if (bVar == null) {
            return W0;
        }
        int M = this.D0.M();
        int L2 = this.D0.L();
        if (com.bumptech.glide.util.k.v(i4, i5) && !this.D0.j0()) {
            M = aVar.M();
            L2 = aVar.L();
        }
        i<TranscodeType> iVar = this.D0;
        com.bumptech.glide.request.b bVar3 = bVar;
        bVar3.r(W0, iVar.V0(pVar, gVar, bVar, iVar.f16769p0, iVar.P(), M, L2, this.D0, executor));
        return bVar3;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.a] */
    private com.bumptech.glide.request.d W0(p<TranscodeType> pVar, com.bumptech.glide.request.g<TranscodeType> gVar, @Nullable com.bumptech.glide.request.e eVar, k<?, ? super TranscodeType> kVar, Priority priority, int i4, int i5, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        i<TranscodeType> iVar = this.C0;
        if (iVar != null) {
            if (!this.H0) {
                k<?, ? super TranscodeType> kVar2 = iVar.F0 ? kVar : iVar.f16769p0;
                Priority P = iVar.b0() ? this.C0.P() : c1(priority);
                int M = this.C0.M();
                int L2 = this.C0.L();
                if (com.bumptech.glide.util.k.v(i4, i5) && !this.C0.j0()) {
                    M = aVar.M();
                    L2 = aVar.L();
                }
                int i6 = M;
                int i7 = L2;
                com.bumptech.glide.request.k kVar3 = new com.bumptech.glide.request.k(eVar);
                com.bumptech.glide.request.d v12 = v1(pVar, gVar, aVar, kVar3, kVar, priority, i4, i5, executor);
                this.H0 = true;
                i<TranscodeType> iVar2 = this.C0;
                com.bumptech.glide.request.d V0 = iVar2.V0(pVar, gVar, kVar3, kVar2, P, i6, i7, iVar2, executor);
                this.H0 = false;
                kVar3.q(v12, V0);
                return kVar3;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.E0 != null) {
            com.bumptech.glide.request.k kVar4 = new com.bumptech.glide.request.k(eVar);
            kVar4.q(v1(pVar, gVar, aVar, kVar4, kVar, priority, i4, i5, executor), v1(pVar, gVar, aVar.clone().F0(this.E0.floatValue()), kVar4, kVar, c1(priority), i4, i5, executor));
            return kVar4;
        } else {
            return v1(pVar, gVar, aVar, eVar, kVar, priority, i4, i5, executor);
        }
    }

    @NonNull
    private Priority c1(@NonNull Priority priority) {
        int i4 = a.f16771b[priority.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3 && i4 != 4) {
                    throw new IllegalArgumentException("unknown priority: " + P());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    @SuppressLint({"CheckResult"})
    private void d1(List<com.bumptech.glide.request.g<Object>> list) {
        for (com.bumptech.glide.request.g<Object> gVar : list) {
            S0(gVar);
        }
    }

    private <Y extends p<TranscodeType>> Y g1(@NonNull Y y3, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.util.j.d(y3);
        if (this.G0) {
            com.bumptech.glide.request.d U0 = U0(y3, gVar, aVar, executor);
            com.bumptech.glide.request.d i4 = y3.i();
            if (U0.i(i4) && !j1(aVar, i4)) {
                U0.recycle();
                if (!((com.bumptech.glide.request.d) com.bumptech.glide.util.j.d(i4)).isRunning()) {
                    i4.j();
                }
                return y3;
            }
            this.W.z(y3);
            y3.m(U0);
            this.W.W(y3, U0);
            return y3;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean j1(com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.d dVar) {
        return !aVar.a0() && dVar.a();
    }

    @NonNull
    private i<TranscodeType> u1(@Nullable Object obj) {
        this.A0 = obj;
        this.G0 = true;
        return this;
    }

    private com.bumptech.glide.request.d v1(p<TranscodeType> pVar, com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.e eVar, k<?, ? super TranscodeType> kVar, Priority priority, int i4, int i5, Executor executor) {
        Context context = this.V;
        f fVar = this.Z;
        return com.bumptech.glide.request.j.A(context, fVar, this.A0, this.X, aVar, i4, i5, priority, pVar, gVar, this.B0, eVar, fVar.f(), kVar.c(), executor);
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> A1(float f4) {
        if (f4 >= 0.0f && f4 <= 1.0f) {
            this.E0 = Float.valueOf(f4);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> B1(@Nullable i<TranscodeType> iVar) {
        this.C0 = iVar;
        return this;
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> C1(@Nullable i<TranscodeType>... iVarArr) {
        i<TranscodeType> iVar = null;
        if (iVarArr != null && iVarArr.length != 0) {
            for (int length = iVarArr.length - 1; length >= 0; length--) {
                i<TranscodeType> iVar2 = iVarArr[length];
                if (iVar2 != null) {
                    iVar = iVar == null ? iVar2 : iVar2.B1(iVar);
                }
            }
            return B1(iVar);
        }
        return B1(null);
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> D1(@NonNull k<?, ? super TranscodeType> kVar) {
        this.f16769p0 = (k) com.bumptech.glide.util.j.d(kVar);
        this.F0 = false;
        return this;
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> S0(@Nullable com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (gVar != null) {
            if (this.B0 == null) {
                this.B0 = new ArrayList();
            }
            this.B0.add(gVar);
        }
        return this;
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: T0 */
    public i<TranscodeType> b(@NonNull com.bumptech.glide.request.a<?> aVar) {
        com.bumptech.glide.util.j.d(aVar);
        return (i) super.b(aVar);
    }

    @Override // com.bumptech.glide.request.a
    @CheckResult
    /* renamed from: X0 */
    public i<TranscodeType> m() {
        i<TranscodeType> iVar = (i) super.clone();
        iVar.f16769p0 = (k<?, ? super TranscodeType>) iVar.f16769p0.clone();
        return iVar;
    }

    @CheckResult
    @Deprecated
    public com.bumptech.glide.request.c<File> Y0(int i4, int i5) {
        return b1().z1(i4, i5);
    }

    @CheckResult
    @Deprecated
    public <Y extends p<File>> Y Z0(@NonNull Y y3) {
        return (Y) b1().f1(y3);
    }

    @NonNull
    public i<TranscodeType> a1(@Nullable i<TranscodeType> iVar) {
        this.D0 = iVar;
        return this;
    }

    @NonNull
    @CheckResult
    protected i<File> b1() {
        return new i(File.class, this).b(I0);
    }

    @Deprecated
    public com.bumptech.glide.request.c<TranscodeType> e1(int i4, int i5) {
        return z1(i4, i5);
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y f1(@NonNull Y y3) {
        return (Y) h1(y3, null, com.bumptech.glide.util.d.b());
    }

    @NonNull
    <Y extends p<TranscodeType>> Y h1(@NonNull Y y3, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, Executor executor) {
        return (Y) g1(y3, gVar, this, executor);
    }

    @NonNull
    public r<ImageView, TranscodeType> i1(@NonNull ImageView imageView) {
        i<TranscodeType> iVar;
        com.bumptech.glide.util.k.b();
        com.bumptech.glide.util.j.d(imageView);
        if (!i0() && g0() && imageView.getScaleType() != null) {
            switch (a.f16770a[imageView.getScaleType().ordinal()]) {
                case 1:
                    iVar = clone().m0();
                    break;
                case 2:
                    iVar = clone().n0();
                    break;
                case 3:
                case 4:
                case 5:
                    iVar = clone().p0();
                    break;
                case 6:
                    iVar = clone().n0();
                    break;
            }
            return (r) g1(this.Z.a(imageView, this.X), null, iVar, com.bumptech.glide.util.d.b());
        }
        iVar = this;
        return (r) g1(this.Z.a(imageView, this.X), null, iVar, com.bumptech.glide.util.d.b());
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> k1(@Nullable com.bumptech.glide.request.g<TranscodeType> gVar) {
        this.B0 = null;
        return S0(gVar);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: l1 */
    public i<TranscodeType> l(@Nullable Bitmap bitmap) {
        return u1(bitmap).b(com.bumptech.glide.request.h.X0(com.bumptech.glide.load.engine.j.f17104b));
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: m1 */
    public i<TranscodeType> g(@Nullable Drawable drawable) {
        return u1(drawable).b(com.bumptech.glide.request.h.X0(com.bumptech.glide.load.engine.j.f17104b));
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: n1 */
    public i<TranscodeType> d(@Nullable Uri uri) {
        return u1(uri);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: o1 */
    public i<TranscodeType> f(@Nullable File file) {
        return u1(file);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: p1 */
    public i<TranscodeType> p(@Nullable @DrawableRes @RawRes Integer num) {
        return u1(num).b(com.bumptech.glide.request.h.o1(com.bumptech.glide.signature.a.c(this.V)));
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: q1 */
    public i<TranscodeType> o(@Nullable Object obj) {
        return u1(obj);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: r1 */
    public i<TranscodeType> a(@Nullable String str) {
        return u1(str);
    }

    @Override // com.bumptech.glide.h
    @CheckResult
    @Deprecated
    /* renamed from: s1 */
    public i<TranscodeType> c(@Nullable URL url) {
        return u1(url);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* renamed from: t1 */
    public i<TranscodeType> e(@Nullable byte[] bArr) {
        i<TranscodeType> u12 = u1(bArr);
        if (!u12.Y()) {
            u12 = u12.b(com.bumptech.glide.request.h.X0(com.bumptech.glide.load.engine.j.f17104b));
        }
        return !u12.f0() ? u12.b(com.bumptech.glide.request.h.q1(true)) : u12;
    }

    @NonNull
    public p<TranscodeType> w1() {
        return x1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public p<TranscodeType> x1(int i4, int i5) {
        return f1(m.e(this.W, i4, i5));
    }

    @NonNull
    public com.bumptech.glide.request.c<TranscodeType> y1() {
        return z1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public com.bumptech.glide.request.c<TranscodeType> z1(int i4, int i5) {
        com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f(i4, i5);
        return (com.bumptech.glide.request.c) h1(fVar, fVar, com.bumptech.glide.util.d.a());
    }

    @SuppressLint({"CheckResult"})
    protected i(Class<TranscodeType> cls, i<?> iVar) {
        this(iVar.Y, iVar.W, cls, iVar.V);
        this.A0 = iVar.A0;
        this.G0 = iVar.G0;
        b(iVar);
    }
}
