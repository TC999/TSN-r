package com.kwad.sdk.core.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class EntryPackage extends URLPackage {
    private static final long serialVersionUID = 8251709184937662571L;
    public String entryId;
    public String entryPageSource;

    public EntryPackage() {
        this.entryPageSource = "unknown";
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.entryPageSource = jSONObject.optString("entryPageSource");
        this.entryId = jSONObject.optString("entryId");
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        C11126t.putValue(json, "entryPageSource", this.entryPageSource);
        C11126t.putValue(json, "entryId", this.entryId);
        return json;
    }

    public EntryPackage(@NonNull String str, int i) {
        super(str, i);
        this.entryPageSource = "unknown";
    }
}
