package rx.internal.util;

import rx.Notification;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ActionNotificationObserver.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class a<T> implements rx.f<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<Notification<? super T>> f63880a;

    public a(rx.functions.b<Notification<? super T>> bVar) {
        this.f63880a = bVar;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f63880a.call(Notification.b());
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f63880a.call(Notification.d(th));
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f63880a.call(Notification.e(t3));
    }
}
