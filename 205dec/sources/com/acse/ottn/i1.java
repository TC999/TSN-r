package com.acse.ottn;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i1 extends EventListener {

    /* renamed from: d  reason: collision with root package name */
    public static final String f5730d = "HttpEventListener";

    /* renamed from: e  reason: collision with root package name */
    public static final EventListener.Factory f5731e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final long f5732a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5733b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f5734c;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements EventListener.Factory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicLong f5735a = new AtomicLong(1);

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            return new i1(this.f5735a.getAndIncrement(), call.request().url(), System.nanoTime());
        }
    }

    public i1(long j4, HttpUrl httpUrl, long j5) {
        this.f5732a = j4;
        this.f5733b = j5;
        StringBuilder sb = new StringBuilder(httpUrl.toString());
        sb.append(" ");
        sb.append(j4);
        sb.append(":");
        this.f5734c = sb;
    }

    public final void a(String str) {
        long nanoTime = System.nanoTime() - this.f5733b;
        StringBuilder sb = this.f5734c;
        Locale locale = Locale.CHINA;
        double d4 = nanoTime;
        Double.isNaN(d4);
        sb.append(String.format(locale, "%.3f-%s", Double.valueOf(d4 / 1.0E9d), str));
        sb.append(";");
        if (str.equalsIgnoreCase("callEnd") || str.equalsIgnoreCase("callFailed")) {
            z1.a(f5730d, this.f5734c.toString());
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
