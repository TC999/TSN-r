package com.qq.e.comm.plugin.o0.g;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.g.c;
import com.qq.e.comm.plugin.p.c;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements c.b {

    /* renamed from: h  reason: collision with root package name */
    private static volatile a f45066h;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.p.c f45068b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.p.c f45069c;

    /* renamed from: g  reason: collision with root package name */
    private final ExecutorService f45073g;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, File> f45070d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f45071e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Pair<String, Long>> f45072f = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, com.qq.e.comm.plugin.o0.g.c> f45067a = new ConcurrentHashMap();

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o0.g.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class ThreadFactoryC0866a implements ThreadFactory {
        ThreadFactoryC0866a(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_DOWNLOAD_THREAD");
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements ThreadFactory {
        b(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_DOWNLOAD_THREAD");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.o0.g.b f45074a;

        c(com.qq.e.comm.plugin.o0.g.b bVar) {
            this.f45074a = bVar;
        }

        @Override // com.qq.e.comm.plugin.o0.g.c.a
        public void a(File file) {
            a.this.a(this.f45074a.g(), file);
        }
    }

    private a() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(15, new ThreadFactoryC0866a(this));
        this.f45068b = new c.b().a(newFixedThreadPool).b(10000).a(10000).a();
        this.f45069c = new c.b().a(newFixedThreadPool).b(10000).a(10000).a(false).a();
        this.f45073g = Executors.newSingleThreadExecutor(new b(this));
    }

    public static a a() {
        if (f45066h == null) {
            synchronized (a.class) {
                if (f45066h == null) {
                    f45066h = new a();
                }
            }
        }
        return f45066h;
    }

    private void a(com.qq.e.comm.plugin.o0.g.b bVar) throws IllegalArgumentException {
    }

    private String b(String str) {
        if (str != null) {
            return String.valueOf(str.hashCode());
        }
        throw new NullPointerException("Tag can't be null!");
    }

    public Pair<String, Long> c(String str) {
        return this.f45072f.get(str);
    }

    public File d(String str) {
        return this.f45070d.get(str);
    }

    public boolean e(String str) {
        return this.f45071e.contains(str);
    }

    public boolean f(String str) {
        com.qq.e.comm.plugin.o0.g.c cVar = this.f45067a.get(b(str));
        return cVar != null && cVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d implements com.qq.e.comm.plugin.p.b, com.qq.e.comm.plugin.p.a {

        /* renamed from: a  reason: collision with root package name */
        private final com.qq.e.comm.plugin.p.b f45076a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f45077b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Pair<String, Long>> f45078c;

        /* renamed from: d  reason: collision with root package name */
        private final String f45079d;

        d(com.qq.e.comm.plugin.p.b bVar, List<String> list, Map<String, Pair<String, Long>> map, com.qq.e.comm.plugin.o0.g.b bVar2) {
            this.f45076a = bVar;
            this.f45077b = list;
            this.f45078c = map;
            this.f45079d = bVar2.e();
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a() {
            com.qq.e.comm.plugin.p.b bVar = this.f45076a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void b() {
            com.qq.e.comm.plugin.p.b bVar = this.f45076a;
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, boolean z3) {
            com.qq.e.comm.plugin.p.b bVar = this.f45076a;
            if (bVar != null) {
                bVar.a(j4, z3);
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, long j5, int i4) {
            com.qq.e.comm.plugin.p.b bVar = this.f45076a;
            if (bVar != null) {
                bVar.a(j4, j5, i4);
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            com.qq.e.comm.plugin.p.b bVar = this.f45076a;
            if (bVar != null) {
                bVar.a(file, j4);
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(boolean z3) {
            com.qq.e.comm.plugin.p.b bVar = this.f45076a;
            if (bVar != null) {
                bVar.a(z3);
            }
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
            com.qq.e.comm.plugin.p.b bVar = this.f45076a;
            if (bVar != null) {
                bVar.a(dVar);
            }
            this.f45077b.add(this.f45079d);
        }

        @Override // com.qq.e.comm.plugin.p.a
        public void a(String str, long j4) {
            this.f45078c.put(this.f45079d, new Pair<>(str, Long.valueOf(j4)));
        }
    }

    public void a(com.qq.e.comm.plugin.o0.g.b bVar, com.qq.e.comm.plugin.p.b bVar2) {
        a(bVar);
        if (TextUtils.isEmpty(bVar.g())) {
            if (bVar2 != null) {
                bVar2.a(new com.qq.e.comm.plugin.p.d(4, "UrlIsEmpty"));
                return;
            }
            return;
        }
        if (bVar.c() < 1.0d) {
            v.a(1400011, bVar.a(), Integer.valueOf((int) (bVar.c() * 100.0d)));
        }
        d dVar = new d(bVar2, this.f45071e, this.f45072f, bVar);
        String b4 = b(bVar.e());
        com.qq.e.comm.plugin.o0.g.c cVar = this.f45067a.get(b4);
        if (cVar != null) {
            if (cVar.b()) {
                if (bVar.c() > cVar.a().c()) {
                    cVar.a(bVar.c());
                }
                cVar.a(dVar);
                d1.a("Task has been started!");
                return;
            }
            d1.a("Downloader instance with same tag has not been destroyed!");
            return;
        }
        com.qq.e.comm.plugin.o0.g.c cVar2 = new com.qq.e.comm.plugin.o0.g.c(b4, bVar, dVar, bVar.h() ? this.f45068b : this.f45069c);
        cVar2.a(this);
        cVar2.a(new c(bVar));
        this.f45067a.put(b4, cVar2);
        if (this.f45071e.contains(bVar.g())) {
            this.f45071e.remove(bVar.g());
        }
        a(cVar2, bVar.j());
    }

    private void a(com.qq.e.comm.plugin.o0.g.c cVar, boolean z3) {
        if (z3) {
            this.f45073g.submit(cVar);
        } else {
            d0.f46406b.submit(cVar);
        }
    }

    @Override // com.qq.e.comm.plugin.o0.g.c.b
    public void a(String str) {
        this.f45067a.remove(str);
    }

    void a(String str, File file) {
        this.f45070d.put(str, file);
    }
}
