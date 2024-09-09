package com.kwad.components.core.r.b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.proxy.c;
import com.kwad.sdk.R;
import com.kwad.sdk.components.m;
import com.kwad.sdk.mvp.Presenter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends Presenter {
    private FrameLayout SK;
    private com.kwad.components.core.r.a.b SN;
    private m SQ;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.SN = (com.kwad.components.core.r.a.b) Jx();
        this.SK = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.SQ = this.SN.SE.a(null);
        this.SN.Ms.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.b.1
            @Override // com.kwad.components.core.l.a.a
            public final void c(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fP() {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fQ() {
                if (b.this.SN.SD != null) {
                    b.this.SN.SD.callbackDismiss();
                }
            }
        });
        if (this.SQ == null) {
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.SQ.getView();
        view.setLayoutParams(layoutParams);
        this.SK.addView(view);
        this.SQ.bindActivity(getActivity());
        this.SQ.render();
    }

    public final boolean onBackPressed() {
        m mVar = this.SQ;
        return mVar != null && mVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
