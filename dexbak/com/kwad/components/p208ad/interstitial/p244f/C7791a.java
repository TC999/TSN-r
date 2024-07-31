package com.kwad.components.p208ad.interstitial.p244f;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.core.page.widget.DialogC8867a;
import com.kwad.components.p208ad.interstitial.AlertDialogC7725d;
import com.kwad.components.p208ad.interstitial.p240c.C7724b;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.components.p208ad.interstitial.p245g.View$OnClickListenerC7795b;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.interstitial.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7791a {
    /* renamed from: d */
    public static boolean m32366d(final C7761c c7761c) {
        Activity ownerActivity;
        AlertDialogC7725d alertDialogC7725d = c7761c.f26202io;
        if (alertDialogC7725d != null && (ownerActivity = alertDialogC7725d.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo m25641dQ = C10487e.m25641dQ(c7761c.mAdTemplate);
            int m32560cM = C7724b.m32560cM();
            int m32559cN = C7724b.m32559cN();
            if (m32560cM > C10483a.m25812cn(m25641dQ) && m32559cN < C10483a.m25811co(m25641dQ)) {
                if (C10483a.m25810cp(m25641dQ) == 2) {
                    View$OnClickListenerC7795b.m32365e(c7761c);
                    return true;
                } else if (C10483a.m25810cp(m25641dQ) == 1) {
                    new DialogC8867a(ownerActivity, C10483a.m25809cq(m25641dQ), new DialogC8867a.InterfaceC8872a() { // from class: com.kwad.components.ad.interstitial.f.a.1
                        @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
                        /* renamed from: a */
                        public final void mo29705a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            C9908c.m27313c(C7761c.this.mAdTemplate, (JSONObject) null, new C9913b().m27259cR(8));
                        }

                        @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
                        /* renamed from: b */
                        public final void mo29704b(DialogInterface dialogInterface) {
                            C7761c c7761c2 = C7761c.this;
                            c7761c2.m32457a(false, -1, c7761c2.f26198eN);
                            dialogInterface.dismiss();
                            C9908c.m27306e(C7761c.this.mAdTemplate, (JSONObject) null, new C9913b().m27264cM(151).m27259cR(8));
                            C7761c.this.f26202io.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.DialogC8867a.InterfaceC8872a
                        /* renamed from: c */
                        public final void mo29703c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    C9908c.m27309d(c7761c.mAdTemplate, new JSONObject(), new C9913b().m27264cM(149).m27259cR(8));
                    return true;
                }
            }
        }
        return false;
    }
}
