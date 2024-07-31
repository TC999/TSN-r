package com.kwad.sdk.p437i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.i.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10790d implements InterfaceC10788b {
    public List<C10791e> aIS;
    public long intervalTime;

    /* renamed from: IV */
    public final long m24865IV() {
        long j = this.intervalTime;
        if (j > 0) {
            return j;
        }
        return 5000L;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.aIS = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("configList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C10791e c10791e = new C10791e();
                c10791e.parseJson(optJSONArray.optJSONObject(i));
                this.aIS.add(c10791e);
            }
        }
    }

    @Override // com.kwad.sdk.p437i.InterfaceC10788b
    public final JSONObject toJson() {
        return null;
    }
}
