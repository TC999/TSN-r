package p640rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Subscription;

/* renamed from: rx.subscriptions.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RefCountSubscription implements Subscription {

    /* renamed from: c */
    static final C16190b f47087c = new C16190b(false, 0);

    /* renamed from: a */
    private final Subscription f47088a;

    /* renamed from: b */
    final AtomicReference<C16190b> f47089b = new AtomicReference<>(f47087c);

    /* compiled from: RefCountSubscription.java */
    /* renamed from: rx.subscriptions.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16189a extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 7005765588239987643L;

        /* renamed from: a */
        final RefCountSubscription f47090a;

        public C16189a(RefCountSubscription refCountSubscription) {
            this.f47090a = refCountSubscription;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get() != 0;
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.f47090a.m353b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RefCountSubscription.java */
    /* renamed from: rx.subscriptions.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16190b {

        /* renamed from: a */
        final boolean f47091a;

        /* renamed from: b */
        final int f47092b;

        C16190b(boolean z, int i) {
            this.f47091a = z;
            this.f47092b = i;
        }

        /* renamed from: a */
        C16190b m351a() {
            return new C16190b(this.f47091a, this.f47092b + 1);
        }

        /* renamed from: b */
        C16190b m350b() {
            return new C16190b(this.f47091a, this.f47092b - 1);
        }

        /* renamed from: c */
        C16190b m349c() {
            return new C16190b(true, this.f47092b);
        }
    }

    public RefCountSubscription(Subscription subscription) {
        if (subscription != null) {
            this.f47088a = subscription;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    /* renamed from: d */
    private void m352d(C16190b c16190b) {
        if (c16190b.f47091a && c16190b.f47092b == 0) {
            this.f47088a.unsubscribe();
        }
    }

    /* renamed from: a */
    public Subscription m354a() {
        C16190b c16190b;
        AtomicReference<C16190b> atomicReference = this.f47089b;
        do {
            c16190b = atomicReference.get();
            if (c16190b.f47091a) {
                return Subscriptions.m342e();
            }
        } while (!atomicReference.compareAndSet(c16190b, c16190b.m351a()));
        return new C16189a(this);
    }

    /* renamed from: b */
    void m353b() {
        C16190b c16190b;
        C16190b m350b;
        AtomicReference<C16190b> atomicReference = this.f47089b;
        do {
            c16190b = atomicReference.get();
            m350b = c16190b.m350b();
        } while (!atomicReference.compareAndSet(c16190b, m350b));
        m352d(m350b);
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f47089b.get().f47091a;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        C16190b c16190b;
        C16190b m349c;
        AtomicReference<C16190b> atomicReference = this.f47089b;
        do {
            c16190b = atomicReference.get();
            if (c16190b.f47091a) {
                return;
            }
            m349c = c16190b.m349c();
        } while (!atomicReference.compareAndSet(c16190b, m349c));
        m352d(m349c);
    }
}
