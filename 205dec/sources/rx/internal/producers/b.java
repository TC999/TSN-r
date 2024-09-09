package rx.internal.producers;

import java.util.ArrayList;
import java.util.List;
import rx.f;
import rx.g;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ProducerObserverArbiter.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class b<T> implements g, f<T> {

    /* renamed from: j  reason: collision with root package name */
    static final g f63728j = new a();

    /* renamed from: a  reason: collision with root package name */
    final l<? super T> f63729a;

    /* renamed from: b  reason: collision with root package name */
    boolean f63730b;

    /* renamed from: c  reason: collision with root package name */
    List<T> f63731c;

    /* renamed from: d  reason: collision with root package name */
    g f63732d;

    /* renamed from: e  reason: collision with root package name */
    long f63733e;

    /* renamed from: f  reason: collision with root package name */
    long f63734f;

    /* renamed from: g  reason: collision with root package name */
    g f63735g;

    /* renamed from: h  reason: collision with root package name */
    Object f63736h;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f63737i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ProducerObserverArbiter.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements g {
        a() {
        }

        @Override // rx.g
        public void request(long j4) {
        }
    }

    public b(l<? super T> lVar) {
        this.f63729a = lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0009, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d() {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.producers.b.d():void");
    }

    @Override // rx.f
    public void onCompleted() {
        synchronized (this) {
            if (this.f63730b) {
                this.f63736h = Boolean.TRUE;
                return;
            }
            this.f63730b = true;
            this.f63729a.onCompleted();
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        boolean z3;
        synchronized (this) {
            if (this.f63730b) {
                this.f63736h = th;
                z3 = false;
            } else {
                this.f63730b = true;
                z3 = true;
            }
        }
        if (z3) {
            this.f63729a.onError(th);
        } else {
            this.f63737i = true;
        }
    }

    @Override // rx.f
    public void onNext(T t3) {
        synchronized (this) {
            if (this.f63730b) {
                List list = this.f63731c;
                if (list == null) {
                    list = new ArrayList(4);
                    this.f63731c = list;
                }
                list.add(t3);
                return;
            }
            this.f63730b = true;
            try {
                this.f63729a.onNext(t3);
                long j4 = this.f63733e;
                if (j4 != Long.MAX_VALUE) {
                    this.f63733e = j4 - 1;
                }
                d();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f63730b = false;
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
            if (this.f63730b) {
                this.f63734f += j4;
                return;
            }
            this.f63730b = true;
            g gVar = this.f63732d;
            try {
                long j5 = this.f63733e + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.f63733e = j5;
                d();
                if (gVar != null) {
                    gVar.request(j4);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.f63730b = false;
                    throw th;
                }
            }
        }
    }

    public void setProducer(g gVar) {
        synchronized (this) {
            if (this.f63730b) {
                if (gVar == null) {
                    gVar = f63728j;
                }
                this.f63735g = gVar;
                return;
            }
            this.f63730b = true;
            this.f63732d = gVar;
            long j4 = this.f63733e;
            try {
                d();
                if (gVar == null || j4 == 0) {
                    return;
                }
                gVar.request(j4);
            } catch (Throwable th) {
                synchronized (this) {
                    this.f63730b = false;
                    throw th;
                }
            }
        }
    }
}
