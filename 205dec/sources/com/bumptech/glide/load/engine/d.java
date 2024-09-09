package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataCacheKey.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class d implements com.bumptech.glide.load.c {

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.c f17002c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.c f17003d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2) {
        this.f17002c = cVar;
        this.f17003d = cVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f17002c.b(messageDigest);
        this.f17003d.b(messageDigest);
    }

    com.bumptech.glide.load.c c() {
        return this.f17002c;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f17002c.equals(dVar.f17002c) && this.f17003d.equals(dVar.f17003d);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (this.f17002c.hashCode() * 31) + this.f17003d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f17002c + ", signature=" + this.f17003d + '}';
    }
}
