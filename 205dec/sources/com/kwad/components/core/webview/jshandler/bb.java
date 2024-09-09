package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int Yc;

        public a(int i4) {
            this.Yc = i4;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
    }

    public final void ag(boolean z3) {
        if (this.VX == null) {
            com.kwad.sdk.core.e.c.d("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z3 ? 1 : 0));
            return;
        }
        this.VX.a(new a(z3 ? 1 : 0));
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
