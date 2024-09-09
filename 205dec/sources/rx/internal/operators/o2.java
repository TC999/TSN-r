package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.e;
import rx.internal.util.BackpressureDrainManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorOnBackpressureBuffer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class o2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Long f63063a;

    /* renamed from: b  reason: collision with root package name */
    private final rx.functions.a f63064b;

    /* renamed from: c  reason: collision with root package name */
    private final a.d f63065c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> implements BackpressureDrainManager.a {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicLong f63067b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.l<? super T> f63068c;

        /* renamed from: e  reason: collision with root package name */
        private final BackpressureDrainManager f63070e;

        /* renamed from: f  reason: collision with root package name */
        private final rx.functions.a f63071f;

        /* renamed from: g  reason: collision with root package name */
        private final a.d f63072g;

        /* renamed from: a  reason: collision with root package name */
        private final ConcurrentLinkedQueue<Object> f63066a = new ConcurrentLinkedQueue<>();

        /* renamed from: d  reason: collision with root package name */
        private final AtomicBoolean f63069d = new AtomicBoolean(false);

        public a(rx.l<? super T> lVar, Long l4, rx.functions.a aVar, a.d dVar) {
            this.f63068c = lVar;
            this.f63067b = l4 != null ? new AtomicLong(l4.longValue()) : null;
            this.f63071f = aVar;
            this.f63070e = new BackpressureDrainManager(this);
            this.f63072g = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0049 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean g() {
            /*
                r6 = this;
                java.util.concurrent.atomic.AtomicLong r0 = r6.f63067b
                r1 = 1
                if (r0 != 0) goto L6
                return r1
            L6:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f63067b
                long r2 = r0.get()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L4a
                r0 = 0
                rx.a$d r4 = r6.f63072g     // Catch: rx.exceptions.MissingBackpressureException -> L23
                boolean r4 = r4.a()     // Catch: rx.exceptions.MissingBackpressureException -> L23
                if (r4 == 0) goto L34
                java.lang.Object r4 = r6.poll()     // Catch: rx.exceptions.MissingBackpressureException -> L23
                if (r4 == 0) goto L34
                r4 = 1
                goto L35
            L23:
                r4 = move-exception
                java.util.concurrent.atomic.AtomicBoolean r5 = r6.f63069d
                boolean r5 = r5.compareAndSet(r0, r1)
                if (r5 == 0) goto L34
                r6.unsubscribe()
                rx.l<? super T> r5 = r6.f63068c
                r5.onError(r4)
            L34:
                r4 = 0
            L35:
                rx.functions.a r5 = r6.f63071f
                if (r5 == 0) goto L47
                r5.call()     // Catch: java.lang.Throwable -> L3d
                goto L47
            L3d:
                r1 = move-exception
                rx.exceptions.a.e(r1)
                rx.internal.util.BackpressureDrainManager r2 = r6.f63070e
                r2.terminateAndDrain(r1)
                return r0
            L47:
                if (r4 != 0) goto L4a
                return r0
            L4a:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f63067b
                r4 = 1
                long r4 = r2 - r4
                boolean r0 = r0.compareAndSet(r2, r4)
                if (r0 == 0) goto L6
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.o2.a.g():boolean");
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return v.a(this.f63068c, obj);
        }

        public void e(Throwable th) {
            if (th != null) {
                this.f63068c.onError(th);
            } else {
                this.f63068c.onCompleted();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63069d.get()) {
                return;
            }
            this.f63070e.terminateAndDrain();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63069d.get()) {
                return;
            }
            this.f63070e.terminateAndDrain(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (g()) {
                this.f63066a.offer(v.j(t3));
                this.f63070e.drain();
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.f63066a.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.f63066a.poll();
            AtomicLong atomicLong = this.f63067b;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }

        protected rx.g v() {
            return this.f63070e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final o2<?> f63073a = new o2<>();

        b() {
        }
    }

    o2() {
        this.f63063a = null;
        this.f63064b = null;
        this.f63065c = rx.a.f62055b;
    }

    public static <T> o2<T> a() {
        return (o2<T>) b.f63073a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f63063a, this.f63064b, this.f63065c);
        lVar.add(aVar);
        lVar.setProducer(aVar.v());
        return aVar;
    }

    public o2(long j4) {
        this(j4, null, rx.a.f62055b);
    }

    public o2(long j4, rx.functions.a aVar) {
        this(j4, aVar, rx.a.f62055b);
    }

    public o2(long j4, rx.functions.a aVar, a.d dVar) {
        if (j4 <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar != null) {
            this.f63063a = Long.valueOf(j4);
            this.f63064b = aVar;
            this.f63065c = dVar;
            return;
        }
        throw new NullPointerException("The BackpressureOverflow strategy must not be null");
    }
}
