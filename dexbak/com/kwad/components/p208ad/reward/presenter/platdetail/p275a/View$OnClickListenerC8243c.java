package com.kwad.components.p208ad.reward.presenter.platdetail.p275a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7884e;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8243c extends C8094b implements View.OnClickListener {
    private AdInfo mAdInfo;

    /* renamed from: vl */
    private ImageView f27235vl;

    /* renamed from: vm */
    private TextView f27236vm;

    /* renamed from: vn */
    private boolean f27237vn = false;

    /* renamed from: vo */
    private View f27238vo = null;

    /* renamed from: vp */
    private long f27239vp = -1;

    /* renamed from: gO */
    private final C9002l f27233gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            if (View$OnClickListenerC8243c.this.f27239vp >= 0) {
                if (j2 > Math.min(Math.min(View$OnClickListenerC8243c.this.f27239vp, C10483a.m25929ag(View$OnClickListenerC8243c.this.mAdInfo)), j)) {
                    View$OnClickListenerC8243c.this.m31216in();
                }
            }
        }
    };

    /* renamed from: hw */
    private final InterfaceC7884e f27234hw = new InterfaceC7884e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7884e
        /* renamed from: ce */
        public final void mo31215ce() {
            View$OnClickListenerC8243c.m31221a(View$OnClickListenerC8243c.this, true);
            View$OnClickListenerC8243c.this.m31216in();
        }
    };

    /* renamed from: ca */
    private void m31218ca() {
        this.mAdInfo = C10487e.m25641dQ(this.mAdTemplate);
        this.f26957qo.f26529oJ.m31828a(this.f27233gO);
        this.f26957qo.f26540oU.add(this.f27234hw);
        long m25930af = C10483a.m25930af(this.mAdInfo);
        this.f27239vp = m25930af;
        if (m25930af == 0) {
            this.f27238vo.setVisibility(0);
        } else {
            this.f27238vo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: in */
    public void m31216in() {
        if (this.f27238vo.getVisibility() == 0) {
            return;
        }
        this.f27238vo.setAlpha(0.0f);
        this.f27238vo.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View$OnClickListenerC8243c.this.f27238vo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m31218ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f27238vo) {
            C8141f.m31471a(this.f26957qo, this.f27237vn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27235vl = (ImageView) findViewById(C9659R.C9662id.ksad_detail_close_btn);
        this.f27236vm = (TextView) findViewById(C9659R.C9662id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(C7844b.m32188gq())) {
            this.f27236vm.setText(C7844b.m32188gq());
            this.f27238vo = this.f27236vm;
        } else {
            if (C7844b.m32189gp() == 0) {
                this.f27235vl.setImageResource(C9659R.C9661drawable.ksad_page_close);
            } else {
                this.f27235vl.setImageResource(C9659R.C9661drawable.ksad_video_skip_icon);
            }
            this.f27238vo = this.f27235vl;
        }
        this.f27238vo.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f27233gO);
        this.f26957qo.f26540oU.remove(this.f27234hw);
        this.f27238vo.setVisibility(8);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m31221a(View$OnClickListenerC8243c view$OnClickListenerC8243c, boolean z) {
        view$OnClickListenerC8243c.f27237vn = true;
        return true;
    }
}
