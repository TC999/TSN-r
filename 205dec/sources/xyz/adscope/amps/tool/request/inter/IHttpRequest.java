package xyz.adscope.amps.tool.request.inter;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IHttpRequest<T> {
    void doRequestWithJson(String str, String str2, IHttpResponseCallback<T> iHttpResponseCallback);

    void requestWithGetMethod(String str, IHttpResponseCallback iHttpResponseCallback);

    void requestWithPostMethod(String str, String str2, IHttpResponseCallback iHttpResponseCallback);
}
