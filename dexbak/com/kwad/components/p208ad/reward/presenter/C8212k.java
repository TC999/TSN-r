package com.kwad.components.p208ad.reward.presenter;

import com.kwad.components.core.p301l.p302a.AbstractC8690b;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.p208ad.reward.C7907g;

/* renamed from: com.kwad.components.ad.reward.presenter.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8212k extends C8094b {

    /* renamed from: sm */
    private final AdLiveCallerContextListener f27169sm = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return C7907g.m32031b(C8212k.this.f26957qo);
        }
    };

    /* renamed from: sn */
    private final InterfaceC8689a f27170sn = new AbstractC8690b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.p301l.p302a.AbstractC8690b, com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: c */
        public final void mo29623c(AbstractC8886c abstractC8886c) {
            super.mo29623c(abstractC8886c);
            if (C8212k.this.f26957qo.f26529oJ.m31821jM()) {
                C8212k.this.f26957qo.f26529oJ.m31820jN().onResume();
                if (C8932a.m29575ah(C8212k.this.f26957qo.mContext).m29573qW()) {
                    C8212k.this.f26957qo.m32017d(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.p301l.p302a.AbstractC8690b, com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: d */
        public final void mo29622d(AbstractC8886c abstractC8886c) {
            super.mo29622d(abstractC8886c);
            if (C8212k.this.f26957qo.f26529oJ.m31821jM()) {
                C8212k.this.f26957qo.f26529oJ.m31820jN().onPause();
            }
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (this.f26957qo.f26529oJ.m31821jM()) {
            this.f26957qo.f26529oJ.m31820jN().registerAdLiveCallerContextListener(this.f27169sm);
            this.f26957qo.f28358Ms.add(this.f27170sn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.f26957qo.f26529oJ.m31821jM()) {
            this.f26957qo.f26529oJ.m31820jN().unRegisterAdLiveCallerContextListener(this.f27169sm);
            this.f26957qo.f28358Ms.remove(this.f27170sn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
