package com.qq.e.comm.plugin.u;

import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.w;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    static {
        new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401000, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401002, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1210022, cVar);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        v.a(1404000, cVar, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        v.b(1401001, cVar, Integer.valueOf(i4));
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.d(cVar, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i4, com.qq.e.comm.plugin.n0.c cVar) {
        if (i4 == 200) {
            v.a(1210014, cVar);
            return;
        }
        v.a(1210015, cVar);
        switch (i4) {
            case 202:
                v.a(1210016, cVar);
                return;
            case 203:
                v.a(1210017, cVar);
                return;
            case 204:
                v.a(1210018, cVar);
                return;
            case 205:
                v.a(1210019, cVar);
                return;
            case 206:
                v.a(1210020, cVar);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, int i4, long j4, long j5) {
        v.a(1130112, cVar, null, null, new com.qq.e.comm.plugin.n0.d().a("progress", Integer.valueOf(i4)).a("finished", Long.valueOf(j4)).a("total", Long.valueOf(j5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.c(cVar, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, long j4, long j5) {
        v.a(1130113, cVar, null, null, new com.qq.e.comm.plugin.n0.d().a("progress", Integer.valueOf(i4)).a("finished", Long.valueOf(j4)).a("total", Long.valueOf(j5)));
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.b(cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5) {
        w.a(cVar, j4, j5);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, int i5) {
        v.a(1401006, cVar, Integer.valueOf(i4), Integer.valueOf(i5), null);
    }
}
