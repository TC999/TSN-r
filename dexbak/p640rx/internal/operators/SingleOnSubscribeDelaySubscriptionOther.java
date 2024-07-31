package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscriber;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.t4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleOnSubscribeDelaySubscriptionOther<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single<? extends T> f45959a;

    /* renamed from: b */
    final Observable<?> f45960b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
    /* renamed from: rx.internal.operators.t4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15906a extends SingleSubscriber<T> {

        /* renamed from: b */
        final /* synthetic */ SingleSubscriber f45961b;

        C15906a(SingleSubscriber singleSubscriber) {
            this.f45961b = singleSubscriber;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f45961b.mo446d(t);
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            this.f45961b.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
    /* renamed from: rx.internal.operators.t4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15907b extends Subscriber<Object> {

        /* renamed from: a */
        boolean f45963a;

        /* renamed from: b */
        final /* synthetic */ SingleSubscriber f45964b;

        /* renamed from: c */
        final /* synthetic */ SerialSubscription f45965c;

        C15907b(SingleSubscriber singleSubscriber, SerialSubscription serialSubscription) {
            this.f45964b = singleSubscriber;
            this.f45965c = serialSubscription;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45963a) {
                return;
            }
            this.f45963a = true;
            this.f45965c.m347b(this.f45964b);
            SingleOnSubscribeDelaySubscriptionOther.this.f45959a.m1372i0(this.f45964b);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45963a) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45963a = true;
            this.f45964b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(Object obj) {
            onCompleted();
        }
    }

    public SingleOnSubscribeDelaySubscriptionOther(Single<? extends T> single, Observable<?> observable) {
        this.f45959a = single;
        this.f45960b = observable;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15906a c15906a = new C15906a(singleSubscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        singleSubscriber.m743b(serialSubscription);
        C15907b c15907b = new C15907b(c15906a, serialSubscription);
        serialSubscription.m347b(c15907b);
        this.f45960b.m1551q5(c15907b);
    }
}
