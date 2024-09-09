package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c WB;
    private OfflineOnAudioConflictListener xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.a.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.aU(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.aU(3);
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean ZZ;
        public int aaa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i4) {
        a aVar = new a();
        aVar.ZZ = com.kwad.components.core.s.a.ah(ServiceProvider.getContext()).qW();
        aVar.aaa = i4;
        com.kwad.sdk.core.webview.c.c cVar = this.WB;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.s.a.ah(ServiceProvider.getContext()).b(this.xQ);
        this.WB = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WB = cVar;
        com.kwad.components.core.s.a.ah(ServiceProvider.getContext()).a(this.xQ);
        aU(1);
    }
}
