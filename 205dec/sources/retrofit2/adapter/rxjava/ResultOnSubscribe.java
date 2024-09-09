package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.e;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.a;
import rx.l;
import rx.plugins.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class ResultOnSubscribe<T> implements e.a<Result<T>> {
    private final e.a<Response<T>> upstream;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class ResultSubscriber<R> extends l<Response<R>> {
        private final l<? super Result<R>> subscriber;

        ResultSubscriber(l<? super Result<R>> lVar) {
            super(lVar);
            this.subscriber = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.subscriber.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.subscriber.onNext(Result.error(th));
                this.subscriber.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.subscriber.onError(th2);
                } catch (OnCompletedFailedException e4) {
                    e = e4;
                    f.c().b().a(e);
                } catch (OnErrorFailedException e5) {
                    e = e5;
                    f.c().b().a(e);
                } catch (OnErrorNotImplementedException e6) {
                    e = e6;
                    f.c().b().a(e);
                } catch (Throwable th3) {
                    a.e(th3);
                    f.c().b().a(new CompositeException(th2, th3));
                }
            }
        }

        @Override // rx.f
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultOnSubscribe(e.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    public void call(l<? super Result<T>> lVar) {
        this.upstream.call(new ResultSubscriber(lVar));
    }
}
