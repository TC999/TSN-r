package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.exceptions.OnCompletedFailedException;
import p640rx.exceptions.OnErrorFailedException;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class CallArbiter<T> extends AtomicInteger implements Subscription, Producer {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final Subscriber<? super Response<T>> subscriber;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallArbiter(Call<T> call, Subscriber<? super Response<T>> subscriber) {
        super(0);
        this.call = call;
        this.subscriber = subscriber;
    }

    private void deliverResponse(Response<T> response) {
        try {
            if (!isUnsubscribed()) {
                this.subscriber.onNext(response);
            }
            try {
                if (isUnsubscribed()) {
                    return;
                }
                this.subscriber.onCompleted();
            } catch (OnCompletedFailedException e) {
                e = e;
                RxJavaPlugins.m507c().m508b().m587a(e);
            } catch (OnErrorFailedException e2) {
                e = e2;
                RxJavaPlugins.m507c().m508b().m587a(e);
            } catch (OnErrorNotImplementedException e3) {
                e = e3;
                RxJavaPlugins.m507c().m508b().m587a(e);
            } catch (Throwable th) {
                C15575a.m1474e(th);
                RxJavaPlugins.m507c().m508b().m587a(th);
            }
        } catch (OnCompletedFailedException e4) {
            e = e4;
            RxJavaPlugins.m507c().m508b().m587a(e);
        } catch (OnErrorFailedException e5) {
            e = e5;
            RxJavaPlugins.m507c().m508b().m587a(e);
        } catch (OnErrorNotImplementedException e6) {
            e = e6;
            RxJavaPlugins.m507c().m508b().m587a(e);
        } catch (Throwable th2) {
            C15575a.m1474e(th2);
            try {
                this.subscriber.onError(th2);
            } catch (OnCompletedFailedException e7) {
                e = e7;
                RxJavaPlugins.m507c().m508b().m587a(e);
            } catch (OnErrorFailedException e8) {
                e = e8;
                RxJavaPlugins.m507c().m508b().m587a(e);
            } catch (OnErrorNotImplementedException e9) {
                e = e9;
                RxJavaPlugins.m507c().m508b().m587a(e);
            } catch (Throwable th3) {
                C15575a.m1474e(th3);
                RxJavaPlugins.m507c().m508b().m587a(new CompositeException(th2, th3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitError(Throwable th) {
        set(3);
        if (isUnsubscribed()) {
            return;
        }
        try {
            this.subscriber.onError(th);
        } catch (OnCompletedFailedException e) {
            e = e;
            RxJavaPlugins.m507c().m508b().m587a(e);
        } catch (OnErrorFailedException e2) {
            e = e2;
            RxJavaPlugins.m507c().m508b().m587a(e);
        } catch (OnErrorNotImplementedException e3) {
            e = e3;
            RxJavaPlugins.m507c().m508b().m587a(e);
        } catch (Throwable th2) {
            C15575a.m1474e(th2);
            RxJavaPlugins.m507c().m508b().m587a(new CompositeException(th, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitResponse(Response<T> response) {
        while (true) {
            int i = get();
            if (i == 0) {
                this.response = response;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("Unknown state: " + i);
                }
                throw new AssertionError();
            } else if (compareAndSet(1, 3)) {
                deliverResponse(response);
                return;
            }
        }
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.call.isCanceled();
    }

    @Override // p640rx.Producer
    public void request(long j) {
        if (j == 0) {
            return;
        }
        while (true) {
            int i = get();
            if (i != 0) {
                if (i == 1) {
                    return;
                }
                if (i != 2) {
                    if (i == 3) {
                        return;
                    }
                    throw new IllegalStateException("Unknown state: " + i);
                } else if (compareAndSet(2, 3)) {
                    deliverResponse(this.response);
                    return;
                }
            } else if (compareAndSet(0, 1)) {
                return;
            }
        }
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.call.cancel();
    }
}
