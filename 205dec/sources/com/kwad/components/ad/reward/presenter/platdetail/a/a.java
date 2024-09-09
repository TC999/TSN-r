package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.br;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, br.a {
    private static final String[] vh = {"%ss\u540e\u83b7\u5f97\u5956\u52b11", "\u5df2\u83b7\u5f97\u5956\u52b11/2", "\u5df2\u83b7\u5f97\u5168\u90e8\u5956\u52b1"};
    private TextView hf;
    private br hh;
    private boolean hi;
    private long hj;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private TextView vd;
    private ImageView ve;
    private View vf;
    private boolean vg = false;
    private boolean vi = false;
    private final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.hi) {
                return;
            }
            a.this.hh.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            long a4 = g.a(j4, a.this.mAdInfo);
            a.this.hj = j5;
            a.this.a(a4, j5);
        }
    };
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.vd.setText(a.vh[2]);
        }
    };

    private void ca() {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        this.mAdInfo = dQ;
        this.mApkDownloadHelper = this.qo.mApkDownloadHelper;
        long a4 = g.a(com.kwad.sdk.core.response.b.a.M(dQ), this.mAdInfo) / 1000;
        if (g.G(this.mAdTemplate)) {
            this.vf.setVisibility(0);
            this.vf.setOnClickListener(this);
            this.vd.setText(String.format(vh[0], Long.valueOf(a4)));
            this.hf.setVisibility(8);
        } else {
            this.vf.setVisibility(8);
            this.hf.setText(String.valueOf(a4));
            this.hf.setVisibility(0);
            this.hf.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
        this.qo.oJ.a(this.gO);
    }

    private void ik() {
        if (this.vg) {
            return;
        }
        this.vg = true;
        this.ve.setAlpha(0.0f);
        this.ve.setVisibility(0);
        this.ve.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.hf.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.hf.setAlpha(1.0f - floatValue);
                a.this.ve.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void il() {
        com.kwad.components.ad.reward.e.d dVar = this.qo.mAdRewardStepListener;
        if (dVar != null) {
            dVar.fg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new com.kwad.sdk.core.adlog.c.b().f(this.qo.mRootContainer.getTouchCoords()).cK(41), this.qo.mReportExtData);
        this.qo.oI.bJ();
    }

    private void notifyRewardVerify() {
        this.qo.oI.onRewardVerify();
    }

    private void x(int i4) {
        this.qo.ps = i4;
        if (g.G(this.mAdTemplate)) {
            if (this.vi) {
                return;
            }
            this.vd.setText(String.format(vh[0], Integer.valueOf(i4)));
            return;
        }
        this.hf.setText(String.valueOf(i4));
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.hh = new br(this);
        ca();
        if (this.qo.oJ.jM()) {
            x((int) (((float) com.kwad.sdk.core.response.b.a.ag(this.mAdInfo)) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ve || view == this.vf) {
            com.kwad.components.core.e.d.a.a(new a.C0631a(view.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(2).v(this.qo.oJ.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hf = (TextView) findViewById(R.id.ksad_video_count_down);
        this.ve = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.vd = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.vf = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
        this.qo.oJ.b(this.gO);
        this.ve.setVisibility(8);
        this.vf.setVisibility(8);
        this.vg = false;
        this.vi = false;
        this.hi = false;
    }

    static /* synthetic */ boolean a(a aVar, boolean z3) {
        aVar.vi = true;
        return true;
    }

    public final void a(long j4, long j5) {
        int aK;
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo) && com.kwad.components.core.q.a.qH().qI() == 0) {
            aK = com.kwad.sdk.core.response.b.a.aM(this.mAdInfo);
        } else {
            aK = com.kwad.sdk.core.response.b.a.aK(this.mAdInfo);
        }
        g gVar = this.qo;
        long j6 = aK * (gVar.pb ? 1000 : 0);
        com.kwad.components.ad.reward.l.a(gVar, j5, j4, j6);
        a(j5, j4, j6);
    }

    private void a(long j4, long j5, long j6) {
        com.kwad.components.ad.reward.l.a.a aVar;
        com.kwad.components.ad.reward.l.b.a aVar2;
        if (j4 < (j5 - 800) - j6) {
            int floor = (int) Math.floor(((float) (j5 - j4)) / 1000.0f);
            x(floor);
            p pVar = this.qo.pi;
            if (pVar != null) {
                pVar.T(floor);
                return;
            }
            return;
        }
        this.qo.pe = true;
        if (g.G(this.mAdTemplate)) {
            if (g.E(this.mAdTemplate) && (aVar2 = this.qo.pq) != null) {
                if (!aVar2.jB()) {
                    this.qo.pq.jA();
                }
            } else if (g.F(this.mAdTemplate) && (aVar = this.qo.pr) != null && !aVar.jB()) {
                this.qo.pr.jA();
            }
            if (this.vi) {
                return;
            }
            this.vd.setText(vh[1]);
            il();
            return;
        }
        notifyRewardVerify();
        ik();
        p pVar2 = this.qo.pi;
        if (pVar2 != null) {
            pVar2.T(0);
        }
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.qo.fM() && !this.qo.fL()) {
                this.hj += 500;
                a(com.kwad.sdk.core.response.b.a.ag(this.mAdInfo), this.hj);
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
