package com.qq.e.comm.plugin.fs.e;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {
    public static long a(long j4, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        return a(j4, aVar.c());
    }

    public static long a(long j4, int i4) {
        return i4 <= 0 ? j4 : Math.min(j4, i4 * 1000);
    }

    public static boolean a(long j4, long j5, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        return aVar.c() > 0 && j4 >= j5;
    }
}
