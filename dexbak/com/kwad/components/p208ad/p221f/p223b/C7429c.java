package com.kwad.components.p208ad.p221f.p223b;

import android.view.View;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.f.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7429c extends C7416a {

    /* renamed from: cB */
    private List<Integer> f25439cB;

    /* renamed from: cC */
    private volatile boolean f25440cC = false;

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f25439cB = C10483a.m25867bm(C10487e.m25641dQ(this.f25416mN.mAdTemplate));
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.c.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                C9908c.m27323bL(C7429c.this.f25416mN.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j, long j2) {
                C7429c.this.m33286c(j2);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                C7429c.this.f25440cC = false;
                if (!C7429c.this.f25416mN.mAdTemplate.mPvReported) {
                    C7429c.this.f25416mN.f25420mw.mo33199er();
                }
                C9913b c9913b = new C9913b();
                View view = (View) C7429c.this.f25416mN.f25417mI.getParent();
                if (view != null) {
                    c9913b.m27245v(view.getHeight(), view.getWidth());
                }
                C8934b.m29570qY().m29571a(C7429c.this.f25416mN.mAdTemplate, null, c9913b);
                C9908c.m27324bK(C7429c.this.f25416mN.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                if (C7429c.this.f25440cC) {
                    return;
                }
                C7429c.this.f25440cC = true;
                C8766a.m29888qi().m29902b(C7429c.this.f25416mN.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33286c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f25439cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f25439cB) {
            if (ceil >= num.intValue()) {
                C9908c.m27348a(this.f25416mN.mAdTemplate, ceil, (JSONObject) null);
                this.f25439cB.remove(num);
                return;
            }
        }
    }
}
