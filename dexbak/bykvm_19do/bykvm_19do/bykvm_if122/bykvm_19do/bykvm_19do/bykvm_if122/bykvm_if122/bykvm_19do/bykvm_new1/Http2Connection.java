package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import android.os.SystemClock;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform;
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

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Http2Connection implements Closeable {

    /* renamed from: a */
    final boolean f1089a;

    /* renamed from: b */
    final AbstractC1044i f1090b;

    /* renamed from: d */
    final String f1092d;

    /* renamed from: e */
    int f1093e;

    /* renamed from: f */
    int f1094f;

    /* renamed from: g */
    boolean f1095g;

    /* renamed from: h */
    private final ExecutorService f1096h;

    /* renamed from: i */
    private Map<Integer, Ping> f1097i;

    /* renamed from: j */
    final PushObserver f1098j;

    /* renamed from: l */
    long f1100l;

    /* renamed from: n */
    final Settings f1102n;

    /* renamed from: o */
    boolean f1103o;

    /* renamed from: p */
    final Socket f1104p;

    /* renamed from: q */
    final Http2Writer f1105q;

    /* renamed from: r */
    final C1046j f1106r;

    /* renamed from: s */
    final Set<Integer> f1107s;

    /* renamed from: u */
    static final /* synthetic */ boolean f1088u = true;

    /* renamed from: t */
    static final ExecutorService f1087t = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1061c.m58465a("OkHttp Http2Connection", true));

    /* renamed from: c */
    final Map<Integer, Http2Stream> f1091c = new LinkedHashMap();

    /* renamed from: k */
    long f1099k = 0;

    /* renamed from: m */
    Settings f1101m = new Settings();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1036a extends NamedRunnable {

        /* renamed from: b */
        final /* synthetic */ int f1108b;

        /* renamed from: c */
        final /* synthetic */ ErrorCode f1109c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1036a(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f1108b = i;
            this.f1109c = errorCode;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        public void mo58214b() {
            try {
                Http2Connection.this.m58620b(this.f1108b, this.f1109c);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1037b extends NamedRunnable {

        /* renamed from: b */
        final /* synthetic */ int f1111b;

        /* renamed from: c */
        final /* synthetic */ long f1112c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1037b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f1111b = i;
            this.f1112c = j;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        public void mo58214b() {
            try {
                Http2Connection.this.f1105q.m58547a(this.f1111b, this.f1112c);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1038c extends NamedRunnable {

        /* renamed from: b */
        final /* synthetic */ boolean f1114b;

        /* renamed from: c */
        final /* synthetic */ int f1115c;

        /* renamed from: d */
        final /* synthetic */ int f1116d;

        /* renamed from: e */
        final /* synthetic */ Ping f1117e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1038c(String str, Object[] objArr, boolean z, int i, int i2, Ping ping) {
            super(str, objArr);
            this.f1114b = z;
            this.f1115c = i;
            this.f1116d = i2;
            this.f1117e = ping;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        public void mo58214b() {
            try {
                Http2Connection.this.m58623a(this.f1114b, this.f1115c, this.f1116d, this.f1117e);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1039d extends NamedRunnable {

        /* renamed from: b */
        final /* synthetic */ int f1119b;

        /* renamed from: c */
        final /* synthetic */ List f1120c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1039d(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f1119b = i;
            this.f1120c = list;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        public void mo58214b() {
            if (Http2Connection.this.f1098j.mo58524a(this.f1119b, this.f1120c)) {
                try {
                    Http2Connection.this.f1105q.m58546a(this.f1119b, ErrorCode.CANCEL);
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f1107s.remove(Integer.valueOf(this.f1119b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1040e extends NamedRunnable {

        /* renamed from: b */
        final /* synthetic */ int f1122b;

        /* renamed from: c */
        final /* synthetic */ List f1123c;

        /* renamed from: d */
        final /* synthetic */ boolean f1124d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1040e(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f1122b = i;
            this.f1123c = list;
            this.f1124d = z;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        public void mo58214b() {
            boolean mo58523a = Http2Connection.this.f1098j.mo58523a(this.f1122b, this.f1123c, this.f1124d);
            if (mo58523a) {
                try {
                    Http2Connection.this.f1105q.m58546a(this.f1122b, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (mo58523a || this.f1124d) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f1107s.remove(Integer.valueOf(this.f1122b));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$f */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1041f extends NamedRunnable {

        /* renamed from: b */
        final /* synthetic */ int f1126b;

        /* renamed from: c */
        final /* synthetic */ Buffer f1127c;

        /* renamed from: d */
        final /* synthetic */ int f1128d;

        /* renamed from: e */
        final /* synthetic */ boolean f1129e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1041f(String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
            super(str, objArr);
            this.f1126b = i;
            this.f1127c = buffer;
            this.f1128d = i2;
            this.f1129e = z;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        public void mo58214b() {
            try {
                boolean mo58526a = Http2Connection.this.f1098j.mo58526a(this.f1126b, this.f1127c, this.f1128d, this.f1129e);
                if (mo58526a) {
                    Http2Connection.this.f1105q.m58546a(this.f1126b, ErrorCode.CANCEL);
                }
                if (mo58526a || this.f1129e) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f1107s.remove(Integer.valueOf(this.f1126b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$g */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1042g extends NamedRunnable {

        /* renamed from: b */
        final /* synthetic */ int f1131b;

        /* renamed from: c */
        final /* synthetic */ ErrorCode f1132c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1042g(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.f1131b = i;
            this.f1132c = errorCode;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        public void mo58214b() {
            Http2Connection.this.f1098j.mo58525a(this.f1131b, this.f1132c);
            synchronized (Http2Connection.this) {
                Http2Connection.this.f1107s.remove(Integer.valueOf(this.f1131b));
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$i */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static abstract class AbstractC1044i {

        /* renamed from: a */
        public static final AbstractC1044i f1141a = new C1045a();

        /* compiled from: Http2Connection.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$i$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        static class C1045a extends AbstractC1044i {
            C1045a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Connection.AbstractC1044i
            /* renamed from: a */
            public void mo58609a(Http2Stream http2Stream) throws IOException {
                http2Stream.m58578a(ErrorCode.REFUSED_STREAM);
            }
        }

        /* renamed from: a */
        public void mo58610a(Http2Connection http2Connection) {
        }

        /* renamed from: a */
        public abstract void mo58609a(Http2Stream http2Stream) throws IOException;
    }

    Http2Connection(C1043h c1043h) {
        Settings settings = new Settings();
        this.f1102n = settings;
        this.f1103o = false;
        this.f1107s = new LinkedHashSet();
        this.f1098j = c1043h.f1139f;
        boolean z = c1043h.f1140g;
        this.f1089a = z;
        this.f1090b = c1043h.f1138e;
        int i = z ? 1 : 2;
        this.f1094f = i;
        if (z) {
            this.f1094f = i + 2;
        }
        if (z) {
            this.f1101m.m58520a(7, 16777216);
        }
        String str = c1043h.f1135b;
        this.f1092d = str;
        this.f1096h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C1061c.m58465a(C1061c.m58464a("OkHttp %s Push Observer", str), true));
        settings.m58520a(7, 65535);
        settings.m58520a(5, 16384);
        this.f1100l = settings.m58516c();
        this.f1104p = c1043h.f1134a;
        this.f1105q = new Http2Writer(c1043h.f1137d, z);
        this.f1106r = new C1046j(new Http2Reader(c1043h.f1136c, z));
    }

    /* renamed from: a */
    synchronized Http2Stream m58635a(int i) {
        return this.f1091c.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    public synchronized int m58622b() {
        return this.f1102n.m58517b(Integer.MAX_VALUE);
    }

    /* renamed from: b */
    boolean m58621b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m58615c(int i, ErrorCode errorCode) {
        f1087t.execute(new C1036a("OkHttp %s stream %d", new Object[]{this.f1092d, Integer.valueOf(i)}, i, errorCode));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m58626a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized Http2Stream m58614d(int i) {
        Http2Stream remove;
        remove = this.f1091c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public void flush() throws IOException {
        this.f1105q.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:4:0x0005, B:21:0x0041, B:25:0x0050, B:22:0x0047, B:24:0x004b, B:29:0x0059, B:30:0x0060, B:5:0x0006, B:7:0x000a, B:9:0x001d, B:11:0x0025, B:16:0x002f, B:18:0x0035, B:19:0x003e, B:31:0x0061, B:32:0x0066), top: B:39:0x0005 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Stream m58619b(int r11, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r7 = r10.f1105q
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L6a
            boolean r0 = r10.f1095g     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L61
            int r8 = r10.f1094f     // Catch: java.lang.Throwable -> L67
            int r0 = r8 + 2
            r10.f1094f = r0     // Catch: java.lang.Throwable -> L67
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i r9 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i     // Catch: java.lang.Throwable -> L67
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
            if (r13 == 0) goto L2e
            long r0 = r10.f1100l     // Catch: java.lang.Throwable -> L67
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L2e
            long r0 = r9.f1162b     // Catch: java.lang.Throwable -> L67
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L2c
            goto L2e
        L2c:
            r13 = 0
            goto L2f
        L2e:
            r13 = 1
        L2f:
            boolean r0 = r9.m58568g()     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L3e
            java.util.Map<java.lang.Integer, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> r0 = r10.f1091c     // Catch: java.lang.Throwable -> L67
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L67
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L67
        L3e:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L67
            if (r11 != 0) goto L47
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r0 = r10.f1105q     // Catch: java.lang.Throwable -> L6a
            r0.m58541a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L6a
            goto L50
        L47:
            boolean r0 = r10.f1089a     // Catch: java.lang.Throwable -> L6a
            if (r0 != 0) goto L59
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r0 = r10.f1105q     // Catch: java.lang.Throwable -> L6a
            r0.m58548a(r11, r8, r12)     // Catch: java.lang.Throwable -> L6a
        L50:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L6a
            if (r13 == 0) goto L58
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r11 = r10.f1105q
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Connection.m58619b(int, java.util.List, boolean):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i");
    }

    /* renamed from: a */
    public Http2Stream m58625a(List<Header> list, boolean z) throws IOException {
        return m58619b(0, list, z);
    }

    /* renamed from: c */
    synchronized Ping m58616c(int i) {
        Map<Integer, Ping> map;
        map = this.f1097i;
        return map != null ? map.remove(Integer.valueOf(i)) : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f1105q.m58538b());
        r6 = r3;
        r8.f1100l -= r6;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m58629a(int r9, boolean r10, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r12 = r8.f1105q
            r12.m58540a(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.f1100l     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i> r3 = r8.f1091c     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r3 = r8.f1105q     // Catch: java.lang.Throwable -> L56
            int r3 = r3.m58538b()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f1100l     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f1100l = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.j r4 = r8.f1105q
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.m58540a(r5, r9, r11, r3)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Connection.m58629a(int, boolean, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c, long):void");
    }

    /* renamed from: c */
    public void m58617c() throws IOException {
        m58624a(true);
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$h */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1043h {

        /* renamed from: a */
        Socket f1134a;

        /* renamed from: b */
        String f1135b;

        /* renamed from: c */
        BufferedSource f1136c;

        /* renamed from: d */
        BufferedSink f1137d;

        /* renamed from: e */
        AbstractC1044i f1138e = AbstractC1044i.f1141a;

        /* renamed from: f */
        PushObserver f1139f = PushObserver.f1202a;

        /* renamed from: g */
        boolean f1140g;

        public C1043h(boolean z) {
            this.f1140g = z;
        }

        /* renamed from: a */
        public C1043h m58611a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f1134a = socket;
            this.f1135b = str;
            this.f1136c = bufferedSource;
            this.f1137d = bufferedSink;
            return this;
        }

        /* renamed from: a */
        public C1043h m58612a(AbstractC1044i abstractC1044i) {
            this.f1138e = abstractC1044i;
            return this;
        }

        /* renamed from: a */
        public Http2Connection m58613a() {
            return new Http2Connection(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$j */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1046j extends NamedRunnable implements Http2Reader.InterfaceC1051b {

        /* renamed from: b */
        final Http2Reader f1142b;

        /* compiled from: Http2Connection.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$j$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class C1047a extends NamedRunnable {

            /* renamed from: b */
            final /* synthetic */ Http2Stream f1144b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1047a(String str, Object[] objArr, Http2Stream http2Stream) {
                super(str, objArr);
                this.f1144b = http2Stream;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
            /* renamed from: b */
            public void mo58214b() {
                try {
                    Http2Connection.this.f1090b.mo58609a(this.f1144b);
                } catch (IOException e) {
                    Platform m58485b = Platform.m58485b();
                    m58485b.mo58493a(4, "Http2Connection.Listener failure for " + Http2Connection.this.f1092d, e);
                    try {
                        this.f1144b.m58578a(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$j$b */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class C1048b extends NamedRunnable {
            C1048b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
            /* renamed from: b */
            public void mo58214b() {
                Http2Connection http2Connection = Http2Connection.this;
                http2Connection.f1090b.mo58610a(http2Connection);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Http2Connection.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g$j$c */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public class C1049c extends NamedRunnable {

            /* renamed from: b */
            final /* synthetic */ Settings f1147b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1049c(String str, Object[] objArr, Settings settings) {
                super(str, objArr);
                this.f1147b = settings;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
            /* renamed from: b */
            public void mo58214b() {
                try {
                    Http2Connection.this.f1105q.m58543a(this.f1147b);
                } catch (IOException unused) {
                }
            }
        }

        C1046j(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f1092d);
            this.f1142b = http2Reader;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58591a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58590a(int i, int i2, int i3, boolean z) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58583a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.m58621b(i)) {
                Http2Connection.this.m58633a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream m58635a = Http2Connection.this.m58635a(i);
            if (m58635a == null) {
                Http2Connection.this.m58615c(i, ErrorCode.PROTOCOL_ERROR);
                bufferedSource.skip(i2);
                return;
            }
            m58635a.m58579a(bufferedSource, i2);
            if (z) {
                m58635a.m58566i();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.NamedRunnable
        /* renamed from: b */
        protected void mo58214b() {
            Throwable th;
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    this.f1142b.m58604a(this);
                    while (this.f1142b.m58601a(false, (Http2Reader.InterfaceC1051b) this)) {
                    }
                    errorCode = ErrorCode.NO_ERROR;
                } catch (IOException unused) {
                    errorCode = errorCode2;
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode2;
                    try {
                        Http2Connection.this.m58626a(errorCode, errorCode2);
                    } catch (IOException unused2) {
                    }
                    C1061c.m58475a(this.f1142b);
                    throw th;
                }
                try {
                    try {
                        Http2Connection.this.m58626a(errorCode, ErrorCode.CANCEL);
                    } catch (Throwable th3) {
                        th = th3;
                        Http2Connection.this.m58626a(errorCode, errorCode2);
                        C1061c.m58475a(this.f1142b);
                        throw th;
                    }
                } catch (IOException unused3) {
                    ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection.this.m58626a(errorCode3, errorCode3);
                    C1061c.m58475a(this.f1142b);
                }
            } catch (IOException unused4) {
            }
            C1061c.m58475a(this.f1142b);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58584a(boolean z, int i, int i2, List<Header> list) {
            if (Http2Connection.this.m58621b(i)) {
                Http2Connection.this.m58630a(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream m58635a = Http2Connection.this.m58635a(i);
                if (m58635a == null) {
                    Http2Connection http2Connection = Http2Connection.this;
                    if (http2Connection.f1095g) {
                        return;
                    }
                    if (i <= http2Connection.f1093e) {
                        return;
                    }
                    if (i % 2 == http2Connection.f1094f % 2) {
                        return;
                    }
                    Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, list);
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.f1093e = i;
                    http2Connection2.f1091c.put(Integer.valueOf(i), http2Stream);
                    Http2Connection.f1087t.execute(new C1047a("OkHttp %s stream %d", new Object[]{Http2Connection.this.f1092d, Integer.valueOf(i)}, http2Stream));
                    return;
                }
                m58635a.m58577a(list);
                if (z) {
                    m58635a.m58566i();
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58587a(int i, ErrorCode errorCode) {
            if (Http2Connection.this.m58621b(i)) {
                Http2Connection.this.m58632a(i, errorCode);
                return;
            }
            Http2Stream m58614d = Http2Connection.this.m58614d(i);
            if (m58614d != null) {
                m58614d.m58573c(errorCode);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58582a(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            int i;
            synchronized (Http2Connection.this) {
                int m58516c = Http2Connection.this.f1102n.m58516c();
                if (z) {
                    Http2Connection.this.f1102n.m58522a();
                }
                Http2Connection.this.f1102n.m58519a(settings);
                m58608a(settings);
                int m58516c2 = Http2Connection.this.f1102n.m58516c();
                http2StreamArr = null;
                if (m58516c2 == -1 || m58516c2 == m58516c) {
                    j = 0;
                } else {
                    j = m58516c2 - m58516c;
                    Http2Connection http2Connection = Http2Connection.this;
                    if (!http2Connection.f1103o) {
                        http2Connection.m58628a(j);
                        Http2Connection.this.f1103o = true;
                    }
                    if (!Http2Connection.this.f1091c.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.f1091c.values().toArray(new Http2Stream[Http2Connection.this.f1091c.size()]);
                    }
                }
                Http2Connection.f1087t.execute(new C1048b("OkHttp %s settings", Http2Connection.this.f1092d));
            }
            if (http2StreamArr == null || j == 0) {
                return;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.m58580a(j);
                }
            }
        }

        /* renamed from: a */
        private void m58608a(Settings settings) {
            Http2Connection.f1087t.execute(new C1049c("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f1092d}, settings));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58585a(boolean z, int i, int i2) {
            if (z) {
                Ping m58616c = Http2Connection.this.m58616c(i);
                if (m58616c != null) {
                    m58616c.m58528b();
                    return;
                }
                return;
            }
            Http2Connection.this.m58618b(true, i, i2, null);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58586a(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.mo58881e();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f1091c.values().toArray(new Http2Stream[Http2Connection.this.f1091c.size()]);
                Http2Connection.this.f1095g = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.m58574c() > i && http2Stream.m58569f()) {
                    http2Stream.m58573c(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.m58614d(http2Stream.m58574c());
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58588a(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.f1100l += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream m58635a = Http2Connection.this.m58635a(i);
            if (m58635a != null) {
                synchronized (m58635a) {
                    m58635a.m58580a(j);
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.Http2Reader.InterfaceC1051b
        /* renamed from: a */
        public void mo58589a(int i, int i2, List<Header> list) {
            Http2Connection.this.m58631a(i2, list);
        }
    }

    /* renamed from: a */
    void m58628a(long j) {
        this.f1100l += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58634a(int i, long j) {
        f1087t.execute(new C1037b("OkHttp Window Update %s stream %d", new Object[]{this.f1092d, Integer.valueOf(i)}, i, j));
    }

    /* renamed from: a */
    void m58623a(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.f1105q) {
            if (ping != null) {
                ping.m58527c();
            }
            this.f1105q.m58542a(z, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m58620b(int i, ErrorCode errorCode) throws IOException {
        this.f1105q.m58546a(i, errorCode);
    }

    /* renamed from: b */
    void m58618b(boolean z, int i, int i2, Ping ping) {
        f1087t.execute(new C1038c("OkHttp %s ping %08x%08x", new Object[]{this.f1092d, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, ping));
    }

    /* renamed from: a */
    public void m58627a(ErrorCode errorCode) throws IOException {
        synchronized (this.f1105q) {
            synchronized (this) {
                if (this.f1095g) {
                    return;
                }
                this.f1095g = true;
                this.f1105q.m58545a(this.f1093e, errorCode, C1061c.f1233a);
            }
        }
    }

    /* renamed from: a */
    void m58626a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr;
        if (!f1088u && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        Ping[] pingArr = null;
        try {
            m58627a(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.f1091c.isEmpty()) {
                http2StreamArr = null;
            } else {
                http2StreamArr = (Http2Stream[]) this.f1091c.values().toArray(new Http2Stream[this.f1091c.size()]);
                this.f1091c.clear();
            }
            Map<Integer, Ping> map = this.f1097i;
            if (map != null) {
                this.f1097i = null;
                pingArr = (Ping[]) map.values().toArray(new Ping[this.f1097i.size()]);
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.m58578a(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.m58529a();
            }
        }
        try {
            this.f1105q.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f1104p.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    /* renamed from: a */
    void m58624a(boolean z) throws IOException {
        if (z) {
            this.f1105q.m58551a();
            this.f1105q.m58536b(this.f1101m);
            int m58516c = this.f1101m.m58516c();
            if (m58516c != 65535) {
                this.f1105q.m58547a(0, m58516c - 65535);
            }
        }
        Thread thread = new Thread(this.f1106r);
        thread.setName("tt_pangle_thread_http2_connection" + SystemClock.uptimeMillis());
        thread.start();
    }

    /* renamed from: a */
    public synchronized boolean m58636a() {
        return this.f1095g;
    }

    /* renamed from: a */
    void m58631a(int i, List<Header> list) {
        synchronized (this) {
            if (this.f1107s.contains(Integer.valueOf(i))) {
                m58615c(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f1107s.add(Integer.valueOf(i));
            this.f1096h.execute(new C1039d("OkHttp %s Push Request[%s]", new Object[]{this.f1092d, Integer.valueOf(i)}, i, list));
        }
    }

    /* renamed from: a */
    void m58630a(int i, List<Header> list, boolean z) {
        this.f1096h.execute(new C1040e("OkHttp %s Push Headers[%s]", new Object[]{this.f1092d, Integer.valueOf(i)}, i, list, z));
    }

    /* renamed from: a */
    void m58633a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.mo58909c(j);
        bufferedSource.mo58558a(buffer, j);
        if (buffer.m58947f() == j) {
            this.f1096h.execute(new C1041f("OkHttp %s Push Data[%s]", new Object[]{this.f1092d, Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new IOException(buffer.m58947f() + " != " + i2);
    }

    /* renamed from: a */
    void m58632a(int i, ErrorCode errorCode) {
        this.f1096h.execute(new C1042g("OkHttp %s Push Reset[%s]", new Object[]{this.f1092d, Integer.valueOf(i)}, i, errorCode));
    }
}
