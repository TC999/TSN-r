package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.utils.bo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction adh;

    /* renamed from: com.kwad.components.offline.c.a.a$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.b adU;

        AnonymousClass1(com.kwad.sdk.core.b bVar) {
            this.adU = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final String jSONObject = new com.kwad.sdk.core.webview.c.f(this.adU).toJson().toString();
            bo.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.c.a.a.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.a(a.this) != null) {
                        a.a(a.this).onSuccess(jSONObject);
                    }
                }
            });
        }
    }

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.adh = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void a(com.kwad.sdk.core.b bVar) {
        String jSONObject = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adh;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i4, String str) {
        String jSONObject = new com.kwad.sdk.core.webview.c.e(i4, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adh;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }
}
