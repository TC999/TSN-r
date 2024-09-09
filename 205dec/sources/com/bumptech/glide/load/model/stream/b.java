package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.j;
import com.bumptech.glide.load.model.g;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HttpGlideUrlLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b implements n<g, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f17350b = com.bumptech.glide.load.e.g("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final m<g, g> f17351a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: HttpGlideUrlLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f17352a = new m<>(500);

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<g, InputStream> c(r rVar) {
            return new b(this.f17352a);
        }
    }

    public b() {
        this(null);
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull g gVar, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        m<g, g> mVar = this.f17351a;
        if (mVar != null) {
            g b4 = mVar.b(gVar, 0, 0);
            if (b4 == null) {
                this.f17351a.c(gVar, 0, 0, gVar);
            } else {
                gVar = b4;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) fVar.c(f17350b)).intValue()));
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d */
    public boolean a(@NonNull g gVar) {
        return true;
    }

    public b(@Nullable m<g, g> mVar) {
        this.f17351a = mVar;
    }
}
