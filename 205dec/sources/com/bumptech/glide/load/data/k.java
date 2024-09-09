package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.resource.bitmap.u;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: InputStreamRewinder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class k implements e<InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f16822b = 5242880;

    /* renamed from: a  reason: collision with root package name */
    private final u f16823a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: InputStreamRewinder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.load.engine.bitmap_recycle.b f16824a;

        public a(com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f16824a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        /* renamed from: c */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f16824a);
        }
    }

    k(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        u uVar = new u(inputStream, bVar);
        this.f16823a = uVar;
        uVar.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f16823a.c();
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    /* renamed from: c */
    public InputStream a() throws IOException {
        this.f16823a.reset();
        return this.f16823a;
    }
}
