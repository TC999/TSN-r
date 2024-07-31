package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9232x implements InterfaceC10625a {

    /* renamed from: WB */
    private InterfaceC10627c f29309WB;

    /* renamed from: xQ */
    private OfflineOnAudioConflictListener f29310xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.a.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            C9232x.this.m29169aU(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            C9232x.this.m29169aU(3);
        }
    };

    @KsJson
    /* renamed from: com.kwad.components.core.webview.tachikoma.a.x$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9234a extends C10482a {

        /* renamed from: ZZ */
        public boolean f29312ZZ;
        public int aaa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aU */
    public void m29169aU(int i) {
        C9234a c9234a = new C9234a();
        c9234a.f29312ZZ = C8932a.m29575ah(ServiceProvider.getContext()).m29573qW();
        c9234a.aaa = i;
        InterfaceC10627c interfaceC10627c = this.f29309WB;
        if (interfaceC10627c != null) {
            interfaceC10627c.mo25251a(c9234a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        C8932a.m29575ah(ServiceProvider.getContext()).m29574b(this.f29310xQ);
        this.f29309WB = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29309WB = interfaceC10627c;
        C8932a.m29575ah(ServiceProvider.getContext()).m29577a(this.f29310xQ);
        m29169aU(1);
    }
}
