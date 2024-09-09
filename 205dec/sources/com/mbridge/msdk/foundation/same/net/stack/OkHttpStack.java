package com.mbridge.msdk.foundation.same.net.stack;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.stack.b;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class OkHttpStack implements a {
    private final OkHttpClient mClient = b.a.f39654a.b();

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class DefaultEventListener extends EventListener {
        private long callDuring;
        private long callStart;
        private long connectDuring;
        private String connectErrorMessage;
        private long connectStart;
        private long connectionDuring;
        private long connectionStart;
        private long dnsDuring;
        private String dnsResult;
        private long dnsStart;
        private String hostName;
        private b.C0742b httpStatus;
        private boolean isReportHttpStatus;
        private String method;

        public DefaultEventListener(String str) {
            try {
                boolean a4 = b.a().a(str);
                this.isReportHttpStatus = a4;
                if (a4) {
                    this.httpStatus = b.a().c();
                }
            } catch (Exception unused) {
                this.isReportHttpStatus = false;
                this.httpStatus = null;
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callEnd(Call call) {
            super.callEnd(call);
            try {
                com.mbridge.msdk.foundation.same.net.a.a().c();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis() - this.callStart;
                this.callDuring = currentTimeMillis;
                b.C0742b c0742b = this.httpStatus;
                c0742b.f39655a = 0;
                c0742b.f39658d = this.method;
                c0742b.f39656b = currentTimeMillis;
                c0742b.f39659e = this.hostName;
                c0742b.f39661g = this.dnsDuring;
                c0742b.f39662h = this.dnsResult;
                c0742b.f39663i = this.connectDuring;
                c0742b.f39665k = this.connectionDuring;
                b.a().a(this.httpStatus);
            } catch (Exception e4) {
                x.d("OkHttpStack", e4.getMessage());
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callFailed(Call call, IOException iOException) {
            super.callFailed(call, iOException);
            try {
                com.mbridge.msdk.foundation.same.net.a.a().d();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                this.callDuring = System.currentTimeMillis() - this.callStart;
                if (!TextUtils.isEmpty(this.connectErrorMessage)) {
                    b.C0742b c0742b = this.httpStatus;
                    c0742b.f39655a = 1;
                    c0742b.f39664j = this.connectErrorMessage;
                } else {
                    this.httpStatus.f39655a = 2;
                }
                this.httpStatus.f39657c = iOException != null ? iOException.getMessage() : "IO Exception";
                b.C0742b c0742b2 = this.httpStatus;
                c0742b2.f39656b = this.callDuring;
                c0742b2.f39659e = this.hostName;
                c0742b2.f39658d = this.method;
                c0742b2.f39661g = this.dnsDuring;
                c0742b2.f39662h = this.dnsResult;
                c0742b2.f39663i = this.connectDuring;
                c0742b2.f39665k = this.connectionDuring;
                b.a().a(this.httpStatus);
            } catch (Exception e4) {
                x.d("OkHttpStack", e4.getMessage());
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callStart(Call call) {
            super.callStart(call);
            try {
                com.mbridge.msdk.foundation.same.net.a.a().b();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.callStart = System.currentTimeMillis();
            if (call != null) {
                try {
                    this.method = call.request().method();
                } catch (Exception unused2) {
                    this.method = "";
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectDuring = System.currentTimeMillis() - this.connectStart;
            this.connectErrorMessage = "";
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectDuring = System.currentTimeMillis() - this.connectStart;
            this.connectErrorMessage = iOException != null ? iOException.getMessage() : "IO Exception";
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            super.connectStart(call, inetSocketAddress, proxy);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectStart = System.currentTimeMillis();
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            super.connectionAcquired(call, connection);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectionStart = System.currentTimeMillis();
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectionReleased(Call call, Connection connection) {
            super.connectionReleased(call, connection);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectionDuring = System.currentTimeMillis() - this.connectionStart;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            super.dnsEnd(call, str, list);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                this.dnsDuring = System.currentTimeMillis() - this.dnsStart;
                if (TextUtils.isEmpty(str)) {
                    this.hostName = "unKnown";
                } else {
                    this.hostName = str;
                }
                if (list != null && list.size() != 0) {
                    InetAddress inetAddress = list.get(0);
                    if (inetAddress != null && !TextUtils.isEmpty(inetAddress.getHostAddress())) {
                        this.dnsResult = inetAddress.getHostAddress();
                        return;
                    }
                    this.dnsResult = "unKnown";
                    return;
                }
                this.dnsResult = "unKnown";
            } catch (Exception e4) {
                x.d("OkHttpStack", e4.getMessage());
                this.hostName = "";
                this.dnsResult = "";
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void dnsStart(Call call, String str) {
            super.dnsStart(call, str);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.dnsStart = System.currentTimeMillis();
        }
    }

    private static RequestBody createRequestBody(i iVar) {
        byte[] e4 = iVar.e();
        if (e4 == null) {
            return null;
        }
        return RequestBody.create((MediaType) null, e4);
    }

    private static void setConnectionParametersForRequest(Request.Builder builder, i<?> iVar) throws IOException {
        switch (iVar.a()) {
            case 0:
                builder.get();
                return;
            case 1:
                builder.post(createRequestBody(iVar));
                return;
            case 2:
                builder.put(createRequestBody(iVar));
                return;
            case 3:
                builder.delete();
                return;
            case 4:
                builder.head();
                return;
            case 5:
                builder.method("OPTIONS", null);
                return;
            case 6:
                builder.method("TRACE", null);
                return;
            case 7:
                builder.patch(createRequestBody(iVar));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.stack.a
    public com.mbridge.msdk.foundation.same.net.e.b performRequest(i<?> iVar) throws IOException {
        int h4 = iVar.h();
        int i4 = iVar.i();
        int j4 = iVar.j();
        int k4 = iVar.k();
        int l4 = iVar.l();
        if (i4 == 0) {
            i4 = h4;
        }
        if (j4 == 0) {
            j4 = h4;
        }
        if (k4 != 0) {
            h4 = k4;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        arrayList.add(Protocol.HTTP_2);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder eventListener = this.mClient.newBuilder().protocols(arrayList).readTimeout(j4, timeUnit).connectTimeout(i4, timeUnit).writeTimeout(h4, timeUnit).eventListener(new DefaultEventListener(iVar.b()));
        if (l4 > 0) {
            eventListener.callTimeout(l4, timeUnit);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("connectTimeout: ");
        sb.append(i4);
        sb.append(" readTimeout: ");
        sb.append(j4);
        sb.append(" writeTimeout: ");
        sb.append(h4);
        sb.append(" callTimeout: ");
        sb.append(l4 == 0 ? "not set" : Integer.valueOf(l4));
        x.a("OkHttpStack", sb.toString());
        Request.Builder builder = new Request.Builder();
        for (Map.Entry<String, String> entry : iVar.d().entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        setConnectionParametersForRequest(builder, iVar);
        Response execute = eventListener.build().newCall(builder.url(iVar.b()).build()).execute();
        Headers headers = execute.headers();
        ArrayList arrayList2 = new ArrayList();
        int size = headers.size();
        for (int i5 = 0; i5 < size; i5++) {
            String name = headers.name(i5);
            String value = headers.value(i5);
            if (name != null) {
                arrayList2.add(new com.mbridge.msdk.foundation.same.net.c.b(name, value));
            }
        }
        return new com.mbridge.msdk.foundation.same.net.e.b(execute.code(), arrayList2, execute.body().byteStream());
    }
}
