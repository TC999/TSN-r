package rx.internal.operators;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorGroupBy.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g2<T, K, V> implements e.b<rx.observables.d<K, V>, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends K> f62628a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends V> f62629b;

    /* renamed from: c  reason: collision with root package name */
    final int f62630c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f62631d;

    /* renamed from: e  reason: collision with root package name */
    final rx.functions.p<rx.functions.b<K>, Map<K, Object>> f62632e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorGroupBy.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62633a;

        a(c cVar) {
            this.f62633a = cVar;
        }

        @Override // rx.functions.a
        public void call() {
            this.f62633a.g();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorGroupBy.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final c<?, ?, ?> f62635a;

        public b(c<?, ?, ?> cVar) {
            this.f62635a = cVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f62635a.M(j4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorGroupBy.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T, K, V> extends rx.l<T> {

        /* renamed from: q  reason: collision with root package name */
        static final Object f62636q = new Object();

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.observables.d<K, V>> f62637a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends K> f62638b;

        /* renamed from: c  reason: collision with root package name */
        final rx.functions.p<? super T, ? extends V> f62639c;

        /* renamed from: d  reason: collision with root package name */
        final int f62640d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f62641e;

        /* renamed from: f  reason: collision with root package name */
        final Map<Object, d<K, V>> f62642f;

        /* renamed from: g  reason: collision with root package name */
        final Queue<rx.observables.d<K, V>> f62643g = new ConcurrentLinkedQueue();

        /* renamed from: h  reason: collision with root package name */
        final b f62644h;

        /* renamed from: i  reason: collision with root package name */
        final Queue<K> f62645i;

        /* renamed from: j  reason: collision with root package name */
        final rx.internal.producers.a f62646j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicBoolean f62647k;

        /* renamed from: l  reason: collision with root package name */
        final AtomicLong f62648l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicInteger f62649m;

        /* renamed from: n  reason: collision with root package name */
        Throwable f62650n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f62651o;

        /* renamed from: p  reason: collision with root package name */
        final AtomicInteger f62652p;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorGroupBy.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a<K> implements rx.functions.b<K> {

            /* renamed from: a  reason: collision with root package name */
            final Queue<K> f62653a;

            a(Queue<K> queue) {
                this.f62653a = queue;
            }

            @Override // rx.functions.b
            public void call(K k4) {
                this.f62653a.offer(k4);
            }
        }

        public c(rx.l<? super rx.observables.d<K, V>> lVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, int i4, boolean z3, rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar3) {
            this.f62637a = lVar;
            this.f62638b = pVar;
            this.f62639c = pVar2;
            this.f62640d = i4;
            this.f62641e = z3;
            rx.internal.producers.a aVar = new rx.internal.producers.a();
            this.f62646j = aVar;
            aVar.request(i4);
            this.f62644h = new b(this);
            this.f62647k = new AtomicBoolean();
            this.f62648l = new AtomicLong();
            this.f62649m = new AtomicInteger(1);
            this.f62652p = new AtomicInteger();
            if (pVar3 == null) {
                this.f62642f = new ConcurrentHashMap();
                this.f62645i = null;
                return;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.f62645i = concurrentLinkedQueue;
            this.f62642f = I(pVar3, new a(concurrentLinkedQueue));
        }

        private Map<Object, d<K, V>> I(rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar, rx.functions.b<K> bVar) {
            return pVar.call(bVar);
        }

        void J() {
            if (this.f62652p.getAndIncrement() != 0) {
                return;
            }
            Queue<rx.observables.d<K, V>> queue = this.f62643g;
            rx.l<? super rx.observables.d<K, V>> lVar = this.f62637a;
            int i4 = 1;
            while (!x(this.f62651o, queue.isEmpty(), lVar, queue)) {
                long j4 = this.f62648l.get();
                long j5 = 0;
                while (j5 != j4) {
                    boolean z3 = this.f62651o;
                    rx.observables.d<K, V> poll = queue.poll();
                    boolean z4 = poll == null;
                    if (x(z3, z4, lVar, queue)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    lVar.onNext(poll);
                    j5++;
                }
                if (j5 != 0) {
                    if (j4 != Long.MAX_VALUE) {
                        rx.internal.operators.a.i(this.f62648l, j5);
                    }
                    this.f62646j.request(j5);
                }
                i4 = this.f62652p.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            }
        }

        void L(rx.l<? super rx.observables.d<K, V>> lVar, Queue<?> queue, Throwable th) {
            queue.clear();
            ArrayList<d> arrayList = new ArrayList(this.f62642f.values());
            this.f62642f.clear();
            Queue<K> queue2 = this.f62645i;
            if (queue2 != null) {
                queue2.clear();
            }
            for (d dVar : arrayList) {
                dVar.onError(th);
            }
            lVar.onError(th);
        }

        public void M(long j4) {
            if (j4 >= 0) {
                rx.internal.operators.a.b(this.f62648l, j4);
                J();
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j4);
        }

        public void g() {
            if (this.f62647k.compareAndSet(false, true) && this.f62649m.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62651o) {
                return;
            }
            for (d<K, V> dVar : this.f62642f.values()) {
                dVar.z7();
            }
            this.f62642f.clear();
            Queue<K> queue = this.f62645i;
            if (queue != null) {
                queue.clear();
            }
            this.f62651o = true;
            this.f62649m.decrementAndGet();
            J();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62651o) {
                rx.plugins.c.I(th);
                return;
            }
            this.f62650n = th;
            this.f62651o = true;
            this.f62649m.decrementAndGet();
            J();
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62651o) {
                return;
            }
            Queue<?> queue = this.f62643g;
            rx.l<? super rx.observables.d<K, V>> lVar = this.f62637a;
            try {
                K call = this.f62638b.call(t3);
                boolean z3 = false;
                Object obj = call != null ? call : f62636q;
                d dVar = this.f62642f.get(obj);
                if (dVar == null) {
                    if (this.f62647k.get()) {
                        return;
                    }
                    dVar = d.y7(call, this.f62640d, this, this.f62641e);
                    this.f62642f.put(obj, dVar);
                    this.f62649m.getAndIncrement();
                    z3 = true;
                }
                try {
                    dVar.onNext(this.f62639c.call(t3));
                    if (this.f62645i != null) {
                        while (true) {
                            K poll = this.f62645i.poll();
                            if (poll == null) {
                                break;
                            }
                            d<K, V> dVar2 = this.f62642f.get(poll);
                            if (dVar2 != null) {
                                dVar2.z7();
                            }
                        }
                    }
                    if (z3) {
                        queue.offer(dVar);
                        J();
                    }
                } catch (Throwable th) {
                    unsubscribe();
                    L(lVar, queue, th);
                }
            } catch (Throwable th2) {
                unsubscribe();
                L(lVar, queue, th2);
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62646j.c(gVar);
        }

        public void v(K k4) {
            if (k4 == null) {
                k4 = (K) f62636q;
            }
            if (this.f62642f.remove(k4) == null || this.f62649m.decrementAndGet() != 0) {
                return;
            }
            unsubscribe();
        }

        boolean x(boolean z3, boolean z4, rx.l<? super rx.observables.d<K, V>> lVar, Queue<?> queue) {
            if (z3) {
                Throwable th = this.f62650n;
                if (th != null) {
                    L(lVar, queue, th);
                    return true;
                } else if (z4) {
                    this.f62637a.onCompleted();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorGroupBy.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<K, T> extends rx.observables.d<K, T> {

        /* renamed from: c  reason: collision with root package name */
        final e<T, K> f62654c;

        protected d(K k4, e<T, K> eVar) {
            super(k4, eVar);
            this.f62654c = eVar;
        }

        public static <T, K> d<K, T> y7(K k4, int i4, c<?, K, T> cVar, boolean z3) {
            return new d<>(k4, new e(i4, cVar, k4, z3));
        }

        public void onError(Throwable th) {
            this.f62654c.e(th);
        }

        public void onNext(T t3) {
            this.f62654c.g(t3);
        }

        public void z7() {
            this.f62654c.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorGroupBy.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<T, K> extends AtomicInteger implements rx.g, rx.m, e.a<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: a  reason: collision with root package name */
        final K f62655a;

        /* renamed from: c  reason: collision with root package name */
        final c<?, K, T> f62657c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f62658d;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f62660f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f62661g;

        /* renamed from: b  reason: collision with root package name */
        final Queue<Object> f62656b = new ConcurrentLinkedQueue();

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f62662h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<rx.l<? super T>> f62663i = new AtomicReference<>();

        /* renamed from: j  reason: collision with root package name */
        final AtomicBoolean f62664j = new AtomicBoolean();

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f62659e = new AtomicLong();

        public e(int i4, c<?, K, T> cVar, K k4, boolean z3) {
            this.f62657c = cVar;
            this.f62655a = k4;
            this.f62658d = z3;
        }

        boolean a(boolean z3, boolean z4, rx.l<? super T> lVar, boolean z5) {
            if (this.f62662h.get()) {
                this.f62656b.clear();
                this.f62657c.v(this.f62655a);
                return true;
            } else if (z3) {
                if (z5) {
                    if (z4) {
                        Throwable th = this.f62661g;
                        if (th != null) {
                            lVar.onError(th);
                        } else {
                            lVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f62661g;
                if (th2 != null) {
                    this.f62656b.clear();
                    lVar.onError(th2);
                    return true;
                } else if (z4) {
                    lVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Queue<Object> queue = this.f62656b;
            boolean z3 = this.f62658d;
            rx.l<? super T> lVar = this.f62663i.get();
            int i4 = 1;
            while (true) {
                if (lVar != null) {
                    if (a(this.f62660f, queue.isEmpty(), lVar, z3)) {
                        return;
                    }
                    long j4 = this.f62659e.get();
                    long j5 = 0;
                    while (j5 != j4) {
                        boolean z4 = this.f62660f;
                        Object poll = queue.poll();
                        boolean z5 = poll == null;
                        if (a(z4, z5, lVar, z3)) {
                            return;
                        }
                        if (z5) {
                            break;
                        }
                        lVar.onNext((Object) v.e(poll));
                        j5++;
                    }
                    if (j5 != 0) {
                        if (j4 != Long.MAX_VALUE) {
                            rx.internal.operators.a.i(this.f62659e, j5);
                        }
                        this.f62657c.f62646j.request(j5);
                    }
                }
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
                if (lVar == null) {
                    lVar = this.f62663i.get();
                }
            }
        }

        public void c() {
            this.f62660f = true;
            b();
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void e(Throwable th) {
            this.f62661g = th;
            this.f62660f = true;
            b();
        }

        public void g(T t3) {
            if (t3 == null) {
                this.f62661g = new NullPointerException();
                this.f62660f = true;
            } else {
                this.f62656b.offer(v.j(t3));
            }
            b();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f62662h.get();
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j4);
            } else if (j4 != 0) {
                rx.internal.operators.a.b(this.f62659e, j4);
                b();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f62662h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f62657c.v(this.f62655a);
            }
        }

        public void call(rx.l<? super T> lVar) {
            if (this.f62664j.compareAndSet(false, true)) {
                lVar.add(this);
                lVar.setProducer(this);
                this.f62663i.lazySet(lVar);
                b();
                return;
            }
            lVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }
    }

    public g2(rx.functions.p<? super T, ? extends K> pVar) {
        this(pVar, rx.internal.util.n.c(), rx.internal.util.j.f63940d, false, null);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public g2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
        this(pVar, pVar2, rx.internal.util.j.f63940d, false, null);
    }

    public rx.l<? super T> call(rx.l<? super rx.observables.d<K, V>> lVar) {
        try {
            c cVar = new c(lVar, this.f62628a, this.f62629b, this.f62630c, this.f62631d, this.f62632e);
            lVar.add(rx.subscriptions.f.a(new a(cVar)));
            lVar.setProducer(cVar.f62644h);
            return cVar;
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
            rx.l<? super T> d4 = rx.observers.h.d();
            d4.unsubscribe();
            return d4;
        }
    }

    public g2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar3) {
        this(pVar, pVar2, rx.internal.util.j.f63940d, false, pVar3);
    }

    public g2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, int i4, boolean z3, rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar3) {
        this.f62628a = pVar;
        this.f62629b = pVar2;
        this.f62630c = i4;
        this.f62631d = z3;
        this.f62632e = pVar3;
    }
}
