package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9151h implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29241VX;

    /* renamed from: VZ */
    private InterfaceC9165n f29242VZ;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9152a extends C10482a {

        /* renamed from: Wa */
        public String f29243Wa;

        public final String getTarget() {
            return this.f29243Wa;
        }
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.h$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9153b extends C10482a {

        /* renamed from: Md */
        public int f29244Md;

        /* renamed from: Wb */
        public int f29245Wb;

        /* renamed from: Wc */
        public int f29246Wc;
    }

    public C9151h(InterfaceC9165n interfaceC9165n) {
        this.f29242VZ = interfaceC9165n;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29241VX = interfaceC10627c;
        try {
            C9152a c9152a = new C9152a();
            c9152a.parseJson(new JSONObject(str));
            String target = c9152a.getTarget();
            InterfaceC9165n interfaceC9165n = this.f29242VZ;
            if (interfaceC9165n != null) {
                interfaceC9165n.mo29222a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: aO */
    public final void m29234aO(int i) {
        C9153b c9153b = new C9153b();
        c9153b.f29244Md = i;
        m29235a(c9153b);
    }

    /* renamed from: aT */
    public final void m29233aT(boolean z) {
        C9153b c9153b = new C9153b();
        c9153b.f29246Wc = z ? 1 : 0;
        m29235a(c9153b);
    }

    /* renamed from: f */
    public final void m29232f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        C9153b c9153b = new C9153b();
        c9153b.f29245Wb = playableSource.getCode();
        m29235a(c9153b);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29241VX = null;
    }

    /* renamed from: a */
    public final void m29235a(C10482a c10482a) {
        InterfaceC10627c interfaceC10627c = this.f29241VX;
        if (interfaceC10627c == null || c10482a == null) {
            return;
        }
        interfaceC10627c.mo25251a(c10482a);
    }
}
