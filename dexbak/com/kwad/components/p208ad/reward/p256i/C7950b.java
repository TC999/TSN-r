package com.kwad.components.p208ad.reward.p256i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.C9138bf;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.components.ad.reward.i.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7950b extends C9138bf implements C9138bf.InterfaceC9139a {

    /* renamed from: sa */
    private PlayableSource f26661sa;

    public C7950b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.f26661sa = playableSource;
        m29240a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.C9138bf.InterfaceC9139a
    /* renamed from: dK */
    public final boolean mo29239dK() {
        C7838a.m32198eX().m32199c(this.f26661sa, new C7949a(this.mContext));
        return false;
    }
}
