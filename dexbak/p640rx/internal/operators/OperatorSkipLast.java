package p640rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.internal.operators.c3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorSkipLast<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final int f45011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipLast.java */
    /* renamed from: rx.internal.operators.c3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15675a extends Subscriber<T> {

        /* renamed from: a */
        private final Deque<Object> f45012a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45013b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15675a(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f45013b = subscriber2;
            this.f45012a = new ArrayDeque();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45013b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45013b.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p640rx.Observer
        public void onNext(T t) {
            if (OperatorSkipLast.this.f45011a == 0) {
                this.f45013b.onNext(t);
                return;
            }
            if (this.f45012a.size() == OperatorSkipLast.this.f45011a) {
                this.f45013b.onNext(NotificationLite.m1048e(this.f45012a.removeFirst()));
            } else {
                request(1L);
            }
            this.f45012a.offerLast(NotificationLite.m1043j(t));
        }
    }

    public OperatorSkipLast(int i) {
        if (i >= 0) {
            this.f45011a = i;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new C15675a(subscriber, subscriber);
    }
}
