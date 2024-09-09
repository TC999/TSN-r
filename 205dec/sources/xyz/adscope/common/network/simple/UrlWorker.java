package xyz.adscope.common.network.simple;

import java.lang.reflect.Type;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Call;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class UrlWorker<S, F> extends BasicWorker<SimpleUrlRequest, S, F> {

    /* renamed from: g  reason: collision with root package name */
    public Call f65015g;

    public UrlWorker(SimpleUrlRequest simpleUrlRequest, Type type, Type type2) {
        super(simpleUrlRequest, type, type2);
    }

    @Override // xyz.adscope.common.network.simple.BasicWorker
    public Response a(SimpleUrlRequest simpleUrlRequest) {
        Call call = new Call(simpleUrlRequest);
        this.f65015g = call;
        return call.execute();
    }

    @Override // xyz.adscope.common.network.simple.BasicWorker
    public void cancel() {
        Call call = this.f65015g;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.f65015g.asyncCancel();
    }
}
