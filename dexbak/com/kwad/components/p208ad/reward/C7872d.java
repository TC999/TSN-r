package com.kwad.components.p208ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9182w;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7872d extends C7824b {

    /* renamed from: oA */
    private List<AdTemplate> f26491oA;

    /* renamed from: oB */
    private boolean f26492oB;

    /* renamed from: oC */
    private List<C8619c> f26493oC;

    /* renamed from: oD */
    private C9182w.InterfaceC9184b f26494oD;

    public C7872d(List<AdTemplate> list, @Nullable JSONObject jSONObject, C9182w.InterfaceC9184b interfaceC9184b) {
        super(jSONObject, null);
        this.f26492oB = false;
        this.f26493oC = new ArrayList();
        this.f26491oA = list;
        this.f26494oD = interfaceC9184b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AdTemplate adTemplate : this.f26491oA) {
            this.f26493oC.add(new C8619c(adTemplate));
        }
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: B */
    public final String mo32120B(AdTemplate adTemplate) {
        List<AdTemplate> list = this.f26491oA;
        if (list != null && list.size() >= 2) {
            return C10484b.m25753co(this.f26491oA.get(1));
        }
        return super.mo32120B(adTemplate);
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: a */
    public final void mo32119a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, C8619c c8619c, int i) {
        super.m32225a(frameLayout, adBaseFrameLayout, this.f26491oA, this.f26493oC);
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: b */
    public final void mo32118b(C10605b c10605b) {
        c10605b.setAdTemplateList(this.f26491oA);
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: bx */
    public final boolean mo32117bx() {
        if (this.f26492oB) {
            return this.f26383HL;
        }
        return super.mo32117bx();
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: fj */
    public final void mo32116fj() {
        super.mo32116fj();
        this.f26387cL.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: fk */
    public final boolean mo32115fk() {
        return false;
    }

    /* renamed from: fl */
    public final void m32114fl() {
        C9109aw c9109aw = this.f26390cQ;
        if (c9109aw != null) {
            c9109aw.m29267ss();
        }
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: fm */
    public final void mo31935fm() {
        C8032c.m31762a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: fn */
    public final void mo31934fn() {
        AdTemplate adTemplate = this.mAdTemplate;
        C8032c.m31774a(adTemplate, true, "middle_play_end_card", mo32120B(adTemplate));
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: fo */
    public final void mo31933fo() {
        C8032c.m31761a(true, "middle_play_end_card", mo32120B(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public final void setShowLandingPage(boolean z) {
        this.f26492oB = z;
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: a */
    public final void mo31936a(C9003a c9003a) {
        super.mo31936a(c9003a);
        List<AdTemplate> list = this.f26491oA;
        C9182w c9182w = new C9182w(new ArrayList(list.subList(1, list.size() - 1)));
        c9182w.m29212a(this.f26494oD);
        c9003a.m29403a(c9182w);
    }
}
