package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LoadPath.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class s<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f17216a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17217b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f17218c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17219d;

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f17216a = cls;
        this.f17217b = pool;
        this.f17218c = (List) com.bumptech.glide.util.j.c(list);
        this.f17219d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<Transcode> c(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.f fVar, int i4, int i5, i.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f17218c.size();
        u<Transcode> uVar = null;
        for (int i6 = 0; i6 < size; i6++) {
            try {
                uVar = this.f17218c.get(i6).a(eVar, i4, i5, fVar, aVar);
            } catch (GlideException e4) {
                list.add(e4);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f17219d, new ArrayList(list));
    }

    public Class<Data> a() {
        return this.f17216a;
    }

    public u<Transcode> b(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.f fVar, int i4, int i5, i.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) com.bumptech.glide.util.j.d(this.f17217b.acquire());
        try {
            return c(eVar, fVar, i4, i5, aVar, list);
        } finally {
            this.f17217b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f17218c.toArray()) + '}';
    }
}
