package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9258s;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9221s implements InterfaceC10625a {

    /* renamed from: ZP */
    private InterfaceC9222a f29301ZP;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.s$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9222a {
        /* renamed from: a */
        void mo28997a(C9258s c9258s);
    }

    /* renamed from: a */
    public final void m29177a(InterfaceC9222a interfaceC9222a) {
        this.f29301ZP = interfaceC9222a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "showToast";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29301ZP = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29301ZP != null) {
            C9258s c9258s = new C9258s();
            try {
                c9258s.parseJson(new JSONObject(str));
                this.f29301ZP.mo28997a(c9258s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
