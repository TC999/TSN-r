package com.qq.e.comm.plugin.d.g;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    public static void a(Thread thread, Throwable th) {
        b bVar = new b(thread, th);
        d[] dVarArr = {new a(), new e(), new f()};
        for (int i4 = 0; i4 < 3 && !dVarArr[i4].a(bVar); i4++) {
        }
    }

    public static void a() {
        com.qq.e.comm.plugin.d.b.a().postDelayed(new g(), com.qq.e.comm.plugin.d.a.d());
    }
}
