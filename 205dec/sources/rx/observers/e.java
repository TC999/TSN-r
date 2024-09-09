package rx.observers;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SafeSubscriber.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class e<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    private final l<? super T> f64174a;

    /* renamed from: b  reason: collision with root package name */
    boolean f64175b;

    public e(l<? super T> lVar) {
        super(lVar);
        this.f64174a = lVar;
    }

    protected void F(Throwable th) {
        rx.plugins.f.c().b().a(th);
        try {
            this.f64174a.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                rx.plugins.c.I(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e4) {
            try {
                unsubscribe();
                throw e4;
            } catch (Throwable th3) {
                rx.plugins.c.I(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            rx.plugins.c.I(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                rx.plugins.c.I(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    public l<? super T> G() {
        return this.f64174a;
    }

    @Override // rx.f
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (this.f64175b) {
            return;
        }
        this.f64175b = true;
        try {
            this.f64174a.onCompleted();
            try {
                unsubscribe();
            } finally {
            }
        } catch (Throwable th) {
            try {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
                throw new OnCompletedFailedException(th.getMessage(), th);
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } finally {
                }
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f64175b) {
            return;
        }
        this.f64175b = true;
        F(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        try {
            if (this.f64175b) {
                return;
            }
            this.f64174a.onNext(t3);
        } catch (Throwable th) {
            rx.exceptions.a.f(th, this);
        }
    }
}
