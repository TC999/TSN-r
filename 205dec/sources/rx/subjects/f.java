package rx.subjects;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: Subject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class f<T, R> extends rx.e<R> implements rx.f<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public f(e.a<R> aVar) {
        super(aVar);
    }

    public abstract boolean v7();

    public final e<T, R> w7() {
        if (getClass() == e.class) {
            return (e) this;
        }
        return new e<>(this);
    }
}
