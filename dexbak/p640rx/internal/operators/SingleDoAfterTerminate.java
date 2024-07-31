package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.i4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleDoAfterTerminate<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single<T> f45361a;

    /* renamed from: b */
    final Action0 f45362b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleDoAfterTerminate.java */
    /* renamed from: rx.internal.operators.i4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15756a<T> extends SingleSubscriber<T> {

        /* renamed from: b */
        final SingleSubscriber<? super T> f45363b;

        /* renamed from: c */
        final Action0 f45364c;

        public C15756a(SingleSubscriber<? super T> singleSubscriber, Action0 action0) {
            this.f45363b = singleSubscriber;
            this.f45364c = action0;
        }

        /* renamed from: F */
        void m1207F() {
            try {
                this.f45364c.call();
            } catch (Throwable th) {
                C15575a.m1474e(th);
                RxJavaHooks.m576I(th);
            }
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            try {
                this.f45363b.mo446d(t);
            } finally {
                m1207F();
            }
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            try {
                this.f45363b.onError(th);
            } finally {
                m1207F();
            }
        }
    }

    public SingleDoAfterTerminate(Single<T> single, Action0 action0) {
        this.f45361a = single;
        this.f45362b = action0;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15756a c15756a = new C15756a(singleSubscriber, this.f45362b);
        singleSubscriber.m743b(c15756a);
        this.f45361a.m1372i0(c15756a);
    }
}
