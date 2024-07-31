package p640rx.observers;

import java.util.Arrays;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.exceptions.OnCompletedFailedException;
import p640rx.exceptions.OnErrorFailedException;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.exceptions.UnsubscribeFailedException;
import p640rx.plugins.RxJavaHooks;
import p640rx.plugins.RxJavaPlugins;

/* renamed from: rx.observers.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SafeSubscriber<T> extends Subscriber<T> {

    /* renamed from: a */
    private final Subscriber<? super T> f46905a;

    /* renamed from: b */
    boolean f46906b;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.f46905a = subscriber;
    }

    /* renamed from: F */
    protected void m639F(Throwable th) {
        RxJavaPlugins.m507c().m508b().m587a(th);
        try {
            this.f46905a.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                RxJavaHooks.m576I(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e) {
            try {
                unsubscribe();
                throw e;
            } catch (Throwable th3) {
                RxJavaHooks.m576I(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            RxJavaHooks.m576I(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                RxJavaHooks.m576I(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    /* renamed from: G */
    public Subscriber<? super T> m638G() {
        return this.f46905a;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (this.f46906b) {
            return;
        }
        this.f46906b = true;
        try {
            this.f46905a.onCompleted();
            try {
                unsubscribe();
            } finally {
            }
        } catch (Throwable th) {
            try {
                C15575a.m1474e(th);
                RxJavaHooks.m576I(th);
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

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        C15575a.m1474e(th);
        if (this.f46906b) {
            return;
        }
        this.f46906b = true;
        m639F(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        try {
            if (this.f46906b) {
                return;
            }
            this.f46905a.onNext(t);
        } catch (Throwable th) {
            C15575a.m1473f(th, this);
        }
    }
}
