package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Registry {

    /* renamed from: k */
    public static final String f13211k = "Gif";

    /* renamed from: l */
    public static final String f13212l = "Bitmap";

    /* renamed from: m */
    public static final String f13213m = "BitmapDrawable";

    /* renamed from: n */
    private static final String f13214n = "legacy_prepend_all";

    /* renamed from: o */
    private static final String f13215o = "legacy_append";

    /* renamed from: a */
    private final ModelLoaderRegistry f13216a;

    /* renamed from: b */
    private final EncoderRegistry f13217b;

    /* renamed from: c */
    private final ResourceDecoderRegistry f13218c;

    /* renamed from: d */
    private final ResourceEncoderRegistry f13219d;

    /* renamed from: e */
    private final DataRewinderRegistry f13220e;

    /* renamed from: f */
    private final TranscoderRegistry f13221f;

    /* renamed from: g */
    private final ImageHeaderParserRegistry f13222g;

    /* renamed from: h */
    private final ModelToResourceClassCache f13223h = new ModelToResourceClassCache();

    /* renamed from: i */
    private final LoadPathCache f13224i = new LoadPathCache();

    /* renamed from: j */
    private final Pools.Pool<List<Throwable>> f13225j;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> m44358f = FactoryPools.m44358f();
        this.f13225j = m44358f;
        this.f13216a = new ModelLoaderRegistry(m44358f);
        this.f13217b = new EncoderRegistry();
        this.f13218c = new ResourceDecoderRegistry();
        this.f13219d = new ResourceEncoderRegistry();
        this.f13220e = new DataRewinderRegistry();
        this.f13221f = new TranscoderRegistry();
        this.f13222g = new ImageHeaderParserRegistry();
        m45760z(Arrays.asList(f13211k, f13212l, f13213m));
    }

    @NonNull
    /* renamed from: f */
    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> m45780f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f13218c.m44689d(cls, cls2)) {
            for (Class cls5 : this.f13221f.m44787b(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.f13218c.m44691b(cls, cls4), this.f13221f.m44788a(cls4, cls5), this.f13225j));
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public <Data> Registry m45785a(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f13217b.m44705a(cls, encoder);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <TResource> Registry m45784b(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f13219d.m44685a(cls, resourceEncoder);
        return this;
    }

    @NonNull
    /* renamed from: c */
    public <Data, TResource> Registry m45783c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        m45781e(f13215o, cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    /* renamed from: d */
    public <Model, Data> Registry m45782d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f13216a.m45065a(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    /* renamed from: e */
    public <Data, TResource> Registry m45781e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f13218c.m44692a(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: g */
    public List<ImageHeaderParser> m45779g() {
        List<ImageHeaderParser> m44700b = this.f13222g.m44700b();
        if (m44700b.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return m44700b;
    }

    @Nullable
    /* renamed from: h */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> m45778h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> m44699a = this.f13224i.m44699a(cls, cls2, cls3);
        if (this.f13224i.m44697c(m44699a)) {
            return null;
        }
        if (m44699a == null) {
            List<DecodePath<Data, TResource, Transcode>> m45780f = m45780f(cls, cls2, cls3);
            m44699a = m45780f.isEmpty() ? null : new LoadPath<>(cls, cls2, cls3, m45780f, this.f13225j);
            this.f13224i.m44696d(cls, cls2, cls3, m44699a);
        }
        return m44699a;
    }

    @NonNull
    /* renamed from: i */
    public <Model> List<ModelLoader<Model, ?>> m45777i(@NonNull Model model) {
        List<ModelLoader<Model, ?>> m45061e = this.f13216a.m45061e(model);
        if (m45061e.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return m45061e;
    }

    @NonNull
    /* renamed from: j */
    public <Model, TResource, Transcode> List<Class<?>> m45776j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> m44694b = this.f13223h.m44694b(cls, cls2, cls3);
        if (m44694b == null) {
            m44694b = new ArrayList<>();
            for (Class<?> cls4 : this.f13216a.m45062d(cls)) {
                for (Class<?> cls5 : this.f13218c.m44689d(cls4, cls2)) {
                    if (!this.f13221f.m44787b(cls5, cls3).isEmpty() && !m44694b.contains(cls5)) {
                        m44694b.add(cls5);
                    }
                }
            }
            this.f13223h.m44693c(cls, cls2, cls3, Collections.unmodifiableList(m44694b));
        }
        return m44694b;
    }

    @NonNull
    /* renamed from: k */
    public <X> ResourceEncoder<X> m45775k(@NonNull Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> m44684b = this.f13219d.m44684b(resource.mo2883b());
        if (m44684b != null) {
            return m44684b;
        }
        throw new NoResultEncoderAvailableException(resource.mo2883b());
    }

    @NonNull
    /* renamed from: l */
    public <X> DataRewinder<X> m45774l(@NonNull X x) {
        return this.f13220e.m45476a(x);
    }

    @NonNull
    /* renamed from: m */
    public <X> Encoder<X> m45773m(@NonNull X x) throws NoSourceEncoderAvailableException {
        Encoder<X> m44704b = this.f13217b.m44704b(x.getClass());
        if (m44704b != null) {
            return m44704b;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    /* renamed from: n */
    public boolean m45772n(@NonNull Resource<?> resource) {
        return this.f13219d.m44684b(resource.mo2883b()) != null;
    }

    @NonNull
    /* renamed from: o */
    public <Data> Registry m45771o(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f13217b.m44703c(cls, encoder);
        return this;
    }

    @NonNull
    /* renamed from: p */
    public <TResource> Registry m45770p(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f13219d.m44683c(cls, resourceEncoder);
        return this;
    }

    @NonNull
    /* renamed from: q */
    public <Data, TResource> Registry m45769q(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        m45767s(f13214n, cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    /* renamed from: r */
    public <Model, Data> Registry m45768r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f13216a.m45059g(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    /* renamed from: s */
    public <Data, TResource> Registry m45767s(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f13218c.m44688e(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: t */
    public Registry m45766t(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f13222g.m44701a(imageHeaderParser);
        return this;
    }

    @NonNull
    /* renamed from: u */
    public Registry m45765u(@NonNull DataRewinder.InterfaceC3563a<?> interfaceC3563a) {
        this.f13220e.m45475b(interfaceC3563a);
        return this;
    }

    @NonNull
    @Deprecated
    /* renamed from: v */
    public <Data> Registry m45764v(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        return m45785a(cls, encoder);
    }

    @NonNull
    @Deprecated
    /* renamed from: w */
    public <TResource> Registry m45763w(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        return m45784b(cls, resourceEncoder);
    }

    @NonNull
    /* renamed from: x */
    public <TResource, Transcode> Registry m45762x(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f13221f.m44786c(cls, cls2, resourceTranscoder);
        return this;
    }

    @NonNull
    /* renamed from: y */
    public <Model, Data> Registry m45761y(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f13216a.m45057i(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    /* renamed from: z */
    public final Registry m45760z(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, f13214n);
        arrayList.add(f13215o);
        this.f13218c.m44687f(arrayList);
        return this;
    }
}
