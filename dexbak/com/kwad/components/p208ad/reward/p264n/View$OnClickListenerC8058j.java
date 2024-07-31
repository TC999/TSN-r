package com.kwad.components.p208ad.reward.p264n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.p208ad.reward.DialogFragmentC7931h;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.n.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8058j extends AbstractC8041d implements View.OnClickListener {
    private AdTemplate adTemplate;

    /* renamed from: hz */
    private TextView f26848hz;

    /* renamed from: lv */
    private KSCornerImageView f26849lv;

    /* renamed from: lw */
    private TextView f26850lw;

    /* renamed from: lx */
    private TextView f26851lx;

    /* renamed from: pP */
    private DialogFragmentC7931h.InterfaceC7942a f26852pP;

    /* renamed from: sz */
    private ViewGroup f26853sz;

    /* renamed from: vo */
    private View f26854vo;

    /* renamed from: zb */
    private DialogFragment f26855zb;

    /* renamed from: zc */
    private TextView f26856zc;

    /* renamed from: zd */
    private View f26857zd;

    /* renamed from: ze */
    private View f26858ze;

    public View$OnClickListenerC8058j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, DialogFragmentC7931h.InterfaceC7942a interfaceC7942a) {
        this.f26855zb = dialogFragment;
        this.adTemplate = adTemplate;
        this.f26852pP = interfaceC7942a;
        this.f26853sz = (ViewGroup) layoutInflater.inflate(C9659R.C9663layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.f26849lv = (KSCornerImageView) this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_icon);
        this.f26848hz = (TextView) this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_title);
        this.f26850lw = (TextView) this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_desc);
        this.f26856zc = (TextView) this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_play_time_tips);
        this.f26851lx = (TextView) this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_detail);
        this.f26854vo = this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_btn_close);
        this.f26857zd = this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_btn_deny);
        this.f26858ze = this.f26853sz.findViewById(C9659R.C9662id.ksad_reward_jinniu_dialog_btn_continue);
        this.f26854vo.setOnClickListener(this);
        this.f26857zd.setOnClickListener(this);
        this.f26858ze.setOnClickListener(this);
        this.f26849lv.setOnClickListener(this);
        this.f26848hz.setOnClickListener(this);
        this.f26850lw.setOnClickListener(this);
        this.f26851lx.setOnClickListener(this);
    }

    /* renamed from: a */
    public final void m31685a(DialogFragmentC7931h.C7944c c7944c) {
        KSImageLoader.loadAppIcon(this.f26849lv, c7944c.m31951gf(), this.adTemplate, 4);
        this.f26848hz.setText(c7944c.getTitle());
        this.f26850lw.setText(c7944c.m31950gg());
        this.f26856zc.setText(c7944c.m31948gi());
        if (C10483a.m25824cb(this.adTemplate)) {
            this.f26851lx.setText(String.format("%s >", C10483a.m25957aE(C10487e.m25641dQ(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public final ViewGroup mo31643gF() {
        return this.f26853sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogFragmentC7931h.InterfaceC7942a interfaceC7942a;
        if (view.equals(this.f26854vo)) {
            this.f26855zb.dismiss();
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a2 = this.f26852pP;
            if (interfaceC7942a2 != null) {
                interfaceC7942a2.mo29097ga();
            }
        } else if (view.equals(this.f26857zd)) {
            this.f26855zb.dismiss();
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a3 = this.f26852pP;
            if (interfaceC7942a3 != null) {
                interfaceC7942a3.mo29100F(false);
            }
        } else if (view.equals(this.f26858ze)) {
            this.f26855zb.dismiss();
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a4 = this.f26852pP;
            if (interfaceC7942a4 != null) {
                interfaceC7942a4.mo29097ga();
            }
        } else if (view.equals(this.f26849lv)) {
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a5 = this.f26852pP;
            if (interfaceC7942a5 != null) {
                interfaceC7942a5.mo31451g(127, 2);
            }
        } else if (view.equals(this.f26848hz)) {
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a6 = this.f26852pP;
            if (interfaceC7942a6 != null) {
                interfaceC7942a6.mo31451g(128, 2);
            }
        } else if (view.equals(this.f26850lw)) {
            DialogFragmentC7931h.InterfaceC7942a interfaceC7942a7 = this.f26852pP;
            if (interfaceC7942a7 != null) {
                interfaceC7942a7.mo31451g(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, 2);
            }
        } else if (!view.equals(this.f26851lx) || (interfaceC7942a = this.f26852pP) == null) {
        } else {
            interfaceC7942a.mo31451g(131, 2);
        }
    }
}
