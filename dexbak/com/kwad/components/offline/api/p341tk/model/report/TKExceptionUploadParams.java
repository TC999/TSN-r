package com.kwad.components.offline.api.p341tk.model.report;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TKExceptionUploadParams extends BaseOfflineCompoJsonParse<TKExceptionUploadParams> {
    public String bizExtraInfo;
    public String bundleId;
    public String bundleSource;
    public String bundleType;
    public String bundleVersionCode;
    public String businessName;
    public long clientTimeStamp;
    public int containerType;
    public String error;
    public String errorType;
    public String key;
    public String sdkVersion;
    public String sessionId;
    public String taskId;
    public String templateId;
    public String templateVersionCode;
    public int v8SoType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKExceptionUploadParams tKExceptionUploadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.key = jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY);
        if (JSONObject.NULL.toString().equals(this.key)) {
            this.key = "";
        }
        this.error = jSONObject.optString("error");
        if (JSONObject.NULL.toString().equals(this.error)) {
            this.error = "";
        }
        this.v8SoType = jSONObject.optInt("v8SoType");
        this.bundleType = jSONObject.optString("bundleType");
        if (JSONObject.NULL.toString().equals(this.bundleType)) {
            this.bundleType = "";
        }
        this.bundleSource = jSONObject.optString("bundleSource");
        if (JSONObject.NULL.toString().equals(this.bundleSource)) {
            this.bundleSource = "";
        }
        this.bundleId = jSONObject.optString("bundleId");
        if (JSONObject.NULL.toString().equals(this.bundleId)) {
            this.bundleId = "";
        }
        this.bundleVersionCode = jSONObject.optString("bundleVersionCode");
        if (JSONObject.NULL.toString().equals(this.bundleVersionCode)) {
            this.bundleVersionCode = "";
        }
        this.businessName = jSONObject.optString("businessName");
        if (JSONObject.NULL.toString().equals(this.businessName)) {
            this.businessName = "";
        }
        this.taskId = jSONObject.optString("taskId");
        if (JSONObject.NULL.toString().equals(this.taskId)) {
            this.taskId = "";
        }
        this.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(this.templateId)) {
            this.templateId = "";
        }
        this.templateVersionCode = jSONObject.optString("templateVersionCode");
        if (JSONObject.NULL.toString().equals(this.templateVersionCode)) {
            this.templateVersionCode = "";
        }
        this.sdkVersion = jSONObject.optString("sdkVersion");
        if (JSONObject.NULL.toString().equals(this.sdkVersion)) {
            this.sdkVersion = "";
        }
        this.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(this.sessionId)) {
            this.sessionId = "";
        }
        this.bizExtraInfo = jSONObject.optString("biz_extra_info");
        if (JSONObject.NULL.toString().equals(this.bizExtraInfo)) {
            this.bizExtraInfo = "";
        }
        this.errorType = jSONObject.optString("errorType");
        if (JSONObject.NULL.toString().equals(this.errorType)) {
            this.errorType = "";
        }
        this.containerType = jSONObject.optInt("container_type");
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKExceptionUploadParams tKExceptionUploadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = this.error;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "error", this.error);
        }
        int i = this.v8SoType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "v8SoType", i);
        }
        String str2 = this.bundleType;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "bundleType", this.bundleType);
        }
        String str3 = this.bundleSource;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "bundleSource", this.bundleSource);
        }
        String str4 = this.bundleId;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "bundleId", this.bundleId);
        }
        String str5 = this.bundleVersionCode;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "bundleVersionCode", this.bundleVersionCode);
        }
        String str6 = this.businessName;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "businessName", this.businessName);
        }
        String str7 = this.taskId;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "taskId", this.taskId);
        }
        String str8 = this.templateId;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "templateId", this.templateId);
        }
        String str9 = this.templateVersionCode;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "templateVersionCode", this.templateVersionCode);
        }
        String str10 = this.sdkVersion;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "sdkVersion", this.sdkVersion);
        }
        String str11 = this.sessionId;
        if (str11 != null && !str11.equals("")) {
            C11126t.putValue(jSONObject, "sessionId", this.sessionId);
        }
        String str12 = this.bizExtraInfo;
        if (str12 != null && !str12.equals("")) {
            C11126t.putValue(jSONObject, "biz_extra_info", this.bizExtraInfo);
        }
        String str13 = this.errorType;
        if (str13 != null && !str13.equals("")) {
            C11126t.putValue(jSONObject, "errorType", this.errorType);
        }
        int i2 = this.containerType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "container_type", i2);
        }
        long j = this.clientTimeStamp;
        if (j != 0) {
            C11126t.putValue(jSONObject, "clientTimeStamp", j);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKExceptionUploadParams tKExceptionUploadParams) {
        return toJson(tKExceptionUploadParams, (JSONObject) null);
    }
}
