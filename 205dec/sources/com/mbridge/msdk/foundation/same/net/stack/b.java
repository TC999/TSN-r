package com.mbridge.msdk.foundation.same.net.stack;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

/* compiled from: OKHTTPClientManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private OkHttpClient f39647a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.c.a f39648b;

    /* renamed from: c  reason: collision with root package name */
    private String f39649c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OKHTTPClientManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f39654a = new b();
    }

    /* compiled from: OKHTTPClientManager.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.stack.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0742b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public int f39655a;

        /* renamed from: b  reason: collision with root package name */
        public long f39656b = 0;

        /* renamed from: c  reason: collision with root package name */
        public String f39657c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f39658d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f39659e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f39660f = "";

        /* renamed from: g  reason: collision with root package name */
        public long f39661g = 0;

        /* renamed from: h  reason: collision with root package name */
        public String f39662h = "";

        /* renamed from: i  reason: collision with root package name */
        public long f39663i = 0;

        /* renamed from: j  reason: collision with root package name */
        public String f39664j = "";

        /* renamed from: k  reason: collision with root package name */
        public long f39665k = 0;

        public static C0742b a(C0742b c0742b) {
            C0742b c0742b2 = new C0742b();
            c0742b2.f39655a = c0742b.f39655a;
            c0742b2.f39658d = c0742b.f39658d;
            c0742b2.f39660f = c0742b.f39660f;
            c0742b2.f39656b = c0742b.f39656b;
            c0742b2.f39663i = c0742b.f39663i;
            c0742b2.f39657c = c0742b.f39657c;
            c0742b2.f39662h = c0742b.f39662h;
            c0742b2.f39661g = c0742b.f39661g;
            c0742b2.f39659e = c0742b.f39659e;
            c0742b2.f39664j = c0742b.f39664j;
            c0742b2.f39665k = c0742b.f39665k;
            return c0742b2;
        }
    }

    public static b a() {
        return a.f39654a;
    }

    public final synchronized OkHttpClient b() {
        if (this.f39647a == null) {
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequestsPerHost(10);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.readTimeout(100L, timeUnit);
            builder.connectTimeout(60L, timeUnit);
            builder.writeTimeout(60L, timeUnit);
            builder.connectionPool(new ConnectionPool(32, 5L, TimeUnit.MINUTES));
            builder.dispatcher(dispatcher);
            builder.eventListener(new EventListener() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.1
            });
            this.f39647a = builder.build();
        }
        return this.f39647a;
    }

    public final C0742b c() {
        C0742b c0742b = new C0742b();
        c0742b.f39660f = this.f39649c;
        return c0742b;
    }

    private b() {
        this.f39647a = null;
        this.f39649c = "";
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f39648b == null) {
                this.f39648b = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
            }
            com.mbridge.msdk.c.a aVar = this.f39648b;
            if (aVar != null) {
                String v3 = aVar.v();
                String str2 = d.a().f39564a;
                if (TextUtils.isEmpty(v3) || !str.startsWith(v3) || TextUtils.equals(v3, str2)) {
                    return false;
                }
                this.f39649c = v3;
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(C0742b c0742b) {
        if (c0742b == null) {
            return;
        }
        final C0742b a4 = C0742b.a(c0742b);
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StringBuilder sb = new StringBuilder("key=2000102&");
                    sb.append("app_id=");
                    sb.append(com.mbridge.msdk.foundation.controller.a.f().k());
                    sb.append("&");
                    sb.append("status=");
                    sb.append(a4.f39655a);
                    sb.append("&");
                    sb.append("domain=");
                    sb.append(a4.f39660f);
                    sb.append("&");
                    sb.append("method=");
                    sb.append(a4.f39658d);
                    sb.append("&");
                    if (TextUtils.isEmpty(a4.f39662h)) {
                        if (!TextUtils.isEmpty(a4.f39657c)) {
                            sb.append("connect_e=");
                            sb.append(a4.f39657c);
                        } else if (!TextUtils.isEmpty(a4.f39664j)) {
                            sb.append("connect_e=");
                            sb.append(a4.f39664j);
                        }
                    } else {
                        sb.append("dns_r=");
                        sb.append(a4.f39662h);
                        sb.append("&");
                        sb.append("dns_d=");
                        sb.append(a4.f39661g);
                        sb.append("&");
                        sb.append("host=");
                        sb.append(a4.f39659e);
                        sb.append("&");
                        if (TextUtils.isEmpty(a4.f39664j)) {
                            if (TextUtils.isEmpty(a4.f39657c)) {
                                sb.append("call_d=");
                                sb.append(a4.f39656b);
                                sb.append("&");
                                sb.append("connect_d=");
                                sb.append(a4.f39663i);
                                sb.append("&");
                                sb.append("connection_d=");
                                sb.append(a4.f39665k);
                            } else {
                                sb.append("connect_d=");
                                sb.append(a4.f39663i);
                                sb.append("&");
                                sb.append("connection_e=");
                                sb.append(a4.f39657c);
                            }
                        } else if (!TextUtils.isEmpty(a4.f39664j)) {
                            sb.append("connect_e=");
                            sb.append(a4.f39664j);
                        } else if (!TextUtils.isEmpty(a4.f39657c)) {
                            sb.append("connect_e=");
                            sb.append(a4.f39657c);
                        }
                    }
                    if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                        com.mbridge.msdk.foundation.same.report.b.a().a(sb.toString());
                        return;
                    }
                    final b bVar = b.this;
                    String sb2 = sb.toString();
                    Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                    com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(j4);
                    com.mbridge.msdk.foundation.same.net.g.d a5 = e.a(j4);
                    a5.a("data", URLEncoder.encode(sb2, "utf-8"));
                    a5.a("m_sdk", "msdk");
                    aVar.c(0, d.a().f39564a, a5, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.3
                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void a(String str) {
                            x.a("OKHTTPClientManager", "report success");
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void b(String str) {
                            x.a("OKHTTPClientManager", "report failed");
                        }
                    });
                } catch (Exception e4) {
                    x.d("OKHTTPClientManager", e4.getMessage());
                }
            }
        });
    }
}
