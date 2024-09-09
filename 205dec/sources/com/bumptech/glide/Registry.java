package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class Registry {

    /* renamed from: k  reason: collision with root package name */
    public static final String f16435k = "Gif";

    /* renamed from: l  reason: collision with root package name */
    public static final String f16436l = "Bitmap";

    /* renamed from: m  reason: collision with root package name */
    public static final String f16437m = "BitmapDrawable";

    /* renamed from: n  reason: collision with root package name */
    private static final String f16438n = "legacy_prepend_all";

    /* renamed from: o  reason: collision with root package name */
    private static final String f16439o = "legacy_append";

    /* renamed from: a  reason: collision with root package name */
    private final p f16440a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.provider.a f16441b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.provider.e f16442c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.provider.f f16443d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f16444e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.transcode.f f16445f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.provider.b f16446g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.provider.d f16447h = new com.bumptech.glide.provider.d();

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.provider.c f16448i = new com.bumptech.glide.provider.c();

    /* renamed from: j  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f16449j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> f4 = com.bumptech.glide.util.pool.a.f();
        this.f16449j = f4;
        this.f16440a = new p(f4);
        this.f16441b = new com.bumptech.glide.provider.a();
        this.f16442c = new com.bumptech.glide.provider.e();
        this.f16443d = new com.bumptech.glide.provider.f();
        this.f16444e = new com.bumptech.glide.load.data.f();
        this.f16445f = new com.bumptech.glide.load.resource.transcode.f();
        this.f16446g = new com.bumptech.glide.provider.b();
        z(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.i<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f16442c.d(cls, cls2)) {
            for (Class cls5 : this.f16445f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.i(cls, cls4, cls5, this.f16442c.b(cls, cls4), this.f16445f.a(cls4, cls5), this.f16449j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.f16441b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.h<TResource> hVar) {
        this.f16443d.a(cls, hVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        e("legacy_append", cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f16440a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        this.f16442c.a(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b4 = this.f16446g.b();
        if (b4.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return b4;
    }

    @Nullable
    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        s<Data, TResource, Transcode> a4 = this.f16448i.a(cls, cls2, cls3);
        if (this.f16448i.c(a4)) {
            return null;
        }
        if (a4 == null) {
            List<com.bumptech.glide.load.engine.i<Data, TResource, Transcode>> f4 = f(cls, cls2, cls3);
            a4 = f4.isEmpty() ? null : new s<>(cls, cls2, cls3, f4, this.f16449j);
            this.f16448i.d(cls, cls2, cls3, a4);
        }
        return a4;
    }

    @NonNull
    public <Model> List<n<Model, ?>> i(@NonNull Model model) {
        List<n<Model, ?>> e4 = this.f16440a.e(model);
        if (e4.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return e4;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> b4 = this.f16447h.b(cls, cls2, cls3);
        if (b4 == null) {
            b4 = new ArrayList<>();
            for (Class<?> cls4 : this.f16440a.d(cls)) {
                for (Class<?> cls5 : this.f16442c.d(cls4, cls2)) {
                    if (!this.f16445f.b(cls5, cls3).isEmpty() && !b4.contains(cls5)) {
                        b4.add(cls5);
                    }
                }
            }
            this.f16447h.c(cls, cls2, cls3, Collections.unmodifiableList(b4));
        }
        return b4;
    }

    @NonNull
    public <X> com.bumptech.glide.load.h<X> k(@NonNull u<X> uVar) throws NoResultEncoderAvailableException {
        com.bumptech.glide.load.h<X> b4 = this.f16443d.b(uVar.b());
        if (b4 != null) {
            return b4;
        }
        throw new NoResultEncoderAvailableException(uVar.b());
    }

    @NonNull
    public <X> com.bumptech.glide.load.data.e<X> l(@NonNull X x3) {
        return this.f16444e.a(x3);
    }

    @NonNull
    public <X> com.bumptech.glide.load.a<X> m(@NonNull X x3) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> b4 = this.f16441b.b(x3.getClass());
        if (b4 != null) {
            return b4;
        }
        throw new NoSourceEncoderAvailableException(x3.getClass());
    }

    public boolean n(@NonNull u<?> uVar) {
        return this.f16443d.b(uVar.b()) != null;
    }

    @NonNull
    public <Data> Registry o(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.f16441b.c(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry p(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.h<TResource> hVar) {
        this.f16443d.c(cls, hVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry q(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        s("legacy_prepend_all", cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f16440a.g(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry s(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.g<Data, TResource> gVar) {
        this.f16442c.e(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public Registry t(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f16446g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry u(@NonNull e.a<?> aVar) {
        this.f16444e.b(aVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> Registry v(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        return a(cls, aVar);
    }

    @NonNull
    @Deprecated
    public <TResource> Registry w(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.h<TResource> hVar) {
        return b(cls, hVar);
    }

    @NonNull
    public <TResource, Transcode> Registry x(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.resource.transcode.e<TResource, Transcode> eVar) {
        this.f16445f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry y(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f16440a.i(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public final Registry z(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f16442c.f(arrayList);
        return this;
    }
}
