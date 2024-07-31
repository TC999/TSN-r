package com.kwad.components.p208ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.p208ad.interstitial.AlertDialogC7725d;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.components.p208ad.interstitial.p245g.C7796c;
import com.kwad.components.p208ad.interstitial.report.C7802a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7693a extends PagerAdapter {

    /* renamed from: dU */
    private final KsAdVideoPlayConfig f26057dU;

    /* renamed from: ie */
    private final KsInterstitialAd.AdInteractionListener f26058ie;

    /* renamed from: im */
    private final List<AdResultData> f26059im = new ArrayList();

    /* renamed from: io */
    private final AlertDialogC7725d f26060io;

    /* renamed from: iq */
    private final boolean f26061iq;

    /* renamed from: ir */
    private InterfaceC7696b f26062ir;

    /* renamed from: is */
    private InterfaceC7695a f26063is;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7695a {
        /* renamed from: cp */
        void mo32590cp();
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7696b {
        /* renamed from: a */
        void mo32591a(C7796c c7796c, int i);
    }

    public C7693a(AdResultData adResultData, AlertDialogC7725d alertDialogC7725d, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f26060io = alertDialogC7725d;
        this.f26057dU = ksAdVideoPlayConfig;
        this.f26058ie = adInteractionListener;
        this.f26061iq = C10483a.m25807cs(C10487e.m25641dQ(C10485c.m25661n(adResultData))) == 1;
    }

    /* renamed from: d */
    public final void m32622d(List<AdResultData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f26059im.clear();
        this.f26059im.addAll(list);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f26059im.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, final int i) {
        C7796c c7796c = new C7796c(viewGroup.getContext());
        viewGroup.addView(c7796c);
        c7796c.setAggregateAdView(i > 0);
        if (i == 0) {
            c7796c.setAdConvertListener(new C7761c.InterfaceC7768a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
                @Override // com.kwad.components.p208ad.interstitial.p242e.C7761c.InterfaceC7768a
                /* renamed from: b */
                public final void mo32411b(long j, long j2) {
                    AdResultData adResultData = (AdResultData) C7693a.this.f26059im.get(i);
                    if (adResultData == null) {
                        return;
                    }
                    C7802a.m32299dM().m32300b(C10485c.m25661n(adResultData), j, j2);
                    if (C7693a.this.f26063is != null) {
                        C7693a.this.f26063is.mo32590cp();
                    }
                }
            });
        }
        if (i > 0) {
            if (i == 1) {
                c7796c.setAggregateShowTriggerType(this.f26061iq ? 8 : 7);
            } else {
                c7796c.setAggregateShowTriggerType(7);
            }
        }
        c7796c.mo32360a(this.f26059im.get(i), this.f26060io, this.f26057dU, this.f26058ie);
        InterfaceC7696b interfaceC7696b = this.f26062ir;
        if (interfaceC7696b != null) {
            interfaceC7696b.mo32591a(c7796c, i);
        }
        return c7796c;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    /* renamed from: a */
    public final void m32625a(InterfaceC7696b interfaceC7696b) {
        this.f26062ir = interfaceC7696b;
    }

    /* renamed from: a */
    public final void m32626a(InterfaceC7695a interfaceC7695a) {
        this.f26063is = interfaceC7695a;
    }
}
