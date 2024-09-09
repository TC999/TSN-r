package com.kwad.components.ad.interstitial.f;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static boolean d(final c cVar) {
        Activity ownerActivity;
        d dVar = cVar.f38639io;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo dQ = e.dQ(cVar.mAdTemplate);
            int cM = com.kwad.components.ad.interstitial.c.b.cM();
            int cN = com.kwad.components.ad.interstitial.c.b.cN();
            if (cM > com.kwad.sdk.core.response.b.a.cn(dQ) && cN < com.kwad.sdk.core.response.b.a.co(dQ)) {
                if (com.kwad.sdk.core.response.b.a.cp(dQ) == 2) {
                    com.kwad.components.ad.interstitial.g.b.e(cVar);
                    return true;
                } else if (com.kwad.sdk.core.response.b.a.cp(dQ) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.cq(dQ), new a.InterfaceC0646a() { // from class: com.kwad.components.ad.interstitial.f.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.c(c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cR(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = c.this;
                            cVar2.a(false, -1, cVar2.eN);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.e(c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(151).cR(8));
                            c.this.f38639io.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0646a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().cM(149).cR(8));
                    return true;
                }
            }
        }
        return false;
    }
}
