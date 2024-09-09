package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ModelToResourceClassCache.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<i> f17635a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<i, List<Class<?>>> f17636b = new ArrayMap<>();

    public void a() {
        synchronized (this.f17636b) {
            this.f17636b.clear();
        }
    }

    @Nullable
    public List<Class<?>> b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f17635a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.b(cls, cls2, cls3);
        }
        synchronized (this.f17636b) {
            list = this.f17636b.get(andSet);
        }
        this.f17635a.set(andSet);
        return list;
    }

    public void c(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f17636b) {
            this.f17636b.put(new i(cls, cls2, cls3), list);
        }
    }
}
