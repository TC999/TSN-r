package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GlideContext extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: j */
    static final TransitionOptions<?, ?> f13316j = new GenericTransitionOptions();

    /* renamed from: a */
    private final ArrayPool f13317a;

    /* renamed from: b */
    private final Registry f13318b;

    /* renamed from: c */
    private final ImageViewTargetFactory f13319c;

    /* renamed from: d */
    private final RequestOptions f13320d;

    /* renamed from: e */
    private final List<RequestListener<Object>> f13321e;

    /* renamed from: f */
    private final Map<Class<?>, TransitionOptions<?, ?>> f13322f;

    /* renamed from: g */
    private final Engine f13323g;

    /* renamed from: h */
    private final boolean f13324h;

    /* renamed from: i */
    private final int f13325i;

    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull RequestOptions requestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull Engine engine, boolean z, int i) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f13317a = arrayPool;
        this.f13318b = registry;
        this.f13319c = imageViewTargetFactory;
        this.f13320d = requestOptions;
        this.f13321e = list;
        this.f13322f = map;
        this.f13323g = engine;
        this.f13324h = z;
        this.f13325i = i;
    }

    @NonNull
    /* renamed from: a */
    public <X> ViewTarget<ImageView, X> m45637a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f13319c.m44485a(imageView, cls);
    }

    @NonNull
    /* renamed from: b */
    public ArrayPool m45636b() {
        return this.f13317a;
    }

    /* renamed from: c */
    public List<RequestListener<Object>> m45635c() {
        return this.f13321e;
    }

    /* renamed from: d */
    public RequestOptions m45634d() {
        return this.f13320d;
    }

    @NonNull
    /* renamed from: e */
    public <T> TransitionOptions<?, T> m45633e(@NonNull Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = (TransitionOptions<?, T>) this.f13322f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry<Class<?>, TransitionOptions<?, ?>> entry : this.f13322f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions<?, T>) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (TransitionOptions<?, T>) f13316j : transitionOptions;
    }

    @NonNull
    /* renamed from: f */
    public Engine m45632f() {
        return this.f13323g;
    }

    /* renamed from: g */
    public int m45631g() {
        return this.f13325i;
    }

    @NonNull
    /* renamed from: h */
    public Registry m45630h() {
        return this.f13318b;
    }

    /* renamed from: i */
    public boolean m45629i() {
        return this.f13324h;
    }
}
