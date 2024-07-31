package com.kwad.components.p208ad.reward.p264n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.model.C8026a;
import com.kwad.components.p208ad.widget.KsPriceView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.widget.InterfaceC11145c;

/* renamed from: com.kwad.components.ad.reward.n.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8059k extends AbstractC8041d implements InterfaceC11145c {

    /* renamed from: hz */
    private TextView f26859hz;

    /* renamed from: lv */
    private KSCornerImageView f26860lv;

    /* renamed from: lw */
    private TextView f26861lw;

    /* renamed from: qo */
    private C7907g f26862qo;

    /* renamed from: yH */
    private KsPriceView f26863yH;

    /* renamed from: yK */
    private TextView f26864yK;

    /* renamed from: yL */
    private TextView f26865yL;

    /* renamed from: yM */
    private View f26866yM;

    /* renamed from: zf */
    private ViewStub f26867zf;

    /* renamed from: zg */
    private ViewGroup f26868zg;

    /* renamed from: zh */
    private KsStyledTextButton f26869zh;

    /* renamed from: zi */
    private KsStyledTextButton f26870zi;

    public C8059k(C7907g c7907g, ViewStub viewStub) {
        this.f26867zf = viewStub;
        this.f26862qo = c7907g;
    }

    /* renamed from: d */
    private void m31683d(View view, boolean z) {
        if (view.equals(this.f26870zi)) {
            this.f26862qo.m32060a(2, view.getContext(), z ? 38 : 153, 1);
        } else if (view.equals(this.f26869zh)) {
            this.f26862qo.m32060a(2, view.getContext(), z ? 37 : 153, 1);
        } else if (view.equals(this.f26868zg)) {
            this.f26862qo.m32060a(2, view.getContext(), z ? 2 : 153, 2);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        m31684a(c8074r.getAdTemplate(), C8026a.m31818I(c8074r.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.f26862qo.mAdTemplate)) {
            m31683d(view, false);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public final ViewGroup mo31643gF() {
        return this.f26868zg;
    }

    public final void hide() {
        ViewGroup viewGroup = this.f26868zg;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public C8059k(C7907g c7907g, ViewGroup viewGroup) {
        this.f26868zg = viewGroup;
        this.f26862qo = c7907g;
    }

    /* renamed from: a */
    private void m31684a(AdTemplate adTemplate, C8026a c8026a) {
        KSImageLoader.loadAppIcon(this.f26860lv, c8026a.m31809gf(), adTemplate, 8);
        this.f26859hz.setText(c8026a.getTitle());
        this.f26861lw.setText(c8026a.m31808gg());
        int dimensionPixelSize = this.f26868zg.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.f26863yH.getConfig().m30438ae(dimensionPixelSize).m30436ag(dimensionPixelSize).m30437af(this.f26868zg.getResources().getColor(C9659R.C9660color.ksad_jinniu_end_origin_color));
        this.f26863yH.m30441d(c8026a.getPrice(), c8026a.getOriginPrice(), true);
        String m31813gW = c8026a.m31813gW();
        this.f26866yM.setVisibility(TextUtils.isEmpty(m31813gW) ? 8 : 0);
        if (m31813gW != null) {
            this.f26864yK.setText(m31813gW);
        }
        this.f26865yL.setText(c8026a.m31812gX());
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m31683d(view, true);
    }
}
