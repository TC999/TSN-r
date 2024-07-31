package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9225u implements InterfaceC10625a {

    /* renamed from: ZR */
    private InterfaceC9226a f29303ZR;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.u$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9226a {
        /* renamed from: a */
        void mo29174a(C9227b c9227b);
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.tachikoma.a.u$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9227b extends C10482a {
        public int errorCode;
        public String errorMsg;
        public int status;
    }

    /* renamed from: a */
    public final void m29175a(InterfaceC9226a interfaceC9226a) {
        this.f29303ZR = interfaceC9226a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "splashShowStatus";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29303ZR = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29303ZR != null) {
            C9227b c9227b = new C9227b();
            try {
                try {
                    c9227b.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.f29303ZR.mo29174a(c9227b);
            }
        }
    }
}
