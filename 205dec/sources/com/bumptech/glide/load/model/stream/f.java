package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.g;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import java.io.InputStream;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: UrlLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f17359a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: UrlLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<URL, InputStream> c(r rVar) {
            return new f(rVar.d(g.class, InputStream.class));
        }
    }

    public f(n<g, InputStream> nVar) {
        this.f17359a = nVar;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull URL url, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f17359a.b(new g(url), i4, i5, fVar);
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d */
    public boolean a(@NonNull URL url) {
        return true;
    }
}
