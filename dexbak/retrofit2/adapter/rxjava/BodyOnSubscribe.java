package retrofit2.adapter.rxjava;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.exceptions.OnCompletedFailedException;
import p640rx.exceptions.OnErrorFailedException;
import p640rx.exceptions.OnErrorNotImplementedException;
import p640rx.plugins.RxJavaPlugins;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class BodyOnSubscribe<T> implements Observable.InterfaceC15567a<T> {
    private final Observable.InterfaceC15567a<Response<T>> upstream;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class BodySubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super R> subscriber;
        private boolean subscriberTerminated;

        BodySubscriber(Subscriber<? super R> subscriber) {
            super(subscriber);
            this.subscriber = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.subscriberTerminated) {
                return;
            }
            this.subscriber.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!this.subscriberTerminated) {
                this.subscriber.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.m507c().m508b().m587a(assertionError);
        }

        @Override // p640rx.Observer
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
                RxJavaPlugins.m507c().m508b().m587a(new CompositeException(httpException, th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyOnSubscribe(Observable.InterfaceC15567a<Response<T>> interfaceC15567a) {
        this.upstream = interfaceC15567a;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        this.upstream.call(new BodySubscriber(subscriber));
    }
}
