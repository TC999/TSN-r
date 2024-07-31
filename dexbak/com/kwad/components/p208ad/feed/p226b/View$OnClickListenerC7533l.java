package com.kwad.components.p208ad.feed.p226b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
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
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* renamed from: com.kwad.components.ad.feed.b.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7533l extends AbstractC7501a implements View.OnClickListener, InterfaceC11145c {

    /* renamed from: eB */
    private TextView f25687eB;

    /* renamed from: eD */
    private ImageView f25688eD;

    /* renamed from: eI */
    private DownloadProgressView f25689eI;

    /* renamed from: ey */
    private long f25690ey;

    /* renamed from: fv */
    private RoundAngleImageView f25691fv;
    private C8619c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public View$OnClickListenerC7533l(@NonNull Context context) {
        super(context);
    }

    /* renamed from: be */
    private void m33063be() {
        this.mLogoView.m28912aD(this.mAdTemplate);
        this.f25689eI.m30446ai(this.mAdTemplate);
        this.f25689eI.setOnClickListener(this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25689eI, this);
        if (C10483a.m25956aF(this.mAdInfo)) {
            C8619c c8619c = new C8619c(this.mAdTemplate, null, this.f25689eI.getAppDownloadListener());
            this.mApkDownloadHelper = c8619c;
            c8619c.m30146d(this.f25689eI.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            m33139bb();
        }
    }

    /* renamed from: c */
    private void m33062c(View view, final int i) {
        if (view == this.f25688eD) {
            m28884tk();
        } else {
            C8615a.m30233a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate).m30209al(5).m30207am(i).m30189b(this.mApkDownloadHelper).m30205an(view == this.f25689eI ? 1 : 2).m30202ao(view == this.f25689eI).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.l.1
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    View$OnClickListenerC7533l.this.m28893aL(i);
                }
            }));
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        super.mo28891b((View$OnClickListenerC7533l) adResultData);
        this.f25687eB.setText(C7598f.m32829c(this.mAdTemplate));
        List<String> m25879ba = C10483a.m25879ba(this.mAdInfo);
        if (m25879ba.size() > 0) {
            this.f25690ey = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.f25691fv, m25879ba.get(0), this.mAdTemplate, this.f25597ez);
        } else {
            C10331c.m26250e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        m33063be();
        C10751a.m24923a(this, this.f25687eB, this.f25691fv, this.f25689eI, this.f25688eD);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25687eB, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25691fv, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25689eI, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25688eD, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    public final void mo28890bc() {
        this.f25687eB = (TextView) findViewById(C9659R.C9662id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(C9659R.C9662id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(C9659R.C9662id.ksad_ad_image);
        this.f25691fv = roundAngleImageView;
        roundAngleImageView.setRadius(C10751a.m24924a(getContext(), 3.0f));
        this.f25688eD = (ImageView) findViewById(C9659R.C9662id.ksad_ad_dislike);
        this.f25689eI = (DownloadProgressView) findViewById(C9659R.C9662id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bf */
    public final void mo28889bf() {
        super.mo28889bf();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30148c(this.f25689eI.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    public final int getLayoutId() {
        return C9659R.C9663layout.ksad_feed_text_right_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.f25687eB) {
            i = 25;
        } else if (view == this.f25691fv) {
            i = 100;
        } else {
            i = view == this.f25689eI ? 1 : 35;
        }
        m33062c(view, i);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m33062c(view, 153);
        }
    }
}
