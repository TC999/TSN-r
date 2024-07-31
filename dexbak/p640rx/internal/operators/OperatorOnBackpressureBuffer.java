package p640rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.BackpressureOverflow;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.internal.util.BackpressureDrainManager;

/* renamed from: rx.internal.operators.o2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorOnBackpressureBuffer<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    private final Long f45632a;

    /* renamed from: b */
    private final Action0 f45633b;

    /* renamed from: c */
    private final BackpressureOverflow.InterfaceC15500d f45634c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* renamed from: rx.internal.operators.o2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15817a<T> extends Subscriber<T> implements BackpressureDrainManager.InterfaceC16028a {

        /* renamed from: b */
        private final AtomicLong f45636b;

        /* renamed from: c */
        private final Subscriber<? super T> f45637c;

        /* renamed from: e */
        private final BackpressureDrainManager f45639e;

        /* renamed from: f */
        private final Action0 f45640f;

        /* renamed from: g */
        private final BackpressureOverflow.InterfaceC15500d f45641g;

        /* renamed from: a */
        private final ConcurrentLinkedQueue<Object> f45635a = new ConcurrentLinkedQueue<>();

        /* renamed from: d */
        private final AtomicBoolean f45638d = new AtomicBoolean(false);

        public C15817a(Subscriber<? super T> subscriber, Long l, Action0 action0, BackpressureOverflow.InterfaceC15500d interfaceC15500d) {
            this.f45637c = subscriber;
            this.f45636b = l != null ? new AtomicLong(l.longValue()) : null;
            this.f45640f = action0;
            this.f45639e = new BackpressureDrainManager(this);
            this.f45641g = interfaceC15500d;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0049 A[SYNTHETIC] */
        /* renamed from: F */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean m1135F() {
            /*
                r6 = this;
                java.util.concurrent.atomic.AtomicLong r0 = r6.f45636b
                r1 = 1
                if (r0 != 0) goto L6
                return r1
            L6:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f45636b
                long r2 = r0.get()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L4a
                r0 = 0
                rx.a$d r4 = r6.f45641g     // Catch: p640rx.exceptions.MissingBackpressureException -> L23
                boolean r4 = r4.mo1993a()     // Catch: p640rx.exceptions.MissingBackpressureException -> L23
                if (r4 == 0) goto L34
                java.lang.Object r4 = r6.poll()     // Catch: p640rx.exceptions.MissingBackpressureException -> L23
                if (r4 == 0) goto L34
                r4 = 1
                goto L35
            L23:
                r4 = move-exception
                java.util.concurrent.atomic.AtomicBoolean r5 = r6.f45638d
                boolean r5 = r5.compareAndSet(r0, r1)
                if (r5 == 0) goto L34
                r6.unsubscribe()
                rx.l<? super T> r5 = r6.f45637c
                r5.onError(r4)
            L34:
                r4 = 0
            L35:
                rx.functions.a r5 = r6.f45640f
                if (r5 == 0) goto L47
                r5.call()     // Catch: java.lang.Throwable -> L3d
                goto L47
            L3d:
                r1 = move-exception
                p640rx.exceptions.C15575a.m1474e(r1)
                rx.internal.util.BackpressureDrainManager r2 = r6.f45639e
                r2.terminateAndDrain(r1)
                return r0
            L47:
                if (r4 != 0) goto L4a
                return r0
            L4a:
                java.util.concurrent.atomic.AtomicLong r0 = r6.f45636b
                r4 = 1
                long r4 = r2 - r4
                boolean r0 = r0.compareAndSet(r2, r4)
                if (r0 == 0) goto L6
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.OperatorOnBackpressureBuffer.C15817a.m1135F():boolean");
        }

        /* renamed from: G */
        protected Producer m1134G() {
            return this.f45639e;
        }

        @Override // p640rx.internal.util.BackpressureDrainManager.InterfaceC16028a
        public boolean accept(Object obj) {
            return NotificationLite.m1052a(this.f45637c, obj);
        }

        @Override // p640rx.internal.util.BackpressureDrainManager.InterfaceC16028a
        /* renamed from: d */
        public void mo930d(Throwable th) {
            if (th != null) {
                this.f45637c.onError(th);
            } else {
                this.f45637c.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45638d.get()) {
                return;
            }
            this.f45639e.terminateAndDrain();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45638d.get()) {
                return;
            }
            this.f45639e.terminateAndDrain(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (m1135F()) {
                this.f45635a.offer(NotificationLite.m1043j(t));
                this.f45639e.drain();
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // p640rx.internal.util.BackpressureDrainManager.InterfaceC16028a
        public Object peek() {
            return this.f45635a.peek();
        }

        @Override // p640rx.internal.util.BackpressureDrainManager.InterfaceC16028a
        public Object poll() {
            Object poll = this.f45635a.poll();
            AtomicLong atomicLong = this.f45636b;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* renamed from: rx.internal.operators.o2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15818b {

        /* renamed from: a */
        static final OperatorOnBackpressureBuffer<?> f45642a = new OperatorOnBackpressureBuffer<>();

        C15818b() {
        }
    }

    OperatorOnBackpressureBuffer() {
        this.f45632a = null;
        this.f45633b = null;
        this.f45634c = BackpressureOverflow.f44624b;
    }

    /* renamed from: a */
    public static <T> OperatorOnBackpressureBuffer<T> m1136a() {
        return (OperatorOnBackpressureBuffer<T>) C15818b.f45642a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        C15817a c15817a = new C15817a(subscriber, this.f45632a, this.f45633b, this.f45634c);
        subscriber.add(c15817a);
        subscriber.setProducer(c15817a.m1134G());
        return c15817a;
    }

    public OperatorOnBackpressureBuffer(long j) {
        this(j, null, BackpressureOverflow.f44624b);
    }

    public OperatorOnBackpressureBuffer(long j, Action0 action0) {
        this(j, action0, BackpressureOverflow.f44624b);
    }

    public OperatorOnBackpressureBuffer(long j, Action0 action0, BackpressureOverflow.InterfaceC15500d interfaceC15500d) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (interfaceC15500d != null) {
            this.f45632a = Long.valueOf(j);
            this.f45633b = action0;
            this.f45634c = interfaceC15500d;
            return;
        }
        throw new NullPointerException("The BackpressureOverflow strategy must not be null");
    }
}
