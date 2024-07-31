package com.kwad.components.p208ad.splashscreen.p278c;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.webview.tachikoma.p336d.C9279a;
import com.kwad.components.p208ad.splashscreen.C8474d;
import com.kwad.components.p208ad.splashscreen.C8489h;
import com.kwad.components.p208ad.splashscreen.InterfaceC8488g;
import com.kwad.components.p208ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p402g.C10377c;
import com.kwad.sdk.core.p402g.InterfaceC10375a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8438l extends AbstractC8433i implements View.OnClickListener, InterfaceC8488g, InterfaceC10375a {

    /* renamed from: DA */
    private C10377c f27760DA;

    /* renamed from: DB */
    private C8474d f27761DB;

    /* renamed from: Dw */
    private View f27762Dw;

    /* renamed from: Dx */
    private KsRotateView f27763Dx;

    /* renamed from: Dy */
    private TextView f27764Dy;

    /* renamed from: Dz */
    private TextView f27765Dz;
    private long mStartTime;

    @Override // com.kwad.sdk.core.p402g.InterfaceC10375a
    /* renamed from: U */
    public final void mo26222U(final String str) {
        boolean mo26185tz = this.f27734Dg.f27881Cs.mo26185tz();
        boolean m30267nr = AlertDialogC8602b.m30267nr();
        if (!mo26185tz || m30267nr) {
            return;
        }
        this.f27763Dx.m30453lU();
        C8489h c8489h = this.f27734Dg;
        if (c8489h != null) {
            c8489h.m30624a(1, getContext(), Opcodes.IF_ICMPLT, 2, new C8489h.InterfaceC8492a() { // from class: com.kwad.components.ad.splashscreen.c.l.3
                @Override // com.kwad.components.p208ad.splashscreen.C8489h.InterfaceC8492a
                /* renamed from: b */
                public final void mo30595b(@NonNull C9913b c9913b) {
                    c9913b.m27248dg(str);
                }
            });
        }
        m30736lq();
        mo30723ln();
    }

    @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8488g
    /* renamed from: W */
    public final void mo30629W(int i) {
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i, com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        getRootView().post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.l.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8489h c8489h = View$OnClickListenerC8438l.this.f27734Dg;
                if (c8489h != null) {
                    c8489h.f27876CI = SystemClock.elapsedRealtime() - View$OnClickListenerC8438l.this.mStartTime;
                }
            }
        });
        C8489h c8489h = this.f27734Dg;
        if (c8489h != null) {
            c8489h.m30622a(this);
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.ksad_rotate_layout);
        if (viewStub != null) {
            this.f27762Dw = viewStub.inflate();
        } else {
            this.f27762Dw = findViewById(C9659R.C9662id.ksad_rotate_root);
        }
        this.f27764Dy = (TextView) findViewById(C9659R.C9662id.ksad_rotate_text);
        this.f27765Dz = (TextView) findViewById(C9659R.C9662id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(C9659R.C9662id.ksad_rotate_view);
        this.f27763Dx = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: j */
    protected final void mo30728j(int i, String str) {
        TextView textView = this.f27765Dz;
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
        C10377c c10377c = this.f27760DA;
        if (c10377c != null) {
            c10377c.m26207bj(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lj */
    protected final void mo30727lj() {
        AdTemplate adTemplate = this.f27734Dg.mAdTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.f27761DB = C8474d.m30657a(adTemplate, m25641dQ, this.f27734Dg.mApkDownloadHelper, 1);
        TextView textView = this.f27764Dy;
        if (textView != null) {
            textView.setText(C10484b.m25702dk(m25641dQ));
        }
        TextView textView2 = this.f27765Dz;
        if (textView2 != null) {
            textView2.setText("或点击" + this.f27761DB.m30656ku());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lk */
    protected final void mo30726lk() {
        View view = this.f27762Dw;
        if (view == null || this.f27734Dg == null) {
            return;
        }
        view.setVisibility(0);
        C9908c.m27337b(this.f27734Dg.mAdTemplate, (int) Opcodes.INVOKESTATIC, (JSONObject) null);
        C9279a.m29119sY().m29121aW(Opcodes.INVOKESTATIC);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: ll */
    protected final void mo30725ll() {
        AdMatrixInfo.RotateInfo m25771cU = C10484b.m25771cU(this.f27734Dg.mAdTemplate);
        C10377c c10377c = this.f27760DA;
        if (c10377c == null) {
            C10377c c10377c2 = new C10377c(m25771cU);
            this.f27760DA = c10377c2;
            c10377c2.m26213a(this);
            return;
        }
        c10377c.m26210a(m25771cU);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lm */
    protected final void mo30724lm() {
        C10377c c10377c = this.f27760DA;
        if (c10377c != null) {
            c10377c.m26208bi(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: ln */
    protected final void mo30723ln() {
        C10377c c10377c = this.f27760DA;
        if (c10377c != null) {
            c10377c.m26207bj(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i
    /* renamed from: lo */
    protected final void mo30722lo() {
        this.f27763Dx.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.l.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                View$OnClickListenerC8438l.this.f27763Dx.m30452lo();
            }
        });
    }

    @Override // com.kwad.sdk.core.p402g.InterfaceC10375a
    /* renamed from: lr */
    public final void mo26221lr() {
        C9908c.m27321bN(this.f27734Dg.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f27734Dg.m30618c(1, getContext(), Opcodes.IF_ICMPGE, 1);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.AbstractC8433i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C10331c.m26254d("SplashRotatePresenter", "onUnbind");
        C8489h c8489h = this.f27734Dg;
        if (c8489h != null) {
            c8489h.m30620b(this);
        }
    }
}
