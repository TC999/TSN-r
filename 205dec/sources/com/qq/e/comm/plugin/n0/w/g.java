package com.qq.e.comm.plugin.n0.w;

import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class a extends com.qq.e.comm.plugin.n0.c {
        public a(com.qq.e.comm.plugin.n0.c cVar) {
            super(cVar);
            a("wx_sdk_method", (Object) 3);
        }
    }

    public static void a(int i4, com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar != null) {
            int i5 = 0;
            if (!eVar.m1()) {
                if (com.qq.e.comm.plugin.util.c.e(eVar)) {
                    i5 = 2;
                } else if (com.qq.e.comm.plugin.util.c.f(eVar)) {
                    i5 = 1;
                }
            }
            v.a(i4, new a(cVar), Integer.valueOf(i5), null);
        }
    }
}
