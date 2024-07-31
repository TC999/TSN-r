package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DecodeHelper<Transcode> {

    /* renamed from: a */
    private final List<ModelLoader.C3678a<?>> f13708a = new ArrayList();

    /* renamed from: b */
    private final List<Key> f13709b = new ArrayList();

    /* renamed from: c */
    private GlideContext f13710c;

    /* renamed from: d */
    private Object f13711d;

    /* renamed from: e */
    private int f13712e;

    /* renamed from: f */
    private int f13713f;

    /* renamed from: g */
    private Class<?> f13714g;

    /* renamed from: h */
    private DecodeJob.InterfaceC3621e f13715h;

    /* renamed from: i */
    private Options f13716i;

    /* renamed from: j */
    private Map<Class<?>, Transformation<?>> f13717j;

    /* renamed from: k */
    private Class<Transcode> f13718k;

    /* renamed from: l */
    private boolean f13719l;

    /* renamed from: m */
    private boolean f13720m;

    /* renamed from: n */
    private Key f13721n;

    /* renamed from: o */
    private Priority f13722o;

    /* renamed from: p */
    private DiskCacheStrategy f13723p;

    /* renamed from: q */
    private boolean f13724q;

    /* renamed from: r */
    private boolean f13725r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m45282a() {
        this.f13710c = null;
        this.f13711d = null;
        this.f13721n = null;
        this.f13714g = null;
        this.f13718k = null;
        this.f13716i = null;
        this.f13722o = null;
        this.f13717j = null;
        this.f13723p = null;
        this.f13708a.clear();
        this.f13719l = false;
        this.f13709b.clear();
        this.f13720m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayPool m45281b() {
        return this.f13710c.m45636b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public List<Key> m45280c() {
        if (!this.f13720m) {
            this.f13720m = true;
            this.f13709b.clear();
            List<ModelLoader.C3678a<?>> m45276g = m45276g();
            int size = m45276g.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.C3678a<?> c3678a = m45276g.get(i);
                if (!this.f13709b.contains(c3678a.f13999a)) {
                    this.f13709b.add(c3678a.f13999a);
                }
                for (int i2 = 0; i2 < c3678a.f14000b.size(); i2++) {
                    if (!this.f13709b.contains(c3678a.f14000b.get(i2))) {
                        this.f13709b.add(c3678a.f14000b.get(i2));
                    }
                }
            }
        }
        return this.f13709b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public DiskCache m45279d() {
        return this.f13715h.mo45203a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public DiskCacheStrategy m45278e() {
        return this.f13723p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public int m45277f() {
        return this.f13713f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public List<ModelLoader.C3678a<?>> m45276g() {
        if (!this.f13719l) {
            this.f13719l = true;
            this.f13708a.clear();
            List m45777i = this.f13710c.m45630h().m45777i(this.f13711d);
            int size = m45777i.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.C3678a<?> mo45003b = ((ModelLoader) m45777i.get(i)).mo45003b(this.f13711d, this.f13712e, this.f13713f, this.f13716i);
                if (mo45003b != null) {
                    this.f13708a.add(mo45003b);
                }
            }
        }
        return this.f13708a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public <Data> LoadPath<Data, ?, Transcode> m45275h(Class<Data> cls) {
        return this.f13710c.m45630h().m45778h(cls, this.f13714g, this.f13718k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public Class<?> m45274i() {
        return this.f13711d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public List<ModelLoader<File, ?>> m45273j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f13710c.m45630h().m45777i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public Options m45272k() {
        return this.f13716i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public Priority m45271l() {
        return this.f13722o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public List<Class<?>> m45270m() {
        return this.f13710c.m45630h().m45776j(this.f13711d.getClass(), this.f13714g, this.f13718k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public <Z> ResourceEncoder<Z> m45269n(Resource<Z> resource) {
        return this.f13710c.m45630h().m45775k(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public Key m45268o() {
        return this.f13721n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public <X> Encoder<X> m45267p(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f13710c.m45630h().m45773m(x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public Class<?> m45266q() {
        return (Class<Transcode>) this.f13718k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public <Z> Transformation<Z> m45265r(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation<Z>) this.f13717j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.f13717j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation<Z>) next.getValue();
                    break;
                }
            }
        }
        if (transformation == null) {
            if (this.f13717j.isEmpty() && this.f13724q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.m44998c();
        }
        return transformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public int m45264s() {
        return this.f13712e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: t */
    public boolean m45263t(Class<?> cls) {
        return m45275h(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    public <R> void m45262u(GlideContext glideContext, Object obj, Key key, int i, int i2, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.InterfaceC3621e interfaceC3621e) {
        this.f13710c = glideContext;
        this.f13711d = obj;
        this.f13721n = key;
        this.f13712e = i;
        this.f13713f = i2;
        this.f13723p = diskCacheStrategy;
        this.f13714g = cls;
        this.f13715h = interfaceC3621e;
        this.f13718k = cls2;
        this.f13722o = priority;
        this.f13716i = options;
        this.f13717j = map;
        this.f13724q = z;
        this.f13725r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public boolean m45261v(Resource<?> resource) {
        return this.f13710c.m45630h().m45772n(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public boolean m45260w() {
        return this.f13725r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public boolean m45259x(Key key) {
        List<ModelLoader.C3678a<?>> m45276g = m45276g();
        int size = m45276g.size();
        for (int i = 0; i < size; i++) {
            if (m45276g.get(i).f13999a.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
