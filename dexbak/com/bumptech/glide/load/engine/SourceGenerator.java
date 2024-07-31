package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.y */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SourceGenerator implements DataFetcherGenerator, DataFetcher.InterfaceC3562a<Object>, DataFetcherGenerator.InterfaceC3616a {

    /* renamed from: h */
    private static final String f13930h = "SourceGenerator";

    /* renamed from: a */
    private final DecodeHelper<?> f13931a;

    /* renamed from: b */
    private final DataFetcherGenerator.InterfaceC3616a f13932b;

    /* renamed from: c */
    private int f13933c;

    /* renamed from: d */
    private DataCacheGenerator f13934d;

    /* renamed from: e */
    private Object f13935e;

    /* renamed from: f */
    private volatile ModelLoader.C3678a<?> f13936f;

    /* renamed from: g */
    private DataCacheKey f13937g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC3616a interfaceC3616a) {
        this.f13931a = decodeHelper;
        this.f13932b = interfaceC3616a;
    }

    /* renamed from: g */
    private void m45126g(Object obj) {
        long m44411b = LogTime.m44411b();
        try {
            Encoder<X> m45267p = this.f13931a.m45267p(obj);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(m45267p, obj, this.f13931a.m45272k());
            this.f13937g = new DataCacheKey(this.f13936f.f13999a, this.f13931a.m45268o());
            this.f13931a.m45279d().mo45332a(this.f13937g, dataCacheWriter);
            if (Log.isLoggable(f13930h, 2)) {
                Log.v(f13930h, "Finished encoding source to cache, key: " + this.f13937g + ", data: " + obj + ", encoder: " + m45267p + ", duration: " + LogTime.m44412a(m44411b));
            }
            this.f13936f.f14001c.mo45009b();
            this.f13934d = new DataCacheGenerator(Collections.singletonList(this.f13936f.f13999a), this.f13931a, this);
        } catch (Throwable th) {
            this.f13936f.f14001c.mo45009b();
            throw th;
        }
    }

    /* renamed from: h */
    private boolean m45125h() {
        return this.f13933c < this.f13931a.m45276g().size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC3616a
    /* renamed from: a */
    public void mo45130a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f13932b.mo45130a(key, exc, dataFetcher, this.f13936f.f14001c.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: b */
    public boolean mo45129b() {
        Object obj = this.f13935e;
        if (obj != null) {
            this.f13935e = null;
            m45126g(obj);
        }
        DataCacheGenerator dataCacheGenerator = this.f13934d;
        if (dataCacheGenerator == null || !dataCacheGenerator.mo45129b()) {
            this.f13934d = null;
            this.f13936f = null;
            boolean z = false;
            while (!z && m45125h()) {
                List<ModelLoader.C3678a<?>> m45276g = this.f13931a.m45276g();
                int i = this.f13933c;
                this.f13933c = i + 1;
                this.f13936f = m45276g.get(i);
                if (this.f13936f != null && (this.f13931a.m45278e().mo45219c(this.f13936f.f14001c.getDataSource()) || this.f13931a.m45263t(this.f13936f.f14001c.mo45010a()))) {
                    this.f13936f.f14001c.mo45008d(this.f13931a.m45271l(), this);
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
    /* renamed from: c */
    public void mo45052c(@NonNull Exception exc) {
        this.f13932b.mo45130a(this.f13937g, exc, this.f13936f.f14001c, this.f13936f.f14001c.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.C3678a<?> c3678a = this.f13936f;
        if (c3678a != null) {
            c3678a.f14001c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC3616a
    /* renamed from: d */
    public void mo45128d() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
    /* renamed from: e */
    public void mo45051e(Object obj) {
        DiskCacheStrategy m45278e = this.f13931a.m45278e();
        if (obj != null && m45278e.mo45219c(this.f13936f.f14001c.getDataSource())) {
            this.f13935e = obj;
            this.f13932b.mo45128d();
            return;
        }
        this.f13932b.mo45127f(this.f13936f.f13999a, obj, this.f13936f.f14001c, this.f13936f.f14001c.getDataSource(), this.f13937g);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.InterfaceC3616a
    /* renamed from: f */
    public void mo45127f(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f13932b.mo45127f(key, obj, dataFetcher, this.f13936f.f14001c.getDataSource(), key);
    }
}
