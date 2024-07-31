package com.mbridge.msdk.splash.p507f;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.p486g.CampaignRequest;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParamsForAdd;
import com.mbridge.msdk.foundation.tools.DomainSameDiTool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.out.MBConfiguration;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;

/* renamed from: com.mbridge.msdk.splash.f.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SplashMBLoadRequest extends CampaignRequest {
    public SplashMBLoadRequest(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.p486g.CampaignRequest, com.mbridge.msdk.foundation.same.net.p486g.CommonAsyncHttpRequest
    /* renamed from: a */
    public final void mo20858a(String str, CommonRequestParams commonRequestParams) {
        super.mo20858a(str, commonRequestParams);
        commonRequestParams.m22222a(Constants.PARAM_PLATFORM, "1");
        commonRequestParams.m22222a("os_version", Build.VERSION.RELEASE);
        commonRequestParams.m22222a("package_name", SameDiTool.m21810A(this.f30819a));
        commonRequestParams.m22222a("app_version_name", SameDiTool.m21769v(this.f30819a));
        commonRequestParams.m22222a("app_version_code", SameDiTool.m21771u(this.f30819a) + "");
        commonRequestParams.m22222a("orientation", SameDiTool.m21772t(this.f30819a) + "");
        commonRequestParams.m22222a(C2624bk.f8685i, SameDiTool.m21766x());
        commonRequestParams.m22222a(C2624bk.f8686j, SameDiTool.m21762z());
        commonRequestParams.m22222a("gaid", "");
        commonRequestParams.m22222a("gaid2", SameDiTool.m21801F());
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
        commonRequestParams.m22222a("version_flag", "1");
        CommonRequestParamsForAdd.m22219a(commonRequestParams, this.f30819a);
        CommonRequestParamsForAdd.m22220a(commonRequestParams);
    }
}
