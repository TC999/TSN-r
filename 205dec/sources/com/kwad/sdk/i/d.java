package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements b {
    public List<e> aIS;
    public long intervalTime;

    public final long IV() {
        long j4 = this.intervalTime;
        if (j4 > 0) {
            return j4;
        }
        return 5000L;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.aIS = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("configList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                e eVar = new e();
                eVar.parseJson(optJSONArray.optJSONObject(i4));
                this.aIS.add(eVar);
            }
        }
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
