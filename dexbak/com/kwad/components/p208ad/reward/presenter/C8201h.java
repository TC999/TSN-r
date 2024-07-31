package com.kwad.components.p208ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7881b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p368b.C9768b;
import com.kwad.sdk.p368b.InterfaceC9767a;

/* renamed from: com.kwad.components.ad.reward.presenter.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8201h extends C8094b implements InterfaceC9767a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.p368b.InterfaceC9767a
    /* renamed from: N */
    public final void mo26320N(String str) {
        if (TextUtils.equals(C10483a.m25911ay(this.mAdInfo), str)) {
            AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
            if (C10483a.m25947aO(m25641dQ) && C10483a.m25948aN(m25641dQ) == 1) {
                return;
            }
            InterfaceC7881b interfaceC7881b = this.f26957qo.f26528oI;
            if (interfaceC7881b != null) {
                interfaceC7881b.onRewardVerify();
            }
            this.f26957qo.f26529oJ.pause();
            this.f26957qo.m32013fB();
        }
    }

    @Override // com.kwad.sdk.p368b.InterfaceC9767a
    /* renamed from: O */
    public final void mo26319O(String str) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.mAdInfo = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        C9768b.m27830Ao().m27824a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C9768b.m27830Ao().m27817b(this);
    }
}
