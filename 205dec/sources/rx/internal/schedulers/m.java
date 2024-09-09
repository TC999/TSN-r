package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: TrampolineScheduler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class m extends rx.h {

    /* renamed from: a  reason: collision with root package name */
    public static final m f63851a = new m();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends h.a implements rx.m {

        /* renamed from: a  reason: collision with root package name */
        final AtomicInteger f63852a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        final PriorityBlockingQueue<b> f63853b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        private final rx.subscriptions.a f63854c = new rx.subscriptions.a();

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f63855d = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: TrampolineScheduler.java */
        /* renamed from: rx.internal.schedulers.m$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public class C1316a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f63856a;

            C1316a(b bVar) {
                this.f63856a = bVar;
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f63853b.remove(this.f63856a);
            }
        }

        a() {
        }

        private rx.m H(rx.functions.a aVar, long j4) {
            if (this.f63854c.isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            b bVar = new b(aVar, Long.valueOf(j4), this.f63852a.incrementAndGet());
            this.f63853b.add(bVar);
            if (this.f63855d.getAndIncrement() == 0) {
                do {
                    b poll = this.f63853b.poll();
                    if (poll != null) {
                        poll.f63858a.call();
                    }
                } while (this.f63855d.decrementAndGet() > 0);
                return rx.subscriptions.f.e();
            }
            return rx.subscriptions.f.a(new C1316a(bVar));
        }

        public rx.m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            long b4 = b() + timeUnit.toMillis(j4);
            return H(new l(aVar, this, b4), b4);
        }

        public rx.m d(rx.functions.a aVar) {
            return H(aVar, b());
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63854c.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f63854c.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.a f63858a;

        /* renamed from: b  reason: collision with root package name */
        final Long f63859b;

        /* renamed from: c  reason: collision with root package name */
        final int f63860c;

        b(rx.functions.a aVar, Long l4, int i4) {
            this.f63858a = aVar;
            this.f63859b = l4;
            this.f63860c = i4;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f63859b.compareTo(bVar.f63859b);
            return compareTo == 0 ? m.F(this.f63860c, bVar.f63860c) : compareTo;
        }
    }

    private m() {
    }

    static int F(int i4, int i5) {
        if (i4 < i5) {
            return -1;
        }
        return i4 == i5 ? 0 : 1;
    }

    @Override // rx.h
    public h.a a() {
        return new a();
    }
}
