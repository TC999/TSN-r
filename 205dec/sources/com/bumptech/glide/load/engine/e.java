package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.cache.a;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataCacheWriter.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class e<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.a<DataType> f17004a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f17005b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.f f17006c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, com.bumptech.glide.load.f fVar) {
        this.f17004a = aVar;
        this.f17005b = datatype;
        this.f17006c = fVar;
    }

    @Override // com.bumptech.glide.load.engine.cache.a.b
    public boolean a(@NonNull File file) {
        return this.f17004a.a(this.f17005b, file, this.f17006c);
    }
}
