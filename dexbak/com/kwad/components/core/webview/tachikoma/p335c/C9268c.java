package com.kwad.components.core.webview.tachikoma.p335c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p334b.C9264y;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9292d;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9870k;
import com.kwad.sdk.core.webview.p422c.InterfaceC10631g;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11059bi;

/* renamed from: com.kwad.components.core.webview.tachikoma.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9268c extends AbstractC9266a {

    /* renamed from: SK */
    private FrameLayout f29328SK;

    /* renamed from: YI */
    private DialogFragmentC9274e f29329YI;
    private C9218p aaE;
    private C9109aw aaF;
    private InterfaceC9292d aaG = new InterfaceC9292d() { // from class: com.kwad.components.core.webview.tachikoma.c.c.2
        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9292d
        /* renamed from: fR */
        public final void mo29096fR() {
            if (C9268c.this.aaF != null) {
                C9268c.this.aaF.m29268sr();
                C9268c.this.aaF.m29267ss();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9292d
        /* renamed from: fZ */
        public final void mo29095fZ() {
            if (C9268c.this.aaF != null) {
                C9268c.this.aaF.m29266st();
                C9268c.this.aaF.m29265su();
            }
        }
    };

    /* renamed from: xn */
    private String f29330xn;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sV */
    public void m29155sV() {
        DialogFragmentC9274e.InterfaceC9276a interfaceC9276a = this.aay.aaD;
        if (interfaceC9276a != null) {
            interfaceC9276a.mo29141fT();
        }
        C9283b.m29107tc().m29108s(getTkTemplateId(), getTKReaderScene());
        InterfaceC9870k interfaceC9870k = this.aay.aaA;
        if (interfaceC9870k != null) {
            interfaceC9870k.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28991a(C9031a.C9033a c9033a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        DialogFragmentC9274e dialogFragmentC9274e = this.f29329YI;
        if (dialogFragmentC9274e != null) {
            dialogFragmentC9274e.m29152a(this.aaG);
        }
        if (this.aay.aaA != null) {
            this.f29322gj.m29055a(new InterfaceC10631g() { // from class: com.kwad.components.core.webview.tachikoma.c.c.1
                @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10631g
                public final void callTKBridge(String str) {
                    C9268c.this.aay.aaA.callTKBridge(str);
                }
            });
            this.aay.aaA.mo27490a(this.f29322gj);
            this.f29322gj.m29054a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        InterfaceC9870k interfaceC9870k = this.aay.aaA;
        if (interfaceC9870k != null) {
            interfaceC9870k.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
        super.mo28979bG();
        C9267b c9267b = this.aay;
        if (c9267b.aaC) {
            InterfaceC9291c interfaceC9291c = c9267b.f29324Sy;
            if (interfaceC9291c != null) {
                interfaceC9291c.mo29100F(true);
                return;
            }
            return;
        }
        DialogFragmentC9274e dialogFragmentC9274e = this.f29329YI;
        if (dialogFragmentC9274e != null) {
            dialogFragmentC9274e.dismiss();
        }
        InterfaceC9291c interfaceC9291c2 = this.aay.f29324Sy;
        if (interfaceC9291c2 != null) {
            interfaceC9291c2.mo29097ga();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public FrameLayout getTKContainer() {
        return this.f29328SK;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public String getTkTemplateId() {
        StyleTemplate styleTemplate = this.aay.f29323SA;
        if (styleTemplate != null) {
            return styleTemplate.templateId;
        }
        return this.f29330xn;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f29328SK = (FrameLayout) findViewById(C9659R.C9662id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a
    /* renamed from: a */
    protected final void mo29159a(C9267b c9267b) {
        super.mo29159a(c9267b);
        C9267b c9267b2 = this.aay;
        this.f29330xn = c9267b2.f29326xn;
        this.f29329YI = c9267b2.f29325YI;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C11059bi.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C11059bi.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28987a(C9218p c9218p) {
        this.aaE = c9218p;
        long j = this.aay.f29327xs;
        if (c9218p == null || j <= 0) {
            return;
        }
        C9264y c9264y = new C9264y();
        c9264y.f29321nE = (int) ((((float) j) / 1000.0f) + 0.5f);
        this.aaE.m29178a(c9264y);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
        this.aaF = c9109aw;
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28985a(C9259t c9259t) {
        super.mo28985a(c9259t);
        DialogFragmentC9274e dialogFragmentC9274e = this.f29329YI;
        if (dialogFragmentC9274e != null) {
            dialogFragmentC9274e.dismiss();
        }
        InterfaceC9291c interfaceC9291c = this.aay.f29324Sy;
        if (interfaceC9291c != null) {
            interfaceC9291c.mo29100F(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.AbstractC9266a, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28984a(WebCloseStatus webCloseStatus) {
        super.mo28984a(webCloseStatus);
        InterfaceC9870k interfaceC9870k = this.aay.aaA;
        if (interfaceC9870k != null) {
            interfaceC9870k.callbackDialogDismiss();
        }
    }

    /* renamed from: a */
    public void mo28989a(TKRenderFailReason tKRenderFailReason) {
        DialogFragmentC9274e dialogFragmentC9274e = this.f29329YI;
        if (dialogFragmentC9274e != null) {
            if (dialogFragmentC9274e.isShowing()) {
                this.f29329YI.m29148d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.c.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        C9268c.this.f29329YI.m29147e(this);
                        C9268c.this.m29155sV();
                    }
                });
            } else {
                m29155sV();
            }
            this.f29329YI.dismiss();
            return;
        }
        m29155sV();
    }
}
