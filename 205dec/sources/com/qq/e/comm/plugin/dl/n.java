package com.qq.e.comm.plugin.dl;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f42488a = System.currentTimeMillis();

        /* renamed from: b  reason: collision with root package name */
        public long f42489b;

        /* renamed from: c  reason: collision with root package name */
        public int f42490c;
    }

    public static void a(int i4, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.g0.y yVar) {
        if (yVar == null) {
            return;
        }
        boolean z3 = i4 != 0;
        int k4 = yVar.k();
        com.qq.e.comm.plugin.n0.e eVar2 = new com.qq.e.comm.plugin.n0.e((k4 == 1 || k4 == 4) ? z3 ? 1190010 : 1190011 : z3 ? 1190020 : 1190021);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.c(eVar.q0());
        cVar.a(eVar.o());
        cVar.d(yVar.j());
        eVar2.a(cVar);
        eVar2.c(k4);
        if (z3) {
            eVar2.d(i4);
        }
        com.qq.e.comm.plugin.n0.v.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.b.g gVar, int i4, String str, int i5) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(i5 == 0 ? 1190102 : 1190101);
        eVar.c(i4);
        eVar.d(i5);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(gVar);
        cVar.d(str);
        eVar.a(cVar);
        com.qq.e.comm.plugin.n0.v.a(eVar);
    }

    public static void a(com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.g0.y yVar, int i4, Exception exc) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(1190022);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(gVar);
        cVar.d(yVar.j());
        eVar.a(cVar);
        eVar.d(i4);
        if (exc != null) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("ot", exc.getMessage());
            eVar.a(dVar);
        }
        com.qq.e.comm.plugin.n0.v.a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.b.g gVar, int i4, String str, int i5) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(i5 == 0 ? 1190104 : 1190103);
        eVar.c(i4);
        eVar.d(i5);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(gVar);
        cVar.d(str);
        eVar.a(cVar);
        com.qq.e.comm.plugin.n0.v.a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.b.g gVar, int i4) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(1190007);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(gVar);
        eVar.a(cVar);
        eVar.c(3);
        eVar.d(i4);
        com.qq.e.comm.plugin.n0.v.a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.g0.e eVar, a aVar) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2230015);
        hVar.a(com.qq.e.comm.plugin.n0.c.a(eVar));
        hVar.b(aVar.f42489b - aVar.f42488a);
        hVar.b(aVar.f42490c);
        com.qq.e.comm.plugin.n0.v.a(hVar);
    }

    public static void a(a aVar) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2230016);
        hVar.b(aVar.f42489b - aVar.f42488a);
        hVar.b(aVar.f42490c);
        com.qq.e.comm.plugin.n0.v.a(hVar);
    }

    public static void a(com.qq.e.comm.plugin.b.g gVar, String str, int i4) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(1190023);
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(gVar);
        cVar.d(str);
        eVar.a(cVar);
        eVar.d(i4);
        com.qq.e.comm.plugin.n0.v.a(eVar);
    }
}
