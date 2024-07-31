package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.w4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleOperatorOnErrorResumeNext<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    private final Single<? extends T> f46121a;

    /* renamed from: b */
    final Func1<Throwable, ? extends Single<? extends T>> f46122b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOperatorOnErrorResumeNext.java */
    /* renamed from: rx.internal.operators.w4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15953a implements Func1<Throwable, Single<? extends T>> {

        /* renamed from: a */
        final /* synthetic */ Single f46123a;

        C15953a(Single single) {
            this.f46123a = single;
        }

        @Override // p640rx.functions.Func1
        public Single<? extends T> call(Throwable th) {
            return this.f46123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOperatorOnErrorResumeNext.java */
    /* renamed from: rx.internal.operators.w4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15954b extends SingleSubscriber<T> {

        /* renamed from: b */
        final /* synthetic */ SingleSubscriber f46124b;

        C15954b(SingleSubscriber singleSubscriber) {
            this.f46124b = singleSubscriber;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f46124b.mo446d(t);
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            try {
                SingleOperatorOnErrorResumeNext.this.f46122b.call(th).m1372i0(this.f46124b);
            } catch (Throwable th2) {
                C15575a.m1471h(th2, this.f46124b);
            }
        }
    }

    private SingleOperatorOnErrorResumeNext(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        if (single == null) {
            throw new NullPointerException("originalSingle must not be null");
        }
        if (func1 != null) {
            this.f46121a = single;
            this.f46122b = func1;
            return;
        }
        throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
    }

    /* renamed from: a */
    public static <T> SingleOperatorOnErrorResumeNext<T> m1009a(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        return new SingleOperatorOnErrorResumeNext<>(single, func1);
    }

    /* renamed from: b */
    public static <T> SingleOperatorOnErrorResumeNext<T> m1008b(Single<? extends T> single, Single<? extends T> single2) {
        if (single2 != null) {
            return new SingleOperatorOnErrorResumeNext<>(single, new C15953a(single2));
        }
        throw new NullPointerException("resumeSingleInCaseOfError must not be null");
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15954b c15954b = new C15954b(singleSubscriber);
        singleSubscriber.m743b(c15954b);
        this.f46121a.m1372i0(c15954b);
    }
}
