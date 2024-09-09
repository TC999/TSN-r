package com.bytedance.sdk.component.xv.w.c.ux;

import android.os.SystemClock;
import com.bytedance.sdk.component.xv.w.c.ux.ev;
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
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class r implements Closeable {
    final t bk;
    boolean ev;

    /* renamed from: f  reason: collision with root package name */
    int f30858f;
    final p fp;
    final bk gd;

    /* renamed from: i  reason: collision with root package name */
    private Map<Integer, a> f30859i;
    final xv ia;

    /* renamed from: k  reason: collision with root package name */
    long f30860k;

    /* renamed from: q  reason: collision with root package name */
    private int f30862q;

    /* renamed from: r  reason: collision with root package name */
    int f30863r;

    /* renamed from: s  reason: collision with root package name */
    final Set<Integer> f30864s;

    /* renamed from: t  reason: collision with root package name */
    boolean f30865t;

    /* renamed from: u  reason: collision with root package name */
    private final ExecutorService f30866u;
    final String ux;

    /* renamed from: w  reason: collision with root package name */
    final boolean f30867w;
    final w xv;
    final Socket ys;
    static final /* synthetic */ boolean fz = true;

    /* renamed from: c  reason: collision with root package name */
    static final ExecutorService f30856c = new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.xv.w.c.xv.c("OkHttp Http2Connection", true));
    final Map<Integer, gd> sr = new LinkedHashMap();

    /* renamed from: p  reason: collision with root package name */
    long f30861p = 0;

    /* renamed from: a  reason: collision with root package name */
    t f30857a = new t();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class w {

        /* renamed from: f  reason: collision with root package name */
        public static final w f30881f = new w() { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.w.1
            @Override // com.bytedance.sdk.component.xv.w.c.ux.r.w
            public void c(gd gdVar) throws IOException {
                gdVar.c(com.bytedance.sdk.component.xv.w.c.ux.w.REFUSED_STREAM);
            }
        };

        public abstract void c(gd gdVar) throws IOException;

        public void c(r rVar) {
        }
    }

    r(c cVar) {
        t tVar = new t();
        this.bk = tVar;
        this.f30865t = false;
        this.f30864s = new LinkedHashSet();
        this.gd = cVar.f30878f;
        boolean z3 = cVar.f30879r;
        this.f30867w = z3;
        this.xv = cVar.ux;
        int i4 = z3 ? 1 : 2;
        this.f30863r = i4;
        if (z3) {
            this.f30863r = i4 + 2;
        }
        this.f30862q = z3 ? 1 : 2;
        if (z3) {
            this.f30857a.c(7, 16777216);
        }
        String str = cVar.f30880w;
        this.ux = str;
        this.f30866u = new com.bytedance.sdk.component.gd.sr.sr(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.xv.w.c.xv.c(com.bytedance.sdk.component.xv.w.c.xv.c("OkHttp %s Push Observer", str), true));
        tVar.c(7, 65535);
        tVar.c(5, 16384);
        this.f30860k = tVar.sr();
        this.ys = cVar.f30877c;
        this.fp = new p(cVar.sr, z3);
        this.ia = new xv(new ev(cVar.xv, z3));
    }

    synchronized gd c(int i4) {
        return this.sr.get(Integer.valueOf(i4));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c(com.bytedance.sdk.component.xv.w.c.ux.w.NO_ERROR, com.bytedance.sdk.component.xv.w.c.ux.w.CANCEL);
    }

    public synchronized boolean sr() {
        return this.ev;
    }

    boolean sr(int i4) {
        return i4 != 0 && (i4 & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized gd w(int i4) {
        gd remove;
        remove = this.sr.remove(Integer.valueOf(i4));
        notifyAll();
        return remove;
    }

    synchronized a xv(int i4) {
        Map<Integer, a> map;
        map = this.f30859i;
        return map != null ? map.remove(Integer.valueOf(i4)) : null;
    }

    public synchronized int c() {
        return this.bk.xv(Integer.MAX_VALUE);
    }

    public void xv() throws IOException {
        c(true);
    }

    public gd c(List<com.bytedance.sdk.component.xv.w.c.ux.xv> list, boolean z3) throws IOException {
        return w(0, list, z3);
    }

    void xv(final int i4, final com.bytedance.sdk.component.xv.w.c.ux.w wVar) {
        this.f30866u.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s Push Reset[%s]", new Object[]{this.ux, Integer.valueOf(i4)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.7
            @Override // com.bytedance.sdk.component.xv.w.c.w
            public void xv() {
                r.this.gd.c(i4, wVar);
                synchronized (r.this) {
                    r.this.f30864s.remove(Integer.valueOf(i4));
                }
            }
        });
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        Socket f30877c;

        /* renamed from: r  reason: collision with root package name */
        boolean f30879r;
        com.bytedance.sdk.component.xv.c.sr sr;

        /* renamed from: w  reason: collision with root package name */
        String f30880w;
        com.bytedance.sdk.component.xv.c.ux xv;
        w ux = w.f30881f;

        /* renamed from: f  reason: collision with root package name */
        bk f30878f = bk.f30818c;

        public c(boolean z3) {
            this.f30879r = z3;
        }

        public c c(Socket socket, String str, com.bytedance.sdk.component.xv.c.ux uxVar, com.bytedance.sdk.component.xv.c.sr srVar) {
            this.f30877c = socket;
            this.f30880w = str;
            this.xv = uxVar;
            this.sr = srVar;
            return this;
        }

        public c c(w wVar) {
            this.ux = wVar;
            return this;
        }

        public r c() {
            return new r(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:4:0x0006, B:21:0x0041, B:25:0x0050, B:22:0x0047, B:24:0x004b, B:29:0x0059, B:30:0x0060, B:5:0x0007, B:7:0x000b, B:9:0x001d, B:11:0x0025, B:16:0x002f, B:18:0x0035, B:19:0x003e, B:31:0x0061, B:32:0x0066), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.sdk.component.xv.w.c.ux.gd w(int r11, java.util.List<com.bytedance.sdk.component.xv.w.c.ux.xv> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            com.bytedance.sdk.component.xv.w.c.ux.p r7 = r10.fp
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r10.ev     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L61
            int r8 = r10.f30863r     // Catch: java.lang.Throwable -> L67
            int r0 = r8 + 2
            r10.f30863r = r0     // Catch: java.lang.Throwable -> L67
            com.bytedance.sdk.component.xv.w.c.ux.gd r9 = new com.bytedance.sdk.component.xv.w.c.ux.gd     // Catch: java.lang.Throwable -> L67
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
            if (r13 == 0) goto L2e
            long r0 = r10.f30860k     // Catch: java.lang.Throwable -> L67
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L2e
            long r0 = r9.f30840w     // Catch: java.lang.Throwable -> L67
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L2c
            goto L2e
        L2c:
            r13 = 0
            goto L2f
        L2e:
            r13 = 1
        L2f:
            boolean r0 = r9.w()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L3e
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.xv.w.c.ux.gd> r0 = r10.sr     // Catch: java.lang.Throwable -> L67
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L67
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L67
        L3e:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            if (r11 != 0) goto L47
            com.bytedance.sdk.component.xv.w.c.ux.p r0 = r10.fp     // Catch: java.lang.Throwable -> L6a
            r0.c(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L6a
            goto L50
        L47:
            boolean r0 = r10.f30867w     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L59
            com.bytedance.sdk.component.xv.w.c.ux.p r0 = r10.fp     // Catch: java.lang.Throwable -> L6a
            r0.c(r11, r8, r12)     // Catch: java.lang.Throwable -> L6a
        L50:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            if (r13 == 0) goto L58
            com.bytedance.sdk.component.xv.w.c.ux.p r11 = r10.fp
            r11.w()
        L58:
            return r9
        L59:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L6a
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L6a
            throw r11     // Catch: java.lang.Throwable -> L6a
        L61:
            com.bytedance.sdk.component.xv.w.c.ux.c r11 = new com.bytedance.sdk.component.xv.w.c.ux.c     // Catch: java.lang.Throwable -> L67
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.c.ux.r.w(int, java.util.List, boolean):com.bytedance.sdk.component.xv.w.c.ux.gd");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.fp.xv());
        r6 = r3;
        r8.f30860k -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r9, boolean r10, com.bytedance.sdk.component.xv.c.xv r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            com.bytedance.sdk.component.xv.w.c.ux.p r12 = r8.fp
            r12.c(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.f30860k     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.xv.w.c.ux.gd> r3 = r8.sr     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
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
            com.bytedance.sdk.component.xv.w.c.ux.p r3 = r8.fp     // Catch: java.lang.Throwable -> L56
            int r3 = r3.xv()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f30860k     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f30860k = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            com.bytedance.sdk.component.xv.w.c.ux.p r4 = r8.fp
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.c(r5, r9, r11, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.c.ux.r.c(int, boolean, com.bytedance.sdk.component.xv.c.xv, long):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class xv extends com.bytedance.sdk.component.xv.w.c.w implements ev.w {

        /* renamed from: c  reason: collision with root package name */
        final ev f30882c;

        xv(ev evVar) {
            super("OkHttp %s", r.this.ux);
            this.f30882c = evVar;
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c() {
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(int i4, int i5, int i6, boolean z3) {
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(boolean z3, int i4, com.bytedance.sdk.component.xv.c.ux uxVar, int i5) throws IOException {
            if (r.this.sr(i4)) {
                r.this.c(i4, uxVar, i5, z3);
                return;
            }
            gd c4 = r.this.c(i4);
            if (c4 == null) {
                r.this.c(i4, com.bytedance.sdk.component.xv.w.c.ux.w.PROTOCOL_ERROR);
                uxVar.ev(i5);
                return;
            }
            c4.c(uxVar, i5);
            if (z3) {
                c4.gd();
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.w
        protected void xv() {
            com.bytedance.sdk.component.xv.w.c.ux.w wVar;
            r rVar;
            com.bytedance.sdk.component.xv.w.c.ux.w wVar2 = com.bytedance.sdk.component.xv.w.c.ux.w.INTERNAL_ERROR;
            try {
                try {
                    this.f30882c.c(this);
                    while (this.f30882c.c(false, (ev.w) this)) {
                    }
                } catch (IOException unused) {
                } catch (NullPointerException unused2) {
                } catch (Throwable th) {
                    th = th;
                    try {
                        r.this.c(wVar2, wVar2);
                    } catch (Exception unused3) {
                    }
                    com.bytedance.sdk.component.xv.w.c.xv.c(this.f30882c);
                    throw th;
                }
                try {
                    r.this.c(com.bytedance.sdk.component.xv.w.c.ux.w.NO_ERROR, com.bytedance.sdk.component.xv.w.c.ux.w.CANCEL);
                } catch (IOException unused4) {
                    wVar = com.bytedance.sdk.component.xv.w.c.ux.w.PROTOCOL_ERROR;
                    rVar = r.this;
                    rVar.c(wVar, wVar);
                    com.bytedance.sdk.component.xv.w.c.xv.c(this.f30882c);
                } catch (NullPointerException unused5) {
                    wVar = com.bytedance.sdk.component.xv.w.c.ux.w.PROTOCOL_ERROR;
                    rVar = r.this;
                    rVar.c(wVar, wVar);
                    com.bytedance.sdk.component.xv.w.c.xv.c(this.f30882c);
                }
                com.bytedance.sdk.component.xv.w.c.xv.c(this.f30882c);
            } catch (Throwable th2) {
                th = th2;
                r.this.c(wVar2, wVar2);
                com.bytedance.sdk.component.xv.w.c.xv.c(this.f30882c);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(boolean z3, int i4, int i5, List<com.bytedance.sdk.component.xv.w.c.ux.xv> list) {
            if (r.this.sr(i4)) {
                r.this.c(i4, list, z3);
                return;
            }
            synchronized (r.this) {
                gd c4 = r.this.c(i4);
                if (c4 == null) {
                    r rVar = r.this;
                    if (rVar.ev) {
                        return;
                    }
                    if (i4 <= rVar.f30858f) {
                        return;
                    }
                    if (i4 % 2 == rVar.f30863r % 2) {
                        return;
                    }
                    final gd gdVar = new gd(i4, r.this, false, z3, list);
                    r rVar2 = r.this;
                    rVar2.f30858f = i4;
                    rVar2.sr.put(Integer.valueOf(i4), gdVar);
                    try {
                        r.f30856c.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s stream %d", new Object[]{r.this.ux, Integer.valueOf(i4)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.xv.1
                            @Override // com.bytedance.sdk.component.xv.w.c.w
                            public void xv() {
                                try {
                                    r.this.xv.c(gdVar);
                                } catch (IOException e4) {
                                    com.bytedance.sdk.component.xv.w.c.r.ux w3 = com.bytedance.sdk.component.xv.w.c.r.ux.w();
                                    w3.c(4, "Http2Connection.Listener failure for " + r.this.ux, e4);
                                    try {
                                        gdVar.c(com.bytedance.sdk.component.xv.w.c.ux.w.PROTOCOL_ERROR);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                    return;
                }
                c4.c(list);
                if (z3) {
                    c4.gd();
                }
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(int i4, com.bytedance.sdk.component.xv.w.c.ux.w wVar) {
            if (r.this.sr(i4)) {
                r.this.xv(i4, wVar);
                return;
            }
            gd w3 = r.this.w(i4);
            if (w3 != null) {
                w3.xv(wVar);
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(boolean z3, t tVar) {
            gd[] gdVarArr;
            long j4;
            int i4;
            synchronized (r.this) {
                int sr = r.this.bk.sr();
                if (z3) {
                    r.this.bk.c();
                }
                r.this.bk.c(tVar);
                c(tVar);
                int sr2 = r.this.bk.sr();
                gdVarArr = null;
                if (sr2 == -1 || sr2 == sr) {
                    j4 = 0;
                } else {
                    j4 = sr2 - sr;
                    r rVar = r.this;
                    if (!rVar.f30865t) {
                        rVar.c(j4);
                        r.this.f30865t = true;
                    }
                    if (!r.this.sr.isEmpty()) {
                        gdVarArr = (gd[]) r.this.sr.values().toArray(new gd[r.this.sr.size()]);
                    }
                }
                try {
                    r.f30856c.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s settings", r.this.ux) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.xv.2
                        @Override // com.bytedance.sdk.component.xv.w.c.w
                        public void xv() {
                            r rVar2 = r.this;
                            rVar2.xv.c(rVar2);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            if (gdVarArr == null || j4 == 0) {
                return;
            }
            for (gd gdVar : gdVarArr) {
                synchronized (gdVar) {
                    gdVar.c(j4);
                }
            }
        }

        private void c(final t tVar) {
            try {
                r.f30856c.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s ACK Settings", new Object[]{r.this.ux}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.xv.3
                    @Override // com.bytedance.sdk.component.xv.w.c.w
                    public void xv() {
                        try {
                            r.this.fp.c(tVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(boolean z3, int i4, int i5) {
            if (z3) {
                a xv = r.this.xv(i4);
                if (xv != null) {
                    xv.w();
                    return;
                }
                return;
            }
            r.this.c(true, i4, i5, (a) null);
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(int i4, com.bytedance.sdk.component.xv.w.c.ux.w wVar, com.bytedance.sdk.component.xv.c.f fVar) {
            gd[] gdVarArr;
            fVar.r();
            synchronized (r.this) {
                gdVarArr = (gd[]) r.this.sr.values().toArray(new gd[r.this.sr.size()]);
                r.this.ev = true;
            }
            for (gd gdVar : gdVarArr) {
                if (gdVar.c() > i4 && gdVar.xv()) {
                    gdVar.xv(com.bytedance.sdk.component.xv.w.c.ux.w.REFUSED_STREAM);
                    r.this.w(gdVar.c());
                }
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(int i4, long j4) {
            if (i4 == 0) {
                synchronized (r.this) {
                    r rVar = r.this;
                    rVar.f30860k += j4;
                    rVar.notifyAll();
                }
                return;
            }
            gd c4 = r.this.c(i4);
            if (c4 != null) {
                synchronized (c4) {
                    c4.c(j4);
                }
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.ux.ev.w
        public void c(int i4, int i5, List<com.bytedance.sdk.component.xv.w.c.ux.xv> list) {
            r.this.c(i5, list);
        }
    }

    void c(long j4) {
        this.f30860k += j4;
        if (j4 > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final int i4, final com.bytedance.sdk.component.xv.w.c.ux.w wVar) {
        try {
            f30856c.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s stream %d", new Object[]{this.ux, Integer.valueOf(i4)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.1
                @Override // com.bytedance.sdk.component.xv.w.c.w
                public void xv() {
                    try {
                        r.this.w(i4, wVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final int i4, final long j4) {
        try {
            f30856c.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp Window Update %s stream %d", new Object[]{this.ux, Integer.valueOf(i4)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.2
                @Override // com.bytedance.sdk.component.xv.w.c.w
                public void xv() {
                    try {
                        r.this.fp.c(i4, j4);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void c(final boolean z3, final int i4, final int i5, final a aVar) {
        try {
            f30856c.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s ping %08x%08x", new Object[]{this.ux, Integer.valueOf(i4), Integer.valueOf(i5)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.3
                @Override // com.bytedance.sdk.component.xv.w.c.w
                public void xv() {
                    try {
                        r.this.w(z3, i4, i5, aVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i4, com.bytedance.sdk.component.xv.w.c.ux.w wVar) throws IOException {
        this.fp.c(i4, wVar);
    }

    public void c(com.bytedance.sdk.component.xv.w.c.ux.w wVar) throws IOException {
        synchronized (this.fp) {
            synchronized (this) {
                if (this.ev) {
                    return;
                }
                this.ev = true;
                this.fp.c(this.f30858f, wVar, com.bytedance.sdk.component.xv.w.c.xv.f30940c);
            }
        }
    }

    void w(boolean z3, int i4, int i5, a aVar) throws IOException {
        synchronized (this.fp) {
            if (aVar != null) {
                aVar.c();
            }
            this.fp.c(z3, i4, i5);
        }
    }

    public void w() throws IOException {
        this.fp.w();
    }

    void c(com.bytedance.sdk.component.xv.w.c.ux.w wVar, com.bytedance.sdk.component.xv.w.c.ux.w wVar2) throws IOException {
        gd[] gdVarArr;
        if (!fz && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        a[] aVarArr = null;
        try {
            c(wVar);
            e = null;
        } catch (IOException e4) {
            e = e4;
        }
        synchronized (this) {
            if (this.sr.isEmpty()) {
                gdVarArr = null;
            } else {
                gdVarArr = (gd[]) this.sr.values().toArray(new gd[this.sr.size()]);
                this.sr.clear();
            }
            Map<Integer, a> map = this.f30859i;
            if (map != null) {
                this.f30859i = null;
                aVarArr = (a[]) map.values().toArray(new a[this.f30859i.size()]);
            }
        }
        if (gdVarArr != null) {
            for (gd gdVar : gdVarArr) {
                try {
                    gdVar.c(wVar2);
                } catch (IOException e5) {
                    if (e != null) {
                        e = e5;
                    }
                }
            }
        }
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.xv();
            }
        }
        try {
            this.fp.close();
        } catch (IOException e6) {
            if (e == null) {
                e = e6;
            }
        }
        try {
            this.ys.close();
        } catch (IOException e7) {
            e = e7;
        }
        if (e != null) {
            throw e;
        }
    }

    void c(boolean z3) throws IOException {
        if (z3) {
            this.fp.c();
            this.fp.w(this.f30857a);
            int sr = this.f30857a.sr();
            if (sr != 65535) {
                this.fp.c(0, sr - 65535);
            }
        }
        com.bytedance.sdk.component.gd.sr.xv xvVar = new com.bytedance.sdk.component.gd.sr.xv(this.ia, "Http2Connection");
        xvVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        xvVar.start();
    }

    void c(final int i4, final List<com.bytedance.sdk.component.xv.w.c.ux.xv> list) {
        synchronized (this) {
            if (this.f30864s.contains(Integer.valueOf(i4))) {
                c(i4, com.bytedance.sdk.component.xv.w.c.ux.w.PROTOCOL_ERROR);
                return;
            }
            this.f30864s.add(Integer.valueOf(i4));
            this.f30866u.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s Push Request[%s]", new Object[]{this.ux, Integer.valueOf(i4)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.4
                @Override // com.bytedance.sdk.component.xv.w.c.w
                public void xv() {
                    if (r.this.gd.c(i4, list)) {
                        try {
                            r.this.fp.c(i4, com.bytedance.sdk.component.xv.w.c.ux.w.CANCEL);
                            synchronized (r.this) {
                                r.this.f30864s.remove(Integer.valueOf(i4));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    void c(final int i4, final List<com.bytedance.sdk.component.xv.w.c.ux.xv> list, final boolean z3) {
        this.f30866u.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s Push Headers[%s]", new Object[]{this.ux, Integer.valueOf(i4)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.5
            @Override // com.bytedance.sdk.component.xv.w.c.w
            public void xv() {
                boolean c4 = r.this.gd.c(i4, list, z3);
                if (c4) {
                    try {
                        r.this.fp.c(i4, com.bytedance.sdk.component.xv.w.c.ux.w.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (c4 || z3) {
                    synchronized (r.this) {
                        r.this.f30864s.remove(Integer.valueOf(i4));
                    }
                }
            }
        });
    }

    void c(final int i4, com.bytedance.sdk.component.xv.c.ux uxVar, final int i5, final boolean z3) throws IOException {
        final com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
        long j4 = i5;
        uxVar.c(j4);
        uxVar.c(xvVar, j4);
        if (xvVar.w() == j4) {
            this.f30866u.execute(new com.bytedance.sdk.component.xv.w.c.w("OkHttp %s Push Data[%s]", new Object[]{this.ux, Integer.valueOf(i4)}) { // from class: com.bytedance.sdk.component.xv.w.c.ux.r.6
                @Override // com.bytedance.sdk.component.xv.w.c.w
                public void xv() {
                    try {
                        boolean c4 = r.this.gd.c(i4, xvVar, i5, z3);
                        if (c4) {
                            r.this.fp.c(i4, com.bytedance.sdk.component.xv.w.c.ux.w.CANCEL);
                        }
                        if (c4 || z3) {
                            synchronized (r.this) {
                                r.this.f30864s.remove(Integer.valueOf(i4));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(xvVar.w() + " != " + i5);
    }
}
