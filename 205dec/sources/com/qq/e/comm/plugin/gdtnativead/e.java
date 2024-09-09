package com.qq.e.comm.plugin.gdtnativead;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.i0;
import com.qq.e.comm.plugin.util.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.b.g gVar, boolean z3, com.qq.e.comm.plugin.n0.c cVar, int i4, Exception exc) {
        if (gVar == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL) {
            i0.a(gVar, z3, cVar, i4, exc);
        } else if (gVar != com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
        } else {
            if (z3) {
                v.a(1040014, cVar);
                return;
            }
            v.b(1040013, cVar, Integer.valueOf(i4), a(exc, (String) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401000, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401001, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401002, cVar);
    }

    public static void e(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.d(cVar, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("renderTime", Long.valueOf(j4));
        v.a(1404001, cVar, Integer.valueOf(j4 > ((long) com.qq.e.comm.plugin.d0.a.d().f().a("EXPRESS2_RENDER_TIMEOUT", AVMDLDataLoader.KeyIsLiveSetLoaderType)) ? 1 : 0), dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, int i4, long j4, long j5) {
        v.a(1130116, cVar, null, null, new com.qq.e.comm.plugin.n0.d().a("progress", Integer.valueOf(i4)).a("finished", Long.valueOf(j4)).a("total", Long.valueOf(j5)));
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2302003);
        hVar.b(j4);
        hVar.a(cVar);
        v.a(hVar);
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.c(cVar, j4);
    }

    public static void e(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1040022, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.b(cVar, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1404009, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1404000, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (!TextUtils.isEmpty(str)) {
            dVar.a("ot", str);
        }
        v.b(1404002, cVar, Integer.valueOf(i4), dVar);
    }

    private static com.qq.e.comm.plugin.n0.d a(Exception exc, String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (exc != null) {
            dVar.a("ot", exc.getMessage());
        }
        if (str != null) {
            dVar.a("rs", str);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, long j4, long j5) {
        v.a(1130117, cVar, null, null, new com.qq.e.comm.plugin.n0.d().a("progress", Integer.valueOf(i4)).a("finished", Long.valueOf(j4)).a("total", Long.valueOf(j5)));
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.a(cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5) {
        w.a(cVar, j4, j5);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, boolean z3) {
        v.a(1405002, cVar, Integer.valueOf(!z3 ? 1 : 0));
    }
}
