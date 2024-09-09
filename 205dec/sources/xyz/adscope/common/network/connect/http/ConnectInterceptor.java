package xyz.adscope.common.network.connect.http;

import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestBody;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.ConnectFactory;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.network.connect.Network;
import xyz.adscope.common.network.connect.StreamBody;
import xyz.adscope.common.network.cookie.CookieManager;
import xyz.adscope.common.network.exception.ConnectException;
import xyz.adscope.common.network.exception.ConnectTimeoutError;
import xyz.adscope.common.network.exception.HostError;
import xyz.adscope.common.network.exception.ReadException;
import xyz.adscope.common.network.exception.ReadTimeoutError;
import xyz.adscope.common.network.exception.URLError;
import xyz.adscope.common.network.exception.WriteException;
import xyz.adscope.common.network.util.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ConnectInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final CookieManager f64883a = new CookieManager(Kalle.getConfig().getCookieStore());

    /* renamed from: b  reason: collision with root package name */
    public final ConnectFactory f64884b = Kalle.getConfig().getConnectFactory();

    /* renamed from: c  reason: collision with root package name */
    public final Network f64885c = Kalle.getConfig().getNetwork();

    /* renamed from: d  reason: collision with root package name */
    public Connection f64886d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64887e;

    public final Headers a(Map<String, List<String>> map) {
        Headers headers = new Headers();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            headers.add(entry.getKey(), entry.getValue());
        }
        return headers;
    }

    public final Connection a(Request request) {
        try {
            Headers headers = request.headers();
            URI uri = new URI(request.url().toString());
            List<String> list = this.f64883a.get(uri);
            if (list != null && !list.isEmpty()) {
                headers.add("Cookie", list);
            }
            headers.set("Host", uri.getHost());
            return this.f64884b.connect(request);
        } catch (MalformedURLException e4) {
            throw new URLError(String.format("The url is malformed: %1$s.", request.url()), e4);
        } catch (SocketTimeoutException e5) {
            throw new ConnectTimeoutError(String.format("Connect time out: %1$s.", request.url()), e5);
        } catch (URISyntaxException e6) {
            throw new URLError(String.format("The url syntax error: %1$s.", request.url()), e6);
        } catch (UnknownHostException e7) {
            throw new HostError(String.format("Hostname can not be resolved: %1$s.", request.url()), e7);
        } catch (Exception e8) {
            throw new ConnectException(String.format("An unknown exception: %1$s.", request.url()), e8);
        }
    }

    public final void a(RequestBody requestBody) {
        try {
            OutputStream outputStream = this.f64886d.getOutputStream();
            requestBody.writeTo(IOUtils.toBufferedOutputStream(outputStream));
            IOUtils.closeQuietly(outputStream);
        } catch (Exception e4) {
            throw new WriteException(e4);
        }
    }

    public final Response b(Request request) {
        try {
            int code = this.f64886d.getCode();
            Headers a4 = a(this.f64886d.getHeaders());
            List<String> list = a4.get("Set-Cookie");
            if (list != null && !list.isEmpty()) {
                this.f64883a.add(URI.create(request.url().toString()), list);
            }
            return Response.newBuilder().code(code).headers(a4).body(new StreamBody(a4.getContentType(), this.f64886d.getInputStream())).locationUrl(code == 302 ? this.f64886d.getLocationUrl() : "").build();
        } catch (SocketTimeoutException e4) {
            throw new ReadTimeoutError(String.format("Read data time out: %1$s.", request.url()), e4);
        } catch (Exception e5) {
            throw new ReadException(e5);
        }
    }

    public void cancel() {
        this.f64887e = true;
        Connection connection = this.f64886d;
        if (connection != null) {
            connection.disconnect();
        }
    }

    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        if (this.f64887e) {
            throw new CancellationException("The request has been cancelled.");
        }
        Request request = chain.request();
        if (request.method().allowBody()) {
            Headers headers = request.headers();
            RequestBody body = request.body();
            headers.set("Content-Length", Long.toString(body.contentLength()));
            headers.set("Content-Type", body.contentType());
            this.f64886d = a(request);
            a(body);
        } else {
            this.f64886d = a(request);
        }
        return b(request);
    }
}
