package com.acse.ottn.p041c;

import androidx.annotation.Nullable;
import com.acse.ottn.util.C1694ra;
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

/* renamed from: com.acse.ottn.c.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1474e extends EventListener {

    /* renamed from: a */
    private static final String f2704a = "HttpEventListener";

    /* renamed from: b */
    public static final EventListener.Factory f2705b = new C1473d();

    /* renamed from: c */
    private final long f2706c;

    /* renamed from: d */
    private final long f2707d;

    /* renamed from: e */
    private StringBuilder f2708e;

    public C1474e(long j, HttpUrl httpUrl, long j2) {
        this.f2706c = j;
        this.f2707d = j2;
        StringBuilder sb = new StringBuilder(httpUrl.toString());
        sb.append(" ");
        sb.append(j);
        sb.append(":");
        this.f2708e = sb;
    }

    /* renamed from: a */
    private void m56690a(String str) {
        long nanoTime = System.nanoTime() - this.f2707d;
        StringBuilder sb = this.f2708e;
        Locale locale = Locale.CHINA;
        double d = nanoTime;
        Double.isNaN(d);
        sb.append(String.format(locale, "%.3f-%s", Double.valueOf(d / 1.0E9d), str));
        sb.append(";");
        if (str.equalsIgnoreCase("callEnd") || str.equalsIgnoreCase("callFailed")) {
            C1694ra.m55917a(f2704a, this.f2708e.toString());
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        m56690a("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        m56690a("callFailed");
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        m56690a("callStart");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        m56690a("connectEnd");
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        m56690a("connectFailed");
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        m56690a("connectStart");
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        m56690a("connectionAcquired");
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        m56690a("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        m56690a("dnsEnd");
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        m56690a("dnsStart");
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        m56690a("requestBodyEnd");
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        m56690a("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        m56690a("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        m56690a("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        m56690a("responseBodyEnd");
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        m56690a("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        m56690a("responseHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        m56690a("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        m56690a("secureConnectEnd");
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        m56690a("secureConnectStart");
    }
}
