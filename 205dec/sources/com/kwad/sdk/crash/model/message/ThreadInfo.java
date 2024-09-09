package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ThreadInfo implements b, Serializable {
    private static final long serialVersionUID = -1743841938230203418L;
    public int mIndex;
    public String mName;
    public int mTid;
    public String mTrace;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mName = jSONObject.optString("mName");
        this.mTrace = jSONObject.optString("mTrace");
        this.mTid = jSONObject.optInt("mTid");
        this.mIndex = jSONObject.optInt("mIndex");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mName", this.mName);
        t.putValue(jSONObject, "mTrace", this.mTrace);
        t.putValue(jSONObject, "mTid", this.mTid);
        t.putValue(jSONObject, "mIndex", this.mIndex);
        return jSONObject;
    }
}