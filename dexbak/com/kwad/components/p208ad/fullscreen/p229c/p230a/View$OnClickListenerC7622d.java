package com.kwad.components.p208ad.fullscreen.p229c.p230a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.fullscreen.p227a.C7606b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7884e;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.fullscreen.c.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7622d extends C8094b implements View.OnClickListener {

    /* renamed from: ht */
    private ImageView f25883ht;

    /* renamed from: hu */
    private TextView f25884hu;

    /* renamed from: hv */
    private View f25885hv = null;

    /* renamed from: hw */
    private InterfaceC7884e f25886hw = new InterfaceC7884e() { // from class: com.kwad.components.ad.fullscreen.c.a.d.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7884e
        /* renamed from: ce */
        public final void mo31215ce() {
            View$OnClickListenerC7622d.this.m32757cd();
        }
    };

    /* renamed from: gO */
    private C9002l f25882gO = new C9002l() { // from class: com.kwad.components.ad.fullscreen.c.a.d.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            View$OnClickListenerC7622d.this.m32756g(j2);
        }
    };

    /* renamed from: ca */
    private void m32758ca() {
        this.f26957qo.f26529oJ.m31828a(this.f25882gO);
        this.f26957qo.f26540oU.add(this.f25886hw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cd */
    public void m32757cd() {
        if (this.f25885hv.getVisibility() == 0) {
            return;
        }
        this.f25885hv.setAlpha(0.0f);
        this.f25885hv.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View$OnClickListenerC7622d.this.f25885hv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.f25885hv.setOnClickListener(this);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m32758ca();
    }

    /* renamed from: g */
    public final void m32756g(long j) {
        if (j >= C10483a.m25924al(C10487e.m25641dQ(this.mAdTemplate))) {
            m32757cd();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f25885hv) {
            C8141f.m31471a(this.f26957qo, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25883ht = (ImageView) findViewById(C9659R.C9662id.ksad_skip_icon);
        this.f25884hu = (TextView) findViewById(C9659R.C9662id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(C7606b.m32796bN())) {
            this.f25884hu.setText(C7606b.m32796bN());
            this.f25883ht.setVisibility(8);
            this.f25885hv = this.f25884hu;
            return;
        }
        if (C7606b.m32797bM() == 0) {
            this.f25883ht.setImageResource(C9659R.C9661drawable.ksad_page_close);
        } else {
            this.f25883ht.setImageResource(C9659R.C9661drawable.ksad_video_skip_icon);
        }
        this.f25884hu.setVisibility(8);
        this.f25885hv = this.f25883ht;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26540oU.remove(this.f25886hw);
        this.f26957qo.f26529oJ.m31826b(this.f25882gO);
    }
}
