package com.qq.e.comm.plugin.fs.e;

import android.os.CountDownTimer;
import android.text.TextUtils;
import com.qq.e.comm.plugin.o0.g.b;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l2;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements com.qq.e.comm.plugin.util.v2.e {

    /* renamed from: f  reason: collision with root package name */
    private static final int f43261f = com.qq.e.comm.plugin.d0.a.d().f().a("ifsvmlt", 20000);

    /* renamed from: g  reason: collision with root package name */
    private static volatile f f43262g;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Set<c>> f43263c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, CountDownTimer> f43264d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, com.qq.e.comm.plugin.util.v2.c> f43265e = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43282c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f43283d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f43284e;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a extends CountDownTimer {
            a(long j4, long j5) {
                super(j4, j5);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                d1.a("FSVideoDownloader", "FSVideoADView load video timeout");
                e.e(b.this.f43284e);
                Set<c> set = (Set) f.this.f43263c.get(b.this.f43282c);
                if (set == null || set.size() <= 0) {
                    return;
                }
                for (c cVar : set) {
                    cVar.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
            }
        }

        b(String str, int i4, com.qq.e.comm.plugin.g0.e eVar) {
            this.f43282c = str;
            this.f43283d = i4;
            this.f43284e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((CountDownTimer) f.this.f43264d.get(this.f43282c)) == null) {
                long j4 = this.f43283d;
                f.this.f43264d.put(this.f43282c, new a(j4, j4).start());
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a();

        void a(int i4, long j4, long j5);

        void a(com.qq.e.comm.plugin.p.d dVar);

        void a(String str);

        void a(boolean z3);

        void onCancel();

        void onStart();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d implements c {
        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(int i4, long j4, long j5) {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(String str) {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void a(boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.fs.e.f.c
        public void onStart() {
        }
    }

    private f() {
    }

    private com.qq.e.comm.plugin.util.v2.c c(com.qq.e.comm.plugin.g0.e eVar) {
        String K0 = eVar.K0();
        if (K0 == null) {
            return new com.qq.e.comm.plugin.util.v2.d();
        }
        com.qq.e.comm.plugin.util.v2.c cVar = this.f43265e.get(K0);
        if (cVar == null) {
            com.qq.e.comm.plugin.util.v2.b bVar = new com.qq.e.comm.plugin.util.v2.b(eVar, this);
            this.f43265e.put(K0, bVar);
            return bVar;
        }
        return cVar;
    }

    public boolean d(com.qq.e.comm.plugin.g0.e eVar) {
        return c(eVar).e();
    }

    public void e(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.util.v2.c cVar = this.f43265e.get(b(eVar));
        if (cVar != null) {
            cVar.f();
        }
    }

    public void f(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.util.v2.c cVar = this.f43265e.get(b(eVar));
        if (cVar != null) {
            cVar.g();
        }
    }

    public void g(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.util.v2.c cVar = this.f43265e.get(b(eVar));
        if (cVar != null) {
            cVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.p.b {

        /* renamed from: a  reason: collision with root package name */
        private int f43266a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f43267b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43268c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f43269d;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.fs.e.f$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0823a implements Runnable {
            RunnableC0823a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<c> set = (Set) f.this.f43263c.get(a.this.f43267b);
                if (set == null || set.size() <= 0) {
                    return;
                }
                for (c cVar : set) {
                    cVar.onStart();
                }
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class b implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f43272c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ long f43273d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ long f43274e;

            b(int i4, long j4, long j5) {
                this.f43272c = i4;
                this.f43273d = j4;
                this.f43274e = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<c> set = (Set) f.this.f43263c.get(a.this.f43267b);
                if (set != null && set.size() > 0) {
                    for (c cVar : set) {
                        cVar.a(this.f43272c, this.f43273d, this.f43274e);
                    }
                }
                a aVar = a.this;
                f.this.a(aVar.f43267b);
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<c> set = (Set) f.this.f43263c.get(a.this.f43267b);
                if (set != null && set.size() > 0) {
                    for (c cVar : set) {
                        File c4 = b1.c(a.this.f43268c);
                        cVar.a(c4 == null ? "" : c4.getAbsolutePath());
                    }
                }
                f.this.f43263c.remove(a.this.f43267b);
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class d implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f43277c;

            d(boolean z3) {
                this.f43277c = z3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<c> set = (Set) f.this.f43263c.get(a.this.f43267b);
                if (set == null || set.size() <= 0) {
                    return;
                }
                for (c cVar : set) {
                    cVar.a(this.f43277c);
                }
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<c> set = (Set) f.this.f43263c.get(a.this.f43267b);
                if (set != null && set.size() > 0) {
                    for (c cVar : set) {
                        cVar.onCancel();
                    }
                }
                f.this.f43263c.remove(a.this.f43267b);
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.fs.e.f$a$f  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0824f implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ com.qq.e.comm.plugin.p.d f43280c;

            RunnableC0824f(com.qq.e.comm.plugin.p.d dVar) {
                this.f43280c = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<c> set = (Set) f.this.f43263c.get(a.this.f43267b);
                if (set != null && set.size() > 0) {
                    for (c cVar : set) {
                        cVar.a(this.f43280c);
                    }
                }
                f.this.f43263c.remove(a.this.f43267b);
            }
        }

        a(String str, String str2, com.qq.e.comm.plugin.g0.e eVar) {
            this.f43267b = str;
            this.f43268c = str2;
            this.f43269d = eVar;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a() {
            d1.a("FSVideoDownloader", "onStarted");
            p0.a((Runnable) new RunnableC0823a());
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void b() {
            d1.a("FSVideoDownloader", "onCancel");
            p0.a((Runnable) new e());
            f.this.a(this.f43267b);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, boolean z3) {
            this.f43266a = (int) (j4 >> 10);
            d1.a("FSVideoDownloader", "onConnected isRangeSupport: " + z3 + ", total: " + j4);
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, long j5, int i4) {
            d1.a("FSVideoDownloader", "downloading video, Progress: " + i4 + "%");
            p0.a((Runnable) new b(i4, j4, j5));
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            d1.a("FSVideoDownloader", "onCompleted");
            p0.a((Runnable) new c());
            f.this.a(this.f43267b);
            l2.a(j4, this.f43266a, this.f43268c, com.qq.e.comm.plugin.n0.c.a(this.f43269d));
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(boolean z3) {
            d1.a("FSVideoDownloader", "onPaused " + z3);
            p0.a((Runnable) new d(z3));
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            GDTLogger.w("\u89c6\u9891\u4e0b\u8f7d\u5931\u8d25, code: " + dVar.a() + ", msg: " + dVar.b(), null);
            p0.a((Runnable) new RunnableC0824f(dVar));
            f.this.a(this.f43267b);
        }
    }

    private String b(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            d1.a("FSVideoDownloader", "getMapKey null baseAdInfo");
            return "";
        } else if (eVar.K0() == null) {
            d1.a("FSVideoDownloader", "getMapKey null traceId");
            if (eVar.L0() == null) {
                d1.a("FSVideoDownloader", "getMapKey null video");
                return "";
            }
            return eVar.L0();
        } else {
            return eVar.K0();
        }
    }

    public static f a() {
        if (f43262g == null) {
            synchronized (f.class) {
                if (f43262g == null) {
                    f43262g = new f();
                }
            }
        }
        return f43262g;
    }

    public void a(String str, String str2, c cVar, com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        String str3;
        d1.a("FSVideoDownloader", "downloadVideo isPreloadVideo:%b, videoUrl:%s", Boolean.valueOf(z3), str);
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("\u4e0b\u8f7d\u89c6\u9891\u5931\u8d25\uff0cvideoUrl\u4e3a\u7a7a");
            return;
        }
        double d4 = 1.0d;
        boolean z4 = !TextUtils.isEmpty(str2);
        if (!z4) {
            a(eVar);
        } else if (z3) {
            if (com.qq.e.comm.plugin.util.v2.a.a(eVar.H())) {
                d1.a("FSVideoDownloader", "CDNStrategyUtil Don't download ");
                return;
            } else {
                d1.a("FSVideoDownloader", "CDNStrategyUtil all download ");
                a(eVar);
            }
        } else {
            d1.a("FSVideoDownloader", "CDNVideoDownloadTrigger download");
            com.qq.e.comm.plugin.util.v2.c c4 = c(eVar);
            String d5 = c4.d();
            d4 = c4.b();
            str3 = d5;
            a(str, z4, cVar, eVar, d4, str3);
        }
        str3 = "";
        a(str, z4, cVar, eVar, d4, str3);
    }

    private void a(String str, boolean z3, c cVar, com.qq.e.comm.plugin.g0.e eVar, double d4, String str2) {
        d1.a("FSVideoDownloader", "downloadVideoPartial ratio:%.2f, playWhileDownloading:%b, videoUrl:%s", Double.valueOf(d4), Boolean.valueOf(z3), str);
        b.C0867b c0867b = new b.C0867b();
        c0867b.a(d4);
        String b4 = b(eVar);
        a(!z3 ? f43261f : f43261f * 2, b4, eVar);
        if (cVar != null) {
            Set<c> set = this.f43263c.get(b4);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(cVar);
            this.f43263c.put(b4, set);
        }
        com.qq.e.comm.plugin.o0.g.a.a().a(c0867b.d(str).a(b1.d(str)).a(b1.p()).d(!z3).c(str2).a(com.qq.e.comm.plugin.n0.c.a(eVar)).a(), new a(b4, str, eVar));
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar) {
        String K0 = eVar.K0();
        if (K0 == null) {
            return;
        }
        this.f43265e.put(K0, new com.qq.e.comm.plugin.util.v2.d());
    }

    @Override // com.qq.e.comm.plugin.util.v2.e
    public void a(com.qq.e.comm.plugin.util.v2.c cVar, double d4) {
        a(cVar.a().L0(), true, null, cVar.a(), d4, cVar.d());
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar, int i4, int i5, int i6) {
        d1.a("FSVideoDownloader", "onPositionUpdate currentPosition:%d, duration:%d, videoDownloadProgress:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        String K0 = eVar.K0();
        if (K0 == null) {
            d1.a("FSVideoDownloader", "onPositionUpdate null trace id");
            return;
        }
        com.qq.e.comm.plugin.util.v2.c cVar = this.f43265e.get(K0);
        if (cVar != null) {
            cVar.a(i4, i5, i6);
        }
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar, int i4, f.t tVar) {
        d1.a("FSVideoDownloader", "onPositionBlock blockTime:%d, state:%s", Integer.valueOf(i4), tVar);
        String K0 = eVar.K0();
        if (K0 == null) {
            d1.a("FSVideoDownloader", "onPositionBlock null trace id");
            return;
        }
        com.qq.e.comm.plugin.util.v2.c cVar = this.f43265e.get(K0);
        if (cVar != null) {
            cVar.a(i4, tVar);
        }
    }

    public void a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.o0.h.f fVar) {
        String b4 = b(eVar);
        com.qq.e.comm.plugin.util.v2.c remove = this.f43265e.remove(b4);
        if (remove != null) {
            remove.a(fVar);
        }
        this.f43263c.remove(b4);
    }

    private void a(int i4, String str, com.qq.e.comm.plugin.g0.e eVar) {
        p0.a((Runnable) new b(str, i4, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        CountDownTimer countDownTimer;
        Map<String, CountDownTimer> map = this.f43264d;
        if (map == null || (countDownTimer = map.get(str)) == null) {
            return;
        }
        countDownTimer.cancel();
        this.f43264d.remove(str);
    }
}
