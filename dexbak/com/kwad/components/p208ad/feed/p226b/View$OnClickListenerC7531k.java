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

/* renamed from: com.kwad.components.ad.feed.b.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7531k extends AbstractC7501a implements View.OnClickListener, InterfaceC11145c {

    /* renamed from: eB */
    private TextView f25681eB;

    /* renamed from: eD */
    private ImageView f25682eD;

    /* renamed from: eI */
    private DownloadProgressView f25683eI;

    /* renamed from: fv */
    private RoundAngleImageView f25684fv;
    private C8619c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public View$OnClickListenerC7531k(@NonNull Context context) {
        super(context);
    }

    /* renamed from: be */
    private void m33066be() {
        this.mLogoView.m28912aD(this.mAdTemplate);
        this.f25683eI.m30446ai(this.mAdTemplate);
        C10751a.m24923a(this, this.f25681eB, this.f25684fv, this.f25683eI);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25681eB, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25684fv, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25683eI, this);
        if (C10483a.m25956aF(this.mAdInfo)) {
            C8619c c8619c = new C8619c(this.mAdTemplate, null, this.f25683eI.getAppDownloadListener());
            this.mApkDownloadHelper = c8619c;
            c8619c.m30146d(this.f25683eI.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            m33139bb();
        }
    }

    /* renamed from: c */
    private void m33065c(View view, final int i) {
        if (view == this.f25682eD) {
            m28884tk();
        } else {
            C8615a.m30233a(new C8615a.C8616a(getContext()).m30209al(5).m30207am(i).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30205an(view == this.f25683eI ? 1 : 2).m30202ao(view == this.f25683eI).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.feed.b.k.1
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    View$OnClickListenerC7531k.this.m28893aL(i);
                }
            }));
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        super.mo28891b((View$OnClickListenerC7531k) adResultData);
        this.f25681eB.setText(C7598f.m32829c(this.mAdTemplate));
        List<String> m25879ba = C10483a.m25879ba(this.mAdInfo);
        if (m25879ba.size() > 0) {
            this.f25596ey = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.f25684fv, m25879ba.get(0), this.mAdTemplate, this.f25597ez);
        } else {
            C10331c.m26250e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        m33066be();
        this.f25682eD.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    public final void mo28890bc() {
        this.f25681eB = (TextView) findViewById(C9659R.C9662id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(C9659R.C9662id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(C9659R.C9662id.ksad_ad_image);
        this.f25684fv = roundAngleImageView;
        roundAngleImageView.setRadius(C10751a.m24924a(getContext(), 3.0f));
        this.f25682eD = (ImageView) findViewById(C9659R.C9662id.ksad_ad_dislike);
        this.f25683eI = (DownloadProgressView) findViewById(C9659R.C9662id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bf */
    public final void mo28889bf() {
        super.mo28889bf();
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30148c(this.f25683eI.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    public final int getLayoutId() {
        return C9659R.C9663layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.f25681eB) {
            i = 25;
        } else if (view == this.f25684fv) {
            i = 100;
        } else {
            i = view == this.f25683eI ? 1 : 35;
        }
        m33065c(view, i);
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
            m33065c(view, 153);
        }
    }
}
