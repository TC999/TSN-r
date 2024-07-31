package com.kwad.components.p208ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9151h;
import com.kwad.components.core.webview.jshandler.InterfaceC9165n;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p250c.C7863a;
import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.components.p208ad.reward.p250c.C7869f;
import com.kwad.components.p208ad.reward.p250c.InterfaceC7866d;
import com.kwad.components.p208ad.reward.p256i.C7950b;
import com.kwad.components.p208ad.reward.p258k.C7990p;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7951j extends C7824b {
    @Nullable

    /* renamed from: qg */
    private InterfaceC7866d f26662qg;

    /* renamed from: qh */
    private WeakReference<C7907g> f26663qh;

    public C7951j(C7907g c7907g, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.f26663qh = new WeakReference<>(c7907g);
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: fm */
    public final void mo31935fm() {
        WeakReference<C7907g> weakReference = this.f26663qh;
        C8032c.m31762a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: fn */
    public final void mo31934fn() {
        WeakReference<C7907g> weakReference = this.f26663qh;
        boolean z = (weakReference != null ? weakReference.get() : null) != null;
        AdTemplate adTemplate = this.mAdTemplate;
        C8032c.m31774a(adTemplate, z, "end_card", mo32120B(adTemplate));
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: fo */
    public final void mo31933fo() {
        WeakReference<C7907g> weakReference = this.f26663qh;
        C8032c.m31761a((weakReference != null ? weakReference.get() : null) != null, "end_card", mo32120B(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    /* renamed from: a */
    public final void m31938a(@Nullable InterfaceC7866d interfaceC7866d) {
        this.f26662qg = interfaceC7866d;
    }

    @Override // com.kwad.components.p208ad.p247k.C7824b
    /* renamed from: a */
    public final void mo31936a(C9003a c9003a) {
        super.mo31936a(c9003a);
        c9003a.m29403a(new C7950b(this.f26387cL.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        c9003a.m29403a(new C7869f(new InterfaceC7866d() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.p208ad.reward.p250c.InterfaceC7866d
            /* renamed from: a */
            public final void mo31322a(C7864b c7864b) {
                if (C7951j.this.f26662qg != null) {
                    C7951j.this.f26662qg.mo31322a(c7864b);
                }
            }
        }));
        c9003a.m29403a(new C9151h(new InterfaceC9165n() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.core.webview.jshandler.InterfaceC9165n
            /* renamed from: a */
            public final void mo29222a(C9151h c9151h, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    c9151h.m29235a(C7863a.m32133gL().m32132gM());
                }
            }
        }));
        WeakReference<C7907g> weakReference = this.f26663qh;
        c9003a.m29402b(new C7990p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.f26388cO));
    }
}
