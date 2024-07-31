package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9216o extends AbstractC9230w {

    /* renamed from: ZO */
    private InterfaceC9217a f29299ZO;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.o$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9217a {
        boolean isMuted();
    }

    /* renamed from: a */
    public final void m29180a(InterfaceC9217a interfaceC9217a) {
        this.f29299ZO = interfaceC9217a;
    }

    /* renamed from: c */
    public final void m29179c(C9252m c9252m) {
        super.m29171b(c9252m);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerMuteStateListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        super.mo25241a(str, interfaceC10627c);
        if (this.f29299ZO != null) {
            C9252m c9252m = new C9252m();
            c9252m.aao = this.f29299ZO.isMuted();
            interfaceC10627c.mo25251a(c9252m);
        }
    }
}
