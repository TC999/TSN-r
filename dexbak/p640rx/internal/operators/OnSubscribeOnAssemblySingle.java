package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.AssemblyStackTraceException;

/* renamed from: rx.internal.operators.u0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeOnAssemblySingle<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: c */
    public static volatile boolean f45968c;

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45969a;

    /* renamed from: b */
    final String f45970b = OnSubscribeOnAssembly.m1103a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeOnAssemblySingle.java */
    /* renamed from: rx.internal.operators.u0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15908a<T> extends SingleSubscriber<T> {

        /* renamed from: b */
        final SingleSubscriber<? super T> f45971b;

        /* renamed from: c */
        final String f45972c;

        public C15908a(SingleSubscriber<? super T> singleSubscriber, String str) {
            this.f45971b = singleSubscriber;
            this.f45972c = str;
            singleSubscriber.m743b(this);
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f45971b.mo446d(t);
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f45972c).attachTo(th);
            this.f45971b.onError(th);
        }
    }

    public OnSubscribeOnAssemblySingle(Single.InterfaceC15633t<T> interfaceC15633t) {
        this.f45969a = interfaceC15633t;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        this.f45969a.call(new C15908a(singleSubscriber, this.f45970b));
    }
}
