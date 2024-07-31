package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.co */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9984co implements InterfaceC10273d<SdkConfigData.CouponActiveConfig> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        m27114a(couponActiveConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        return m27113b(couponActiveConfig, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27114a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponActiveConfig.popUpShowTimeSeconds = jSONObject.optInt("popUpShowTimeSeconds");
        couponActiveConfig.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(couponActiveConfig.title)) {
            couponActiveConfig.title = "";
        }
        couponActiveConfig.secondTitle = jSONObject.optString("secondTitle");
        if (JSONObject.NULL.toString().equals(couponActiveConfig.secondTitle)) {
            couponActiveConfig.secondTitle = "";
        }
        couponActiveConfig.bottomTitle = jSONObject.optString("bottomTitle");
        if (JSONObject.NULL.toString().equals(couponActiveConfig.bottomTitle)) {
            couponActiveConfig.bottomTitle = "";
        }
        couponActiveConfig.videoThreshold = jSONObject.optInt("videoThreshold");
        couponActiveConfig.videoSeconds = jSONObject.optInt("videoSeconds");
        TemplateConfig templateConfig = new TemplateConfig();
        couponActiveConfig.couponOpenConfig = templateConfig;
        templateConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        TemplateConfig templateConfig2 = new TemplateConfig();
        couponActiveConfig.couponInfoConfig = templateConfig2;
        templateConfig2.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        ActivityInfo activityInfo = new ActivityInfo();
        couponActiveConfig.activityInfo = activityInfo;
        activityInfo.parseJson(jSONObject.optJSONObject("activityInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27113b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = couponActiveConfig.popUpShowTimeSeconds;
        if (i != 0) {
            C11126t.putValue(jSONObject, "popUpShowTimeSeconds", i);
        }
        String str = couponActiveConfig.title;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "title", couponActiveConfig.title);
        }
        String str2 = couponActiveConfig.secondTitle;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "secondTitle", couponActiveConfig.secondTitle);
        }
        String str3 = couponActiveConfig.bottomTitle;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "bottomTitle", couponActiveConfig.bottomTitle);
        }
        int i2 = couponActiveConfig.videoThreshold;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "videoThreshold", i2);
        }
        int i3 = couponActiveConfig.videoSeconds;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "videoSeconds", i3);
        }
        C11126t.m23678a(jSONObject, "couponOpenConfig", couponActiveConfig.couponOpenConfig);
        C11126t.m23678a(jSONObject, "couponInfoConfig", couponActiveConfig.couponInfoConfig);
        C11126t.m23678a(jSONObject, "activityInfo", couponActiveConfig.activityInfo);
        return jSONObject;
    }
}
