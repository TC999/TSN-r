package rx.internal.util;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.functions.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: IndexedRingBuffer.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class e<E> implements rx.m {

    /* renamed from: e  reason: collision with root package name */
    static final int f63916e;

    /* renamed from: a  reason: collision with root package name */
    private final a<E> f63917a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final b f63918b = new b();

    /* renamed from: c  reason: collision with root package name */
    final AtomicInteger f63919c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    final AtomicInteger f63920d = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: IndexedRingBuffer.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a<E> {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceArray<E> f63921a = new AtomicReferenceArray<>(e.f63916e);

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<a<E>> f63922b = new AtomicReference<>();

        a() {
        }

        a<E> a() {
            if (this.f63922b.get() != null) {
                return this.f63922b.get();
            }
            a<E> aVar = new a<>();
            return this.f63922b.compareAndSet(null, aVar) ? aVar : this.f63922b.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: IndexedRingBuffer.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicIntegerArray f63923a = new AtomicIntegerArray(e.f63916e);

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference<b> f63924b = new AtomicReference<>();

        b() {
        }

        public int a(int i4, int i5) {
            return this.f63923a.getAndSet(i4, i5);
        }

        b b() {
            if (this.f63924b.get() != null) {
                return this.f63924b.get();
            }
            b bVar = new b();
            return this.f63924b.compareAndSet(null, bVar) ? bVar : this.f63924b.get();
        }

        public void c(int i4, int i5) {
            this.f63923a.set(i4, i5);
        }
    }

    static {
        int i4 = i.b() ? 8 : 128;
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                i4 = Integer.parseInt(property);
            } catch (NumberFormatException e4) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e4.getMessage());
            }
        }
        f63916e = i4;
    }

    e() {
    }

    private int F(p<? super E, Boolean> pVar, int i4, int i5) {
        a<E> aVar;
        int i6;
        int i7 = this.f63919c.get();
        a<E> aVar2 = this.f63917a;
        int i8 = f63916e;
        if (i4 >= i8) {
            a<E> G = G(i4);
            i6 = i4;
            i4 %= i8;
            aVar = G;
        } else {
            aVar = aVar2;
            i6 = i4;
        }
        loop0: while (aVar != null) {
            while (i4 < f63916e) {
                if (i6 >= i7 || i6 >= i5) {
                    break loop0;
                }
                Object obj = (E) aVar.f63921a.get(i4);
                if (obj != null && !pVar.call(obj).booleanValue()) {
                    return i6;
                }
                i4++;
                i6++;
            }
            aVar = aVar.f63922b.get();
            i4 = 0;
        }
        return i6;
    }

    private a<E> G(int i4) {
        int i5 = f63916e;
        if (i4 < i5) {
            return this.f63917a;
        }
        int i6 = i4 / i5;
        a<E> aVar = this.f63917a;
        for (int i7 = 0; i7 < i6; i7++) {
            aVar = aVar.a();
        }
        return aVar;
    }

    private synchronized int H() {
        int andIncrement;
        int I = I();
        if (I >= 0) {
            int i4 = f63916e;
            if (I < i4) {
                andIncrement = this.f63918b.a(I, -1);
            } else {
                andIncrement = J(I).a(I % i4, -1);
            }
            if (andIncrement == this.f63919c.get()) {
                this.f63919c.getAndIncrement();
            }
        } else {
            andIncrement = this.f63919c.getAndIncrement();
        }
        return andIncrement;
    }

    private synchronized int I() {
        int i4;
        int i5;
        do {
            i4 = this.f63920d.get();
            if (i4 <= 0) {
                return -1;
            }
            i5 = i4 - 1;
        } while (!this.f63920d.compareAndSet(i4, i5));
        return i5;
    }

    private b J(int i4) {
        int i5 = f63916e;
        if (i4 < i5) {
            return this.f63918b;
        }
        int i6 = i4 / i5;
        b bVar = this.f63918b;
        for (int i7 = 0; i7 < i6; i7++) {
            bVar = bVar.b();
        }
        return bVar;
    }

    public static <T> e<T> K() {
        return new e<>();
    }

    private synchronized void L(int i4) {
        int andIncrement = this.f63920d.getAndIncrement();
        int i5 = f63916e;
        if (andIncrement < i5) {
            this.f63918b.c(andIncrement, i4);
        } else {
            J(andIncrement).c(andIncrement % i5, i4);
        }
    }

    public void M() {
        int i4 = this.f63919c.get();
        int i5 = 0;
        loop0: for (a<E> aVar = this.f63917a; aVar != null; aVar = aVar.f63922b.get()) {
            int i6 = 0;
            while (i6 < f63916e) {
                if (i5 >= i4) {
                    break loop0;
                }
                aVar.f63921a.set(i6, null);
                i6++;
                i5++;
            }
        }
        this.f63919c.set(0);
        this.f63920d.set(0);
    }

    public E N(int i4) {
        E andSet;
        int i5 = f63916e;
        if (i4 < i5) {
            andSet = this.f63917a.f63921a.getAndSet(i4, null);
        } else {
            andSet = G(i4).f63921a.getAndSet(i4 % i5, null);
        }
        L(i4);
        return andSet;
    }

    public int a(E e4) {
        int H = H();
        int i4 = f63916e;
        if (H < i4) {
            this.f63917a.f63921a.set(H, e4);
            return H;
        }
        G(H).f63921a.set(H % i4, e4);
        return H;
    }

    public int b(p<? super E, Boolean> pVar) {
        return d(pVar, 0);
    }

    public int d(p<? super E, Boolean> pVar, int i4) {
        int F = F(pVar, i4, this.f63919c.get());
        if (i4 > 0 && F == this.f63919c.get()) {
            return F(pVar, 0, i4);
        }
        if (F == this.f63919c.get()) {
            return 0;
        }
        return F;
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return false;
    }

    @Override // rx.m
    public void unsubscribe() {
        M();
    }
}
