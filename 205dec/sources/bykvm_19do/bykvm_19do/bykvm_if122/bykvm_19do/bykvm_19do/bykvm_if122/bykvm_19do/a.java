package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a extends t {

    /* renamed from: h  reason: collision with root package name */
    private static final long f785h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f786i;

    /* renamed from: j  reason: collision with root package name */
    static a f787j;

    /* renamed from: e  reason: collision with root package name */
    private boolean f788e;

    /* renamed from: f  reason: collision with root package name */
    private a f789f;

    /* renamed from: g  reason: collision with root package name */
    private long f790g;

    /* compiled from: AsyncTimeout.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class C0032a implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f791a;

        C0032a(r rVar) {
            this.f791a = rVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            u.a(cVar.f798b, 0L, j4);
            while (true) {
                long j5 = 0;
                if (j4 <= 0) {
                    return;
                }
                o oVar = cVar.f797a;
                while (true) {
                    if (j5 >= 65536) {
                        break;
                    }
                    j5 += oVar.f830c - oVar.f829b;
                    if (j5 >= j4) {
                        j5 = j4;
                        break;
                    }
                    oVar = oVar.f833f;
                }
                a.this.g();
                try {
                    try {
                        this.f791a.b(cVar, j5);
                        j4 -= j5;
                        a.this.a(true);
                    } catch (IOException e4) {
                        throw a.this.a(e4);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.f791a.close();
                    a.this.a(true);
                } catch (IOException e4) {
                    throw a.this.a(e4);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            a.this.g();
            try {
                try {
                    this.f791a.flush();
                    a.this.a(true);
                } catch (IOException e4) {
                    throw a.this.a(e4);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t t() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f791a + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class b implements s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f793a;

        b(s sVar) {
            this.f793a = sVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j4) throws IOException {
            a.this.g();
            try {
                try {
                    long a4 = this.f793a.a(cVar, j4);
                    a.this.a(true);
                    return a4;
                } catch (IOException e4) {
                    throw a.this.a(e4);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.f793a.close();
                    a.this.a(true);
                } catch (IOException e4) {
                    throw a.this.a(e4);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t t() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f793a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.i();
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
                java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f787j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f787j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.i()     // Catch: java.lang.InterruptedException -> L0
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
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f785h = millis;
        f786i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    private static synchronized void a(a aVar, long j4, boolean z3) {
        synchronized (a.class) {
            if (f787j == null) {
                f787j = new a();
                c cVar = new c();
                cVar.setName("tt_pangle_thread_watch_dog");
                cVar.start();
            }
            long nanoTime = System.nanoTime();
            int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i4 != 0 && z3) {
                aVar.f790g = Math.min(j4, aVar.c() - nanoTime) + nanoTime;
            } else if (i4 != 0) {
                aVar.f790g = j4 + nanoTime;
            } else if (z3) {
                aVar.f790g = aVar.c();
            } else {
                throw new AssertionError();
            }
            long b4 = aVar.b(nanoTime);
            a aVar2 = f787j;
            while (true) {
                a aVar3 = aVar2.f789f;
                if (aVar3 == null || b4 < aVar3.b(nanoTime)) {
                    break;
                }
                aVar2 = aVar2.f789f;
            }
            aVar.f789f = aVar2.f789f;
            aVar2.f789f = aVar;
            if (aVar2 == f787j) {
                a.class.notify();
            }
        }
    }

    private long b(long j4) {
        return this.f790g - j4;
    }

    static a j() throws InterruptedException {
        a aVar = f787j.f789f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f785h);
            if (f787j.f789f != null || System.nanoTime() - nanoTime < f786i) {
                return null;
            }
            return f787j;
        }
        long b4 = aVar.b(System.nanoTime());
        if (b4 > 0) {
            long j4 = b4 / C.MICROS_PER_SECOND;
            a.class.wait(j4, (int) (b4 - (C.MICROS_PER_SECOND * j4)));
            return null;
        }
        f787j.f789f = aVar.f789f;
        aVar.f789f = null;
        return aVar;
    }

    public final void g() {
        if (!this.f788e) {
            long f4 = f();
            boolean d4 = d();
            if (f4 != 0 || d4) {
                this.f788e = true;
                a(this, f4, d4);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean h() {
        if (this.f788e) {
            this.f788e = false;
            return a(this);
        }
        return false;
    }

    protected void i() {
    }

    protected IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        r1.f789f = r3.f789f;
        r3.f789f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized boolean a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r3) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.class
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f787j     // Catch: java.lang.Throwable -> L19
        L5:
            if (r1 == 0) goto L17
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r1.f789f     // Catch: java.lang.Throwable -> L19
            if (r2 != r3) goto L15
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r3.f789f     // Catch: java.lang.Throwable -> L19
            r1.f789f = r2     // Catch: java.lang.Throwable -> L19
            r1 = 0
            r3.f789f = r1     // Catch: java.lang.Throwable -> L19
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a):boolean");
    }

    public final r a(r rVar) {
        return new C0032a(rVar);
    }

    public final s a(s sVar) {
        return new b(sVar);
    }

    final void a(boolean z3) throws IOException {
        if (h() && z3) {
            throw b((IOException) null);
        }
    }

    final IOException a(IOException iOException) throws IOException {
        return !h() ? iOException : b(iOException);
    }
}
