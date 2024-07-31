package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GlideBuilder {

    /* renamed from: b */
    private Engine f13300b;

    /* renamed from: c */
    private BitmapPool f13301c;

    /* renamed from: d */
    private ArrayPool f13302d;

    /* renamed from: e */
    private MemoryCache f13303e;

    /* renamed from: f */
    private GlideExecutor f13304f;

    /* renamed from: g */
    private GlideExecutor f13305g;

    /* renamed from: h */
    private DiskCache.InterfaceC3592a f13306h;

    /* renamed from: i */
    private MemorySizeCalculator f13307i;

    /* renamed from: j */
    private ConnectivityMonitorFactory f13308j;
    @Nullable

    /* renamed from: m */
    private RequestManagerRetriever.InterfaceC3740b f13311m;

    /* renamed from: n */
    private GlideExecutor f13312n;

    /* renamed from: o */
    private boolean f13313o;
    @Nullable

    /* renamed from: p */
    private List<RequestListener<Object>> f13314p;

    /* renamed from: q */
    private boolean f13315q;

    /* renamed from: a */
    private final Map<Class<?>, TransitionOptions<?, ?>> f13299a = new ArrayMap();

    /* renamed from: k */
    private int f13309k = 4;

    /* renamed from: l */
    private RequestOptions f13310l = new RequestOptions();

    @NonNull
    /* renamed from: a */
    public GlideBuilder m45657a(@NonNull RequestListener<Object> requestListener) {
        if (this.f13314p == null) {
            this.f13314p = new ArrayList();
        }
        this.f13314p.add(requestListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public Glide m45656b(@NonNull Context context) {
        if (this.f13304f == null) {
            this.f13304f = GlideExecutor.m45289g();
        }
        if (this.f13305g == null) {
            this.f13305g = GlideExecutor.m45292d();
        }
        if (this.f13312n == null) {
            this.f13312n = GlideExecutor.m45294b();
        }
        if (this.f13307i == null) {
            this.f13307i = new MemorySizeCalculator.C3604a(context).m45310a();
        }
        if (this.f13308j == null) {
            this.f13308j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f13301c == null) {
            int m45315b = this.f13307i.m45315b();
            if (m45315b > 0) {
                this.f13301c = new LruBitmapPool(m45315b);
            } else {
                this.f13301c = new BitmapPoolAdapter();
            }
        }
        if (this.f13302d == null) {
            this.f13302d = new LruArrayPool(this.f13307i.m45316a());
        }
        if (this.f13303e == null) {
            this.f13303e = new LruResourceCache(this.f13307i.m45313d());
        }
        if (this.f13306h == null) {
            this.f13306h = new InternalCacheDiskCacheFactory(context);
        }
        if (this.f13300b == null) {
            this.f13300b = new Engine(this.f13303e, this.f13306h, this.f13305g, this.f13304f, GlideExecutor.m45286j(), GlideExecutor.m45294b(), this.f13313o);
        }
        List<RequestListener<Object>> list = this.f13314p;
        if (list == null) {
            this.f13314p = Collections.emptyList();
        } else {
            this.f13314p = Collections.unmodifiableList(list);
        }
        return new Glide(context, this.f13300b, this.f13303e, this.f13301c, this.f13302d, new RequestManagerRetriever(this.f13311m), this.f13308j, this.f13309k, this.f13310l.m44622k0(), this.f13299a, this.f13314p, this.f13315q);
    }

    @NonNull
    /* renamed from: c */
    public GlideBuilder m45655c(@Nullable GlideExecutor glideExecutor) {
        this.f13312n = glideExecutor;
        return this;
    }

    @NonNull
    /* renamed from: d */
    public GlideBuilder m45654d(@Nullable ArrayPool arrayPool) {
        this.f13302d = arrayPool;
        return this;
    }

    @NonNull
    /* renamed from: e */
    public GlideBuilder m45653e(@Nullable BitmapPool bitmapPool) {
        this.f13301c = bitmapPool;
        return this;
    }

    @NonNull
    /* renamed from: f */
    public GlideBuilder m45652f(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.f13308j = connectivityMonitorFactory;
        return this;
    }

    @NonNull
    /* renamed from: g */
    public GlideBuilder m45651g(@Nullable RequestOptions requestOptions) {
        this.f13310l = requestOptions;
        return this;
    }

    @NonNull
    /* renamed from: h */
    public <T> GlideBuilder m45650h(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        this.f13299a.put(cls, transitionOptions);
        return this;
    }

    @NonNull
    /* renamed from: i */
    public GlideBuilder m45649i(@Nullable DiskCache.InterfaceC3592a interfaceC3592a) {
        this.f13306h = interfaceC3592a;
        return this;
    }

    @NonNull
    /* renamed from: j */
    public GlideBuilder m45648j(@Nullable GlideExecutor glideExecutor) {
        this.f13305g = glideExecutor;
        return this;
    }

    /* renamed from: k */
    GlideBuilder m45647k(Engine engine) {
        this.f13300b = engine;
        return this;
    }

    @NonNull
    /* renamed from: l */
    public GlideBuilder m45646l(boolean z) {
        this.f13313o = z;
        return this;
    }

    @NonNull
    /* renamed from: m */
    public GlideBuilder m45645m(int i) {
        if (i >= 2 && i <= 6) {
            this.f13309k = i;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    /* renamed from: n */
    public GlideBuilder m45644n(boolean z) {
        this.f13315q = z;
        return this;
    }

    @NonNull
    /* renamed from: o */
    public GlideBuilder m45643o(@Nullable MemoryCache memoryCache) {
        this.f13303e = memoryCache;
        return this;
    }

    @NonNull
    /* renamed from: p */
    public GlideBuilder m45642p(@NonNull MemorySizeCalculator.C3604a c3604a) {
        return m45641q(c3604a.m45310a());
    }

    @NonNull
    /* renamed from: q */
    public GlideBuilder m45641q(@Nullable MemorySizeCalculator memorySizeCalculator) {
        this.f13307i = memorySizeCalculator;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public void m45640r(@Nullable RequestManagerRetriever.InterfaceC3740b interfaceC3740b) {
        this.f13311m = interfaceC3740b;
    }

    @Deprecated
    /* renamed from: s */
    public GlideBuilder m45639s(@Nullable GlideExecutor glideExecutor) {
        return m45638t(glideExecutor);
    }

    @NonNull
    /* renamed from: t */
    public GlideBuilder m45638t(@Nullable GlideExecutor glideExecutor) {
        this.f13304f = glideExecutor;
        return this;
    }
}
