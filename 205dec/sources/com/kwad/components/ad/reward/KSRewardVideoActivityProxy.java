package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.c;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bn;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.l.b<g> implements g.b, m.a, c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private m mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bm mTimerHelper;
    private boolean mReportedPageResume = false;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hj() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).pg != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void bJ() {
            super.bJ();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fP = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fE();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void h(boolean z3) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z3)) {
                com.kwad.sdk.a.a.c.zM().zP();
                super.h(z3);
            }
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (!((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((g) KSRewardVideoActivityProxy.this.mCallerContext).pg == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.e.d
        public final void fg() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    private bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            bm bmVar = new bm();
            this.mTimerHelper = bmVar;
            bmVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify(boolean z3) {
        ((g) this.mCallerContext).E(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z3 || ((g) this.mCallerContext).pg == 0) {
            e.fp().C(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.adlog.c.g(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.gL().gM().M(com.kwad.components.ad.reward.c.b.rn);
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.gR()) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.cS(this.mModel.bH())) {
            Object obj = this.mCallerContext;
            if (((g) obj).mAdTemplate.converted || ((g) obj).oZ || ((g) obj).fL()) {
                return;
            }
            g.a(getActivity(), (g) this.mCallerContext);
        }
    }

    private boolean isLaunchTaskCompleted() {
        Object obj = this.mCallerContext;
        return ((g) obj).pq != null && ((g) obj).pq.isCompleted();
    }

    private boolean isNeoScan() {
        return this.mModel.ho() != null && this.mModel.ho().neoPageType == 1;
    }

    public static void launch(Activity activity, AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar, int i4) {
        Intent intent;
        AdTemplate n4 = com.kwad.sdk.core.response.b.c.n(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(true, n4);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.l.ek(n4);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.b.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, KsRewardVideoActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", n4.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.mE().i(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra("key_template_reward_type", i4);
        String uniqueId = n4.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.H(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.zM().bj(true);
            com.kwad.components.ad.reward.monitor.c.c(true, n4, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(true, n4, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        Object obj = this.mCallerContext;
        if (((g) obj).pr != null) {
            ((g) obj).pr.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        return ((g) this.mCallerContext).fM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z3) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == null || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!com.kwad.sdk.core.response.b.a.cM(cVar.bH()) || !((g) this.mCallerContext).fK()) {
            com.kwad.sdk.core.adlog.c.m(this.mModel.getAdTemplate(), (int) Math.ceil(((float) getTimerHelper().getTime()) / 1000.0f));
        }
        if (z3) {
            if (this.mModel.ho() == null || this.mModel.ho().neoPageType != 1) {
                com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.ho() == null || this.mModel.ho().neoPageType != 1) {
            com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.hn());
        }
        return true;
    }

    private void notifyRewardStep(final int i4, final int i5) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.b.e.eb(cVar.getAdTemplate()) || ((g) this.mCallerContext).pf.contains(Integer.valueOf(i5))) {
            return;
        }
        ((g) this.mCallerContext).pf.add(Integer.valueOf(i5));
        n.a(i4, i5, (g) this.mCallerContext, this.mModel);
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.h(i4, i5)) {
                        com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i4, i5, false);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.b.e.eb(cVar.getAdTemplate()) || ((g) this.mCallerContext).fN()) {
            return;
        }
        boolean z3 = false;
        if (this.mModel.hi()) {
            Object obj = this.mCallerContext;
            if (((g) obj).pq != null && ((g) obj).pq.isCompleted()) {
                z3 = true;
            }
            if (z3) {
                handleNotifyVerify(true);
            }
        } else if (this.mModel.hj()) {
            Object obj2 = this.mCallerContext;
            if (((g) obj2).pr != null && ((g) obj2).pr.isCompleted()) {
                z3 = true;
            }
            if (z3) {
                handleNotifyVerify(true);
            }
        } else {
            handleNotifyVerify(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.hi()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
            }
        } else if (this.mModel.hj()) {
            Object obj = this.mCallerContext;
            boolean z3 = ((g) obj).pr != null && ((g) obj).pr.isCompleted();
            notifyRewardStep(1, 0);
            if (z3) {
                notifyRewardStep(1, 1);
            }
        } else if (this.mIsFinishVideoLookStep) {
        } else {
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.c.c(true, cVar != null ? cVar.getAdTemplate() : null, str);
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        com.kwad.components.ad.reward.model.c a4 = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = a4;
        if (a4 == null) {
            com.kwad.sdk.j.a.al("reward", "show");
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.h(false);
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null && cVar.gt) {
            return R.layout.ksad_activity_reward_neo;
        }
        return R.layout.ksad_activity_reward_video_legacy;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.K(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.c.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.ho());
        com.kwad.components.ad.reward.monitor.c.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.s.c.qZ().a(this);
        b.fb().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        com.kwad.sdk.j.a.al("reward", "show");
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bz(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        BackPressHandleResult gn = this.mRewardPresenter.gn();
        if (gn.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (gn.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.h(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.h(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.b.b(true, cVar != null ? cVar.getAdTemplate() : null);
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        m mVar = new m(this, this.mContext, this.mRootContainer, cVar, (g) this.mCallerContext);
        this.mRewardPresenter = mVar;
        mVar.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.e.c.d("RewardVideo", "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            b.fb().b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.h(false);
            if (this.mCallerContext != null) {
                i.gj().B(String.valueOf(((g) this.mCallerContext).mAdTemplate));
                com.kwad.components.ad.reward.e.f.J(getUniqueId());
            }
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                String K = com.kwad.sdk.core.response.b.a.K(cVar.bH());
                if (!TextUtils.isEmpty(K)) {
                    com.kwad.sdk.core.videocache.c.a.bl(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext())).eD(K);
                }
            }
            com.kwad.components.core.s.c.qZ().b(this);
            this.listenerKey = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.s.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        Object obj = this.mCallerContext;
        if (obj != null) {
            ((g) obj).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.d.b.tc().td();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.d.a.DF();
                com.kwad.sdk.core.d.a.bU(adTemplate);
            }
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.c.f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            com.kwad.components.ad.reward.c.a.gL().M(this.mContext);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.ad.reward.m.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).E(false);
        ((g) this.mCallerContext).pd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.l.b
    public g onCreateCallerContext() {
        long am;
        AdResultData hk = this.mModel.hk();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo bH = this.mModel.bH();
        final g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.oH = this.mModel.hm() == 2;
        gVar.oI = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.hl();
        gVar.mReportExtData = this.mModel.hn();
        gVar.mRootContainer = this.mRootContainer;
        gVar.d(hk);
        gVar.pB = com.kwad.sdk.core.response.b.b.dR(bH) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        gVar.a(this);
        if (com.kwad.sdk.core.response.b.a.aF(bH)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(adTemplate, this.mModel.hn());
        }
        gVar.oM = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cz(adTemplate)) {
            j jVar = new j(gVar, this.mModel.hn(), null);
            gVar.oN = jVar;
            jVar.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.b.a.as(bH)) {
            gVar.oO = new com.kwad.components.ad.k.a().af(true);
        }
        gVar.oY = true;
        if (com.kwad.sdk.core.response.b.a.bH(bH)) {
            gVar.oL = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.pu = 0L;
        if (this.mModel.bH() != null) {
            if (com.kwad.sdk.core.response.b.a.bH(this.mModel.bH())) {
                am = com.kwad.sdk.core.response.b.a.ar(this.mModel.bH());
            } else {
                am = com.kwad.sdk.core.response.b.a.am(this.mModel.bH());
            }
            gVar.pu = am;
        }
        gVar.mTimerHelper = getTimerHelper();
        gVar.oJ = new com.kwad.components.ad.reward.m.e(gVar);
        gVar.gt = this.mModel.gt;
        return gVar;
    }
}
