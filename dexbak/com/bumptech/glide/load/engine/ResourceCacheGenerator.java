package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.v */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.InterfaceC3562a<Object> {

    /* renamed from: a */
    private final DataFetcherGenerator.InterfaceC3616a f13908a;

    /* renamed from: b */
    private final DecodeHelper<?> f13909b;

    /* renamed from: c */
    private int f13910c;

    /* renamed from: d */
    private int f13911d = -1;

    /* renamed from: e */
    private Key f13912e;

    /* renamed from: f */
    private List<ModelLoader<File, ?>> f13913f;

    /* renamed from: g */
    private int f13914g;

    /* renamed from: h */
    private volatile ModelLoader.C3678a<?> f13915h;

    /* renamed from: i */
    private File f13916i;

    /* renamed from: j */
    private ResourceCacheKey f13917j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC3616a interfaceC3616a) {
        this.f13909b = decodeHelper;
        this.f13908a = interfaceC3616a;
    }

    /* renamed from: a */
    private boolean m45133a() {
        return this.f13914g < this.f13913f.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: b */
    public boolean mo45129b() {
        List<Key> m45280c = this.f13909b.m45280c();
        boolean z = false;
        if (m45280c.isEmpty()) {
            return false;
        }
        List<Class<?>> m45270m = this.f13909b.m45270m();
        if (m45270m.isEmpty()) {
            if (File.class.equals(this.f13909b.m45266q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f13909b.m45274i() + " to " + this.f13909b.m45266q());
        }
        while (true) {
            if (this.f13913f != null && m45133a()) {
                this.f13915h = null;
                while (!z && m45133a()) {
                    List<ModelLoader<File, ?>> list = this.f13913f;
                    int i = this.f13914g;
                    this.f13914g = i + 1;
                    this.f13915h = list.get(i).mo45003b(this.f13916i, this.f13909b.m45264s(), this.f13909b.m45277f(), this.f13909b.m45272k());
                    if (this.f13915h != null && this.f13909b.m45263t(this.f13915h.f14001c.mo45010a())) {
                        this.f13915h.f14001c.mo45008d(this.f13909b.m45271l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f13911d + 1;
            this.f13911d = i2;
            if (i2 >= m45270m.size()) {
                int i3 = this.f13910c + 1;
                this.f13910c = i3;
                if (i3 >= m45280c.size()) {
                    return false;
                }
                this.f13911d = 0;
            }
            Key key = m45280c.get(this.f13910c);
            Class<?> cls = m45270m.get(this.f13911d);
            this.f13917j = new ResourceCacheKey(this.f13909b.m45281b(), key, this.f13909b.m45268o(), this.f13909b.m45264s(), this.f13909b.m45277f(), this.f13909b.m45265r(cls), cls, this.f13909b.m45272k());
            File mo45331b = this.f13909b.m45279d().mo45331b(this.f13917j);
            this.f13916i = mo45331b;
            if (mo45331b != null) {
                this.f13912e = key;
                this.f13913f = this.f13909b.m45273j(mo45331b);
                this.f13914g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
    /* renamed from: c */
    public void mo45052c(@NonNull Exception exc) {
        this.f13908a.mo45130a(this.f13917j, exc, this.f13915h.f14001c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.C3678a<?> c3678a = this.f13915h;
        if (c3678a != null) {
            c3678a.f14001c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
    /* renamed from: e */
    public void mo45051e(Object obj) {
        this.f13908a.mo45127f(this.f13912e, obj, this.f13915h.f14001c, DataSource.RESOURCE_DISK_CACHE, this.f13917j);
    }
}
