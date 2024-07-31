package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class DecodeJob<R> implements DataFetcherGenerator.InterfaceC3616a, Runnable, Comparable<DecodeJob<?>>, FactoryPools.InterfaceC3779f {

    /* renamed from: F */
    private static final String f13726F = "DecodeJob";

    /* renamed from: A */
    private DataSource f13727A;

    /* renamed from: B */
    private DataFetcher<?> f13728B;

    /* renamed from: C */
    private volatile DataFetcherGenerator f13729C;

    /* renamed from: D */
    private volatile boolean f13730D;

    /* renamed from: E */
    private volatile boolean f13731E;

    /* renamed from: d */
    private final InterfaceC3621e f13735d;

    /* renamed from: e */
    private final Pools.Pool<DecodeJob<?>> f13736e;

    /* renamed from: h */
    private GlideContext f13739h;

    /* renamed from: i */
    private Key f13740i;

    /* renamed from: j */
    private Priority f13741j;

    /* renamed from: k */
    private EngineKey f13742k;

    /* renamed from: l */
    private int f13743l;

    /* renamed from: m */
    private int f13744m;

    /* renamed from: n */
    private DiskCacheStrategy f13745n;

    /* renamed from: o */
    private Options f13746o;

    /* renamed from: p */
    private InterfaceC3618b<R> f13747p;

    /* renamed from: q */
    private int f13748q;

    /* renamed from: r */
    private EnumC3624h f13749r;

    /* renamed from: s */
    private EnumC3623g f13750s;

    /* renamed from: t */
    private long f13751t;

    /* renamed from: u */
    private boolean f13752u;

    /* renamed from: v */
    private Object f13753v;

    /* renamed from: w */
    private Thread f13754w;

    /* renamed from: x */
    private Key f13755x;

    /* renamed from: y */
    private Key f13756y;

    /* renamed from: z */
    private Object f13757z;

    /* renamed from: a */
    private final DecodeHelper<R> f13732a = new DecodeHelper<>();

    /* renamed from: b */
    private final List<Throwable> f13733b = new ArrayList();

    /* renamed from: c */
    private final StateVerifier f13734c = StateVerifier.m44345a();

    /* renamed from: f */
    private final C3620d<?> f13737f = new C3620d<>();

    /* renamed from: g */
    private final C3622f f13738g = new C3622f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C3617a {

        /* renamed from: a */
        static final /* synthetic */ int[] f13758a;

        /* renamed from: b */
        static final /* synthetic */ int[] f13759b;

        /* renamed from: c */
        static final /* synthetic */ int[] f13760c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f13760c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13760c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC3624h.values().length];
            f13759b = iArr2;
            try {
                iArr2[EnumC3624h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13759b[EnumC3624h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13759b[EnumC3624h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13759b[EnumC3624h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13759b[EnumC3624h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[EnumC3623g.values().length];
            f13758a = iArr3;
            try {
                iArr3[EnumC3623g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13758a[EnumC3623g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13758a[EnumC3623g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3618b<R> {
        /* renamed from: b */
        void mo45199b(GlideException glideException);

        /* renamed from: c */
        void mo45198c(Resource<R> resource, DataSource dataSource);

        /* renamed from: d */
        void mo45197d(DecodeJob<?> decodeJob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C3619c<Z> implements DecodePath.InterfaceC3625a<Z> {

        /* renamed from: a */
        private final DataSource f13761a;

        C3619c(DataSource dataSource) {
            this.f13761a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.InterfaceC3625a
        @NonNull
        /* renamed from: a */
        public Resource<Z> mo45222a(@NonNull Resource<Z> resource) {
            return DecodeJob.this.m45240u(this.f13761a, resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3620d<Z> {

        /* renamed from: a */
        private Key f13763a;

        /* renamed from: b */
        private ResourceEncoder<Z> f13764b;

        /* renamed from: c */
        private LockedResource<Z> f13765c;

        C3620d() {
        }

        /* renamed from: a */
        void m45234a() {
            this.f13763a = null;
            this.f13764b = null;
            this.f13765c = null;
        }

        /* renamed from: b */
        void m45233b(InterfaceC3621e interfaceC3621e, Options options) {
            GlideTrace.m44351a("DecodeJob.encode");
            try {
                interfaceC3621e.mo45203a().mo45332a(this.f13763a, new DataCacheWriter(this.f13764b, this.f13765c, options));
            } finally {
                this.f13765c.m45135e();
                GlideTrace.m44347e();
            }
        }

        /* renamed from: c */
        boolean m45232c() {
            return this.f13765c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: d */
        <X> void m45231d(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.f13763a = key;
            this.f13764b = resourceEncoder;
            this.f13765c = lockedResource;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3621e {
        /* renamed from: a */
        DiskCache mo45203a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3622f {

        /* renamed from: a */
        private boolean f13766a;

        /* renamed from: b */
        private boolean f13767b;

        /* renamed from: c */
        private boolean f13768c;

        C3622f() {
        }

        /* renamed from: a */
        private boolean m45230a(boolean z) {
            return (this.f13768c || z || this.f13767b) && this.f13766a;
        }

        /* renamed from: b */
        synchronized boolean m45229b() {
            this.f13767b = true;
            return m45230a(false);
        }

        /* renamed from: c */
        synchronized boolean m45228c() {
            this.f13768c = true;
            return m45230a(false);
        }

        /* renamed from: d */
        synchronized boolean m45227d(boolean z) {
            this.f13766a = true;
            return m45230a(z);
        }

        /* renamed from: e */
        synchronized void m45226e() {
            this.f13767b = false;
            this.f13766a = false;
            this.f13768c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC3623g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC3624h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob(InterfaceC3621e interfaceC3621e, Pools.Pool<DecodeJob<?>> pool) {
        this.f13735d = interfaceC3621e;
        this.f13736e = pool;
    }

    /* renamed from: A */
    private void m45258A() {
        Throwable th;
        this.f13734c.mo44343c();
        if (this.f13730D) {
            if (this.f13733b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f13733b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.f13730D = true;
    }

    /* renamed from: e */
    private <Data> Resource<R> m45254e(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long m44411b = LogTime.m44411b();
            Resource<R> m45253g = m45253g(data, dataSource);
            if (Log.isLoggable(f13726F, 2)) {
                m45247n("Decoded result " + m45253g, m44411b);
            }
            return m45253g;
        } finally {
            dataFetcher.mo45009b();
        }
    }

    /* renamed from: g */
    private <Data> Resource<R> m45253g(Data data, DataSource dataSource) throws GlideException {
        return m45236y(data, dataSource, (LoadPath<Data, ?, R>) this.f13732a.m45275h(data.getClass()));
    }

    private int getPriority() {
        return this.f13741j.ordinal();
    }

    /* renamed from: i */
    private void m45252i() {
        if (Log.isLoggable(f13726F, 2)) {
            long j = this.f13751t;
            m45246o("Retrieved data", j, "data: " + this.f13757z + ", cache key: " + this.f13755x + ", fetcher: " + this.f13728B);
        }
        Resource<R> resource = null;
        try {
            resource = m45254e(this.f13728B, this.f13757z, this.f13727A);
        } catch (GlideException e) {
            e.setLoggingDetails(this.f13756y, this.f13727A);
            this.f13733b.add(e);
        }
        if (resource != null) {
            m45244q(resource, this.f13727A);
        } else {
            m45237x();
        }
    }

    /* renamed from: j */
    private DataFetcherGenerator m45251j() {
        int i = C3617a.f13759b[this.f13749r.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.f13749r);
                }
                return new SourceGenerator(this.f13732a, this);
            }
            return new DataCacheGenerator(this.f13732a, this);
        }
        return new ResourceCacheGenerator(this.f13732a, this);
    }

    /* renamed from: k */
    private EnumC3624h m45250k(EnumC3624h enumC3624h) {
        int i = C3617a.f13759b[enumC3624h.ordinal()];
        if (i == 1) {
            return this.f13745n.mo45221a() ? EnumC3624h.DATA_CACHE : m45250k(EnumC3624h.DATA_CACHE);
        } else if (i == 2) {
            return this.f13752u ? EnumC3624h.FINISHED : EnumC3624h.SOURCE;
        } else if (i == 3 || i == 4) {
            return EnumC3624h.FINISHED;
        } else {
            if (i == 5) {
                return this.f13745n.mo45220b() ? EnumC3624h.RESOURCE_CACHE : m45250k(EnumC3624h.RESOURCE_CACHE);
            }
            throw new IllegalArgumentException("Unrecognized stage: " + enumC3624h);
        }
    }

    @NonNull
    /* renamed from: l */
    private Options m45249l(DataSource dataSource) {
        Options options = this.f13746o;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f13732a.m45260w();
        Option<Boolean> option = Downsampler.f14128j;
        Boolean bool = (Boolean) options.m45124c(option);
        if (bool == null || (bool.booleanValue() && !z)) {
            Options options2 = new Options();
            options2.m45123d(this.f13746o);
            options2.m45122e(option, Boolean.valueOf(z));
            return options2;
        }
        return options;
    }

    /* renamed from: n */
    private void m45247n(String str, long j) {
        m45246o(str, j, null);
    }

    /* renamed from: o */
    private void m45246o(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.m44412a(j));
        sb.append(", load key: ");
        sb.append(this.f13742k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(f13726F, sb.toString());
    }

    /* renamed from: p */
    private void m45245p(Resource<R> resource, DataSource dataSource) {
        m45258A();
        this.f13747p.mo45198c(resource, dataSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: q */
    private void m45244q(Resource<R> resource, DataSource dataSource) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).mo44824a();
        }
        LockedResource lockedResource = 0;
        if (this.f13737f.m45232c()) {
            resource = LockedResource.m45137c(resource);
            lockedResource = resource;
        }
        m45245p(resource, dataSource);
        this.f13749r = EnumC3624h.ENCODE;
        try {
            if (this.f13737f.m45232c()) {
                this.f13737f.m45233b(this.f13735d, this.f13746o);
            }
            m45242s();
        } finally {
            if (lockedResource != 0) {
                lockedResource.m45135e();
            }
        }
    }

    /* renamed from: r */
    private void m45243r() {
        m45258A();
        this.f13747p.mo45199b(new GlideException("Failed to load resource", new ArrayList(this.f13733b)));
        m45241t();
    }

    /* renamed from: s */
    private void m45242s() {
        if (this.f13738g.m45229b()) {
            m45238w();
        }
    }

    /* renamed from: t */
    private void m45241t() {
        if (this.f13738g.m45228c()) {
            m45238w();
        }
    }

    /* renamed from: w */
    private void m45238w() {
        this.f13738g.m45226e();
        this.f13737f.m45234a();
        this.f13732a.m45282a();
        this.f13730D = false;
        this.f13739h = null;
        this.f13740i = null;
        this.f13746o = null;
        this.f13741j = null;
        this.f13742k = null;
        this.f13747p = null;
        this.f13749r = null;
        this.f13729C = null;
        this.f13754w = null;
        this.f13755x = null;
        this.f13757z = null;
        this.f13727A = null;
        this.f13728B = null;
        this.f13751t = 0L;
        this.f13731E = false;
        this.f13753v = null;
        this.f13733b.clear();
        this.f13736e.release(this);
    }

    /* renamed from: x */
    private void m45237x() {
        this.f13754w = Thread.currentThread();
        this.f13751t = LogTime.m44411b();
        boolean z = false;
        while (!this.f13731E && this.f13729C != null && !(z = this.f13729C.mo45129b())) {
            this.f13749r = m45250k(this.f13749r);
            this.f13729C = m45251j();
            if (this.f13749r == EnumC3624h.SOURCE) {
                mo45128d();
                return;
            }
        }
        if ((this.f13749r == EnumC3624h.FINISHED || this.f13731E) && !z) {
            m45243r();
        }
    }

    /* renamed from: y */
    private <Data, ResourceType> Resource<R> m45236y(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options m45249l = m45249l(dataSource);
        DataRewinder<Data> m45774l = this.f13739h.m45630h().m45774l(data);
        try {
            return loadPath.m45140b(m45774l, m45249l, this.f13743l, this.f13744m, new C3619c(dataSource));
        } finally {
            m45774l.mo2889b();
        }
    }

    /* renamed from: z */
    private void m45235z() {
        int i = C3617a.f13758a[this.f13750s.ordinal()];
        if (i == 1) {
            this.f13749r = m45250k(EnumC3624h.INITIALIZE);
            this.f13729C = m45251j();
            m45237x();
        } else if (i == 2) {
            m45237x();
        } else if (i == 3) {
            m45252i();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f13750s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public boolean m45257B() {
        EnumC3624h m45250k = m45250k(EnumC3624h.INITIALIZE);
        return m45250k == EnumC3624h.RESOURCE_CACHE || m45250k == EnumC3624h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC3616a
    /* renamed from: a */
    public void mo45130a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.mo45009b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.mo45010a());
        this.f13733b.add(glideException);
        if (Thread.currentThread() != this.f13754w) {
            this.f13750s = EnumC3623g.SWITCH_TO_SOURCE_SERVICE;
            this.f13747p.mo45197d(this);
            return;
        }
        m45237x();
    }

    /* renamed from: b */
    public void m45256b() {
        this.f13731E = true;
        DataFetcherGenerator dataFetcherGenerator = this.f13729C;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        return priority == 0 ? this.f13748q - decodeJob.f13748q : priority;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC3616a
    /* renamed from: d */
    public void mo45128d() {
        this.f13750s = EnumC3623g.SWITCH_TO_SOURCE_SERVICE;
        this.f13747p.mo45197d(this);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC3616a
    /* renamed from: f */
    public void mo45127f(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f13755x = key;
        this.f13757z = obj;
        this.f13728B = dataFetcher;
        this.f13727A = dataSource;
        this.f13756y = key2;
        if (Thread.currentThread() != this.f13754w) {
            this.f13750s = EnumC3623g.DECODE_DATA;
            this.f13747p.mo45197d(this);
            return;
        }
        GlideTrace.m44351a("DecodeJob.decodeFromRetrievedData");
        try {
            m45252i();
        } finally {
            GlideTrace.m44347e();
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3779f
    @NonNull
    /* renamed from: h */
    public StateVerifier mo44353h() {
        return this.f13734c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public DecodeJob<R> m45248m(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, InterfaceC3618b<R> interfaceC3618b, int i3) {
        this.f13732a.m45262u(glideContext, obj, key, i, i2, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.f13735d);
        this.f13739h = glideContext;
        this.f13740i = key;
        this.f13741j = priority;
        this.f13742k = engineKey;
        this.f13743l = i;
        this.f13744m = i2;
        this.f13745n = diskCacheStrategy;
        this.f13752u = z3;
        this.f13746o = options;
        this.f13747p = interfaceC3618b;
        this.f13748q = i3;
        this.f13750s = EnumC3623g.INITIALIZE;
        this.f13753v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.m44350b("DecodeJob#run(model=%s)", this.f13753v);
        DataFetcher<?> dataFetcher = this.f13728B;
        try {
            try {
                if (this.f13731E) {
                    m45243r();
                    if (dataFetcher != null) {
                        dataFetcher.mo45009b();
                    }
                    GlideTrace.m44347e();
                    return;
                }
                m45235z();
                if (dataFetcher != null) {
                    dataFetcher.mo45009b();
                }
                GlideTrace.m44347e();
            } catch (CallbackException e) {
                throw e;
            }
        }
    }

    @NonNull
    /* renamed from: u */
    <Z> Resource<Z> m45240u(DataSource dataSource, @NonNull Resource<Z> resource) {
        Resource<Z> resource2;
        Transformation<Z> transformation;
        EncodeStrategy encodeStrategy;
        Key dataCacheKey;
        Class<?> cls = resource.get().getClass();
        ResourceEncoder<Z> resourceEncoder = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            Transformation<Z> m45265r = this.f13732a.m45265r(cls);
            transformation = m45265r;
            resource2 = m45265r.mo44823a(this.f13739h, resource, this.f13743l, this.f13744m);
        } else {
            resource2 = resource;
            transformation = null;
        }
        if (!resource.equals(resource2)) {
            resource.recycle();
        }
        if (this.f13732a.m45261v(resource2)) {
            resourceEncoder = this.f13732a.m45269n(resource2);
            encodeStrategy = resourceEncoder.mo44826b(this.f13746o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        ResourceEncoder resourceEncoder2 = resourceEncoder;
        if (this.f13745n.mo45218d(!this.f13732a.m45259x(this.f13755x), dataSource, encodeStrategy)) {
            if (resourceEncoder2 != null) {
                int i = C3617a.f13760c[encodeStrategy.ordinal()];
                if (i == 1) {
                    dataCacheKey = new DataCacheKey(this.f13755x, this.f13740i);
                } else if (i == 2) {
                    dataCacheKey = new ResourceCacheKey(this.f13732a.m45281b(), this.f13755x, this.f13740i, this.f13743l, this.f13744m, transformation, cls, this.f13746o);
                } else {
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                }
                LockedResource m45137c = LockedResource.m45137c(resource2);
                this.f13737f.m45231d(dataCacheKey, resourceEncoder2, m45137c);
                return m45137c;
            }
            throw new Registry.NoResultEncoderAvailableException(resource2.get().getClass());
        }
        return resource2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public void m45239v(boolean z) {
        if (this.f13738g.m45227d(z)) {
            m45238w();
        }
    }
}
