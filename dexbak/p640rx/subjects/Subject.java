package p640rx.subjects;

import p640rx.Observable;
import p640rx.Observer;

/* renamed from: rx.subjects.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class Subject<T, R> extends Observable<R> implements Observer<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public Subject(Observable.InterfaceC15567a<R> interfaceC15567a) {
        super(interfaceC15567a);
    }

    /* renamed from: v7 */
    public abstract boolean mo371v7();

    /* renamed from: w7 */
    public final SerializedSubject<T, R> m398w7() {
        if (getClass() == SerializedSubject.class) {
            return (SerializedSubject) this;
        }
        return new SerializedSubject<>(this);
    }
}
