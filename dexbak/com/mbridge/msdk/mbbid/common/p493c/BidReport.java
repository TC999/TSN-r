package com.mbridge.msdk.mbbid.common.p493c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* renamed from: com.mbridge.msdk.mbbid.common.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BidReport {

    /* renamed from: a */
    private static final String f31235a = "com.mbridge.msdk.mbbid.common.c.a";

    /* renamed from: b */
    public static void m21684b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new ReportRequest(context).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a("key=2000064&result=2&network_type=" + SameDiTool.m21804D(context) + "&reason=" + str2, context, str), new ReportResponseHandler() { // from class: com.mbridge.msdk.mbbid.common.c.a.2
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str3) {
                    SameLogTool.m21733d(BidReport.f31235a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str3) {
                    SameLogTool.m21733d(BidReport.f31235a, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f31235a, e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m21685a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("key=");
            sb.append("2000064");
            sb.append("&");
            sb.append("result=");
            sb.append("1");
            sb.append("&");
            sb.append("network_type=");
            sb.append(SameDiTool.m21804D(context));
            sb.append("&");
            sb.append("bidid=");
            sb.append(str2);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            new ReportRequest(context).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), context, str), new ReportResponseHandler() { // from class: com.mbridge.msdk.mbbid.common.c.a.1
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str3) {
                    SameLogTool.m21733d(BidReport.f31235a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str3) {
                    SameLogTool.m21733d(BidReport.f31235a, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f31235a, e.getMessage());
        }
    }
}
