package rx.observers;

import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SafeCompletableSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class d implements rx.d, m {

    /* renamed from: a  reason: collision with root package name */
    final rx.d f64171a;

    /* renamed from: b  reason: collision with root package name */
    m f64172b;

    /* renamed from: c  reason: collision with root package name */
    boolean f64173c;

    public d(rx.d dVar) {
        this.f64171a = dVar;
    }

    @Override // rx.d
    public void a(m mVar) {
        this.f64172b = mVar;
        try {
            this.f64171a.a(this);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            mVar.unsubscribe();
            onError(th);
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f64173c || this.f64172b.isUnsubscribed();
    }

    @Override // rx.d
    public void onCompleted() {
        if (this.f64173c) {
            return;
        }
        this.f64173c = true;
        try {
            this.f64171a.onCompleted();
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // rx.d
    public void onError(Throwable th) {
        rx.plugins.c.I(th);
        if (this.f64173c) {
            return;
        }
        this.f64173c = true;
        try {
            this.f64171a.onError(th);
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f64172b.unsubscribe();
    }
}
