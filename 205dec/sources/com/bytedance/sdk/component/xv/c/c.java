package com.bytedance.sdk.component.xv.c;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends u {

    /* renamed from: c  reason: collision with root package name */
    static c f30671c;
    private static final long sr;

    /* renamed from: w  reason: collision with root package name */
    private static final long f30672w;

    /* renamed from: f  reason: collision with root package name */
    private c f30673f;

    /* renamed from: r  reason: collision with root package name */
    private long f30674r;
    private boolean ux;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.component.xv.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class C0460c extends com.bytedance.sdk.component.gd.sr.xv {
        C0460c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.y_();
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
                java.lang.Class<com.bytedance.sdk.component.xv.c.c> r0 = com.bytedance.sdk.component.xv.c.c.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                com.bytedance.sdk.component.xv.c.c r1 = com.bytedance.sdk.component.xv.c.c.sr()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.bytedance.sdk.component.xv.c.c r2 = com.bytedance.sdk.component.xv.c.c.f30671c     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.bytedance.sdk.component.xv.c.c.f30671c = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.y_()     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
            L1c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.c.c.C0460c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f30672w = millis;
        sr = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    static c sr() throws InterruptedException {
        c cVar = f30671c.f30673f;
        if (cVar == null) {
            long nanoTime = System.nanoTime();
            c.class.wait(f30672w);
            if (f30671c.f30673f != null || System.nanoTime() - nanoTime < sr) {
                return null;
            }
            return f30671c;
        }
        long w3 = cVar.w(System.nanoTime());
        if (w3 > 0) {
            long j4 = w3 / C.MICROS_PER_SECOND;
            c.class.wait(j4, (int) (w3 - (C.MICROS_PER_SECOND * j4)));
            return null;
        }
        f30671c.f30673f = cVar.f30673f;
        cVar.f30673f = null;
        return cVar;
    }

    public final void c() {
        if (this.ux) {
            return;
        }
        long z_ = z_();
        boolean xv = xv();
        if (z_ != 0 || xv) {
            this.ux = true;
            c(this, z_, xv);
        }
    }

    public final boolean w() {
        if (this.ux) {
            this.ux = false;
            return c(this);
        }
        return false;
    }

    protected void y_() {
    }

    private long w(long j4) {
        return this.f30674r - j4;
    }

    protected IOException w(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized void c(c cVar, long j4, boolean z3) {
        synchronized (c.class) {
            if (f30671c == null) {
                f30671c = new c();
                C0460c c0460c = new C0460c();
                c0460c.setName("csj_watch_dog");
                try {
                    c0460c.start();
                } catch (Throwable unused) {
                }
            }
            long nanoTime = System.nanoTime();
            if (j4 != 0 && z3) {
                cVar.f30674r = Math.min(j4, cVar.A_() - nanoTime) + nanoTime;
            } else if (j4 != 0) {
                cVar.f30674r = j4 + nanoTime;
            } else if (z3) {
                cVar.f30674r = cVar.A_();
            } else {
                throw new AssertionError();
            }
            long w3 = cVar.w(nanoTime);
            c cVar2 = f30671c;
            while (true) {
                c cVar3 = cVar2.f30673f;
                if (cVar3 == null || w3 < cVar3.w(nanoTime)) {
                    break;
                }
                cVar2 = cVar2.f30673f;
            }
            cVar.f30673f = cVar2.f30673f;
            cVar2.f30673f = cVar;
            if (cVar2 == f30671c) {
                c.class.notify();
            }
        }
    }

    private static synchronized boolean c(c cVar) {
        synchronized (c.class) {
            c cVar2 = f30671c;
            while (cVar2 != null) {
                c cVar3 = cVar2.f30673f;
                if (cVar3 == cVar) {
                    cVar2.f30673f = cVar.f30673f;
                    cVar.f30673f = null;
                    return false;
                }
                cVar2 = cVar3;
            }
            return true;
        }
    }

    public final s c(final s sVar) {
        return new s() { // from class: com.bytedance.sdk.component.xv.c.c.1
            @Override // com.bytedance.sdk.component.xv.c.s
            public void a_(xv xvVar, long j4) throws IOException {
                try {
                    i.c(xvVar.f30701w, 0L, j4);
                    while (true) {
                        long j5 = 0;
                        if (j4 <= 0) {
                            return;
                        }
                        ys ysVar = xvVar.f30700c;
                        while (true) {
                            if (j5 >= 65536) {
                                break;
                            }
                            j5 += ysVar.xv - ysVar.f30706w;
                            if (j5 >= j4) {
                                j5 = j4;
                                break;
                            }
                            ysVar = ysVar.f30704f;
                        }
                        c.this.c();
                        try {
                            try {
                                sVar.a_(xvVar, j5);
                                j4 -= j5;
                                c.this.c(true);
                            } catch (IOException e4) {
                                throw c.this.c(e4);
                            }
                        } catch (Throwable th) {
                            c.this.c(false);
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    throw new IOException(e5);
                }
            }

            @Override // com.bytedance.sdk.component.xv.c.s
            public u c() {
                return c.this;
            }

            @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                c.this.c();
                try {
                    try {
                        sVar.close();
                        c.this.c(true);
                    } catch (IOException e4) {
                        throw c.this.c(e4);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.xv.c.s, java.io.Flushable
            public void flush() throws IOException {
                c.this.c();
                try {
                    try {
                        sVar.flush();
                        c.this.c(true);
                    } catch (IOException e4) {
                        throw c.this.c(e4);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sVar + ")";
            }
        };
    }

    public final fz c(final fz fzVar) {
        return new fz() { // from class: com.bytedance.sdk.component.xv.c.c.2
            @Override // com.bytedance.sdk.component.xv.c.fz
            public long c(xv xvVar, long j4) throws IOException {
                c.this.c();
                try {
                    try {
                        long c4 = fzVar.c(xvVar, j4);
                        c.this.c(true);
                        return c4;
                    } catch (IOException e4) {
                        throw c.this.c(e4);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                c.this.c();
                try {
                    try {
                        fzVar.close();
                        c.this.c(true);
                    } catch (IOException e4) {
                        throw c.this.c(e4);
                    }
                } catch (Throwable th) {
                    c.this.c(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + fzVar + ")";
            }

            @Override // com.bytedance.sdk.component.xv.c.fz
            public u c() {
                return c.this;
            }
        };
    }

    final void c(boolean z3) throws IOException {
        if (w() && z3) {
            throw w((IOException) null);
        }
    }

    final IOException c(IOException iOException) throws IOException {
        return !w() ? iOException : w(iOException);
    }
}
