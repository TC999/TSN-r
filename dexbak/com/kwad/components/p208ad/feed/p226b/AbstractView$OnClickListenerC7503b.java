package com.kwad.components.p208ad.feed.p226b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.feed.C7598f;
import com.kwad.components.p208ad.widget.DownloadProgressView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* renamed from: com.kwad.components.ad.feed.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractView$OnClickListenerC7503b extends AbstractC7501a implements View.OnClickListener, InterfaceC11145c {

    /* renamed from: dE */
    protected ImageView f25599dE;

    /* renamed from: dF */
    protected TextView f25600dF;

    /* renamed from: dM */
    private TextView f25601dM;

    /* renamed from: eB */
    protected TextView f25602eB;

    /* renamed from: eC */
    protected ImageView f25603eC;

    /* renamed from: eD */
    protected ImageView f25604eD;

    /* renamed from: eE */
    protected RatioFrameLayout f25605eE;

    /* renamed from: eF */
    protected TextView f25606eF;

    /* renamed from: eG */
    private TextView f25607eG;

    /* renamed from: eH */
    private View f25608eH;

    /* renamed from: eI */
    protected DownloadProgressView f25609eI;
    protected C8619c mApkDownloadHelper;
    protected KsLogoView mLogoView;

    public AbstractView$OnClickListenerC7503b(@NonNull Context context) {
        super(context);
    }

    /* renamed from: bd */
    private void m33134bd() {
        findViewById(C9659R.C9662id.ksad_ad_h5_container).setVisibility(0);
        findViewById(C9659R.C9662id.ksad_ad_download_container).setVisibility(8);
        this.f25607eG = (TextView) findViewById(C9659R.C9662id.ksad_h5_desc);
        this.f25601dM = (TextView) findViewById(C9659R.C9662id.ksad_h5_open_btn);
        this.f25608eH = findViewById(C9659R.C9662id.ksad_h5_open_cover);
        this.f25607eG.setText(C7598f.m32829c(this.mAdTemplate));
        this.f25601dM.setText(C10483a.m25957aE(this.mAdInfo));
        this.f25608eH.setOnClickListener(this);
        this.f25607eG.setOnClickListener(this);
        this.f25601dM.setOnClickListener(this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25608eH, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25607eG, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25601dM, this);
    }

    /* renamed from: be */
    private void m33133be() {
        findViewById(C9659R.C9662id.ksad_ad_download_container).setVisibility(0);
        findViewById(C9659R.C9662id.ksad_ad_h5_container).setVisibility(8);
        this.f25599dE = (ImageView) findViewById(C9659R.C9662id.ksad_app_icon);
        this.f25600dF = (TextView) findViewById(C9659R.C9662id.ksad_app_title);
        TextView textView = (TextView) findViewById(C9659R.C9662id.ksad_app_desc);
        this.f25606eF = textView;
        C10751a.m24923a(this, this.f25599dE, this.f25600dF, textView);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25599dE, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25600dF, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25606eF, this);
        this.f25600dF.setText(C10483a.m25914av(this.mAdInfo));
        this.f25599dE.setImageResource(C9659R.C9661drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.f25599dE, C10483a.m25820cf(this.mAdInfo), this.mAdTemplate, 8);
        this.f25606eF.setText(C7598f.m32829c(this.mAdTemplate));
        m33139bb();
        this.f25609eI.m30446ai(this.mAdTemplate);
        this.f25609eI.setOnClickListener(this);
        C8619c c8619c = new C8619c(this.mAdTemplate, null, this.f25609eI.getAppDownloadListener());
        this.mApkDownloadHelper = c8619c;
        c8619c.m30146d(this.f25609eI.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25609eI, this);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    public final void mo28890bc() {
        this.f25602eB = (TextView) findViewById(C9659R.C9662id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(C9659R.C9662id.ksad_image_container);
        this.f25605eE = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.f25603eC = (ImageView) findViewById(C9659R.C9662id.ksad_ad_image);
        this.f25604eD = (ImageView) findViewById(C9659R.C9662id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_dislike_logo);
        this.f25609eI = (DownloadProgressView) findViewById(C9659R.C9662id.ksad_app_download_btn);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bf */
    public final void mo28889bf() {
        super.mo28889bf();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30148c(this.f25609eI.getAppDownloadListener());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view == this.f25602eB) {
            i = 25;
        } else if (view == this.f25603eC) {
            i = 100;
        } else if (view == this.f25609eI || view == this.f25601dM || view == this.f25608eH) {
            i = 1;
        } else if (view == this.f25599dE) {
            i = 13;
        } else if (view == this.f25600dF) {
            i = 14;
        } else {
            i = (view == this.f25606eF || view == this.f25607eG) ? 101 : 35;
        }
        m33138a(view, i);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        super.mo28891b((AbstractView$OnClickListenerC7503b) adResultData);
        this.f25602eB.setText(C7598f.m32829c(this.mAdTemplate));
        this.mLogoView.m28912aD(this.mAdTemplate);
        this.f25603eC.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                AdInfo m25641dQ = C10487e.m25641dQ(AbstractView$OnClickListenerC7503b.this.mAdTemplate);
                if (C10483a.m25941aU(m25641dQ).height > C10483a.m25941aU(m25641dQ).width) {
                    ViewGroup.LayoutParams layoutParams = AbstractView$OnClickListenerC7503b.this.f25605eE.getLayoutParams();
                    layoutParams.width = AbstractView$OnClickListenerC7503b.this.getWidth() / 2;
                    AbstractView$OnClickListenerC7503b.this.f25605eE.setRatio(1.7857142686843872d);
                    AbstractView$OnClickListenerC7503b.this.f25605eE.setLayoutParams(layoutParams);
                }
                List<String> m25879ba = C10483a.m25879ba(AbstractView$OnClickListenerC7503b.this.mAdInfo);
                if (m25879ba.size() > 0) {
                    KSImageLoader.loadFeeImage(AbstractView$OnClickListenerC7503b.this.f25603eC, m25879ba.get(0), AbstractView$OnClickListenerC7503b.this.mAdTemplate, AbstractView$OnClickListenerC7503b.this.f25597ez);
                } else {
                    C10331c.m26250e("BaseFeedTextImageView", "getImageUrlList size less than one");
                }
            }
        });
        if (C10483a.m25956aF(this.mAdInfo)) {
            m33133be();
        } else {
            m33134bd();
        }
        C10751a.m24923a(this, this.f25602eB, this.f25603eC, this.f25604eD);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25602eB, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25603eC, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25604eD, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        onClick(view);
    }

    /* renamed from: a */
    private void m33138a(View view, final int i) {
        if (view == this.f25604eD) {
            m28884tk();
            return;
        }
        m33140ba();
        C8615a.m30233a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30209al(5).m30207am(i).m30189b(this.mApkDownloadHelper).m30205an(view == this.f25609eI ? 1 : 2).m30202ao(view == this.f25609eI).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.b.2
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                AbstractView$OnClickListenerC7503b.this.m28893aL(i);
            }
        }));
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m33138a(view, 153);
        }
    }
}
