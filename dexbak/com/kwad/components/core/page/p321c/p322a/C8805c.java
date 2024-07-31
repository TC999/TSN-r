package com.kwad.components.core.page.p321c.p322a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.p208ad.p210b.InterfaceC7349g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.page.c.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8805c extends AbstractC8803a {

    /* renamed from: OP */
    private LinearLayout f28557OP;

    /* renamed from: OQ */
    private TextView f28558OQ;

    /* renamed from: OR */
    private TextView f28559OR;

    /* renamed from: OS */
    private TextView f28560OS;

    /* renamed from: OT */
    private TextView f28561OT;

    /* renamed from: OU */
    private int f28562OU;

    /* renamed from: OV */
    private boolean f28563OV = false;

    /* renamed from: OW */
    private boolean f28564OW = false;

    /* renamed from: OX */
    private Runnable f28565OX = new Runnable() { // from class: com.kwad.components.core.page.c.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (C8805c.this.f28563OV) {
                C11064bn.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (C8805c.this.f28562OU <= 0) {
                C8805c.this.f28558OQ.setText("任务已完成");
                C8805c.this.f28559OR.setVisibility(8);
                C8805c.this.f28560OS.setVisibility(8);
                C8805c.this.f28561OT.setVisibility(8);
                InterfaceC7349g interfaceC7349g = (InterfaceC7349g) C9861c.m27501f(InterfaceC7349g.class);
                if (interfaceC7349g != null && !C8805c.this.f28564OW) {
                    interfaceC7349g.notifyRewardVerify();
                }
            } else {
                C8805c.this.m29812pw();
                C11064bn.runOnUiThreadDelay(this, 1000L);
            }
            C8805c.m29814i(C8805c.this);
        }
    };

    /* renamed from: wT */
    private final InterfaceC10246c f28566wT = new AbstractC10247d() { // from class: com.kwad.components.core.page.c.a.c.2
        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: onActivityPaused */
        public final void mo26607c(Activity activity) {
            super.mo26607c(activity);
            C8805c.this.f28563OV = true;
        }

        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        /* renamed from: onActivityResumed */
        public final void mo26606d(Activity activity) {
            super.mo26606d(activity);
            C8805c.this.f28563OV = false;
        }
    };

    /* renamed from: i */
    static /* synthetic */ int m29814i(C8805c c8805c) {
        int i = c8805c.f28562OU;
        c8805c.f28562OU = i - 1;
        return i;
    }

    /* renamed from: pv */
    private void m29813pv() {
        this.f28557OP.setVisibility(0);
        if (this.f28548OH.mAdTemplate.mRewardVerifyCalled) {
            this.f28558OQ.setText("任务已完成");
            this.f28559OR.setVisibility(8);
            this.f28560OS.setVisibility(8);
            this.f28561OT.setVisibility(8);
            return;
        }
        m29812pw();
        C11064bn.runOnUiThreadDelay(this.f28565OX, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pw */
    public void m29812pw() {
        this.f28559OR.setText(m29811px());
        this.f28561OT.setText(m29810py());
    }

    /* renamed from: px */
    private String m29811px() {
        int i = this.f28562OU / 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    /* renamed from: py */
    private String m29810py() {
        int i = this.f28562OU % 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    @Override // com.kwad.components.core.page.p321c.p322a.AbstractC8803a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C10232b.m26625DD();
        C10232b.m26622a(this.f28566wT);
        this.f28562OU = C10251d.m26548Cg();
        m29813pv();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f28557OP = (LinearLayout) findViewById(C9659R.C9662id.ksad_reward_land_page_open_tip);
        this.f28558OQ = (TextView) findViewById(C9659R.C9662id.ksad_reward_land_page_open_desc);
        this.f28559OR = (TextView) findViewById(C9659R.C9662id.ksad_reward_land_page_open_minute);
        this.f28560OS = (TextView) findViewById(C9659R.C9662id.ksad_reward_land_page_open_colon);
        this.f28561OT = (TextView) findViewById(C9659R.C9662id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C10232b.m26625DD();
        C10232b.m26621b(this.f28566wT);
        C11064bn.m23858c(this.f28565OX);
    }
}
