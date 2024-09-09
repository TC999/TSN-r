package rx.subjects;

import rx.e;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SerializedSubject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class e<T, R> extends f<T, R> {

    /* renamed from: b  reason: collision with root package name */
    private final rx.observers.f<T> f64311b;

    /* renamed from: c  reason: collision with root package name */
    private final f<T, R> f64312c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SerializedSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class a implements e.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64313a;

        a(f fVar) {
            this.f64313a = fVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l) ((l) obj));
        }

        public void call(l<? super R> lVar) {
            this.f64313a.I6(lVar);
        }
    }

    public e(f<T, R> fVar) {
        super(new a(fVar));
        this.f64312c = fVar;
        this.f64311b = new rx.observers.f<>(fVar);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f64311b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f64311b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64311b.onNext(t3);
    }

    @Override // rx.subjects.f
    public boolean v7() {
        return this.f64312c.v7();
    }
}
