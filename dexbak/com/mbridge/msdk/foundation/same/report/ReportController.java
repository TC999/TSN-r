package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.ClickTime;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.ReportData;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.ReportErrorDao;
import com.mbridge.msdk.foundation.p472db.SettingCampaignDao;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.TargetAdaptionUtils;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.rover.RoverReportData;
import com.mbridge.msdk.rover.RoverReportResponseHandler;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.report.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ReportController {

    /* renamed from: a */
    public static final String f30926a = "d";

    /* renamed from: b */
    private Context f30927b;

    /* renamed from: c */
    private int f30928c;

    public ReportController(Context context, int i) {
        this.f30927b = context;
        this.f30928c = i;
    }

    /* renamed from: c */
    private void m22088c(String str) {
        try {
            new ReportRequest(this.f30927b).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(str, this.f30927b, ""), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.15
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str2) {
                    String str3 = ReportController.f30926a;
                    SameLogTool.m21736b(str3, "reportPB success data:" + str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str2) {
                    String str3 = ReportController.f30926a;
                    SameLogTool.m21736b(str3, "reportPB onFailed msg:" + str2);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m22090b(String str) {
        m22088c(str);
    }

    /* renamed from: b */
    private String m22091b() {
        StringBuffer stringBuffer = new StringBuffer("?");
        stringBuffer.append("platform=");
        stringBuffer.append(URLEncoder.encode("1"));
        stringBuffer.append("&");
        stringBuffer.append("os_version=");
        stringBuffer.append(URLEncoder.encode(Build.VERSION.RELEASE));
        stringBuffer.append("&");
        stringBuffer.append("package_name=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21810A(this.f30927b)));
        stringBuffer.append("&");
        stringBuffer.append("app_version_name=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21769v(this.f30927b)));
        stringBuffer.append("&");
        stringBuffer.append("app_version_code=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21771u(this.f30927b) + ""));
        stringBuffer.append("&");
        stringBuffer.append("screen_size=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21765x(this.f30927b) + "x" + SameDiTool.m21763y(this.f30927b)));
        stringBuffer.append("&");
        stringBuffer.append("orientation=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21772t(this.f30927b) + ""));
        stringBuffer.append("&");
        stringBuffer.append("gaid=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21803E()));
        stringBuffer.append("&");
        String encode = URLEncoder.encode(SameDiTool.m21762z());
        stringBuffer.append("brand=");
        stringBuffer.append(encode);
        stringBuffer.append("&");
        stringBuffer.append("mnc=");
        stringBuffer.append(URLEncoder.encode(DomainSameDiTool.m21909e(this.f30927b)));
        stringBuffer.append("&");
        stringBuffer.append("mcc=");
        stringBuffer.append(URLEncoder.encode(DomainSameDiTool.m21912d(this.f30927b)));
        stringBuffer.append("&");
        int m21804D = SameDiTool.m21804D(this.f30927b);
        stringBuffer.append("network_type=");
        stringBuffer.append(URLEncoder.encode(m21804D + ""));
        stringBuffer.append("&");
        stringBuffer.append("network_str");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21784a(this.f30927b, m21804D)));
        stringBuffer.append("&");
        stringBuffer.append("language=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21773s(this.f30927b)));
        stringBuffer.append("&");
        stringBuffer.append("timezone=");
        stringBuffer.append(URLEncoder.encode(SameDiTool.m21809B()));
        stringBuffer.append("&");
        String encode2 = URLEncoder.encode(SameDiTool.m21811A());
        stringBuffer.append("useragent=");
        stringBuffer.append(encode2);
        stringBuffer.append("&");
        stringBuffer.append("sdk_version=");
        stringBuffer.append(URLEncoder.encode(MBConfiguration.SDK_VERSION));
        stringBuffer.append("&");
        String encode3 = URLEncoder.encode(DomainSameDiTool.m21897j(this.f30927b));
        stringBuffer.append("gp_version=");
        stringBuffer.append(encode3);
        stringBuffer.append("&");
        stringBuffer.append("sign=");
        stringBuffer.append(URLEncoder.encode(SameMD5.getMD5(MBSDKContext.m22865f().m22860k() + MBSDKContext.m22865f().m22859l())));
        stringBuffer.append("&");
        stringBuffer.append("app_id=");
        stringBuffer.append(URLEncoder.encode(MBSDKContext.m22865f().m22860k()));
        stringBuffer.append("&");
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (m23252b.m23404Z() == 1) {
                    if (DomainSameDiTool.m21918b(this.f30927b) != null) {
                        jSONObject.put("imei", DomainSameDiTool.m21918b(this.f30927b));
                    }
                    if (DomainSameDiTool.m21899i(this.f30927b) != null) {
                        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, DomainSameDiTool.m21899i(this.f30927b));
                    }
                }
                if (m23252b.m23371aa() == 1 && DomainSameDiTool.m21903g(this.f30927b) != null) {
                    jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DomainSameDiTool.m21903g(this.f30927b));
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String m21813a = SameBase64Tool.m21813a(jSONObject.toString());
                    if (!TextUtils.isEmpty(m21813a)) {
                        stringBuffer.append("dvi=");
                        stringBuffer.append(m21813a);
                        stringBuffer.append("&");
                    } else {
                        stringBuffer.append("dvi=");
                        stringBuffer.append("");
                        stringBuffer.append("&");
                    }
                } else {
                    stringBuffer.append("dvi=");
                    stringBuffer.append("");
                    stringBuffer.append("&");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            stringBuffer.append("dvi=");
            stringBuffer.append("");
            stringBuffer.append("&");
        }
        stringBuffer.append("unit_id=");
        stringBuffer.append(0);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public final void m22103a(int i, String str) {
        new ReportRequest(this.f30927b).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22061a("event", C11385e.m22065a((Campaign) null, i, "request"), this.f30927b, str), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.1
            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: a */
            public final void mo20683a(String str2) {
                SameLogTool.m21736b(ReportController.f30926a, "report success");
            }

            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: b */
            public final void mo20682b(String str2) {
            }
        });
    }

    public ReportController(Context context) {
        this.f30928c = 0;
        this.f30927b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    public final void m22100a(final ReportData reportData, final Boolean bool) {
        if (reportData != null) {
            if (reportData.m22467c().equals("GET")) {
                new ReportRequest(this.f30927b).m22234a(0, reportData.m22469b(), (CommonRequestParams) null, new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.12
                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: a */
                    public final void mo20683a(String str) {
                        SameLogTool.m21736b(ReportController.f30926a, "report success");
                        ReportErrorDao.m22686a(CommonSDKDBHelper.m22721a(ReportController.this.f30927b)).m22684a(reportData.m22469b());
                        if (!bool.booleanValue() || ReportErrorDao.m22686a(CommonSDKDBHelper.m22721a(ReportController.this.f30927b)).m22682b() <= 20) {
                            return;
                        }
                        SDKController.m22827a().m22820c();
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: b */
                    public final void mo20682b(String str) {
                    }
                });
            } else if (reportData.m22467c().equals("POST")) {
                ReportRequest reportRequest = new ReportRequest(this.f30927b);
                if (TextUtils.isEmpty(reportData.m22465d())) {
                    return;
                }
                CommonRequestParams m22062a = C11385e.m22062a(reportData.m22465d(), this.f30927b, reportData.m22473a());
                if (reportData.m22462f() > 0) {
                    m22062a.m22222a("retry", reportData.m22462f() + "");
                }
                reportRequest.m22227c(0, reportData.m22469b(), m22062a, new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.13
                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: a */
                    public final void mo20683a(String str) {
                        SameLogTool.m21736b(ReportController.f30926a, "report success");
                        ReportErrorDao.m22686a(CommonSDKDBHelper.m22721a(ReportController.this.f30927b)).m22683a(reportData.m22465d(), reportData.m22469b(), reportData.m22461g());
                        if (!bool.booleanValue() || ReportErrorDao.m22686a(CommonSDKDBHelper.m22721a(ReportController.this.f30927b)).m22688a() <= 0) {
                            return;
                        }
                        SDKController.m22827a().m22820c();
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: b */
                    public final void mo20682b(String str) {
                        ReportErrorDao.m22686a(CommonSDKDBHelper.m22721a(ReportController.this.f30927b)).m22685a(reportData);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public final void m22101a(final ReportData reportData) {
        new ReportRequest(this.f30927b).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22078a(this.f30927b, reportData), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.14
            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: a */
            public final void mo20683a(String str) {
                SameLogTool.m21736b(ReportController.f30926a, "report success");
                try {
                    ReportData reportData2 = reportData;
                    if (reportData2 != null) {
                        int m22463e = reportData2.m22463e();
                        SettingCampaignDao m22674a = SettingCampaignDao.m22674a(CommonSDKDBHelper.m22721a(ReportController.this.f30927b));
                        m22674a.m22672a(m22463e + "");
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: b */
            public final void mo20682b(String str) {
            }
        });
    }

    /* renamed from: a */
    public final void m22098a(String str) {
        m22088c(str);
    }

    /* renamed from: a */
    public final void m22094a(String str, String str2, String str3, String str4) {
        try {
            ReportRequest reportRequest = new ReportRequest(this.f30927b);
            String str5 = "click_type=" + URLEncoder.encode(str, "utf-8") + "&" + BidResponsedEx.KEY_CID + "=" + URLEncoder.encode(str2, "utf-8") + "&" + MBridgeConstans.PROPERTIES_UNIT_ID + "=" + URLEncoder.encode(str3, "utf-8") + "&" + DomainCampaignEx.LOOPBACK_KEY + "=" + URLEncoder.encode("2000027", "utf-8") + "&http_url=" + URLEncoder.encode(str4, "utf-8");
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(str5);
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(str5, this.f30927b, str3), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.2
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str6) {
                    SameLogTool.m21738a("", "SSL REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str6) {
                    SameLogTool.m21738a("", "SSL REPORT FAILED");
                }
            });
        } catch (Exception unused) {
            SameLogTool.m21733d(f30926a, "ssl  error report failed");
        }
    }

    /* renamed from: a */
    public final void m22096a(String str, final File file) {
        new ReportRequest(this.f30927b).m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22077a(this.f30927b, str), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.3
            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: a */
            public final void mo20683a(String str2) {
                SameLogTool.m21736b(ReportController.f30926a, "report success exception");
                File file2 = file;
                if (file2 != null) {
                    file2.delete();
                }
            }

            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: b */
            public final void mo20682b(String str2) {
                SameLogTool.m21736b(ReportController.f30926a, "report failed exception");
            }
        });
    }

    /* renamed from: a */
    public final void m22095a(final String str, String str2, String str3, Frame frame) {
        ReportRequest reportRequest = new ReportRequest(this.f30927b);
        CommonRequestParams m22062a = C11385e.m22062a(str2, this.f30927b, str3);
        if (frame != null) {
            m22062a.m22222a("session_id", frame.getSessionId());
            m22062a.m22222a("parent_session_id", frame.getParentSessionId());
        }
        reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a, new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.4
            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: a */
            public final void mo20683a(String str4) {
                SameLogTool.m21736b(ReportController.f30926a, "report success");
                if ("net_time_stats".equals(str)) {
                    return;
                }
                if ("click_duration".equals(str)) {
                    SDKController.m22827a().m22820c();
                } else if ("load_duration".equals(str)) {
                    SDKController.m22827a().m22820c();
                    SDKController.m22827a().m22820c();
                }
            }

            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: b */
            public final void mo20682b(String str4) {
                SameLogTool.m21736b(ReportController.f30926a, "report success");
            }
        });
    }

    /* renamed from: a */
    public final void m22097a(String str, ClickTime clickTime, String str2) {
        ReportRequest reportRequest = new ReportRequest(this.f30927b);
        String m22596a = ClickTime.m22596a(clickTime);
        if (TextUtils.isEmpty(m22596a)) {
            return;
        }
        if (MBBatchReportManager.m22142a().m22135c()) {
            MBBatchReportManager.m22142a().m22139a(m22596a);
            return;
        }
        reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(m22596a, this.f30927b, str2), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.5
            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: a */
            public final void mo20683a(String str3) {
                SameLogTool.m21736b(ReportController.f30926a, "report success");
            }

            @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
            /* renamed from: b */
            public final void mo20682b(String str3) {
            }
        });
    }

    /* renamed from: a */
    public final void m22102a(CampaignEx campaignEx, List<RoverReportData> list, RoverReportResponseHandler roverReportResponseHandler) {
        ReportRequest reportRequest = new ReportRequest(this.f30927b);
        String m22091b = m22091b();
        CommonRequestParams m22066a = C11385e.m22066a(campaignEx, list);
        reportRequest.m22227c(1, RequestUrlUtil.m22248a().f30769A + m22091b, m22066a, roverReportResponseHandler);
    }

    /* renamed from: a */
    public final void m22105a(int i, int i2, String str, String str2) {
        try {
            ReportRequest reportRequest = new ReportRequest(this.f30927b);
            StringBuilder sb = new StringBuilder();
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append("2000112");
            sb.append("&");
            sb.append("st_net");
            sb.append("=");
            sb.append(i2);
            sb.append("&");
            sb.append(CommonNetImpl.RESULT);
            sb.append("=");
            sb.append(i);
            sb.append("&");
            sb.append("url");
            sb.append("=");
            sb.append(str2);
            sb.append("&");
            sb.append(MediationConstant.KEY_REASON);
            sb.append("=");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), this.f30927b, ""), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.6
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str3) {
                    SameLogTool.m21738a("", "reportSettingLoadFailed onSuccess");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str3) {
                    SameLogTool.m21738a("", "reportSettingLoadFailed onFailed:" + str3);
                }
            });
        } catch (Throwable unused) {
            SameLogTool.m21733d(f30926a, "reportSettingLoadFailed onFailed");
        }
    }

    /* renamed from: b */
    public final void m22089b(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            ReportRequest reportRequest = new ReportRequest(this.f30927b);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("hb=");
                sb.append(1);
                sb.append("&");
            }
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000065", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append(CampaignEx.JSON_KEY_CLICK_URL);
            sb.append("=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), this.f30927b, str4), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.10
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str6) {
                    SameLogTool.m21738a("", "MraidClic REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str6) {
                    SameLogTool.m21738a("", "MraidClic REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m22106a() {
        try {
            if (C11385e.m22087a()) {
                ReportRequest reportRequest = new ReportRequest(this.f30927b);
                String m22860k = MBSDKContext.m22865f().m22860k();
                Setting m23252b = SettingManager.m23261a().m23252b(m22860k);
                if (m23252b == null) {
                    m23252b = SettingManager.m23261a().m23253b();
                }
                int m23434J = m23252b.m23434J();
                String str = "key=2000053&Appid=" + m22860k + "&uptips2=" + m23252b.m23436I() + "&info_status=" + SDKAuthorityController.m22842a().m22832d() + "&iseu=" + m23434J;
                String m21803E = SameDiTool.m21803E();
                if (!TextUtils.isEmpty(m21803E)) {
                    str = str + "&gaid=" + m21803E;
                }
                String str2 = str + "&GDPR_area=" + m23252b.m23378aT() + "&GDPR_consent=" + SDKAuthorityController.m22842a().m22829f();
                SameLogTool.m21738a(f30926a, "reportPrivateAuthorityStatus  data:" + str2);
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(str2);
                    return;
                }
                reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(str2, this.f30927b, ""), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.7
                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: a */
                    public final void mo20683a(String str3) {
                        SameLogTool.m21738a("", "PrivateAuthorityStatus onSuccess ");
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                    /* renamed from: b */
                    public final void mo20682b(String str3) {
                        SameLogTool.m21738a("", "PrivateAuthorityStatus onFailed:" + str3);
                    }
                });
                C11385e.m22059b();
            }
        } catch (Throwable unused) {
            SameLogTool.m21733d(f30926a, "PrivateAuthorityStatus onFailed");
        }
    }

    /* renamed from: a */
    public final void m22104a(int i, int i2, String str, String str2, String str3) {
        try {
            ReportRequest reportRequest = new ReportRequest(this.f30927b);
            StringBuilder sb = new StringBuilder();
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000058", "utf-8"));
            sb.append("&");
            sb.append("appid");
            sb.append("=");
            sb.append(URLEncoder.encode(MBSDKContext.m22865f().m22860k(), "utf-8"));
            sb.append("&");
            sb.append("dl_service");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f30998c + "", "utf-8"));
            sb.append("&");
            sb.append("dl_service_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f30999d + "", "utf-8"));
            sb.append("&");
            sb.append("dl_type");
            sb.append("=");
            sb.append(URLEncoder.encode(i + "", "utf-8"));
            sb.append("&");
            sb.append("dl_link_type");
            sb.append("=");
            sb.append(URLEncoder.encode(i2 + "", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append("dl_v4");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f31004i + "", "utf-8"));
            sb.append("&");
            sb.append("dl_v4_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f31005j + "", "utf-8"));
            sb.append("&");
            sb.append("dl_pkg");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f30996a + "", "utf-8"));
            sb.append("&");
            sb.append("dl_pkg_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f30997b + "", "utf-8"));
            sb.append("&");
            sb.append("dl_i_p");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f31000e + "", "utf-8"));
            sb.append("&");
            sb.append("dl_i_p_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f31002g + "", "utf-8"));
            sb.append("&");
            sb.append("dl_fp");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f31001f + "", "utf-8"));
            sb.append("&");
            sb.append("dl_fp_rs");
            sb.append("=");
            sb.append(URLEncoder.encode(TargetAdaptionUtils.f31003h + "", "utf-8"));
            sb.append("&");
            sb.append("tgt_v");
            sb.append("=");
            sb.append(URLEncoder.encode(SameDiTool.m21767w(this.f30927b) + "", "utf-8"));
            sb.append("&");
            sb.append("app_v_n");
            sb.append("=");
            sb.append(URLEncoder.encode(SameDiTool.m21769v(this.f30927b) + "", "utf-8"));
            sb.append("&");
            sb.append("app_v_c");
            sb.append("=");
            sb.append(URLEncoder.encode(SameDiTool.m21771u(this.f30927b) + "", "utf-8"));
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), this.f30927b, ""), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.8
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str4) {
                    SameLogTool.m21738a("", "reportDownloadMethod REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str4) {
                    SameLogTool.m21738a("", "reportDownloadMethod REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m22092a(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            ReportRequest reportRequest = new ReportRequest(this.f30927b);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("hb=");
                sb.append(1);
                sb.append("&");
            }
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000066", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append("err_method");
            sb.append("=");
            sb.append(str5);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), this.f30927b, str4), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.9
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str6) {
                    SameLogTool.m21738a("", "MraidUnSupportMethod REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str6) {
                    SameLogTool.m21738a("", "MraidUnSupportMethod REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m22093a(String str, String str2, String str3, String str4, String str5) {
        try {
            ReportRequest reportRequest = new ReportRequest(this.f30927b);
            StringBuilder sb = new StringBuilder();
            int m21804D = SameDiTool.m21804D(this.f30927b);
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000071", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append(MediationConstant.KEY_REASON);
            sb.append("=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            sb.append("&");
            sb.append(UMCommonContent.f37763T);
            sb.append("=");
            sb.append(URLEncoder.encode(m21804D + "", "utf-8"));
            sb.append("&");
            sb.append(CommonNetImpl.RESULT);
            sb.append("=");
            sb.append(URLEncoder.encode("0", "utf-8"));
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, C11385e.m22062a(sb.toString(), this.f30927b, str4), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.d.11
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str6) {
                    SameLogTool.m21738a("", "OMSDK REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str6) {
                    SameLogTool.m21738a("", "OMSDK REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
