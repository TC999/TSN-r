package com.qq.e.comm.plugin.g0.l0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.p0;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f43612a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final int f43613b = com.qq.e.comm.plugin.d0.a.d().f().a("rvncbt", 0);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final String f43614c;

        /* renamed from: d  reason: collision with root package name */
        private final g f43615d;

        a(String str, g gVar) {
            this.f43614c = str;
            this.f43615d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.f43612a.containsKey(this.f43614c)) {
                v.a(1407050, b.b(this.f43615d), 0, 0, b.b(this.f43614c));
            }
        }
    }

    private static boolean b() {
        return f43613b <= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.b.d dVar, g gVar) {
        if (b() || dVar == null) {
            return;
        }
        String D = dVar.D();
        if (TextUtils.isEmpty(D)) {
            return;
        }
        v.a(1407052, b(gVar), 0, 0, b(D));
        f43612a.remove(D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.b.d dVar, g gVar) {
        if (b() || dVar == null) {
            return;
        }
        String D = dVar.D();
        if (TextUtils.isEmpty(D)) {
            return;
        }
        if (f43612a.containsKey(D)) {
            v.a(1407056, b(gVar), 0, 0, b(D));
        }
        f43612a.put(D, Long.valueOf(System.currentTimeMillis()));
        v.a(1407051, b(gVar), 0, 0, b(D));
        p0.a(new a(D, gVar), f43613b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.b.d dVar, g gVar) {
        if (b() || dVar == null) {
            return;
        }
        String D = dVar.D();
        if (TextUtils.isEmpty(D)) {
            return;
        }
        v.a(1407053, b(gVar), 0, 0, b(D));
        f43612a.remove(D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.b.d dVar, g gVar, int i4) {
        if (b() || dVar == null) {
            return;
        }
        String D = dVar.D();
        if (TextUtils.isEmpty(D)) {
            return;
        }
        v.a(1407054, b(gVar), 0, Integer.valueOf(i4), b(D));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.b.d dVar, g gVar, int i4) {
        if (b() || dVar == null) {
            return;
        }
        String D = dVar.D();
        if (TextUtils.isEmpty(D)) {
            return;
        }
        v.a(1407055, b(gVar), Integer.valueOf(i4), 0, b(D));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.qq.e.comm.plugin.n0.d b(String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("tk", str);
        dVar.a("limit", Integer.valueOf(f43613b));
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a("tm", Long.valueOf(currentTimeMillis));
        Long l4 = f43612a.get(str);
        if (l4 != null) {
            dVar.a("stm", l4);
            dVar.a("stmd", Long.valueOf(currentTimeMillis - l4.longValue()));
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.qq.e.comm.plugin.n0.c b(g gVar) {
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(gVar);
        return cVar;
    }
}
