package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.target.r;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GlideContext.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    static final k<?, ?> f16660j = new c();

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f16661a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f16662b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.request.target.k f16663c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.request.h f16664d;

    /* renamed from: e  reason: collision with root package name */
    private final List<com.bumptech.glide.request.g<Object>> f16665e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f16666f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.k f16667g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f16668h;

    /* renamed from: i  reason: collision with root package name */
    private final int f16669i;

    public f(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar, @NonNull Registry registry, @NonNull com.bumptech.glide.request.target.k kVar, @NonNull com.bumptech.glide.request.h hVar, @NonNull Map<Class<?>, k<?, ?>> map, @NonNull List<com.bumptech.glide.request.g<Object>> list, @NonNull com.bumptech.glide.load.engine.k kVar2, boolean z3, int i4) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f16661a = bVar;
        this.f16662b = registry;
        this.f16663c = kVar;
        this.f16664d = hVar;
        this.f16665e = list;
        this.f16666f = map;
        this.f16667g = kVar2;
        this.f16668h = z3;
        this.f16669i = i4;
    }

    @NonNull
    public <X> r<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f16663c.a(imageView, cls);
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f16661a;
    }

    public List<com.bumptech.glide.request.g<Object>> c() {
        return this.f16665e;
    }

    public com.bumptech.glide.request.h d() {
        return this.f16664d;
    }

    @NonNull
    public <T> k<?, T> e(@NonNull Class<T> cls) {
        k<?, T> kVar = (k<?, T>) this.f16666f.get(cls);
        if (kVar == null) {
            for (Map.Entry<Class<?>, k<?, ?>> entry : this.f16666f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    kVar = (k<?, T>) entry.getValue();
                }
            }
        }
        return kVar == null ? (k<?, T>) f16660j : kVar;
    }

    @NonNull
    public com.bumptech.glide.load.engine.k f() {
        return this.f16667g;
    }

    public int g() {
        return this.f16669i;
    }

    @NonNull
    public Registry h() {
        return this.f16662b;
    }

    public boolean i() {
        return this.f16668h;
    }
}
