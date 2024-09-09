package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.transcode.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LoadPathCache.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final s<?, ?, ?> f17632c = new s<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap<com.bumptech.glide.util.i, s<?, ?, ?>> f17633a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.util.i> f17634b = new AtomicReference<>();

    private com.bumptech.glide.util.i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        com.bumptech.glide.util.i andSet = this.f17634b.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.util.i();
        }
        andSet.b(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVar;
        com.bumptech.glide.util.i b4 = b(cls, cls2, cls3);
        synchronized (this.f17633a) {
            sVar = (s<Data, TResource, Transcode>) this.f17633a.get(b4);
        }
        this.f17634b.set(b4);
        return sVar;
    }

    public boolean c(@Nullable s<?, ?, ?> sVar) {
        return f17632c.equals(sVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable s<?, ?, ?> sVar) {
        synchronized (this.f17633a) {
            ArrayMap<com.bumptech.glide.util.i, s<?, ?, ?>> arrayMap = this.f17633a;
            com.bumptech.glide.util.i iVar = new com.bumptech.glide.util.i(cls, cls2, cls3);
            if (sVar == null) {
                sVar = f17632c;
            }
            arrayMap.put(iVar, sVar);
        }
    }
}
