package rx.internal.producers;

import rx.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ProducerArbiter.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class a implements g {

    /* renamed from: g  reason: collision with root package name */
    static final g f63721g = new C1307a();

    /* renamed from: a  reason: collision with root package name */
    long f63722a;

    /* renamed from: b  reason: collision with root package name */
    g f63723b;

    /* renamed from: c  reason: collision with root package name */
    boolean f63724c;

    /* renamed from: d  reason: collision with root package name */
    long f63725d;

    /* renamed from: e  reason: collision with root package name */
    long f63726e;

    /* renamed from: f  reason: collision with root package name */
    g f63727f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ProducerArbiter.java */
    /* renamed from: rx.internal.producers.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class C1307a implements g {
        C1307a() {
        }

        @Override // rx.g
        public void request(long j4) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j4 = this.f63725d;
                long j5 = this.f63726e;
                g gVar = this.f63727f;
                if (j4 == 0 && j5 == 0 && gVar == null) {
                    this.f63724c = false;
                    return;
                }
                this.f63725d = 0L;
                this.f63726e = 0L;
                this.f63727f = null;
                long j6 = this.f63722a;
                if (j6 != Long.MAX_VALUE) {
                    long j7 = j6 + j4;
                    if (j7 < 0 || j7 == Long.MAX_VALUE) {
                        this.f63722a = Long.MAX_VALUE;
                        j6 = Long.MAX_VALUE;
                    } else {
                        j6 = j7 - j5;
                        if (j6 >= 0) {
                            this.f63722a = j6;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (gVar != null) {
                    if (gVar == f63721g) {
                        this.f63723b = null;
                    } else {
                        this.f63723b = gVar;
                        gVar.request(j6);
                    }
                } else {
                    g gVar2 = this.f63723b;
                    if (gVar2 != null && j4 != 0) {
                        gVar2.request(j4);
                    }
                }
            }
        }
    }

    public void b(long j4) {
        if (j4 > 0) {
            synchronized (this) {
                if (this.f63724c) {
                    this.f63726e += j4;
                    return;
                }
                this.f63724c = true;
                try {
                    long j5 = this.f63722a;
                    if (j5 != Long.MAX_VALUE) {
                        long j6 = j5 - j4;
                        if (j6 >= 0) {
                            this.f63722a = j6;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    a();
                    return;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f63724c = false;
                        throw th;
                    }
                }
            }
        }
        throw new IllegalArgumentException("n > 0 required");
    }

    public void c(g gVar) {
        synchronized (this) {
            if (this.f63724c) {
                if (gVar == null) {
                    gVar = f63721g;
                }
                this.f63727f = gVar;
                return;
            }
            this.f63724c = true;
            try {
                this.f63723b = gVar;
                if (gVar != null) {
                    gVar.request(this.f63722a);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f63724c = false;
                    throw th;
                }
            }
        }
    }

    @Override // rx.g
    public void request(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j4 == 0) {
            return;
        }
        synchronized (this) {
            if (this.f63724c) {
                this.f63725d += j4;
                return;
            }
            this.f63724c = true;
            try {
                long j5 = this.f63722a + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.f63722a = j5;
                g gVar = this.f63723b;
                if (gVar != null) {
                    gVar.request(j4);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f63724c = false;
                    throw th;
                }
            }
        }
    }
}
