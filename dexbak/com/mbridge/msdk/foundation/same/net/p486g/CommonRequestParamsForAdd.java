package com.mbridge.msdk.foundation.same.net.p486g;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.tools.CommonBatteryStatusUtil;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameSDCardTool;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.net.g.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonRequestParamsForAdd {

    /* renamed from: a */
    private static String f30831a = "";

    /* renamed from: b */
    private static String f30832b = "";

    /* renamed from: a */
    public static void m22219a(CommonRequestParams commonRequestParams, Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            commonRequestParams.m22222a("withGP", SameDiTool.m21789O() + "");
            commonRequestParams.m22222a("has_wx", SameDiTool.m21774r(MBSDKContext.m22865f().m22861j()) + "");
            commonRequestParams.m22222a("integrated_wx", SameDiTool.m21770v() + "");
            commonRequestParams.m22222a("opensdk_ver", SameDiTool.m21768w() + "");
            commonRequestParams.m22222a("wx_api_ver", SameDiTool.m21779g(MBSDKContext.m22865f().m22858m()) + "");
            SDKAuthorityController.m22842a();
            if (SharedPerferenceManager.m22949a().m22943b(MBridgeConstans.AUTHORITY_DNT, 0) == 1) {
                commonRequestParams.m22222a("dnt", "1");
            }
            commonRequestParams.m22222a("emu", DomainSameDiTool.m21880u());
        }
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_OTHER)) {
            String str = CommonRequestParams.f30826f;
            commonRequestParams.m22222a(str, SameSDCardTool.m22039b() + "");
            String str2 = CommonRequestParams.f30827g;
            commonRequestParams.m22222a(str2, SameSDCardTool.m22042a() + "");
            commonRequestParams.m22222a("power_rate", CommonBatteryStatusUtil.m21932a() + "");
            commonRequestParams.m22222a("charging", CommonBatteryStatusUtil.m21926b() + "");
            commonRequestParams.m22222a(CommonRequestParams.f30824d, SameDiTool.m21794J());
        }
        commonRequestParams.m22222a("pkg_source", SameDiTool.m21783a(SameDiTool.m21810A(context), context));
        if (MBSDKContext.m22865f().m22856o() != null) {
            commonRequestParams.m22222a("web_env", MBSDKContext.m22865f().m22856o().toString());
        }
        if (Build.VERSION.SDK_INT > 18) {
            commonRequestParams.m22222a("http_req", "2");
        }
        m22218a(commonRequestParams, true);
        m22214e(commonRequestParams);
        m22216c(commonRequestParams);
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        if (m23252b.m23378aT()) {
            commonRequestParams.m22222a("gdpr_consent", SDKAuthorityController.m22842a().m22829f() + "");
        }
        m22213f(commonRequestParams);
    }

    /* renamed from: b */
    public static void m22217b(CommonRequestParams commonRequestParams) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            commonRequestParams.m22222a("withGP", SameDiTool.m21789O() + "");
            commonRequestParams.m22222a("has_wx", SameDiTool.m21774r(MBSDKContext.m22865f().m22861j()) + "");
            commonRequestParams.m22222a("integrated_wx", SameDiTool.m21770v() + "");
            commonRequestParams.m22222a("opensdk_ver", SameDiTool.m21768w() + "");
            commonRequestParams.m22222a("wx_api_ver", SameDiTool.m21779g(MBSDKContext.m22865f().m22858m()) + "");
        }
        m22218a(commonRequestParams, false);
        m22214e(commonRequestParams);
        m22216c(commonRequestParams);
        m22213f(commonRequestParams);
    }

    /* renamed from: c */
    public static void m22216c(CommonRequestParams commonRequestParams) {
        try {
            if (TextUtils.isEmpty(CommonConst.f30596s)) {
                CommonConst.f30596s = SharedPerferenceManager.m22949a().m22944b("b");
            }
            if (!TextUtils.isEmpty(CommonConst.f30596s)) {
                commonRequestParams.m22222a("b", CommonConst.f30596s);
            }
            if (TextUtils.isEmpty(CommonConst.f30597t)) {
                CommonConst.f30597t = SharedPerferenceManager.m22949a().m22944b("c");
            }
            if (TextUtils.isEmpty(CommonConst.f30597t)) {
                return;
            }
            commonRequestParams.m22222a("c", CommonConst.f30597t);
        } catch (Exception e) {
            SameLogTool.m21733d("CommonRequestParamsForAdd", e.getMessage());
        }
    }

    /* renamed from: d */
    public static void m22215d(CommonRequestParams commonRequestParams) {
        if (commonRequestParams != null) {
            if (!SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                commonRequestParams.m22223a(C2624bk.f8685i);
                commonRequestParams.m22223a(C2624bk.f8686j);
                commonRequestParams.m22223a("screen_size");
                commonRequestParams.m22223a("sub_ip");
                commonRequestParams.m22223a(UMCommonContent.f37763T);
                commonRequestParams.m22223a("useragent");
                commonRequestParams.m22223a(PathCenter.f37685d);
                commonRequestParams.m22223a("language");
                commonRequestParams.m22223a("network_str");
                commonRequestParams.m22223a("mnc");
                commonRequestParams.m22223a("mcc");
                commonRequestParams.m22223a("os_version");
                commonRequestParams.m22223a("gp_version");
                commonRequestParams.m22223a("country_code");
            }
            if (!SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_OTHER)) {
                commonRequestParams.m22223a(CommonRequestParams.f30826f);
                commonRequestParams.m22223a(CommonRequestParams.f30827g);
                commonRequestParams.m22223a("power_rate");
                commonRequestParams.m22223a("charging");
                commonRequestParams.m22223a(UMCommonContent.f37756M);
            }
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                return;
            }
            commonRequestParams.m22223a("gaid");
            commonRequestParams.m22223a("gaid2");
            commonRequestParams.m22223a("oaid");
        }
    }

    /* renamed from: e */
    private static void m22214e(CommonRequestParams commonRequestParams) {
        int m21791M = SameDiTool.m21791M();
        if (m21791M != -1) {
            commonRequestParams.m22222a("unknown_source", m21791M + "");
        }
    }

    /* renamed from: f */
    private static void m22213f(CommonRequestParams commonRequestParams) {
        String m21790N = SameDiTool.m21790N();
        if (TextUtils.isEmpty(m21790N) || m21790N.equals(FaceEnvironment.f8430OS)) {
            return;
        }
        commonRequestParams.m22222a("hm_info", m21790N);
    }

    /* renamed from: a */
    public static void m22220a(CommonRequestParams commonRequestParams) {
        commonRequestParams.m22222a("api_version", CommonConst.f30583f);
    }

    /* renamed from: a */
    private static void m22218a(CommonRequestParams commonRequestParams, boolean z) {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b != null) {
            if (!TextUtils.isEmpty(m23252b.m23295o()) && z) {
                commonRequestParams.m22222a("a_stid", m23252b.m23295o());
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (m23252b.m23404Z() == 1) {
                    if (DomainSameDiTool.m21918b(m22861j) != null && SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                        jSONObject.put("imei", DomainSameDiTool.m21918b(m22861j));
                    }
                    if (DomainSameDiTool.m21899i(m22861j) != null && SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, DomainSameDiTool.m21899i(m22861j));
                    }
                    if (DomainSameDiTool.m21915c(m22861j) != null && z && SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                        jSONObject.put("imsi", DomainSameDiTool.m21915c(m22861j));
                    }
                }
                if (m23252b.m23440G() == 1 && DomainSameDiTool.m21921a(m22861j) != null && SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    jSONObject.put("oaid", DomainSameDiTool.m21921a(m22861j));
                }
                if (m23252b.m23371aa() == 1 && DomainSameDiTool.m21903g(m22861j) != null && SDKAuthorityController.m22842a().m22840a("authority_android_id")) {
                    jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DomainSameDiTool.m21903g(m22861j));
                }
                if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put(BidResponsedEx.KEY_CID, DomainSameDiTool.m21922a() + "");
                    jSONObject.put("dmt", SameDiTool.m21792L() + "");
                    jSONObject.put("dmf", SameDiTool.m21793K());
                    jSONObject.put("ct", DomainSameDiTool.m21882s());
                }
                if (TextUtils.isEmpty(jSONObject.toString())) {
                    return;
                }
                if (!jSONObject.equals(f30831a)) {
                    f30832b = SameBase64Tool.m21813a(jSONObject.toString());
                }
                if (TextUtils.isEmpty(f30832b)) {
                    return;
                }
                commonRequestParams.m22222a("dvi", f30832b);
            } catch (Exception e) {
                SameLogTool.m21733d("CommonRequestParamsForAdd", e.getMessage());
            }
        }
    }
}
