package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Response;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.a;
import rx.g;
import rx.l;
import rx.m;
import rx.plugins.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class CallArbiter<T> extends AtomicInteger implements m, g {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final l<? super Response<T>> subscriber;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallArbiter(Call<T> call, l<? super Response<T>> lVar) {
        super(0);
        this.call = call;
        this.subscriber = lVar;
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
            } catch (OnCompletedFailedException e4) {
                e = e4;
                f.c().b().a(e);
            } catch (OnErrorFailedException e5) {
                e = e5;
                f.c().b().a(e);
            } catch (OnErrorNotImplementedException e6) {
                e = e6;
                f.c().b().a(e);
            } catch (Throwable th) {
                a.e(th);
                f.c().b().a(th);
            }
        } catch (OnCompletedFailedException e7) {
            e = e7;
            f.c().b().a(e);
        } catch (OnErrorFailedException e8) {
            e = e8;
            f.c().b().a(e);
        } catch (OnErrorNotImplementedException e9) {
            e = e9;
            f.c().b().a(e);
        } catch (Throwable th2) {
            a.e(th2);
            try {
                this.subscriber.onError(th2);
            } catch (OnCompletedFailedException e10) {
                e = e10;
                f.c().b().a(e);
            } catch (OnErrorFailedException e11) {
                e = e11;
                f.c().b().a(e);
            } catch (OnErrorNotImplementedException e12) {
                e = e12;
                f.c().b().a(e);
            } catch (Throwable th3) {
                a.e(th3);
                f.c().b().a(new CompositeException(th2, th3));
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
        } catch (OnCompletedFailedException e4) {
            e = e4;
            f.c().b().a(e);
        } catch (OnErrorFailedException e5) {
            e = e5;
            f.c().b().a(e);
        } catch (OnErrorNotImplementedException e6) {
            e = e6;
            f.c().b().a(e);
        } catch (Throwable th2) {
            a.e(th2);
            f.c().b().a(new CompositeException(th, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitResponse(Response<T> response) {
        while (true) {
            int i4 = get();
            if (i4 == 0) {
                this.response = response;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else if (i4 != 1) {
                if (i4 != 2 && i4 != 3) {
                    throw new IllegalStateException("Unknown state: " + i4);
                }
                throw new AssertionError();
            } else if (compareAndSet(1, 3)) {
                deliverResponse(response);
                return;
            }
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.call.isCanceled();
    }

    @Override // rx.g
    public void request(long j4) {
        if (j4 == 0) {
            return;
        }
        while (true) {
            int i4 = get();
            if (i4 != 0) {
                if (i4 == 1) {
                    return;
                }
                if (i4 != 2) {
                    if (i4 == 3) {
                        return;
                    }
                    throw new IllegalStateException("Unknown state: " + i4);
                } else if (compareAndSet(2, 3)) {
                    deliverResponse(this.response);
                    return;
                }
            } else if (compareAndSet(0, 1)) {
                return;
            }
        }
    }

    @Override // rx.m
    public void unsubscribe() {
        this.call.cancel();
    }
}
