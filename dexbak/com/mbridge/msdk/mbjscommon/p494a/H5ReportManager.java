package com.mbridge.msdk.mbjscommon.p494a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.VideoReportData;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.VideoReportDataDao;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbjscommon.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class H5ReportManager {

    /* renamed from: c */
    private static final String f31415c = "a";

    /* renamed from: d */
    private String f31418d = "handlerNativeResult";

    /* renamed from: a */
    int f31416a = 0;

    /* renamed from: b */
    int f31417b = 1;

    /* compiled from: H5ReportManager.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static final class C11477a {

        /* renamed from: a */
        private static H5ReportManager f31420a = new H5ReportManager();
    }

    /* renamed from: a */
    public static H5ReportManager m21544a() {
        return C11477a.f31420a;
    }

    /* renamed from: a */
    public final void m21542a(Object obj, String str, JSONArray jSONArray, int i) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9;
        JSONObject optJSONObject10;
        JSONObject optJSONObject11;
        int i2;
        try {
            if (jSONArray == null) {
                m21543a(this.f31417b, "called reporter failed, params empty", obj);
                return;
            }
            int length = jSONArray.length();
            if (length == 0) {
                m21543a(this.f31417b, "called reporter failed, params empty", obj);
                return;
            }
            if ("reportMessageR".equalsIgnoreCase(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                int i3 = 0;
                while (true) {
                    i2 = length - 1;
                    if (i3 >= i2) {
                        break;
                    }
                    JSONObject optJSONObject12 = jSONArray.optJSONObject(i3);
                    if (optJSONObject12 != null) {
                        stringBuffer.append(optJSONObject12.optString(DomainCampaignEx.LOOPBACK_KEY));
                        stringBuffer.append("=");
                        stringBuffer.append(optJSONObject12.opt(DomainCampaignEx.LOOPBACK_VALUE));
                        stringBuffer.append("&");
                    }
                    i3++;
                }
                JSONObject optJSONObject13 = jSONArray.optJSONObject(i2);
                if (optJSONObject13 != null) {
                    stringBuffer.append(optJSONObject13.optString(DomainCampaignEx.LOOPBACK_KEY));
                    stringBuffer.append("=");
                    stringBuffer.append(optJSONObject13.opt(DomainCampaignEx.LOOPBACK_VALUE));
                }
                String stringBuffer2 = stringBuffer.toString();
                Context m22861j = MBSDKContext.m22865f().m22861j();
                if (m22861j != null && !TextUtils.isEmpty(stringBuffer2)) {
                    try {
                        new ReportRequest(m22861j).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22063a(stringBuffer2, m22861j), new ReportResponseHandler() { // from class: com.mbridge.msdk.mbjscommon.a.a.1
                            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                            /* renamed from: a */
                            public final void mo20683a(String str2) {
                                SameLogTool.m21733d(H5ReportManager.f31415c, str2);
                            }

                            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                            /* renamed from: b */
                            public final void mo20682b(String str2) {
                                SameLogTool.m21733d(H5ReportManager.f31415c, str2);
                            }
                        });
                    } catch (Exception e) {
                        SameLogTool.m21733d(f31415c, e.getMessage());
                    }
                }
            } else if ("reportMessageD".equalsIgnoreCase(str)) {
                String str2 = "";
                String string = (length <= 0 || (optJSONObject11 = jSONArray.optJSONObject(0)) == null) ? "" : optJSONObject11.getString(DomainCampaignEx.LOOPBACK_VALUE);
                int i4 = (length <= 1 || (optJSONObject10 = jSONArray.optJSONObject(1)) == null) ? -1 : optJSONObject10.getInt(DomainCampaignEx.LOOPBACK_VALUE);
                int i5 = (length <= 2 || (optJSONObject9 = jSONArray.optJSONObject(2)) == null) ? -1 : optJSONObject9.getInt(DomainCampaignEx.LOOPBACK_VALUE);
                int i6 = (length <= 3 || (optJSONObject8 = jSONArray.optJSONObject(3)) == null) ? -1 : optJSONObject8.getInt(DomainCampaignEx.LOOPBACK_VALUE);
                int i7 = (length <= 4 || (optJSONObject7 = jSONArray.optJSONObject(4)) == null) ? -1 : optJSONObject7.getInt(DomainCampaignEx.LOOPBACK_VALUE);
                String string2 = (length <= 5 || (optJSONObject6 = jSONArray.optJSONObject(5)) == null) ? "" : optJSONObject6.getString(DomainCampaignEx.LOOPBACK_VALUE);
                String string3 = (length <= 6 || (optJSONObject5 = jSONArray.optJSONObject(6)) == null) ? "" : optJSONObject5.getString(DomainCampaignEx.LOOPBACK_VALUE);
                int i8 = (length <= 7 || (optJSONObject4 = jSONArray.optJSONObject(7)) == null) ? -1 : optJSONObject4.getInt(DomainCampaignEx.LOOPBACK_VALUE);
                String string4 = (length <= 8 || (optJSONObject3 = jSONArray.optJSONObject(8)) == null) ? "" : optJSONObject3.getString(DomainCampaignEx.LOOPBACK_VALUE);
                int i9 = (length <= 9 || (optJSONObject2 = jSONArray.optJSONObject(9)) == null) ? -1 : optJSONObject2.getInt(DomainCampaignEx.LOOPBACK_VALUE);
                if (length > 10 && (optJSONObject = jSONArray.optJSONObject(10)) != null) {
                    str2 = optJSONObject.getString(DomainCampaignEx.LOOPBACK_VALUE);
                }
                String str3 = str2;
                Context m22861j2 = MBSDKContext.m22865f().m22861j();
                if (m22861j2 != null) {
                    VideoReportDataDao.m22654a(CommonSDKDBHelper.m22721a(m22861j2)).m22653a(new VideoReportData(string, i4, i5, i6, i7, string2, string3, i8, string4, i9, str3));
                }
            }
            m21543a(this.f31416a, "called reporter success", obj);
        } catch (Throwable th) {
            SameLogTool.m21738a(f31415c, th.getMessage());
            m21543a(this.f31417b, "exception: " + th.getMessage(), obj);
        }
    }

    /* renamed from: a */
    private void m21543a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            SameLogTool.m21738a(f31415c, e.getMessage());
        } catch (Throwable th) {
            SameLogTool.m21738a(f31415c, th.getMessage());
        }
    }
}
