package com.mbridge.msdk.mbbid.common;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.tools.CommonBatteryStatusUtil;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.DomainSameTool;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameSDCardTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;

/* renamed from: com.mbridge.msdk.mbbid.common.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AreaBidCommon {
    /* renamed from: a */
    public static String m21703a(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (context != null) {
            try {
                if (MBSDKContext.m22865f().m22861j() == null) {
                    MBSDKContext.m22865f().m22875b(context);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        stringBuffer.append(SameDiTool.m21803E());
        stringBuffer.append("|");
        stringBuffer.append((m23252b.m23371aa() == 1 && SDKAuthorityController.m22842a().m22840a("authority_android_id")) ? DomainSameDiTool.m21903g(context) : "");
        stringBuffer.append("|");
        stringBuffer.append((m23252b.m23404Z() == 1 && SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) ? DomainSameDiTool.m21918b(context) : "");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21762z());
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21764y());
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21804D(context));
        stringBuffer.append("|");
        stringBuffer.append(MBConfiguration.SDK_VERSION);
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21765x(context));
        stringBuffer.append("x");
        stringBuffer.append(SameDiTool.m21763y(context));
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21811A());
        stringBuffer.append("|");
        stringBuffer.append(DomainSameTool.m21874a(20));
        stringBuffer.append("|");
        stringBuffer.append(SameTool.m22003b(20));
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(CommonConst.f30583f);
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21792L());
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21793K());
        stringBuffer.append("|");
        stringBuffer.append(DomainSameDiTool.m21882s());
        stringBuffer.append("|");
        stringBuffer.append(CommonBatteryStatusUtil.m21932a());
        stringBuffer.append("|");
        stringBuffer.append(CommonBatteryStatusUtil.m21926b());
        stringBuffer.append("|");
        stringBuffer.append(SameSDCardTool.m22039b());
        stringBuffer.append("|");
        stringBuffer.append(SameSDCardTool.m22042a());
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(SharedPerferenceManager.m22949a().m22944b("b"));
        stringBuffer.append("|");
        stringBuffer.append(SharedPerferenceManager.m22949a().m22944b("c"));
        stringBuffer.append("|");
        stringBuffer.append("");
        String m23295o = m23252b.m23295o();
        stringBuffer.append("|");
        stringBuffer.append(m23295o);
        stringBuffer.append("|");
        stringBuffer.append(SameTool.m21986e());
        stringBuffer.append("|");
        String m21983f = SameTool.m21983f();
        if (TextUtils.isEmpty(m21983f)) {
            m21983f = "";
        }
        stringBuffer.append(m21983f);
        stringBuffer.append("|");
        stringBuffer.append(SameTool.m21967m(str));
        stringBuffer.append("|");
        if (m23252b.m23440G() == 1 && SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            stringBuffer.append(DomainSameDiTool.m21921a(context));
        }
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21770v());
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21774r(context));
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21768w() + "");
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21779g(MBSDKContext.m22865f().m22858m()) + "");
        stringBuffer.append("|");
        stringBuffer.append(SameDiTool.m21789O());
        stringBuffer.append("|");
        stringBuffer.append(SDKAuthorityController.m22828g() ? "1" : "2");
        stringBuffer.append("|");
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            stringBuffer.append(DomainSameDiTool.m21880u());
        }
        return SameBase64Tool.m21813a(stringBuffer.toString());
    }
}
