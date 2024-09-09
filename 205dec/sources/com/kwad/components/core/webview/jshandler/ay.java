package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ay implements com.kwad.sdk.core.webview.c.a {
    private final a XW;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        @MainThread
        void bB();
    }

    public ay(a aVar) {
        this.XW = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.ay.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (ay.this.XW != null) {
                    ay.this.XW.bB();
                }
                cVar.a(null);
            }
        });
    }
}
