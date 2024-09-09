package rx;

import rx.functions.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleEmitter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface j<T> {
    void a(m mVar);

    void b(n nVar);

    void onError(Throwable th);

    void onSuccess(T t3);
}
