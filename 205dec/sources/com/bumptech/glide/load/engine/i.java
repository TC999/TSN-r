package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DecodePath.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i<DataType, ResourceType, Transcode> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f17097f = "DecodePath";

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f17098a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> f17099b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.transcode.e<ResourceType, Transcode> f17100c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17101d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17102e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DecodePath.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a<ResourceType> {
        @NonNull
        u<ResourceType> a(@NonNull u<ResourceType> uVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.g<DataType, ResourceType>> list, com.bumptech.glide.load.resource.transcode.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f17098a = cls;
        this.f17099b = list;
        this.f17100c = eVar;
        this.f17101d = pool;
        this.f17102e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private u<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) throws GlideException {
        List<Throwable> list = (List) com.bumptech.glide.util.j.d(this.f17101d.acquire());
        try {
            return c(eVar, i4, i5, fVar, list);
        } finally {
            this.f17101d.release(list);
        }
    }

    @NonNull
    private u<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar, List<Throwable> list) throws GlideException {
        int size = this.f17099b.size();
        u<ResourceType> uVar = null;
        for (int i6 = 0; i6 < size; i6++) {
            com.bumptech.glide.load.g<DataType, ResourceType> gVar = this.f17099b.get(i6);
            try {
                if (gVar.a(eVar.a(), fVar)) {
                    uVar = gVar.b(eVar.a(), i4, i5, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e4) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + gVar, e4);
                }
                list.add(e4);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f17102e, new ArrayList(list));
    }

    public u<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar, a<ResourceType> aVar) throws GlideException {
        return this.f17100c.a(aVar.a(b(eVar, i4, i5, fVar)), fVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f17098a + ", decoders=" + this.f17099b + ", transcoder=" + this.f17100c + '}';
    }
}
