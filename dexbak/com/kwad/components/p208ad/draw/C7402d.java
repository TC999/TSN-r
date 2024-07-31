package com.kwad.components.p208ad.draw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.p330s.C8950m;
import com.kwad.components.core.request.C8915d;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.p208ad.KsAdLoadManager;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;

/* renamed from: com.kwad.components.ad.draw.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7402d {
    public static void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean m29540a = C8950m.m29533re().m29540a(covert, "loadDrawAd");
        covert.setAdStyle(6);
        KsAdLoadManager.m33469M();
        KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(new ImpInfo(covert)).m29586aJ(m29540a).m29589a(new C8915d() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
            /* renamed from: a */
            public final void mo29595a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(C10483a.m25977K(C10487e.m25641dQ(adTemplate)))) {
                        arrayList.add(new C7396c(adTemplate));
                    }
                }
                if (arrayList.isEmpty()) {
                    onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg + "(无视频资源)" : adResultData.testErrorMsg);
                    return;
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.draw.d.1.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        KsAdLoadManager.m33469M().m33466b(arrayList);
                        KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
            public final void onError(final int i, final String str) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26254d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.DrawAdListener.this.onError(i, str);
                    }
                });
            }
        }).m29584qy());
    }
}
