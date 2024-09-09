package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener cx;
    private a dk;
    private ImageView dl;
    private ImageView dm;
    private TextView dn;

    /* renamed from: do  reason: not valid java name */
    private ViewGroup f0do;
    private AppScoreView dp;
    private TextView dq;
    private TextView dr;
    private KsLogoView ds;
    private DrawDownloadProgressBar dt;
    private ValueAnimator du;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private int mHeight;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void av();

        void aw();
    }

    public DrawCardApp(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.ksad_draw_card_app, this);
        this.dl = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.dm = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.dn = (TextView) findViewById(R.id.ksad_card_app_name);
        this.f0do = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.dp = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.dq = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.dr = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.ds = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.dt = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.d.a.a.a(context, 156.0f);
    }

    private void aG() {
        ValueAnimator valueAnimator = this.du;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.du.cancel();
        }
    }

    private void aP() {
        d(this.mHeight, 0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.bY(DrawCardApp.this.mAdTemplate), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.ac(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i4) {
                    super.onPaused(i4);
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.Fg(), i4);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i4) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.dt;
                    drawDownloadProgressBar.e(i4 + "%", i4);
                }
            };
        }
        return this.cx;
    }

    public final void aO() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dl) {
            aP();
            a aVar = this.dk;
            if (aVar != null) {
                aVar.av();
                return;
            }
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0631a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.dt).an(view == this.dt ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardApp.this.dk != null) {
                    DrawCardApp.this.dk.aw();
                }
            }
        }));
    }

    public final void release() {
        aG();
        this.mApkDownloadHelper = null;
    }

    private void d(int i4, int i5) {
        aG();
        ValueAnimator b4 = n.b(this, i4, i5);
        this.du = b4;
        b4.setInterpolator(new DecelerateInterpolator(2.0f));
        this.du.setDuration(300L);
        this.du.start();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dQ(adTemplate);
        this.dk = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.dm, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), adTemplate, 11);
        this.dn.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z3 = aA >= 3.0f;
        if (z3) {
            this.dp.setScore(aA);
            this.dp.setVisibility(0);
        }
        boolean z4 = !TextUtils.isEmpty(az);
        if (z4) {
            this.dq.setText(az);
            this.dq.setVisibility(0);
        }
        if (!z3 && !z4) {
            this.f0do.setVisibility(8);
        } else {
            this.f0do.setVisibility(0);
        }
        this.ds.aD(this.mAdTemplate);
        this.dr.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.dl.setOnClickListener(this);
        this.dt.setOnClickListener(this);
        setOnClickListener(this);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        B(context);
    }
}
