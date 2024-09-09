package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceCacheKey.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class w implements com.bumptech.glide.load.c {

    /* renamed from: k  reason: collision with root package name */
    private static final com.bumptech.glide.util.g<Class<?>, byte[]> f17235k = new com.bumptech.glide.util.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f17236c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.c f17237d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.c f17238e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17239f;

    /* renamed from: g  reason: collision with root package name */
    private final int f17240g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f17241h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.load.f f17242i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bumptech.glide.load.i<?> f17243j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(com.bumptech.glide.load.engine.bitmap_recycle.b bVar, com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2, int i4, int i5, com.bumptech.glide.load.i<?> iVar, Class<?> cls, com.bumptech.glide.load.f fVar) {
        this.f17236c = bVar;
        this.f17237d = cVar;
        this.f17238e = cVar2;
        this.f17239f = i4;
        this.f17240g = i5;
        this.f17243j = iVar;
        this.f17241h = cls;
        this.f17242i = fVar;
    }

    private byte[] c() {
        com.bumptech.glide.util.g<Class<?>, byte[]> gVar = f17235k;
        byte[] i4 = gVar.i(this.f17241h);
        if (i4 == null) {
            byte[] bytes = this.f17241h.getName().getBytes(com.bumptech.glide.load.c.f16793b);
            gVar.m(this.f17241h, bytes);
            return bytes;
        }
        return i4;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f17236c.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f17239f).putInt(this.f17240g).array();
        this.f17238e.b(messageDigest);
        this.f17237d.b(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.i<?> iVar = this.f17243j;
        if (iVar != null) {
            iVar.b(messageDigest);
        }
        this.f17242i.b(messageDigest);
        messageDigest.update(c());
        this.f17236c.put(bArr);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            return this.f17240g == wVar.f17240g && this.f17239f == wVar.f17239f && com.bumptech.glide.util.k.d(this.f17243j, wVar.f17243j) && this.f17241h.equals(wVar.f17241h) && this.f17237d.equals(wVar.f17237d) && this.f17238e.equals(wVar.f17238e) && this.f17242i.equals(wVar.f17242i);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f17237d.hashCode() * 31) + this.f17238e.hashCode()) * 31) + this.f17239f) * 31) + this.f17240g;
        com.bumptech.glide.load.i<?> iVar = this.f17243j;
        if (iVar != null) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return (((hashCode * 31) + this.f17241h.hashCode()) * 31) + this.f17242i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f17237d + ", signature=" + this.f17238e + ", width=" + this.f17239f + ", height=" + this.f17240g + ", decodedResourceClass=" + this.f17241h + ", transformation='" + this.f17243j + "', options=" + this.f17242i + '}';
    }
}
