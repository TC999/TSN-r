package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9031a implements InterfaceC10625a {

    /* renamed from: VO */
    private InterfaceC9034b f29071VO;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9033a extends C10482a {

        /* renamed from: Jj */
        public String f29074Jj;

        /* renamed from: VR */
        public String f29075VR;

        /* renamed from: VS */
        public String f29076VS;
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9034b {
        /* renamed from: c */
        void mo28993c(C9033a c9033a);
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9035c extends C10482a {

        /* renamed from: VT */
        public int f29077VT;

        /* renamed from: VU */
        public long f29078VU;

        /* renamed from: VV */
        public boolean f29079VV;
        public int errorCode;
    }

    public C9031a(InterfaceC9034b interfaceC9034b) {
        this.f29071VO = interfaceC9034b;
    }

    /* renamed from: b */
    private void m29339b(final C9033a c9033a) {
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (C9031a.this.f29071VO != null) {
                    C9031a.this.f29071VO.mo28993c(c9033a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            C9033a c9033a = new C9033a();
            c9033a.parseJson(new JSONObject(str));
            m29339b(c9033a);
        } catch (Throwable unused) {
        }
    }
}
