package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeMergeArray implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Completable[] f45589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeMergeArray.java */
    /* renamed from: rx.internal.operators.o$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15806a implements CompletableSubscriber {

        /* renamed from: a */
        final /* synthetic */ CompositeSubscription f45590a;

        /* renamed from: b */
        final /* synthetic */ AtomicBoolean f45591b;

        /* renamed from: c */
        final /* synthetic */ CompletableSubscriber f45592c;

        /* renamed from: d */
        final /* synthetic */ AtomicInteger f45593d;

        C15806a(CompositeSubscription compositeSubscription, AtomicBoolean atomicBoolean, CompletableSubscriber completableSubscriber, AtomicInteger atomicInteger) {
            this.f45590a = compositeSubscription;
            this.f45591b = atomicBoolean;
            this.f45592c = completableSubscriber;
            this.f45593d = atomicInteger;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45590a.m359a(subscription);
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            if (this.f45593d.decrementAndGet() == 0 && this.f45591b.compareAndSet(false, true)) {
                this.f45592c.onCompleted();
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f45590a.unsubscribe();
            if (this.f45591b.compareAndSet(false, true)) {
                this.f45592c.onError(th);
            } else {
                RxJavaHooks.m576I(th);
            }
        }
    }

    public CompletableOnSubscribeMergeArray(Completable[] completableArr) {
        this.f45589a = completableArr;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        boolean z = true;
        AtomicInteger atomicInteger = new AtomicInteger(this.f45589a.length + 1);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        completableSubscriber.mo640a(compositeSubscription);
        Completable[] completableArr = this.f45589a;
        int length = completableArr.length;
        boolean z2 = false;
        int i = 0;
        while (i < length) {
            Completable completable = completableArr[i];
            if (compositeSubscription.isUnsubscribed()) {
                return;
            }
            if (completable == null) {
                compositeSubscription.unsubscribe();
                Throwable nullPointerException = new NullPointerException("A completable source is null");
                if (atomicBoolean.compareAndSet(z2, z)) {
                    completableSubscriber.onError(nullPointerException);
                    return;
                }
                RxJavaHooks.m576I(nullPointerException);
            }
            completable.m1967G0(new C15806a(compositeSubscription, atomicBoolean, completableSubscriber, atomicInteger));
            i++;
            z = true;
            z2 = false;
        }
        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
            completableSubscriber.onCompleted();
        }
    }
}
