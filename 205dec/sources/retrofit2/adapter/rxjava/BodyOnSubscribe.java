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
final class BodyOnSubscribe<T> implements e.a<T> {
    private final e.a<Response<T>> upstream;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class BodySubscriber<R> extends l<Response<R>> {
        private final l<? super R> subscriber;
        private boolean subscriberTerminated;

        BodySubscriber(l<? super R> lVar) {
            super(lVar);
            this.subscriber = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.subscriberTerminated) {
                return;
            }
            this.subscriber.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.subscriberTerminated) {
                this.subscriber.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            assertionError.initCause(th);
            f.c().b().a(assertionError);
        }

        @Override // rx.f
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.subscriber.onNext(response.body());
                return;
            }
            this.subscriberTerminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.subscriber.onError(httpException);
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
                f.c().b().a(new CompositeException(httpException, th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyOnSubscribe(e.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    public void call(l<? super T> lVar) {
        this.upstream.call(new BodySubscriber(lVar));
    }
}
