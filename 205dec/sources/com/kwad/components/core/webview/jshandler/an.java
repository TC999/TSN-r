package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class an implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b cO;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String XB;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {

        /* renamed from: XI  reason: collision with root package name */
        public double f38649XI;
        public int status;
        public long totalBytes;
    }

    private KsAppDownloadListener aL(String str) {
        return new com.kwad.sdk.core.download.a.a(str) { // from class: com.kwad.components.core.webview.jshandler.an.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (an.this.cO.aDK != null) {
                    an.this.a(1, 0.0f, an.this.cO.aDK.gB(nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (an.this.cO.aDK != null) {
                    an.this.a(5, 1.0f, an.this.cO.aDK.gB(nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (an.this.cO.aDK != null) {
                    an.this.a(1, 0.0f, an.this.cO.aDK.gB(nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (an.this.cO.aDK != null) {
                    an.this.a(6, 1.0f, an.this.cO.aDK.gB(nX()));
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i4) {
                if (an.this.cO.aDK != null) {
                    an.this.a(3, (i4 * 1.0f) / 100.0f, an.this.cO.aDK.gB(nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                if (an.this.cO.aDK != null) {
                    an.this.a(2, (i4 * 1.0f) / 100.0f, an.this.cO.aDK.gB(nX()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.af afVar = this.cO.aDK;
        if (afVar != null) {
            afVar.release();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.XB));
        } catch (Exception e4) {
            adTemplate = null;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.b.e.dI(adTemplate) || this.cO.aDK == null) {
            return;
        }
        com.kwad.components.core.e.d.c cVar2 = new com.kwad.components.core.e.d.c(adTemplate);
        String nX = cVar2.nX();
        cVar2.b(aL(nX));
        this.cO.aDK.a(nX, cVar2);
        this.cO.aDK.b(nX, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, float f4, com.kwad.sdk.core.webview.c.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.f38649XI = f4;
            bVar.status = i4;
            bVar.totalBytes = com.kwad.sdk.core.response.b.e.dQ(this.cO.getAdTemplate()).totalBytes;
            cVar.a(bVar);
        }
    }
}
