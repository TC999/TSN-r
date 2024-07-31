package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.ReportData;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.ReportErrorDao;
import com.mbridge.msdk.foundation.same.net.C11332Aa;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParamsForAdd;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p462d.ShortCutsManager;
import com.mbridge.msdk.rover.RoverReportData;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportUtil.java */
/* renamed from: com.mbridge.msdk.foundation.same.report.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11385e extends DomainReport {

    /* renamed from: a */
    public static final String f30952a = "e";

    /* renamed from: a */
    public static String m22065a(Campaign campaign, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put(CcgConstant.f38549t, str);
            jSONObject.put(TTDownloadField.TT_LABEL, i);
            if (campaign != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", campaign.getId());
                jSONObject2.put("title", campaign.getAppName());
                jSONObject.put(DomainCampaignEx.LOOPBACK_VALUE, jSONObject2);
            } else {
                jSONObject.put(DomainCampaignEx.LOOPBACK_VALUE, "");
            }
        } catch (Exception unused) {
            SameLogTool.m21733d(f30952a, "ad track data failed !");
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    public static void m22059b() {
        try {
            C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private static String m22056c(Context context, String str) {
        String m21903g;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pf", "1");
                jSONObject.put("ov", SameDiTool.m21807C());
                jSONObject.put("pn", SameDiTool.m21810A(context));
                jSONObject.put("vn", SameDiTool.m21769v(context));
                jSONObject.put("vc", SameDiTool.m21771u(context));
                jSONObject.put("ot", SameDiTool.m21772t(context));
                jSONObject.put(C7304t.f25066v, SameDiTool.m21766x());
                jSONObject.put("bd", SameDiTool.m21762z());
                jSONObject.put("gaid", SameDiTool.m21803E());
                jSONObject.put("mnc", DomainSameDiTool.m21909e(context));
                jSONObject.put("mcc", DomainSameDiTool.m21912d(context));
                int m21804D = SameDiTool.m21804D(context);
                jSONObject.put("nt", m21804D);
                jSONObject.put("nts", SameDiTool.m21784a(context, m21804D));
                jSONObject.put(C7304t.f25048d, SameDiTool.m21773s(context));
                jSONObject.put("tz", SameDiTool.m21809B());
                jSONObject.put(PathCenter.f37685d, SameDiTool.m21811A());
                jSONObject.put("app_id", MBSDKContext.m22865f().m22860k());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                jSONObject.put("sv", MBConfiguration.SDK_VERSION);
                jSONObject.put("gpv", DomainSameDiTool.m21897j(context));
                jSONObject.put("ss", SameDiTool.m21765x(context) + "x" + SameDiTool.m21763y(context));
                Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                if (m23252b != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (m23252b.m23404Z() == 1) {
                            String m21918b = DomainSameDiTool.m21918b(context);
                            if (m21918b != null) {
                                jSONObject2.put("imei", m21918b);
                            }
                            String m21899i = DomainSameDiTool.m21899i(context);
                            if (m21899i != null) {
                                jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, m21899i);
                            }
                        }
                        if (m23252b.m23371aa() == 1 && (m21903g = DomainSameDiTool.m21903g(context)) != null) {
                            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, m21903g);
                        }
                        try {
                            String m21797H = SameDiTool.m21797H();
                            if (!TextUtils.isEmpty(m21797H)) {
                                jSONObject2.put("manufacturer", m21797H);
                            }
                            String m21919b = DomainSameDiTool.m21919b();
                            if (!TextUtils.isEmpty(m21919b)) {
                                jSONObject2.put("cpu2", m21919b);
                            }
                            String m21913d = DomainSameDiTool.m21913d();
                            if (!TextUtils.isEmpty(m21913d)) {
                                jSONObject2.put("tags", m21913d);
                            }
                            String m21910e = DomainSameDiTool.m21910e();
                            if (!TextUtils.isEmpty(m21910e)) {
                                jSONObject2.put(PathCenter.f37694m, m21910e);
                            }
                            String m21907f = DomainSameDiTool.m21907f();
                            if (!TextUtils.isEmpty(m21907f)) {
                                jSONObject2.put("radio", m21907f);
                            }
                            String m21904g = DomainSameDiTool.m21904g();
                            if (!TextUtils.isEmpty(m21904g)) {
                                jSONObject2.put("bootloader", m21904g);
                            }
                            String m21902h = DomainSameDiTool.m21902h();
                            if (!TextUtils.isEmpty(m21902h)) {
                                jSONObject2.put("hardware", m21902h);
                            }
                            String m21900i = DomainSameDiTool.m21900i();
                            if (!TextUtils.isEmpty(m21900i)) {
                                jSONObject2.put("host", m21900i);
                            }
                            String m21898j = DomainSameDiTool.m21898j();
                            if (!TextUtils.isEmpty(m21898j)) {
                                jSONObject2.put("codename", m21898j);
                            }
                            String m21896k = DomainSameDiTool.m21896k();
                            if (!TextUtils.isEmpty(m21896k)) {
                                jSONObject2.put("incremental", m21896k);
                            }
                            String m21894l = DomainSameDiTool.m21894l();
                            if (!TextUtils.isEmpty(m21894l)) {
                                jSONObject2.put("serial", m21894l);
                            }
                            String m21892m = DomainSameDiTool.m21892m();
                            if (!TextUtils.isEmpty(m21892m)) {
                                jSONObject2.put("display", m21892m);
                            }
                            String m21890n = DomainSameDiTool.m21890n();
                            if (!TextUtils.isEmpty(m21890n)) {
                                jSONObject2.put("board", m21890n);
                            }
                            String m21888o = DomainSameDiTool.m21888o();
                            if (!TextUtils.isEmpty(m21888o)) {
                                jSONObject2.put("type", m21888o);
                            }
                            String m21916c = DomainSameDiTool.m21916c();
                            if (!TextUtils.isEmpty(m21916c)) {
                                jSONObject2.put("support", m21916c);
                            }
                            String m21886p = DomainSameDiTool.m21886p();
                            if (!TextUtils.isEmpty(m21886p)) {
                                jSONObject2.put("release", m21886p);
                            }
                            int m21884q = DomainSameDiTool.m21884q();
                            if (m21884q != -1) {
                                jSONObject2.put("sdkint", m21884q);
                            }
                            String m21893l = DomainSameDiTool.m21893l(context);
                            if (!TextUtils.isEmpty(m21893l)) {
                                jSONObject2.put(UMCommonContent.f37769Z, m21893l);
                            }
                            int m21895k = DomainSameDiTool.m21895k(context);
                            if (m21895k != -1) {
                                jSONObject2.put("batterystatus", m21895k);
                            }
                            int m21883r = DomainSameDiTool.m21883r();
                            if (m21883r != -1) {
                                jSONObject2.put("baseos", m21883r);
                            }
                            String m21802E = SameDiTool.m21802E(context);
                            if (!TextUtils.isEmpty(m21802E)) {
                                jSONObject2.put("is24H", m21802E);
                            }
                            int m21889n = DomainSameDiTool.m21889n(context);
                            if (m21889n != -1) {
                                jSONObject2.put(UMCommonContent.f37799ac, m21889n);
                            }
                            String m21887o = DomainSameDiTool.m21887o(context);
                            if (!TextUtils.isEmpty(m21887o)) {
                                jSONObject2.put("ime", m21887o);
                            }
                            int m21891m = DomainSameDiTool.m21891m(context);
                            if (m21891m != -1) {
                                jSONObject2.put("phonetype", m21891m);
                            }
                            String m21795I = SameDiTool.m21795I();
                            if (!TextUtils.isEmpty(m21795I)) {
                                jSONObject2.put("totalram", m21795I);
                            }
                            String m21800F = SameDiTool.m21800F(context);
                            if (!TextUtils.isEmpty(m21800F)) {
                                jSONObject2.put("totalmemory", m21800F);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(jSONObject2.toString())) {
                            String m21813a = SameBase64Tool.m21813a(jSONObject2.toString());
                            if (!TextUtils.isEmpty(m21813a)) {
                                jSONObject.put("dvi", URLEncoder.encode(m21813a, "utf-8"));
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject.toString();
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return "";
    }

    /* renamed from: d */
    private static void m22055d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new ReportRequest(context).m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a(str, context, ""), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.e.1
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str2) {
                    SameLogTool.m21733d(C11385e.f30952a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str2) {
                    SameLogTool.m21733d(C11385e.f30952a, str2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f30952a, e.getMessage());
        }
    }

    /* renamed from: e */
    private static void m22054e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new ReportRequest(context).m22227c(0, RequestUrlUtil.m22248a().f30791a, m22063a(str, context), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.e.3
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str2) {
                    SameLogTool.m21733d(C11385e.f30952a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str2) {
                    SameLogTool.m21733d(C11385e.f30952a, str2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f30952a, e.getMessage());
        }
    }

    /* renamed from: b */
    public static void m22058b(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (true ^ TextUtils.isEmpty(str2))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000054&");
                    stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                    stringBuffer.append("unit_id=" + str + "&");
                    stringBuffer.append("reason=" + str2 + "&");
                    stringBuffer.append("result=1&");
                    stringBuffer.append("devid=" + SameDiTool.m21803E() + "&");
                    if (campaignEx != null) {
                        stringBuffer.append("cid=" + campaignEx.getId() + "&");
                        if (campaignEx.getAdType() == 287) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=3&");
                        } else if (campaignEx.getAdType() == 94) {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        } else if (campaignEx.getAdType() == 296) {
                            stringBuffer.append("ad_type=5&");
                            stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
                        } else if (campaignEx.getAdType() == 297) {
                            stringBuffer.append("ad_type=6&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else if (campaignEx.getAdType() == 298) {
                            stringBuffer.append("ad_type=7&");
                            stringBuffer.append("ad_html=" + campaignEx.getAdHtml() + "&");
                            stringBuffer.append("ad_tpl_url=" + URLEncoder.encode(campaignEx.getAdZip()) + "&");
                        } else {
                            stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                            stringBuffer.append("ad_type=1&");
                        }
                        stringBuffer.append("rid=");
                        stringBuffer.append(campaignEx.getRequestId());
                        stringBuffer.append("&");
                        stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice());
                    }
                    if (MBBatchReportManager.m22142a().m22135c()) {
                        MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                    } else {
                        m22075a(context, stringBuffer.toString(), str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static CommonRequestParams m22061a(String str, String str2, Context context, String str3) {
        if (context != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        CommonRequestParams commonRequestParams = new CommonRequestParams();
        commonRequestParams.m22222a("m_device_info", m22056c(context, str3));
        commonRequestParams.m22222a("m_action", str);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str4 = f30952a;
                SameLogTool.m21738a(str4, "8.5.0 add channel ,before value : " + str2);
                String m22305a = C11332Aa.m22305a();
                if (m22305a == null) {
                    m22305a = "";
                }
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("channel", m22305a);
                String str5 = MBSDKContext.f30251b.get(str3);
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject.put("u_stid", str5 != null ? str5 : "");
                }
                str2 = jSONObject.toString();
                SameLogTool.m21738a(str4, "8.5.0 add channel ,update value : " + str2);
            } else {
                JSONObject jSONObject2 = new JSONObject();
                String str6 = MBSDKContext.f30251b.get(str3);
                if (!TextUtils.isEmpty(str6)) {
                    jSONObject2.put("u_stid", str6 != null ? str6 : "");
                }
                str2 = jSONObject2.toString();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        commonRequestParams.m22222a("m_data", str2);
        commonRequestParams.m22222a("m_sdk", "msdk");
        return commonRequestParams;
    }

    /* renamed from: a */
    public static CommonRequestParams m22085a(Context context) {
        String m21903g;
        String m21921a;
        CommonRequestParams commonRequestParams = new CommonRequestParams();
        try {
            commonRequestParams.m22222a(Constants.PARAM_PLATFORM, "1");
            String m21810A = SameDiTool.m21810A(context);
            if (!TextUtils.isEmpty(m21810A)) {
                commonRequestParams.m22222a("package_name", URLEncoder.encode(m21810A));
            }
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                commonRequestParams.m22222a("os_version", Build.VERSION.RELEASE);
                commonRequestParams.m22222a(C2624bk.f8686j, URLEncoder.encode(SameDiTool.m21762z()));
                commonRequestParams.m22222a(C2624bk.f8685i, URLEncoder.encode(SameDiTool.m21766x()));
                commonRequestParams.m22222a("gaid", SameDiTool.m21803E());
                commonRequestParams.m22222a("mnc", DomainSameDiTool.m21909e(context));
                commonRequestParams.m22222a("mcc", DomainSameDiTool.m21912d(context));
                int m21804D = SameDiTool.m21804D(context);
                commonRequestParams.m22222a(UMCommonContent.f37763T, m21804D + "");
                commonRequestParams.m22222a("network_str", SameDiTool.m21784a(context, m21804D));
                commonRequestParams.m22222a("language", URLEncoder.encode(SameDiTool.m21773s(context)));
                commonRequestParams.m22222a(UMCommonContent.f37756M, URLEncoder.encode(SameDiTool.m21809B()));
                commonRequestParams.m22222a(PathCenter.f37685d, URLEncoder.encode(SameDiTool.m21811A()));
                commonRequestParams.m22222a("gp_version", URLEncoder.encode(DomainSameDiTool.m21897j(context)));
            }
            commonRequestParams.m22222a("sdk_version", MBConfiguration.SDK_VERSION);
            commonRequestParams.m22222a("app_version_name", URLEncoder.encode(SameDiTool.m21769v(context)));
            commonRequestParams.m22222a("orientation", URLEncoder.encode(SameDiTool.m21772t(context) + ""));
            try {
                if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                    commonRequestParams.m22222a("gpsv", GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE + "");
                }
            } catch (Exception unused) {
                SameLogTool.m21733d(f30952a, "can't find com.google.android.gms.common.GooglePlayServicesUtil class");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            commonRequestParams.m22222a("screen_size", SameDiTool.m21765x(context) + "x" + SameDiTool.m21763y(context));
            CommonRequestParamsForAdd.m22216c(commonRequestParams);
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            if (m23252b != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (SDKAuthorityController.m22842a().m22840a("authority_imei_mac") && m23252b.m23404Z() == 1) {
                        String m21918b = DomainSameDiTool.m21918b(context);
                        if (m21918b != null) {
                            jSONObject.put("imei", m21918b);
                        }
                        String m21899i = DomainSameDiTool.m21899i(context);
                        if (m21899i != null) {
                            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, m21899i);
                        }
                    }
                    if (m23252b.m23440G() == 1 && (m21921a = DomainSameDiTool.m21921a(context)) != null && SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        jSONObject.put("oaid", m21921a);
                    }
                    if (SDKAuthorityController.m22842a().m22840a("authority_android_id") && m23252b.m23371aa() == 1 && (m21903g = DomainSameDiTool.m21903g(context)) != null) {
                        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, m21903g);
                    }
                    try {
                        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                            String m21797H = SameDiTool.m21797H();
                            if (!TextUtils.isEmpty(m21797H)) {
                                jSONObject.put("manufacturer", m21797H);
                            }
                            String m21919b = DomainSameDiTool.m21919b();
                            if (!TextUtils.isEmpty(m21919b)) {
                                jSONObject.put("cpu2", m21919b);
                            }
                            String m21913d = DomainSameDiTool.m21913d();
                            if (!TextUtils.isEmpty(m21913d)) {
                                jSONObject.put("tags", m21913d);
                            }
                            String m21910e = DomainSameDiTool.m21910e();
                            if (!TextUtils.isEmpty(m21910e)) {
                                jSONObject.put(PathCenter.f37694m, m21910e);
                            }
                            String m21907f = DomainSameDiTool.m21907f();
                            if (!TextUtils.isEmpty(m21907f)) {
                                jSONObject.put("radio", m21907f);
                            }
                            String m21904g = DomainSameDiTool.m21904g();
                            if (!TextUtils.isEmpty(m21904g)) {
                                jSONObject.put("bootloader", m21904g);
                            }
                            String m21902h = DomainSameDiTool.m21902h();
                            if (!TextUtils.isEmpty(m21902h)) {
                                jSONObject.put("hardware", m21902h);
                            }
                            String m21900i = DomainSameDiTool.m21900i();
                            if (!TextUtils.isEmpty(m21900i)) {
                                jSONObject.put("host", m21900i);
                            }
                            String m21898j = DomainSameDiTool.m21898j();
                            if (!TextUtils.isEmpty(m21898j)) {
                                jSONObject.put("codename", m21898j);
                            }
                            String m21896k = DomainSameDiTool.m21896k();
                            if (!TextUtils.isEmpty(m21896k)) {
                                jSONObject.put("incremental", m21896k);
                            }
                            String m21894l = DomainSameDiTool.m21894l();
                            if (!TextUtils.isEmpty(m21894l)) {
                                jSONObject.put("serial", m21894l);
                            }
                            String m21892m = DomainSameDiTool.m21892m();
                            if (!TextUtils.isEmpty(m21892m)) {
                                jSONObject.put("display", m21892m);
                            }
                            String m21890n = DomainSameDiTool.m21890n();
                            if (!TextUtils.isEmpty(m21890n)) {
                                jSONObject.put("board", m21890n);
                            }
                            String m21888o = DomainSameDiTool.m21888o();
                            if (!TextUtils.isEmpty(m21888o)) {
                                jSONObject.put("type", m21888o);
                            }
                            String m21916c = DomainSameDiTool.m21916c();
                            if (!TextUtils.isEmpty(m21916c)) {
                                jSONObject.put("support", m21916c);
                            }
                            String m21886p = DomainSameDiTool.m21886p();
                            if (!TextUtils.isEmpty(m21886p)) {
                                jSONObject.put("release", m21886p);
                            }
                            int m21884q = DomainSameDiTool.m21884q();
                            if (m21884q != -1) {
                                jSONObject.put("sdkint", m21884q);
                            }
                            String m21893l = DomainSameDiTool.m21893l(context);
                            if (!TextUtils.isEmpty(m21893l)) {
                                jSONObject.put(UMCommonContent.f37769Z, m21893l);
                            }
                            int m21895k = DomainSameDiTool.m21895k(context);
                            if (m21895k != -1) {
                                jSONObject.put("batterystatus", m21895k);
                            }
                            int m21883r = DomainSameDiTool.m21883r();
                            if (m21883r != -1) {
                                jSONObject.put("baseos", m21883r);
                            }
                            String m21802E = SameDiTool.m21802E(context);
                            if (!TextUtils.isEmpty(m21802E)) {
                                jSONObject.put("is24H", m21802E);
                            }
                            int m21889n = DomainSameDiTool.m21889n(context);
                            if (m21889n != -1) {
                                jSONObject.put(UMCommonContent.f37799ac, m21889n);
                            }
                            String m21887o = DomainSameDiTool.m21887o(context);
                            if (!TextUtils.isEmpty(m21887o)) {
                                jSONObject.put("ime", m21887o);
                            }
                            int m21891m = DomainSameDiTool.m21891m(context);
                            if (m21891m != -1) {
                                jSONObject.put("phonetype", m21891m);
                            }
                            String m21795I = SameDiTool.m21795I();
                            if (!TextUtils.isEmpty(m21795I)) {
                                jSONObject.put("totalram", m21795I);
                            }
                            String m21800F = SameDiTool.m21800F(context);
                            if (!TextUtils.isEmpty(m21800F)) {
                                jSONObject.put("totalmemory", m21800F);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(jSONObject.toString())) {
                        String m21813a = SameBase64Tool.m21813a(jSONObject.toString());
                        if (!TextUtils.isEmpty(m21813a)) {
                            commonRequestParams.m22222a("dvi", m21813a);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
        return commonRequestParams;
    }

    /* renamed from: b */
    public static void m22057b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new ReportRequest(context).m22227c(0, RequestUrlUtil.m22248a().f30791a, m22063a(str, context), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.e.4
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str2) {
                    SameLogTool.m21733d(C11385e.f30952a, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str2) {
                    SameLogTool.m21733d(C11385e.f30952a, str2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f30952a, e.getMessage());
        }
    }

    /* renamed from: a */
    public static CommonRequestParams m22078a(Context context, ReportData reportData) {
        try {
            CommonRequestParams m22085a = m22085a(context);
            try {
                m22085a.m22222a("app_id", MBSDKContext.m22865f().m22860k() + "");
                m22085a.m22222a("data", URLEncoder.encode(reportData.m22465d()));
                return m22085a;
            } catch (Exception unused) {
                return m22085a;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: a */
    public static CommonRequestParams m22077a(Context context, String str) {
        CommonRequestParams m22085a = m22085a(context);
        m22085a.m22222a("app_id", MBSDKContext.m22865f().m22860k() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                m22085a.m22222a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return m22085a;
    }

    /* renamed from: a */
    public static CommonRequestParams m22062a(String str, Context context, String str2) {
        CommonRequestParams m22085a = m22085a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(MBSDKContext.m22865f().m22860k());
        sb.append("");
        m22085a.m22222a("app_id", sb.toString());
        m22085a.m22222a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str3 = MBSDKContext.f30251b.get(str2);
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("&");
                    sb2.append("u_stid");
                    sb2.append("=");
                    sb2.append(str3 != null ? str3 : "");
                    str = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("u_stid=");
                    sb3.append(str3 != null ? str3 : "");
                    str = sb3.toString();
                }
            }
            m22085a.m22222a("data", URLEncoder.encode(str, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        m22085a.m22222a("m_sdk", "msdk");
        return m22085a;
    }

    /* renamed from: a */
    public static CommonRequestParams m22063a(String str, Context context) {
        CommonRequestParams m22085a = m22085a(context);
        m22085a.m22222a("app_id", MBSDKContext.m22865f().m22860k() + "");
        if (!TextUtils.isEmpty(str)) {
            try {
                m22085a.m22222a("data", URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        m22085a.m22222a("m_sdk", "msdk");
        return m22085a;
    }

    /* renamed from: a */
    public static String m22060a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append("&" + entry.getKey() + "=" + entry.getValue());
            }
        }
        sb.append(ShellAdbUtils.f33810d);
        return sb.toString();
    }

    /* renamed from: a */
    public static CommonRequestParams m22066a(CampaignEx campaignEx, List<RoverReportData> list) {
        CommonRequestParams commonRequestParams = new CommonRequestParams();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        if (campaignEx != null) {
            try {
                jSONObject.put(BidResponsedEx.KEY_CID, campaignEx.getId());
                jSONObject.put(DomainCampaignEx.ROVER_KEY_MARK, campaignEx.getRoverMark());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (list != null && list.size() >= 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (RoverReportData roverReportData : list) {
                if (roverReportData != null) {
                    jSONArray2.put(roverReportData.m21312a());
                }
            }
            jSONObject.put("urls", jSONArray2);
        }
        jSONArray.put(jSONObject);
        commonRequestParams.m22222a("data", jSONArray.toString());
        return commonRequestParams;
    }

    /* renamed from: a */
    public static boolean m22087a() {
        try {
            return System.currentTimeMillis() - 86400000 > ((Long) C11400ae.m21961b(MBSDKContext.m22865f().m22861j(), "privateAuthorityTimesTamp", 0L)).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static void m22084a(Context context, CampaignEx campaignEx, int i, int i2) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000056&");
            if (campaignEx != null) {
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
            }
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            stringBuffer.append("unit_id=" + m23252b.m23446D() + "&");
            String m21803E = SameDiTool.m21803E();
            if (!TextUtils.isEmpty(m21803E)) {
                stringBuffer.append("gaid=" + m21803E + "&");
            }
            stringBuffer.append("action_type=" + i + "&");
            stringBuffer.append("jm_a=" + ShortCutsManager.m22996a(context).m22975c() + "&");
            stringBuffer.append("jm_n=" + ShortCutsManager.m22996a(context).m22999a() + "&");
            if (campaignEx != null) {
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            }
            stringBuffer.append("result_type=" + i2);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
            } else {
                new ReportController(context).m22090b(stringBuffer.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m22070a(Context context, String str, String str2, boolean z) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000047&");
                if (!TextUtils.isEmpty(str2)) {
                    String str3 = MBSDKContext.f30251b.get(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str3 == null) {
                        str3 = "";
                    }
                    sb.append(str3);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("hb=");
                stringBuffer.append(z ? 1 : 0);
                stringBuffer.append("&");
                stringBuffer.append("reason=" + str);
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22054e(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m22069a(Context context, String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000104&");
                if (!TextUtils.isEmpty(str2)) {
                    String str7 = MBSDKContext.f30251b.get(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    sb.append(str7);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid=" + str3 + "&");
                }
                if (!TextUtils.isEmpty(str4)) {
                    stringBuffer.append("rid_n=" + str4 + "&");
                }
                if (!TextUtils.isEmpty(str5)) {
                    stringBuffer.append("cid=" + str5 + "&");
                }
                if (!TextUtils.isEmpty(str6)) {
                    stringBuffer.append("template_id=" + str6 + "&");
                }
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("hb=");
                stringBuffer.append(z ? 1 : 0);
                stringBuffer.append("&");
                stringBuffer.append("reason=" + str);
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22054e(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m22068a(Context context, List<CampaignEx> list, String str, boolean z) {
        if (context == null || list == null) {
            return;
        }
        try {
            if (list.size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000048&");
            stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            CampaignEx campaignEx = list.get(0);
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            if (z) {
                stringBuffer.append("hb=");
                stringBuffer.append(1);
                stringBuffer.append("&");
            }
            String requestId = campaignEx.getRequestId();
            if (!TextUtils.isEmpty(requestId)) {
                stringBuffer.append("rid=");
                stringBuffer.append(requestId);
                stringBuffer.append("&");
            }
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (!TextUtils.isEmpty(requestIdNotice)) {
                stringBuffer.append("rid_n=");
                stringBuffer.append(requestIdNotice);
                stringBuffer.append("&");
            }
            StringBuilder sb = new StringBuilder("rtins_type=");
            for (int i = 0; i < list.size(); i++) {
                CampaignEx campaignEx2 = list.get(i);
                if (i < list.size() - 1) {
                    sb.append(campaignEx2.getRtinsType());
                    sb.append(",");
                } else {
                    sb.append(campaignEx2.getRtinsType());
                }
            }
            stringBuffer.append((CharSequence) sb);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
            } else {
                m22075a(context, stringBuffer.toString(), str);
            }
        } catch (Throwable th) {
            SameLogTool.m21733d(f30952a, th.getMessage());
        }
    }

    /* renamed from: a */
    public static void m22082a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000054&");
            stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
            stringBuffer.append("unit_id=" + str + "&");
            stringBuffer.append("cid=" + campaignEx.getId() + "&");
            stringBuffer.append("reason=&");
            stringBuffer.append("result=2&");
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(str2);
            }
            if (campaignEx.getAdType() == 287) {
                stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                stringBuffer.append("ad_type=3&");
            } else if (campaignEx.getAdType() == 94) {
                stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                stringBuffer.append("ad_type=1&");
            } else if (campaignEx.getAdType() == 296) {
                stringBuffer.append("ad_type=5&");
                stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
            } else if (campaignEx.getAdType() == 297) {
                stringBuffer.append("ad_type=6&");
                stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
            } else if (campaignEx.getAdType() == 298) {
                stringBuffer.append("ad_type=7&");
                stringBuffer.append("creative=" + campaignEx.getCreativeId() + "&");
            } else {
                stringBuffer.append("creative=" + URLEncoder.encode(campaignEx.getendcard_url()) + "&");
                stringBuffer.append("ad_type=1&");
            }
            stringBuffer.append("devid=" + SameDiTool.m21803E() + "&");
            if (campaignEx.isBidCampaign()) {
                stringBuffer.append("hb=1&");
            }
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=");
            stringBuffer.append(campaignEx.getRequestIdNotice());
            stringBuffer.append("&");
            stringBuffer.append("adspace_t=");
            stringBuffer.append(campaignEx.getAdSpaceT());
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
            } else {
                m22075a(context, stringBuffer.toString(), str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m22076a(Context context, String str, int i, String str2, String str3, CampaignEx campaignEx) {
        if (campaignEx == null || context == null) {
            return;
        }
        try {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            boolean isBidCampaign = campaignEx.isBidCampaign();
            String requestId = campaignEx.getRequestId();
            String id = campaignEx.getId();
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(campaignUnitId)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000108&");
            if (!TextUtils.isEmpty(campaignUnitId)) {
                String str4 = MBSDKContext.f30251b.get(campaignUnitId);
                StringBuilder sb = new StringBuilder();
                sb.append("u_stid=");
                if (str4 == null) {
                    str4 = "";
                }
                sb.append(str4);
                sb.append("&");
                stringBuffer.append(sb.toString());
            }
            if (!TextUtils.isEmpty(requestId)) {
                stringBuffer.append("rid=" + requestId + "&");
            }
            if (!TextUtils.isEmpty(id)) {
                stringBuffer.append("cid=" + id + "&");
            }
            stringBuffer.append("template_id=" + i + "&");
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("ad_type=" + str + "&");
            }
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("process=" + str3 + "&");
            }
            stringBuffer.append("unit_id=" + campaignUnitId + "&");
            stringBuffer.append("hb=");
            stringBuffer.append(isBidCampaign ? 1 : 0);
            stringBuffer.append("&");
            stringBuffer.append("reason=" + str2);
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
            } else {
                m22054e(context, stringBuffer.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m22079a(Context context, CampaignEx campaignEx, String str, String str2, int i, String str3, int i2) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000073&");
                stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("reason=" + str3 + "&");
                stringBuffer.append("result=" + i + "&");
                if (campaignEx != null) {
                    stringBuffer.append("cid=" + campaignEx.getId() + "&");
                    stringBuffer.append("rid=");
                    stringBuffer.append(campaignEx.getRequestId());
                    stringBuffer.append("&");
                    stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                }
                stringBuffer.append("d_t=" + i2 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(URLEncoder.encode(str, "utf-8"));
                stringBuffer.append(sb.toString());
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22075a(context, stringBuffer.toString(), str2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m22083a(Context context, CampaignEx campaignEx, int i, String str, String str2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000114&");
            stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("gh_id=");
            String str3 = "";
            sb.append(TextUtils.isEmpty(campaignEx.getGhId()) ? "" : URLEncoder.encode(campaignEx.getGhId(), "utf-8"));
            sb.append("&");
            stringBuffer.append(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("gh_path=");
            sb2.append(TextUtils.isEmpty(campaignEx.getGhPath()) ? "" : URLEncoder.encode(campaignEx.getGhPath(), "utf-8"));
            sb2.append("&");
            stringBuffer.append(sb2.toString());
            stringBuffer.append("unit_id=" + str2 + "&");
            stringBuffer.append("rid=");
            stringBuffer.append(campaignEx.getRequestId());
            stringBuffer.append("&");
            stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
            stringBuffer.append("result=" + i + "&");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("reason=");
            if (!TextUtils.isEmpty(str)) {
                str3 = URLEncoder.encode(str, "utf-8");
            }
            sb3.append(str3);
            sb3.append("&");
            stringBuffer.append(sb3.toString());
            stringBuffer.append("cid=" + campaignEx.getId());
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
            } else {
                m22075a(context, stringBuffer.toString(), str2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m22081a(Context context, CampaignEx campaignEx, String str, String str2, int i, int i2) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000074&");
                stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("type=" + i + "&");
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBuffer.append("d_t=" + i2 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(URLEncoder.encode(str, "utf-8"));
                stringBuffer.append(sb.toString());
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22075a(context, stringBuffer.toString(), str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m22080a(Context context, CampaignEx campaignEx, String str, String str2, int i, int i2, int i3) {
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000075&");
                stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                stringBuffer.append("unit_id=" + str2 + "&");
                stringBuffer.append("cid=" + campaignEx.getId() + "&");
                stringBuffer.append("type=" + i + "&");
                stringBuffer.append("rid=");
                stringBuffer.append(campaignEx.getRequestId());
                stringBuffer.append("&");
                stringBuffer.append("rid_n=" + campaignEx.getRequestIdNotice() + "&");
                stringBuffer.append("statue=" + i2 + "&");
                stringBuffer.append("d_t=" + i3 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(URLEncoder.encode(str, "utf-8"));
                stringBuffer.append(sb.toString());
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22075a(context, stringBuffer.toString(), str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m22074a(Context context, String str, String str2, int i, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000076&");
                    stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    stringBuffer.append("reason=" + str3 + "&");
                    stringBuffer.append("result=" + i + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("url=");
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (MBBatchReportManager.m22142a().m22135c()) {
                        MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                    } else {
                        m22075a(context, stringBuffer.toString(), str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m22071a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000086&");
                stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                stringBuffer.append("uniquekey=" + str + "&");
                stringBuffer.append("rid=" + str2 + "&");
                stringBuffer.append("rid_n=" + str4 + "&");
                stringBuffer.append("cid=" + str5 + "&");
                stringBuffer.append("unit_id=" + str6 + "&");
                if (!TextUtils.isEmpty(str6)) {
                    String str7 = MBSDKContext.f30251b.get(str6);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    sb.append(str7);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("packageName=" + str3);
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22055d(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m22072a(Context context, String str, String str2, String str3, int i, String str4, String str5, String str6) {
        if (context != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000087&");
                stringBuffer.append("network_type=" + SameDiTool.m21804D(context) + "&");
                stringBuffer.append("uniquekey=" + str + "&");
                stringBuffer.append("rid=" + str2 + "&");
                stringBuffer.append("rid_n=" + str4 + "&");
                stringBuffer.append("cid=" + str5 + "&");
                stringBuffer.append("unit_id=" + str6 + "&");
                if (!TextUtils.isEmpty(str6)) {
                    String str7 = MBSDKContext.f30251b.get(str6);
                    StringBuilder sb = new StringBuilder();
                    sb.append("u_stid=");
                    if (str7 == null) {
                        str7 = "";
                    }
                    sb.append(str7);
                    sb.append("&");
                    stringBuffer.append(sb.toString());
                }
                stringBuffer.append("packageName=" + str3 + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("result=");
                sb2.append(i);
                stringBuffer.append(sb2.toString());
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22055d(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m22073a(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000089&");
                stringBuffer.append("appid=" + MBSDKContext.m22865f().m22860k() + "&");
                stringBuffer.append("s=" + str + "&");
                stringBuffer.append("i=" + str2 + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("i_c=");
                sb.append(str3);
                stringBuffer.append(sb.toString());
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                } else {
                    m22055d(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m22075a(final Context context, final String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            new ReportRequest(context).m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a(str, context, str2), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.e.2
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str3) {
                    SameLogTool.m21733d(C11385e.f30952a, str3);
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str3) {
                    ReportData reportData = new ReportData();
                    reportData.m22464d(str);
                    reportData.m22471a(System.currentTimeMillis());
                    reportData.m22472a(0);
                    reportData.m22466c("POST");
                    reportData.m22468b(RequestUrlUtil.m22248a().f30791a);
                    ReportErrorDao.m22686a(CommonSDKDBHelper.m22721a(context)).m22685a(reportData);
                    SameLogTool.m21733d(C11385e.f30952a, str3);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            SameLogTool.m21733d(f30952a, e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m22064a(String str) {
        ReportRequest reportRequest = new ReportRequest(MBSDKContext.m22865f().m22861j());
        String str2 = "key=2000088&state=" + str;
        SameLogTool.m21733d(f30952a, str2);
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null || DomainReport.m22149a(m23252b, str2)) {
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a(str2, MBSDKContext.m22865f().m22861j(), ""), null);
        }
    }

    /* renamed from: a */
    public static void m22086a(int i, String str, String str2) {
        try {
            ReportRequest reportRequest = new ReportRequest(MBSDKContext.m22865f().m22861j());
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a("key=2000080&reason=" + str2 + "&ad_type=" + i + "&url=" + URLEncoder.encode(str, "utf-8"), MBSDKContext.m22865f().m22861j(), ""), null);
        } catch (Exception e) {
            SameLogTool.m21733d(f30952a, e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m22067a(CampaignEx campaignEx, String str, int i, int i2, String str2, int i3, int i4, int i5) {
        try {
            ReportRequest reportRequest = new ReportRequest(MBSDKContext.m22865f().m22861j());
            StringBuilder sb = new StringBuilder();
            sb.append(DomainCampaignEx.LOOPBACK_KEY);
            sb.append("=");
            sb.append(URLEncoder.encode("2000094", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
            sb.append("&");
            sb.append(BidResponsedEx.KEY_CID);
            sb.append("=");
            sb.append(URLEncoder.encode(campaignEx.getId(), "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("video_prg");
            sb.append("=");
            sb.append(i);
            sb.append("&");
            sb.append("phase");
            sb.append("=");
            sb.append(i2);
            sb.append("&");
            sb.append("feedback_content");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("feedback_close");
            sb.append("=");
            sb.append(i3);
            sb.append("&");
            sb.append("type");
            sb.append("=");
            sb.append(i5);
            sb.append("&");
            sb.append("ad_type");
            sb.append("=");
            sb.append(i4);
            sb.append("&");
            sb.append(UMCommonContent.f37763T);
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(SameDiTool.m21804D(MBSDKContext.m22865f().m22861j())), "utf-8"));
            if (i3 == 1) {
                sb.append("&");
                sb.append("campaign");
                sb.append("=");
                sb.append(URLEncoder.encode(CampaignEx.campaignToJsonObject(campaignEx).toString(), "utf-8"));
            }
            if (MBridgeConstans.DEBUG && i3 == 1) {
                String str3 = f30952a;
                SameLogTool.m21733d(str3, "2000094:" + ((Object) sb));
            }
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(sb.toString());
                return;
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a(sb.toString(), MBSDKContext.m22865f().m22861j(), str), new ReportResponseHandler() { // from class: com.mbridge.msdk.foundation.same.report.e.5
                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: a */
                public final void mo20683a(String str4) {
                    SameLogTool.m21738a("", "FLBClick REPORT SUCCESS");
                }

                @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                /* renamed from: b */
                public final void mo20682b(String str4) {
                    SameLogTool.m21738a("", "FLBClick REPORT FAILED");
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
