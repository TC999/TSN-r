package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.C3770j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<Data> f13899a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f13900b;

    /* renamed from: c */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f13901c;

    /* renamed from: d */
    private final String f13902d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f13899a = cls;
        this.f13900b = pool;
        this.f13901c = (List) C3770j.m44393c(list);
        this.f13902d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: c */
    private Resource<Transcode> m45139c(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodePath.InterfaceC3625a<ResourceType> interfaceC3625a, List<Throwable> list) throws GlideException {
        int size = this.f13901c.size();
        Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = this.f13901c.get(i3).m45225a(dataRewinder, i, i2, options, interfaceC3625a);
            } catch (GlideException e) {
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f13902d, new ArrayList(list));
    }

    /* renamed from: a */
    public Class<Data> m45141a() {
        return this.f13899a;
    }

    /* renamed from: b */
    public Resource<Transcode> m45140b(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodePath.InterfaceC3625a<ResourceType> interfaceC3625a) throws GlideException {
        List<Throwable> list = (List) C3770j.m44392d(this.f13900b.acquire());
        try {
            return m45139c(dataRewinder, options, i, i2, interfaceC3625a, list);
        } finally {
            this.f13900b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f13901c.toArray()) + '}';
    }
}
