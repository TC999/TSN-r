package com.mbridge.msdk.splash.p501a;

import android.content.Context;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceInfo.java */
/* renamed from: com.mbridge.msdk.splash.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11566a {

    /* renamed from: d */
    public String f31700d;

    /* renamed from: e */
    public String f31701e;

    /* renamed from: g */
    public String f31703g;

    /* renamed from: h */
    public String f31704h;

    /* renamed from: i */
    public String f31705i;

    /* renamed from: j */
    public String f31706j;

    /* renamed from: k */
    public String f31707k;

    /* renamed from: l */
    public String f31708l;

    /* renamed from: m */
    public String f31709m;

    /* renamed from: n */
    public String f31710n;

    /* renamed from: o */
    public String f31711o;

    /* renamed from: p */
    public String f31712p;

    /* renamed from: c */
    public String f31699c = FaceEnvironment.f8430OS;

    /* renamed from: a */
    public String f31697a = SameDiTool.m21764y();

    /* renamed from: b */
    public String f31698b = SameDiTool.m21807C();

    /* renamed from: f */
    public String f31702f = SameDiTool.m21803E();

    public C11566a(Context context) {
        this.f31700d = DomainSameDiTool.m21918b(context);
        this.f31701e = DomainSameDiTool.m21903g(context);
        int m21804D = SameDiTool.m21804D(context);
        this.f31704h = String.valueOf(m21804D);
        this.f31705i = SameDiTool.m21784a(context, m21804D);
        this.f31706j = SameDiTool.m21806C(context);
        this.f31707k = MBSDKContext.m22865f().m22859l();
        this.f31708l = MBSDKContext.m22865f().m22860k();
        this.f31709m = String.valueOf(SameTool.m21978h(context));
        this.f31710n = String.valueOf(SameTool.m21980g(context));
        this.f31712p = String.valueOf(SameTool.m21988d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f31711o = "landscape";
        } else {
            this.f31711o = "portrait";
        }
        this.f31703g = DomainSameDiTool.m21921a(context);
    }

    /* renamed from: a */
    public final JSONObject m21298a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put(ConstantHelper.LOG_DE, this.f31697a);
                jSONObject.put("system_version", this.f31698b);
                jSONObject.put(UMCommonContent.f37763T, this.f31704h);
                jSONObject.put("network_type_str", this.f31705i);
                jSONObject.put("device_ua", this.f31706j);
                jSONObject.put("has_wx", SameDiTool.m21774r(MBSDKContext.m22865f().m22861j()));
                jSONObject.put("integrated_wx", SameDiTool.m21770v());
                jSONObject.put("opensdk_ver", SameDiTool.m21768w() + "");
                jSONObject.put("wx_api_ver", SameDiTool.m21779g(MBSDKContext.m22865f().m22858m()) + "");
                jSONObject.put("emu", DomainSameDiTool.m21880u());
            }
            jSONObject.put("plantform", this.f31699c);
            if (SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
                jSONObject.put("device_imei", this.f31700d);
            }
            if (SDKAuthorityController.m22842a().m22840a("authority_android_id")) {
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, this.f31701e);
            }
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f31702f);
                jSONObject.put("oaid", this.f31703g);
            }
            jSONObject.put("appkey", this.f31707k);
            jSONObject.put("appId", this.f31708l);
            jSONObject.put("screen_width", this.f31709m);
            jSONObject.put("screen_height", this.f31710n);
            jSONObject.put("orientation", this.f31711o);
            jSONObject.put("scale", this.f31712p);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
