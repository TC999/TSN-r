package com.qq.e.comm.plugin.n0.w;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.p.h;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f44824a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends h {
        a() {
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            if (file.exists()) {
                String unused = f.f44824a = b1.d(file);
            }
        }
    }

    public static void a(int i4, boolean z3, int i5, com.qq.e.comm.plugin.n0.c cVar, long j4) {
        com.qq.e.comm.plugin.n0.d dVar;
        e a4 = a(cVar, z3, i5);
        if (j4 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - j4;
            a4.a(currentTimeMillis);
            dVar = new com.qq.e.comm.plugin.n0.d().a("du", Long.valueOf(currentTimeMillis));
        } else {
            dVar = null;
        }
        v.a(i4, a4, Integer.valueOf(i5), dVar);
    }

    public static void a(com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.n0.c cVar) {
        int i4;
        if (gVar.g()) {
            i4 = 2;
        } else {
            i4 = gVar.j() ? 1 : 0;
        }
        if (i4 != 0) {
            e eVar = new e(cVar);
            eVar.d(i4);
            v.b(4003053, eVar, Integer.valueOf(i4));
        }
    }

    private static e a(com.qq.e.comm.plugin.n0.c cVar, boolean z3, int i4) {
        e eVar = new e(cVar);
        eVar.e(i4);
        if (z3) {
            eVar.f(1);
        } else {
            eVar.f(2);
        }
        return eVar;
    }

    public static void a(int i4, boolean z3, int i5, com.qq.e.comm.plugin.n0.c cVar, long j4, int i6) {
        e a4 = a(cVar, z3, i5);
        a4.c(i6);
        if (j4 > 0) {
            a4.a(System.currentTimeMillis() - j4);
        }
        v.a(i4, a4, Integer.valueOf(i5), Integer.valueOf(i6), null);
    }

    public static void a(int i4, boolean z3, int i5, com.qq.e.comm.plugin.n0.c cVar, JSONObject jSONObject) {
        e a4 = a(cVar, z3, i5);
        a4.b(jSONObject);
        v.a(i4, a4, Integer.valueOf(i5));
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar) {
        if (TextUtils.isEmpty(f44824a) && com.qq.e.comm.plugin.t.c.a("lpcije", eVar.q0(), 0, eVar.p0()) != 0) {
            String a4 = com.qq.e.comm.plugin.d0.a.d().f().a("lpciju", eVar.q0(), "https://i.gtimg.cn/ams-web/page-performance/page-performance.min.js?v=1");
            if (TextUtils.isEmpty(a4)) {
                return;
            }
            File m4 = b1.m();
            String e4 = b1.e(a4);
            File file = new File(m4, e4);
            if (file.exists()) {
                d1.a("read From Cache", new Object[0]);
                f44824a = b1.d(file);
                return;
            }
            com.qq.e.comm.plugin.o0.g.a.a().a(new b.C0867b().d(a4).a(m4).a(e4).d(false).b(false).a(), new a());
        }
    }

    public static String a() {
        return f44824a;
    }
}
