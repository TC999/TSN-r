package com.qq.e.comm.plugin.i0;

import com.qq.e.comm.plugin.i0.m.a;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements a.InterfaceC0847a {

    /* renamed from: a  reason: collision with root package name */
    private final int f44218a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.i0.m.a> f44219b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.i0.n.f f44220c;

    public a(int i4, List<com.qq.e.comm.plugin.i0.m.a> list, com.qq.e.comm.plugin.i0.n.f fVar) {
        this.f44218a = i4;
        this.f44219b = list;
        this.f44220c = fVar;
    }

    @Override // com.qq.e.comm.plugin.i0.m.a.InterfaceC0847a
    public com.qq.e.comm.plugin.i0.n.f a() {
        return this.f44220c;
    }

    @Override // com.qq.e.comm.plugin.i0.m.a.InterfaceC0847a
    public com.qq.e.comm.plugin.i0.n.g a(com.qq.e.comm.plugin.i0.n.f fVar) throws Exception {
        if (this.f44218a >= this.f44219b.size()) {
            return null;
        }
        return this.f44219b.get(this.f44218a).a(new a(this.f44218a + 1, this.f44219b, fVar));
    }
}
