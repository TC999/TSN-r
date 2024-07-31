package retrofit2.adapter.rxjava;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class CallEnqueueOnSubscribe<T> implements Observable.InterfaceC15567a<Response<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super Response<T>> subscriber) {
        Call<T> mo60313clone = this.originalCall.mo60313clone();
        final CallArbiter callArbiter = new CallArbiter(mo60313clone, subscriber);
        subscriber.add(callArbiter);
        subscriber.setProducer(callArbiter);
        mo60313clone.enqueue(new Callback<T>() { // from class: retrofit2.adapter.rxjava.CallEnqueueOnSubscribe.1
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                C15575a.m1474e(th);
                callArbiter.emitError(th);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                callArbiter.emitResponse(response);
            }
        });
    }
}
