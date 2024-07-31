package p640rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.subjects.Subject;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BufferUntilSubscriber<T> extends Subject<T, T> {

    /* renamed from: d */
    static final Observer f45176d = new C15716a();

    /* renamed from: b */
    final C15719c<T> f45177b;

    /* renamed from: c */
    private boolean f45178c;

    /* compiled from: BufferUntilSubscriber.java */
    /* renamed from: rx.internal.operators.g$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15716a implements Observer {
        C15716a() {
        }

        @Override // p640rx.Observer
        public void onCompleted() {
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
        }

        @Override // p640rx.Observer
        public void onNext(Object obj) {
        }
    }

    /* compiled from: BufferUntilSubscriber.java */
    /* renamed from: rx.internal.operators.g$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15717b<T> implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final C15719c<T> f45179a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BufferUntilSubscriber.java */
        /* renamed from: rx.internal.operators.g$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15718a implements Action0 {
            C15718a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15717b.this.f45179a.set(BufferUntilSubscriber.f45176d);
            }
        }

        public C15717b(C15719c<T> c15719c) {
            this.f45179a = c15719c;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            boolean z;
            if (this.f45179a.m1254a(null, subscriber)) {
                subscriber.add(Subscriptions.m346a(new C15718a()));
                synchronized (this.f45179a.f45181a) {
                    C15719c<T> c15719c = this.f45179a;
                    z = true;
                    if (c15719c.f45182b) {
                        z = false;
                    } else {
                        c15719c.f45182b = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.f45179a.f45183c.poll();
                    if (poll != null) {
                        NotificationLite.m1052a(this.f45179a.get(), poll);
                    } else {
                        synchronized (this.f45179a.f45181a) {
                            if (this.f45179a.f45183c.isEmpty()) {
                                this.f45179a.f45182b = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                subscriber.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BufferUntilSubscriber.java */
    /* renamed from: rx.internal.operators.g$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15719c<T> extends AtomicReference<Observer<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;

        /* renamed from: b */
        boolean f45182b;

        /* renamed from: a */
        final Object f45181a = new Object();

        /* renamed from: c */
        final ConcurrentLinkedQueue<Object> f45183c = new ConcurrentLinkedQueue<>();

        C15719c() {
        }

        /* renamed from: a */
        boolean m1254a(Observer<? super T> observer, Observer<? super T> observer2) {
            return compareAndSet(observer, observer2);
        }
    }

    private BufferUntilSubscriber(C15719c<T> c15719c) {
        super(new C15717b(c15719c));
        this.f45177b = c15719c;
    }

    /* renamed from: x7 */
    public static <T> BufferUntilSubscriber<T> m1256x7() {
        return new BufferUntilSubscriber<>(new C15719c());
    }

    /* renamed from: y7 */
    private void m1255y7(Object obj) {
        synchronized (this.f45177b.f45181a) {
            this.f45177b.f45183c.add(obj);
            if (this.f45177b.get() != null) {
                C15719c<T> c15719c = this.f45177b;
                if (!c15719c.f45182b) {
                    this.f45178c = true;
                    c15719c.f45182b = true;
                }
            }
        }
        if (!this.f45178c) {
            return;
        }
        while (true) {
            Object poll = this.f45177b.f45183c.poll();
            if (poll == null) {
                return;
            }
            NotificationLite.m1052a(this.f45177b.get(), poll);
        }
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        if (this.f45178c) {
            this.f45177b.get().onCompleted();
        } else {
            m1255y7(NotificationLite.m1051b());
        }
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        if (this.f45178c) {
            this.f45177b.get().onError(th);
        } else {
            m1255y7(NotificationLite.m1050c(th));
        }
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        if (this.f45178c) {
            this.f45177b.get().onNext(t);
        } else {
            m1255y7(NotificationLite.m1043j(t));
        }
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        boolean z;
        synchronized (this.f45177b.f45181a) {
            z = this.f45177b.get() != null;
        }
        return z;
    }
}
