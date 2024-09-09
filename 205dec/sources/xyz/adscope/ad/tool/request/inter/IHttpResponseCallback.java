package xyz.adscope.ad.tool.request.inter;

import xyz.adscope.common.network.simple.SimpleCallback;
import xyz.adscope.common.network.simple.SimpleResponse;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class IHttpResponseCallback<T> extends SimpleCallback<T> {
    public abstract void failCallback(String str, int i4);

    @Override // xyz.adscope.common.network.simple.Callback
    public void onResponse(SimpleResponse<T, String> simpleResponse) {
        if (simpleResponse.isSucceed()) {
            successCallback(simpleResponse.succeed());
        } else {
            failCallback(simpleResponse.failed(), simpleResponse.code());
        }
    }

    public abstract void successCallback(T t3);
}
