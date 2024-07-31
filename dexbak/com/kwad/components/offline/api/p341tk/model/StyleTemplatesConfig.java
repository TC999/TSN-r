package com.kwad.components.offline.api.p341tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.components.offline.api.tk.model.StyleTemplatesConfig */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class StyleTemplatesConfig extends BaseOfflineCompoJsonParse<StyleTemplatesConfig> implements Serializable {
    private static final long serialVersionUID = -6279192768068169498L;
    public List<StyleTemplate> styleTemplates = new ArrayList();

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styleTemplatesConfig.styleTemplates = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("styleTemplates");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(optJSONArray.optJSONObject(i));
                styleTemplatesConfig.styleTemplates.add(styleTemplate);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "styleTemplates", styleTemplatesConfig.styleTemplates);
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(StyleTemplatesConfig styleTemplatesConfig) {
        return toJson(styleTemplatesConfig, (JSONObject) null);
    }
}
