package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Options.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class f implements c {

    /* renamed from: c  reason: collision with root package name */
    private final ArrayMap<e<?>, Object> f17255c = new CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(@NonNull e<T> eVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        eVar.update(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        for (int i4 = 0; i4 < this.f17255c.size(); i4++) {
            f(this.f17255c.keyAt(i4), this.f17255c.valueAt(i4), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull e<T> eVar) {
        return this.f17255c.containsKey(eVar) ? (T) this.f17255c.get(eVar) : eVar.d();
    }

    public void d(@NonNull f fVar) {
        this.f17255c.putAll((SimpleArrayMap<? extends e<?>, ? extends Object>) fVar.f17255c);
    }

    @NonNull
    public <T> f e(@NonNull e<T> eVar, @NonNull T t3) {
        this.f17255c.put(eVar, t3);
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f17255c.equals(((f) obj).f17255c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f17255c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f17255c + '}';
    }
}
