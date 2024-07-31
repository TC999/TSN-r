package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;

/* compiled from: Response.java */
/* renamed from: com.mbridge.msdk.foundation.same.net.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11356k<T> {

    /* renamed from: a */
    public T f30855a;

    /* renamed from: b */
    public CommonError f30856b;

    /* renamed from: c */
    public NetworkResponse f30857c;

    private C11356k(T t, NetworkResponse networkResponse) {
        this.f30856b = null;
        this.f30855a = t;
        this.f30857c = networkResponse;
    }

    /* renamed from: a */
    public static <T> C11356k<T> m22175a(T t, NetworkResponse networkResponse) {
        return new C11356k<>(t, networkResponse);
    }

    /* renamed from: a */
    public static <T> C11356k<T> m22176a(CommonError commonError) {
        return new C11356k<>(commonError);
    }

    private C11356k(CommonError commonError) {
        this.f30855a = null;
        this.f30857c = null;
        this.f30856b = commonError;
    }
}
