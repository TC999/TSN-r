package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.provider.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LoadPathCache {

    /* renamed from: c */
    private static final LoadPath<?, ?, ?> f14315c = new LoadPath<>(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);

    /* renamed from: a */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f14316a = new ArrayMap<>();

    /* renamed from: b */
    private final AtomicReference<MultiClassKey> f14317b = new AtomicReference<>();

    /* renamed from: b */
    private MultiClassKey m44698b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f14317b.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.m44396b(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    /* renamed from: a */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> m44699a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey m44698b = m44698b(cls, cls2, cls3);
        synchronized (this.f14316a) {
            loadPath = (LoadPath<Data, TResource, Transcode>) this.f14316a.get(m44698b);
        }
        this.f14317b.set(m44698b);
        return loadPath;
    }

    /* renamed from: c */
    public boolean m44697c(@Nullable LoadPath<?, ?, ?> loadPath) {
        return f14315c.equals(loadPath);
    }

    /* renamed from: d */
    public void m44696d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f14316a) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f14316a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f14315c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
