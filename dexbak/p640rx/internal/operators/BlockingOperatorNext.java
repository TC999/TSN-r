package p640rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Notification;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.operators.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingOperatorNext {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BlockingOperatorNext.java */
    /* renamed from: rx.internal.operators.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15684a<T> implements Iterable<T> {

        /* renamed from: a */
        final /* synthetic */ Observable f45048a;

        C15684a(Observable observable) {
            this.f45048a = observable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C15685b(this.f45048a, new C15686c());
        }
    }

    /* compiled from: BlockingOperatorNext.java */
    /* renamed from: rx.internal.operators.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15685b<T> implements Iterator<T> {

        /* renamed from: a */
        private final C15686c<T> f45049a;

        /* renamed from: b */
        private final Observable<? extends T> f45050b;

        /* renamed from: c */
        private T f45051c;

        /* renamed from: d */
        private boolean f45052d = true;

        /* renamed from: e */
        private boolean f45053e = true;

        /* renamed from: f */
        private Throwable f45054f;

        /* renamed from: g */
        private boolean f45055g;

        C15685b(Observable<? extends T> observable, C15686c<T> c15686c) {
            this.f45050b = observable;
            this.f45049a = c15686c;
        }

        /* renamed from: a */
        private boolean m1280a() {
            try {
                if (!this.f45055g) {
                    this.f45055g = true;
                    this.f45049a.m1278G(1);
                    this.f45050b.m1657d3().m1551q5(this.f45049a);
                }
                Notification<? extends T> m1277H = this.f45049a.m1277H();
                if (m1277H.m1994m()) {
                    this.f45053e = false;
                    this.f45051c = m1277H.m1999h();
                    return true;
                }
                this.f45052d = false;
                if (m1277H.m1996k()) {
                    return false;
                }
                if (m1277H.m1995l()) {
                    Throwable m2000g = m1277H.m2000g();
                    this.f45054f = m2000g;
                    throw C15575a.m1476c(m2000g);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e) {
                this.f45049a.unsubscribe();
                Thread.currentThread().interrupt();
                this.f45054f = e;
                throw C15575a.m1476c(e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f45054f;
            if (th == null) {
                if (this.f45052d) {
                    return !this.f45053e || m1280a();
                }
                return false;
            }
            throw C15575a.m1476c(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f45054f;
            if (th == null) {
                if (hasNext()) {
                    this.f45053e = true;
                    return this.f45051c;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw C15575a.m1476c(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockingOperatorNext.java */
    /* renamed from: rx.internal.operators.d$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15686c<T> extends Subscriber<Notification<? extends T>> {

        /* renamed from: a */
        private final BlockingQueue<Notification<? extends T>> f45056a = new ArrayBlockingQueue(1);

        /* renamed from: b */
        final AtomicInteger f45057b = new AtomicInteger();

        C15686c() {
        }

        @Override // p640rx.Observer
        /* renamed from: F */
        public void onNext(Notification<? extends T> notification) {
            if (this.f45057b.getAndSet(0) == 1 || !notification.m1994m()) {
                while (!this.f45056a.offer(notification)) {
                    Notification<? extends T> poll = this.f45056a.poll();
                    if (poll != null && !poll.m1994m()) {
                        notification = poll;
                    }
                }
            }
        }

        /* renamed from: G */
        void m1278G(int i) {
            this.f45057b.set(i);
        }

        /* renamed from: H */
        public Notification<? extends T> m1277H() throws InterruptedException {
            m1278G(1);
            return this.f45056a.take();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
        }
    }

    private BlockingOperatorNext() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Iterable<T> m1281a(Observable<? extends T> observable) {
        return new C15684a(observable);
    }
}
