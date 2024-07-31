package com.kwad.components.p208ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.p208ad.widget.AppScoreView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;

/* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ActionBarAppLandscape extends LinearLayout implements InterfaceC11145c {

    /* renamed from: Br */
    private AppScoreView f27538Br;

    /* renamed from: Bs */
    private TextProgressBar f27539Bs;

    /* renamed from: Bt */
    private View f27540Bt;

    /* renamed from: Bu */
    private InterfaceC8334a f27541Bu;

    /* renamed from: cx */
    private KsAppDownloadListener f27542cx;

    /* renamed from: dE */
    private ImageView f27543dE;

    /* renamed from: dF */
    private TextView f27544dF;

    /* renamed from: dH */
    private TextView f27545dH;

    /* renamed from: eF */
    private TextView f27546eF;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8334a {
        /* renamed from: N */
        void mo30954N(boolean z);
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f27542cx == null) {
            this.f27542cx = new AbstractC10298a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.f27539Bs.m29709e(C10483a.m25957aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.f27540Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.f27539Bs.m29709e(C10483a.m25882bY(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.f27540Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.f27539Bs.m29709e(C10483a.m25957aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.f27540Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.f27539Bs.m29709e(C10483a.m25933ac(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.f27540Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
                public final void onPaused(int i) {
                    ActionBarAppLandscape.this.f27539Bs.m29709e(C10483a.m25794dn(i), i);
                    ActionBarAppLandscape.this.f27540Bt.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.f27539Bs.m29709e(C10483a.m25795dm(i), i);
                    ActionBarAppLandscape.this.f27540Bt.setVisibility(8);
                }
            };
        }
        return this.f27542cx;
    }

    private void initView() {
        C10887l.inflate(getContext(), C9659R.C9663layout.ksad_video_actionbar_app_landscape, this);
        this.f27543dE = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f27544dF = (TextView) findViewById(C9659R.C9662id.ksad_app_title);
        this.f27546eF = (TextView) findViewById(C9659R.C9662id.ksad_app_desc);
        this.f27538Br = (AppScoreView) findViewById(C9659R.C9662id.ksad_app_score);
        this.f27545dH = (TextView) findViewById(C9659R.C9662id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(C9659R.C9662id.ksad_app_download_btn);
        this.f27539Bs = textProgressBar;
        textProgressBar.setTextDimen(C10751a.m24924a(getContext(), 16.0f));
        this.f27539Bs.setTextColor(-1);
        this.f27540Bt = findViewById(C9659R.C9662id.ksad_download_bar_cover);
    }

    /* renamed from: kh */
    private void m30955kh() {
        float m25961aA = C10483a.m25961aA(this.mAdInfo);
        boolean z = m25961aA >= 3.0f;
        if (z) {
            this.f27538Br.setScore(m25961aA);
            this.f27538Br.setVisibility(0);
        }
        String m25910az = C10483a.m25910az(this.mAdInfo);
        boolean isEmpty = true ^ TextUtils.isEmpty(m25910az);
        if (isEmpty) {
            this.f27545dH.setText(m25910az);
            this.f27545dH.setVisibility(0);
        }
        if (!isEmpty && !z) {
            this.f27546eF.setText(C10483a.m25915au(this.mAdInfo));
            this.f27538Br.setVisibility(8);
            this.f27545dH.setVisibility(8);
            this.f27546eF.setVisibility(0);
            return;
        }
        this.f27546eF.setVisibility(8);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public final void m30961a(@NonNull AdTemplate adTemplate, @Nullable C8619c c8619c, InterfaceC8334a interfaceC8334a) {
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        this.f27541Bu = interfaceC8334a;
        this.mApkDownloadHelper = c8619c;
        KSImageLoader.loadAppIcon(this.f27543dE, C10483a.m25820cf(m25641dQ), adTemplate, 12);
        this.f27544dF.setText(C10483a.m25823cc(this.mAdInfo));
        m30955kh();
        this.f27539Bs.m29709e(C10483a.m25957aE(this.mAdInfo), 0);
        C8619c c8619c2 = this.mApkDownloadHelper;
        if (c8619c2 != null) {
            c8619c2.m30151b(getAppDownloadListener());
        }
        setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this, this);
        new GestureDetector$OnGestureListenerC11148f(this.f27540Bt, this);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m30960b(view, false);
        }
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    /* renamed from: b */
    private void m30960b(View view, final boolean z) {
        C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30202ao(view == this.f27539Bs).m30205an(view == this.f27540Bt ? 1 : 2).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.f27541Bu != null) {
                    ActionBarAppLandscape.this.f27541Bu.mo30954N(z);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m30960b(view, true);
    }
}
