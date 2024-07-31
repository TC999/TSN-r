package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class DataCacheWriter<DataType> implements DiskCache.InterfaceC3593b {

    /* renamed from: a */
    private final Encoder<DataType> f13681a;

    /* renamed from: b */
    private final DataType f13682b;

    /* renamed from: c */
    private final Options f13683c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f13681a = encoder;
        this.f13682b = datatype;
        this.f13683c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.InterfaceC3593b
    /* renamed from: a */
    public boolean mo45296a(@NonNull File file) {
        return this.f13681a.mo44827a(this.f13682b, file, this.f13683c);
    }
}
