package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.e.d.c Kz;
    private KsAppDownloadListener VG;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.c.c ns;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String We;
        public String packageName;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public k(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    private synchronized void o(String str, String str2) {
        this.Kz = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.VG == null) {
            KsAppDownloadListener sm = sm();
            this.VG = sm;
            this.Kz.b(sm);
        }
    }

    private static boolean p(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener sm() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.k.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                k.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                k.this.p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                k.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                k.this.p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i4) {
                k.this.p(4, i4);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                if (i4 == 0) {
                    k.this.p(1, 0);
                } else {
                    k.this.p(2, i4);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ns = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i4, int i5) {
        if (this.ns != null) {
            b bVar = new b();
            bVar.status = i4;
            bVar.progress = i5;
            this.ns.a(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ns = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (p(aVar.We, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.Kz == null) {
                o(aVar.We, aVar.packageName);
            }
            a.C0631a ar = new a.C0631a(this.mContext).ao(true).ap(false).aq(this.mAdTemplate).ar(false);
            if (this.Kz.s(ar)) {
                return;
            }
            this.Kz.d(this.VG);
            this.Kz.r(ar);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }
}
