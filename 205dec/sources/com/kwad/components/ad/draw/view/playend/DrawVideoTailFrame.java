package com.kwad.components.ad.draw.view.playend;

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
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    private KsDrawAd.AdInteractionListener bN;
    @Nullable
    private KsAppDownloadListener cx;
    private AdBaseFrameLayout dB;
    private ImageView dC;
    private ViewGroup dD;
    private ImageView dE;
    private TextView dF;
    private AppScoreView dG;
    private TextView dH;
    private TextView dI;
    private DrawDownloadProgressBar dJ;
    private ViewGroup dK;
    private TextView dL;
    private TextView dM;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    @Nullable
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.dC = (ImageView) findViewById(R.id.ksad_video_cover);
        this.dD = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_name);
        this.dG = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dH = (TextView) findViewById(R.id.ksad_app_download_count);
        this.dI = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.dJ = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.dK = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.dL = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dM = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.bY(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.ac(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dJ.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i4) {
                super.onPaused(i4);
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.Fg(), i4);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.dJ;
                drawDownloadProgressBar.e(i4 + "%", i4);
            }
        };
    }

    public final void aR() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.cx;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.cx = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new a.C0631a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(view == this.dJ ? 1 : 2).ao(view == this.dJ).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.bN != null) {
                    DrawVideoTailFrame.this.bN.onAdClicked();
                }
                com.kwad.sdk.core.adlog.c.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.dB.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.cx) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.dB = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bN = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public final void b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo dQ = e.dQ(adTemplate);
        this.mAdInfo = dQ;
        AdInfo.AdMaterialInfo.MaterialFeature aV = com.kwad.sdk.core.response.b.a.aV(dQ);
        String str = aV.coverUrl;
        this.mLogoView.aD(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i4 = aV.width;
            int i5 = aV.height;
            if (i4 > 0 && i4 > i5) {
                int screenWidth = com.kwad.sdk.d.a.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.dC.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = (int) (screenWidth * (i5 / i4));
            }
            KSImageLoader.loadImage(this.dC, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 11);
            this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
            float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
            if (aA >= 3.0f) {
                this.dG.setScore(aA);
                this.dG.setVisibility(0);
            }
            this.dH.setText(com.kwad.sdk.core.response.b.a.az(this.mAdInfo));
            this.dI.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.dD.setVisibility(0);
            this.dK.setVisibility(8);
        } else {
            this.dL.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.dM.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.dD.setVisibility(8);
            this.dK.setVisibility(0);
        }
        this.dJ.setOnClickListener(this);
        setOnClickListener(this);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        B(context);
    }
}
