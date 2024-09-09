package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private a aab;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    public y(a aVar) {
        this.aab = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            com.kwad.sdk.core.e.c.d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            final TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.y.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (y.this.aab != null) {
                        y.this.aab.a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }
}
