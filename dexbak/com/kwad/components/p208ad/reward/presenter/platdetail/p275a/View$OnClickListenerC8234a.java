package com.kwad.components.p208ad.reward.presenter.platdetail.p275a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p326q.C8898a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.C7996l;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7883d;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.p260l.p261a.C8005a;
import com.kwad.components.p208ad.reward.p260l.p262b.C8009a;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8072p;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.HandlerC11068br;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8234a extends C8094b implements View.OnClickListener, HandlerC11068br.InterfaceC11069a {

    /* renamed from: vh */
    private static final String[] f27212vh = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};

    /* renamed from: hf */
    private TextView f27214hf;

    /* renamed from: hh */
    private HandlerC11068br f27215hh;

    /* renamed from: hi */
    private boolean f27216hi;

    /* renamed from: hj */
    private long f27217hj;
    private AdInfo mAdInfo;
    private C8619c mApkDownloadHelper;

    /* renamed from: vd */
    private TextView f27218vd;

    /* renamed from: ve */
    private ImageView f27219ve;

    /* renamed from: vf */
    private View f27220vf;

    /* renamed from: vg */
    private boolean f27221vg = false;

    /* renamed from: vi */
    private boolean f27222vi = false;

    /* renamed from: gO */
    private final C9002l f27213gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8996g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (View$OnClickListenerC8234a.this.f27216hi) {
                return;
            }
            View$OnClickListenerC8234a.this.f27215hh.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            long m32055a = C7907g.m32055a(j, View$OnClickListenerC8234a.this.mAdInfo);
            View$OnClickListenerC8234a.this.f27217hj = j2;
            View$OnClickListenerC8234a.this.m31244a(m32055a, j2);
        }
    };
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            View$OnClickListenerC8234a.m31240a(View$OnClickListenerC8234a.this, true);
            View$OnClickListenerC8234a.this.f27218vd.setText(View$OnClickListenerC8234a.f27212vh[2]);
        }
    };

    /* renamed from: ca */
    private void m31237ca() {
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        this.mAdInfo = m25641dQ;
        this.mApkDownloadHelper = this.f26957qo.mApkDownloadHelper;
        long m32055a = C7907g.m32055a(C10483a.m25975M(m25641dQ), this.mAdInfo) / 1000;
        if (C7907g.m32062G(this.mAdTemplate)) {
            this.f27220vf.setVisibility(0);
            this.f27220vf.setOnClickListener(this);
            this.f27218vd.setText(String.format(f27212vh[0], Long.valueOf(m32055a)));
            this.f27214hf.setVisibility(8);
        } else {
            this.f27220vf.setVisibility(8);
            this.f27214hf.setText(String.valueOf(m32055a));
            this.f27214hf.setVisibility(0);
            this.f27214hf.setAlpha(1.0f);
        }
        C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
        this.f26957qo.f26529oJ.m31828a(this.f27213gO);
    }

    /* renamed from: ik */
    private void m31232ik() {
        if (this.f27221vg) {
            return;
        }
        this.f27221vg = true;
        this.f27219ve.setAlpha(0.0f);
        this.f27219ve.setVisibility(0);
        this.f27219ve.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                View$OnClickListenerC8234a.this.f27214hf.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View$OnClickListenerC8234a.this.f27214hf.setAlpha(1.0f - floatValue);
                View$OnClickListenerC8234a.this.f27219ve.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* renamed from: il */
    private void m31231il() {
        InterfaceC7883d interfaceC7883d = this.f26957qo.mAdRewardStepListener;
        if (interfaceC7883d != null) {
            interfaceC7883d.mo32097fg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        C7955b.m31927a(this.mAdTemplate, "native_id", "playTopBar-style1", new C9913b().m27247f(this.f26957qo.mRootContainer.getTouchCoords()).m27266cK(41), this.f26957qo.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    private void notifyRewardVerify() {
        this.f26957qo.f26528oI.onRewardVerify();
    }

    /* renamed from: x */
    private void m31229x(int i) {
        this.f26957qo.f26570ps = i;
        if (C7907g.m32062G(this.mAdTemplate)) {
            if (this.f27222vi) {
                return;
            }
            this.f27218vd.setText(String.format(f27212vh[0], Integer.valueOf(i)));
            return;
        }
        this.f27214hf.setText(String.valueOf(i));
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27215hh = new HandlerC11068br(this);
        m31237ca();
        if (this.f26957qo.f26529oJ.m31821jM()) {
            m31229x((int) (((float) C10483a.m25929ag(this.mAdInfo)) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f27219ve || view == this.f27220vf) {
            C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30205an(2).m30158v(this.f26957qo.f26529oJ.getPlayDuration()).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                public final void onAdClicked() {
                    View$OnClickListenerC8234a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27214hf = (TextView) findViewById(C9659R.C9662id.ksad_video_count_down);
        this.f27219ve = (ImageView) findViewById(C9659R.C9662id.ksad_detail_reward_icon);
        this.f27218vd = (TextView) findViewById(C9659R.C9662id.ksad_reward_deep_task_count_down);
        this.f27220vf = findViewById(C9659R.C9662id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
        this.f26957qo.f26529oJ.m31826b(this.f27213gO);
        this.f27219ve.setVisibility(8);
        this.f27220vf.setVisibility(8);
        this.f27221vg = false;
        this.f27222vi = false;
        this.f27216hi = false;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m31240a(View$OnClickListenerC8234a view$OnClickListenerC8234a, boolean z) {
        view$OnClickListenerC8234a.f27222vi = true;
        return true;
    }

    /* renamed from: a */
    public final void m31244a(long j, long j2) {
        int m25951aK;
        if (C10483a.m25947aO(this.mAdInfo) && C8898a.m29651qH().m29650qI() == 0) {
            m25951aK = C10483a.m25949aM(this.mAdInfo);
        } else {
            m25951aK = C10483a.m25951aK(this.mAdInfo);
        }
        C7907g c7907g = this.f26957qo;
        long j3 = m25951aK * (c7907g.f26553pb ? 1000 : 0);
        C7996l.m31897a(c7907g, j2, j, j3);
        m31243a(j2, j, j3);
    }

    /* renamed from: a */
    private void m31243a(long j, long j2, long j3) {
        C8005a c8005a;
        C8009a c8009a;
        if (j < (j2 - 800) - j3) {
            int floor = (int) Math.floor(((float) (j2 - j)) / 1000.0f);
            m31229x(floor);
            View$OnClickListenerC8072p view$OnClickListenerC8072p = this.f26957qo.f26560pi;
            if (view$OnClickListenerC8072p != null) {
                view$OnClickListenerC8072p.m31653T(floor);
                return;
            }
            return;
        }
        this.f26957qo.f26556pe = true;
        if (C7907g.m32062G(this.mAdTemplate)) {
            if (C7907g.m32065E(this.mAdTemplate) && (c8009a = this.f26957qo.f26568pq) != null) {
                if (!c8009a.m31876jB()) {
                    this.f26957qo.f26568pq.m31877jA();
                }
            } else if (C7907g.m32063F(this.mAdTemplate) && (c8005a = this.f26957qo.f26569pr) != null && !c8005a.m31884jB()) {
                this.f26957qo.f26569pr.m31885jA();
            }
            if (this.f27222vi) {
                return;
            }
            this.f27218vd.setText(f27212vh[1]);
            m31231il();
            return;
        }
        notifyRewardVerify();
        m31232ik();
        View$OnClickListenerC8072p view$OnClickListenerC8072p2 = this.f26957qo.f26560pi;
        if (view$OnClickListenerC8072p2 != null) {
            view$OnClickListenerC8072p2.m31653T(0);
        }
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        if (message.what == 1) {
            if (!this.f26957qo.m32002fM() && !this.f26957qo.m32003fL()) {
                this.f27217hj += 500;
                m31244a(C10483a.m25929ag(this.mAdInfo), this.f27217hj);
                this.f27215hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.f27215hh.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
