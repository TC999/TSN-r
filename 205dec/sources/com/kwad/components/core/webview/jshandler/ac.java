package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    protected b WK;
    protected final com.kwad.sdk.core.webview.b Wf;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void c(a aVar);
    }

    public ac(com.kwad.sdk.core.webview.b bVar) {
        this.Wf = bVar;
    }

    public final void a(b bVar) {
        this.WK = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        b bVar = this.WK;
        if (bVar != null) {
            bVar.c(aVar);
        } else {
            aVar.width = this.Wf.OE.getWidth();
            aVar.height = this.Wf.OE.getHeight();
        }
        cVar.a(aVar);
    }
}
