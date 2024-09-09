package com.qq.e.comm.plugin.e0.d;

import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {
    public static void a(int i4, long j4, com.qq.e.comm.plugin.n0.c cVar) {
        h hVar = new h(a(i4));
        hVar.a(cVar);
        hVar.b(System.currentTimeMillis() - j4);
        v.a(hVar);
    }

    public static void a(long j4, com.qq.e.comm.plugin.n0.c cVar) {
        h hVar = new h(a(999));
        hVar.a(cVar);
        hVar.b(System.currentTimeMillis() - j4);
        v.a(hVar);
    }

    private static int a(int i4) {
        int i5 = 2303000 + i4;
        d1.a("generate id, adnId %d, result: %d", Integer.valueOf(i4), Integer.valueOf(i5));
        return i5;
    }

    public static void a(String str) {
        v.a(1232002, new com.qq.e.comm.plugin.n0.c().c(str));
    }

    public static void a(int i4, String str) {
        v.b(1232001, new com.qq.e.comm.plugin.n0.c().c(str), Integer.valueOf(i4));
    }
}
