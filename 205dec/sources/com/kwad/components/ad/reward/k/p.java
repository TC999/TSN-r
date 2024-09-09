package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class p extends ak {
    private WeakReference<com.kwad.components.ad.reward.g> qh;
    private long xm;
    private String xn;

    public p(com.kwad.components.ad.reward.g gVar, String str, long j4, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.xn = str;
        this.xm = j4;
        if (gVar != null) {
            this.qh = new WeakReference<>(gVar);
        }
    }

    private static boolean Q(String str) {
        try {
            return new JSONObject(str).optInt("elementType") == 18;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void b(boolean z3, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.ad.reward.j.b.a(z3, adTemplate, null, bVar);
    }

    private boolean b(ak.b bVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (bVar.getActionType() == 140 && com.kwad.sdk.core.config.d.yT() && Q(bVar.sp()) && (weakReference = this.qh) != null && weakReference.get() != null) {
            final com.kwad.components.ad.reward.g gVar = this.qh.get();
            bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.ad.reward.k.p.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    gVar.x(p.this.xn);
                }
            }, 1500L);
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void a(@NonNull ak.b bVar) {
        if (b(bVar)) {
            return;
        }
        super.a(bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.ak
    public final void a(com.kwad.sdk.core.adlog.c.b bVar) {
        super.a(bVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.qh;
        if (weakReference != null && weakReference.get() != null) {
            bVar.ah(this.qh.get().oJ.getPlayDuration());
            return;
        }
        long j4 = this.xm;
        if (j4 > 0) {
            bVar.ah(j4);
        }
    }
}
