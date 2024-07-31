package p640rx.internal.util;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p640rx.Subscription;
import p640rx.functions.Func1;

/* renamed from: rx.internal.util.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class IndexedRingBuffer<E> implements Subscription {

    /* renamed from: e */
    static final int f46485e;

    /* renamed from: a */
    private final C16047a<E> f46486a = new C16047a<>();

    /* renamed from: b */
    private final C16048b f46487b = new C16048b();

    /* renamed from: c */
    final AtomicInteger f46488c = new AtomicInteger();

    /* renamed from: d */
    final AtomicInteger f46489d = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndexedRingBuffer.java */
    /* renamed from: rx.internal.util.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16047a<E> {

        /* renamed from: a */
        final AtomicReferenceArray<E> f46490a = new AtomicReferenceArray<>(IndexedRingBuffer.f46485e);

        /* renamed from: b */
        final AtomicReference<C16047a<E>> f46491b = new AtomicReference<>();

        C16047a() {
        }

        /* renamed from: a */
        C16047a<E> m859a() {
            if (this.f46491b.get() != null) {
                return this.f46491b.get();
            }
            C16047a<E> c16047a = new C16047a<>();
            return this.f46491b.compareAndSet(null, c16047a) ? c16047a : this.f46491b.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IndexedRingBuffer.java */
    /* renamed from: rx.internal.util.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16048b {

        /* renamed from: a */
        private final AtomicIntegerArray f46492a = new AtomicIntegerArray(IndexedRingBuffer.f46485e);

        /* renamed from: b */
        private final AtomicReference<C16048b> f46493b = new AtomicReference<>();

        C16048b() {
        }

        /* renamed from: a */
        public int m858a(int i, int i2) {
            return this.f46492a.getAndSet(i, i2);
        }

        /* renamed from: b */
        C16048b m857b() {
            if (this.f46493b.get() != null) {
                return this.f46493b.get();
            }
            C16048b c16048b = new C16048b();
            return this.f46493b.compareAndSet(null, c16048b) ? c16048b : this.f46493b.get();
        }

        /* renamed from: c */
        public void m856c(int i, int i2) {
            this.f46492a.set(i, i2);
        }
    }

    static {
        int i = PlatformDependent.m838b() ? 8 : 128;
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        f46485e = i;
    }

    IndexedRingBuffer() {
    }

    /* renamed from: F */
    private int m871F(Func1<? super E, Boolean> func1, int i, int i2) {
        C16047a<E> c16047a;
        int i3;
        int i4 = this.f46488c.get();
        C16047a<E> c16047a2 = this.f46486a;
        int i5 = f46485e;
        if (i >= i5) {
            C16047a<E> m870G = m870G(i);
            i3 = i;
            i %= i5;
            c16047a = m870G;
        } else {
            c16047a = c16047a2;
            i3 = i;
        }
        loop0: while (c16047a != null) {
            while (i < f46485e) {
                if (i3 >= i4 || i3 >= i2) {
                    break loop0;
                }
                Object obj = (E) c16047a.f46490a.get(i);
                if (obj != null && !func1.call(obj).booleanValue()) {
                    return i3;
                }
                i++;
                i3++;
            }
            c16047a = c16047a.f46491b.get();
            i = 0;
        }
        return i3;
    }

    /* renamed from: G */
    private C16047a<E> m870G(int i) {
        int i2 = f46485e;
        if (i < i2) {
            return this.f46486a;
        }
        int i3 = i / i2;
        C16047a<E> c16047a = this.f46486a;
        for (int i4 = 0; i4 < i3; i4++) {
            c16047a = c16047a.m859a();
        }
        return c16047a;
    }

    /* renamed from: H */
    private synchronized int m869H() {
        int andIncrement;
        int m868I = m868I();
        if (m868I >= 0) {
            int i = f46485e;
            if (m868I < i) {
                andIncrement = this.f46487b.m858a(m868I, -1);
            } else {
                andIncrement = m867J(m868I).m858a(m868I % i, -1);
            }
            if (andIncrement == this.f46488c.get()) {
                this.f46488c.getAndIncrement();
            }
        } else {
            andIncrement = this.f46488c.getAndIncrement();
        }
        return andIncrement;
    }

    /* renamed from: I */
    private synchronized int m868I() {
        int i;
        int i2;
        do {
            i = this.f46489d.get();
            if (i <= 0) {
                return -1;
            }
            i2 = i - 1;
        } while (!this.f46489d.compareAndSet(i, i2));
        return i2;
    }

    /* renamed from: J */
    private C16048b m867J(int i) {
        int i2 = f46485e;
        if (i < i2) {
            return this.f46487b;
        }
        int i3 = i / i2;
        C16048b c16048b = this.f46487b;
        for (int i4 = 0; i4 < i3; i4++) {
            c16048b = c16048b.m857b();
        }
        return c16048b;
    }

    /* renamed from: K */
    public static <T> IndexedRingBuffer<T> m866K() {
        return new IndexedRingBuffer<>();
    }

    /* renamed from: L */
    private synchronized void m865L(int i) {
        int andIncrement = this.f46489d.getAndIncrement();
        int i2 = f46485e;
        if (andIncrement < i2) {
            this.f46487b.m856c(andIncrement, i);
        } else {
            m867J(andIncrement).m856c(andIncrement % i2, i);
        }
    }

    /* renamed from: M */
    public void m864M() {
        int i = this.f46488c.get();
        int i2 = 0;
        loop0: for (C16047a<E> c16047a = this.f46486a; c16047a != null; c16047a = c16047a.f46491b.get()) {
            int i3 = 0;
            while (i3 < f46485e) {
                if (i2 >= i) {
                    break loop0;
                }
                c16047a.f46490a.set(i3, null);
                i3++;
                i2++;
            }
        }
        this.f46488c.set(0);
        this.f46489d.set(0);
    }

    /* renamed from: N */
    public E m863N(int i) {
        E andSet;
        int i2 = f46485e;
        if (i < i2) {
            andSet = this.f46486a.f46490a.getAndSet(i, null);
        } else {
            andSet = m870G(i).f46490a.getAndSet(i % i2, null);
        }
        m865L(i);
        return andSet;
    }

    /* renamed from: a */
    public int m862a(E e) {
        int m869H = m869H();
        int i = f46485e;
        if (m869H < i) {
            this.f46486a.f46490a.set(m869H, e);
            return m869H;
        }
        m870G(m869H).f46490a.set(m869H % i, e);
        return m869H;
    }

    /* renamed from: b */
    public int m861b(Func1<? super E, Boolean> func1) {
        return m860d(func1, 0);
    }

    /* renamed from: d */
    public int m860d(Func1<? super E, Boolean> func1, int i) {
        int m871F = m871F(func1, i, this.f46488c.get());
        if (i > 0 && m871F == this.f46488c.get()) {
            return m871F(func1, 0, i);
        }
        if (m871F == this.f46488c.get()) {
            return 0;
        }
        return m871F;
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return false;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        m864M();
    }
}
