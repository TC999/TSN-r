package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11126t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11161b;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WebViewCommercialMsg extends C10482a implements InterfaceC9914b, Serializable {
    private static final long serialVersionUID = -1007322423487775751L;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject extraParam;
    public JSONObject msg;
    public String primaryKey;
    public double rate;
    public SubBusinessType subBiz;
    public String suffixRatio;
    public String tag;
    public C11161b type;

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("sub_biz")) {
            try {
                this.subBiz = SubBusinessType.valueOf(jSONObject.optString("sub_biz"));
            } catch (Exception unused) {
                this.subBiz = SubBusinessType.OTHER;
            }
        }
        if (jSONObject.has("biz")) {
            try {
                this.biz = BusinessType.valueOf(jSONObject.optString("biz"));
            } catch (Exception unused2) {
                this.biz = BusinessType.OTHER;
            }
        }
        if (jSONObject.has("type")) {
            try {
                this.type = new C11161b(jSONObject.optString("type"));
            } catch (Exception unused3) {
                this.type = new C11161b("OTHER");
            }
        }
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        C11126t.putValue(jSONObject, "biz", this.biz.value);
        C11126t.putValue(jSONObject, "subBiz", this.subBiz.value);
        C11126t.putValue(jSONObject, "type", this.type.getValue());
    }
}
