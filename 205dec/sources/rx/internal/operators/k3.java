package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTakeLastTimed.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f62884a;

    /* renamed from: b  reason: collision with root package name */
    final rx.h f62885b;

    /* renamed from: c  reason: collision with root package name */
    final int f62886c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeLastTimed.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62887a;

        a(b bVar) {
            this.f62887a = bVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f62887a.v(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeLastTimed.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> implements rx.functions.p<Object, T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62889a;

        /* renamed from: b  reason: collision with root package name */
        final long f62890b;

        /* renamed from: c  reason: collision with root package name */
        final rx.h f62891c;

        /* renamed from: d  reason: collision with root package name */
        final int f62892d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f62893e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        final ArrayDeque<Object> f62894f = new ArrayDeque<>();

        /* renamed from: g  reason: collision with root package name */
        final ArrayDeque<Long> f62895g = new ArrayDeque<>();

        public b(rx.l<? super T> lVar, int i4, long j4, rx.h hVar) {
            this.f62889a = lVar;
            this.f62892d = i4;
            this.f62890b = j4;
            this.f62891c = hVar;
        }

        @Override // rx.functions.p
        public T call(Object obj) {
            return (T) v.e(obj);
        }

        protected void g(long j4) {
            long j5 = j4 - this.f62890b;
            while (true) {
                Long peek = this.f62895g.peek();
                if (peek == null || peek.longValue() >= j5) {
                    return;
                }
                this.f62894f.poll();
                this.f62895g.poll();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            g(this.f62891c.b());
            this.f62895g.clear();
            rx.internal.operators.a.e(this.f62893e, this.f62894f, this.f62889a, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62894f.clear();
            this.f62895g.clear();
            this.f62889a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62892d != 0) {
                long b4 = this.f62891c.b();
                if (this.f62894f.size() == this.f62892d) {
                    this.f62894f.poll();
                    this.f62895g.poll();
                }
                g(b4);
                this.f62894f.offer(v.j(t3));
                this.f62895g.offer(Long.valueOf(b4));
            }
        }

        void v(long j4) {
            rx.internal.operators.a.h(this.f62893e, j4, this.f62894f, this.f62889a, this);
        }
    }

    public k3(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f62884a = timeUnit.toMillis(j4);
        this.f62885b = hVar;
        this.f62886c = -1;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f62886c, this.f62884a, this.f62885b);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }

    public k3(int i4, long j4, TimeUnit timeUnit, rx.h hVar) {
        if (i4 >= 0) {
            this.f62884a = timeUnit.toMillis(j4);
            this.f62885b = hVar;
            this.f62886c = i4;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
