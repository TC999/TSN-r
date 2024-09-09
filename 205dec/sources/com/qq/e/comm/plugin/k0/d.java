package com.qq.e.comm.plugin.k0;

import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f44529a;

    public static void a(int i4, Throwable th) {
        int i5;
        if (th instanceof NullPointerException) {
            i5 = 2;
        } else {
            i5 = th instanceof IllegalStateException ? 3 : 1;
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("ot", th.getMessage());
        dVar.a("s_cnt", Integer.valueOf(f44529a));
        v.a(9130034, null, Integer.valueOf(i4), Integer.valueOf(i5), dVar);
    }
}
