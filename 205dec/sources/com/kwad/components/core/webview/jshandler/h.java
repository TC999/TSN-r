package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;
    private n VZ;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String Wa;

        public final String getTarget() {
            return this.Wa;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int Md;
        public int Wb;
        public int Wc;
    }

    public h(n nVar) {
        this.VZ = nVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            n nVar = this.VZ;
            if (nVar != null) {
                nVar.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    public final void aO(int i4) {
        b bVar = new b();
        bVar.Md = i4;
        a(bVar);
    }

    public final void aT(boolean z3) {
        b bVar = new b();
        bVar.Wc = z3 ? 1 : 0;
        a(bVar);
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.Wb = playableSource.getCode();
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VX = null;
    }

    public final void a(com.kwad.sdk.core.response.a.a aVar) {
        com.kwad.sdk.core.webview.c.c cVar = this.VX;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }
}
