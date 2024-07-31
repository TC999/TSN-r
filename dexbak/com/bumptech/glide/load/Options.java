package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Options implements Key {

    /* renamed from: c */
    private final ArrayMap<Option<?>, Object> f13938c = new CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    private static <T> void m45121f(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.f13938c.size(); i++) {
            m45121f(this.f13938c.keyAt(i), this.f13938c.valueAt(i), messageDigest);
        }
    }

    @Nullable
    /* renamed from: c */
    public <T> T m45124c(@NonNull Option<T> option) {
        return this.f13938c.containsKey(option) ? (T) this.f13938c.get(option) : option.m45434d();
    }

    /* renamed from: d */
    public void m45123d(@NonNull Options options) {
        this.f13938c.putAll((SimpleArrayMap<? extends Option<?>, ? extends Object>) options.f13938c);
    }

    @NonNull
    /* renamed from: e */
    public <T> Options m45122e(@NonNull Option<T> option, @NonNull T t) {
        this.f13938c.put(option, t);
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f13938c.equals(((Options) obj).f13938c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f13938c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f13938c + '}';
    }
}
