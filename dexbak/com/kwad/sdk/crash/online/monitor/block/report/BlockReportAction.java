package com.kwad.sdk.crash.online.monitor.block.report;

import com.kwad.sdk.core.report.AbstractC10453e;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BlockReportAction extends AbstractC10453e implements Serializable {
    private static final long serialVersionUID = 8432448382850235426L;
    public String msg;

    public BlockReportAction(String str) {
        this.actionId = UUID.randomUUID().toString();
        this.msg = str;
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.actionId = jSONObject.optString("actionId");
        this.msg = jSONObject.optString("msg");
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "actionId", this.actionId);
        C11126t.putValue(jSONObject, "msg", this.msg);
        return jSONObject;
    }

    public BlockReportAction(JSONObject jSONObject) {
        parseJson(jSONObject);
    }
}
