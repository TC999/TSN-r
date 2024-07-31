package com.kwad.components.p208ad.draw.view.playcard;

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
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.p208ad.widget.AppScoreView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardApp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {

    /* renamed from: cx */
    private KsAppDownloadListener f25379cx;

    /* renamed from: dk */
    private InterfaceC7409a f25380dk;

    /* renamed from: dl */
    private ImageView f25381dl;

    /* renamed from: dm */
    private ImageView f25382dm;

    /* renamed from: dn */
    private TextView f25383dn;

    /* renamed from: do */
    private ViewGroup f25384do;

    /* renamed from: dp */
    private AppScoreView f25385dp;

    /* renamed from: dq */
    private TextView f25386dq;

    /* renamed from: dr */
    private TextView f25387dr;

    /* renamed from: ds */
    private KsLogoView f25388ds;

    /* renamed from: dt */
    private DrawDownloadProgressBar f25389dt;

    /* renamed from: du */
    private ValueAnimator f25390du;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private int mHeight;

    /* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardApp$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7409a {
        /* renamed from: av */
        void mo33326av();

        /* renamed from: aw */
        void mo33325aw();
    }

    public DrawCardApp(Context context) {
        super(context);
        m33336B(context);
    }

    /* renamed from: B */
    private void m33336B(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_draw_card_app, this);
        this.f25381dl = (ImageView) findViewById(C9659R.C9662id.ksad_card_app_close);
        this.f25382dm = (ImageView) findViewById(C9659R.C9662id.ksad_card_app_icon);
        this.f25383dn = (TextView) findViewById(C9659R.C9662id.ksad_card_app_name);
        this.f25384do = (ViewGroup) findViewById(C9659R.C9662id.ksad_card_app_score_container);
        this.f25385dp = (AppScoreView) findViewById(C9659R.C9662id.ksad_card_app_score);
        this.f25386dq = (TextView) findViewById(C9659R.C9662id.ksad_card_app_download_count);
        this.f25387dr = (TextView) findViewById(C9659R.C9662id.ksad_card_app_desc);
        this.f25388ds = (KsLogoView) findViewById(C9659R.C9662id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(C9659R.C9662id.ksad_card_app_download_btn);
        this.f25389dt = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = C10751a.m24924a(context, 156.0f);
    }

    /* renamed from: aG */
    private void m33333aG() {
        ValueAnimator valueAnimator = this.f25390du;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f25390du.cancel();
        }
    }

    /* renamed from: aP */
    private void m33331aP() {
        m33328d(this.mHeight, 0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.f25379cx == null) {
            this.f25379cx = new AbstractC10298a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.f25389dt.m33337e(C10483a.m25957aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.f25389dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.f25389dt.m33337e(C10483a.m25882bY(DrawCardApp.this.mAdTemplate), DrawCardApp.this.f25389dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.f25389dt.m33337e(C10483a.m25957aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.f25389dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.f25389dt.m33337e(C10483a.m25933ac(DrawCardApp.this.mAdInfo), DrawCardApp.this.f25389dt.getMax());
                }

                @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    DrawCardApp.this.f25389dt.m33337e(C10483a.m25980Fg(), i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    DrawDownloadProgressBar drawDownloadProgressBar = DrawCardApp.this.f25389dt;
                    drawDownloadProgressBar.m33337e(i + "%", i);
                }
            };
        }
        return this.f25379cx;
    }

    /* renamed from: aO */
    public final void m33332aO() {
        m33328d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f25381dl) {
            m33331aP();
            InterfaceC7409a interfaceC7409a = this.f25380dk;
            if (interfaceC7409a != null) {
                interfaceC7409a.mo33326av();
                return;
            }
            return;
        }
        C8615a.m30233a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30202ao(view == this.f25389dt).m30205an(view == this.f25389dt ? 1 : 2).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                if (DrawCardApp.this.f25380dk != null) {
                    DrawCardApp.this.f25380dk.mo33325aw();
                }
            }
        }));
    }

    public final void release() {
        m33333aG();
        this.mApkDownloadHelper = null;
    }

    /* renamed from: d */
    private void m33328d(int i, int i2) {
        m33333aG();
        ValueAnimator m29528b = C8951n.m29528b(this, i, i2);
        this.f25390du = m29528b;
        m29528b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f25390du.setDuration(300L);
        this.f25390du.start();
    }

    /* renamed from: a */
    public final void m33334a(@NonNull AdTemplate adTemplate, InterfaceC7409a interfaceC7409a) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
        this.f25380dk = interfaceC7409a;
        this.mApkDownloadHelper = new C8619c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.f25382dm, C10483a.m25820cf(this.mAdInfo), adTemplate, 11);
        this.f25383dn.setText(C10483a.m25914av(this.mAdInfo));
        String m25910az = C10483a.m25910az(this.mAdInfo);
        float m25961aA = C10483a.m25961aA(this.mAdInfo);
        boolean z = m25961aA >= 3.0f;
        if (z) {
            this.f25385dp.setScore(m25961aA);
            this.f25385dp.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(m25910az);
        if (z2) {
            this.f25386dq.setText(m25910az);
            this.f25386dq.setVisibility(0);
        }
        if (!z && !z2) {
            this.f25384do.setVisibility(8);
        } else {
            this.f25384do.setVisibility(0);
        }
        this.f25388ds.m28912aD(this.mAdTemplate);
        this.f25387dr.setText(C10483a.m25915au(this.mAdInfo));
        this.f25381dl.setOnClickListener(this);
        this.f25389dt.setOnClickListener(this);
        setOnClickListener(this);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m33336B(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33336B(context);
    }
}
