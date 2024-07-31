package p640rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.internal.operators.BlockingOperatorToFuture;
import p640rx.internal.util.BlockingUtils;

/* renamed from: rx.singles.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingSingle<T> {

    /* renamed from: a */
    private final Single<? extends T> f46989a;

    /* compiled from: BlockingSingle.java */
    /* renamed from: rx.singles.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16166a extends SingleSubscriber<T> {

        /* renamed from: b */
        final /* synthetic */ AtomicReference f46990b;

        /* renamed from: c */
        final /* synthetic */ CountDownLatch f46991c;

        /* renamed from: d */
        final /* synthetic */ AtomicReference f46992d;

        C16166a(AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
            this.f46990b = atomicReference;
            this.f46991c = countDownLatch;
            this.f46992d = atomicReference2;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f46990b.set(t);
            this.f46991c.countDown();
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            this.f46992d.set(th);
            this.f46991c.countDown();
        }
    }

    private BlockingSingle(Single<? extends T> single) {
        this.f46989a = single;
    }

    /* renamed from: a */
    public static <T> BlockingSingle<T> m449a(Single<? extends T> single) {
        return new BlockingSingle<>(single);
    }

    /* renamed from: b */
    public Future<T> m448b() {
        return BlockingOperatorToFuture.m1275a(this.f46989a.m1340y0());
    }

    /* renamed from: c */
    public T m447c() {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        BlockingUtils.m872a(countDownLatch, this.f46989a.m1372i0(new C16166a(atomicReference, countDownLatch, atomicReference2)));
        Throwable th = (Throwable) atomicReference2.get();
        if (th == null) {
            return (T) atomicReference.get();
        }
        throw C15575a.m1476c(th);
    }
}
