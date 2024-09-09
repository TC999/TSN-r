package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: Http1Codec.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class a implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c {

    /* renamed from: a  reason: collision with root package name */
    final v f1000a;

    /* renamed from: b  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g f1001b;

    /* renamed from: c  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f1002c;

    /* renamed from: d  reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f1003d;

    /* renamed from: e  reason: collision with root package name */
    int f1004e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f1005f = 262144;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public final class c implements r {

        /* renamed from: a  reason: collision with root package name */
        private final i f1010a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1011b;

        c() {
            this.f1010a = new i(a.this.f1003d.t());
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            if (this.f1011b) {
                throw new IllegalStateException("closed");
            }
            if (j4 == 0) {
                return;
            }
            a.this.f1003d.g(j4);
            a.this.f1003d.d("\r\n");
            a.this.f1003d.b(cVar, j4);
            a.this.f1003d.d("\r\n");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f1011b) {
                return;
            }
            this.f1011b = true;
            a.this.f1003d.d("0\r\n\r\n");
            a.this.a(this.f1010a);
            a.this.f1004e = 3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f1011b) {
                return;
            }
            a.this.f1003d.flush();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t t() {
            return this.f1010a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public final class e implements r {

        /* renamed from: a  reason: collision with root package name */
        private final i f1017a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1018b;

        /* renamed from: c  reason: collision with root package name */
        private long f1019c;

        e(long j4) {
            this.f1017a = new i(a.this.f1003d.t());
            this.f1019c = j4;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            if (!this.f1018b) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVar.f(), 0L, j4);
                if (j4 <= this.f1019c) {
                    a.this.f1003d.b(cVar, j4);
                    this.f1019c -= j4;
                    return;
                }
                throw new ProtocolException("expected " + this.f1019c + " bytes but received " + j4);
            }
            throw new IllegalStateException("closed");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1018b) {
                return;
            }
            this.f1018b = true;
            if (this.f1019c <= 0) {
                a.this.a(this.f1017a);
                a.this.f1004e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.f1018b) {
                return;
            }
            a.this.f1003d.flush();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t t() {
            return this.f1017a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class f extends b {

        /* renamed from: e  reason: collision with root package name */
        private long f1021e;

        f(a aVar, long j4) throws IOException {
            super();
            this.f1021e = j4;
            if (j4 == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            if (j4 >= 0) {
                if (!this.f1007b) {
                    long j5 = this.f1021e;
                    if (j5 == 0) {
                        return -1L;
                    }
                    long a4 = super.a(cVar, Math.min(j5, j4));
                    if (a4 != -1) {
                        long j6 = this.f1021e - a4;
                        this.f1021e = j6;
                        if (j6 == 0) {
                            a(true, (IOException) null);
                        }
                        return a4;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, (IOException) protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1007b) {
                return;
            }
            if (this.f1021e != 0 && !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f1007b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class g extends b {

        /* renamed from: e  reason: collision with root package name */
        private boolean f1022e;

        g(a aVar) {
            super();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            if (j4 >= 0) {
                if (!this.f1007b) {
                    if (this.f1022e) {
                        return -1L;
                    }
                    long a4 = super.a(cVar, j4);
                    if (a4 == -1) {
                        this.f1022e = true;
                        a(true, (IOException) null);
                        return -1L;
                    }
                    return a4;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1007b) {
                return;
            }
            if (!this.f1022e) {
                a(false, (IOException) null);
            }
            this.f1007b = true;
        }
    }

    public a(v vVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
        this.f1000a = vVar;
        this.f1001b = gVar;
        this.f1002c = eVar;
        this.f1003d = dVar;
    }

    private String f() throws IOException {
        String e4 = this.f1002c.e(this.f1005f);
        this.f1005f -= e4.length();
        return e4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public r a(y yVar, long j4) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return c();
        }
        if (j4 != -1) {
            return a(j4);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void b() throws IOException {
        this.f1003d.flush();
    }

    public r c() {
        if (this.f1004e == 1) {
            this.f1004e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f1004e);
    }

    public s d() throws IOException {
        if (this.f1004e == 4) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = this.f1001b;
            if (gVar != null) {
                this.f1004e = 5;
                gVar.d();
                return new g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f1004e);
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r e() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String f4 = f();
            if (f4.length() != 0) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(aVar, f4);
            } else {
                return aVar.a();
            }
        }
    }

    public s b(long j4) throws IOException {
        if (this.f1004e == 4) {
            this.f1004e = 5;
            return new f(this, j4);
        }
        throw new IllegalStateException("state: " + this.f1004e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public abstract class b implements s {

        /* renamed from: a  reason: collision with root package name */
        protected final i f1006a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f1007b;

        /* renamed from: c  reason: collision with root package name */
        protected long f1008c;

        private b() {
            this.f1006a = new i(a.this.f1002c.t());
            this.f1008c = 0L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            try {
                long a4 = a.this.f1002c.a(cVar, j4);
                if (a4 > 0) {
                    this.f1008c += a4;
                }
                return a4;
            } catch (IOException e4) {
                a(false, e4);
                throw e4;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t t() {
            return this.f1006a;
        }

        protected final void a(boolean z3, IOException iOException) throws IOException {
            a aVar = a.this;
            int i4 = aVar.f1004e;
            if (i4 == 6) {
                return;
            }
            if (i4 == 5) {
                aVar.a(this.f1006a);
                a aVar2 = a.this;
                aVar2.f1004e = 6;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = aVar2.f1001b;
                if (gVar != null) {
                    gVar.a(!z3, aVar2, this.f1008c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.f1004e);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a(y yVar) throws IOException {
        a(yVar.c(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.i.a(yVar, this.f1001b.b().a().b().type()));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public b0 a(a0 a0Var) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = this.f1001b;
        gVar.f990f.e(gVar.f989e);
        String a4 = a0Var.a("Content-Type");
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.b(a0Var)) {
            return new h(a4, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(a0Var.a("Transfer-Encoding"))) {
            return new h(a4, -1L, l.a(a(a0Var.k().g())));
        }
        long a5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a0Var);
        if (a5 != -1) {
            return new h(a4, a5, l.a(b(a5)));
        }
        return new h(a4, -1L, l.a(d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1Codec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class d extends b {

        /* renamed from: e  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s f1013e;

        /* renamed from: f  reason: collision with root package name */
        private long f1014f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1015g;

        d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s sVar) {
            super();
            this.f1014f = -1L;
            this.f1015g = true;
            this.f1013e = sVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            if (j4 >= 0) {
                if (!this.f1007b) {
                    if (this.f1015g) {
                        long j5 = this.f1014f;
                        if (j5 == 0 || j5 == -1) {
                            a();
                            if (!this.f1015g) {
                                return -1L;
                            }
                        }
                        long a4 = super.a(cVar, Math.min(j4, this.f1014f));
                        if (a4 != -1) {
                            this.f1014f -= a4;
                            return a4;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        a(false, (IOException) protocolException);
                        throw protocolException;
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1007b) {
                return;
            }
            if (this.f1015g && !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f1007b = true;
        }

        private void a() throws IOException {
            if (this.f1014f != -1) {
                a.this.f1002c.v();
            }
            try {
                this.f1014f = a.this.f1002c.y();
                String trim = a.this.f1002c.v().trim();
                if (this.f1014f >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.f1014f == 0) {
                        this.f1015g = false;
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a.this.f1000a.f(), this.f1013e, a.this.e());
                        a(true, (IOException) null);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f1014f + trim + "\"");
            } catch (NumberFormatException e4) {
                throw new ProtocolException(e4.getMessage());
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a() throws IOException {
        this.f1003d.flush();
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r rVar, String str) throws IOException {
        if (this.f1004e == 0) {
            this.f1003d.d(str).d("\r\n");
            int b4 = rVar.b();
            for (int i4 = 0; i4 < b4; i4++) {
                this.f1003d.d(rVar.a(i4)).d(": ").d(rVar.b(i4)).d("\r\n");
            }
            this.f1003d.d("\r\n");
            this.f1004e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f1004e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public a0.a a(boolean z3) throws IOException {
        int i4 = this.f1004e;
        if (i4 != 1 && i4 != 3) {
            throw new IllegalStateException("state: " + this.f1004e);
        }
        try {
            k a4 = k.a(f());
            a0.a a5 = new a0.a().a(a4.f949a).a(a4.f950b).a(a4.f951c).a(e());
            if (z3 && a4.f950b == 100) {
                return null;
            }
            this.f1004e = 4;
            return a5;
        } catch (EOFException e4) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f1001b);
            iOException.initCause(e4);
            throw iOException;
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r a(long j4) {
        if (this.f1004e == 1) {
            this.f1004e = 2;
            return new e(j4);
        }
        throw new IllegalStateException("state: " + this.f1004e);
    }

    public s a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s sVar) throws IOException {
        if (this.f1004e == 4) {
            this.f1004e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f1004e);
    }

    void a(i iVar) {
        t g4 = iVar.g();
        iVar.a(t.f839d);
        g4.a();
        g4.b();
    }
}
