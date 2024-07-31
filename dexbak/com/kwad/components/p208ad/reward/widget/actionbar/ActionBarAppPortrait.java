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

/* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ActionBarAppPortrait extends LinearLayout implements InterfaceC11145c {

    /* renamed from: Br */
    private AppScoreView f27550Br;

    /* renamed from: Bs */
    private TextProgressBar f27551Bs;

    /* renamed from: Bt */
    private View f27552Bt;

    /* renamed from: Bw */
    private InterfaceC8337a f27553Bw;

    /* renamed from: cx */
    private KsAppDownloadListener f27554cx;

    /* renamed from: dE */
    private ImageView f27555dE;

    /* renamed from: dF */
    private TextView f27556dF;

    /* renamed from: dH */
    private TextView f27557dH;

    /* renamed from: eF */
    private TextView f27558eF;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8337a {
        /* renamed from: N */
        void mo30945N(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f27554cx == null) {
            this.f27554cx = new AbstractC10298a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.f27551Bs.m29709e(C10483a.m25957aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.f27552Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.f27551Bs.m29709e(C10483a.m25882bY(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.f27552Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.f27551Bs.m29709e(C10483a.m25957aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.f27552Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.f27551Bs.m29709e(C10483a.m25933ac(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.f27552Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
                public final void onPaused(int i) {
                    ActionBarAppPortrait.this.f27551Bs.m29709e(C10483a.m25794dn(i), i);
                    ActionBarAppPortrait.this.f27552Bt.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.f27551Bs.m29709e(C10483a.m25795dm(i), i);
                    ActionBarAppPortrait.this.f27552Bt.setVisibility(8);
                }
            };
        }
        return this.f27554cx;
    }

    private void initView() {
        C10887l.inflate(getContext(), C9659R.C9663layout.ksad_video_actionbar_app_portrait, this);
        this.f27555dE = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f27556dF = (TextView) findViewById(C9659R.C9662id.ksad_app_title);
        this.f27558eF = (TextView) findViewById(C9659R.C9662id.ksad_app_desc);
        this.f27550Br = (AppScoreView) findViewById(C9659R.C9662id.ksad_app_score);
        this.f27557dH = (TextView) findViewById(C9659R.C9662id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(C9659R.C9662id.ksad_app_download_btn);
        this.f27551Bs = textProgressBar;
        textProgressBar.setTextDimen(C10751a.m24924a(getContext(), 16.0f));
        this.f27551Bs.setTextColor(-1);
        this.f27552Bt = findViewById(C9659R.C9662id.ksad_download_bar_cover);
    }

    /* renamed from: kh */
    private void m30946kh() {
        String m25910az = C10483a.m25910az(this.mAdInfo);
        boolean z = !TextUtils.isEmpty(m25910az);
        float m25961aA = C10483a.m25961aA(this.mAdInfo);
        boolean z2 = m25961aA >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.f27556dF.getLayoutParams()).bottomMargin = C10751a.m24924a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f27550Br.getLayoutParams()).bottomMargin = C10751a.m24924a(getContext(), 1.0f);
            this.f27557dH.setText(m25910az);
            this.f27557dH.setVisibility(0);
            this.f27550Br.setVisibility(0);
            this.f27550Br.setScore(m25961aA);
            this.f27558eF.setVisibility(8);
        } else if (z) {
            this.f27557dH.setText(m25910az);
            this.f27557dH.setVisibility(0);
            this.f27550Br.setVisibility(8);
            this.f27558eF.setVisibility(8);
        } else if (z2) {
            this.f27557dH.setVisibility(8);
            this.f27550Br.setScore(m25961aA);
            this.f27550Br.setVisibility(0);
            this.f27558eF.setVisibility(8);
        } else {
            this.f27558eF.setText(C10483a.m25915au(this.mAdInfo));
            this.f27557dH.setVisibility(8);
            this.f27550Br.setVisibility(8);
            this.f27558eF.setVisibility(0);
        }
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public final void m30952a(@NonNull AdTemplate adTemplate, @Nullable C8619c c8619c, InterfaceC8337a interfaceC8337a) {
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        this.f27553Bw = interfaceC8337a;
        this.mApkDownloadHelper = c8619c;
        KSImageLoader.loadAppIcon(this.f27555dE, C10483a.m25820cf(m25641dQ), adTemplate, 12);
        this.f27556dF.setText(C10483a.m25823cc(this.mAdInfo));
        m30946kh();
        this.f27551Bs.m29709e(C10483a.m25957aE(this.mAdInfo), 0);
        C8619c c8619c2 = this.mApkDownloadHelper;
        if (c8619c2 != null) {
            c8619c2.m30151b(getAppDownloadListener());
        }
        setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this, this);
        new GestureDetector$OnGestureListenerC11148f(this.f27552Bt, this);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m30951b(view, false);
        }
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    /* renamed from: b */
    private void m30951b(View view, final boolean z) {
        int i = view == this.f27552Bt ? 1 : 2;
        C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30209al(1).m30207am(i).m30202ao(view == this.f27551Bs).m30205an(i).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.f27553Bw != null) {
                    ActionBarAppPortrait.this.f27553Bw.mo30945N(z);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m30951b(view, true);
    }
}
