package com.kwad.components.ad.fullscreen.c.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView ht;
    private TextView hu;
    private View hv = null;
    private com.kwad.components.ad.reward.e.e hw = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.fullscreen.c.a.d.1
        @Override // com.kwad.components.ad.reward.e.e
        public final void ce() {
            d.this.cd();
        }
    };
    private l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.d.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            d.this.g(j5);
        }
    };

    private void ca() {
        this.qo.oJ.a(this.gO);
        this.qo.oU.add(this.hw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        if (this.hv.getVisibility() == 0) {
            return;
        }
        this.hv.setAlpha(0.0f);
        this.hv.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.hv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.hv.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    public final void g(long j4) {
        if (j4 >= com.kwad.sdk.core.response.b.a.al(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate))) {
            cd();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.hv) {
            com.kwad.components.ad.reward.presenter.f.a(this.qo, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ht = (ImageView) findViewById(R.id.ksad_skip_icon);
        this.hu = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.fullscreen.a.b.bN())) {
            this.hu.setText(com.kwad.components.ad.fullscreen.a.b.bN());
            this.ht.setVisibility(8);
            this.hv = this.hu;
            return;
        }
        if (com.kwad.components.ad.fullscreen.a.b.bM() == 0) {
            this.ht.setImageResource(R.drawable.ksad_page_close);
        } else {
            this.ht.setImageResource(R.drawable.ksad_video_skip_icon);
        }
        this.hu.setVisibility(8);
        this.hv = this.ht;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oU.remove(this.hw);
        this.qo.oJ.b(this.gO);
    }
}
