package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9202h extends AbstractC9230w {

    /* renamed from: ZH */
    private InterfaceC9203a f29291ZH;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9203a {
        /* renamed from: a */
        void mo29186a(C9202h c9202h);
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.tachikoma.a.h$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9204b extends C10482a {

        /* renamed from: ZI */
        public int f29292ZI;
    }

    /* renamed from: a */
    public final void m29188a(InterfaceC9203a interfaceC9203a) {
        this.f29291ZH = interfaceC9203a;
    }

    /* renamed from: aV */
    public final void m29187aV(boolean z) {
        int i = z ? 1 : 2;
        C9204b c9204b = new C9204b();
        c9204b.f29292ZI = i;
        m29171b(c9204b);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        super.onDestroy();
        this.f29291ZH = null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        super.mo25241a(str, interfaceC10627c);
        InterfaceC9203a interfaceC9203a = this.f29291ZH;
        if (interfaceC9203a != null) {
            interfaceC9203a.mo29186a(this);
        }
    }
}
