package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BufferUntilSubscriber.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g<T> extends rx.subjects.f<T, T> {

    /* renamed from: d  reason: collision with root package name */
    static final rx.f f62607d = new a();

    /* renamed from: b  reason: collision with root package name */
    final c<T> f62608b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f62609c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BufferUntilSubscriber.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements rx.f {
        a() {
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        @Override // rx.f
        public void onNext(Object obj) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BufferUntilSubscriber.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final c<T> f62610a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: BufferUntilSubscriber.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                b.this.f62610a.set(g.f62607d);
            }
        }

        public b(c<T> cVar) {
            this.f62610a = cVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            boolean z3;
            if (this.f62610a.a(null, lVar)) {
                lVar.add(rx.subscriptions.f.a(new a()));
                synchronized (this.f62610a.f62612a) {
                    c<T> cVar = this.f62610a;
                    z3 = true;
                    if (cVar.f62613b) {
                        z3 = false;
                    } else {
                        cVar.f62613b = true;
                    }
                }
                if (!z3) {
                    return;
                }
                while (true) {
                    Object poll = this.f62610a.f62614c.poll();
                    if (poll != null) {
                        v.a(this.f62610a.get(), poll);
                    } else {
                        synchronized (this.f62610a.f62612a) {
                            if (this.f62610a.f62614c.isEmpty()) {
                                this.f62610a.f62613b = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                lVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BufferUntilSubscriber.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends AtomicReference<rx.f<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;

        /* renamed from: b  reason: collision with root package name */
        boolean f62613b;

        /* renamed from: a  reason: collision with root package name */
        final Object f62612a = new Object();

        /* renamed from: c  reason: collision with root package name */
        final ConcurrentLinkedQueue<Object> f62614c = new ConcurrentLinkedQueue<>();

        c() {
        }

        boolean a(rx.f<? super T> fVar, rx.f<? super T> fVar2) {
            return compareAndSet(fVar, fVar2);
        }
    }

    private g(c<T> cVar) {
        super(new b(cVar));
        this.f62608b = cVar;
    }

    public static <T> g<T> x7() {
        return new g<>(new c());
    }

    private void y7(Object obj) {
        synchronized (this.f62608b.f62612a) {
            this.f62608b.f62614c.add(obj);
            if (this.f62608b.get() != null) {
                c<T> cVar = this.f62608b;
                if (!cVar.f62613b) {
                    this.f62609c = true;
                    cVar.f62613b = true;
                }
            }
        }
        if (!this.f62609c) {
            return;
        }
        while (true) {
            Object poll = this.f62608b.f62614c.poll();
            if (poll == null) {
                return;
            }
            v.a(this.f62608b.get(), poll);
        }
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f62609c) {
            this.f62608b.get().onCompleted();
        } else {
            y7(v.b());
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f62609c) {
            this.f62608b.get().onError(th);
        } else {
            y7(v.c(th));
        }
    }

    @Override // rx.f
    public void onNext(T t3) {
        if (this.f62609c) {
            this.f62608b.get().onNext(t3);
        } else {
            y7(v.j(t3));
        }
    }

    @Override // rx.subjects.f
    public boolean v7() {
        boolean z3;
        synchronized (this.f62608b.f62612a) {
            z3 = this.f62608b.get() != null;
        }
        return z3;
    }
}
