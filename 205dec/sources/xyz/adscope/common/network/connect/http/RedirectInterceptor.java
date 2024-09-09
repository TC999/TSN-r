package xyz.adscope.common.network.connect.http;

import xyz.adscope.common.network.BodyRequest;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.UrlRequest;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RedirectInterceptor implements Interceptor {
    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        if (proceed.isRedirect()) {
            Url location = request.url().location(proceed.headers().getLocation());
            Headers headers = request.headers();
            headers.remove("Cookie");
            RequestMethod method = request.method();
            Request build = method.allowBody() ? ((BodyRequest.Builder) BodyRequest.newBuilder(location, method).setHeaders(headers)).setParams(request.copyParams()).body(request.body()).build() : ((UrlRequest.Builder) UrlRequest.newBuilder(location, method).setHeaders(headers)).build();
            IOUtils.closeQuietly(proceed);
            return chain.proceed(build);
        }
        return proceed;
    }
}
