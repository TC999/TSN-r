package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {
    private a Yg;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void sh();
    }

    public bd(a aVar) {
        this.Yg = aVar;
    }

    private void sx() {
        if (com.kwad.components.core.e.c.b.nr()) {
            return;
        }
        bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.bd.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (bd.this.Yg != null) {
                    bd.this.Yg.sh();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        sx();
    }
}
