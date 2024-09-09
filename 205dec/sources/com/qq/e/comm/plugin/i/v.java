package com.qq.e.comm.plugin.i;

import android.content.Intent;
import com.qq.e.comm.plugin.util.p;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class v implements o {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d0.b f44207a;

    /* renamed from: b  reason: collision with root package name */
    private b f44208b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements p.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f44209a;

        a(long j4) {
            this.f44209a = j4;
        }

        @Override // com.qq.e.comm.plugin.util.p.i
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            return true;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            v.a(v.this).a(System.currentTimeMillis() - this.f44209a);
            com.qq.e.comm.plugin.n0.v.a(4008011, v.a(v.this));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends com.qq.e.comm.plugin.n0.c {
        b(com.qq.e.comm.plugin.n0.c cVar) {
            super(cVar);
            a("deeplink_scene", (Object) 1);
        }

        public void a(long j4) {
            a("cost_time", Long.valueOf(j4));
        }
    }

    static /* synthetic */ b a(v vVar) {
        return (b) pro.getobjresult(440, 1, vVar);
    }

    private boolean a(h hVar, Intent intent) {
        return pro.getZresult(441, 0, this, hVar, intent);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(442, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(443, 0, this, hVar, bVar);
    }
}
