package com.bumptech.glide.request;

import android.graphics.Bitmap;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestOptions.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class h extends a<h> {
    @Nullable
    private static h A0;
    @Nullable
    private static h B0;
    @Nullable
    private static h V;
    @Nullable
    private static h W;
    @Nullable
    private static h X;
    @Nullable
    private static h Y;
    @Nullable
    private static h Z;
    @Nullable

    /* renamed from: p0  reason: collision with root package name */
    private static h f17920p0;

    @NonNull
    @CheckResult
    public static h S0(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return new h().J0(iVar);
    }

    @NonNull
    @CheckResult
    public static h T0() {
        if (Z == null) {
            Z = new h().i().h();
        }
        return Z;
    }

    @NonNull
    @CheckResult
    public static h U0() {
        if (Y == null) {
            Y = new h().j().h();
        }
        return Y;
    }

    @NonNull
    @CheckResult
    public static h V0() {
        if (f17920p0 == null) {
            f17920p0 = new h().k().h();
        }
        return f17920p0;
    }

    @NonNull
    @CheckResult
    public static h W0(@NonNull Class<?> cls) {
        return new h().n(cls);
    }

    @NonNull
    @CheckResult
    public static h X0(@NonNull com.bumptech.glide.load.engine.j jVar) {
        return new h().r(jVar);
    }

    @NonNull
    @CheckResult
    public static h Y0(@NonNull DownsampleStrategy downsampleStrategy) {
        return new h().u(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static h Z0(@NonNull Bitmap.CompressFormat compressFormat) {
        return new h().v(compressFormat);
    }

    @NonNull
    @CheckResult
    public static h a1(@IntRange(from = 0, to = 100) int i4) {
        return new h().w(i4);
    }

    @NonNull
    @CheckResult
    public static h b1(@DrawableRes int i4) {
        return new h().x(i4);
    }

    @NonNull
    @CheckResult
    public static h c1(@Nullable Drawable drawable) {
        return new h().y(drawable);
    }

    @NonNull
    @CheckResult
    public static h d1() {
        if (X == null) {
            X = new h().B().h();
        }
        return X;
    }

    @NonNull
    @CheckResult
    public static h e1(@NonNull DecodeFormat decodeFormat) {
        return new h().C(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static h f1(@IntRange(from = 0) long j4) {
        return new h().D(j4);
    }

    @NonNull
    @CheckResult
    public static h g1() {
        if (B0 == null) {
            B0 = new h().s().h();
        }
        return B0;
    }

    @NonNull
    @CheckResult
    public static h h1() {
        if (A0 == null) {
            A0 = new h().t().h();
        }
        return A0;
    }

    @NonNull
    @CheckResult
    public static <T> h i1(@NonNull com.bumptech.glide.load.e<T> eVar, @NonNull T t3) {
        return new h().D0(eVar, t3);
    }

    @NonNull
    @CheckResult
    public static h j1(@IntRange(from = 0) int i4) {
        return k1(i4, i4);
    }

    @NonNull
    @CheckResult
    public static h k1(@IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        return new h().v0(i4, i5);
    }

    @NonNull
    @CheckResult
    public static h l1(@DrawableRes int i4) {
        return new h().w0(i4);
    }

    @NonNull
    @CheckResult
    public static h m1(@Nullable Drawable drawable) {
        return new h().x0(drawable);
    }

    @NonNull
    @CheckResult
    public static h n1(@NonNull Priority priority) {
        return new h().y0(priority);
    }

    @NonNull
    @CheckResult
    public static h o1(@NonNull com.bumptech.glide.load.c cVar) {
        return new h().E0(cVar);
    }

    @NonNull
    @CheckResult
    public static h p1(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return new h().F0(f4);
    }

    @NonNull
    @CheckResult
    public static h q1(boolean z3) {
        if (z3) {
            if (V == null) {
                V = new h().G0(true).h();
            }
            return V;
        }
        if (W == null) {
            W = new h().G0(false).h();
        }
        return W;
    }

    @NonNull
    @CheckResult
    public static h r1(@IntRange(from = 0) int i4) {
        return new h().I0(i4);
    }
}
