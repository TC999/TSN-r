package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class aq implements com.kwad.sdk.core.webview.c.a {
    private Handler WA = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c WB;
    private b cU;
    private String mUrl;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Deprecated
    public aq(b bVar) {
        this.cU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cU;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cU = null;
        this.WB = null;
        this.WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WB = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.aq.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    aq.this.b(aVar);
                    if (aq.this.WB != null) {
                        aq.this.WB.a(null);
                    }
                }
            });
        } catch (JSONException e4) {
            com.kwad.sdk.core.e.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e4);
            com.kwad.sdk.core.webview.b.c.b.ag(this.mUrl, e4.getMessage());
            cVar.onError(-1, e4.getMessage());
        }
    }

    public aq(b bVar, String str) {
        this.cU = bVar;
        this.mUrl = str;
    }
}
