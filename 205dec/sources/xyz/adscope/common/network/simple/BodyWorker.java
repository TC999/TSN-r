package xyz.adscope.common.network.simple;

import java.lang.reflect.Type;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Call;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class BodyWorker<S, F> extends BasicWorker<SimpleBodyRequest, S, F> {

    /* renamed from: g  reason: collision with root package name */
    public Call f64974g;

    public BodyWorker(SimpleBodyRequest simpleBodyRequest, Type type, Type type2) {
        super(simpleBodyRequest, type, type2);
    }

    @Override // xyz.adscope.common.network.simple.BasicWorker
    public Response a(SimpleBodyRequest simpleBodyRequest) {
        Call call = new Call(simpleBodyRequest);
        this.f64974g = call;
        return call.execute();
    }

    @Override // xyz.adscope.common.network.simple.BasicWorker
    public void cancel() {
        Call call = this.f64974g;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.f64974g.asyncCancel();
    }
}
