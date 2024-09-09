package com.qq.e.comm.plugin.util;

import java.lang.Comparable;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class i1<T extends Comparable<? super T>> {

    /* renamed from: a  reason: collision with root package name */
    private final T f46486a;

    /* renamed from: b  reason: collision with root package name */
    private final T f46487b;

    public i1(T t3, T t4) {
        this.f46486a = (T) a((Object) t3, (Object) "lower must not be null");
        this.f46487b = (T) a((Object) t4, (Object) "upper must not be null");
        if (t3.compareTo(t4) > 0) {
            throw new IllegalArgumentException("lower must be less than or equal to upper");
        }
    }

    public static <T extends Comparable<? super T>> i1<T> a(T t3, T t4) {
        return new i1<>(t3, t4);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof i1) {
            i1 i1Var = (i1) obj;
            return this.f46486a.equals(i1Var.f46486a) && this.f46487b.equals(i1Var.f46487b);
        }
        return false;
    }

    public String toString() {
        return String.format("[%s, %s]", this.f46486a, this.f46487b);
    }

    public boolean a(T t3) {
        a((Object) t3, (Object) "value must not be null");
        return (t3.compareTo(this.f46486a) >= 0) && (t3.compareTo(this.f46487b) <= 0);
    }

    public static <T> T a(T t3, Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
