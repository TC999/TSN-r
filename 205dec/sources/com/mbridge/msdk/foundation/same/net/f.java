package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONObject;

/* compiled from: Listener.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private long f39549a;

    /* renamed from: d  reason: collision with root package name */
    public String f39551d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39552e = "";

    /* renamed from: f  reason: collision with root package name */
    public int f39553f = 0;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.a.a f39550b = null;

    @Override // com.mbridge.msdk.foundation.same.net.e
    public void a() {
        this.f39549a = System.currentTimeMillis();
    }

    @Override // com.mbridge.msdk.foundation.same.net.e
    public void a(long j4, long j5) {
    }

    @Override // com.mbridge.msdk.foundation.same.net.e
    public void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
    }

    @Override // com.mbridge.msdk.foundation.same.net.e
    public void b() {
    }

    public final void b(int i4) {
        com.mbridge.msdk.foundation.same.report.a.a aVar = this.f39550b;
        if (aVar != null) {
            aVar.c(i4);
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.e
    public void c() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.e
    public final void d() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.e
    public final void e() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.e
    public void a(k<T> kVar) {
        try {
            String str = com.mbridge.msdk.foundation.controller.a.f().k() + "_" + this.f39552e + "_" + this.f39551d + "_" + this.f39553f;
            com.mbridge.msdk.c.b.a().d(this.f39551d);
            x.d("Listener", kVar.f39628a + " " + str);
            T t3 = kVar.f39628a;
            if (t3 instanceof JSONObject) {
                com.mbridge.msdk.foundation.same.net.f.c.a().a(str, ((JSONObject) t3).optInt("status"), ((JSONObject) kVar.f39628a).toString(), System.currentTimeMillis());
            }
            if (kVar.f39628a instanceof String) {
                com.mbridge.msdk.foundation.same.net.f.c.a().a(str, new JSONObject((String) kVar.f39628a).optInt("status"), (String) kVar.f39628a, System.currentTimeMillis());
            }
        } catch (Exception e4) {
            x.d("Listener", e4.getMessage());
        }
    }

    public final void a(long j4) {
        com.mbridge.msdk.foundation.same.report.a.a aVar = new com.mbridge.msdk.foundation.same.report.a.a(new com.mbridge.msdk.foundation.entity.j());
        this.f39550b = aVar;
        aVar.b(this.f39551d);
        this.f39550b.a(1);
        com.mbridge.msdk.foundation.same.report.a.a aVar2 = this.f39550b;
        aVar2.a((j4 - this.f39549a) + "");
    }

    public final void a(int i4) {
        com.mbridge.msdk.foundation.same.report.a.a aVar = this.f39550b;
        if (aVar != null) {
            aVar.b(i4);
            this.f39550b.a();
        }
    }
}
