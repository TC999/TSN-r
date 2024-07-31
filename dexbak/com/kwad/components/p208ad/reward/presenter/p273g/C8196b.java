package com.kwad.components.p208ad.reward.presenter.p273g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p260l.C8014d;
import com.kwad.components.p208ad.reward.p260l.p262b.C8009a;
import com.kwad.components.p208ad.reward.p264n.C8037c;
import com.kwad.components.p208ad.reward.p264n.C8042e;
import com.kwad.components.p208ad.reward.p264n.C8073q;
import com.kwad.components.p208ad.reward.p264n.InterfaceC8045f;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p368b.C9768b;
import com.kwad.sdk.p368b.InterfaceC9767a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11128v;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.reward.presenter.g.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8196b extends C8094b implements C8037c.InterfaceC8039a, InterfaceC9767a, InterfaceC10635a, InterfaceC11145c {

    /* renamed from: wP */
    private static float f27134wP = 0.4548105f;
    private AdInfo mAdInfo;

    /* renamed from: pq */
    private C8009a f27135pq;
    @Nullable

    /* renamed from: wI */
    private ViewGroup f27136wI;
    @Nullable

    /* renamed from: wJ */
    private C8073q f27137wJ;

    /* renamed from: wK */
    private ViewGroup f27138wK;

    /* renamed from: wL */
    private C8042e f27139wL;

    /* renamed from: wM */
    private C8037c f27140wM;
    @Nullable

    /* renamed from: wN */
    private C8037c f27141wN;

    /* renamed from: wQ */
    private int f27142wQ = 15;

    /* renamed from: wR */
    private long f27143wR = -1;

    /* renamed from: wS */
    private boolean f27144wS = false;
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            if (C8196b.this.f27140wM != null && C7907g.m32062G(C8196b.this.f26957qo.mAdTemplate)) {
                C8196b.this.f27140wM.m31735jQ();
            }
            if (C8196b.this.f27141wN != null) {
                C8196b.this.f27141wN.m31735jQ();
            }
        }
    };

    /* renamed from: wT */
    private InterfaceC10246c f27145wT = new AbstractC10247d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        public final void onBackToBackground() {
            super.onBackToBackground();
            C8196b.this.m31300W(false);
        }

        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
        public final void onBackToForeground() {
            super.onBackToForeground();
            C8196b.this.m31300W(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public void m31300W(boolean z) {
        C8009a c8009a;
        C8009a.m31878a(this.f27135pq, getContext(), this.f26957qo.mAdTemplate);
        if (!this.f27135pq.m31871jG()) {
            if (z) {
                m31299X(false);
            }
        } else if (z) {
            boolean m31290jd = m31290jd();
            if (m31290jd && (c8009a = this.f27135pq) != null) {
                c8009a.m31872jF();
                C7845b.m32173fb().notifyRewardVerify();
                this.f26957qo.f26528oI.onRewardVerify();
            }
            m31299X(m31290jd);
        } else {
            this.f27143wR = System.currentTimeMillis();
        }
    }

    /* renamed from: X */
    private void m31299X(boolean z) {
        C10331c.m26254d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.f27144wS + " completed: " + z);
        if (this.f27144wS) {
            return;
        }
        C11128v.m23669c(getContext(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z) {
            this.f27144wS = true;
        }
    }

    /* renamed from: Y */
    private void m31298Y(boolean z) {
        this.f26957qo.m32060a(1, getContext(), z ? 1 : 153, 1);
    }

    /* renamed from: jd */
    private boolean m31290jd() {
        C10331c.m26254d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.f27143wR);
        return this.f27143wR >= 0 && System.currentTimeMillis() - this.f27143wR > ((long) (this.f27142wQ * 1000));
    }

    @Override // com.kwad.sdk.p368b.InterfaceC9767a
    /* renamed from: N */
    public final void mo26320N(String str) {
        if (TextUtils.equals(C10483a.m25911ay(this.mAdInfo), str)) {
            C7907g c7907g = this.f26957qo;
            if (c7907g.f26568pq == null || !C7907g.m32065E(c7907g.mAdTemplate)) {
                return;
            }
            this.f26957qo.f26568pq.m31874jD();
            C10232b.m26625DD();
            if (C10232b.isAppOnForeground()) {
                return;
            }
            this.f27143wR = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.p368b.InterfaceC9767a
    /* renamed from: O */
    public final void mo26319O(String str) {
    }

    @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
    /* renamed from: a */
    public final void mo25245a(@Nullable C10640a c10640a) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C10331c.m26254d("LaunchAppTaskPresenter", "onBind");
        if (C7907g.m32065E(this.f26957qo.mAdTemplate)) {
            this.mAdInfo = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
            this.f27142wQ = C7844b.m32187gr();
            C10232b.m26625DD();
            C10232b.m26622a(this.f27145wT);
            C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
            C8009a m31866jy = C8014d.m31866jy();
            this.f27135pq = m31866jy;
            this.f26957qo.f26568pq = m31866jy;
            C8009a.m31878a(m31866jy, getContext(), this.f26957qo.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(C9659R.C9662id.ksad_activity_apk_info_area_native);
            this.f27136wI = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                C8037c c8037c = new C8037c(this.f27136wI);
                this.f27141wN = c8037c;
                c8037c.m31741a(this.f26957qo.mApkDownloadHelper);
                this.f27141wN.m31743a(this);
                this.f27141wN.m31737c(this.f26957qo.mAdTemplate, false);
                ((KSFrameLayout) findViewById(C9659R.C9662id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                C8073q c8073q = new C8073q((KsAdWebView) findViewById(C9659R.C9662id.ksad_right_area_webview), this.f27136wI, this.f26957qo.mApkDownloadHelper, this);
                this.f27137wJ = c8073q;
                c8073q.m31721a(this.f26957qo.mAdTemplate, adBaseFrameLayout);
            }
            C9768b.m27830Ao().m27824a(this);
            m31295a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C10331c.m26254d("LaunchAppTaskPresenter", "onUnbind");
        C10232b.m26625DD();
        C10232b.m26621b(this.f27145wT);
        C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
        C9768b.m27830Ao().m27817b(this);
        C8042e c8042e = this.f27139wL;
        if (c8042e != null) {
            c8042e.m31716jS();
            this.f27139wL = null;
        }
        C8037c c8037c = this.f27141wN;
        if (c8037c != null) {
            c8037c.m31736jP();
        }
        this.f26957qo.f26568pq = null;
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.f26957qo.mAdTemplate)) {
            m31298Y(false);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.C8037c.InterfaceC8039a
    /* renamed from: d */
    public final void mo31291d(boolean z, int i) {
        this.f26957qo.m32037b(1, getContext(), z ? 1 : 153, 1);
    }

    /* renamed from: a */
    private void m31295a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!C11015ai.m24123LZ()) {
            C10331c.m26254d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(C9659R.C9662id.ksad_reward_apk_info_stub)).inflate();
        int i = C9659R.C9662id.ksad_reward_apk_info_card_native_container;
        ViewGroup viewGroup = (ViewGroup) findViewById(i);
        this.f27138wK = viewGroup;
        viewGroup.setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this.f27138wK, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(C9659R.C9662id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(C9659R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(C9659R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
        this.f27138wK = viewGroup2;
        C8037c c8037c = new C8037c(viewGroup2);
        this.f27140wM = c8037c;
        c8037c.m31741a(this.f26957qo.mApkDownloadHelper);
        this.f27140wM.m31743a(this);
        this.f27140wM.m31737c(this.f26957qo.mAdTemplate, false);
        C8042e c8042e = new C8042e((KsAdWebView) findViewById(C9659R.C9662id.ksad_reward_apk_info_card_h5), this.f27138wK, this.f26957qo.mApkDownloadHelper, this);
        this.f27139wL = c8042e;
        c8042e.m31723a(new InterfaceC8045f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.p208ad.reward.p264n.InterfaceC8045f
            /* renamed from: j */
            public final void mo31289j(String str, int i2) {
                int i3 = C10487e.m25641dQ(C8196b.this.f26957qo.mAdTemplate).status;
                C10331c.m26254d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i3);
                C8196b.this.f27140wM.m31734k(str, i2);
            }
        });
        this.f27139wL.m31721a(this.f26957qo.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m31298Y(true);
    }
}
