package com.kwad.components.ad.reward.presenter.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.b.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    private static float wP = 0.4548105f;
    private AdInfo mAdInfo;
    private com.kwad.components.ad.reward.l.b.a pq;
    @Nullable
    private ViewGroup wI;
    @Nullable
    private q wJ;
    private ViewGroup wK;
    private e wL;
    private c wM;
    @Nullable
    private c wN;
    private int wQ = 15;
    private long wR = -1;
    private boolean wS = false;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.wM != null && g.G(b.this.qo.mAdTemplate)) {
                b.this.wM.jQ();
            }
            if (b.this.wN != null) {
                b.this.wN.jQ();
            }
        }
    };
    private com.kwad.sdk.core.c.c wT = new d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.W(false);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.W(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z3) {
        com.kwad.components.ad.reward.l.b.a aVar;
        com.kwad.components.ad.reward.l.b.a.a(this.pq, getContext(), this.qo.mAdTemplate);
        if (!this.pq.jG()) {
            if (z3) {
                X(false);
            }
        } else if (z3) {
            boolean jd = jd();
            if (jd && (aVar = this.pq) != null) {
                aVar.jF();
                com.kwad.components.ad.reward.b.fb().notifyRewardVerify();
                this.qo.oI.onRewardVerify();
            }
            X(jd);
        } else {
            this.wR = System.currentTimeMillis();
        }
    }

    private void X(boolean z3) {
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.wS + " completed: " + z3);
        if (this.wS) {
            return;
        }
        v.c(getContext(), z3 ? "\u606d\u559c\uff01\u4efb\u52a1\u8fbe\u6807\u5566\uff0c\u6210\u529f\u83b7\u53d6\u5956\u52b1~" : "\u54ce\u5440\uff0c\u5dee\u4e00\u70b9\u5c31\u8fbe\u6807\u5566\uff0c\u518d\u8bd5\u4e00\u6b21~", 0);
        if (z3) {
            this.wS = true;
        }
    }

    private void Y(boolean z3) {
        this.qo.a(1, getContext(), z3 ? 1 : 153, 1);
    }

    private boolean jd() {
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.wR);
        return this.wR >= 0 && System.currentTimeMillis() - this.wR > ((long) (this.wQ * 1000));
    }

    @Override // com.kwad.sdk.b.a
    public final void N(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            g gVar = this.qo;
            if (gVar.pq == null || !g.E(gVar.mAdTemplate)) {
                return;
            }
            this.qo.pq.jD();
            com.kwad.sdk.core.c.b.DD();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            this.wR = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.b.a
    public final void O(String str) {
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onBind");
        if (g.E(this.qo.mAdTemplate)) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
            this.wQ = com.kwad.components.ad.reward.a.b.gr();
            com.kwad.sdk.core.c.b.DD();
            com.kwad.sdk.core.c.b.a(this.wT);
            com.kwad.components.ad.reward.b.fb().a(this.mRewardVerifyListener);
            com.kwad.components.ad.reward.l.b.a jy = com.kwad.components.ad.reward.l.d.jy();
            this.pq = jy;
            this.qo.pq = jy;
            com.kwad.components.ad.reward.l.b.a.a(jy, getContext(), this.qo.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.wI = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                c cVar = new c(this.wI);
                this.wN = cVar;
                cVar.a(this.qo.mApkDownloadHelper);
                this.wN.a(this);
                this.wN.c(this.qo.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wI, this.qo.mApkDownloadHelper, this);
                this.wJ = qVar;
                qVar.a(this.qo.mAdTemplate, adBaseFrameLayout);
            }
            com.kwad.sdk.b.b.Ao().a(this);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.b(this.wT);
        com.kwad.components.ad.reward.b.fb().b(this.mRewardVerifyListener);
        com.kwad.sdk.b.b.Ao().b(this);
        e eVar = this.wL;
        if (eVar != null) {
            eVar.jS();
            this.wL = null;
        }
        c cVar = this.wN;
        if (cVar != null) {
            cVar.jP();
        }
        this.qo.pq = null;
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.qo.mAdTemplate)) {
            Y(false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z3, int i4) {
        this.qo.b(1, getContext(), z3 ? 1 : 153, 1);
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!ai.LZ()) {
            com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        int i4 = R.id.ksad_reward_apk_info_card_native_container;
        ViewGroup viewGroup = (ViewGroup) findViewById(i4);
        this.wK = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wK, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new ay() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(i4);
        this.wK = viewGroup2;
        c cVar = new c(viewGroup2);
        this.wM = cVar;
        cVar.a(this.qo.mApkDownloadHelper);
        this.wM.a(this);
        this.wM.c(this.qo.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wK, this.qo.mApkDownloadHelper, this);
        this.wL = eVar;
        eVar.a(new com.kwad.components.ad.reward.n.f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.ad.reward.n.f
            public final void j(String str, int i5) {
                int i6 = com.kwad.sdk.core.response.b.e.dQ(b.this.qo.mAdTemplate).status;
                com.kwad.sdk.core.e.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i6);
                b.this.wM.k(str, i5);
            }
        });
        this.wL.a(this.qo.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        Y(true);
    }
}
