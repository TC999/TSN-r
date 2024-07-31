package p640rx.internal.operators;

import p640rx.Completable;
import p640rx.CompletableSubscriber;
import p640rx.Subscription;
import p640rx.exceptions.AssemblyStackTraceException;

/* renamed from: rx.internal.operators.t0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeOnAssemblyCompletable<T> implements Completable.InterfaceC15540j0 {

    /* renamed from: c */
    public static volatile boolean f45885c;

    /* renamed from: a */
    final Completable.InterfaceC15540j0 f45886a;

    /* renamed from: b */
    final String f45887b = OnSubscribeOnAssembly.m1103a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeOnAssemblyCompletable.java */
    /* renamed from: rx.internal.operators.t0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15881a implements CompletableSubscriber {

        /* renamed from: a */
        final CompletableSubscriber f45888a;

        /* renamed from: b */
        final String f45889b;

        public C15881a(CompletableSubscriber completableSubscriber, String str) {
            this.f45888a = completableSubscriber;
            this.f45889b = str;
        }

        @Override // p640rx.CompletableSubscriber
        /* renamed from: a */
        public void mo640a(Subscription subscription) {
            this.f45888a.mo640a(subscription);
        }

        @Override // p640rx.CompletableSubscriber
        public void onCompleted() {
            this.f45888a.onCompleted();
        }

        @Override // p640rx.CompletableSubscriber
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f45889b).attachTo(th);
            this.f45888a.onError(th);
        }
    }

    public OnSubscribeOnAssemblyCompletable(Completable.InterfaceC15540j0 interfaceC15540j0) {
        this.f45886a = interfaceC15540j0;
    }

    @Override // p640rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        this.f45886a.call(new C15881a(completableSubscriber, this.f45887b));
    }
}
