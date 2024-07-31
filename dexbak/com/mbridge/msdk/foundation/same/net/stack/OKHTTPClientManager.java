package com.mbridge.msdk.foundation.same.net.stack;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

/* renamed from: com.mbridge.msdk.foundation.same.net.stack.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class OKHTTPClientManager {

    /* renamed from: a */
    private OkHttpClient f30874a;

    /* renamed from: b */
    private Setting f30875b;

    /* renamed from: c */
    private String f30876c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OKHTTPClientManager.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.stack.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11363a {

        /* renamed from: a */
        private static final OKHTTPClientManager f30881a = new OKHTTPClientManager();
    }

    /* compiled from: OKHTTPClientManager.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.stack.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11364b implements Serializable {

        /* renamed from: a */
        public int f30882a;

        /* renamed from: b */
        public long f30883b = 0;

        /* renamed from: c */
        public String f30884c = "";

        /* renamed from: d */
        public String f30885d = "";

        /* renamed from: e */
        public String f30886e = "";

        /* renamed from: f */
        public String f30887f = "";

        /* renamed from: g */
        public long f30888g = 0;

        /* renamed from: h */
        public String f30889h = "";

        /* renamed from: i */
        public long f30890i = 0;

        /* renamed from: j */
        public String f30891j = "";

        /* renamed from: k */
        public long f30892k = 0;

        /* renamed from: a */
        public static C11364b m22150a(C11364b c11364b) {
            C11364b c11364b2 = new C11364b();
            c11364b2.f30882a = c11364b.f30882a;
            c11364b2.f30885d = c11364b.f30885d;
            c11364b2.f30887f = c11364b.f30887f;
            c11364b2.f30883b = c11364b.f30883b;
            c11364b2.f30890i = c11364b.f30890i;
            c11364b2.f30884c = c11364b.f30884c;
            c11364b2.f30889h = c11364b.f30889h;
            c11364b2.f30888g = c11364b.f30888g;
            c11364b2.f30886e = c11364b.f30886e;
            c11364b2.f30891j = c11364b.f30891j;
            c11364b2.f30892k = c11364b.f30892k;
            return c11364b2;
        }
    }

    /* renamed from: a */
    public static OKHTTPClientManager m22156a() {
        return C11363a.f30881a;
    }

    /* renamed from: b */
    public final synchronized OkHttpClient m22153b() {
        if (this.f30874a == null) {
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
            this.f30874a = builder.build();
        }
        return this.f30874a;
    }

    /* renamed from: c */
    public final C11364b m22152c() {
        C11364b c11364b = new C11364b();
        c11364b.f30887f = this.f30876c;
        return c11364b;
    }

    private OKHTTPClientManager() {
        this.f30874a = null;
        this.f30876c = "";
    }

    /* renamed from: a */
    public final boolean m22154a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f30875b == null) {
                this.f30875b = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
            }
            Setting setting = this.f30875b;
            if (setting != null) {
                String m23281v = setting.m23281v();
                String str2 = RequestUrlUtil.m22248a().f30791a;
                if (TextUtils.isEmpty(m23281v) || !str.startsWith(m23281v) || TextUtils.equals(m23281v, str2)) {
                    return false;
                }
                this.f30876c = m23281v;
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final void m22155a(C11364b c11364b) {
        if (c11364b == null) {
            return;
        }
        final C11364b m22150a = C11364b.m22150a(c11364b);
        ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StringBuilder sb = new StringBuilder("key=2000102&");
                    sb.append("app_id=");
                    sb.append(MBSDKContext.m22865f().m22860k());
                    sb.append("&");
                    sb.append("status=");
                    sb.append(m22150a.f30882a);
                    sb.append("&");
                    sb.append("domain=");
                    sb.append(m22150a.f30887f);
                    sb.append("&");
                    sb.append("method=");
                    sb.append(m22150a.f30885d);
                    sb.append("&");
                    if (TextUtils.isEmpty(m22150a.f30889h)) {
                        if (!TextUtils.isEmpty(m22150a.f30884c)) {
                            sb.append("connect_e=");
                            sb.append(m22150a.f30884c);
                        } else if (!TextUtils.isEmpty(m22150a.f30891j)) {
                            sb.append("connect_e=");
                            sb.append(m22150a.f30891j);
                        }
                    } else {
                        sb.append("dns_r=");
                        sb.append(m22150a.f30889h);
                        sb.append("&");
                        sb.append("dns_d=");
                        sb.append(m22150a.f30888g);
                        sb.append("&");
                        sb.append("host=");
                        sb.append(m22150a.f30886e);
                        sb.append("&");
                        if (TextUtils.isEmpty(m22150a.f30891j)) {
                            if (TextUtils.isEmpty(m22150a.f30884c)) {
                                sb.append("call_d=");
                                sb.append(m22150a.f30883b);
                                sb.append("&");
                                sb.append("connect_d=");
                                sb.append(m22150a.f30890i);
                                sb.append("&");
                                sb.append("connection_d=");
                                sb.append(m22150a.f30892k);
                            } else {
                                sb.append("connect_d=");
                                sb.append(m22150a.f30890i);
                                sb.append("&");
                                sb.append("connection_e=");
                                sb.append(m22150a.f30884c);
                            }
                        } else if (!TextUtils.isEmpty(m22150a.f30891j)) {
                            sb.append("connect_e=");
                            sb.append(m22150a.f30891j);
                        } else if (!TextUtils.isEmpty(m22150a.f30884c)) {
                            sb.append("connect_e=");
                            sb.append(m22150a.f30884c);
                        }
                    }
                    if (MBBatchReportManager.m22142a().m22135c()) {
                        MBBatchReportManager.m22142a().m22139a(sb.toString());
                        return;
                    }
                    final OKHTTPClientManager oKHTTPClientManager = OKHTTPClientManager.this;
                    String sb2 = sb.toString();
                    Context m22861j = MBSDKContext.m22865f().m22861j();
                    ReportRequest reportRequest = new ReportRequest(m22861j);
                    CommonRequestParams m22085a = C11385e.m22085a(m22861j);
                    m22085a.m22222a("data", URLEncoder.encode(sb2, "utf-8"));
                    m22085a.m22222a("m_sdk", "msdk");
                    reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, m22085a, new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.net.stack.b.3
                        @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                        /* renamed from: a */
                        public final void mo20683a(String str) {
                            SameLogTool.m21738a("OKHTTPClientManager", "report success");
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                        /* renamed from: b */
                        public final void mo20682b(String str) {
                            SameLogTool.m21738a("OKHTTPClientManager", "report failed");
                        }
                    });
                } catch (Exception e) {
                    SameLogTool.m21733d("OKHTTPClientManager", e.getMessage());
                }
            }
        });
    }
}
