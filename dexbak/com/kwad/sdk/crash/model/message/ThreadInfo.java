package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ThreadInfo implements InterfaceC9914b, Serializable {
    private static final long serialVersionUID = -1743841938230203418L;
    public int mIndex;
    public String mName;
    public int mTid;
    public String mTrace;

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mName = jSONObject.optString("mName");
        this.mTrace = jSONObject.optString("mTrace");
        this.mTid = jSONObject.optInt("mTid");
        this.mIndex = jSONObject.optInt("mIndex");
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "mName", this.mName);
        C11126t.putValue(jSONObject, "mTrace", this.mTrace);
        C11126t.putValue(jSONObject, "mTid", this.mTid);
        C11126t.putValue(jSONObject, "mIndex", this.mIndex);
        return jSONObject;
    }
}
