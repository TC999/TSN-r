package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Response;
import rx.e;
import rx.exceptions.a;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class CallExecuteOnSubscribe<T> implements e.a<Response<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    public void call(l<? super Response<T>> lVar) {
        Call<T> mo286clone = this.originalCall.mo286clone();
        CallArbiter callArbiter = new CallArbiter(mo286clone, lVar);
        lVar.add(callArbiter);
        lVar.setProducer(callArbiter);
        try {
            callArbiter.emitResponse(mo286clone.execute());
        } catch (Throwable th) {
            a.e(th);
            callArbiter.emitError(th);
        }
    }
}
