package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h extends w {
    private a ZH;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(h hVar);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int ZI;
    }

    public final void a(a aVar) {
        this.ZH = aVar;
    }

    public final void aV(boolean z3) {
        int i4 = z3 ? 1 : 2;
        b bVar = new b();
        bVar.ZI = i4;
        b(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        this.ZH = null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        a aVar = this.ZH;
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
