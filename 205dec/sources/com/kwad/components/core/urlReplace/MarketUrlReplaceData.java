package com.kwad.components.core.urlReplace;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MarketUrlReplaceData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 4953795264697162439L;
    private urlInfo data;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class urlInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 201762827228761165L;
        public String miMarketUrl;
        public boolean replaceSuccess;

        private urlInfo() {
        }
    }

    public String getMiMarketUrl() {
        urlInfo urlinfo = this.data;
        return urlinfo == null ? "" : urlinfo.miMarketUrl;
    }

    public boolean isParseSuccess() {
        urlInfo urlinfo = this.data;
        return (urlinfo == null || urlinfo.miMarketUrl.equals("")) ? false : true;
    }

    public boolean isReplaceSuccess() {
        urlInfo urlinfo = this.data;
        if (urlinfo == null) {
            return false;
        }
        return urlinfo.replaceSuccess;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("data");
            e eVar = (e) com.kwad.sdk.components.c.f(e.class);
            if (bh.isNullString(optString) || eVar == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(eVar.getResponseData(optString));
            urlInfo urlinfo = new urlInfo();
            this.data = urlinfo;
            urlinfo.miMarketUrl = jSONObject2.optString("miMarketUrl");
            this.data.replaceSuccess = jSONObject2.optBoolean("replaceSuccess");
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.d("json bug", e4.toString());
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }
}
