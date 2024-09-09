package com.qq.e.comm.plugin.e.l;

import android.view.View;
import com.qq.e.comm.plugin.e.i.f;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.e.i.a f42765b;

    /* renamed from: c  reason: collision with root package name */
    private final View f42766c;

    public b(com.qq.e.comm.plugin.e.i.a aVar, View view) {
        this.f42765b = aVar;
        this.f42766c = view;
    }

    @Override // com.qq.e.comm.plugin.e.l.a, com.qq.e.comm.plugin.e.l.d
    public String a(int i4) {
        return (this.f42765b == null || this.f42766c == null) ? "" : super.a(i4);
    }

    @Override // com.qq.e.comm.plugin.e.l.a
    protected com.qq.e.comm.plugin.e.c b(int i4) {
        com.qq.e.comm.plugin.g0.e g4 = this.f42765b.g();
        return new com.qq.e.comm.plugin.e.i.c(g4.q0(), new com.qq.e.comm.plugin.e.i.e(this.f42766c.getContext(), new com.qq.e.comm.plugin.e.i.b(this.f42766c.getContext(), new f(this.f42766c, g4, this.f42765b, i4)))).a();
    }

    @Override // com.qq.e.comm.plugin.e.l.a
    protected com.qq.e.comm.plugin.e.c a() {
        com.qq.e.comm.plugin.e.i.a aVar = this.f42765b;
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }
}
