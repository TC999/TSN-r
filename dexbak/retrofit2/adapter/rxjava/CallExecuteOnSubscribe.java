package retrofit2.adapter.rxjava;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class CallExecuteOnSubscribe<T> implements Observable.InterfaceC15567a<Response<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super Response<T>> subscriber) {
        Call<T> mo60313clone = this.originalCall.mo60313clone();
        CallArbiter callArbiter = new CallArbiter(mo60313clone, subscriber);
        subscriber.add(callArbiter);
        subscriber.setProducer(callArbiter);
        try {
            callArbiter.emitResponse(mo60313clone.execute());
        } catch (Throwable th) {
            C15575a.m1474e(th);
            callArbiter.emitError(th);
        }
    }
}
