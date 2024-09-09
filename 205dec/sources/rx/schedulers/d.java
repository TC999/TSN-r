package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.h;
import rx.internal.schedulers.i;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: TestScheduler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class d extends h {

    /* renamed from: c  reason: collision with root package name */
    static long f64241c;

    /* renamed from: a  reason: collision with root package name */
    final Queue<c> f64242a = new PriorityQueue(11, new a());

    /* renamed from: b  reason: collision with root package name */
    long f64243b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            long j4 = cVar.f64250a;
            long j5 = cVar2.f64250a;
            if (j4 == j5) {
                if (cVar.f64253d < cVar2.f64253d) {
                    return -1;
                }
                return cVar.f64253d > cVar2.f64253d ? 1 : 0;
            } else if (j4 < j5) {
                return -1;
            } else {
                return j4 > j5 ? 1 : 0;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    final class b extends h.a implements i.b {

        /* renamed from: a  reason: collision with root package name */
        private final rx.subscriptions.a f64244a = new rx.subscriptions.a();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: TestScheduler.java */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f64246a;

            a(c cVar) {
                this.f64246a = cVar;
            }

            @Override // rx.functions.a
            public void call() {
                d.this.f64242a.remove(this.f64246a);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: TestScheduler.java */
        /* renamed from: rx.schedulers.d$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class C1324b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f64248a;

            C1324b(c cVar) {
                this.f64248a = cVar;
            }

            @Override // rx.functions.a
            public void call() {
                d.this.f64242a.remove(this.f64248a);
            }
        }

        b() {
        }

        public m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            c cVar = new c(this, d.this.f64243b + timeUnit.toNanos(j4), aVar);
            d.this.f64242a.add(cVar);
            return rx.subscriptions.f.a(new a(cVar));
        }

        public m G(rx.functions.a aVar, long j4, long j5, TimeUnit timeUnit) {
            return i.a(this, aVar, j4, j5, timeUnit, this);
        }

        @Override // rx.internal.schedulers.i.b
        public long a() {
            return d.this.f64243b;
        }

        @Override // rx.h.a
        public long b() {
            return d.this.b();
        }

        public m d(rx.functions.a aVar) {
            c cVar = new c(this, 0L, aVar);
            d.this.f64242a.add(cVar);
            return rx.subscriptions.f.a(new C1324b(cVar));
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f64244a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f64244a.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final long f64250a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.a f64251b;

        /* renamed from: c  reason: collision with root package name */
        final h.a f64252c;

        /* renamed from: d  reason: collision with root package name */
        private final long f64253d;

        c(h.a aVar, long j4, rx.functions.a aVar2) {
            long j5 = d.f64241c;
            d.f64241c = 1 + j5;
            this.f64253d = j5;
            this.f64250a = j4;
            this.f64251b = aVar2;
            this.f64252c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f64250a), this.f64251b.toString());
        }
    }

    private void I(long j4) {
        while (!this.f64242a.isEmpty()) {
            c peek = this.f64242a.peek();
            long j5 = peek.f64250a;
            if (j5 > j4) {
                break;
            }
            if (j5 == 0) {
                j5 = this.f64243b;
            }
            this.f64243b = j5;
            this.f64242a.remove();
            if (!peek.f64252c.isUnsubscribed()) {
                peek.f64251b.call();
            }
        }
        this.f64243b = j4;
    }

    public void F(long j4, TimeUnit timeUnit) {
        G(this.f64243b + timeUnit.toNanos(j4), TimeUnit.NANOSECONDS);
    }

    public void G(long j4, TimeUnit timeUnit) {
        I(timeUnit.toNanos(j4));
    }

    public void H() {
        I(this.f64243b);
    }

    @Override // rx.h
    public h.a a() {
        return new b();
    }

    @Override // rx.h
    public long b() {
        return TimeUnit.NANOSECONDS.toMillis(this.f64243b);
    }
}
