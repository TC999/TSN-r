package com.kwad.components.core.p289e.p294e;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.core.e.e.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8638d extends C8636b implements View.OnClickListener {

    /* renamed from: Lr */
    private TextView f28280Lr;

    /* renamed from: Ls */
    private TextView f28281Ls;

    /* renamed from: qO */
    private TextView f28282qO;

    @Override // com.kwad.components.core.p289e.p294e.C8636b, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (this.f28277Lq.f28279Lp.m30181nB() == 1) {
            TextView textView = this.f28282qO;
            textView.setText("即将打开" + C10483a.m25822cd(this.mAdInfo));
        } else if (this.f28277Lq.f28279Lp.m30181nB() == 2) {
            this.f28282qO.setText("即将打开第三方页面");
        }
        C10751a.m24923a(this, this.f28280Lr, this.f28281Ls);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f28277Lq.f28279Lp.m30210ak(true);
        this.f28277Lq.f28278Ln.dismiss();
        if (view == this.f28280Lr) {
            C8615a.m30233a(this.f28277Lq.f28279Lp);
            C9908c.m27287p(this.f28277Lq.f28279Lp.getAdTemplate(), 230);
        } else if (view == this.f28281Ls) {
            C9908c.m27287p(this.f28277Lq.f28279Lp.getAdTemplate(), 231);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f28282qO = (TextView) findViewById(C9659R.C9662id.ksad_second_confirm_content_view);
        this.f28280Lr = (TextView) findViewById(C9659R.C9662id.ksad_second_confirm_ensure);
        this.f28281Ls = (TextView) findViewById(C9659R.C9662id.ksad_second_confirm_cancle);
    }
}
