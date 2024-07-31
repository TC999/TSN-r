package com.kwad.components.core.p327r.p329b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.components.core.p327r.p328a.C8904b;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.InterfaceC9872m;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.components.core.r.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8908b extends Presenter {

    /* renamed from: SK */
    private FrameLayout f28791SK;

    /* renamed from: SN */
    private C8904b f28792SN;

    /* renamed from: SQ */
    private InterfaceC9872m f28793SQ;

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f28792SN = (C8904b) m24613Jx();
        this.f28791SK = (FrameLayout) findViewById(C9659R.C9662id.ksad_js_container);
        this.f28793SQ = this.f28792SN.f28782SE.mo28978a(null);
        this.f28792SN.f28358Ms.add(new InterfaceC8689a() { // from class: com.kwad.components.core.r.b.b.1
            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: c */
            public final void mo29623c(AbstractC8886c abstractC8886c) {
            }

            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: d */
            public final void mo29622d(AbstractC8886c abstractC8886c) {
            }

            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: fP */
            public final void mo29621fP() {
            }

            @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
            /* renamed from: fQ */
            public final void mo29620fQ() {
                if (C8908b.this.f28792SN.f28781SD != null) {
                    C8908b.this.f28792SN.f28781SD.callbackDismiss();
                }
            }
        });
        if (this.f28793SQ == null) {
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.f28793SQ.getView();
        view.setLayoutParams(layoutParams);
        this.f28791SK.addView(view);
        this.f28793SQ.bindActivity(getActivity());
        this.f28793SQ.render();
    }

    public final boolean onBackPressed() {
        InterfaceC9872m interfaceC9872m = this.f28793SQ;
        return interfaceC9872m != null && interfaceC9872m.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
