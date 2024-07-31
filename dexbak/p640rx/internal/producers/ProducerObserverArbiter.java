package p640rx.internal.producers;

import java.util.ArrayList;
import java.util.List;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;

/* renamed from: rx.internal.producers.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {

    /* renamed from: j */
    static final Producer f46297j = new C15995a();

    /* renamed from: a */
    final Subscriber<? super T> f46298a;

    /* renamed from: b */
    boolean f46299b;

    /* renamed from: c */
    List<T> f46300c;

    /* renamed from: d */
    Producer f46301d;

    /* renamed from: e */
    long f46302e;

    /* renamed from: f */
    long f46303f;

    /* renamed from: g */
    Producer f46304g;

    /* renamed from: h */
    Object f46305h;

    /* renamed from: i */
    volatile boolean f46306i;

    /* compiled from: ProducerObserverArbiter.java */
    /* renamed from: rx.internal.producers.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15995a implements Producer {
        C15995a() {
        }

        @Override // p640rx.Producer
        public void request(long j) {
        }
    }

    public ProducerObserverArbiter(Subscriber<? super T> subscriber) {
        this.f46298a = subscriber;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0009, code lost:
        continue;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m959d() {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.producers.ProducerObserverArbiter.m959d():void");
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        synchronized (this) {
            if (this.f46299b) {
                this.f46305h = Boolean.TRUE;
                return;
            }
            this.f46299b = true;
            this.f46298a.onCompleted();
        }
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        boolean z;
        synchronized (this) {
            if (this.f46299b) {
                this.f46305h = th;
                z = false;
            } else {
                this.f46299b = true;
                z = true;
            }
        }
        if (z) {
            this.f46298a.onError(th);
        } else {
            this.f46306i = true;
        }
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        synchronized (this) {
            if (this.f46299b) {
                List list = this.f46300c;
                if (list == null) {
                    list = new ArrayList(4);
                    this.f46300c = list;
                }
                list.add(t);
                return;
            }
            this.f46299b = true;
            try {
                this.f46298a.onNext(t);
                long j = this.f46302e;
                if (j != Long.MAX_VALUE) {
                    this.f46302e = j - 1;
                }
                m959d();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f46299b = false;
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
            if (this.f46299b) {
                this.f46303f += j;
                return;
            }
            this.f46299b = true;
            Producer producer = this.f46301d;
            try {
                long j2 = this.f46302e + j;
                if (j2 < 0) {
                    j2 = Long.MAX_VALUE;
                }
                this.f46302e = j2;
                m959d();
                if (producer != null) {
                    producer.request(j);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.f46299b = false;
                    throw th;
                }
            }
        }
    }

    public void setProducer(Producer producer) {
        synchronized (this) {
            if (this.f46299b) {
                if (producer == null) {
                    producer = f46297j;
                }
                this.f46304g = producer;
                return;
            }
            this.f46299b = true;
            this.f46301d = producer;
            long j = this.f46302e;
            try {
                m959d();
                if (producer == null || j == 0) {
                    return;
                }
                producer.request(j);
            } catch (Throwable th) {
                synchronized (this) {
                    this.f46299b = false;
                    throw th;
                }
            }
        }
    }
}
