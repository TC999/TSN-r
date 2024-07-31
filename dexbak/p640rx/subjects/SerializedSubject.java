package p640rx.subjects;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.observers.SerializedObserver;

/* renamed from: rx.subjects.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SerializedSubject<T, R> extends Subject<T, R> {

    /* renamed from: b */
    private final SerializedObserver<T> f47042b;

    /* renamed from: c */
    private final Subject<T, R> f47043c;

    /* compiled from: SerializedSubject.java */
    /* renamed from: rx.subjects.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C16179a implements Observable.InterfaceC15567a<R> {

        /* renamed from: a */
        final /* synthetic */ Subject f47044a;

        C16179a(Subject subject) {
            this.f47044a = subject;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super R> subscriber) {
            this.f47044a.m1822I6(subscriber);
        }
    }

    public SerializedSubject(Subject<T, R> subject) {
        super(new C16179a(subject));
        this.f47043c = subject;
        this.f47042b = new SerializedObserver<>(subject);
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f47042b.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f47042b.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f47042b.onNext(t);
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        return this.f47043c.mo371v7();
    }
}
