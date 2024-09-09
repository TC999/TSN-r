package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Http2Stream.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class i {

    /* renamed from: l  reason: collision with root package name */
    static final /* synthetic */ boolean f1153l = true;

    /* renamed from: b  reason: collision with root package name */
    long f1155b;

    /* renamed from: c  reason: collision with root package name */
    final int f1156c;

    /* renamed from: d  reason: collision with root package name */
    final g f1157d;

    /* renamed from: e  reason: collision with root package name */
    private List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> f1158e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1159f;

    /* renamed from: g  reason: collision with root package name */
    private final b f1160g;

    /* renamed from: h  reason: collision with root package name */
    final a f1161h;

    /* renamed from: a  reason: collision with root package name */
    long f1154a = 0;

    /* renamed from: i  reason: collision with root package name */
    final c f1162i = new c();

    /* renamed from: j  reason: collision with root package name */
    final c f1163j = new c();

    /* renamed from: k  reason: collision with root package name */
    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f1164k = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public final class a implements r {

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ boolean f1165e = true;

        /* renamed from: a  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1166a = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();

        /* renamed from: b  reason: collision with root package name */
        boolean f1167b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1168c;

        a() {
        }

        private void a(boolean z3) throws IOException {
            i iVar;
            long min;
            i iVar2;
            synchronized (i.this) {
                i.this.f1163j.g();
                while (true) {
                    iVar = i.this;
                    if (iVar.f1155b > 0 || this.f1168c || this.f1167b || iVar.f1164k != null) {
                        break;
                    }
                    iVar.k();
                }
                iVar.f1163j.k();
                i.this.b();
                min = Math.min(i.this.f1155b, this.f1166a.f());
                iVar2 = i.this;
                iVar2.f1155b -= min;
            }
            iVar2.f1163j.g();
            try {
                i iVar3 = i.this;
                iVar3.f1157d.a(iVar3.f1156c, z3 && min == this.f1166a.f(), this.f1166a, min);
            } finally {
                i.this.f1163j.k();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            if (!f1165e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f1166a.b(cVar, j4);
            while (this.f1166a.f() >= 16384) {
                a(false);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f1165e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.f1167b) {
                    return;
                }
                if (!i.this.f1161h.f1168c) {
                    if (this.f1166a.f() > 0) {
                        while (this.f1166a.f() > 0) {
                            a(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f1157d.a(iVar.f1156c, true, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f1167b = true;
                }
                i.this.f1157d.flush();
                i.this.a();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            if (!f1165e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.b();
            }
            while (this.f1166a.f() > 0) {
                a(false);
                i.this.f1157d.flush();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t t() {
            return i.this.f1163j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Stream.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a {
        c() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        protected void i() {
            i.this.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
        }

        public void k() throws IOException {
            if (h()) {
                throw b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i4, g gVar, boolean z3, boolean z4, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f1156c = i4;
            this.f1157d = gVar;
            this.f1155b = gVar.f1095n.c();
            b bVar = new b(gVar.f1094m.c());
            this.f1160g = bVar;
            a aVar = new a();
            this.f1161h = aVar;
            bVar.f1175e = z4;
            aVar.f1168c = z3;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        if (d(bVar)) {
            this.f1157d.b(this.f1156c, bVar);
        }
    }

    public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        if (d(bVar)) {
            this.f1157d.c(this.f1156c, bVar);
        }
    }

    public int c() {
        return this.f1156c;
    }

    public r d() {
        synchronized (this) {
            if (!this.f1159f && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f1161h;
    }

    public s e() {
        return this.f1160g;
    }

    public boolean f() {
        return this.f1157d.f1082a == ((this.f1156c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.f1164k != null) {
            return false;
        }
        b bVar = this.f1160g;
        if (bVar.f1175e || bVar.f1174d) {
            a aVar = this.f1161h;
            if (aVar.f1168c || aVar.f1167b) {
                if (this.f1159f) {
                    return false;
                }
            }
        }
        return true;
    }

    public t h() {
        return this.f1162i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean g4;
        if (!f1153l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f1160g.f1175e = true;
            g4 = g();
            notifyAll();
        }
        if (g4) {
            return;
        }
        this.f1157d.d(this.f1156c);
    }

    public synchronized List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> j() throws IOException {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list;
        if (f()) {
            this.f1162i.g();
            while (this.f1158e == null && this.f1164k == null) {
                k();
            }
            this.f1162i.k();
            list = this.f1158e;
            if (list != null) {
                this.f1158e = null;
            } else {
                throw new o(this.f1164k);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public t l() {
        return this.f1163j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        if (this.f1164k == null) {
            this.f1164k = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        boolean z3;
        if (!f1153l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z3 = true;
            this.f1159f = true;
            if (this.f1158e == null) {
                this.f1158e = list;
                z3 = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f1158e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f1158e = arrayList;
            }
        }
        if (z3) {
            return;
        }
        this.f1157d.d(this.f1156c);
    }

    void b() throws IOException {
        a aVar = this.f1161h;
        if (!aVar.f1167b) {
            if (!aVar.f1168c) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar = this.f1164k;
                if (bVar != null) {
                    throw new o(bVar);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    private boolean d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        if (f1153l || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f1164k != null) {
                    return false;
                }
                if (this.f1160g.f1175e && this.f1161h.f1168c) {
                    return false;
                }
                this.f1164k = bVar;
                notifyAll();
                this.f1157d.d(this.f1156c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i4) throws IOException {
        if (!f1153l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f1160g.a(eVar, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http2Stream.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public final class b implements s {

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ boolean f1170g = true;

        /* renamed from: a  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1171a = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();

        /* renamed from: b  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1172b = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();

        /* renamed from: c  reason: collision with root package name */
        private final long f1173c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1174d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1175e;

        b(long j4) {
            this.f1173c = j4;
        }

        private void b() throws IOException {
            i.this.f1162i.g();
            while (this.f1172b.f() == 0 && !this.f1175e && !this.f1174d) {
                try {
                    i iVar = i.this;
                    if (iVar.f1164k != null) {
                        break;
                    }
                    iVar.k();
                } finally {
                    i.this.f1162i.k();
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            if (j4 >= 0) {
                synchronized (i.this) {
                    b();
                    a();
                    if (this.f1172b.f() == 0) {
                        return -1L;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar2 = this.f1172b;
                    long a4 = cVar2.a(cVar, Math.min(j4, cVar2.f()));
                    i iVar = i.this;
                    long j5 = iVar.f1154a + a4;
                    iVar.f1154a = j5;
                    if (j5 >= iVar.f1157d.f1094m.c() / 2) {
                        i iVar2 = i.this;
                        iVar2.f1157d.a(iVar2.f1156c, iVar2.f1154a);
                        i.this.f1154a = 0L;
                    }
                    synchronized (i.this.f1157d) {
                        g gVar = i.this.f1157d;
                        long j6 = gVar.f1092k + a4;
                        gVar.f1092k = j6;
                        if (j6 >= gVar.f1094m.c() / 2) {
                            g gVar2 = i.this.f1157d;
                            gVar2.a(0, gVar2.f1092k);
                            i.this.f1157d.f1092k = 0L;
                        }
                    }
                    return a4;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f1174d = true;
                this.f1172b.a();
                i.this.notifyAll();
            }
            i.this.a();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t t() {
            return i.this.f1162i;
        }

        void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, long j4) throws IOException {
            boolean z3;
            boolean z4;
            boolean z5;
            if (!f1170g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j4 > 0) {
                synchronized (i.this) {
                    z3 = this.f1175e;
                    z4 = true;
                    z5 = this.f1172b.f() + j4 > this.f1173c;
                }
                if (z5) {
                    eVar.skip(j4);
                    i.this.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z3) {
                    eVar.skip(j4);
                    return;
                } else {
                    long a4 = eVar.a(this.f1171a, j4);
                    if (a4 != -1) {
                        j4 -= a4;
                        synchronized (i.this) {
                            if (this.f1172b.f() != 0) {
                                z4 = false;
                            }
                            this.f1172b.a(this.f1171a);
                            if (z4) {
                                i.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        private void a() throws IOException {
            if (!this.f1174d) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar = i.this.f1164k;
                if (bVar != null) {
                    throw new o(bVar);
                }
                return;
            }
            throw new IOException("stream closed");
        }
    }

    void a() throws IOException {
        boolean z3;
        boolean g4;
        if (!f1153l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            b bVar = this.f1160g;
            if (!bVar.f1175e && bVar.f1174d) {
                a aVar = this.f1161h;
                if (aVar.f1168c || aVar.f1167b) {
                    z3 = true;
                    g4 = g();
                }
            }
            z3 = false;
            g4 = g();
        }
        if (z3) {
            a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
        } else if (g4) {
        } else {
            this.f1157d.d(this.f1156c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j4) {
        this.f1155b += j4;
        if (j4 > 0) {
            notifyAll();
        }
    }
}
