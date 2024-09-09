package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.n0;
import rx.internal.util.ExceptionsUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeFlattenIterable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k0<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T> f62853a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends Iterable<? extends R>> f62854b;

    /* renamed from: c  reason: collision with root package name */
    final int f62855c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62856a;

        a(b bVar) {
            this.f62856a = bVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f62856a.x(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f62858a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends Iterable<? extends R>> f62859b;

        /* renamed from: c  reason: collision with root package name */
        final long f62860c;

        /* renamed from: d  reason: collision with root package name */
        final Queue<Object> f62861d;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f62865h;

        /* renamed from: i  reason: collision with root package name */
        long f62866i;

        /* renamed from: j  reason: collision with root package name */
        Iterator<? extends R> f62867j;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Throwable> f62862e = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f62864g = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f62863f = new AtomicLong();

        public b(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar, int i4) {
            this.f62858a = lVar;
            this.f62859b = pVar;
            if (i4 == Integer.MAX_VALUE) {
                this.f62860c = Long.MAX_VALUE;
                this.f62861d = new rx.internal.util.atomic.e(rx.internal.util.j.f63940d);
            } else {
                this.f62860c = i4 - (i4 >> 2);
                if (rx.internal.util.unsafe.n0.f()) {
                    this.f62861d = new rx.internal.util.unsafe.z(i4);
                } else {
                    this.f62861d = new rx.internal.util.atomic.d(i4);
                }
            }
            request(i4);
        }

        boolean g(boolean z3, boolean z4, rx.l<?> lVar, Queue<?> queue) {
            if (lVar.isUnsubscribed()) {
                queue.clear();
                this.f62867j = null;
                return true;
            } else if (z3) {
                if (this.f62862e.get() == null) {
                    if (z4) {
                        lVar.onCompleted();
                        return true;
                    }
                    return false;
                }
                Throwable terminate = ExceptionsUtils.terminate(this.f62862e);
                unsubscribe();
                queue.clear();
                this.f62867j = null;
                lVar.onError(terminate);
                return true;
            } else {
                return false;
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62865h = true;
            v();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.f62862e, th)) {
                this.f62865h = true;
                v();
                return;
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (!this.f62861d.offer(v.j(t3))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            v();
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00d8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0010 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void v() {
            /*
                Method dump skipped, instructions count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.k0.b.v():void");
        }

        void x(long j4) {
            if (j4 > 0) {
                rx.internal.operators.a.b(this.f62863f, j4);
                v();
            } else if (j4 >= 0) {
            } else {
                throw new IllegalStateException("n >= 0 required but it was " + j4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T, R> implements e.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final T f62868a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends Iterable<? extends R>> f62869b;

        public c(T t3, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar) {
            this.f62868a = t3;
            this.f62869b = pVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super R> lVar) {
            try {
                Iterator<? extends R> it = this.f62869b.call((T) this.f62868a).iterator();
                if (!it.hasNext()) {
                    lVar.onCompleted();
                } else {
                    lVar.setProducer(new n0.a(lVar, it));
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, lVar, this.f62868a);
            }
        }
    }

    protected k0(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar, int i4) {
        this.f62853a = eVar;
        this.f62854b = pVar;
        this.f62855c = i4;
    }

    public static <T, R> rx.e<R> a(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar, int i4) {
        if (eVar instanceof rx.internal.util.k) {
            return rx.e.H6(new c(((rx.internal.util.k) eVar).x7(), pVar));
        }
        return rx.e.H6(new k0(eVar, pVar, i4));
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        b bVar = new b(lVar, this.f62854b, this.f62855c);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        this.f62853a.I6(bVar);
    }
}
