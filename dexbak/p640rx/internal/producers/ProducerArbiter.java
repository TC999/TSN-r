package p640rx.internal.producers;

import p640rx.Producer;

/* renamed from: rx.internal.producers.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ProducerArbiter implements Producer {

    /* renamed from: g */
    static final Producer f46290g = new C15994a();

    /* renamed from: a */
    long f46291a;

    /* renamed from: b */
    Producer f46292b;

    /* renamed from: c */
    boolean f46293c;

    /* renamed from: d */
    long f46294d;

    /* renamed from: e */
    long f46295e;

    /* renamed from: f */
    Producer f46296f;

    /* compiled from: ProducerArbiter.java */
    /* renamed from: rx.internal.producers.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15994a implements Producer {
        C15994a() {
        }

        @Override // p640rx.Producer
        public void request(long j) {
        }
    }

    /* renamed from: a */
    public void m962a() {
        while (true) {
            synchronized (this) {
                long j = this.f46294d;
                long j2 = this.f46295e;
                Producer producer = this.f46296f;
                if (j == 0 && j2 == 0 && producer == null) {
                    this.f46293c = false;
                    return;
                }
                this.f46294d = 0L;
                this.f46295e = 0L;
                this.f46296f = null;
                long j3 = this.f46291a;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.f46291a = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 >= 0) {
                            this.f46291a = j3;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (producer != null) {
                    if (producer == f46290g) {
                        this.f46292b = null;
                    } else {
                        this.f46292b = producer;
                        producer.request(j3);
                    }
                } else {
                    Producer producer2 = this.f46292b;
                    if (producer2 != null && j != 0) {
                        producer2.request(j);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m961b(long j) {
        if (j > 0) {
            synchronized (this) {
                if (this.f46293c) {
                    this.f46295e += j;
                    return;
                }
                this.f46293c = true;
                try {
                    long j2 = this.f46291a;
                    if (j2 != Long.MAX_VALUE) {
                        long j3 = j2 - j;
                        if (j3 >= 0) {
                            this.f46291a = j3;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    m962a();
                    return;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f46293c = false;
                        throw th;
                    }
                }
            }
        }
        throw new IllegalArgumentException("n > 0 required");
    }

    /* renamed from: c */
    public void m960c(Producer producer) {
        synchronized (this) {
            if (this.f46293c) {
                if (producer == null) {
                    producer = f46290g;
                }
                this.f46296f = producer;
                return;
            }
            this.f46293c = true;
            try {
                this.f46292b = producer;
                if (producer != null) {
                    producer.request(this.f46291a);
                }
                m962a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f46293c = false;
                    throw th;
                }
            }
        }
    }

    @Override // p640rx.Producer
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j == 0) {
            return;
        }
        synchronized (this) {
            if (this.f46293c) {
                this.f46294d += j;
                return;
            }
            this.f46293c = true;
            try {
                long j2 = this.f46291a + j;
                if (j2 < 0) {
                    j2 = Long.MAX_VALUE;
                }
                this.f46291a = j2;
                Producer producer = this.f46292b;
                if (producer != null) {
                    producer.request(j);
                }
                m962a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f46293c = false;
                    throw th;
                }
            }
        }
    }
}
