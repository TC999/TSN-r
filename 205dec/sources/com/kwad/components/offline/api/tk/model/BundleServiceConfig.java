package com.kwad.components.offline.api.tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
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
            t.putValue(jSONObject, "bundleName", bundleServiceConfig.bundleName);
        }
        int i4 = bundleServiceConfig.loadType;
        if (i4 != -1) {
            t.putValue(jSONObject, "loadType", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BundleServiceConfig bundleServiceConfig) {
        return toJson(bundleServiceConfig, (JSONObject) null);
    }
}
