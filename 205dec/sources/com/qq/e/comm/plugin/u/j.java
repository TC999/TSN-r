package com.qq.e.comm.plugin.u;

import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.b.l;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class j {

    /* renamed from: c  reason: collision with root package name */
    protected final Context f46297c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f46298d;

    /* renamed from: e  reason: collision with root package name */
    protected final ADListener f46299e;

    /* renamed from: g  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.n0.c f46301g = new com.qq.e.comm.plugin.n0.c();

    /* renamed from: f  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.b.g f46300f = a();

    public j(Context context, String str, String str2, l lVar, ADListener aDListener) {
        this.f46297c = context;
        this.f46298d = str2;
        this.f46299e = aDListener;
        this.f46301g.c(this.f46298d);
        this.f46301g.a(this.f46300f);
    }

    protected abstract com.qq.e.comm.plugin.b.g a();
}
