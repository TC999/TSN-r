package com.kwad.components.p208ad.splashscreen.p278c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.webview.tachikoma.p336d.C9279a;
import com.kwad.components.p208ad.splashscreen.C8474d;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.InterfaceC8488g;
import com.kwad.components.p208ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p402g.C10380d;
import com.kwad.sdk.core.p402g.InterfaceC10376b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8442m extends AbstractC8433i implements View.OnClickListener, InterfaceC8488g, InterfaceC10376b, InterfaceC11145c {

    /* renamed from: CW */
    private boolean f27770CW;

    /* renamed from: DB */
    private C8474d f27771DB;

    /* renamed from: DE */
    private ViewGroup f27772DE;

    /* renamed from: DF */
    private KsShakeView f27773DF;

    /* renamed from: DG */
    private TextView f27774DG;

    /* renamed from: eg */
    private C10380d f27775eg;

    /* renamed from: eh */
    private Vibrator f27776eh;
    private long mStartTime;

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8488g
    /* renamed from: W */
    public final void mo30629W(int i) {
    }

    @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
    /* renamed from: aV */
    public final void mo26219aV() {
        C9908c.m27321bN(this.f27734Dg.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.m.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC8442m.this.f27734Dg.f27876CI = SystemClock.elapsedRealtime() - View$OnClickListenerC8442m.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.f27776eh = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.ksad_shake_layout);
        if (viewStub != null) {
            this.f27772DE = (ViewGroup) viewStub.inflate();
        } else {
            this.f27772DE = (ViewGroup) findViewById(C9659R.C9662id.ksad_shake_root);
        }
        this.f27774DG = (TextView) this.f27772DE.findViewById(C9659R.C9662id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.f27772DE.findViewById(C9659R.C9662id.ksad_shake_view);
        this.f27773DF = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: j */
    protected final void mo30728j(int i, String str) {
        TextView textView = this.f27774DG;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8488g
    /* renamed from: kA */
    public final void mo30628kA() {
        C10380d c10380d = this.f27775eg;
        if (c10380d != null) {
            c10380d.m26194bj(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lj */
    protected final void mo30727lj() {
        AdInfo m25641dQ = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        C8489h c8489h = this.f27734Dg;
        this.f27771DB = C8474d.m30657a(c8489h.mAdTemplate, m25641dQ, c8489h.mApkDownloadHelper, 2);
        this.f27770CW = C10486d.m25657dF(this.f27734Dg.mAdTemplate);
        new GestureDetector$OnGestureListenerC11148f(this.f27773DF.getContext(), this.f27773DF, this);
        this.f27734Dg.m30622a(this);
        TextView textView = this.f27774DG;
        if (textView != null) {
            textView.setText(this.f27771DB.m30656ku());
        }
        KsShakeView ksShakeView = this.f27773DF;
        if (ksShakeView != null) {
            ksShakeView.m30509ac(this.f27771DB.m30655kv());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lk */
    protected final void mo30726lk() {
        ViewGroup viewGroup = this.f27772DE;
        if (viewGroup == null || this.f27734Dg == null) {
            return;
        }
        viewGroup.setVisibility(0);
        C9908c.m27337b(this.f27734Dg.mAdTemplate, (int) Opcodes.INVOKEINTERFACE, (JSONObject) null);
        C9279a.m29119sY().m29121aW(Opcodes.INVOKEINTERFACE);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: ll */
    protected final void mo30725ll() {
        float m25772cT = C10484b.m25772cT(this.f27734Dg.mAdTemplate);
        C10380d c10380d = this.f27775eg;
        if (c10380d == null) {
            C10380d c10380d2 = new C10380d(m25772cT);
            this.f27775eg = c10380d2;
            c10380d2.m26199a(this);
            return;
        }
        c10380d.m26192e(m25772cT);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lm */
    protected final void mo30724lm() {
        C10380d c10380d = this.f27775eg;
        if (c10380d != null) {
            c10380d.m26195bi(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: ln */
    protected final void mo30723ln() {
        C10380d c10380d = this.f27775eg;
        if (c10380d != null) {
            c10380d.m26194bj(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lo */
    protected final void mo30722lo() {
        this.f27773DF.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.m.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC8442m.this.f27773DF.m30503lV();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C8489h c8489h;
        AdTemplate adTemplate;
        C10331c.m26254d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.f27773DF) || (c8489h = this.f27734Dg) == null || (adTemplate = c8489h.mAdTemplate) == null || !C10484b.m25735dF(C10487e.m25641dQ(adTemplate))) {
            return;
        }
        this.f27734Dg.m30618c(1, getContext(), Opcodes.IFLE, 1);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C10331c.m26254d("SplashShakePresenter", "onUnbind");
        C8489h c8489h = this.f27734Dg;
        if (c8489h != null) {
            c8489h.m30620b(this);
        }
        KsShakeView ksShakeView = this.f27773DF;
        if (ksShakeView != null) {
            ksShakeView.m30502lW();
        }
    }

    @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
    /* renamed from: a */
    public final void mo26220a(final double d) {
        boolean m30267nr = AlertDialogC8602b.m30267nr();
        if (!this.f27734Dg.f27881Cs.mo26185tz() || m30267nr) {
            return;
        }
        this.f27773DF.m30508b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.c.m.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View$OnClickListenerC8442m view$OnClickListenerC8442m = View$OnClickListenerC8442m.this;
                C8489h c8489h = view$OnClickListenerC8442m.f27734Dg;
                if (c8489h != null) {
                    c8489h.m30624a(1, view$OnClickListenerC8442m.getContext(), 157, 2, new C8489h.InterfaceC8492a() { // from class: com.kwad.components.ad.splashscreen.c.m.3.1
                        @Override // com.kwad.components.p208ad.splashscreen.C8489h.InterfaceC8492a
                        /* renamed from: b */
                        public final void mo30595b(@NonNull C9913b c9913b) {
                            c9913b.m27246l(d);
                        }
                    });
                }
                View$OnClickListenerC8442m.this.f27773DF.m30503lV();
            }
        });
        C11064bn.m23863a(getContext(), this.f27776eh);
        mo30723ln();
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        C8489h c8489h;
        C10331c.m26254d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.f27770CW);
        if (this.f27770CW && (c8489h = this.f27734Dg) != null) {
            c8489h.m30618c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        C8489h c8489h;
        C10331c.m26254d("SplashShakePresenter", "onSingleTap: " + view);
        if (C10484b.m25735dF(C10487e.m25641dQ(this.f27734Dg.mAdTemplate)) && (c8489h = this.f27734Dg) != null) {
            c8489h.m30618c(1, getContext(), Opcodes.IFLE, 1);
        }
    }
}
