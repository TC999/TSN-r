package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EngineKey.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class n implements com.bumptech.glide.load.c {

    /* renamed from: c  reason: collision with root package name */
    private final Object f17166c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17167d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17168e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f17169f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f17170g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.load.c f17171h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.i<?>> f17172i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bumptech.glide.load.f f17173j;

    /* renamed from: k  reason: collision with root package name */
    private int f17174k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Object obj, com.bumptech.glide.load.c cVar, int i4, int i5, Map<Class<?>, com.bumptech.glide.load.i<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.f fVar) {
        this.f17166c = com.bumptech.glide.util.j.d(obj);
        this.f17171h = (com.bumptech.glide.load.c) com.bumptech.glide.util.j.e(cVar, "Signature must not be null");
        this.f17167d = i4;
        this.f17168e = i5;
        this.f17172i = (Map) com.bumptech.glide.util.j.d(map);
        this.f17169f = (Class) com.bumptech.glide.util.j.e(cls, "Resource class must not be null");
        this.f17170g = (Class) com.bumptech.glide.util.j.e(cls2, "Transcode class must not be null");
        this.f17173j = (com.bumptech.glide.load.f) com.bumptech.glide.util.j.d(fVar);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            return this.f17166c.equals(nVar.f17166c) && this.f17171h.equals(nVar.f17171h) && this.f17168e == nVar.f17168e && this.f17167d == nVar.f17167d && this.f17172i.equals(nVar.f17172i) && this.f17169f.equals(nVar.f17169f) && this.f17170g.equals(nVar.f17170g) && this.f17173j.equals(nVar.f17173j);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f17174k == 0) {
            int hashCode = this.f17166c.hashCode();
            this.f17174k = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f17171h.hashCode()) * 31) + this.f17167d) * 31) + this.f17168e;
            this.f17174k = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f17172i.hashCode();
            this.f17174k = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f17169f.hashCode();
            this.f17174k = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f17170g.hashCode();
            this.f17174k = hashCode5;
            this.f17174k = (hashCode5 * 31) + this.f17173j.hashCode();
        }
        return this.f17174k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f17166c + ", width=" + this.f17167d + ", height=" + this.f17168e + ", resourceClass=" + this.f17169f + ", transcodeClass=" + this.f17170g + ", signature=" + this.f17171h + ", hashCode=" + this.f17174k + ", transformations=" + this.f17172i + ", options=" + this.f17173j + '}';
    }
}
