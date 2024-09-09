package com.mbridge.msdk.foundation.same.net;

/* compiled from: Response.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f39628a;

    /* renamed from: b  reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.net.a.a f39629b;

    /* renamed from: c  reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.net.e.c f39630c;

    private k(T t3, com.mbridge.msdk.foundation.same.net.e.c cVar) {
        this.f39629b = null;
        this.f39628a = t3;
        this.f39630c = cVar;
    }

    public static <T> k<T> a(T t3, com.mbridge.msdk.foundation.same.net.e.c cVar) {
        return new k<>(t3, cVar);
    }

    public static <T> k<T> a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        return new k<>(aVar);
    }

    private k(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        this.f39628a = null;
        this.f39630c = null;
        this.f39629b = aVar;
    }
}
