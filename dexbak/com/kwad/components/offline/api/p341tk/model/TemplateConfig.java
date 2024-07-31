package com.kwad.components.offline.api.p341tk.model;

import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.offline.api.tk.model.TemplateConfig */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TemplateConfig extends BaseOfflineCompoJsonParse<TemplateConfig> {
    public String bundleFile;
    public String bundleId;
    public String md5;
    public String sha256;
    public String version;
    public String versionCode;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.bundleId = jSONObject.optString("bundleId");
        templateConfig.bundleFile = jSONObject.optString("bundleFile");
        templateConfig.version = jSONObject.optString(ConstantHelper.LOG_VS);
        templateConfig.md5 = jSONObject.optString("md5");
        templateConfig.sha256 = jSONObject.optString("sha256");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(templateConfig.bundleId)) {
            C11126t.putValue(jSONObject, "bundleId", templateConfig.bundleId);
        }
        if (!TextUtils.isEmpty(templateConfig.bundleFile)) {
            C11126t.putValue(jSONObject, "bundleFile", templateConfig.bundleFile);
        }
        if (!TextUtils.isEmpty(templateConfig.version)) {
            C11126t.putValue(jSONObject, ConstantHelper.LOG_VS, templateConfig.version);
        }
        if (!TextUtils.isEmpty(templateConfig.md5)) {
            C11126t.putValue(jSONObject, "md5", templateConfig.md5);
        }
        if (!TextUtils.isEmpty(templateConfig.sha256)) {
            C11126t.putValue(jSONObject, "sha256", templateConfig.sha256);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig) {
        return toJson(templateConfig, (JSONObject) null);
    }
}
