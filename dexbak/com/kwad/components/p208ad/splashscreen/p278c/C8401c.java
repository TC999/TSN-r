package com.kwad.components.p208ad.splashscreen.p278c;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.p208ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.p208ad.splashscreen.monitor.C8495a;
import com.kwad.components.p208ad.splashscreen.p283e.C8478a;
import com.kwad.components.p208ad.splashscreen.p284f.C8486c;
import com.kwad.components.p208ad.splashscreen.widget.InterfaceC8512a;
import com.kwad.components.p208ad.splashscreen.widget.SkipView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11063bm;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8401c extends C8421e implements InterfaceC10385c {

    /* renamed from: CY */
    private TextView f27705CY;

    /* renamed from: CZ */
    private InterfaceC8512a f27706CZ;

    /* renamed from: Da */
    private AdInfo.AdPreloadInfo f27707Da;

    /* renamed from: Db */
    private boolean f27708Db = false;

    /* renamed from: Dc */
    private View f27709Dc;

    /* renamed from: sd */
    private AdInfo f27710sd;

    /* renamed from: kW */
    private SplashSkipViewModel m30785kW() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        AdInfo adInfo = this.f27710sd;
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        int i = adSplashInfo.imageDisplaySecond;
        if (i <= 0) {
            i = 5;
        }
        int min = Math.min(adSplashInfo.videoDisplaySecond, C10483a.m25976L(adInfo));
        if (C10483a.m25877bc(this.f27710sd)) {
            i = min;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kX */
    public void m30784kX() {
        C8495a.m30585kT().m30584l(this.f27734Dg.mAdTemplate);
        this.f27734Dg.m30602kO();
        JSONObject jSONObject = new JSONObject();
        C8478a c8478a = this.f27734Dg.f27879Cq;
        if (c8478a != null) {
            try {
                jSONObject.put("duration", c8478a.getCurrentPosition());
            } catch (JSONException e) {
                C10331c.printStackTrace(e);
            }
        }
        C9893a.C9894a c9894a = new C9893a.C9894a();
        C11063bm c11063bm = this.f27734Dg.mTimerHelper;
        if (c11063bm != null) {
            c9894a.duration = c11063bm.getTime();
        }
        C9908c.m27334b(this.f27734Dg.mAdTemplate, new C9913b().m27265cL(1).m27257cT(22).m27268b(c9894a), jSONObject);
    }

    /* renamed from: kZ */
    private synchronized void m30782kZ() {
        if (!this.f27708Db && this.f27706CZ != null) {
            if (C10483a.m25802cx(this.f27710sd) && C10483a.m25801cy(this.f27710sd)) {
                C9908c.m27337b(this.f27734Dg.mAdTemplate, 124, (JSONObject) null);
                this.f27708Db = true;
            }
        }
    }

    /* renamed from: t */
    private void m30781t(AdInfo adInfo) {
        findViewById(C8486c.m30630z(adInfo) ? C9659R.C9662id.ksad_splash_right_top_root : C9659R.C9662id.ksad_splash_left_top_root).setVisibility(0);
    }

    /* renamed from: u */
    private static boolean m30780u(AdInfo adInfo) {
        return !C10483a.m25804cv(adInfo);
    }

    /* renamed from: v */
    private void m30779v(AdInfo adInfo) {
        this.f27705CY = (TextView) findViewById(C8486c.m30630z(adInfo) ? C9659R.C9662id.ksad_splash_preload_right_tips : C9659R.C9662id.ksad_splash_preload_left_tips);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.f27707Da = adPreloadInfo;
        if (adPreloadInfo != null && !C11053bg.isNullString(adPreloadInfo.preloadTips)) {
            this.f27705CY.setVisibility(0);
            this.f27705CY.setText(this.f27707Da.preloadTips);
            return;
        }
        this.f27705CY.setVisibility(8);
    }

    /* renamed from: w */
    private void m30778w(AdInfo adInfo) {
        this.f27709Dc = findViewById(C9659R.C9662id.ksad_skip_view_area);
        if (C10483a.m25803cw(adInfo) && adInfo.adSplashInfo.skipButtonPosition == 0) {
            this.f27709Dc.setVisibility(0);
            this.f27709Dc.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C8401c.this.m30784kX();
                }
            });
            this.f27709Dc.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.3
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    ((View) C8401c.this.f27706CZ).post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.3.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            int mo30461aa = C8401c.this.f27706CZ.mo30461aa(35);
                            ViewGroup.LayoutParams layoutParams = C8401c.this.f27709Dc.getLayoutParams();
                            layoutParams.width = mo30461aa + C10751a.m24924a(C8401c.this.f27734Dg.mRootContainer.getContext(), 66.0f);
                            C8401c.this.f27709Dc.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
            return;
        }
        this.f27709Dc.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        C10331c.m26254d("SkipAdPresenter", "onPageVisible");
        this.f27706CZ.mo30463B(this.f27710sd);
        m30782kZ();
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C10331c.m26254d("SkipAdPresenter", "onPageInvisible");
        this.f27706CZ.mo30464A(this.f27710sd);
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C10331c.m26254d("SkipAdPresenter", "onBind");
        AdInfo m25641dQ = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        this.f27710sd = m25641dQ;
        m30781t(m25641dQ);
        m30779v(this.f27710sd);
        if (m30780u(this.f27710sd)) {
            this.f27706CZ = (InterfaceC8512a) findViewById(C8486c.m30630z(this.f27710sd) ? C9659R.C9662id.ksad_splash_skip_right_view : C9659R.C9662id.ksad_splash_skip_left_view);
        } else {
            this.f27706CZ = (InterfaceC8512a) findViewById(C8486c.m30630z(this.f27710sd) ? C9659R.C9662id.ksad_splash_circle_skip_right_view : C9659R.C9662id.ksad_splash_circle_skip_left_view);
        }
        this.f27706CZ.mo30462a(m30785kW(), this.f27710sd);
        this.f27706CZ.setOnViewListener(new SkipView.InterfaceC8510a() { // from class: com.kwad.components.ad.splashscreen.c.c.1
            @Override // com.kwad.components.p208ad.splashscreen.widget.SkipView.InterfaceC8510a
            /* renamed from: Y */
            public final void mo30483Y(int i) {
                C8401c.this.f27734Dg.m30625X(i);
            }

            @Override // com.kwad.components.p208ad.splashscreen.widget.SkipView.InterfaceC8510a
            /* renamed from: la */
            public final void mo30482la() {
                C8401c.this.m30784kX();
            }

            @Override // com.kwad.components.p208ad.splashscreen.widget.SkipView.InterfaceC8510a
            /* renamed from: lb */
            public final void mo30481lb() {
                C8401c.this.m30783kY();
            }
        });
        m30778w(this.f27710sd);
        this.f27734Dg.f27881Cs.mo26187a(this);
    }

    /* renamed from: kY */
    public final void m30783kY() {
        this.f27734Dg.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.c.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (AlertDialogC8602b.m30267nr()) {
                    C8401c.this.f27734Dg.mRootContainer.postDelayed(this, 1000L);
                } else {
                    C8401c.this.f27734Dg.m30604kM();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27734Dg.f27881Cs.mo26186b(this);
        this.f27706CZ.mo30460bf();
    }
}
