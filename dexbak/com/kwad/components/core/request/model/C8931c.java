package com.kwad.components.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.request.model.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8931c implements InterfaceC9914b {

    /* renamed from: Sd */
    public long f28843Sd;
    public long photoId;

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "photoId", this.photoId);
        C11126t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.f28843Sd);
        return jSONObject;
    }
}
