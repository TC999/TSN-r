package com.kwad.components.ad.draw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a4 = m.re().a(covert, "loadDrawAd");
        covert.setAdStyle(6);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0649a().e(new ImpInfo(covert)).aJ(a4).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate)))) {
                        arrayList.add(new c(adTemplate));
                    }
                }
                if (arrayList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg + "(\u65e0\u89c6\u9891\u8d44\u6e90)" : adResultData.testErrorMsg);
                    return;
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.draw.d.1.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i4, final String str) {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        KsLoadManager.DrawAdListener.this.onError(i4, str);
                    }
                });
            }
        }).qy());
    }
}
