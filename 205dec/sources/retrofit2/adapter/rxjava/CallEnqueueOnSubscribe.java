package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.e;
import rx.exceptions.a;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class CallEnqueueOnSubscribe<T> implements e.a<Response<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    public void call(l<? super Response<T>> lVar) {
        Call<T> mo286clone = this.originalCall.mo286clone();
        final CallArbiter callArbiter = new CallArbiter(mo286clone, lVar);
        lVar.add(callArbiter);
        lVar.setProducer(callArbiter);
        mo286clone.enqueue(new Callback<T>() { // from class: retrofit2.adapter.rxjava.CallEnqueueOnSubscribe.1
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                a.e(th);
                callArbiter.emitError(th);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                callArbiter.emitResponse(response);
            }
        });
    }
}
