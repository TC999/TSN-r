package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ag */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9057ag implements InterfaceC10625a {

    /* renamed from: Wf */
    private final C10605b f29127Wf;

    /* renamed from: com.kwad.components.core.webview.jshandler.ag$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9058a implements InterfaceC9914b {
        private int screenOrientation;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "screenOrientation", this.screenOrientation);
            return jSONObject;
        }
    }

    public C9057ag(C10605b c10605b) {
        this.f29127Wf = c10605b;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29127Wf.m25325GN()) {
            interfaceC10627c.onError(-1, "native adTemplate is null");
            return;
        }
        C9058a c9058a = new C9058a();
        c9058a.screenOrientation = !C11015ai.isOrientationPortrait() ? 1 : 0;
        interfaceC10627c.mo25251a(c9058a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getScreenOrientation";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
