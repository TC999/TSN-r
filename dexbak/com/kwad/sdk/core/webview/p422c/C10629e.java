package com.kwad.sdk.core.webview.p422c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.utils.C11126t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10629e implements InterfaceC9914b {
    private final String amz;
    private final int result;

    public C10629e(int i, String str) {
        this.result = i;
        this.amz = str;
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, CommonNetImpl.RESULT, this.result);
        C11126t.putValue(jSONObject, "error_msg", this.amz);
        return jSONObject;
    }
}
