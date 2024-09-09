package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import android.os.SystemClock;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Connection.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class g implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final boolean f1082a;

    /* renamed from: b  reason: collision with root package name */
    final i f1083b;

    /* renamed from: d  reason: collision with root package name */
    final String f1085d;

    /* renamed from: e  reason: collision with root package name */
    int f1086e;

    /* renamed from: f  reason: collision with root package name */
    int f1087f;

    /* renamed from: g  reason: collision with root package name */
    boolean f1088g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f1089h;

    /* renamed from: i  reason: collision with root package name */
    private Map<Integer, l> f1090i;

    /* renamed from: j  reason: collision with root package name */
    final m f1091j;

    /* renamed from: l  reason: collision with root package name */
    long f1093l;

    /* renamed from: n  reason: collision with root package name */
    final n f1095n;

    /* renamed from: o  reason: collision with root package name */
    boolean f1096o;

    /* renamed from: p  reason: collision with root package name */
    final Socket f1097p;

    /* renamed from: q  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j f1098q;

    /* renamed from: r  reason: collision with root package name */
    final j f1099r;

    /* renamed from: s  reason: collision with root package name */
    final Set<Integer> f1100s;

    /* renamed from: u  reason: collision with root package name */
    static final /* synthetic */ boolean f1081u = true;

    /* renamed from: t  reason: collision with root package name */
    static final ExecutorService f1080t = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp Http2Connection", true));

    /* renamed from: c  reason: collision with root package name */
    final Map<Integer, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> f1084c = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    long f1092k = 0;

    /* renamed from: m  reason: collision with root package name */
    n f1094m = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1101b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f1102c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            super(str, objArr);
            this.f1101b = i4;
            this.f1102c = bVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.b(this.f1101b, this.f1102c);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1104b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f1105c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i4, long j4) {
            super(str, objArr);
            this.f1104b = i4;
            this.f1105c = j4;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.f1098q.a(this.f1104b, this.f1105c);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1107b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1108c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f1109d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l f1110e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, boolean z3, int i4, int i5, l lVar) {
            super(str, objArr);
            this.f1107b = z3;
            this.f1108c = i4;
            this.f1109d = i5;
            this.f1110e = lVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                g.this.a(this.f1107b, this.f1108c, this.f1109d, this.f1110e);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class d extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1112b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f1113c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i4, List list) {
            super(str, objArr);
            this.f1112b = i4;
            this.f1113c = list;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            if (g.this.f1091j.a(this.f1112b, this.f1113c)) {
                try {
                    g.this.f1098q.a(this.f1112b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                    synchronized (g.this) {
                        g.this.f1100s.remove(Integer.valueOf(this.f1112b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class e extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1115b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f1116c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f1117d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i4, List list, boolean z3) {
            super(str, objArr);
            this.f1115b = i4;
            this.f1116c = list;
            this.f1117d = z3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            boolean a4 = g.this.f1091j.a(this.f1115b, this.f1116c, this.f1117d);
            if (a4) {
                try {
                    g.this.f1098q.a(this.f1115b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a4 || this.f1117d) {
                synchronized (g.this) {
                    g.this.f1100s.remove(Integer.valueOf(this.f1115b));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class f extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1119b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1120c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f1121d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f1122e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i5, boolean z3) {
            super(str, objArr);
            this.f1119b = i4;
            this.f1120c = cVar;
            this.f1121d = i5;
            this.f1122e = z3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            try {
                boolean a4 = g.this.f1091j.a(this.f1119b, this.f1120c, this.f1121d, this.f1122e);
                if (a4) {
                    g.this.f1098q.a(this.f1119b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                }
                if (a4 || this.f1122e) {
                    synchronized (g.this) {
                        g.this.f1100s.remove(Integer.valueOf(this.f1119b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$g  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class C0035g extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1124b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f1125c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0035g(String str, Object[] objArr, int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            super(str, objArr);
            this.f1124b = i4;
            this.f1125c = bVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            g.this.f1091j.a(this.f1124b, this.f1125c);
            synchronized (g.this) {
                g.this.f1100s.remove(Integer.valueOf(this.f1124b));
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        public static final i f1134a = new a();

        /* compiled from: Http2Connection.java */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        static class a extends i {
            a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
            public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException {
                iVar.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException;
    }

    g(h hVar) {
        n nVar = new n();
        this.f1095n = nVar;
        this.f1096o = false;
        this.f1100s = new LinkedHashSet();
        this.f1091j = hVar.f1132f;
        boolean z3 = hVar.f1133g;
        this.f1082a = z3;
        this.f1083b = hVar.f1131e;
        int i4 = z3 ? 1 : 2;
        this.f1087f = i4;
        if (z3) {
            this.f1087f = i4 + 2;
        }
        if (z3) {
            this.f1094m.a(7, 16777216);
        }
        String str = hVar.f1128b;
        this.f1085d = str;
        this.f1089h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp %s Push Observer", str), true));
        nVar.a(7, 65535);
        nVar.a(5, 16384);
        this.f1093l = nVar.c();
        this.f1097p = hVar.f1127a;
        this.f1098q = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j(hVar.f1130d, z3);
        this.f1099r = new j(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h(hVar.f1129c, z3));
    }

    synchronized bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a(int i4) {
        return this.f1084c.get(Integer.valueOf(i4));
    }

    public synchronized int b() {
        return this.f1095n.b(Integer.MAX_VALUE);
    }

    boolean b(int i4) {
        return i4 != 0 && (i4 & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        f1080t.execute(new a("OkHttp %s stream %d", new Object[]{this.f1085d, Integer.valueOf(i4)}, i4, bVar));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.NO_ERROR, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i d(int i4) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i remove;
        remove = this.f1084c.remove(Integer.valueOf(i4));
        notifyAll();
        return remove;
    }

    public void flush() throws IOException {
        this.f1098q.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:4:0x0005, B:21:0x0041, B:25:0x0050, B:22:0x0047, B:24:0x004b, B:29:0x0059, B:30:0x0060, B:5:0x0006, B:7:0x000a, B:9:0x001d, B:11:0x0025, B:16:0x002f, B:18:0x0035, B:19:0x003e, B:31:0x0061, B:32:0x0066), top: B:39:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i b(int r11, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r7 = r10.f1098q
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r10.f1088g     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L61
            int r8 = r10.f1087f     // Catch: java.lang.Throwable -> L67
            int r0 = r8 + 2
            r10.f1087f = r0     // Catch: java.lang.Throwable -> L67
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i r9 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i     // Catch: java.lang.Throwable -> L67
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
            if (r13 == 0) goto L2e
            long r0 = r10.f1093l     // Catch: java.lang.Throwable -> L67
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L2e
            long r0 = r9.f1155b     // Catch: java.lang.Throwable -> L67
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L2c
            goto L2e
        L2c:
            r13 = 0
            goto L2f
        L2e:
            r13 = 1
        L2f:
            boolean r0 = r9.g()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L3e
            java.util.Map<java.lang.Integer, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> r0 = r10.f1084c     // Catch: java.lang.Throwable -> L67
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L67
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L67
        L3e:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            if (r11 != 0) goto L47
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r0 = r10.f1098q     // Catch: java.lang.Throwable -> L6a
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L6a
            goto L50
        L47:
            boolean r0 = r10.f1082a     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L59
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r0 = r10.f1098q     // Catch: java.lang.Throwable -> L6a
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L6a
        L50:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            if (r13 == 0) goto L58
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r11 = r10.f1098q
            r11.flush()
        L58:
            return r9
        L59:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L6a
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L6a
            throw r11     // Catch: java.lang.Throwable -> L6a
        L61:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a r11 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a     // Catch: java.lang.Throwable -> L67
            r11.<init>()     // Catch: java.lang.Throwable -> L67
            throw r11     // Catch: java.lang.Throwable -> L67
        L67:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            throw r11     // Catch: java.lang.Throwable -> L6a
        L6a:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.b(int, java.util.List, boolean):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i");
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list, boolean z3) throws IOException {
        return b(0, list, z3);
    }

    synchronized l c(int i4) {
        Map<Integer, l> map;
        map = this.f1090i;
        return map != null ? map.remove(Integer.valueOf(i4)) : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f1098q.b());
        r6 = r3;
        r8.f1093l -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r9, boolean r10, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r12 = r8.f1098q
            r12.a(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.f1093l     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> r3 = r8.f1084c     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L56
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L56
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r3 = r8.f1098q     // Catch: java.lang.Throwable -> L56
            int r3 = r3.b()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f1093l     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f1093l = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r4 = r8.f1098q
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.a(r5, r9, r11, r3)
            goto Ld
        L56:
            r9 = move-exception
            goto L5e
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.a(int, boolean, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c, long):void");
    }

    public void c() throws IOException {
        a(true);
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        Socket f1127a;

        /* renamed from: b  reason: collision with root package name */
        String f1128b;

        /* renamed from: c  reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f1129c;

        /* renamed from: d  reason: collision with root package name */
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f1130d;

        /* renamed from: e  reason: collision with root package name */
        i f1131e = i.f1134a;

        /* renamed from: f  reason: collision with root package name */
        m f1132f = m.f1195a;

        /* renamed from: g  reason: collision with root package name */
        boolean f1133g;

        public h(boolean z3) {
            this.f1133g = z3;
        }

        public h a(Socket socket, String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
            this.f1127a = socket;
            this.f1128b = str;
            this.f1129c = eVar;
            this.f1130d = dVar;
            return this;
        }

        public h a(i iVar) {
            this.f1131e = iVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class j extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b implements h.b {

        /* renamed from: b  reason: collision with root package name */
        final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h f1135b;

        /* compiled from: Http2Connection.java */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        class a extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i f1137b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) {
                super(str, objArr);
                this.f1137b = iVar;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                try {
                    g.this.f1083b.a(this.f1137b);
                } catch (IOException e4) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e b4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b();
                    b4.a(4, "Http2Connection.Listener failure for " + g.this.f1085d, e4);
                    try {
                        this.f1137b.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection.java */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        class b extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                g gVar = g.this;
                gVar.f1083b.a(gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Http2Connection.java */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        public class c extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ n f1140b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, n nVar) {
                super(str, objArr);
                this.f1140b = nVar;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
            public void b() {
                try {
                    g.this.f1098q.a(this.f1140b);
                } catch (IOException unused) {
                }
            }
        }

        j(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h hVar) {
            super("OkHttp %s", g.this.f1085d);
            this.f1135b = hVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i4, int i5, int i6, boolean z3) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z3, int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i5) throws IOException {
            if (g.this.b(i4)) {
                g.this.a(i4, eVar, i5, z3);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a4 = g.this.a(i4);
            if (a4 == null) {
                g.this.c(i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                eVar.skip(i5);
                return;
            }
            a4.a(eVar, i5);
            if (z3) {
                a4.i();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        protected void b() {
            Throwable th;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.INTERNAL_ERROR;
            try {
                try {
                    this.f1135b.a(this);
                    while (this.f1135b.a(false, (h.b) this)) {
                    }
                    bVar = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.NO_ERROR;
                } catch (IOException unused) {
                    bVar = bVar2;
                } catch (Throwable th2) {
                    th = th2;
                    bVar = bVar2;
                    try {
                        g.this.a(bVar, bVar2);
                    } catch (IOException unused2) {
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1135b);
                    throw th;
                }
                try {
                    try {
                        g.this.a(bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
                    } catch (Throwable th3) {
                        th = th3;
                        g.this.a(bVar, bVar2);
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1135b);
                        throw th;
                    }
                } catch (IOException unused3) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR;
                    g.this.a(bVar3, bVar3);
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1135b);
                }
            } catch (IOException unused4) {
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1135b);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z3, int i4, int i5, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
            if (g.this.b(i4)) {
                g.this.a(i4, list, z3);
                return;
            }
            synchronized (g.this) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a4 = g.this.a(i4);
                if (a4 == null) {
                    g gVar = g.this;
                    if (gVar.f1088g) {
                        return;
                    }
                    if (i4 <= gVar.f1086e) {
                        return;
                    }
                    if (i4 % 2 == gVar.f1087f % 2) {
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i(i4, g.this, false, z3, list);
                    g gVar2 = g.this;
                    gVar2.f1086e = i4;
                    gVar2.f1084c.put(Integer.valueOf(i4), iVar);
                    g.f1080t.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f1085d, Integer.valueOf(i4)}, iVar));
                    return;
                }
                a4.a(list);
                if (z3) {
                    a4.i();
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
            if (g.this.b(i4)) {
                g.this.a(i4, bVar);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i d4 = g.this.d(i4);
            if (d4 != null) {
                d4.c(bVar);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z3, n nVar) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
            long j4;
            int i4;
            synchronized (g.this) {
                int c4 = g.this.f1095n.c();
                if (z3) {
                    g.this.f1095n.a();
                }
                g.this.f1095n.a(nVar);
                a(nVar);
                int c5 = g.this.f1095n.c();
                iVarArr = null;
                if (c5 == -1 || c5 == c4) {
                    j4 = 0;
                } else {
                    j4 = c5 - c4;
                    g gVar = g.this;
                    if (!gVar.f1096o) {
                        gVar.a(j4);
                        g.this.f1096o = true;
                    }
                    if (!g.this.f1084c.isEmpty()) {
                        iVarArr = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) g.this.f1084c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[g.this.f1084c.size()]);
                    }
                }
                g.f1080t.execute(new b("OkHttp %s settings", g.this.f1085d));
            }
            if (iVarArr == null || j4 == 0) {
                return;
            }
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.a(j4);
                }
            }
        }

        private void a(n nVar) {
            g.f1080t.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f1085d}, nVar));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(boolean z3, int i4, int i5) {
            if (z3) {
                l c4 = g.this.c(i4);
                if (c4 != null) {
                    c4.b();
                    return;
                }
                return;
            }
            g.this.b(true, i4, i5, null);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
            fVar.e();
            synchronized (g.this) {
                iVarArr = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) g.this.f1084c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[g.this.f1084c.size()]);
                g.this.f1088g = true;
            }
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                if (iVar.c() > i4 && iVar.f()) {
                    iVar.c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
                    g.this.d(iVar.c());
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i4, long j4) {
            if (i4 == 0) {
                synchronized (g.this) {
                    g gVar = g.this;
                    gVar.f1093l += j4;
                    gVar.notifyAll();
                }
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i a4 = g.this.a(i4);
            if (a4 != null) {
                synchronized (a4) {
                    a4.a(j4);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.h.b
        public void a(int i4, int i5, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
            g.this.a(i5, list);
        }
    }

    void a(long j4) {
        this.f1093l += j4;
        if (j4 > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, long j4) {
        f1080t.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f1085d, Integer.valueOf(i4)}, i4, j4));
    }

    void a(boolean z3, int i4, int i5, l lVar) throws IOException {
        synchronized (this.f1098q) {
            if (lVar != null) {
                lVar.c();
            }
            this.f1098q.a(z3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        this.f1098q.a(i4, bVar);
    }

    void b(boolean z3, int i4, int i5, l lVar) {
        f1080t.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f1085d, Integer.valueOf(i4), Integer.valueOf(i5)}, z3, i4, i5, lVar));
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        synchronized (this.f1098q) {
            synchronized (this) {
                if (this.f1088g) {
                    return;
                }
                this.f1088g = true;
                this.f1098q.a(this.f1086e, bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1226a);
            }
        }
    }

    void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar2) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[] iVarArr;
        if (!f1081u && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        l[] lVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e4) {
            e = e4;
        }
        synchronized (this) {
            if (this.f1084c.isEmpty()) {
                iVarArr = null;
            } else {
                iVarArr = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[]) this.f1084c.values().toArray(new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i[this.f1084c.size()]);
                this.f1084c.clear();
            }
            Map<Integer, l> map = this.f1090i;
            if (map != null) {
                this.f1090i = null;
                lVarArr = (l[]) map.values().toArray(new l[this.f1090i.size()]);
            }
        }
        if (iVarArr != null) {
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e5) {
                    if (e != null) {
                        e = e5;
                    }
                }
            }
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.a();
            }
        }
        try {
            this.f1098q.close();
        } catch (IOException e6) {
            if (e == null) {
                e = e6;
            }
        }
        try {
            this.f1097p.close();
        } catch (IOException e7) {
            e = e7;
        }
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z3) throws IOException {
        if (z3) {
            this.f1098q.a();
            this.f1098q.b(this.f1094m);
            int c4 = this.f1094m.c();
            if (c4 != 65535) {
                this.f1098q.a(0, c4 - 65535);
            }
        }
        Thread thread = new Thread(this.f1099r);
        thread.setName("tt_pangle_thread_http2_connection" + SystemClock.uptimeMillis());
        thread.start();
    }

    public synchronized boolean a() {
        return this.f1088g;
    }

    void a(int i4, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        synchronized (this) {
            if (this.f1100s.contains(Integer.valueOf(i4))) {
                c(i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.PROTOCOL_ERROR);
                return;
            }
            this.f1100s.add(Integer.valueOf(i4));
            this.f1089h.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f1085d, Integer.valueOf(i4)}, i4, list));
        }
    }

    void a(int i4, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list, boolean z3) {
        this.f1089h.execute(new e("OkHttp %s Push Headers[%s]", new Object[]{this.f1085d, Integer.valueOf(i4)}, i4, list, z3));
    }

    void a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i5, boolean z3) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        long j4 = i5;
        eVar.c(j4);
        eVar.a(cVar, j4);
        if (cVar.f() == j4) {
            this.f1089h.execute(new f("OkHttp %s Push Data[%s]", new Object[]{this.f1085d, Integer.valueOf(i4)}, i4, cVar, i5, z3));
            return;
        }
        throw new IOException(cVar.f() + " != " + i5);
    }

    void a(int i4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        this.f1089h.execute(new C0035g("OkHttp %s Push Reset[%s]", new Object[]{this.f1085d, Integer.valueOf(i4)}, i4, bVar));
    }
}
