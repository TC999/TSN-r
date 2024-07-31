package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.provider.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ModelToResourceClassCache {

    /* renamed from: a */
    private final AtomicReference<MultiClassKey> f14318a = new AtomicReference<>();

    /* renamed from: b */
    private final ArrayMap<MultiClassKey, List<Class<?>>> f14319b = new ArrayMap<>();

    /* renamed from: a */
    public void m44695a() {
        synchronized (this.f14319b) {
            this.f14319b.clear();
        }
    }

    @Nullable
    /* renamed from: b */
    public List<Class<?>> m44694b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey andSet = this.f14318a.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.m44396b(cls, cls2, cls3);
        }
        synchronized (this.f14319b) {
            list = this.f14319b.get(andSet);
        }
        this.f14318a.set(andSet);
        return list;
    }

    /* renamed from: c */
    public void m44693c(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f14319b) {
            this.f14319b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
