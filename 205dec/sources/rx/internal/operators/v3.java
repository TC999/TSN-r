package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorToObservableList.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v3<T> implements e.b<List<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorToObservableList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f63470a;

        /* renamed from: b  reason: collision with root package name */
        List<T> f63471b = new LinkedList();

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f63472c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.l f63473d;

        a(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f63472c = singleDelayedProducer;
            this.f63473d = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63470a) {
                return;
            }
            this.f63470a = true;
            try {
                ArrayList arrayList = new ArrayList(this.f63471b);
                this.f63471b = null;
                this.f63472c.setValue(arrayList);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63473d.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63470a) {
                return;
            }
            this.f63471b.add(t3);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorToObservableList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final v3<Object> f63475a = new v3<>();

        b() {
        }
    }

    v3() {
    }

    public static <T> v3<T> a() {
        return (v3<T>) b.f63475a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        a aVar = new a(singleDelayedProducer, lVar);
        lVar.add(aVar);
        lVar.setProducer(singleDelayedProducer);
        return aVar;
    }
}
