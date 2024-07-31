package com.kwad.components.p208ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.internal.api.C8681e;
import com.kwad.components.core.p287c.C8552f;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p298i.C8675d;
import com.kwad.components.core.p301l.AbstractC8691b;
import com.kwad.components.core.p330s.C8936c;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.p208ad.p247k.C7815a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.C8015m;
import com.kwad.components.p208ad.reward.model.C8028c;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p250c.C7863a;
import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.components.p208ad.reward.p250c.InterfaceC7866d;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.C7885f;
import com.kwad.components.p208ad.reward.p252e.C7888i;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7883d;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.components.p208ad.reward.page.BackPressHandleResult;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.p392d.C10274a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.videocache.p415c.C10562a;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11063bm;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11103l;
import com.stub.StubApp;

@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* renamed from: com.kwad.components.ad.reward.KSRewardVideoActivityProxy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSRewardVideoActivityProxy extends AbstractC8691b<C7907g> implements C7907g.InterfaceC7921b, C8015m.InterfaceC8017a, C8936c.InterfaceC8938b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private C8028c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private C8015m mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private C11063bm mTimerHelper;
    private boolean mReportedPageResume = false;
    private boolean mIsFinishVideoLookStep = false;
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.m31790hj() && ((C7907g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((C7907g) KSRewardVideoActivityProxy.this.mCallerContext).f26558pg != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private C7888i mAdOpenInteractionListener = new C7888i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.components.p208ad.reward.p252e.C7888i, com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
        /* renamed from: bJ */
        public final void mo32088bJ() {
            super.mo32088bJ();
            ((C7907g) KSRewardVideoActivityProxy.this.mCallerContext).f26523fP = true;
            ((C7907g) KSRewardVideoActivityProxy.this.mCallerContext).m32010fE();
        }

        @Override // com.kwad.components.p208ad.reward.p252e.C7888i, com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
        /* renamed from: h */
        public final void mo32084h(boolean z) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z)) {
                C9679c.m28040zM().m28037zP();
                super.mo32084h(z);
            }
        }

        @Override // com.kwad.components.p208ad.reward.p252e.C7888i, com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
        public final void onRewardVerify() {
            if (!((C7907g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((C7907g) KSRewardVideoActivityProxy.this.mCallerContext).f26558pg == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private InterfaceC7883d mAdRewardStepListener = new InterfaceC7883d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7883d
        /* renamed from: fg */
        public final void mo32097fg() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    private C11063bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            C11063bm c11063bm = new C11063bm();
            this.mTimerHelper = c11063bm;
            c11063bm.startTiming();
        }
        return this.mTimerHelper;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify(boolean z) {
        ((C7907g) this.mCallerContext).m32064E(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z || ((C7907g) this.mCallerContext).f26558pg == 0) {
            C7876e.m32105fp().m32107C(this.mModel.getAdTemplate());
        }
        C9908c.m27303g(this.mModel.getAdTemplate(), isNeoScan());
        if (!((C7907g) this.mCallerContext).mAdTemplate.converted) {
            C7863a.m32133gL().m32132gM().m32130M(C7864b.f26483rn);
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.m32087gR()) {
                    C8032c.m31775a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (C10483a.m25835cS(this.mModel.m31794bH())) {
            T t = this.mCallerContext;
            if (((C7907g) t).mAdTemplate.converted || ((C7907g) t).f26545oZ || ((C7907g) t).m32003fL()) {
                return;
            }
            C7907g.m32054a(getActivity(), (C7907g) this.mCallerContext);
        }
    }

    private boolean isLaunchTaskCompleted() {
        T t = this.mCallerContext;
        return ((C7907g) t).f26568pq != null && ((C7907g) t).f26568pq.isCompleted();
    }

    private boolean isNeoScan() {
        return this.mModel.m31785ho() != null && this.mModel.m31785ho().neoPageType == 1;
    }

    public static void launch(Activity activity, AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, C8675d c8675d, int i) {
        Intent intent;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        C8032c.m31747i(true, m25661n);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        C11103l.m23774ek(m25661n);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            C10973b.m24291a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, KSRewardLandScapeVideoActivity.class);
        } else {
            C10973b.m24291a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, KsRewardVideoActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", m25661n.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", C8552f.m30378mE().m30379i(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", C8681e.m30025a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i);
        String uniqueId = m25661n.getUniqueId();
        C7885f.m32091a(uniqueId, rewardAdInteractionListener, c8675d);
        C7885f.m32094H(uniqueId);
        try {
            activity.startActivity(intent);
            C9679c.m28040zM().m28044bj(true);
            C8032c.m31753c(true, m25661n, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            C8032c.m31763a(true, m25661n, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        T t = this.mCallerContext;
        if (((C7907g) t).f26569pr != null) {
            ((C7907g) t).f26569pr.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        return ((C7907g) this.mCallerContext).m32002fM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z) {
        C8028c c8028c;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (c8028c = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!C10483a.m25841cM(c8028c.m31794bH()) || !((C7907g) this.mCallerContext).m32004fK()) {
            C9908c.m27291m(this.mModel.getAdTemplate(), (int) Math.ceil(((float) getTimerHelper().getTime()) / 1000.0f));
        }
        if (z) {
            if (this.mModel.m31785ho() == null || this.mModel.m31785ho().neoPageType != 1) {
                C9908c.m27352a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((C7907g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.m31785ho() == null || this.mModel.m31785ho().neoPageType != 1) {
            C9908c.m27352a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.m31786hn());
        }
        return true;
    }

    private void notifyRewardStep(final int i, final int i2) {
        C8028c c8028c = this.mModel;
        if (c8028c == null || C10487e.m25630eb(c8028c.getAdTemplate()) || ((C7907g) this.mCallerContext).f26557pf.contains(Integer.valueOf(i2))) {
            return;
        }
        ((C7907g) this.mCallerContext).f26557pf.add(Integer.valueOf(i2));
        C8034n.m31744a(i, i2, (C7907g) this.mCallerContext, this.mModel);
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.m32085h(i, i2)) {
                        C8032c.m31775a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i, i2, false);
                    }
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        C8028c c8028c = this.mModel;
        if (c8028c == null || !((C7907g) this.mCallerContext).mCheckExposureResult || C10487e.m25630eb(c8028c.getAdTemplate()) || ((C7907g) this.mCallerContext).m32001fN()) {
            return;
        }
        boolean z = false;
        if (this.mModel.m31791hi()) {
            T t = this.mCallerContext;
            if (((C7907g) t).f26568pq != null && ((C7907g) t).f26568pq.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
            }
        } else if (this.mModel.m31790hj()) {
            T t2 = this.mCallerContext;
            if (((C7907g) t2).f26569pr != null && ((C7907g) t2).f26569pr.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
            }
        } else {
            handleNotifyVerify(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.m31791hi()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
            }
        } else if (this.mModel.m31790hj()) {
            T t = this.mCallerContext;
            boolean z = ((C7907g) t).f26569pr != null && ((C7907g) t).f26569pr.isCompleted();
            notifyRewardStep(1, 0);
            if (z) {
                notifyRewardStep(1, 1);
            }
        } else if (this.mIsFinishVideoLookStep) {
        } else {
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
        }
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    private void reportSubPageCreate(String str) {
        C8028c c8028c = this.mModel;
        C8032c.m31753c(true, c8028c != null ? c8028c.getAdTemplate() : null, str);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public boolean checkIntentData(@Nullable Intent intent) {
        C8028c m31796a = C8028c.m31796a(intent);
        this.mModel = m31796a;
        if (m31796a == null) {
            C10819a.m24738al("reward", TTLogUtil.TAG_EVENT_SHOW);
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.mo32084h(false);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public int getLayoutId() {
        C8028c c8028c = this.mModel;
        if (c8028c != null && c8028c.f26769gt) {
            return C9659R.C9663layout.ksad_activity_reward_neo;
        }
        return C9659R.C9663layout.ksad_activity_reward_video_legacy;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.m32089K(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        C8032c.m31766a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.m31785ho());
        C8032c.m31749g(true, this.mModel.getAdTemplate());
        C8936c.m29567qZ().m29569a(this);
        C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        C10819a.m24738al("reward", TTLogUtil.TAG_EVENT_SHOW);
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7921b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c
    public void onActivityCreate() {
        super.onActivityCreate();
        C9828c.m27588bz(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        BackPressHandleResult m31847gn = this.mRewardPresenter.m31847gn();
        if (m31847gn.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (m31847gn.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.mo32084h(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.mo32084h(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        C8028c c8028c = this.mModel;
        C8031b.m31780b(true, c8028c != null ? c8028c.getAdTemplate() : null);
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b
    public Presenter onCreatePresenter() {
        C8028c c8028c = this.mModel;
        if (c8028c == null) {
            return null;
        }
        C8015m c8015m = new C8015m(this, this.mContext, this.mRootContainer, c8028c, (C7907g) this.mCallerContext);
        this.mRewardPresenter = c8015m;
        c8015m.m31863a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.components.core.proxy.p325a.InterfaceC8884c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        C10331c.m26254d(TAG, "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.mo32084h(false);
            if (this.mCallerContext != 0) {
                C7947i.m31941gj().m31942B(String.valueOf(((C7907g) this.mCallerContext).mAdTemplate));
                C7885f.m32092J(getUniqueId());
            }
            C8028c c8028c = this.mModel;
            if (c8028c != null) {
                String m25977K = C10483a.m25977K(c8028c.m31794bH());
                if (!TextUtils.isEmpty(m25977K)) {
                    C10562a.m25468bl(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext())).m25438eD(m25977K);
                }
            }
            C8936c.m29567qZ().m29568b(this);
            this.listenerKey = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.p330s.C8936c.InterfaceC8938b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t = this.mCallerContext;
        if (t != 0) {
            ((C7907g) t).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
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
        C9283b.m29107tc().m29106td();
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            C8028c c8028c = this.mModel;
            if (c8028c != null) {
                AdTemplate adTemplate = c8028c.getAdTemplate();
                C10274a.m26475DF();
                C10274a.m26468bU(adTemplate);
            }
            if (!this.mReportedPageResume) {
                C8032c.m31750f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            C7863a.m32133gL().m32138M(this.mContext);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.p208ad.reward.C8015m.InterfaceC8017a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((C7907g) this.mCallerContext).m32064E(false);
        ((C7907g) this.mCallerContext).f26555pd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.p301l.AbstractC8691b
    public C7907g onCreateCallerContext() {
        long m25923am;
        AdResultData m31789hk = this.mModel.m31789hk();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo m31794bH = this.mModel.m31794bH();
        final C7907g c7907g = new C7907g(this);
        c7907g.mPageEnterTime = this.mPageEnterTime;
        c7907g.f26527oH = this.mModel.m31787hm() == 2;
        c7907g.f26528oI = this.mAdOpenInteractionListener;
        c7907g.mAdRewardStepListener = this.mAdRewardStepListener;
        c7907g.mScreenOrientation = this.mModel.getScreenOrientation();
        c7907g.mVideoPlayConfig = this.mModel.m31788hl();
        c7907g.mReportExtData = this.mModel.m31786hn();
        c7907g.mRootContainer = this.mRootContainer;
        c7907g.m32018d(m31789hk);
        c7907g.f26547pB = C10484b.m25723dR(m31794bH) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        c7907g.m32048a(this);
        if (C10483a.m25956aF(m31794bH)) {
            c7907g.mApkDownloadHelper = new C8619c(adTemplate, this.mModel.m31786hn());
        }
        c7907g.f26532oM = new RewardActionBarControl(c7907g, this.mContext, adTemplate);
        c7907g.m32034b(this.mPlayEndPageListener);
        if (C10484b.m25742cz(adTemplate)) {
            C7951j c7951j = new C7951j(c7907g, this.mModel.m31786hn(), null);
            c7907g.f26533oN = c7951j;
            c7951j.m31938a(new InterfaceC7866d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                @Override // com.kwad.components.p208ad.reward.p250c.InterfaceC7866d
                /* renamed from: a */
                public final void mo31322a(C7864b c7864b) {
                    c7907g.m32035b(c7864b);
                }
            });
        }
        if (C10483a.m25917as(m31794bH)) {
            c7907g.f26534oO = new C7815a().m32246af(true);
        }
        c7907g.f26544oY = true;
        if (C10483a.m25900bH(m31794bH)) {
            c7907g.f26531oL = new C8874a((KsAdWebView) findViewById(C9659R.C9662id.ksad_playable_webview));
        }
        c7907g.f26572pu = 0L;
        if (this.mModel.m31794bH() != null) {
            if (C10483a.m25900bH(this.mModel.m31794bH())) {
                m25923am = C10483a.m25918ar(this.mModel.m31794bH());
            } else {
                m25923am = C10483a.m25923am(this.mModel.m31794bH());
            }
            c7907g.f26572pu = m25923am;
        }
        c7907g.mTimerHelper = getTimerHelper();
        c7907g.f26529oJ = new C8025e(c7907g);
        c7907g.f26525gt = this.mModel.f26769gt;
        return c7907g;
    }
}
