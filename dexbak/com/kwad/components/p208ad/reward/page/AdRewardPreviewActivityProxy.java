package com.kwad.components.p208ad.reward.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.core.p287c.C8552f;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8943h;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.request.C8916e;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.DialogFragmentC7931h;
import com.kwad.components.p208ad.reward.model.RewardCallBackRespInfo;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.widget.HandSlideView;
import com.kwad.components.p208ad.reward.widget.RewardPreviewTopBarView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11063bm;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdRewardPreviewActivityProxy extends AbstractC8886c implements HandSlideView.InterfaceC8327a {
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String KEY_URL = "key_langingpage_url";
    private static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    public DialogFragmentC7931h mCloseDialog;
    private int mCount;
    private C8943h mCountdownHelper;
    private long mCurrentDuration;
    private View mHandSlideContainer;
    @Nullable
    private HandSlideView mHandSlideView;
    private long mLastDown;
    protected KsLogoView mLogoView;
    private int mSkipCount;
    private long mStartPlayTime;
    private C11063bm mTimerHelper;
    private RewardPreviewTopBarView mTopBarView;
    private String mUrl;
    private AdBaseFrameLayout mWebContainer;
    private boolean mHadAdClicked = false;
    private boolean mCheckExposureResult = true;
    private long mPageEnterTime = 0;
    private boolean mReportedPageShow = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8087a {
        /* renamed from: a */
        public static void m31634a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, long j) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoSkipToEnd(j);
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        /* renamed from: c */
        public static void m31633c(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
                try {
                    rewardAdInteractionListener.onRewardStepVerify(0, 0);
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        /* renamed from: d */
        public static void m31632d(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoPlayEnd();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        /* renamed from: e */
        public static void m31631e(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onPageDismiss();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        /* renamed from: f */
        public static void m31630f(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onAdClicked();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRequest(final int i) {
        new AbstractC10436l<C8916e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
            @NonNull
            /* renamed from: C */
            private static RewardCallBackRespInfo m31638C(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: gl */
            public C8916e createRequest() {
                return new C8916e(i, AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return m31638C(str);
            }
        }.request(exposureRequest());
    }

    private void closeHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView != null) {
            handSlideView.destroy();
            this.mHandSlideView = null;
        }
        View view = this.mHandSlideContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private AbstractC10439o<C8916e, RewardCallBackRespInfo> exposureRequest() {
        return new AbstractC10439o<C8916e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.7
            /* renamed from: a */
            private void m31636a(@NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull InterfaceC10420f interfaceC10420f) {
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m31636a((RewardCallBackRespInfo) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C8916e c8916e, int i, String str) {
                super.onError(c8916e, i, str);
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = false;
            }
        };
    }

    private KsAdWebView.InterfaceC10599d getWebErrorListener() {
        return new KsAdWebView.InterfaceC10599d() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
                C8032c.m31757b(true, AdRewardPreviewActivityProxy.this.mAdTemplate, AdRewardPreviewActivityProxy.this.mPageEnterTime);
                C8032c.m31776L(AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageStart() {
                C8032c.m31777K(AdRewardPreviewActivityProxy.this.mAdTemplate);
                if (!AdRewardPreviewActivityProxy.this.mAdTemplate.mPvReported) {
                    AdRewardPreviewActivityProxy.this.checkExposure();
                }
                if (!AdRewardPreviewActivityProxy.this.mHadAdClicked) {
                    AdRewardPreviewActivityProxy.this.showHandSlideMask();
                }
                C9893a.C9894a c9894a = new C9893a.C9894a();
                c9894a.apd = "award_view";
                C7955b.m31926a(true, AdRewardPreviewActivityProxy.this.mAdTemplate, null, new C9913b().m27268b(c9894a));
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str, String str2) {
                C8032c.m31755c(AdRewardPreviewActivityProxy.this.mAdTemplate, i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdClick() {
        this.mHadAdClicked = true;
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9894a.apd = "award_view";
        C7955b.m31927a(this.mAdTemplate, (String) null, "nativePreview", new C9913b().m27266cK(72).m27268b(c9894a).m27247f(this.mWebContainer.getTouchCoords()), (JSONObject) null);
        closeHandSlideMask();
        C8087a.m31630f(mInteractionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCountdownEnd() {
        if (this.mCheckExposureResult) {
            C8087a.m31633c(mInteractionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEndClose() {
        C8087a.m31632d(mInteractionListener);
        C9908c.m27352a(this.mAdTemplate, 1, getTimerHelper().getTime(), (JSONObject) null);
        finish();
    }

    public static void launch(Activity activity, AdResultData adResultData, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        C8032c.m31747i(true, adTemplate);
        boolean m26555CG = C10251d.m26555CG();
        mInteractionListener = rewardAdInteractionListener;
        C10973b.m24291a(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(activity, AdWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(KEY_URL, str);
        if (m26555CG) {
            intent.putExtra("key_ad_result_cache_idx", C8552f.m30378mE().m30379i(adResultData));
        } else {
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
        }
        try {
            activity.startActivity(intent);
            if (!m26555CG) {
                activity.overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
            C8032c.m31763a(true, adTemplate, PageCreateStage.ERROR_START_ACTIVITY.getStage(), e.getMessage());
        }
        C8032c.m31753c(true, adTemplate, PageCreateStage.END_LAUNCH.getStage());
    }

    private void reportSubPageCreate(String str) {
        C8032c.m31753c(true, this.mAdTemplate, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCloseDialog() {
        DialogFragmentC7931h dialogFragmentC7931h = this.mCloseDialog;
        if (dialogFragmentC7931h == null || !dialogFragmentC7931h.isShowing()) {
            int ceil = (int) Math.ceil(((float) this.mCurrentDuration) / 1000.0f);
            this.mCloseDialog = DialogFragmentC7931h.m31976a(getActivity(), this.mAdTemplate, DialogFragmentC7931h.m31966h("还差" + ceil + "秒就可以获取奖励", ceil), new DialogFragmentC7931h.C7943b() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.8
                @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
                /* renamed from: F */
                public final void mo29100F(boolean z) {
                    C8087a.m31634a(AdRewardPreviewActivityProxy.mInteractionListener, System.currentTimeMillis() - AdRewardPreviewActivityProxy.this.mStartPlayTime);
                    C9908c.m27352a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, AdRewardPreviewActivityProxy.this.getTimerHelper().getTime(), (JSONObject) null);
                    AdRewardPreviewActivityProxy.this.finish();
                }

                @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
                /* renamed from: fR */
                public final void mo29099fR() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.pause();
                    }
                }

                @Override // com.kwad.components.p208ad.reward.DialogFragmentC7931h.C7943b, com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c
                /* renamed from: ga */
                public final void mo29097ga() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.resume();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView == null || handSlideView.isStarted()) {
            return;
        }
        this.mHandSlideContainer.setVisibility(0);
        this.mHandSlideView.m31004a(this);
    }

    public void checkExposure() {
        long j = C10487e.m25641dQ(this.mAdTemplate).adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || C10483a.m25929ag(C10487e.m25641dQ(this.mAdTemplate)) <= 5000) {
            return;
        }
        C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
            @Override // java.lang.Runnable
            public final void run() {
                AdRewardPreviewActivityProxy.this.checkRequest(1);
            }
        }, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[RETURN] */
    @Override // com.kwad.components.core.proxy.AbstractC8886c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkIntentData(@androidx.annotation.Nullable android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key_ad_result_cache_idx"
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L1f
            boolean r3 = r5.hasExtra(r0)     // Catch: java.lang.Throwable -> L39
            if (r3 == 0) goto L1f
            int r5 = r5.getIntExtra(r0, r1)     // Catch: java.lang.Throwable -> L39
            com.kwad.components.core.c.f r0 = com.kwad.components.core.p287c.C8552f.m30378mE()     // Catch: java.lang.Throwable -> L39
            com.kwad.sdk.core.response.model.AdResultData r5 = r0.m30380d(r5, r2)     // Catch: java.lang.Throwable -> L39
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.getFirstAdTemplate()     // Catch: java.lang.Throwable -> L39
            r4.mAdTemplate = r5     // Catch: java.lang.Throwable -> L39
            goto L3d
        L1f:
            android.content.Intent r5 = r4.getIntent()     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "key_template_json"
            java.lang.String r5 = r5.getStringExtra(r0)     // Catch: java.lang.Throwable -> L39
            com.kwad.sdk.core.response.model.AdTemplate r0 = new com.kwad.sdk.core.response.model.AdTemplate     // Catch: java.lang.Throwable -> L39
            r0.<init>()     // Catch: java.lang.Throwable -> L39
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L39
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L39
            r0.parseJson(r3)     // Catch: java.lang.Throwable -> L39
            r4.mAdTemplate = r0     // Catch: java.lang.Throwable -> L39
            goto L3d
        L39:
            r5 = move-exception
            com.kwad.sdk.core.p397e.C10331c.printStackTrace(r5)
        L3d:
            com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            if (r5 != 0) goto L49
            java.lang.String r5 = "reward"
            java.lang.String r0 = "show"
            com.kwad.sdk.p439j.C10819a.m24738al(r5, r0)
            return r1
        L49:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.reward.page.AdRewardPreviewActivityProxy.checkIntentData(android.content.Intent):boolean");
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public int getLayoutId() {
        return C9659R.C9663layout.ksad_activity_reward_preview;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public String getPageName() {
        return TAG;
    }

    public C11063bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new C11063bm();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initData() {
        this.mUrl = getIntent().getStringExtra(KEY_URL);
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        int i = m25641dQ.adStyleInfo.adBrowseInfo.adBrowseDuration;
        int m25931ae = C10483a.m25931ae(m25641dQ);
        this.mCount = i;
        this.mSkipCount = Math.min(m25931ae, i);
        this.mStartPlayTime = System.currentTimeMillis();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            try {
                rewardAdInteractionListener.onVideoPlayStart();
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    @SuppressLint({"SetTextI18n"})
    public void initView() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(C9659R.C9662id.ksad_video_webview);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().m25331ei(this.mAdTemplate).m25336bu(true).m25334bw(true).m25338bs(true).m25339b(getWebErrorListener()));
        this.mAdWebView.onActivityCreate();
        this.mWebContainer = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_preview_webview_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_reward_preview_logo);
        this.mLogoView = ksLogoView;
        ksLogoView.m28912aD(this.mAdTemplate);
        this.mHandSlideContainer = findViewById(C9659R.C9662id.ksad_reward_preview_hand_slide_container);
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        if (this.mUrl != null) {
            C8619c c8619c = new C8619c(this.mAdTemplate);
            if (C10483a.m25956aF(m25641dQ) && C10251d.m26576BR() && C11013ag.isWifiConnected(getActivity())) {
                c8619c.m30128r(new C8615a.C8616a(getActivity()).m30202ao(false).m30200ap(false).m30198aq(this.mAdTemplate).m30195ar(false));
            }
        }
        this.mAdWebView.loadUrl(!TextUtils.isEmpty(this.mUrl) ? this.mUrl : C10483a.m25943aS(C10487e.m25641dQ(this.mAdTemplate)));
        getTimerHelper().startTiming();
        this.mWebContainer.m25392a(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
                    if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                        AdRewardPreviewActivityProxy.this.handleAdClick();
                    }
                    AdRewardPreviewActivityProxy.this.mLastDown = 0L;
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.mHandSlideView = (HandSlideView) findViewById(C9659R.C9662id.ksad_reward_preview_hand_slide);
        C8943h c8943h = new C8943h(this.mCount * 1000);
        this.mCountdownHelper = c8943h;
        c8943h.m29556a(new C8943h.InterfaceC8945a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
            @Override // com.kwad.components.core.p330s.C8943h.InterfaceC8945a
            public final void onProgress(long j, long j2) {
                C10331c.m26254d(AdRewardPreviewActivityProxy.TAG, "onProgress currentDuration: " + j + " , totalDuration: " + j2);
                AdRewardPreviewActivityProxy.this.mCurrentDuration = j;
                AdRewardPreviewActivityProxy.this.mTopBarView.m30972n(j);
            }
        });
        this.mCountdownHelper.start();
        RewardPreviewTopBarView rewardPreviewTopBarView = (RewardPreviewTopBarView) findViewById(C9659R.C9662id.ksad_reward_preview_topbar);
        this.mTopBarView = rewardPreviewTopBarView;
        rewardPreviewTopBarView.setTotalCountDuration(this.mCount * 1000);
        this.mTopBarView.setRewardTips(C10483a.m25883bY(m25641dQ));
        this.mTopBarView.setCloseBtnDelayShowDuration(this.mSkipCount * 1000);
        this.mTopBarView.setTopBarListener(new RewardPreviewTopBarView.InterfaceC8331a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
            @Override // com.kwad.components.p208ad.reward.widget.RewardPreviewTopBarView.InterfaceC8331a
            /* renamed from: F */
            public final void mo30971F(boolean z) {
                if (z) {
                    AdRewardPreviewActivityProxy.this.handleEndClose();
                } else {
                    AdRewardPreviewActivityProxy.this.showCloseDialog();
                }
            }

            @Override // com.kwad.components.p208ad.reward.widget.RewardPreviewTopBarView.InterfaceC8331a
            /* renamed from: G */
            public final void mo30970G(boolean z) {
                if (z) {
                    return;
                }
                AdRewardPreviewActivityProxy.this.handleCountdownEnd();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void onActivityCreate() {
        super.onActivityCreate();
        C10819a.m24738al("reward", TTLogUtil.TAG_EVENT_SHOW);
        C9828c.m27588bz(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        try {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null && ksAdWebView.canGoBack()) {
                this.mAdWebView.goBack();
                C9908c.m27322bM(this.mAdTemplate);
                return;
            }
            RewardPreviewTopBarView rewardPreviewTopBarView = this.mTopBarView;
            if (rewardPreviewTopBarView != null && rewardPreviewTopBarView.m30973ke()) {
                super.onBackPressed();
                C8087a.m31632d(mInteractionListener);
                C9908c.m27352a(this.mAdTemplate, 11, getTimerHelper().getTime(), (JSONObject) null);
                return;
            }
            showCloseDialog();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mPageEnterTime = elapsedRealtime;
            C8032c.m31768a(true, this.mAdTemplate, elapsedRealtime);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        C8031b.m31780b(true, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.components.core.proxy.p325a.InterfaceC8884c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        C8087a.m31631e(mInteractionListener);
        mInteractionListener = null;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        C8943h c8943h = this.mCountdownHelper;
        if (c8943h != null) {
            c8943h.stop();
        }
        super.onDestroy();
    }

    @Override // com.kwad.components.p208ad.reward.widget.HandSlideView.InterfaceC8327a
    public void onHandSlideLoopEnd() {
        closeHandSlideMask();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        getTimerHelper().m23865Np();
        C8943h c8943h = this.mCountdownHelper;
        if (c8943h != null) {
            c8943h.pause();
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().m23866No();
        C8943h c8943h = this.mCountdownHelper;
        if (c8943h != null) {
            c8943h.resume();
        }
        if (this.mReportedPageShow) {
            return;
        }
        C8032c.m31750f(true, this.mAdTemplate);
        this.mReportedPageShow = true;
    }
}
