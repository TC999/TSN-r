package com.kwad.components.offline.api.p341tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.kwad.components.offline.api.tk.model.BundleServiceConfig */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BundleServiceConfig extends BaseOfflineCompoJsonParse<BundleServiceConfig> implements Serializable {
    public String bundleName;
    public int loadType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(BundleServiceConfig bundleServiceConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bundleServiceConfig.bundleName = jSONObject.optString("bundleName");
        if (jSONObject.opt("bundleName") == JSONObject.NULL) {
            bundleServiceConfig.bundleName = "";
        }
        bundleServiceConfig.loadType = jSONObject.optInt("loadType");
        if (jSONObject.opt("loadType") == JSONObject.NULL) {
            bundleServiceConfig.loadType = -1;
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BundleServiceConfig bundleServiceConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bundleServiceConfig.bundleName;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "bundleName", bundleServiceConfig.bundleName);
        }
        int i = bundleServiceConfig.loadType;
        if (i != -1) {
            C11126t.putValue(jSONObject, "loadType", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BundleServiceConfig bundleServiceConfig) {
        return toJson(bundleServiceConfig, (JSONObject) null);
    }
}
