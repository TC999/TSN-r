package com.mbridge.msdk.click.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.b;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;

/* compiled from: DspFilterUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f38893a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f38894b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f38895c = 1500;

    /* renamed from: d  reason: collision with root package name */
    private static String f38896d = "2000109";

    /* renamed from: e  reason: collision with root package name */
    private static String f38897e = "DspFilterUtils";

    public static boolean a(CampaignEx campaignEx, String str, int i4) {
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            r2 = campaignEx.getFac() != 0;
            try {
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                if (j4 != null) {
                    if (URLUtil.isFileUrl(str)) {
                        File file = new File(str.replace("file:////", "").replace("file:///", "").replace("file://", ""));
                        if (file.exists()) {
                            str = v.a(file);
                        }
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=" + f38896d + "&");
                    stringBuffer.append("type=" + i4 + "&");
                    stringBuffer.append("html=" + str + "&");
                    stringBuffer.append("network_type=" + t.D(j4) + "&");
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
                    if (b.a().c()) {
                        b.a().a(stringBuffer.toString());
                    } else {
                        e.b(j4, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                x.d(f38897e, th.getMessage());
            }
        }
        return r2;
    }
}
