package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: h */
    private static final long f792h;

    /* renamed from: i */
    private static final long f793i;

    /* renamed from: j */
    static AsyncTimeout f794j;

    /* renamed from: e */
    private boolean f795e;

    /* renamed from: f */
    private AsyncTimeout f796f;

    /* renamed from: g */
    private long f797g;

    /* compiled from: AsyncTimeout.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1010a implements Sink {

        /* renamed from: a */
        final /* synthetic */ Sink f798a;

        C1010a(Sink sink) {
            this.f798a = sink;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: b */
        public void mo58561b(Buffer buffer, long j) throws IOException {
            Util.m58867a(buffer.f805b, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                Segment segment = buffer.f804a;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += segment.f837c - segment.f836b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    segment = segment.f840f;
                }
                AsyncTimeout.this.m58971g();
                try {
                    try {
                        this.f798a.mo58561b(buffer, j2);
                        j -= j2;
                        AsyncTimeout.this.m58973a(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.m58974a(e);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.m58973a(false);
                    throw th;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            AsyncTimeout.this.m58971g();
            try {
                try {
                    this.f798a.close();
                    AsyncTimeout.this.m58973a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.m58974a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m58973a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
        public void flush() throws IOException {
            AsyncTimeout.this.m58971g();
            try {
                try {
                    this.f798a.flush();
                    AsyncTimeout.this.m58973a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.m58974a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m58973a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: t */
        public Timeout mo58560t() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f798a + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1011b implements Source {

        /* renamed from: a */
        final /* synthetic */ Source f800a;

        C1011b(Source source) {
            this.f800a = source;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            AsyncTimeout.this.m58971g();
            try {
                try {
                    long mo58558a = this.f800a.mo58558a(buffer, j);
                    AsyncTimeout.this.m58973a(true);
                    return mo58558a;
                } catch (IOException e) {
                    throw AsyncTimeout.this.m58974a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m58973a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            AsyncTimeout.this.m58971g();
            try {
                try {
                    this.f800a.close();
                    AsyncTimeout.this.m58973a(true);
                } catch (IOException e) {
                    throw AsyncTimeout.this.m58974a(e);
                }
            } catch (Throwable th) {
                AsyncTimeout.this.m58973a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: t */
        public Timeout mo58555t() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f800a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1012c extends Thread {
        C1012c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.mo58553i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.m58969j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.f794j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.f794j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.mo58553i()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L1d
            L1c:
                throw r1
            L1d:
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.C1012c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f792h = millis;
        f793i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* renamed from: a */
    private static synchronized void m58977a(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (f794j == null) {
                f794j = new AsyncTimeout();
                C1012c c1012c = new C1012c();
                c1012c.setName("tt_pangle_thread_watch_dog");
                c1012c.start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.f797g = Math.min(j, asyncTimeout.mo58874c() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.f797g = j + nanoTime;
            } else if (z) {
                asyncTimeout.f797g = asyncTimeout.mo58874c();
            } else {
                throw new AssertionError();
            }
            long m58972b = asyncTimeout.m58972b(nanoTime);
            AsyncTimeout asyncTimeout2 = f794j;
            while (true) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.f796f;
                if (asyncTimeout3 == null || m58972b < asyncTimeout3.m58972b(nanoTime)) {
                    break;
                }
                asyncTimeout2 = asyncTimeout2.f796f;
            }
            asyncTimeout.f796f = asyncTimeout2.f796f;
            asyncTimeout2.f796f = asyncTimeout;
            if (asyncTimeout2 == f794j) {
                AsyncTimeout.class.notify();
            }
        }
    }

    /* renamed from: b */
    private long m58972b(long j) {
        return this.f797g - j;
    }

    /* renamed from: j */
    static AsyncTimeout m58969j() throws InterruptedException {
        AsyncTimeout asyncTimeout = f794j.f796f;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(f792h);
            if (f794j.f796f != null || System.nanoTime() - nanoTime < f793i) {
                return null;
            }
            return f794j;
        }
        long m58972b = asyncTimeout.m58972b(System.nanoTime());
        if (m58972b > 0) {
            long j = m58972b / 1000000;
            AsyncTimeout.class.wait(j, (int) (m58972b - (1000000 * j)));
            return null;
        }
        f794j.f796f = asyncTimeout.f796f;
        asyncTimeout.f796f = null;
        return asyncTimeout;
    }

    /* renamed from: g */
    public final void m58971g() {
        if (!this.f795e) {
            long m58872f = m58872f();
            boolean mo58873d = mo58873d();
            if (m58872f != 0 || mo58873d) {
                this.f795e = true;
                m58977a(this, m58872f, mo58873d);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* renamed from: h */
    public final boolean m58970h() {
        if (this.f795e) {
            this.f795e = false;
            return m58978a(this);
        }
        return false;
    }

    /* renamed from: i */
    protected void mo58553i() {
    }

    /* renamed from: b */
    protected IOException mo58554b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        r1.f796f = r3.f796f;
        r3.f796f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = false;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized boolean m58978a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout r3) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.class
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.f794j     // Catch: java.lang.Throwable -> L19
        L5:
            if (r1 == 0) goto L17
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r1.f796f     // Catch: java.lang.Throwable -> L19
            if (r2 != r3) goto L15
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r3.f796f     // Catch: java.lang.Throwable -> L19
            r1.f796f = r2     // Catch: java.lang.Throwable -> L19
            r1 = 0
            r3.f796f = r1     // Catch: java.lang.Throwable -> L19
            r3 = 0
        L13:
            monitor-exit(r0)
            return r3
        L15:
            r1 = r2
            goto L5
        L17:
            r3 = 1
            goto L13
        L19:
            r3 = move-exception
            monitor-exit(r0)
            goto L1d
        L1c:
            throw r3
        L1d:
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.AsyncTimeout.m58978a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a):boolean");
    }

    /* renamed from: a */
    public final Sink m58976a(Sink sink) {
        return new C1010a(sink);
    }

    /* renamed from: a */
    public final Source m58975a(Source source) {
        return new C1011b(source);
    }

    /* renamed from: a */
    final void m58973a(boolean z) throws IOException {
        if (m58970h() && z) {
            throw mo58554b((IOException) null);
        }
    }

    /* renamed from: a */
    final IOException m58974a(IOException iOException) throws IOException {
        return !m58970h() ? iOException : mo58554b(iOException);
    }
}
