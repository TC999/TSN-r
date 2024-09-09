package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorToObservableSortedList.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w3<T> implements e.b<List<T>, T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator f63542c = new c();

    /* renamed from: a  reason: collision with root package name */
    final Comparator<? super T> f63543a;

    /* renamed from: b  reason: collision with root package name */
    final int f63544b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorToObservableSortedList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.q f63545a;

        a(rx.functions.q qVar) {
            this.f63545a = qVar;
        }

        @Override // java.util.Comparator
        public int compare(T t3, T t4) {
            return ((Integer) this.f63545a.call(t3, t4)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorToObservableSortedList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        List<T> f63547a;

        /* renamed from: b  reason: collision with root package name */
        boolean f63548b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f63549c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.l f63550d;

        b(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f63549c = singleDelayedProducer;
            this.f63550d = lVar;
            this.f63547a = new ArrayList(w3.this.f63544b);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63548b) {
                return;
            }
            this.f63548b = true;
            List<T> list = this.f63547a;
            this.f63547a = null;
            try {
                Collections.sort(list, w3.this.f63543a);
                this.f63549c.setValue(list);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63550d.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63548b) {
                return;
            }
            this.f63547a.add(t3);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorToObservableSortedList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c implements Comparator<Object> {
        c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    public w3(int i4) {
        this.f63543a = f63542c;
        this.f63544b = i4;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        b bVar = new b(singleDelayedProducer, lVar);
        lVar.add(bVar);
        lVar.setProducer(singleDelayedProducer);
        return bVar;
    }

    public w3(rx.functions.q<? super T, ? super T, Integer> qVar, int i4) {
        this.f63544b = i4;
        this.f63543a = new a(qVar);
    }
}
