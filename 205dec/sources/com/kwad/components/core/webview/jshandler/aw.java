package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class aw extends com.kwad.components.core.webview.tachikoma.a.w {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a implements com.kwad.sdk.core.b {
        private String XS;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "lifeStatus", this.XS);
            return jSONObject;
        }
    }

    private void aM(String str) {
        a aVar = new a();
        aVar.XS = str;
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void sr() {
        aM("showStart");
    }

    public final void ss() {
        aM("showEnd");
    }

    public final void st() {
        aM("hideStart");
    }

    public final void su() {
        aM("hideEnd");
    }

    public final void sv() {
        aM("pageVisiable");
    }

    public final void sw() {
        aM("pageInvisiable");
    }
}
