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
/* renamed from: com.bumptech.glide.load.engine.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.InterfaceC3562a<Object> {

    /* renamed from: a */
    private final List<Key> f13614a;

    /* renamed from: b */
    private final DecodeHelper<?> f13615b;

    /* renamed from: c */
    private final DataFetcherGenerator.InterfaceC3616a f13616c;

    /* renamed from: d */
    private int f13617d;

    /* renamed from: e */
    private Key f13618e;

    /* renamed from: f */
    private List<ModelLoader<File, ?>> f13619f;

    /* renamed from: g */
    private int f13620g;

    /* renamed from: h */
    private volatile ModelLoader.C3678a<?> f13621h;

    /* renamed from: i */
    private File f13622i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC3616a interfaceC3616a) {
        this(decodeHelper.m45280c(), decodeHelper, interfaceC3616a);
    }

    /* renamed from: a */
    private boolean m45337a() {
        return this.f13620g < this.f13619f.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    /* renamed from: b */
    public boolean mo45129b() {
        while (true) {
            boolean z = false;
            if (this.f13619f != null && m45337a()) {
                this.f13621h = null;
                while (!z && m45337a()) {
                    List<ModelLoader<File, ?>> list = this.f13619f;
                    int i = this.f13620g;
                    this.f13620g = i + 1;
                    this.f13621h = list.get(i).mo45003b(this.f13622i, this.f13615b.m45264s(), this.f13615b.m45277f(), this.f13615b.m45272k());
                    if (this.f13621h != null && this.f13615b.m45263t(this.f13621h.f14001c.mo45010a())) {
                        this.f13621h.f14001c.mo45008d(this.f13615b.m45271l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f13617d + 1;
            this.f13617d = i2;
            if (i2 >= this.f13614a.size()) {
                return false;
            }
            Key key = this.f13614a.get(this.f13617d);
            File mo45331b = this.f13615b.m45279d().mo45331b(new DataCacheKey(key, this.f13615b.m45268o()));
            this.f13622i = mo45331b;
            if (mo45331b != null) {
                this.f13618e = key;
                this.f13619f = this.f13615b.m45273j(mo45331b);
                this.f13620g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
    /* renamed from: c */
    public void mo45052c(@NonNull Exception exc) {
        this.f13616c.mo45130a(this.f13618e, exc, this.f13621h.f14001c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.C3678a<?> c3678a = this.f13621h;
        if (c3678a != null) {
            c3678a.f14001c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
    /* renamed from: e */
    public void mo45051e(Object obj) {
        this.f13616c.mo45127f(this.f13618e, obj, this.f13621h.f14001c, DataSource.DATA_DISK_CACHE, this.f13618e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.InterfaceC3616a interfaceC3616a) {
        this.f13617d = -1;
        this.f13614a = list;
        this.f13615b = decodeHelper;
        this.f13616c = interfaceC3616a;
    }
}
