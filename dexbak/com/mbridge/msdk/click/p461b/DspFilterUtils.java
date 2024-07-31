package com.mbridge.msdk.click.p461b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.File;

/* renamed from: com.mbridge.msdk.click.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DspFilterUtils {

    /* renamed from: a */
    public static int f30066a = 1;

    /* renamed from: b */
    public static int f30067b = 2;

    /* renamed from: c */
    public static int f30068c = 1500;

    /* renamed from: d */
    private static String f30069d = "2000109";

    /* renamed from: e */
    private static String f30070e = "DspFilterUtils";

    /* renamed from: a */
    public static boolean m23081a(CampaignEx campaignEx, String str, int i) {
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            r2 = campaignEx.getFac() != 0;
            try {
                Context m22861j = MBSDKContext.m22865f().m22861j();
                if (m22861j != null) {
                    if (URLUtil.isFileUrl(str)) {
                        File file = new File(str.replace("file:////", "").replace("file:///", "").replace("file://", ""));
                        if (file.exists()) {
                            str = SameFileTool.m21756a(file);
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=" + f30069d + "&");
                    stringBuffer.append("type=" + i + "&");
                    stringBuffer.append("html=" + str + "&");
                    stringBuffer.append("network_type=" + SameDiTool.m21804D(m22861j) + "&");
                    stringBuffer.append("unit_id=" + campaignEx.getCampaignUnitId() + "&");
                    String requestId = campaignEx.getRequestId();
                    if (!TextUtils.isEmpty(requestId)) {
                        stringBuffer.append("rid=");
                        stringBuffer.append(requestId);
                        stringBuffer.append("&");
                    }
                    if (campaignEx.isBidCampaign()) {
                        stringBuffer.append("hb=");
                        stringBuffer.append("1");
                        stringBuffer.append("&");
                    }
                    String requestIdNotice = campaignEx.getRequestIdNotice();
                    if (!TextUtils.isEmpty(requestIdNotice)) {
                        stringBuffer.append("rid_n=");
                        stringBuffer.append(requestIdNotice);
                        stringBuffer.append("&");
                    }
                    stringBuffer.append("cid=" + campaignEx.getId());
                    if (MBBatchReportManager.m22142a().m22135c()) {
                        MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                    } else {
                        C11385e.m22057b(m22861j, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                SameLogTool.m21733d(f30070e, th.getMessage());
            }
        }
        return r2;
    }
}
