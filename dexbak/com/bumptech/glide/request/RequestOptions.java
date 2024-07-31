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
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* renamed from: com.bumptech.glide.request.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    @Nullable

    /* renamed from: A0 */
    private static RequestOptions f14389A0;
    @Nullable

    /* renamed from: B0 */
    private static RequestOptions f14390B0;
    @Nullable

    /* renamed from: V */
    private static RequestOptions f14391V;
    @Nullable

    /* renamed from: W */
    private static RequestOptions f14392W;
    @Nullable

    /* renamed from: X */
    private static RequestOptions f14393X;
    @Nullable

    /* renamed from: Y */
    private static RequestOptions f14394Y;
    @Nullable

    /* renamed from: Z */
    private static RequestOptions f14395Z;
    @Nullable

    /* renamed from: p0 */
    private static RequestOptions f14396p0;

    @NonNull
    @CheckResult
    /* renamed from: S0 */
    public static RequestOptions m44583S0(@NonNull Transformation<Bitmap> transformation) {
        return new RequestOptions().m44662J0(transformation);
    }

    @NonNull
    @CheckResult
    /* renamed from: T0 */
    public static RequestOptions m44582T0() {
        if (f14395Z == null) {
            f14395Z = new RequestOptions().m44627i().m44629h();
        }
        return f14395Z;
    }

    @NonNull
    @CheckResult
    /* renamed from: U0 */
    public static RequestOptions m44581U0() {
        if (f14394Y == null) {
            f14394Y = new RequestOptions().m44625j().m44629h();
        }
        return f14394Y;
    }

    @NonNull
    @CheckResult
    /* renamed from: V0 */
    public static RequestOptions m44580V0() {
        if (f14396p0 == null) {
            f14396p0 = new RequestOptions().m44623k().m44629h();
        }
        return f14396p0;
    }

    @NonNull
    @CheckResult
    /* renamed from: W0 */
    public static RequestOptions m44579W0(@NonNull Class<?> cls) {
        return new RequestOptions().m44618n(cls);
    }

    @NonNull
    @CheckResult
    /* renamed from: X0 */
    public static RequestOptions m44578X0(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().m44612r(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    /* renamed from: Y0 */
    public static RequestOptions m44577Y0(@NonNull DownsampleStrategy downsampleStrategy) {
        return new RequestOptions().m44606u(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    /* renamed from: Z0 */
    public static RequestOptions m44576Z0(@NonNull Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().m44604v(compressFormat);
    }

    @NonNull
    @CheckResult
    /* renamed from: a1 */
    public static RequestOptions m44575a1(@IntRange(from = 0, m60035to = 100) int i) {
        return new RequestOptions().m44602w(i);
    }

    @NonNull
    @CheckResult
    /* renamed from: b1 */
    public static RequestOptions m44574b1(@DrawableRes int i) {
        return new RequestOptions().m44600x(i);
    }

    @NonNull
    @CheckResult
    /* renamed from: c1 */
    public static RequestOptions m44573c1(@Nullable Drawable drawable) {
        return new RequestOptions().m44598y(drawable);
    }

    @NonNull
    @CheckResult
    /* renamed from: d1 */
    public static RequestOptions m44572d1() {
        if (f14393X == null) {
            f14393X = new RequestOptions().m44679B().m44629h();
        }
        return f14393X;
    }

    @NonNull
    @CheckResult
    /* renamed from: e1 */
    public static RequestOptions m44571e1(@NonNull DecodeFormat decodeFormat) {
        return new RequestOptions().m44677C(decodeFormat);
    }

    @NonNull
    @CheckResult
    /* renamed from: f1 */
    public static RequestOptions m44570f1(@IntRange(from = 0) long j) {
        return new RequestOptions().m44675D(j);
    }

    @NonNull
    @CheckResult
    /* renamed from: g1 */
    public static RequestOptions m44569g1() {
        if (f14390B0 == null) {
            f14390B0 = new RequestOptions().m44610s().m44629h();
        }
        return f14390B0;
    }

    @NonNull
    @CheckResult
    /* renamed from: h1 */
    public static RequestOptions m44568h1() {
        if (f14389A0 == null) {
            f14389A0 = new RequestOptions().m44608t().m44629h();
        }
        return f14389A0;
    }

    @NonNull
    @CheckResult
    /* renamed from: i1 */
    public static <T> RequestOptions m44567i1(@NonNull Option<T> option, @NonNull T t) {
        return new RequestOptions().m44674D0(option, t);
    }

    @NonNull
    @CheckResult
    /* renamed from: j1 */
    public static RequestOptions m44566j1(@IntRange(from = 0) int i) {
        return m44565k1(i, i);
    }

    @NonNull
    @CheckResult
    /* renamed from: k1 */
    public static RequestOptions m44565k1(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        return new RequestOptions().m44603v0(i, i2);
    }

    @NonNull
    @CheckResult
    /* renamed from: l1 */
    public static RequestOptions m44564l1(@DrawableRes int i) {
        return new RequestOptions().m44601w0(i);
    }

    @NonNull
    @CheckResult
    /* renamed from: m1 */
    public static RequestOptions m44563m1(@Nullable Drawable drawable) {
        return new RequestOptions().m44599x0(drawable);
    }

    @NonNull
    @CheckResult
    /* renamed from: n1 */
    public static RequestOptions m44562n1(@NonNull Priority priority) {
        return new RequestOptions().m44597y0(priority);
    }

    @NonNull
    @CheckResult
    /* renamed from: o1 */
    public static RequestOptions m44561o1(@NonNull Key key) {
        return new RequestOptions().m44672E0(key);
    }

    @NonNull
    @CheckResult
    /* renamed from: p1 */
    public static RequestOptions m44560p1(@FloatRange(from = 0.0d, m60036to = 1.0d) float f) {
        return new RequestOptions().m44670F0(f);
    }

    @NonNull
    @CheckResult
    /* renamed from: q1 */
    public static RequestOptions m44559q1(boolean z) {
        if (z) {
            if (f14391V == null) {
                f14391V = new RequestOptions().m44668G0(true).m44629h();
            }
            return f14391V;
        }
        if (f14392W == null) {
            f14392W = new RequestOptions().m44668G0(false).m44629h();
        }
        return f14392W;
    }

    @NonNull
    @CheckResult
    /* renamed from: r1 */
    public static RequestOptions m44558r1(@IntRange(from = 0) int i) {
        return new RequestOptions().m44664I0(i);
    }
}
