package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableOnSubscribeConcatArray implements Completable.InterfaceC15540j0 {

    /* renamed from: a */
    final Completable[] f45467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableOnSubscribeConcatArray.java */
    /* renamed from: rx.internal.operators.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15780a extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: a */
        final CompletableSubscriber f45468a;

        /* renamed from: b */
        final Completable[] f45469b;

        /* renamed from: c */
        int f45470c;

        /* renamed from: d */
        final SerialSubscription f45471d = new SerialSubscription();

        public C15780a(CompletableSubscriber completableSubscriber, Completable[] completableArr) {
            this.f45468a = completableSubscriber;
            this.f45469b = completableArr;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45471d.m347b(subscription);
        }

        /* renamed from: b */
        void m1181b() {
            if (!this.f45471d.isUnsubscribed() && getAndIncrement() == 0) {
                Completable[] completableArr = this.f45469b;
                while (!this.f45471d.isUnsubscribed()) {
                    int i = this.f45470c;
                    this.f45470c = i + 1;
                    if (i == completableArr.length) {
                        this.f45468a.onCompleted();
                        return;
                    }
                    completableArr[i].m1967G0(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            m1181b();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.f45468a.onError(th);
        }
    }

    public CompletableOnSubscribeConcatArray(Completable[] completableArr) {
        this.f45467a = completableArr;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        C15780a c15780a = new C15780a(completableSubscriber, this.f45467a);
        completableSubscriber.mo640a(c15780a.f45471d);
        c15780a.m1181b();
    }
}
