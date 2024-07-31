package com.kwad.sdk.core.webview.p422c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.utils.C11126t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.c.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10630f implements InterfaceC9914b {
    public final InterfaceC9914b aEE;
    public final int result = 1;

    public C10630f(InterfaceC9914b interfaceC9914b) {
        this.aEE = interfaceC9914b;
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, CommonNetImpl.RESULT, this.result);
        C11126t.m23678a(jSONObject, "data", this.aEE);
        return jSONObject;
    }
}
