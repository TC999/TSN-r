package com.kwad.components.p208ad.feed.p226b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8629d;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.feed.C7598f;
import com.kwad.components.p208ad.feed.FeedDownloadActivityProxy;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* renamed from: com.kwad.components.ad.feed.b.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7530j extends AbstractC7501a implements View.OnClickListener, InterfaceC11145c {

    /* renamed from: eB */
    private TextView f25678eB;

    /* renamed from: eC */
    private ImageView f25679eC;

    /* renamed from: eD */
    private ImageView f25680eD;
    private KsLogoView mLogoView;

    public View$OnClickListenerC7530j(@NonNull Context context) {
        super(context);
    }

    /* renamed from: c */
    private void m33068c(View view, int i) {
        if (view == this.f25680eD) {
            m28884tk();
        } else if (C8629d.m30119a(new C8615a.C8616a(getContext()).m30198aq(this.mAdTemplate), 1) == 1) {
            m28893aL(i);
        } else if (C10483a.m25956aF(this.mAdInfo)) {
            m28893aL(i);
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.abm);
        } else {
            m28893aL(i);
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        onClick(view);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        super.mo28891b((View$OnClickListenerC7530j) adResultData);
        this.f25678eB.setText(C7598f.m32829c(this.mAdTemplate));
        List<String> m25879ba = C10483a.m25879ba(this.mAdInfo);
        this.mLogoView.m28912aD(this.mAdTemplate);
        if (m25879ba.size() > 0) {
            KSImageLoader.loadFeeImage(this.f25679eC, m25879ba.get(0), this.mAdTemplate);
        } else {
            C10331c.m26250e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        C10751a.m24923a(this, this.f25678eB, this.f25679eC, this.f25680eD);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25678eB, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25679eC, this);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25680eD, this);
        setOnClickListener(this);
        if (C10483a.m25956aF(this.mAdInfo)) {
            m33139bb();
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    public final void mo28890bc() {
        ((RatioFrameLayout) findViewById(C9659R.C9662id.ksad_container)).setRatio(0.5600000023841858d);
        this.f25678eB = (TextView) findViewById(C9659R.C9662id.ksad_ad_desc);
        this.f25679eC = (ImageView) findViewById(C9659R.C9662id.ksad_ad_image);
        this.f25680eD = (ImageView) findViewById(C9659R.C9662id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    public final int getLayoutId() {
        return C9659R.C9663layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.f25678eB) {
            i = 25;
        } else {
            i = view == this.f25679eC ? 100 : 35;
        }
        m33068c(view, i);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m33068c(view, 153);
        }
    }
}
