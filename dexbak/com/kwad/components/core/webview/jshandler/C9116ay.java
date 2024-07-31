package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.webview.jshandler.ay */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9116ay implements InterfaceC10625a {

    /* renamed from: XW */
    private final InterfaceC9118a f29208XW;

    /* renamed from: com.kwad.components.core.webview.jshandler.ay$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9118a {
        @MainThread
        /* renamed from: bB */
        void mo29256bB();
    }

    public C9116ay(InterfaceC9118a interfaceC9118a) {
        this.f29208XW = interfaceC9118a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull final InterfaceC10627c interfaceC10627c) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ay.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (C9116ay.this.f29208XW != null) {
                    C9116ay.this.f29208XW.mo29256bB();
                }
                interfaceC10627c.mo25251a(null);
            }
        });
    }
}
