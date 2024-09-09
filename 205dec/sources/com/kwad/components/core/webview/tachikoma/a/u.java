package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class u implements com.kwad.sdk.core.webview.c.a {
    private a ZR;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(b bVar);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int errorCode;
        public String errorMsg;
        public int status;
    }

    public final void a(a aVar) {
        this.ZR = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "splashShowStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ZR = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ZR != null) {
            b bVar = new b();
            try {
                try {
                    bVar.parseJson(new JSONObject(str));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.ZR.a(bVar);
            }
        }
    }
}
