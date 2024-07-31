package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.bumptech.glide.util.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MultiClassKey {

    /* renamed from: a */
    private Class<?> f14559a;

    /* renamed from: b */
    private Class<?> f14560b;

    /* renamed from: c */
    private Class<?> f14561c;

    public MultiClassKey() {
    }

    /* renamed from: a */
    public void m44397a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m44396b(cls, cls2, null);
    }

    /* renamed from: b */
    public void m44396b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f14559a = cls;
        this.f14560b = cls2;
        this.f14561c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f14559a.equals(multiClassKey.f14559a) && this.f14560b.equals(multiClassKey.f14560b) && C3771k.m44387d(this.f14561c, multiClassKey.f14561c);
    }

    public int hashCode() {
        int hashCode = ((this.f14559a.hashCode() * 31) + this.f14560b.hashCode()) * 31;
        Class<?> cls = this.f14561c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f14559a + ", second=" + this.f14560b + '}';
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m44397a(cls, cls2);
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        m44396b(cls, cls2, cls3);
    }
}
