package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorThrowable;
import p640rx.functions.Func1;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.u4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleOnSubscribeMap<T, R> implements Single.InterfaceC15633t<R> {

    /* renamed from: a */
    final Single<T> f46004a;

    /* renamed from: b */
    final Func1<? super T, ? extends R> f46005b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnSubscribeMap.java */
    /* renamed from: rx.internal.operators.u4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15916a<T, R> extends SingleSubscriber<T> {

        /* renamed from: b */
        final SingleSubscriber<? super R> f46006b;

        /* renamed from: c */
        final Func1<? super T, ? extends R> f46007c;

        /* renamed from: d */
        boolean f46008d;

        public C15916a(SingleSubscriber<? super R> singleSubscriber, Func1<? super T, ? extends R> func1) {
            this.f46006b = singleSubscriber;
            this.f46007c = func1;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            try {
                this.f46006b.mo446d(this.f46007c.call(t));
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            if (this.f46008d) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f46008d = true;
            this.f46006b.onError(th);
        }
    }

    public SingleOnSubscribeMap(Single<T> single, Func1<? super T, ? extends R> func1) {
        this.f46004a = single;
        this.f46005b = func1;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super R> singleSubscriber) {
        C15916a c15916a = new C15916a(singleSubscriber, this.f46005b);
        singleSubscriber.m743b(c15916a);
        this.f46004a.m1372i0(c15916a);
    }
}
