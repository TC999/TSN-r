package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.w */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9182w implements InterfaceC10625a {

    /* renamed from: Wq */
    private List<AdTemplate> f29267Wq;

    /* renamed from: cO */
    private C10605b f29268cO;

    /* renamed from: oD */
    private InterfaceC9184b f29269oD;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.w$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9183a extends C10482a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.w$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9184b {
        /* renamed from: N */
        void mo29210N(AdTemplate adTemplate);
    }

    public C9182w(List<AdTemplate> list) {
        this.f29267Wq = list;
    }

    /* renamed from: sn */
    private List<AdTemplate> m29211sn() {
        List<AdTemplate> list = this.f29267Wq;
        if (list != null) {
            return list;
        }
        C10605b c10605b = this.f29268cO;
        if (c10605b != null) {
            return c10605b.m25326GM();
        }
        return null;
    }

    /* renamed from: a */
    public final void m29212a(InterfaceC9184b interfaceC9184b) {
        this.f29269oD = interfaceC9184b;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            C9183a c9183a = new C9183a();
            c9183a.parseJson(new JSONObject(str));
            AdTemplate m25652a = C10487e.m25652a(m29211sn(), c9183a.creativeId, c9183a.adStyle);
            InterfaceC9184b interfaceC9184b = this.f29269oD;
            if (interfaceC9184b != null) {
                interfaceC9184b.mo29210N(m25652a);
            }
        } catch (JSONException unused) {
        }
    }

    public C9182w(C10605b c10605b) {
        this.f29268cO = c10605b;
    }
}
