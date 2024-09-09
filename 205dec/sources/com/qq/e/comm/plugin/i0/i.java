package com.qq.e.comm.plugin.i0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.l0.c;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends j {

    /* renamed from: a  reason: collision with root package name */
    private final c.a f44232a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f44233b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f44234c;

    public i(c.a aVar, com.qq.e.comm.plugin.g0.e eVar) {
        this.f44232a = aVar;
        this.f44233b = com.qq.e.comm.plugin.n0.c.a(eVar);
        this.f44234c = eVar;
    }

    @Override // com.qq.e.comm.plugin.i0.b
    public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
        String str;
        int statusCode = gVar == null ? 0 : gVar.getStatusCode();
        if (statusCode != 200 && statusCode != 204) {
            com.qq.e.comm.plugin.l0.h.b.b(this.f44234c, fVar.getUrl(), fVar.f(), statusCode);
            c.a aVar = this.f44232a;
            if (aVar != null) {
                aVar.a(statusCode, null);
            }
            d1.a("\u66dd\u5149\u5931\u8d25");
            a(statusCode, (Exception) null);
        } else {
            c.a aVar2 = this.f44232a;
            if (aVar2 != null) {
                aVar2.a();
            }
            d1.a("\u66dd\u5149\u6210\u529f", new Object[0]);
            String E = this.f44234c.E();
            if (!TextUtils.isEmpty(E)) {
                a1.a(E);
            }
            com.qq.e.comm.plugin.l0.h.b.i();
            a();
        }
        if (statusCode != 200) {
            str = statusCode != 204 ? "res == null,no errorMessage" : "http code 204,no content";
        } else {
            try {
                str = gVar.b();
            } catch (Exception e4) {
                d1.a(e4.toString(), new Object[0]);
                str = "";
            }
        }
        f2.a("#exposureRes#", str, new Object[0]);
    }

    private void a() {
        this.f44234c.n1();
        v.a(1402001, this.f44233b);
    }

    private void a(int i4, Exception exc) {
        this.f44234c.b(i4);
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (exc != null) {
            dVar.a("msg", exc.getMessage());
        }
        v.b(1402002, this.f44233b, Integer.valueOf(i4), dVar);
    }

    @Override // com.qq.e.comm.plugin.i0.j
    public void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc) {
        com.qq.e.comm.plugin.l0.h.b.b(this.f44234c, fVar.getUrl(), fVar.f(), i4);
        a(i4, exc);
        c.a aVar = this.f44232a;
        if (aVar == null) {
            return;
        }
        aVar.a(i4, exc);
        f2.a("#exposureRes#", exc, new Object[0]);
    }
}
