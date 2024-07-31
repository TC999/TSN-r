package com.kwad.components.core.p326q;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.C9278d;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p334b.C9262w;
import com.kwad.components.core.webview.tachikoma.p335c.C9268c;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.q.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8900c extends C9268c {
    /* renamed from: qP */
    private C9278d m29641qP() {
        return new C9278d() { // from class: com.kwad.components.core.q.c.1
            @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C9262w c9262w = new C9262w();
                c9262w.aav = C8898a.m29651qH().m29644qO() + 1;
                interfaceC10627c.mo25251a(c9262w);
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        interfaceC9876q.mo27480c(m29641qP());
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.C9268c, com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        super.mo28984a(webCloseStatus);
        if (webCloseStatus.interactSuccess) {
            DialogFragmentC9274e dialogFragmentC9274e = this.aay.f29325YI;
            if (dialogFragmentC9274e != null) {
                dialogFragmentC9274e.dismiss();
                return;
            }
            return;
        }
        this.aay.mActivity.finish();
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.C9268c, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        super.mo28989a(tKRenderFailReason);
    }
}
