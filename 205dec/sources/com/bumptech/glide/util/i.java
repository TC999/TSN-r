package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MultiClassKey.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f18077a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f18078b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f18079c;

    public i() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        b(cls, cls2, null);
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f18077a = cls;
        this.f18078b = cls2;
        this.f18079c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f18077a.equals(iVar.f18077a) && this.f18078b.equals(iVar.f18078b) && k.d(this.f18079c, iVar.f18079c);
    }

    public int hashCode() {
        int hashCode = ((this.f18077a.hashCode() * 31) + this.f18078b.hashCode()) * 31;
        Class<?> cls = this.f18079c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f18077a + ", second=" + this.f18078b + '}';
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2);
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        b(cls, cls2, cls3);
    }
}
