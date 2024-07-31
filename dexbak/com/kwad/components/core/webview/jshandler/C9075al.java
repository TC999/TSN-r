package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p425b.C10642c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.al */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9075al implements InterfaceC10625a {

    /* renamed from: WA */
    private final Handler f29159WA;

    /* renamed from: Wf */
    private final C10605b f29160Wf;
    @Nullable

    /* renamed from: Xu */
    private final InterfaceC9080b f29161Xu;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.al$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9079a extends C10482a {

        /* renamed from: XA */
        public boolean f29168XA;

        /* renamed from: XB */
        public String f29169XB;

        /* renamed from: XC */
        public int f29170XC;

        /* renamed from: XD */
        public C10642c f29171XD;
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.al$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9080b {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29159WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        final C8619c c8619c;
        final C9079a c9079a = new C9079a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            c9079a.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(c9079a.f29169XB));
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
        if (C10487e.m25649dI(adTemplate)) {
            if (this.f29160Wf.aDK != null) {
                c8619c = (C8619c) this.f29160Wf.aDK.m24135gA(C10487e.m25641dQ(adTemplate).downloadId);
            } else {
                c8619c = null;
            }
            if (this.f29160Wf.aDL) {
                this.f29159WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.al.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C8615a.m30233a(new C8615a.C8616a(C9075al.this.f29160Wf.f29621OE.getContext()).m30198aq(adTemplate).m30189b(c8619c).m30205an(c9079a.f29170XC).m30202ao(true).m30212ag(c9079a.f29171XD.f29649KG).m30197aq(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.core.webview.jshandler.al.1.1
                            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.f29161Xu != null) {
                this.f29159WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.al.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                    }
                });
            }
            interfaceC10627c.mo25251a(null);
        }
    }
}
