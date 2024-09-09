package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j extends d implements View.OnClickListener {
    private AdTemplate adTemplate;
    private TextView hz;
    private KSCornerImageView lv;
    private TextView lw;
    private TextView lx;
    private h.a pP;
    private ViewGroup sz;
    private View vo;
    private DialogFragment zb;
    private TextView zc;
    private View zd;
    private View ze;

    public j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.zb = dialogFragment;
        this.adTemplate = adTemplate;
        this.pP = aVar;
        this.sz = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.lv = (KSCornerImageView) this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.hz = (TextView) this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.lw = (TextView) this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.zc = (TextView) this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.lx = (TextView) this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.vo = this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.zd = this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.ze = this.sz.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.vo.setOnClickListener(this);
        this.zd.setOnClickListener(this);
        this.ze.setOnClickListener(this);
        this.lv.setOnClickListener(this);
        this.hz.setOnClickListener(this);
        this.lw.setOnClickListener(this);
        this.lx.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadAppIcon(this.lv, cVar.gf(), this.adTemplate, 4);
        this.hz.setText(cVar.getTitle());
        this.lw.setText(cVar.gg());
        this.zc.setText(cVar.gi());
        if (com.kwad.sdk.core.response.b.a.cb(this.adTemplate)) {
            this.lx.setText(String.format("%s >", com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gF() {
        return this.sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.vo)) {
            this.zb.dismiss();
            h.a aVar2 = this.pP;
            if (aVar2 != null) {
                aVar2.ga();
            }
        } else if (view.equals(this.zd)) {
            this.zb.dismiss();
            h.a aVar3 = this.pP;
            if (aVar3 != null) {
                aVar3.F(false);
            }
        } else if (view.equals(this.ze)) {
            this.zb.dismiss();
            h.a aVar4 = this.pP;
            if (aVar4 != null) {
                aVar4.ga();
            }
        } else if (view.equals(this.lv)) {
            h.a aVar5 = this.pP;
            if (aVar5 != null) {
                aVar5.g(127, 2);
            }
        } else if (view.equals(this.hz)) {
            h.a aVar6 = this.pP;
            if (aVar6 != null) {
                aVar6.g(128, 2);
            }
        } else if (view.equals(this.lw)) {
            h.a aVar7 = this.pP;
            if (aVar7 != null) {
                aVar7.g(129, 2);
            }
        } else if (!view.equals(this.lx) || (aVar = this.pP) == null) {
        } else {
            aVar.g(131, 2);
        }
    }
}
