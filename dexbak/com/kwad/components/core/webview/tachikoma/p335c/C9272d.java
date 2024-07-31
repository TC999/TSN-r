package com.kwad.components.core.webview.tachikoma.p335c;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9292d;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.InterfaceC9872m;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.components.core.webview.tachikoma.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9272d extends Presenter {

    /* renamed from: SK */
    private FrameLayout f29331SK;

    /* renamed from: SQ */
    private InterfaceC9872m f29332SQ;

    /* renamed from: YI */
    private DialogFragmentC9274e f29333YI;
    protected C9267b aay;

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C9267b c9267b = (C9267b) m24613Jx();
        this.aay = c9267b;
        DialogFragmentC9274e dialogFragmentC9274e = c9267b.f29325YI;
        this.f29333YI = dialogFragmentC9274e;
        if (dialogFragmentC9274e != null) {
            dialogFragmentC9274e.m29152a(new InterfaceC9292d() { // from class: com.kwad.components.core.webview.tachikoma.c.d.1
                @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9292d
                /* renamed from: fR */
                public final void mo29096fR() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9292d
                /* renamed from: fZ */
                public final void mo29095fZ() {
                }
            });
        }
        InterfaceC9872m mo28978a = this.aay.aaB.mo28978a(null);
        this.f29332SQ = mo28978a;
        if (mo28978a == null) {
            this.aay.aaA.callbackPageStatus(false, null);
            this.f29333YI.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.f29332SQ.getView();
        view.setLayoutParams(layoutParams);
        this.f29331SK.addView(view);
        this.f29332SQ.render();
        this.aay.aaA.callbackPageStatus(true, null);
    }

    public final boolean onBackPressed() {
        InterfaceC9872m interfaceC9872m = this.f29332SQ;
        return interfaceC9872m != null && interfaceC9872m.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f29331SK = (FrameLayout) findViewById(C9659R.C9662id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
