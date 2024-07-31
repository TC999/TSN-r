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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.InterfaceC3744d;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
import com.bumptech.glide.util.Executors;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.bumptech.glide.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {

    /* renamed from: I0 */
    protected static final RequestOptions f13432I0 = new RequestOptions().m44612r(DiskCacheStrategy.f13788c).m44597y0(Priority.LOW).m44668G0(true);
    @Nullable

    /* renamed from: A0 */
    private Object f13433A0;
    @Nullable

    /* renamed from: B0 */
    private List<RequestListener<TranscodeType>> f13434B0;
    @Nullable

    /* renamed from: C0 */
    private RequestBuilder<TranscodeType> f13435C0;
    @Nullable

    /* renamed from: D0 */
    private RequestBuilder<TranscodeType> f13436D0;
    @Nullable

    /* renamed from: E0 */
    private Float f13437E0;

    /* renamed from: F0 */
    private boolean f13438F0;

    /* renamed from: G0 */
    private boolean f13439G0;

    /* renamed from: H0 */
    private boolean f13440H0;

    /* renamed from: V */
    private final Context f13441V;

    /* renamed from: W */
    private final C3558j f13442W;

    /* renamed from: X */
    private final Class<TranscodeType> f13443X;

    /* renamed from: Y */
    private final Glide f13444Y;

    /* renamed from: Z */
    private final GlideContext f13445Z;
    @NonNull

    /* renamed from: p0 */
    private TransitionOptions<?, ? super TranscodeType> f13446p0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilder.java */
    /* renamed from: com.bumptech.glide.i$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C3557a {

        /* renamed from: a */
        static final /* synthetic */ int[] f13447a;

        /* renamed from: b */
        static final /* synthetic */ int[] f13448b;

        static {
            int[] iArr = new int[Priority.values().length];
            f13448b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13448b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13448b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13448b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f13447a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13447a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13447a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13447a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13447a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13447a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13447a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13447a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public RequestBuilder(@NonNull Glide glide, C3558j c3558j, Class<TranscodeType> cls, Context context) {
        this.f13438F0 = true;
        this.f13444Y = glide;
        this.f13442W = c3558j;
        this.f13443X = cls;
        this.f13441V = context;
        this.f13446p0 = c3558j.m45529E(cls);
        this.f13445Z = glide.m45739i();
        m45556d1(c3558j.m45531C());
        mo44636b(c3558j.m45530D());
    }

    /* renamed from: U0 */
    private InterfaceC3744d m45565U0(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return m45564V0(target, requestListener, null, this.f13446p0, baseRequestOptions.m44651P(), baseRequestOptions.m44657M(), baseRequestOptions.m44659L(), baseRequestOptions, executor);
    }

    /* renamed from: V0 */
    private InterfaceC3744d m45564V0(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        if (this.f13436D0 != null) {
            errorRequestCoordinator2 = new ErrorRequestCoordinator(requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator2;
        } else {
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        InterfaceC3744d m45563W0 = m45563W0(target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i, i2, baseRequestOptions, executor);
        if (errorRequestCoordinator == null) {
            return m45563W0;
        }
        int m44657M = this.f13436D0.m44657M();
        int m44659L = this.f13436D0.m44659L();
        if (C3771k.m44369v(i, i2) && !this.f13436D0.m44624j0()) {
            m44657M = baseRequestOptions.m44657M();
            m44659L = baseRequestOptions.m44659L();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.f13436D0;
        ErrorRequestCoordinator errorRequestCoordinator3 = errorRequestCoordinator;
        errorRequestCoordinator3.m44589r(m45563W0, requestBuilder.m45564V0(target, requestListener, errorRequestCoordinator, requestBuilder.f13446p0, requestBuilder.m44651P(), m44657M, m44659L, this.f13436D0, executor));
        return errorRequestCoordinator3;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.a] */
    /* renamed from: W0 */
    private InterfaceC3744d m45563W0(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        RequestBuilder<TranscodeType> requestBuilder = this.f13435C0;
        if (requestBuilder != null) {
            if (!this.f13440H0) {
                TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.f13438F0 ? transitionOptions : requestBuilder.f13446p0;
                Priority m44651P = requestBuilder.m44635b0() ? this.f13435C0.m44651P() : m45557c1(priority);
                int m44657M = this.f13435C0.m44657M();
                int m44659L = this.f13435C0.m44659L();
                if (C3771k.m44369v(i, i2) && !this.f13435C0.m44624j0()) {
                    m44657M = baseRequestOptions.m44657M();
                    m44659L = baseRequestOptions.m44659L();
                }
                int i3 = m44657M;
                int i4 = m44659L;
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator);
                InterfaceC3744d m45538v1 = m45538v1(target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2, executor);
                this.f13440H0 = true;
                RequestBuilder<TranscodeType> requestBuilder2 = this.f13435C0;
                InterfaceC3744d m45564V0 = requestBuilder2.m45564V0(target, requestListener, thumbnailRequestCoordinator, transitionOptions2, m44651P, i3, i4, requestBuilder2, executor);
                this.f13440H0 = false;
                thumbnailRequestCoordinator.m44517q(m45538v1, m45564V0);
                return thumbnailRequestCoordinator;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.f13437E0 != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(requestCoordinator);
            thumbnailRequestCoordinator2.m44517q(m45538v1(target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2, executor), m45538v1(target, requestListener, baseRequestOptions.clone().m44670F0(this.f13437E0.floatValue()), thumbnailRequestCoordinator2, transitionOptions, m45557c1(priority), i, i2, executor));
            return thumbnailRequestCoordinator2;
        } else {
            return m45538v1(target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i, i2, executor);
        }
    }

    @NonNull
    /* renamed from: c1 */
    private Priority m45557c1(@NonNull Priority priority) {
        int i = C3557a.f13448b[priority.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3 && i != 4) {
                    throw new IllegalArgumentException("unknown priority: " + m44651P());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: d1 */
    private void m45556d1(List<RequestListener<Object>> list) {
        for (RequestListener<Object> requestListener : list) {
            m45567S0(requestListener);
        }
    }

    /* renamed from: g1 */
    private <Y extends Target<TranscodeType>> Y m45553g1(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        C3770j.m44392d(y);
        if (this.f13439G0) {
            InterfaceC3744d m45565U0 = m45565U0(y, requestListener, baseRequestOptions, executor);
            InterfaceC3744d mo44472i = y.mo44472i();
            if (m45565U0.mo44525i(mo44472i) && !m45550j1(baseRequestOptions, mo44472i)) {
                m45565U0.recycle();
                if (!((InterfaceC3744d) C3770j.m44392d(mo44472i)).isRunning()) {
                    mo44472i.mo44524j();
                }
                return y;
            }
            this.f13442W.m45490z(y);
            y.mo44469m(m45565U0);
            this.f13442W.m45511W(y, m45565U0);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    /* renamed from: j1 */
    private boolean m45550j1(BaseRequestOptions<?> baseRequestOptions, InterfaceC3744d interfaceC3744d) {
        return !baseRequestOptions.m44637a0() && interfaceC3744d.mo44533a();
    }

    @NonNull
    /* renamed from: u1 */
    private RequestBuilder<TranscodeType> m45539u1(@Nullable Object obj) {
        this.f13433A0 = obj;
        this.f13439G0 = true;
        return this;
    }

    /* renamed from: v1 */
    private InterfaceC3744d m45538v1(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, Executor executor) {
        Context context = this.f13441V;
        GlideContext glideContext = this.f13445Z;
        return SingleRequest.m44557A(context, glideContext, this.f13433A0, this.f13443X, baseRequestOptions, i, i2, priority, target, requestListener, this.f13434B0, requestCoordinator, glideContext.m45632f(), transitionOptions.m45487c(), executor);
    }

    @NonNull
    @CheckResult
    /* renamed from: A1 */
    public RequestBuilder<TranscodeType> m45571A1(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.f13437E0 = Float.valueOf(f);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    /* renamed from: B1 */
    public RequestBuilder<TranscodeType> m45570B1(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.f13435C0 = requestBuilder;
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: C1 */
    public RequestBuilder<TranscodeType> m45569C1(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        RequestBuilder<TranscodeType> requestBuilder = null;
        if (requestBuilderArr != null && requestBuilderArr.length != 0) {
            for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
                RequestBuilder<TranscodeType> requestBuilder2 = requestBuilderArr[length];
                if (requestBuilder2 != null) {
                    requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.m45570B1(requestBuilder);
                }
            }
            return m45570B1(requestBuilder);
        }
        return m45570B1(null);
    }

    @NonNull
    @CheckResult
    /* renamed from: D1 */
    public RequestBuilder<TranscodeType> m45568D1(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.f13446p0 = (TransitionOptions) C3770j.m44392d(transitionOptions);
        this.f13438F0 = false;
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: S0 */
    public RequestBuilder<TranscodeType> m45567S0(@Nullable RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.f13434B0 == null) {
                this.f13434B0 = new ArrayList();
            }
            this.f13434B0.add(requestListener);
        }
        return this;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: T0 */
    public RequestBuilder<TranscodeType> mo44636b(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        C3770j.m44392d(baseRequestOptions);
        return (RequestBuilder) super.mo44636b(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* renamed from: X0 */
    public RequestBuilder<TranscodeType> mo44620m() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.f13446p0 = (TransitionOptions<?, ? super TranscodeType>) requestBuilder.f13446p0.clone();
        return requestBuilder;
    }

    @CheckResult
    @Deprecated
    /* renamed from: Y0 */
    public FutureTarget<File> m45561Y0(int i, int i2) {
        return m45558b1().m45534z1(i, i2);
    }

    @CheckResult
    @Deprecated
    /* renamed from: Z0 */
    public <Y extends Target<File>> Y m45560Z0(@NonNull Y y) {
        return (Y) m45558b1().m45554f1(y);
    }

    @NonNull
    /* renamed from: a1 */
    public RequestBuilder<TranscodeType> m45559a1(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        this.f13436D0 = requestBuilder;
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: b1 */
    protected RequestBuilder<File> m45558b1() {
        return new RequestBuilder(File.class, this).mo44636b(f13432I0);
    }

    @Deprecated
    /* renamed from: e1 */
    public FutureTarget<TranscodeType> m45555e1(int i, int i2) {
        return m45534z1(i, i2);
    }

    @NonNull
    /* renamed from: f1 */
    public <Y extends Target<TranscodeType>> Y m45554f1(@NonNull Y y) {
        return (Y) m45552h1(y, null, Executors.m44414b());
    }

    @NonNull
    /* renamed from: h1 */
    <Y extends Target<TranscodeType>> Y m45552h1(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, Executor executor) {
        return (Y) m45553g1(y, requestListener, this, executor);
    }

    @NonNull
    /* renamed from: i1 */
    public ViewTarget<ImageView, TranscodeType> m45551i1(@NonNull ImageView imageView) {
        RequestBuilder<TranscodeType> requestBuilder;
        C3771k.m44389b();
        C3770j.m44392d(imageView);
        if (!m44626i0() && m44630g0() && imageView.getScaleType() != null) {
            switch (C3557a.f13447a[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestBuilder = clone().m44619m0();
                    break;
                case 2:
                    requestBuilder = clone().m44617n0();
                    break;
                case 3:
                case 4:
                case 5:
                    requestBuilder = clone().m44615p0();
                    break;
                case 6:
                    requestBuilder = clone().m44617n0();
                    break;
            }
            return (ViewTarget) m45553g1(this.f13445Z.m45637a(imageView, this.f13443X), null, requestBuilder, Executors.m44414b());
        }
        requestBuilder = this;
        return (ViewTarget) m45553g1(this.f13445Z.m45637a(imageView, this.f13443X), null, requestBuilder, Executors.m44414b());
    }

    @NonNull
    @CheckResult
    /* renamed from: k1 */
    public RequestBuilder<TranscodeType> m45549k1(@Nullable RequestListener<TranscodeType> requestListener) {
        this.f13434B0 = null;
        return m45567S0(requestListener);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: l1 */
    public RequestBuilder<TranscodeType> mo45501l(@Nullable Bitmap bitmap) {
        return m45539u1(bitmap).mo44636b(RequestOptions.m44578X0(DiskCacheStrategy.f13787b));
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: m1 */
    public RequestBuilder<TranscodeType> mo45502g(@Nullable Drawable drawable) {
        return m45539u1(drawable).mo44636b(RequestOptions.m44578X0(DiskCacheStrategy.f13787b));
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: n1 */
    public RequestBuilder<TranscodeType> mo45505d(@Nullable Uri uri) {
        return m45539u1(uri);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: o1 */
    public RequestBuilder<TranscodeType> mo45503f(@Nullable File file) {
        return m45539u1(file);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: p1 */
    public RequestBuilder<TranscodeType> mo45499p(@Nullable @DrawableRes @RawRes Integer num) {
        return m45539u1(num).mo44636b(RequestOptions.m44561o1(ApplicationVersionSignature.m44436c(this.f13441V)));
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: q1 */
    public RequestBuilder<TranscodeType> mo45500o(@Nullable Object obj) {
        return m45539u1(obj);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: r1 */
    public RequestBuilder<TranscodeType> mo45507a(@Nullable String str) {
        return m45539u1(str);
    }

    @Override // com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* renamed from: s1 */
    public RequestBuilder<TranscodeType> mo45506c(@Nullable URL url) {
        return m45539u1(url);
    }

    @Override // com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: t1 */
    public RequestBuilder<TranscodeType> mo45504e(@Nullable byte[] bArr) {
        RequestBuilder<TranscodeType> m45539u1 = m45539u1(bArr);
        if (!m45539u1.m44639Y()) {
            m45539u1 = m45539u1.mo44636b(RequestOptions.m44578X0(DiskCacheStrategy.f13787b));
        }
        return !m45539u1.m44631f0() ? m45539u1.mo44636b(RequestOptions.m44559q1(true)) : m45539u1;
    }

    @NonNull
    /* renamed from: w1 */
    public Target<TranscodeType> m45537w1() {
        return m45536x1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    /* renamed from: x1 */
    public Target<TranscodeType> m45536x1(int i, int i2) {
        return m45554f1(PreloadTarget.m44482e(this.f13442W, i, i2));
    }

    @NonNull
    /* renamed from: y1 */
    public FutureTarget<TranscodeType> m45535y1() {
        return m45534z1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    /* renamed from: z1 */
    public FutureTarget<TranscodeType> m45534z1(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
        return (FutureTarget) m45552h1(requestFutureTarget, requestFutureTarget, Executors.m44415a());
    }

    @SuppressLint({"CheckResult"})
    protected RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.f13444Y, requestBuilder.f13442W, cls, requestBuilder.f13441V);
        this.f13433A0 = requestBuilder.f13433A0;
        this.f13439G0 = requestBuilder.f13439G0;
        mo44636b(requestBuilder);
    }
}
