package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.InterfaceC10229c;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.config.C10249b;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.p434g.AbstractC10762b;
import com.kwad.sdk.p435h.p436a.C10771a;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SdkConfigData extends BaseResultData implements InterfaceC9914b, Serializable {
    public static final int DEFAULT_CAN_USE_THRESHOLD = 300;
    public static final int DEFAULT_GOOD_IDC_THRESHOLD = 200;
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    private static final long serialVersionUID = -7796837168148055391L;
    private JSONObject abConfig;
    private JSONObject adxConfig;
    private JSONObject appConfig;
    private JSONObject mDataJsonObj;
    public long requestInterval = 3600;
    public List<C10771a> h5PreloadConfigs = new ArrayList();
    public TemplateConfig templateConfig = new TemplateConfig();
    public TemplateConfigMap templateConfigMap = new TemplateConfigMap();
    public CouponActiveConfig couponActiveConfig = new CouponActiveConfig();
    public HttpDnsInfo httpDnsInfo = new HttpDnsInfo();
    public int goodIdcThresholdMs = 200;
    public int canUseThresholdMs = 300;

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class CouponActiveConfig extends C10482a implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = 6375241669684789095L;
        public ActivityInfo activityInfo;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public int popUpShowTimeSeconds;
        public int videoSeconds;
        public int videoThreshold;
        public String title = "抽红包兑奖";
        public String secondTitle = "累计到100元可兑换京东卡";
        public String bottomTitle = "刷满5个视频抽红包，每个视频观看>5秒";
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class TemplateConfigMap extends C10482a implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = -6512236636350788192L;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
    }

    public <T> T getAppConfigData(T t, AbstractC10762b<JSONObject, T> abstractC10762b) {
        JSONObject jSONObject = this.appConfig;
        return jSONObject != null ? abstractC10762b.apply(jSONObject) : t;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(C9889d.getResponseData(jSONObject.optString("data")));
            this.mDataJsonObj = jSONObject2;
            this.requestInterval = jSONObject2.optLong("requestInterval");
            this.goodIdcThresholdMs = this.mDataJsonObj.optInt("goodIdcThresholdMs", 200);
            this.canUseThresholdMs = this.mDataJsonObj.optInt("canUseThresholdMs", 300);
            C10249b.m26594j(this.mDataJsonObj);
            JSONObject optJSONObject = this.mDataJsonObj.optJSONObject("abConfig");
            this.abConfig = optJSONObject;
            C10249b.m26594j(optJSONObject);
            JSONObject optJSONObject2 = this.mDataJsonObj.optJSONObject("adxConfig");
            this.adxConfig = optJSONObject2;
            C10249b.m26594j(optJSONObject2);
            this.appConfig = this.mDataJsonObj.optJSONObject("appConfig");
            this.h5PreloadConfigs = C11126t.m23680a(this.mDataJsonObj.optString("h5PreloadConfigs"), new InterfaceC10229c<C10771a>() { // from class: com.kwad.sdk.core.response.model.SdkConfigData.1
                /* renamed from: Fp */
                private static C10771a m25609Fp() {
                    return new C10771a();
                }

                @Override // com.kwad.sdk.core.InterfaceC10229c
                /* renamed from: AW */
                public final /* synthetic */ C10771a mo23794AW() {
                    return m25609Fp();
                }
            });
            C10249b.m26594j(this.appConfig);
            this.templateConfig.parseJson(this.mDataJsonObj.optJSONObject("templateConfig"));
            this.templateConfigMap.parseJson(this.mDataJsonObj.optJSONObject("templateConfigMap"));
            this.couponActiveConfig.parseJson(this.mDataJsonObj.optJSONObject("couponActiveConfig"));
            this.httpDnsInfo.parseJson(this.mDataJsonObj.optJSONObject("httpDnsInfo"));
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = this.mDataJsonObj;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
