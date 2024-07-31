package com.kwad.components.p208ad.reward.p258k.p259a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.C9151h;
import com.kwad.components.core.webview.jshandler.InterfaceC9165n;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.p335c.C9268c;
import com.kwad.components.p208ad.reward.p250c.C7863a;
import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.components.p208ad.reward.p250c.C7869f;
import com.kwad.components.p208ad.reward.p250c.InterfaceC7866d;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;

/* renamed from: com.kwad.components.ad.reward.k.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7961c extends C9268c implements InterfaceC7965e {

    /* renamed from: xu */
    private C7959a f26672xu;

    /* renamed from: a */
    public final void m31916a(C7864b c7864b) {
        C7959a c7959a = this.f26672xu;
        if (c7959a != null) {
            c7959a.m31923b(c7864b);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a
    /* renamed from: hN */
    public final C9305i mo29161hN() {
        this.f26672xu = (C7959a) this.aay;
        return new C7964d(this.f26672xu.m31922ji(), this.f26672xu.f29327xs, getContext());
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
        super.mo28982a(c10640a);
        C7959a c7959a = this.f26672xu;
        if (c7959a == null || c7959a.m31922ji() == null) {
            return;
        }
        this.f26672xu.m31922ji().f26528oI.mo32088bJ();
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(new C7869f(new InterfaceC7866d() { // from class: com.kwad.components.ad.reward.k.a.c.1
            @Override // com.kwad.components.p208ad.reward.p250c.InterfaceC7866d
            /* renamed from: a */
            public final void mo31322a(C7864b c7864b) {
                C10331c.m26254d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + c7864b.m32129gO());
                C7961c.this.m31916a(c7864b);
            }
        }));
        interfaceC9876q.mo27480c(new C9151h(new InterfaceC9165n() { // from class: com.kwad.components.ad.reward.k.a.c.2
            @Override // com.kwad.components.core.webview.jshandler.InterfaceC9165n
            /* renamed from: a */
            public final void mo29222a(C9151h c9151h, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    c9151h.m29235a(C7863a.m32133gL().m32132gM());
                    C7863a.m32133gL().m32137a(c9151h);
                }
            }
        }));
    }
}
