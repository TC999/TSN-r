package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ac */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9043ac implements InterfaceC10625a {

    /* renamed from: WK */
    protected InterfaceC9045b f29095WK;

    /* renamed from: Wf */
    protected final C10605b f29096Wf;

    /* renamed from: com.kwad.components.core.webview.jshandler.ac$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9044a implements InterfaceC9914b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "width", this.width);
            C11126t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ac$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9045b {
        /* renamed from: c */
        void mo28996c(C9044a c9044a);
    }

    public C9043ac(C10605b c10605b) {
        this.f29096Wf = c10605b;
    }

    /* renamed from: a */
    public final void m29330a(InterfaceC9045b interfaceC9045b) {
        this.f29095WK = interfaceC9045b;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9044a c9044a = new C9044a();
        InterfaceC9045b interfaceC9045b = this.f29095WK;
        if (interfaceC9045b != null) {
            interfaceC9045b.mo28996c(c9044a);
        } else {
            c9044a.width = this.f29096Wf.f29621OE.getWidth();
            c9044a.height = this.f29096Wf.f29621OE.getHeight();
        }
        interfaceC10627c.mo25251a(c9044a);
    }
}
