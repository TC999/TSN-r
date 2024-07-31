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
final class ResultOnSubscribe<T> implements Observable.InterfaceC15567a<Result<T>> {
    private final Observable.InterfaceC15567a<Response<T>> upstream;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class ResultSubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super Result<R>> subscriber;

        ResultSubscriber(Subscriber<? super Result<R>> subscriber) {
            super(subscriber);
            this.subscriber = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.subscriber.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            try {
                this.subscriber.onNext(Result.error(th));
                this.subscriber.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.subscriber.onError(th2);
                } catch (OnCompletedFailedException e) {
                    e = e;
                    RxJavaPlugins.m507c().m508b().m587a(e);
                } catch (OnErrorFailedException e2) {
                    e = e2;
                    RxJavaPlugins.m507c().m508b().m587a(e);
                } catch (OnErrorNotImplementedException e3) {
                    e = e3;
                    RxJavaPlugins.m507c().m508b().m587a(e);
                } catch (Throwable th3) {
                    C15575a.m1474e(th3);
                    RxJavaPlugins.m507c().m508b().m587a(new CompositeException(th2, th3));
                }
            }
        }

        @Override // p640rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultOnSubscribe(Observable.InterfaceC15567a<Response<T>> interfaceC15567a) {
        this.upstream = interfaceC15567a;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super Result<T>> subscriber) {
        this.upstream.call(new ResultSubscriber(subscriber));
    }
}
