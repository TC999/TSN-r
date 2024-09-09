package xyz.adscope.common.network.urlconnect;

import android.os.Build;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.connect.ConnectFactory;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class URLConnectionFactory implements ConnectFactory {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {
        public Builder() {
        }

        public URLConnectionFactory build() {
            return new URLConnectionFactory(this);
        }
    }

    public URLConnectionFactory(Builder builder) {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean a(RequestMethod requestMethod) {
        boolean allowBody = requestMethod.allowBody();
        return Build.VERSION.SDK_INT < 21 ? allowBody && requestMethod != RequestMethod.DELETE : allowBody;
    }

    @Override // xyz.adscope.common.network.connect.ConnectFactory
    public Connection connect(Request request) {
        URL url = new URL(request.url().toString(true));
        LogUtil.i(CommonConstants.TAG, "URLConnectionFactory connect url : " + url);
        Proxy proxy = request.proxy();
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
        httpURLConnection.setConnectTimeout(request.connectTimeout());
        httpURLConnection.setReadTimeout(request.readTimeout());
        httpURLConnection.setInstanceFollowRedirects(false);
        if (httpURLConnection instanceof HttpsURLConnection) {
            SSLSocketFactory sslSocketFactory = request.sslSocketFactory();
            if (sslSocketFactory != null) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sslSocketFactory);
            }
            HostnameVerifier hostnameVerifier = request.hostnameVerifier();
            if (hostnameVerifier != null) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
            }
        }
        RequestMethod method = request.method();
        httpURLConnection.setRequestMethod(method.toString());
        httpURLConnection.setDoInput(true);
        boolean a4 = a(method);
        httpURLConnection.setDoOutput(a4);
        Headers headers = request.headers();
        if (a4) {
            long contentLength = headers.getContentLength();
            if (contentLength <= 2147483647L) {
                httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
            } else if (Build.VERSION.SDK_INT >= 19) {
                httpURLConnection.setFixedLengthStreamingMode(contentLength);
            } else {
                httpURLConnection.setChunkedStreamingMode(262144);
            }
        }
        headers.set("Connection", Build.VERSION.SDK_INT > 19 ? headers.get("Connection").get(0) : "close");
        for (Map.Entry<String, String> entry : Headers.getRequestHeaders(headers).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.connect();
        return new URLConnection(httpURLConnection);
    }
}
