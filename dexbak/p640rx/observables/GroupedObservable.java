package p640rx.observables;

import p640rx.Observable;
import p640rx.Subscriber;

/* renamed from: rx.observables.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GroupedObservable<K, T> extends Observable<T> {

    /* renamed from: b */
    private final K f46878b;

    /* compiled from: GroupedObservable.java */
    /* renamed from: rx.observables.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16116a implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final /* synthetic */ Observable f46879a;

        C16116a(Observable observable) {
            this.f46879a = observable;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            this.f46879a.m1822I6(subscriber);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GroupedObservable(K k, Observable.InterfaceC15567a<T> interfaceC15567a) {
        super(interfaceC15567a);
        this.f46878b = k;
    }

    /* renamed from: v7 */
    public static <K, T> GroupedObservable<K, T> m691v7(K k, Observable.InterfaceC15567a<T> interfaceC15567a) {
        return new GroupedObservable<>(k, interfaceC15567a);
    }

    /* renamed from: w7 */
    public static <K, T> GroupedObservable<K, T> m690w7(K k, Observable<T> observable) {
        return new GroupedObservable<>(k, new C16116a(observable));
    }

    /* renamed from: x7 */
    public K m689x7() {
        return this.f46878b;
    }
}
