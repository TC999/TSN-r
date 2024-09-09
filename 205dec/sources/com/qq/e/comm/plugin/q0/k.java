package com.qq.e.comm.plugin.q0;

import android.content.Context;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f45476a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f45477b;

    /* renamed from: c  reason: collision with root package name */
    private String f45478c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f45479d;

    public k(Context context, String str, boolean z3) {
        this.f45476a = context;
        this.f45477b = z3;
        this.f45478c = str;
    }

    public static boolean b() {
        return false;
    }

    public k a(com.qq.e.comm.plugin.g0.e eVar) {
        this.f45479d = eVar;
        return this;
    }

    public h a() {
        c cVar = new c(this.f45476a, this.f45478c, this.f45477b);
        cVar.a(this.f45479d);
        return cVar;
    }
}
