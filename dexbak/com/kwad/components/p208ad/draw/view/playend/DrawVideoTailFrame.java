package com.kwad.components.p208ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.p208ad.widget.AppScoreView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {

    /* renamed from: bN */
    private KsDrawAd.AdInteractionListener f25399bN;
    @Nullable

    /* renamed from: cx */
    private KsAppDownloadListener f25400cx;

    /* renamed from: dB */
    private AdBaseFrameLayout f25401dB;

    /* renamed from: dC */
    private ImageView f25402dC;

    /* renamed from: dD */
    private ViewGroup f25403dD;

    /* renamed from: dE */
    private ImageView f25404dE;

    /* renamed from: dF */
    private TextView f25405dF;

    /* renamed from: dG */
    private AppScoreView f25406dG;

    /* renamed from: dH */
    private TextView f25407dH;

    /* renamed from: dI */
    private TextView f25408dI;

    /* renamed from: dJ */
    private DrawDownloadProgressBar f25409dJ;

    /* renamed from: dK */
    private ViewGroup f25410dK;

    /* renamed from: dL */
    private TextView f25411dL;

    /* renamed from: dM */
    private TextView f25412dM;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    @Nullable
    private C8619c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        m33315B(context);
    }

    /* renamed from: B */
    private void m33315B(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_draw_video_tailframe, this);
        this.f25402dC = (ImageView) findViewById(C9659R.C9662id.ksad_video_cover);
        this.f25403dD = (ViewGroup) findViewById(C9659R.C9662id.ksad_app_container);
        this.f25404dE = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f25405dF = (TextView) findViewById(C9659R.C9662id.ksad_app_name);
        this.f25406dG = (AppScoreView) findViewById(C9659R.C9662id.ksad_app_score);
        this.f25407dH = (TextView) findViewById(C9659R.C9662id.ksad_app_download_count);
        this.f25408dI = (TextView) findViewById(C9659R.C9662id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(C9659R.C9662id.ksad_app_download_btn);
        this.f25409dJ = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.f25410dK = (ViewGroup) findViewById(C9659R.C9662id.ksad_h5_container);
        this.f25411dL = (TextView) findViewById(C9659R.C9662id.ksad_h5_ad_desc);
        this.f25412dM = (TextView) findViewById(C9659R.C9662id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new AbstractC10298a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.f25409dJ.m33337e(C10483a.m25957aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.f25409dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.f25409dJ.m33337e(C10483a.m25882bY(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.f25409dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.f25409dJ.m33337e(C10483a.m25957aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.f25409dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.f25409dJ.m33337e(C10483a.m25933ac(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.f25409dJ.getMax());
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                super.onPaused(i);
                DrawVideoTailFrame.this.f25409dJ.m33337e(C10483a.m25980Fg(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.f25409dJ;
                drawDownloadProgressBar.m33337e(i + "%", i);
            }
        };
    }

    /* renamed from: aR */
    public final void m33313aR() {
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f25400cx;
            if (ksAppDownloadListener != null) {
                c8619c.m30146d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.f25400cx = appDownloadListener;
            this.mApkDownloadHelper.m30151b(appDownloadListener);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C8615a.m30233a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30205an(view == this.f25409dJ ? 1 : 2).m30202ao(view == this.f25409dJ).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.f25399bN != null) {
                    DrawVideoTailFrame.this.f25399bN.onAdClicked();
                }
                C9908c.m27349a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.f25401dB.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c == null || (ksAppDownloadListener = this.f25400cx) == null) {
            return;
        }
        c8619c.m30148c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f25401dB = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f25399bN = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable C8619c c8619c) {
        this.mApkDownloadHelper = c8619c;
    }

    /* renamed from: b */
    public final void m33311b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        AdInfo.AdMaterialInfo.MaterialFeature m25940aV = C10483a.m25940aV(m25641dQ);
        String str = m25940aV.coverUrl;
        this.mLogoView.m28912aD(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = m25940aV.width;
            int i2 = m25940aV.height;
            if (i > 0 && i > i2) {
                int screenWidth = C10751a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.f25402dC.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = (int) (screenWidth * (i2 / i));
            }
            KSImageLoader.loadImage(this.f25402dC, str, this.mAdTemplate);
        }
        if (C10483a.m25956aF(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.f25404dE, C10483a.m25820cf(this.mAdInfo), this.mAdTemplate, 11);
            this.f25405dF.setText(C10483a.m25914av(this.mAdInfo));
            float m25961aA = C10483a.m25961aA(this.mAdInfo);
            if (m25961aA >= 3.0f) {
                this.f25406dG.setScore(m25961aA);
                this.f25406dG.setVisibility(0);
            }
            this.f25407dH.setText(C10483a.m25910az(this.mAdInfo));
            this.f25408dI.setText(C10483a.m25915au(this.mAdInfo));
            this.f25403dD.setVisibility(0);
            this.f25410dK.setVisibility(8);
        } else {
            this.f25411dL.setText(C10483a.m25915au(this.mAdInfo));
            this.f25412dM.setText(C10483a.m25957aE(this.mAdInfo));
            this.f25403dD.setVisibility(8);
            this.f25410dK.setVisibility(0);
        }
        this.f25409dJ.setOnClickListener(this);
        setOnClickListener(this);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m33315B(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33315B(context);
    }
}
