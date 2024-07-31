package p640rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Actions;
import p640rx.internal.operators.NotificationLite;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.subjects.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class SubjectSubscriptionManager<T> extends AtomicReference<C16181b<T>> implements Observable.InterfaceC15567a<T> {
    private static final long serialVersionUID = 6035251036011671568L;

    /* renamed from: a */
    volatile Object f47045a;

    /* renamed from: b */
    boolean f47046b;

    /* renamed from: c */
    Action1<C16182c<T>> f47047c;

    /* renamed from: d */
    Action1<C16182c<T>> f47048d;

    /* renamed from: e */
    Action1<C16182c<T>> f47049e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubjectSubscriptionManager.java */
    /* renamed from: rx.subjects.g$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16180a implements Action0 {

        /* renamed from: a */
        final /* synthetic */ C16182c f47050a;

        C16180a(C16182c c16182c) {
            this.f47050a = c16182c;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            SubjectSubscriptionManager.this.m392f(this.f47050a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SubjectSubscriptionManager.java */
    /* renamed from: rx.subjects.g$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16181b<T> {

        /* renamed from: c */
        static final C16182c[] f47052c;

        /* renamed from: d */
        static final C16181b f47053d;

        /* renamed from: e */
        static final C16181b f47054e;

        /* renamed from: a */
        final boolean f47055a;

        /* renamed from: b */
        final C16182c[] f47056b;

        static {
            C16182c[] c16182cArr = new C16182c[0];
            f47052c = c16182cArr;
            f47053d = new C16181b(true, c16182cArr);
            f47054e = new C16181b(false, c16182cArr);
        }

        public C16181b(boolean z, C16182c[] c16182cArr) {
            this.f47055a = z;
            this.f47056b = c16182cArr;
        }

        /* renamed from: a */
        public C16181b m389a(C16182c c16182c) {
            C16182c[] c16182cArr = this.f47056b;
            int length = c16182cArr.length;
            C16182c[] c16182cArr2 = new C16182c[length + 1];
            System.arraycopy(c16182cArr, 0, c16182cArr2, 0, length);
            c16182cArr2[length] = c16182c;
            return new C16181b(this.f47055a, c16182cArr2);
        }

        /* renamed from: b */
        public C16181b m388b(C16182c c16182c) {
            C16182c[] c16182cArr = this.f47056b;
            int length = c16182cArr.length;
            if (length == 1 && c16182cArr[0] == c16182c) {
                return f47054e;
            }
            if (length == 0) {
                return this;
            }
            int i = length - 1;
            C16182c[] c16182cArr2 = new C16182c[i];
            int i2 = 0;
            for (C16182c c16182c2 : c16182cArr) {
                if (c16182c2 != c16182c) {
                    if (i2 == i) {
                        return this;
                    }
                    c16182cArr2[i2] = c16182c2;
                    i2++;
                }
            }
            if (i2 == 0) {
                return f47054e;
            }
            if (i2 < i) {
                C16182c[] c16182cArr3 = new C16182c[i2];
                System.arraycopy(c16182cArr2, 0, c16182cArr3, 0, i2);
                c16182cArr2 = c16182cArr3;
            }
            return new C16181b(this.f47055a, c16182cArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SubjectSubscriptionManager.java */
    /* renamed from: rx.subjects.g$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16182c<T> implements Observer<T> {

        /* renamed from: a */
        final Subscriber<? super T> f47057a;

        /* renamed from: b */
        boolean f47058b = true;

        /* renamed from: c */
        boolean f47059c;

        /* renamed from: d */
        List<Object> f47060d;

        /* renamed from: e */
        boolean f47061e;

        /* renamed from: f */
        volatile boolean f47062f;

        /* renamed from: g */
        private volatile Object f47063g;

        public C16182c(Subscriber<? super T> subscriber) {
            this.f47057a = subscriber;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: F */
        public void m387F(Object obj) {
            synchronized (this) {
                if (this.f47058b && !this.f47059c) {
                    this.f47058b = false;
                    this.f47059c = obj != null;
                    if (obj != null) {
                        m386G(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0038  */
        /* renamed from: G */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m386G(java.util.List<java.lang.Object> r5, java.lang.Object r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 1
            L2:
                r2 = 0
                if (r5 == 0) goto L1a
                java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L17
            L9:
                boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L17
                if (r3 == 0) goto L1a
                java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L17
                r4.m381d(r3)     // Catch: java.lang.Throwable -> L17
                goto L9
            L17:
                r5 = move-exception
                r0 = 0
                goto L36
            L1a:
                if (r1 == 0) goto L20
                r4.m381d(r6)     // Catch: java.lang.Throwable -> L17
                r1 = 0
            L20:
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L17
                java.util.List<java.lang.Object> r5 = r4.f47060d     // Catch: java.lang.Throwable -> L2e
                r3 = 0
                r4.f47060d = r3     // Catch: java.lang.Throwable -> L2e
                if (r5 != 0) goto L2c
                r4.f47059c = r2     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L34
                return
            L2c:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2e
                goto L2
            L2e:
                r5 = move-exception
                r0 = 0
            L30:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L34
                throw r5     // Catch: java.lang.Throwable -> L32
            L32:
                r5 = move-exception
                goto L36
            L34:
                r5 = move-exception
                goto L30
            L36:
                if (r0 != 0) goto L40
                monitor-enter(r4)
                r4.f47059c = r2     // Catch: java.lang.Throwable -> L3d
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                goto L40
            L3d:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                throw r5
            L40:
                goto L42
            L41:
                throw r5
            L42:
                goto L41
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.subjects.SubjectSubscriptionManager.C16182c.m386G(java.util.List, java.lang.Object):void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: H */
        public void m385H(Object obj) {
            if (!this.f47061e) {
                synchronized (this) {
                    this.f47058b = false;
                    if (this.f47059c) {
                        if (this.f47060d == null) {
                            this.f47060d = new ArrayList();
                        }
                        this.f47060d.add(obj);
                        return;
                    }
                    this.f47061e = true;
                }
            }
            NotificationLite.m1052a(this.f47057a, obj);
        }

        /* renamed from: I */
        Observer<? super T> m384I() {
            return this.f47057a;
        }

        /* renamed from: J */
        public <I> I m383J() {
            return (I) this.f47063g;
        }

        /* renamed from: K */
        public void m382K(Object obj) {
            this.f47063g = obj;
        }

        /* renamed from: d */
        void m381d(Object obj) {
            if (obj != null) {
                NotificationLite.m1052a(this.f47057a, obj);
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f47057a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f47057a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f47057a.onNext(t);
        }
    }

    public SubjectSubscriptionManager() {
        super(C16181b.f47054e);
        this.f47046b = true;
        this.f47047c = Actions.m1455a();
        this.f47048d = Actions.m1455a();
        this.f47049e = Actions.m1455a();
    }

    /* renamed from: a */
    boolean m397a(C16182c<T> c16182c) {
        C16181b<T> c16181b;
        do {
            c16181b = get();
            if (c16181b.f47055a) {
                this.f47049e.call(c16182c);
                return false;
            }
        } while (!compareAndSet(c16181b, c16181b.m389a(c16182c)));
        this.f47048d.call(c16182c);
        return true;
    }

    /* renamed from: b */
    void m396b(Subscriber<? super T> subscriber, C16182c<T> c16182c) {
        subscriber.add(Subscriptions.m346a(new C16180a(c16182c)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Object m395c() {
        return this.f47045a;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public C16182c<T>[] m394d(Object obj) {
        m391g(obj);
        return get().f47056b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public C16182c<T>[] m393e() {
        return get().f47056b;
    }

    /* renamed from: f */
    void m392f(C16182c<T> c16182c) {
        C16181b<T> c16181b;
        C16181b<T> m388b;
        do {
            c16181b = get();
            if (c16181b.f47055a || (m388b = c16181b.m388b(c16182c)) == c16181b) {
                return;
            }
        } while (!compareAndSet(c16181b, m388b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m391g(Object obj) {
        this.f47045a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public C16182c<T>[] m390h(Object obj) {
        m391g(obj);
        this.f47046b = false;
        if (get().f47055a) {
            return C16181b.f47052c;
        }
        return getAndSet(C16181b.f47053d).f47056b;
    }

    public void call(Subscriber<? super T> subscriber) {
        C16182c<T> c16182c = new C16182c<>(subscriber);
        m396b(subscriber, c16182c);
        this.f47047c.call(c16182c);
        if (!subscriber.isUnsubscribed() && m397a(c16182c) && subscriber.isUnsubscribed()) {
            m392f(c16182c);
        }
    }
}
