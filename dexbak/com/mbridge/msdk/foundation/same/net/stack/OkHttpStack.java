package com.mbridge.msdk.foundation.same.net.stack;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.AbstractC11354i;
import com.mbridge.msdk.foundation.same.net.BandWideUtil;
import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import com.mbridge.msdk.foundation.same.net.p484e.C11348b;
import com.mbridge.msdk.foundation.same.net.stack.OKHTTPClientManager;
import com.mbridge.msdk.foundation.tools.SameLogTool;
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

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class OkHttpStack implements HttpStack {
    private final OkHttpClient mClient = OKHTTPClientManager.C11363a.f30881a.m22153b();

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
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
        private OKHTTPClientManager.C11364b httpStatus;
        private boolean isReportHttpStatus;
        private String method;

        public DefaultEventListener(String str) {
            try {
                boolean m22154a = OKHTTPClientManager.m22156a().m22154a(str);
                this.isReportHttpStatus = m22154a;
                if (m22154a) {
                    this.httpStatus = OKHTTPClientManager.m22156a().m22152c();
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
                BandWideUtil.m22300a().m22298c();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis() - this.callStart;
                this.callDuring = currentTimeMillis;
                OKHTTPClientManager.C11364b c11364b = this.httpStatus;
                c11364b.f30882a = 0;
                c11364b.f30885d = this.method;
                c11364b.f30883b = currentTimeMillis;
                c11364b.f30886e = this.hostName;
                c11364b.f30888g = this.dnsDuring;
                c11364b.f30889h = this.dnsResult;
                c11364b.f30890i = this.connectDuring;
                c11364b.f30892k = this.connectionDuring;
                OKHTTPClientManager.m22156a().m22155a(this.httpStatus);
            } catch (Exception e) {
                SameLogTool.m21733d("OkHttpStack", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callFailed(Call call, IOException iOException) {
            super.callFailed(call, iOException);
            try {
                BandWideUtil.m22300a().m22297d();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                this.callDuring = System.currentTimeMillis() - this.callStart;
                if (!TextUtils.isEmpty(this.connectErrorMessage)) {
                    OKHTTPClientManager.C11364b c11364b = this.httpStatus;
                    c11364b.f30882a = 1;
                    c11364b.f30891j = this.connectErrorMessage;
                } else {
                    this.httpStatus.f30882a = 2;
                }
                this.httpStatus.f30884c = iOException != null ? iOException.getMessage() : "IO Exception";
                OKHTTPClientManager.C11364b c11364b2 = this.httpStatus;
                c11364b2.f30883b = this.callDuring;
                c11364b2.f30886e = this.hostName;
                c11364b2.f30885d = this.method;
                c11364b2.f30888g = this.dnsDuring;
                c11364b2.f30889h = this.dnsResult;
                c11364b2.f30890i = this.connectDuring;
                c11364b2.f30892k = this.connectionDuring;
                OKHTTPClientManager.m22156a().m22155a(this.httpStatus);
            } catch (Exception e) {
                SameLogTool.m21733d("OkHttpStack", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callStart(Call call) {
            super.callStart(call);
            try {
                BandWideUtil.m22300a().m22299b();
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
            } catch (Exception e) {
                SameLogTool.m21733d("OkHttpStack", e.getMessage());
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

    private static RequestBody createRequestBody(AbstractC11354i abstractC11354i) {
        byte[] mo22194e = abstractC11354i.mo22194e();
        if (mo22194e == null) {
            return null;
        }
        return RequestBody.create((MediaType) null, mo22194e);
    }

    private static void setConnectionParametersForRequest(Request.Builder builder, AbstractC11354i<?> abstractC11354i) throws IOException {
        switch (abstractC11354i.m22211a()) {
            case 0:
                builder.get();
                return;
            case 1:
                builder.post(createRequestBody(abstractC11354i));
                return;
            case 2:
                builder.put(createRequestBody(abstractC11354i));
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
                builder.patch(createRequestBody(abstractC11354i));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.stack.HttpStack
    public C11348b performRequest(AbstractC11354i<?> abstractC11354i) throws IOException {
        int m22191h = abstractC11354i.m22191h();
        int m22190i = abstractC11354i.m22190i();
        int m22189j = abstractC11354i.m22189j();
        int m22188k = abstractC11354i.m22188k();
        int m22187l = abstractC11354i.m22187l();
        if (m22190i == 0) {
            m22190i = m22191h;
        }
        if (m22189j == 0) {
            m22189j = m22191h;
        }
        if (m22188k != 0) {
            m22191h = m22188k;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        arrayList.add(Protocol.HTTP_2);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder eventListener = this.mClient.newBuilder().protocols(arrayList).readTimeout(m22189j, timeUnit).connectTimeout(m22190i, timeUnit).writeTimeout(m22191h, timeUnit).eventListener(new DefaultEventListener(abstractC11354i.m22198b()));
        if (m22187l > 0) {
            eventListener.callTimeout(m22187l, timeUnit);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("connectTimeout: ");
        sb.append(m22190i);
        sb.append(" readTimeout: ");
        sb.append(m22189j);
        sb.append(" writeTimeout: ");
        sb.append(m22191h);
        sb.append(" callTimeout: ");
        sb.append(m22187l == 0 ? "not set" : Integer.valueOf(m22187l));
        SameLogTool.m21738a("OkHttpStack", sb.toString());
        Request.Builder builder = new Request.Builder();
        for (Map.Entry<String, String> entry : abstractC11354i.m22195d().entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        setConnectionParametersForRequest(builder, abstractC11354i);
        Response execute = eventListener.build().newCall(builder.url(abstractC11354i.m22198b()).build()).execute();
        Headers headers = execute.headers();
        ArrayList arrayList2 = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (name != null) {
                arrayList2.add(new C11336b(name, value));
            }
        }
        return new C11348b(execute.code(), arrayList2, execute.body().byteStream());
    }
}
