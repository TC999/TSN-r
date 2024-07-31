package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.mbridge.msdk.foundation.same.report.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameCommonReporter {

    /* renamed from: a */
    private String f30955a;

    /* renamed from: b */
    private Map<String, String> f30956b;

    /* compiled from: SameCommonReporter.java */
    /* renamed from: com.mbridge.msdk.foundation.same.report.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11392a {

        /* renamed from: a */
        private String f30957a;

        /* renamed from: b */
        private Map<String, String> f30958b = new HashMap();

        public C11392a(String str) {
            this.f30957a = str;
        }

        /* renamed from: a */
        public final SameCommonReporter m22051a() {
            return new SameCommonReporter(this);
        }
    }

    /* renamed from: a */
    public final void m22053a(String str) {
        String str2;
        if (TextUtils.isEmpty(this.f30955a)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("key=");
        sb.append(this.f30955a);
        CommonRequestParams commonRequestParams = null;
        try {
            str2 = m22052a(this.f30956b);
        } catch (Exception unused) {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (MBBatchReportManager.m22142a().m22135c()) {
            MBBatchReportManager.m22142a().m22139a(sb.toString());
            return;
        }
        try {
            commonRequestParams = C11385e.m22062a(sb.toString(), MBSDKContext.m22865f().m22861j(), str);
        } catch (Exception unused2) {
        }
        if (commonRequestParams != null) {
            try {
                new ReportRequest(MBSDKContext.m22865f().m22861j()).m22227c(0, RequestUrlUtil.m22248a().f30791a, commonRequestParams, new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.f.1
                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: a */
                    public final void mo20683a(String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: b */
                    public final void mo20682b(String str3) {
                    }
                });
            } catch (Exception unused3) {
            }
        }
    }

    private SameCommonReporter(C11392a c11392a) {
        this.f30955a = c11392a.f30957a;
        this.f30956b = c11392a.f30958b;
    }

    /* renamed from: a */
    private String m22052a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                str2 = URLEncoder.encode(str2, "utf-8");
                            } catch (Exception unused) {
                            }
                            sb.append("&");
                            sb.append(str);
                            sb.append("=");
                            sb.append(str2);
                        }
                    }
                }
            } catch (Exception unused2) {
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }
}
