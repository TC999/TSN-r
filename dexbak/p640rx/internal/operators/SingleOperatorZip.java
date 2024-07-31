package p640rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.FuncN;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.x4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleOperatorZip {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: SingleOperatorZip.java */
    /* renamed from: rx.internal.operators.x4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15968a<R> implements Single.InterfaceC15633t<R> {

        /* renamed from: a */
        final /* synthetic */ Single[] f46172a;

        /* renamed from: b */
        final /* synthetic */ FuncN f46173b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: SingleOperatorZip.java */
        /* renamed from: rx.internal.operators.x4$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15969a<T> extends SingleSubscriber<T> {

            /* renamed from: b */
            final /* synthetic */ Object[] f46174b;

            /* renamed from: c */
            final /* synthetic */ int f46175c;

            /* renamed from: d */
            final /* synthetic */ AtomicInteger f46176d;

            /* renamed from: e */
            final /* synthetic */ SingleSubscriber f46177e;

            /* renamed from: f */
            final /* synthetic */ AtomicBoolean f46178f;

            C15969a(Object[] objArr, int i, AtomicInteger atomicInteger, SingleSubscriber singleSubscriber, AtomicBoolean atomicBoolean) {
                this.f46174b = objArr;
                this.f46175c = i;
                this.f46176d = atomicInteger;
                this.f46177e = singleSubscriber;
                this.f46178f = atomicBoolean;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p640rx.SingleSubscriber
            /* renamed from: d */
            public void mo446d(T t) {
                this.f46174b[this.f46175c] = t;
                if (this.f46176d.decrementAndGet() == 0) {
                    try {
                        this.f46177e.mo446d(C15968a.this.f46173b.call(this.f46174b));
                    } catch (Throwable th) {
                        C15575a.m1474e(th);
                        onError(th);
                    }
                }
            }

            @Override // p640rx.SingleSubscriber
            public void onError(Throwable th) {
                if (this.f46178f.compareAndSet(false, true)) {
                    this.f46177e.onError(th);
                } else {
                    RxJavaHooks.m576I(th);
                }
            }
        }

        C15968a(Single[] singleArr, FuncN funcN) {
            this.f46172a = singleArr;
            this.f46173b = funcN;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SingleSubscriber) ((SingleSubscriber) obj));
        }

        public void call(SingleSubscriber<? super R> singleSubscriber) {
            if (this.f46172a.length == 0) {
                singleSubscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(this.f46172a.length);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            Object[] objArr = new Object[this.f46172a.length];
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            singleSubscriber.m743b(compositeSubscription);
            for (int i = 0; i < this.f46172a.length && !compositeSubscription.isUnsubscribed() && !atomicBoolean.get(); i++) {
                C15969a c15969a = new C15969a(objArr, i, atomicInteger, singleSubscriber, atomicBoolean);
                compositeSubscription.m359a(c15969a);
                if (compositeSubscription.isUnsubscribed() || atomicBoolean.get()) {
                    return;
                }
                this.f46172a[i].m1372i0(c15969a);
            }
        }
    }

    private SingleOperatorZip() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T, R> Single<R> m1001a(Single<? extends T>[] singleArr, FuncN<? extends R> funcN) {
        return Single.m1365m(new C15968a(singleArr, funcN));
    }
}
