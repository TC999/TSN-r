package p640rx.internal.operators;

import java.util.NoSuchElementException;
import p640rx.Observable;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.a1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OnSubscribeSingle<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    private final Observable<T> f44890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeSingle.java */
    /* renamed from: rx.internal.operators.a1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15645a extends Subscriber<T> {

        /* renamed from: a */
        private boolean f44891a;

        /* renamed from: b */
        private boolean f44892b;

        /* renamed from: c */
        private T f44893c;

        /* renamed from: d */
        final /* synthetic */ SingleSubscriber f44894d;

        C15645a(SingleSubscriber singleSubscriber) {
            this.f44894d = singleSubscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f44891a) {
                return;
            }
            if (this.f44892b) {
                this.f44894d.mo446d(this.f44893c);
            } else {
                this.f44894d.onError(new NoSuchElementException("Observable emitted no items"));
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f44894d.onError(th);
            unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f44892b) {
                this.f44891a = true;
                this.f44894d.onError(new IllegalArgumentException("Observable emitted too many elements"));
                unsubscribe();
                return;
            }
            this.f44892b = true;
            this.f44893c = t;
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(2L);
        }
    }

    public OnSubscribeSingle(Observable<T> observable) {
        this.f44890a = observable;
    }

    /* renamed from: a */
    public static <T> OnSubscribeSingle<T> m1319a(Observable<T> observable) {
        return new OnSubscribeSingle<>(observable);
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15645a c15645a = new C15645a(singleSubscriber);
        singleSubscriber.m743b(c15645a);
        this.f44890a.m1822I6(c15645a);
    }
}
