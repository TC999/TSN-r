package com.mbridge.msdk.foundation.same.p479f;

import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* renamed from: com.mbridge.msdk.foundation.same.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ReportTask implements Runnable {

    /* renamed from: a */
    private String f30678a;

    /* renamed from: b */
    private String f30679b;

    public ReportTask(String str, String str2) {
        this.f30678a = str;
        this.f30679b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            SameLogTool.m21733d("ReportTask", "start report");
            new ReportRequest(MBSDKContext.m22865f().m22861j()).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(this.f30678a, MBSDKContext.m22865f().m22861j(), this.f30679b), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.f.a.1
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str) {
                    SameLogTool.m21733d("ReportTask", str);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str) {
                    SameLogTool.m21733d("ReportTask", str);
                }
            });
        } catch (Throwable th) {
            SameLogTool.m21733d("ReportTask", th.getMessage());
        }
    }
}
