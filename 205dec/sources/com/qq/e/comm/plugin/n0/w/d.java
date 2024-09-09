package com.qq.e.comm.plugin.n0.w;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends com.qq.e.comm.plugin.n0.c {
    public d(com.qq.e.comm.plugin.n0.c cVar) {
        super(cVar);
        a("deeplink_scene", (Object) 1);
    }

    public d a(long j4) {
        a("cost_time", Long.valueOf(j4));
        return this;
    }

    public d b(boolean z3) {
        if (z3) {
            a("deeplink_type", (Object) 3);
        } else {
            a("deeplink_type", (Object) 1);
        }
        return this;
    }
}
