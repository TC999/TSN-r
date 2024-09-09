package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    public ap(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.a.c cVar2 = new com.kwad.components.core.webview.a.c();
        if (this.mContext == null) {
            com.kwad.sdk.core.adlog.c.j(this.mAdTemplate, 2);
            cVar.onError(-1, "context\u4e3a\u7a7a");
            return;
        }
        AdTemplate adTemplate = null;
        try {
            cVar2.parseJson(new JSONObject(str));
            AdTemplate adTemplate2 = this.mAdTemplate;
            try {
                int i4 = cVar2.VN;
                if (i4 > 0) {
                    adTemplate2 = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(i4), cVar2.Jj);
                }
                if (adTemplate2 == null) {
                    com.kwad.sdk.core.adlog.c.j(this.mAdTemplate, 2);
                    cVar.onError(-1, "adTemplate\u4e3a\u7a7a\uff1a" + cVar2.VN);
                    return;
                }
                AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate2);
                if (!com.kwad.sdk.core.response.b.a.S(dQ) && com.kwad.components.core.e.d.e.a(this.mContext, dQ.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, cVar2.VL, cVar2.VM, adTemplate2) == 1) {
                    cVar.a(null);
                } else {
                    cVar.onError(-1, "\u8df3\u8f6c\u5931\u8d25");
                }
            } catch (Exception e4) {
                e = e4;
                adTemplate = adTemplate2;
                com.kwad.sdk.core.adlog.c.j(adTemplate, 2);
                cVar.onError(-1, "\u89e3\u6790\u5931\u8d25");
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
