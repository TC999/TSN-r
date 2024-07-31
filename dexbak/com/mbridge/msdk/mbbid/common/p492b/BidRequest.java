package com.mbridge.msdk.mbbid.common.p492b;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParamsForAdd;
import com.mbridge.msdk.foundation.same.net.p486g.HeaderBiddingRequest;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;

/* renamed from: com.mbridge.msdk.mbbid.common.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class BidRequest extends HeaderBiddingRequest {
    public BidRequest(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.p486g.HeaderBiddingRequest, com.mbridge.msdk.foundation.same.net.p486g.CommonAsyncHttpRequest
    /* renamed from: a */
    public final void mo20858a(String str, CommonRequestParams commonRequestParams) {
        super.mo20858a(str, commonRequestParams);
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        commonRequestParams.m22222a(Constants.PARAM_PLATFORM, "1");
        commonRequestParams.m22222a("os_version", Build.VERSION.RELEASE);
        commonRequestParams.m22222a("package_name", SameDiTool.m21810A(this.f30819a));
        commonRequestParams.m22222a("app_version_name", SameDiTool.m21769v(this.f30819a));
        commonRequestParams.m22222a("app_version_code", SameDiTool.m21771u(this.f30819a) + "");
        commonRequestParams.m22222a(C2624bk.f8685i, SameDiTool.m21766x());
        commonRequestParams.m22222a(C2624bk.f8686j, SameDiTool.m21762z());
        commonRequestParams.m22222a("gaid", "");
        commonRequestParams.m22222a("gaid2", SameDiTool.m21801F());
        if (m23252b.m23404Z() == 1 && SDKAuthorityController.m22842a().m22840a("authority_imei_mac") && DomainSameDiTool.m21918b(this.f30819a) != null) {
            commonRequestParams.m22222a("d1", SameBase64Tool.m21813a(DomainSameDiTool.m21918b(this.f30819a)));
        }
        if (m23252b.m23371aa() == 1 && DomainSameDiTool.m21903g(this.f30819a) != null && SDKAuthorityController.m22842a().m22840a("authority_android_id")) {
            commonRequestParams.m22222a("d3", DomainSameDiTool.m21906f(this.f30819a));
        }
        commonRequestParams.m22222a("mnc", DomainSameDiTool.m21909e(this.f30819a));
        commonRequestParams.m22222a("mcc", DomainSameDiTool.m21912d(this.f30819a));
        int m21804D = SameDiTool.m21804D(this.f30819a);
        commonRequestParams.m22222a(UMCommonContent.f37763T, m21804D + "");
        commonRequestParams.m22222a("network_str", SameDiTool.m21784a(this.f30819a, m21804D) + "");
        commonRequestParams.m22222a("language", SameDiTool.m21773s(this.f30819a));
        commonRequestParams.m22222a(UMCommonContent.f37756M, SameDiTool.m21809B());
        commonRequestParams.m22222a("useragent", SameDiTool.m21811A());
        commonRequestParams.m22222a("sdk_version", MBConfiguration.SDK_VERSION);
        commonRequestParams.m22222a("gp_version", DomainSameDiTool.m21897j(this.f30819a));
        commonRequestParams.m22222a("screen_size", SameDiTool.m21765x(this.f30819a) + "x" + SameDiTool.m21763y(this.f30819a));
        commonRequestParams.m22222a("is_clever", CommonConst.f30588k);
        CommonRequestParamsForAdd.m22219a(commonRequestParams, this.f30819a);
        CommonRequestParamsForAdd.m22220a(commonRequestParams);
    }
}
