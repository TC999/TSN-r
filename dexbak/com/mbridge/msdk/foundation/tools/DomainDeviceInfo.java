package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.tools.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DomainDeviceInfo {

    /* renamed from: d */
    public String f31029d;

    /* renamed from: e */
    public String f31030e;

    /* renamed from: g */
    public String f31032g;

    /* renamed from: h */
    public String f31033h;

    /* renamed from: i */
    public String f31034i;

    /* renamed from: j */
    public String f31035j;

    /* renamed from: k */
    public String f31036k;

    /* renamed from: l */
    public String f31037l;

    /* renamed from: m */
    public String f31038m;

    /* renamed from: n */
    public String f31039n;

    /* renamed from: o */
    public String f31040o;

    /* renamed from: p */
    public String f31041p;

    /* renamed from: q */
    public String f31042q;

    /* renamed from: r */
    public String f31043r;

    /* renamed from: s */
    public String f31044s;

    /* renamed from: t */
    public String f31045t;

    /* renamed from: u */
    public String f31046u;

    /* renamed from: v */
    public int f31047v;

    /* renamed from: w */
    public JSONObject f31048w;

    /* renamed from: c */
    public String f31028c = FaceEnvironment.f8430OS;

    /* renamed from: a */
    public String f31026a = SameDiTool.m21764y();

    /* renamed from: b */
    public String f31027b = SameDiTool.m21807C();

    /* renamed from: f */
    public String f31031f = SameDiTool.m21803E();

    public DomainDeviceInfo(Context context) {
        this.f31029d = DomainSameDiTool.m21918b(context);
        this.f31030e = DomainSameDiTool.m21903g(context);
        int m21804D = SameDiTool.m21804D(context);
        this.f31032g = String.valueOf(m21804D);
        this.f31033h = SameDiTool.m21784a(context, m21804D);
        this.f31034i = SameDiTool.m21806C(context);
        this.f31035j = MBSDKContext.m22865f().m22859l();
        this.f31036k = MBSDKContext.m22865f().m22860k();
        this.f31037l = String.valueOf(SameTool.m21978h(context));
        this.f31038m = String.valueOf(SameTool.m21980g(context));
        this.f31042q = String.valueOf(SameTool.m21988d(context));
        this.f31044s = MBSDKContext.m22865f().m22856o().toString();
        this.f31046u = SameDiTool.m21762z();
        this.f31047v = SameTool.m21986e();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f31039n = "landscape";
        } else {
            this.f31039n = "portrait";
        }
        this.f31043r = DomainSameDiTool.m21921a(context);
        this.f31040o = CommonConst.f30596s;
        this.f31041p = CommonConst.f30597t;
        this.f31045t = SameDiTool.m21794J();
        this.f31048w = m21923a(context, true);
    }

    /* renamed from: a */
    private JSONObject m21923a(Context context, boolean z) {
        Setting m23252b;
        JSONObject jSONObject = new JSONObject();
        try {
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put(BidResponsedEx.KEY_CID, DomainSameDiTool.m21922a() + "");
                jSONObject.put("dmt", SameDiTool.m21792L() + "");
                jSONObject.put("dmf", SameDiTool.m21793K());
                jSONObject.put("ct", DomainSameDiTool.m21882s());
            }
            m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        } catch (JSONException e) {
            SameLogTool.m21733d("DomainDeviceInfo", e.getMessage());
        }
        if (m23252b != null && context != null) {
            if (m23252b.m23404Z() == 1) {
                if (DomainSameDiTool.m21918b(context) != null && SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                    jSONObject.put("imei", DomainSameDiTool.m21918b(context));
                }
                if (DomainSameDiTool.m21899i(context) != null && SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                    jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, DomainSameDiTool.m21899i(context));
                }
                if (DomainSameDiTool.m21915c(context) != null && z && SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                    jSONObject.put("imsi", DomainSameDiTool.m21915c(context));
                }
            }
            if (m23252b.m23440G() == 1 && DomainSameDiTool.m21921a(context) != null && SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("oaid", DomainSameDiTool.m21921a(context));
            }
            if (m23252b.m23371aa() == 1 && DomainSameDiTool.m21903g(context) != null && SDKAuthorityController.m22842a().m22840a("authority_android_id")) {
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DomainSameDiTool.m21903g(context));
            }
            return jSONObject;
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final JSONObject m21924a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put(ConstantHelper.LOG_DE, this.f31026a);
                jSONObject.put("system_version", this.f31027b);
                jSONObject.put(UMCommonContent.f37763T, this.f31032g);
                jSONObject.put("network_type_str", this.f31033h);
                jSONObject.put("device_ua", this.f31034i);
                jSONObject.put("has_wx", SameDiTool.m21774r(MBSDKContext.m22865f().m22861j()));
                jSONObject.put("integrated_wx", SameDiTool.m21770v());
                jSONObject.put("opensdk_ver", SameDiTool.m21768w() + "");
                jSONObject.put("wx_api_ver", SameDiTool.m21779g(MBSDKContext.m22865f().m22858m()) + "");
                jSONObject.put("emu", DomainSameDiTool.m21880u());
                jSONObject.put(C2624bk.f8686j, this.f31046u);
            }
            jSONObject.put("plantform", this.f31028c);
            if (SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                jSONObject.put("device_imei", this.f31029d);
            }
            if (SDKAuthorityController.m22842a().m22840a("authority_android_id")) {
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, this.f31030e);
            }
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f31031f);
                jSONObject.put("oaid", this.f31043r);
            }
            jSONObject.put("appkey", this.f31035j);
            jSONObject.put("appId", this.f31036k);
            jSONObject.put("screen_width", this.f31037l);
            jSONObject.put("screen_height", this.f31038m);
            jSONObject.put("orientation", this.f31039n);
            jSONObject.put("scale", this.f31042q);
            jSONObject.put("b", this.f31040o);
            jSONObject.put("c", this.f31041p);
            jSONObject.put("web_env", this.f31044s);
            jSONObject.put("f", this.f31045t);
            jSONObject.put("misk_spt", this.f31047v);
            jSONObject.put("dvi", SameBase64Tool.m21813a(this.f31048w.toString()));
            if (!SDKAuthorityController.m22828g()) {
                jSONObject.put("dev_source", "2");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
