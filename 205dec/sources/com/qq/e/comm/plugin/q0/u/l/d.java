package com.qq.e.comm.plugin.q0.u.l;

import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.f;
import com.qq.e.comm.plugin.q0.u.j;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends j {

    /* renamed from: a  reason: collision with root package name */
    private String f45650a;

    /* renamed from: b  reason: collision with root package name */
    private int f45651b;

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f45652c;

    public d(e eVar) {
        if (eVar != null) {
            if (eVar.T0() != null) {
                this.f45650a = eVar.T0().f43589a;
            }
            this.f45651b = eVar.G();
            this.f45652c = com.qq.e.comm.plugin.n0.c.a(eVar);
        }
    }

    @Override // com.qq.e.comm.plugin.q0.u.j
    public f<String> a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        char c4;
        String a4 = dVar.a();
        int hashCode = a4.hashCode();
        if (hashCode == -1748133766) {
            if (a4.equals("launchMiniProgram")) {
                c4 = 2;
            }
            c4 = '\uffff';
        } else if (hashCode != -1086481308) {
            if (hashCode == -922762465 && a4.equals("updateTimelineShareData")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else {
            if (a4.equals("preloadMiniProgram")) {
                c4 = 1;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            new c(this.f45650a).a(hVar, dVar);
        } else if (c4 == 1) {
            new b(this.f45650a, this.f45651b, this.f45652c).a(hVar, dVar);
        } else if (c4 == 2) {
            new a(this.f45650a, this.f45651b, this.f45652c).a(hVar, dVar);
        }
        return new f<>(null);
    }

    public String a() {
        return "wx";
    }
}
