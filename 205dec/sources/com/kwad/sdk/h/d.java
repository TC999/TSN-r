package com.kwad.sdk.h;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class d implements b {
    public List<e> aKh;
    public long intervalTime;

    public final long JG() {
        long j4 = this.intervalTime;
        if (j4 > 0) {
            return j4;
        }
        return 5000L;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.aKh = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("configList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                e eVar = new e();
                eVar.parseJson(optJSONArray.optJSONObject(i4));
                this.aKh.add(eVar);
            }
        }
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        return null;
    }
}
