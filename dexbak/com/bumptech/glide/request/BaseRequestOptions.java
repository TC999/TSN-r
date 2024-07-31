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
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.request.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {

    /* renamed from: A */
    private static final int f14328A = -1;

    /* renamed from: B */
    private static final int f14329B = 2;

    /* renamed from: C */
    private static final int f14330C = 4;

    /* renamed from: D */
    private static final int f14331D = 8;

    /* renamed from: E */
    private static final int f14332E = 16;

    /* renamed from: F */
    private static final int f14333F = 32;

    /* renamed from: G */
    private static final int f14334G = 64;

    /* renamed from: H */
    private static final int f14335H = 128;

    /* renamed from: I */
    private static final int f14336I = 256;

    /* renamed from: J */
    private static final int f14337J = 512;

    /* renamed from: K */
    private static final int f14338K = 1024;

    /* renamed from: L */
    private static final int f14339L = 2048;

    /* renamed from: M */
    private static final int f14340M = 4096;

    /* renamed from: N */
    private static final int f14341N = 8192;

    /* renamed from: O */
    private static final int f14342O = 16384;

    /* renamed from: P */
    private static final int f14343P = 32768;

    /* renamed from: Q */
    private static final int f14344Q = 65536;

    /* renamed from: R */
    private static final int f14345R = 131072;

    /* renamed from: S */
    private static final int f14346S = 262144;

    /* renamed from: T */
    private static final int f14347T = 524288;

    /* renamed from: U */
    private static final int f14348U = 1048576;

    /* renamed from: a */
    private int f14349a;
    @Nullable

    /* renamed from: e */
    private Drawable f14353e;

    /* renamed from: f */
    private int f14354f;
    @Nullable

    /* renamed from: g */
    private Drawable f14355g;

    /* renamed from: h */
    private int f14356h;

    /* renamed from: m */
    private boolean f14361m;
    @Nullable

    /* renamed from: o */
    private Drawable f14363o;

    /* renamed from: p */
    private int f14364p;

    /* renamed from: t */
    private boolean f14368t;
    @Nullable

    /* renamed from: u */
    private Resources.Theme f14369u;

    /* renamed from: v */
    private boolean f14370v;

    /* renamed from: w */
    private boolean f14371w;

    /* renamed from: x */
    private boolean f14372x;

    /* renamed from: z */
    private boolean f14374z;

    /* renamed from: b */
    private float f14350b = 1.0f;
    @NonNull

    /* renamed from: c */
    private DiskCacheStrategy f14351c = DiskCacheStrategy.f13790e;
    @NonNull

    /* renamed from: d */
    private Priority f14352d = Priority.NORMAL;

    /* renamed from: i */
    private boolean f14357i = true;

    /* renamed from: j */
    private int f14358j = -1;

    /* renamed from: k */
    private int f14359k = -1;
    @NonNull

    /* renamed from: l */
    private Key f14360l = EmptySignature.m44433c();

    /* renamed from: n */
    private boolean f14362n = true;
    @NonNull

    /* renamed from: q */
    private Options f14365q = new Options();
    @NonNull

    /* renamed from: r */
    private Map<Class<?>, Transformation<?>> f14366r = new CachedHashCodeArrayMap();
    @NonNull

    /* renamed from: s */
    private Class<?> f14367s = Object.class;

    /* renamed from: y */
    private boolean f14373y = true;

    @NonNull
    /* renamed from: A0 */
    private T m44680A0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z) {
        T m44658L0 = z ? m44658L0(downsampleStrategy, transformation) : m44609s0(downsampleStrategy, transformation);
        m44658L0.f14373y = true;
        return m44658L0;
    }

    /* renamed from: B0 */
    private T m44678B0() {
        return this;
    }

    @NonNull
    /* renamed from: C0 */
    private T m44676C0() {
        if (!this.f14368t) {
            return m44678B0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    /* renamed from: d0 */
    private boolean m44633d0(int i) {
        return m44632e0(this.f14349a, i);
    }

    /* renamed from: e0 */
    private static boolean m44632e0(int i, int i2) {
        return (i & i2) != 0;
    }

    @NonNull
    /* renamed from: q0 */
    private T m44613q0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return m44680A0(downsampleStrategy, transformation, false);
    }

    @NonNull
    /* renamed from: z0 */
    private T m44595z0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return m44680A0(downsampleStrategy, transformation, true);
    }

    @NonNull
    @CheckResult
    /* renamed from: A */
    public T m44681A(@Nullable Drawable drawable) {
        if (this.f14370v) {
            return (T) clone().m44681A(drawable);
        }
        this.f14363o = drawable;
        this.f14364p = 0;
        this.f14349a = (this.f14349a | 8192) & (-16385);
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: B */
    public T m44679B() {
        return m44595z0(DownsampleStrategy.f14058a, new FitCenter());
    }

    @NonNull
    @CheckResult
    /* renamed from: C */
    public T m44677C(@NonNull DecodeFormat decodeFormat) {
        C3770j.m44392d(decodeFormat);
        return (T) m44674D0(Downsampler.f14125g, decodeFormat).m44674D0(GifOptions.f14244a, decodeFormat);
    }

    @NonNull
    @CheckResult
    /* renamed from: D */
    public T m44675D(@IntRange(from = 0) long j) {
        return m44674D0(VideoDecoder.f14075g, Long.valueOf(j));
    }

    @NonNull
    @CheckResult
    /* renamed from: D0 */
    public <Y> T m44674D0(@NonNull Option<Y> option, @NonNull Y y) {
        if (this.f14370v) {
            return (T) clone().m44674D0(option, y);
        }
        C3770j.m44392d(option);
        C3770j.m44392d(y);
        this.f14365q.m45122e(option, y);
        return m44676C0();
    }

    @NonNull
    /* renamed from: E */
    public final DiskCacheStrategy m44673E() {
        return this.f14351c;
    }

    @NonNull
    @CheckResult
    /* renamed from: E0 */
    public T m44672E0(@NonNull Key key) {
        if (this.f14370v) {
            return (T) clone().m44672E0(key);
        }
        this.f14360l = (Key) C3770j.m44392d(key);
        this.f14349a |= 1024;
        return m44676C0();
    }

    /* renamed from: F */
    public final int m44671F() {
        return this.f14354f;
    }

    @NonNull
    @CheckResult
    /* renamed from: F0 */
    public T m44670F0(@FloatRange(from = 0.0d, m60036to = 1.0d) float f) {
        if (this.f14370v) {
            return (T) clone().m44670F0(f);
        }
        if (f >= 0.0f && f <= 1.0f) {
            this.f14350b = f;
            this.f14349a |= 2;
            return m44676C0();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Nullable
    /* renamed from: G */
    public final Drawable m44669G() {
        return this.f14353e;
    }

    @NonNull
    @CheckResult
    /* renamed from: G0 */
    public T m44668G0(boolean z) {
        if (this.f14370v) {
            return (T) clone().m44668G0(true);
        }
        this.f14357i = !z;
        this.f14349a |= 256;
        return m44676C0();
    }

    @Nullable
    /* renamed from: H */
    public final Drawable m44667H() {
        return this.f14363o;
    }

    @NonNull
    @CheckResult
    /* renamed from: H0 */
    public T m44666H0(@Nullable Resources.Theme theme) {
        if (this.f14370v) {
            return (T) clone().m44666H0(theme);
        }
        this.f14369u = theme;
        this.f14349a |= 32768;
        return m44676C0();
    }

    /* renamed from: I */
    public final int m44665I() {
        return this.f14364p;
    }

    @NonNull
    @CheckResult
    /* renamed from: I0 */
    public T m44664I0(@IntRange(from = 0) int i) {
        return m44674D0(HttpGlideUrlLoader.f14033b, Integer.valueOf(i));
    }

    /* renamed from: J */
    public final boolean m44663J() {
        return this.f14372x;
    }

    @NonNull
    @CheckResult
    /* renamed from: J0 */
    public T m44662J0(@NonNull Transformation<Bitmap> transformation) {
        return m44660K0(transformation, true);
    }

    @NonNull
    /* renamed from: K */
    public final Options m44661K() {
        return this.f14365q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /* renamed from: K0 */
    T m44660K0(@NonNull Transformation<Bitmap> transformation, boolean z) {
        if (this.f14370v) {
            return (T) clone().m44660K0(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        m44654N0(Bitmap.class, transformation, z);
        m44654N0(Drawable.class, drawableTransformation, z);
        m44654N0(BitmapDrawable.class, drawableTransformation.m44923c(), z);
        m44654N0(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return m44676C0();
    }

    /* renamed from: L */
    public final int m44659L() {
        return this.f14358j;
    }

    @NonNull
    @CheckResult
    /* renamed from: L0 */
    final T m44658L0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.f14370v) {
            return (T) clone().m44658L0(downsampleStrategy, transformation);
        }
        m44606u(downsampleStrategy);
        return m44662J0(transformation);
    }

    /* renamed from: M */
    public final int m44657M() {
        return this.f14359k;
    }

    @NonNull
    @CheckResult
    /* renamed from: M0 */
    public <Y> T m44656M0(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return m44654N0(cls, transformation, true);
    }

    @Nullable
    /* renamed from: N */
    public final Drawable m44655N() {
        return this.f14355g;
    }

    @NonNull
    /* renamed from: N0 */
    <Y> T m44654N0(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation, boolean z) {
        if (this.f14370v) {
            return (T) clone().m44654N0(cls, transformation, z);
        }
        C3770j.m44392d(cls);
        C3770j.m44392d(transformation);
        this.f14366r.put(cls, transformation);
        this.f14362n = true;
        int i = this.f14349a | 2048 | 65536;
        this.f14349a = i;
        this.f14373y = false;
        if (z) {
            this.f14349a = i | 131072;
            this.f14361m = true;
        }
        return m44676C0();
    }

    /* renamed from: O */
    public final int m44653O() {
        return this.f14356h;
    }

    @NonNull
    @CheckResult
    /* renamed from: O0 */
    public T m44652O0(@NonNull Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return m44660K0(new MultiTransformation(transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return m44662J0(transformationArr[0]);
        }
        return m44676C0();
    }

    @NonNull
    /* renamed from: P */
    public final Priority m44651P() {
        return this.f14352d;
    }

    @NonNull
    @CheckResult
    @Deprecated
    /* renamed from: P0 */
    public T m44650P0(@NonNull Transformation<Bitmap>... transformationArr) {
        return m44660K0(new MultiTransformation(transformationArr), true);
    }

    @NonNull
    /* renamed from: Q */
    public final Class<?> m44649Q() {
        return this.f14367s;
    }

    @NonNull
    @CheckResult
    /* renamed from: Q0 */
    public T m44648Q0(boolean z) {
        if (this.f14370v) {
            return (T) clone().m44648Q0(z);
        }
        this.f14374z = z;
        this.f14349a |= 1048576;
        return m44676C0();
    }

    @NonNull
    /* renamed from: R */
    public final Key m44647R() {
        return this.f14360l;
    }

    @NonNull
    @CheckResult
    /* renamed from: R0 */
    public T m44646R0(boolean z) {
        if (this.f14370v) {
            return (T) clone().m44646R0(z);
        }
        this.f14371w = z;
        this.f14349a |= 262144;
        return m44676C0();
    }

    /* renamed from: S */
    public final float m44645S() {
        return this.f14350b;
    }

    @Nullable
    /* renamed from: T */
    public final Resources.Theme m44644T() {
        return this.f14369u;
    }

    @NonNull
    /* renamed from: U */
    public final Map<Class<?>, Transformation<?>> m44643U() {
        return this.f14366r;
    }

    /* renamed from: V */
    public final boolean m44642V() {
        return this.f14374z;
    }

    /* renamed from: W */
    public final boolean m44641W() {
        return this.f14371w;
    }

    /* renamed from: X */
    protected boolean m44640X() {
        return this.f14370v;
    }

    /* renamed from: Y */
    public final boolean m44639Y() {
        return m44633d0(4);
    }

    /* renamed from: Z */
    public final boolean m44638Z() {
        return this.f14368t;
    }

    /* renamed from: a0 */
    public final boolean m44637a0() {
        return this.f14357i;
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public T mo44636b(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        if (this.f14370v) {
            return (T) clone().mo44636b(baseRequestOptions);
        }
        if (m44632e0(baseRequestOptions.f14349a, 2)) {
            this.f14350b = baseRequestOptions.f14350b;
        }
        if (m44632e0(baseRequestOptions.f14349a, 262144)) {
            this.f14371w = baseRequestOptions.f14371w;
        }
        if (m44632e0(baseRequestOptions.f14349a, 1048576)) {
            this.f14374z = baseRequestOptions.f14374z;
        }
        if (m44632e0(baseRequestOptions.f14349a, 4)) {
            this.f14351c = baseRequestOptions.f14351c;
        }
        if (m44632e0(baseRequestOptions.f14349a, 8)) {
            this.f14352d = baseRequestOptions.f14352d;
        }
        if (m44632e0(baseRequestOptions.f14349a, 16)) {
            this.f14353e = baseRequestOptions.f14353e;
            this.f14354f = 0;
            this.f14349a &= -33;
        }
        if (m44632e0(baseRequestOptions.f14349a, 32)) {
            this.f14354f = baseRequestOptions.f14354f;
            this.f14353e = null;
            this.f14349a &= -17;
        }
        if (m44632e0(baseRequestOptions.f14349a, 64)) {
            this.f14355g = baseRequestOptions.f14355g;
            this.f14356h = 0;
            this.f14349a &= -129;
        }
        if (m44632e0(baseRequestOptions.f14349a, 128)) {
            this.f14356h = baseRequestOptions.f14356h;
            this.f14355g = null;
            this.f14349a &= -65;
        }
        if (m44632e0(baseRequestOptions.f14349a, 256)) {
            this.f14357i = baseRequestOptions.f14357i;
        }
        if (m44632e0(baseRequestOptions.f14349a, 512)) {
            this.f14359k = baseRequestOptions.f14359k;
            this.f14358j = baseRequestOptions.f14358j;
        }
        if (m44632e0(baseRequestOptions.f14349a, 1024)) {
            this.f14360l = baseRequestOptions.f14360l;
        }
        if (m44632e0(baseRequestOptions.f14349a, 4096)) {
            this.f14367s = baseRequestOptions.f14367s;
        }
        if (m44632e0(baseRequestOptions.f14349a, 8192)) {
            this.f14363o = baseRequestOptions.f14363o;
            this.f14364p = 0;
            this.f14349a &= -16385;
        }
        if (m44632e0(baseRequestOptions.f14349a, 16384)) {
            this.f14364p = baseRequestOptions.f14364p;
            this.f14363o = null;
            this.f14349a &= -8193;
        }
        if (m44632e0(baseRequestOptions.f14349a, 32768)) {
            this.f14369u = baseRequestOptions.f14369u;
        }
        if (m44632e0(baseRequestOptions.f14349a, 65536)) {
            this.f14362n = baseRequestOptions.f14362n;
        }
        if (m44632e0(baseRequestOptions.f14349a, 131072)) {
            this.f14361m = baseRequestOptions.f14361m;
        }
        if (m44632e0(baseRequestOptions.f14349a, 2048)) {
            this.f14366r.putAll(baseRequestOptions.f14366r);
            this.f14373y = baseRequestOptions.f14373y;
        }
        if (m44632e0(baseRequestOptions.f14349a, 524288)) {
            this.f14372x = baseRequestOptions.f14372x;
        }
        if (!this.f14362n) {
            this.f14366r.clear();
            this.f14361m = false;
            this.f14349a = this.f14349a & (-2049) & (-131073);
            this.f14373y = true;
        }
        this.f14349a |= baseRequestOptions.f14349a;
        this.f14365q.m45123d(baseRequestOptions.f14365q);
        return m44676C0();
    }

    /* renamed from: b0 */
    public final boolean m44635b0() {
        return m44633d0(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c0 */
    public boolean m44634c0() {
        return this.f14373y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseRequestOptions) {
            BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
            return Float.compare(baseRequestOptions.f14350b, this.f14350b) == 0 && this.f14354f == baseRequestOptions.f14354f && C3771k.m44387d(this.f14353e, baseRequestOptions.f14353e) && this.f14356h == baseRequestOptions.f14356h && C3771k.m44387d(this.f14355g, baseRequestOptions.f14355g) && this.f14364p == baseRequestOptions.f14364p && C3771k.m44387d(this.f14363o, baseRequestOptions.f14363o) && this.f14357i == baseRequestOptions.f14357i && this.f14358j == baseRequestOptions.f14358j && this.f14359k == baseRequestOptions.f14359k && this.f14361m == baseRequestOptions.f14361m && this.f14362n == baseRequestOptions.f14362n && this.f14371w == baseRequestOptions.f14371w && this.f14372x == baseRequestOptions.f14372x && this.f14351c.equals(baseRequestOptions.f14351c) && this.f14352d == baseRequestOptions.f14352d && this.f14365q.equals(baseRequestOptions.f14365q) && this.f14366r.equals(baseRequestOptions.f14366r) && this.f14367s.equals(baseRequestOptions.f14367s) && C3771k.m44387d(this.f14360l, baseRequestOptions.f14360l) && C3771k.m44387d(this.f14369u, baseRequestOptions.f14369u);
        }
        return false;
    }

    /* renamed from: f0 */
    public final boolean m44631f0() {
        return m44633d0(256);
    }

    /* renamed from: g0 */
    public final boolean m44630g0() {
        return this.f14362n;
    }

    @NonNull
    /* renamed from: h */
    public T m44629h() {
        if (this.f14368t && !this.f14370v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f14370v = true;
        return m44622k0();
    }

    /* renamed from: h0 */
    public final boolean m44628h0() {
        return this.f14361m;
    }

    public int hashCode() {
        return C3771k.m44375p(this.f14369u, C3771k.m44375p(this.f14360l, C3771k.m44375p(this.f14367s, C3771k.m44375p(this.f14366r, C3771k.m44375p(this.f14365q, C3771k.m44375p(this.f14352d, C3771k.m44375p(this.f14351c, C3771k.m44373r(this.f14372x, C3771k.m44373r(this.f14371w, C3771k.m44373r(this.f14362n, C3771k.m44373r(this.f14361m, C3771k.m44376o(this.f14359k, C3771k.m44376o(this.f14358j, C3771k.m44373r(this.f14357i, C3771k.m44375p(this.f14363o, C3771k.m44376o(this.f14364p, C3771k.m44375p(this.f14355g, C3771k.m44376o(this.f14356h, C3771k.m44375p(this.f14353e, C3771k.m44376o(this.f14354f, C3771k.m44379l(this.f14350b)))))))))))))))))))));
    }

    @NonNull
    @CheckResult
    /* renamed from: i */
    public T m44627i() {
        return m44658L0(DownsampleStrategy.f14059b, new CenterCrop());
    }

    /* renamed from: i0 */
    public final boolean m44626i0() {
        return m44633d0(2048);
    }

    @NonNull
    @CheckResult
    /* renamed from: j */
    public T m44625j() {
        return m44595z0(DownsampleStrategy.f14062e, new CenterInside());
    }

    /* renamed from: j0 */
    public final boolean m44624j0() {
        return C3771k.m44369v(this.f14359k, this.f14358j);
    }

    @NonNull
    @CheckResult
    /* renamed from: k */
    public T m44623k() {
        return m44658L0(DownsampleStrategy.f14062e, new CircleCrop());
    }

    @NonNull
    /* renamed from: k0 */
    public T m44622k0() {
        this.f14368t = true;
        return m44678B0();
    }

    @NonNull
    @CheckResult
    /* renamed from: l0 */
    public T m44621l0(boolean z) {
        if (this.f14370v) {
            return (T) clone().m44621l0(z);
        }
        this.f14372x = z;
        this.f14349a |= 524288;
        return m44676C0();
    }

    @Override // 
    @CheckResult
    /* renamed from: m */
    public T clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.f14365q = options;
            options.m45123d(this.f14365q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.f14366r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f14366r);
            t.f14368t = false;
            t.f14370v = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @CheckResult
    /* renamed from: m0 */
    public T m44619m0() {
        return m44609s0(DownsampleStrategy.f14059b, new CenterCrop());
    }

    @NonNull
    @CheckResult
    /* renamed from: n */
    public T m44618n(@NonNull Class<?> cls) {
        if (this.f14370v) {
            return (T) clone().m44618n(cls);
        }
        this.f14367s = (Class) C3770j.m44392d(cls);
        this.f14349a |= 4096;
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: n0 */
    public T m44617n0() {
        return m44613q0(DownsampleStrategy.f14062e, new CenterInside());
    }

    @NonNull
    @CheckResult
    /* renamed from: o0 */
    public T m44616o0() {
        return m44609s0(DownsampleStrategy.f14059b, new CircleCrop());
    }

    @NonNull
    @CheckResult
    /* renamed from: p0 */
    public T m44615p0() {
        return m44613q0(DownsampleStrategy.f14058a, new FitCenter());
    }

    @NonNull
    @CheckResult
    /* renamed from: q */
    public T m44614q() {
        return m44674D0(Downsampler.f14128j, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    /* renamed from: r */
    public T m44612r(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.f14370v) {
            return (T) clone().m44612r(diskCacheStrategy);
        }
        this.f14351c = (DiskCacheStrategy) C3770j.m44392d(diskCacheStrategy);
        this.f14349a |= 4;
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: r0 */
    public T m44611r0(@NonNull Transformation<Bitmap> transformation) {
        return m44660K0(transformation, false);
    }

    @NonNull
    @CheckResult
    /* renamed from: s */
    public T m44610s() {
        return m44674D0(GifOptions.f14245b, Boolean.TRUE);
    }

    @NonNull
    /* renamed from: s0 */
    final T m44609s0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.f14370v) {
            return (T) clone().m44609s0(downsampleStrategy, transformation);
        }
        m44606u(downsampleStrategy);
        return m44660K0(transformation, false);
    }

    @NonNull
    @CheckResult
    /* renamed from: t */
    public T m44608t() {
        if (this.f14370v) {
            return (T) clone().m44608t();
        }
        this.f14366r.clear();
        this.f14361m = false;
        this.f14362n = false;
        this.f14349a = (this.f14349a & (-2049) & (-131073)) | 65536;
        this.f14373y = true;
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: t0 */
    public <Y> T m44607t0(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return m44654N0(cls, transformation, false);
    }

    @NonNull
    @CheckResult
    /* renamed from: u */
    public T m44606u(@NonNull DownsampleStrategy downsampleStrategy) {
        return m44674D0(DownsampleStrategy.f14065h, C3770j.m44392d(downsampleStrategy));
    }

    @NonNull
    @CheckResult
    /* renamed from: u0 */
    public T m44605u0(int i) {
        return m44603v0(i, i);
    }

    @NonNull
    @CheckResult
    /* renamed from: v */
    public T m44604v(@NonNull Bitmap.CompressFormat compressFormat) {
        return m44674D0(BitmapEncoder.f14085c, C3770j.m44392d(compressFormat));
    }

    @NonNull
    @CheckResult
    /* renamed from: v0 */
    public T m44603v0(int i, int i2) {
        if (this.f14370v) {
            return (T) clone().m44603v0(i, i2);
        }
        this.f14359k = i;
        this.f14358j = i2;
        this.f14349a |= 512;
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: w */
    public T m44602w(@IntRange(from = 0, m60035to = 100) int i) {
        return m44674D0(BitmapEncoder.f14084b, Integer.valueOf(i));
    }

    @NonNull
    @CheckResult
    /* renamed from: w0 */
    public T m44601w0(@DrawableRes int i) {
        if (this.f14370v) {
            return (T) clone().m44601w0(i);
        }
        this.f14356h = i;
        this.f14355g = null;
        this.f14349a = (this.f14349a | 128) & (-65);
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: x */
    public T m44600x(@DrawableRes int i) {
        if (this.f14370v) {
            return (T) clone().m44600x(i);
        }
        this.f14354f = i;
        this.f14353e = null;
        this.f14349a = (this.f14349a | 32) & (-17);
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: x0 */
    public T m44599x0(@Nullable Drawable drawable) {
        if (this.f14370v) {
            return (T) clone().m44599x0(drawable);
        }
        this.f14355g = drawable;
        this.f14356h = 0;
        this.f14349a = (this.f14349a | 64) & (-129);
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: y */
    public T m44598y(@Nullable Drawable drawable) {
        if (this.f14370v) {
            return (T) clone().m44598y(drawable);
        }
        this.f14353e = drawable;
        this.f14354f = 0;
        this.f14349a = (this.f14349a | 16) & (-33);
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: y0 */
    public T m44597y0(@NonNull Priority priority) {
        if (this.f14370v) {
            return (T) clone().m44597y0(priority);
        }
        this.f14352d = (Priority) C3770j.m44392d(priority);
        this.f14349a |= 8;
        return m44676C0();
    }

    @NonNull
    @CheckResult
    /* renamed from: z */
    public T m44596z(@DrawableRes int i) {
        if (this.f14370v) {
            return (T) clone().m44596z(i);
        }
        this.f14364p = i;
        this.f14363o = null;
        this.f14349a = (this.f14349a | 16384) & (-8193);
        return m44676C0();
    }
}
