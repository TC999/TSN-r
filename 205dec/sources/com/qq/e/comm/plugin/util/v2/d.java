package com.qq.e.comm.plugin.util.v2;

import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements c {
    @Override // com.qq.e.comm.plugin.util.v2.c
    public void a(int i4, int i5, int i6) {
        d1.a("NotWorkTrigger", "onPositionUpdate");
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public double b() {
        d1.a("NotWorkTrigger", "getFirstDownloadRatio");
        return 1.0d;
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void c() {
        d1.a("NotWorkTrigger", "traceRewarded");
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public String d() {
        d1.a("NotWorkTrigger", "getDownloadUrlUa");
        return "not_download";
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public boolean e() {
        d1.a("NotWorkTrigger", "isEnable");
        return false;
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void f() {
        d1.a("NotWorkTrigger", "traceError");
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void g() {
        d1.a("NotWorkTrigger", "tracePlay");
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void a(int i4, f.t tVar) {
        d1.a("NotWorkTrigger", "onPositionBlock");
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public com.qq.e.comm.plugin.g0.e a() {
        d1.a("NotWorkTrigger", "getAdInfo");
        return new com.qq.e.comm.plugin.g0.e("", "", "", "", g.UNIFIED_BANNER, new JSONObject(), l.f42027d);
    }

    @Override // com.qq.e.comm.plugin.util.v2.c
    public void a(f fVar) {
        d1.a("NotWorkTrigger", "destroy");
    }
}
