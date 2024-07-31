package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.C3770j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: f */
    private static final String f13780f = "DecodePath";

    /* renamed from: a */
    private final Class<DataType> f13781a;

    /* renamed from: b */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f13782b;

    /* renamed from: c */
    private final ResourceTranscoder<ResourceType, Transcode> f13783c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f13784d;

    /* renamed from: e */
    private final String f13785e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodePath.java */
    /* renamed from: com.bumptech.glide.load.engine.i$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3625a<ResourceType> {
        @NonNull
        /* renamed from: a */
        Resource<ResourceType> mo45222a(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.f13781a = cls;
        this.f13782b = list;
        this.f13783c = resourceTranscoder;
        this.f13784d = pool;
        this.f13785e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    /* renamed from: b */
    private Resource<ResourceType> m45224b(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options) throws GlideException {
        List<Throwable> list = (List) C3770j.m44392d(this.f13784d.acquire());
        try {
            return m45223c(dataRewinder, i, i2, options, list);
        } finally {
            this.f13784d.release(list);
        }
    }

    @NonNull
    /* renamed from: c */
    private Resource<ResourceType> m45223c(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.f13782b.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.f13782b.get(i3);
            try {
                if (resourceDecoder.mo2814a(dataRewinder.mo2890a(), options)) {
                    resource = resourceDecoder.mo2813b(dataRewinder.mo2890a(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable(f13780f, 2)) {
                    Log.v(f13780f, "Failed to decode data for " + resourceDecoder, e);
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f13785e, new ArrayList(list));
    }

    /* renamed from: a */
    public Resource<Transcode> m45225a(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, InterfaceC3625a<ResourceType> interfaceC3625a) throws GlideException {
        return this.f13783c.mo44784a(interfaceC3625a.mo45222a(m45224b(dataRewinder, i, i2, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f13781a + ", decoders=" + this.f13782b + ", transcoder=" + this.f13783c + '}';
    }
}
