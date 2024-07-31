package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.aa */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9036aa implements InterfaceC10625a {

    /* renamed from: WA */
    private Handler f29080WA;

    /* renamed from: WE */
    private boolean f29081WE;

    /* renamed from: WF */
    private boolean f29082WF;

    /* renamed from: Wf */
    private final C10605b f29083Wf;

    /* renamed from: Ws */
    private boolean f29084Ws;
    @Nullable

    /* renamed from: cR */
    private InterfaceC10635a f29085cR;
    @Nullable
    private final C8619c mApkDownloadHelper;

    public C9036aa(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a, boolean z, boolean z2, boolean z3) {
        this.f29081WE = false;
        this.f29082WF = false;
        this.f29084Ws = z;
        this.f29080WA = new Handler(Looper.getMainLooper());
        this.f29083Wf = c10605b;
        this.mApkDownloadHelper = c8619c;
        this.f29081WE = false;
        if (c8619c != null) {
            c8619c.m30152as(1);
        }
        this.f29085cR = interfaceC10635a;
        this.f29082WF = z3;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29080WA.removeCallbacksAndMessages(null);
        this.f29085cR = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29083Wf.m25325GN()) {
            interfaceC10627c.onError(-1, "native adTemplate is null");
            return;
        }
        final C10640a c10640a = new C10640a();
        try {
            c10640a.parseJson(new JSONObject(str));
            c10640a.f29642Kr = true;
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
        if (this.f29083Wf.aDL) {
            this.f29080WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.aa.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C9036aa.this.f29083Wf.aDM || c10640a.f29643XA) {
                        C9036aa.this.f29083Wf.getAdTemplate();
                        C8615a.m30234a(C9036aa.this.f29083Wf.f29621OE.getContext(), C9036aa.this.f29083Wf.getAdTemplate(), new C8615a.InterfaceC8617b() { // from class: com.kwad.components.core.webview.jshandler.aa.1.1
                            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                            public final void onAdClicked() {
                                if (C9036aa.this.f29085cR != null) {
                                    C9036aa.this.f29085cR.mo25245a(c10640a);
                                }
                            }
                        }, C9036aa.this.mApkDownloadHelper, c10640a.f29643XA, C9036aa.this.f29084Ws, C9036aa.this.f29081WE, C9036aa.this.f29082WF);
                    }
                }
            });
        } else if (this.f29085cR != null) {
            this.f29080WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.aa.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C9036aa.this.f29085cR != null) {
                        C9036aa.this.f29085cR.mo25245a(c10640a);
                    }
                }
            });
        }
        interfaceC10627c.mo25251a(null);
    }

    public C9036aa(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a) {
        this(c10605b, c8619c, interfaceC10635a, false, false, false);
    }

    public C9036aa(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a, byte b) {
        this(c10605b, c8619c, interfaceC10635a, false, false, false);
    }
}
