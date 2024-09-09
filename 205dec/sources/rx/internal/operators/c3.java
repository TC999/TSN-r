package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSkipLast.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final int f62442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSkipLast.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Deque<Object> f62443a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f62444b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f62444b = lVar2;
            this.f62443a = new ArrayDeque();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62444b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62444b.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(T t3) {
            if (c3.this.f62442a == 0) {
                this.f62444b.onNext(t3);
                return;
            }
            if (this.f62443a.size() == c3.this.f62442a) {
                this.f62444b.onNext(v.e(this.f62443a.removeFirst()));
            } else {
                request(1L);
            }
            this.f62443a.offerLast(v.j(t3));
        }
    }

    public c3(int i4) {
        if (i4 >= 0) {
            this.f62442a = i4;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
