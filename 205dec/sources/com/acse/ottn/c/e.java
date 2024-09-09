package com.acse.ottn.c;

import androidx.annotation.Nullable;
import com.acse.ottn.util.ra;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e extends EventListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5317a = "HttpEventListener";

    /* renamed from: b  reason: collision with root package name */
    public static final EventListener.Factory f5318b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final long f5319c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5320d;

    /* renamed from: e  reason: collision with root package name */
    private StringBuilder f5321e;

    public e(long j4, HttpUrl httpUrl, long j5) {
        this.f5319c = j4;
        this.f5320d = j5;
        StringBuilder sb = new StringBuilder(httpUrl.toString());
        sb.append(" ");
        sb.append(j4);
        sb.append(":");
        this.f5321e = sb;
    }

    private void a(String str) {
        long nanoTime = System.nanoTime() - this.f5320d;
        StringBuilder sb = this.f5321e;
        Locale locale = Locale.CHINA;
        double d4 = nanoTime;
        Double.isNaN(d4);
        sb.append(String.format(locale, "%.3f-%s", Double.valueOf(d4 / 1.0E9d), str));
        sb.append(";");
        if (str.equalsIgnoreCase("callEnd") || str.equalsIgnoreCase("callFailed")) {
            ra.a("HttpEventListener", this.f5321e.toString());
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        a("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        a("callFailed");
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        a("callStart");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        a("connectEnd");
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        a("connectFailed");
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        a("connectStart");
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        a("connectionAcquired");
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        a("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        a("dnsEnd");
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        a("dnsStart");
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j4) {
        super.requestBodyEnd(call, j4);
        a("requestBodyEnd");
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        a("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        a("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        a("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j4) {
        super.responseBodyEnd(call, j4);
        a("responseBodyEnd");
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        a("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        a("responseHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        a("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        a("secureConnectEnd");
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        a("secureConnectStart");
    }
}
