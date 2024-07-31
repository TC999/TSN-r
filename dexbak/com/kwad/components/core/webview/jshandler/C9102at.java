package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.at */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9102at implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29197VX;

    /* renamed from: XQ */
    private InterfaceC9105c f29198XQ;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.at$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9103a extends C10482a implements InterfaceC9914b {
        public int status;
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.at$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9104b {
        /* renamed from: pF */
        void mo29273pF();
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.at$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9105c {
        /* renamed from: pI */
        void mo29272pI();
    }

    public C9102at(InterfaceC9105c interfaceC9105c) {
        this.f29198XQ = interfaceC9105c;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29197VX = interfaceC10627c;
        InterfaceC9105c interfaceC9105c = this.f29198XQ;
        if (interfaceC9105c != null) {
            interfaceC9105c.mo29272pI();
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29197VX = null;
    }

    /* renamed from: sq */
    public final void m29274sq() {
        if (this.f29197VX != null) {
            C9103a c9103a = new C9103a();
            c9103a.status = 1;
            this.f29197VX.mo25251a(c9103a);
        }
    }
}
