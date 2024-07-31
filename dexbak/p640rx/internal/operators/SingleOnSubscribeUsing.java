package p640rx.internal.operators;

import java.util.Arrays;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.functions.Action1;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.v4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleOnSubscribeUsing<T, Resource> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Func0<Resource> f46045a;

    /* renamed from: b */
    final Func1<? super Resource, ? extends Single<? extends T>> f46046b;

    /* renamed from: c */
    final Action1<? super Resource> f46047c;

    /* renamed from: d */
    final boolean f46048d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnSubscribeUsing.java */
    /* renamed from: rx.internal.operators.v4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15929a extends SingleSubscriber<T> {

        /* renamed from: b */
        final /* synthetic */ Object f46049b;

        /* renamed from: c */
        final /* synthetic */ SingleSubscriber f46050c;

        C15929a(Object obj, SingleSubscriber singleSubscriber) {
            this.f46049b = obj;
            this.f46050c = singleSubscriber;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            SingleOnSubscribeUsing singleOnSubscribeUsing = SingleOnSubscribeUsing.this;
            if (singleOnSubscribeUsing.f46048d) {
                try {
                    singleOnSubscribeUsing.f46047c.call((Object) this.f46049b);
                } catch (Throwable th) {
                    C15575a.m1474e(th);
                    this.f46050c.onError(th);
                    return;
                }
            }
            this.f46050c.mo446d(t);
            SingleOnSubscribeUsing singleOnSubscribeUsing2 = SingleOnSubscribeUsing.this;
            if (singleOnSubscribeUsing2.f46048d) {
                return;
            }
            try {
                singleOnSubscribeUsing2.f46047c.call((Object) this.f46049b);
            } catch (Throwable th2) {
                C15575a.m1474e(th2);
                RxJavaHooks.m576I(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            SingleOnSubscribeUsing.this.m1039a(this.f46050c, this.f46049b, th);
        }
    }

    public SingleOnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Single<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        this.f46045a = func0;
        this.f46046b = func1;
        this.f46047c = action1;
        this.f46048d = z;
    }

    /* renamed from: a */
    void m1039a(SingleSubscriber<? super T> singleSubscriber, Resource resource, Throwable th) {
        C15575a.m1474e(th);
        if (this.f46048d) {
            try {
                this.f46047c.call(resource);
            } catch (Throwable th2) {
                C15575a.m1474e(th2);
                th = new CompositeException(Arrays.asList(th, th2));
            }
        }
        singleSubscriber.onError(th);
        if (this.f46048d) {
            return;
        }
        try {
            this.f46047c.call(resource);
        } catch (Throwable th3) {
            C15575a.m1474e(th3);
            RxJavaHooks.m576I(th3);
        }
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            Resource call = this.f46045a.call();
            try {
                Single<? extends T> call2 = this.f46046b.call(call);
                if (call2 == null) {
                    m1039a(singleSubscriber, call, new NullPointerException("The single"));
                    return;
                }
                C15929a c15929a = new C15929a(call, singleSubscriber);
                singleSubscriber.m743b(c15929a);
                call2.m1372i0(c15929a);
            } catch (Throwable th) {
                m1039a(singleSubscriber, call, th);
            }
        } catch (Throwable th2) {
            C15575a.m1474e(th2);
            singleSubscriber.onError(th2);
        }
    }
}
