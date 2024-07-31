package com.kwad.components.core.webview.jshandler;

import android.os.Vibrator;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.webview.jshandler.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9179u implements InterfaceC10625a {

    /* renamed from: eh */
    private Vibrator f29264eh;

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29264eh = (Vibrator) ServiceProvider.getContext().getSystemService("vibrator");
        C11064bn.m23863a(ServiceProvider.getContext(), this.f29264eh);
        interfaceC10627c.mo25251a(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "startVibrate";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
