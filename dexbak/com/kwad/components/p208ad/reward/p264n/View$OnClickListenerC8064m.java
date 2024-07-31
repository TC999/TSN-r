package com.kwad.components.p208ad.reward.p264n;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.p208ad.reward.DialogFragmentC7931h;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.n.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8064m extends AbstractC8041d implements View.OnClickListener {

    /* renamed from: fq */
    private ImageView f26885fq;

    /* renamed from: hz */
    private TextView f26886hz;

    /* renamed from: pP */
    private DialogFragmentC7931h.InterfaceC7942a f26887pP;

    /* renamed from: zb */
    private DialogFragment f26888zb;

    /* renamed from: ze */
    private View f26889ze;

    /* renamed from: zt */
    private ViewGroup f26890zt;

    /* renamed from: zu */
    private View f26891zu;

    /* renamed from: zv */
    private TextView f26892zv;

    /* renamed from: zw */
    private TextView f26893zw;

    /* renamed from: zx */
    private TextView f26894zx;

    /* renamed from: zy */
    private View f26895zy;

    public View$OnClickListenerC8064m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, DialogFragmentC7931h.InterfaceC7942a interfaceC7942a) {
        this.f26888zb = dialogFragment;
        this.f26887pP = interfaceC7942a;
        if (C10483a.m25842cL(C10487e.m25641dQ(adTemplate))) {
            this.f26890zt = (ViewGroup) layoutInflater.inflate(C9659R.C9663layout.ksad_live_origin_dialog, viewGroup, false);
            m31668s(true);
            return;
        }
        this.f26890zt = (ViewGroup) layoutInflater.inflate(C9659R.C9663layout.ksad_live_subscribe_dialog, viewGroup, false);
        m31668s(false);
    }

    /* renamed from: s */
    private void m31668s(boolean z) {
        this.f26891zu = this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_btn_close);
        this.f26886hz = (TextView) this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_title);
        this.f26885fq = (ImageView) this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_icon);
        this.f26893zw = (TextView) this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_content_txt);
        this.f26892zv = (TextView) this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_content);
        this.f26889ze = this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_btn_continue);
        this.f26895zy = this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_btn_deny);
        this.f26894zx = (TextView) this.f26890zt.findViewById(C9659R.C9662id.ksad_live_subscribe_dialog_vide_detail);
        if (z) {
            this.f26891zu.setVisibility(8);
        }
        this.f26891zu.setOnClickListener(this);
        this.f26889ze.setOnClickListener(this);
        this.f26895zy.setOnClickListener(this);
        this.f26894zx.setOnClickListener(this);
    }

    /* renamed from: a */
    public final void m31669a(DialogFragmentC7931h.C7944c c7944c) {
        KSImageLoader.loadCircleIcon(this.f26885fq, c7944c.m31951gf(), this.f26890zt.getContext().getResources().getDrawable(C9659R.C9661drawable.ksad_ic_default_user_avatar));
        String title = c7944c.getTitle();
        if (this.f26886hz != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = mo31643gF().getResources().getColor(C9659R.C9660color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.f26886hz.setText(spannableString);
        }
        this.f26892zv.setText(c7944c.m31950gg());
        this.f26893zw.setText(c7944c.m31949gh());
        this.f26894zx.setText(String.format("%s", c7944c.f26647pY));
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public final ViewGroup mo31643gF() {
        return this.f26890zt;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogFragmentC7931h.InterfaceC7942a interfaceC7942a;
        if (view.equals(this.f26891zu)) {
            this.f26888zb.dismiss();
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a2 = this.f26887pP;
            if (interfaceC7942a2 != null) {
                interfaceC7942a2.mo29097ga();
            }
        } else if (view.equals(this.f26889ze)) {
            this.f26888zb.dismiss();
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a3 = this.f26887pP;
            if (interfaceC7942a3 != null) {
                interfaceC7942a3.mo29097ga();
            }
        } else if (view.equals(this.f26895zy)) {
            this.f26888zb.dismiss();
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a4 = this.f26887pP;
            if (interfaceC7942a4 != null) {
                interfaceC7942a4.mo29100F(false);
            }
        } else if (!view.equals(this.f26894zx) || (interfaceC7942a = this.f26887pP) == null) {
        } else {
            interfaceC7942a.mo31451g(131, 2);
        }
    }
}
