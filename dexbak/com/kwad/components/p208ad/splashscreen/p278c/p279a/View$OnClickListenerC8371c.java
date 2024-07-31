package com.kwad.components.p208ad.splashscreen.p278c.p279a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.p208ad.splashscreen.monitor.C8495a;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;
import com.kwad.components.p208ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8371c extends C8421e implements View.OnClickListener, InterfaceC11145c {

    /* renamed from: EB */
    private CloseCountDownView f27649EB;

    /* renamed from: ED */
    private ViewGroup f27650ED;

    /* renamed from: EE */
    private ViewGroup f27651EE;

    /* renamed from: EF */
    private ImageView f27652EF;

    /* renamed from: EG */
    private TextView f27653EG;

    /* renamed from: EH */
    private TextView f27654EH;

    /* renamed from: EI */
    private CloseCountDownView.InterfaceC8504a f27655EI = new CloseCountDownView.InterfaceC8504a() { // from class: com.kwad.components.ad.splashscreen.c.a.c.1
        @Override // com.kwad.components.p208ad.splashscreen.widget.CloseCountDownView.InterfaceC8504a
        /* renamed from: df */
        public final void mo30514df() {
            C9893a.C9894a c9894a = new C9893a.C9894a();
            C8495a.m30585kT().m30584l(View$OnClickListenerC8371c.this.f27734Dg.mAdTemplate);
            if (View$OnClickListenerC8371c.this.f27734Dg.mTimerHelper != null) {
                c9894a.duration = View$OnClickListenerC8371c.this.f27734Dg.mTimerHelper.getTime();
            }
            C9908c.m27334b(View$OnClickListenerC8371c.this.f27734Dg.mAdTemplate, new C9913b().m27265cL(1).m27268b(c9894a).m27257cT(6), (JSONObject) null);
            View$OnClickListenerC8371c.this.f27734Dg.m30602kO();
        }

        @Override // com.kwad.components.p208ad.splashscreen.widget.CloseCountDownView.InterfaceC8504a
        /* renamed from: lb */
        public final void mo30513lb() {
            C9893a.C9894a c9894a = new C9893a.C9894a();
            if (View$OnClickListenerC8371c.this.f27734Dg.mTimerHelper != null) {
                c9894a.duration = View$OnClickListenerC8371c.this.f27734Dg.mTimerHelper.getTime();
            }
            C9908c.m27334b(View$OnClickListenerC8371c.this.f27734Dg.mAdTemplate, new C9913b().m27265cL(14).m27268b(c9894a).m27257cT(6), (JSONObject) null);
            View$OnClickListenerC8371c.this.f27734Dg.m30598kS();
        }
    };

    /* renamed from: t */
    private void m30864t(View view) {
        if (view == this.f27650ED) {
            this.f27734Dg.m30618c(2, view.getContext(), 104, 2);
        } else if (view == this.f27651EE) {
            this.f27734Dg.m30618c(2, view.getContext(), 26, 1);
        } else if (view == this.f27652EF) {
            this.f27734Dg.m30618c(2, view.getContext(), 15, 2);
        } else if (view == this.f27653EG) {
            this.f27734Dg.m30618c(2, view.getContext(), 16, 2);
        } else if (view == this.f27654EH) {
            this.f27734Dg.m30618c(2, view.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27649EB.setOnViewClickListener(this.f27655EI);
        this.f27651EE.setOnClickListener(this);
        new GestureDetector$OnGestureListenerC11148f(this.f27651EE.getContext(), this.f27651EE, this);
        if (C10484b.m25712df(C10487e.m25641dQ(this.f27734Dg.mAdTemplate))) {
            this.f27650ED.setOnClickListener(this);
            this.f27652EF.setOnClickListener(this);
            this.f27653EG.setOnClickListener(this);
            this.f27654EH.setOnClickListener(this);
            new GestureDetector$OnGestureListenerC11148f(this.f27651EE.getContext(), this.f27650ED, this);
            new GestureDetector$OnGestureListenerC11148f(this.f27651EE.getContext(), this.f27652EF, this);
            new GestureDetector$OnGestureListenerC11148f(this.f27651EE.getContext(), this.f27653EG, this);
            new GestureDetector$OnGestureListenerC11148f(this.f27651EE.getContext(), this.f27654EH, this);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m30864t(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27649EB = (CloseCountDownView) findViewById(C9659R.C9662id.ksad_ad_endcard_close_root);
        this.f27650ED = (ViewGroup) findViewById(C9659R.C9662id.ksad_splash_end_card_giftbox_view);
        this.f27651EE = (ViewGroup) findViewById(C9659R.C9662id.ksad_splash_endcard_actionbar);
        this.f27652EF = (ImageView) findViewById(C9659R.C9662id.ksad_ad_endcard_icon);
        this.f27653EG = (TextView) findViewById(C9659R.C9662id.ksad_ad_endcard_appname);
        this.f27654EH = (TextView) findViewById(C9659R.C9662id.ksad_ad_endcard_appdesc);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m30864t(view);
    }
}
