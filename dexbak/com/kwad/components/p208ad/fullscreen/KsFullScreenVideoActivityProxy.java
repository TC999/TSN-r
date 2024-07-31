package com.kwad.components.p208ad.fullscreen;

import android.content.Context;
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
import com.kwad.components.core.p301l.AbstractC8691b;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.p208ad.fullscreen.p229c.C7641b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.C7951j;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
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
import com.kwad.sdk.utils.C11063bm;
import com.kwad.sdk.utils.C11103l;
import com.kwad.sdk.utils.C11126t;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* renamed from: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsFullScreenVideoActivityProxy extends AbstractC8691b<C7907g> implements OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "FullScreenVideo";
    private static final HashMap<String, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener> sHashMap = new HashMap<>();
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private C7641b mFullScreenPresenter;
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    public long mPageEnterTime;
    private JSONObject mReportExtData;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private C11063bm mTimerHelper;
    private KsVideoPlayConfig mVideoPlayConfig;
    private C7607b model;
    private boolean mReportedPageResume = false;
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private C7650d mAdOpenInteractionListener = new C7650d() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.components.p208ad.fullscreen.C7650d, com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
        /* renamed from: h */
        public final void mo32084h(boolean z) {
            if (KsFullScreenVideoActivityProxy.this.notifyPageDismiss()) {
                super.mo32084h(z);
            }
        }
    };

    private static String getListenerKey(AdTemplate adTemplate) {
        return adTemplate == null ? "" : String.valueOf(C10487e.m25641dQ(adTemplate).adBaseInfo.creativeId);
    }

    private C11063bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            C11063bm c11063bm = new C11063bm();
            this.mTimerHelper = c11063bm;
            c11063bm.startTiming();
        }
        return this.mTimerHelper;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        C11126t.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    public static void launch(@NonNull Context context, @NonNull AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Intent intent;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        C8032c.m31747i(false, m25661n);
        C11103l.m23774ek(m25661n);
        if (ksVideoPlayConfig.isShowLandscape()) {
            C10973b.m24291a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, KsFullScreenLandScapeVideoActivity.class);
        } else {
            C10973b.m24291a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, FeedDownloadActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_ad_result_cache_idx", C8552f.m30378mE().m30379i(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", C8681e.m30025a(ksVideoPlayConfig));
        sHashMap.put(getListenerKey(m25661n), fullScreenVideoAdInteractionListener);
        try {
            context.startActivity(intent);
            C9679c.m28040zM().m28044bj(true);
            reportSubPageCreate(PageCreateStage.END_LAUNCH.getStage(), m25661n);
        } catch (Throwable th) {
            C8032c.m31763a(false, m25661n, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (this.mAdTemplate != null && this.mAdInfo != null) {
            long time = getTimerHelper().getTime();
            C9679c.m28040zM().m28037zP();
            C9908c.m27352a(this.mAdTemplate, 6, time, this.mReportExtData);
            if (C10483a.m25841cM(this.mAdInfo) && !((C7907g) this.mCallerContext).f26526jY) {
                C9908c.m27291m(this.model.getAdTemplate(), (int) Math.ceil(((float) time) / 1000.0f));
            }
        }
        return true;
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        C10973b.m24291a(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        C10973b.m24291a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    private static void reportSubPageCreate(String str, AdTemplate adTemplate) {
        C8032c.m31753c(false, adTemplate, str);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public boolean checkIntentData(@Nullable Intent intent) {
        if (C10251d.m26555CG()) {
            this.mVideoPlayConfig = C8681e.m30024b(getIntent().getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
            if (serializableExtra instanceof KsVideoPlayConfig) {
                this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            }
        }
        AdResultData m30380d = C8552f.m30378mE().m30380d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = m30380d;
        if (m30380d == null) {
            return false;
        }
        AdTemplate m25661n = C10485c.m25661n(m30380d);
        this.mAdTemplate = m25661n;
        this.model = new C7607b(m25661n);
        this.mAdOpenInteractionListener.setAdTemplate(this.mAdTemplate);
        if (this.mVideoPlayConfig == null || this.mAdTemplate == null) {
            C10819a.m24738al("fullscreen", TTLogUtil.TAG_EVENT_SHOW);
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
        C7607b c7607b = this.model;
        if (c7607b != null && c7607b.f25856gt) {
            return C9659R.C9663layout.ksad_activity_fullscreen_tk;
        }
        return C9659R.C9663layout.ksad_activity_fullscreen_video_legacy;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return ((C7907g) this.mCallerContext).m31995fx();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initData() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = elapsedRealtime;
        C8032c.m31768a(false, this.mAdTemplate, elapsedRealtime);
        C8032c.m31749g(false, this.mAdTemplate);
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = sHashMap.get(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = fullScreenVideoAdInteractionListener;
        this.mAdOpenInteractionListener.m32718b(fullScreenVideoAdInteractionListener);
        this.mAdInfo = C10487e.m25641dQ(this.mAdTemplate);
        this.mScreenOrientation = this.mVideoPlayConfig.isShowLandscape() ? 1 : 0;
        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        initVideoPlayConfig(this.mVideoPlayConfig);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        C10819a.m24738al("fullscreen", TTLogUtil.TAG_EVENT_SHOW);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c
    public void onActivityCreate() {
        super.onActivityCreate();
        C9828c.m27588bz(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        C7641b c7641b = this.mFullScreenPresenter;
        if ((c7641b == null || !c7641b.onBackPressed()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        C8031b.m31780b(false, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b
    public Presenter onCreatePresenter() {
        getActivity();
        C7641b c7641b = new C7641b(this, this.mRootContainer, this.model, (C7907g) this.mCallerContext);
        this.mFullScreenPresenter = c7641b;
        return c7641b;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.components.core.proxy.p325a.InterfaceC8884c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            this.mAdOpenInteractionListener.mo32084h(false);
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                String m25977K = C10483a.m25977K(adInfo);
                if (!TextUtils.isEmpty(m25977K)) {
                    C10562a.m25468bl(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext())).m25438eD(m25977K);
                }
            }
            T t = this.mCallerContext;
            if (t != 0 && ((C7907g) t).f26529oJ != null && ((C7907g) t).f26529oJ.m31821jM()) {
                ((C7907g) this.mCallerContext).f26529oJ.m31820jN().removeInterceptor(this);
            }
            sHashMap.remove(getListenerKey(this.mAdTemplate));
            this.mInteractionListener = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            getTimerHelper().m23865Np();
            T t = this.mCallerContext;
            if (t != 0) {
                ((C7907g) t).mPageEnterTime = -1L;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            getTimerHelper().m23866No();
            if (this.mReportedPageResume) {
                return;
            }
            C8032c.m31750f(false, this.mAdTemplate);
            this.mReportedPageResume = true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.p301l.AbstractC8691b
    public C7907g onCreateCallerContext() {
        long m25923am;
        C7907g c7907g = new C7907g(this);
        c7907g.m32018d(this.mAdResultData);
        c7907g.mPageEnterTime = this.mPageEnterTime;
        c7907g.f26527oH = false;
        c7907g.f26528oI = this.mAdOpenInteractionListener;
        c7907g.mScreenOrientation = this.mScreenOrientation;
        c7907g.mVideoPlayConfig = this.mVideoPlayConfig;
        c7907g.mReportExtData = this.mReportExtData;
        c7907g.mRootContainer = this.mRootContainer;
        if (C10483a.m25956aF(this.mAdInfo)) {
            c7907g.mApkDownloadHelper = new C8619c(this.mAdTemplate, this.mReportExtData);
        }
        c7907g.f26532oM = new RewardActionBarControl(c7907g, this.mContext, this.mAdTemplate);
        c7907g.m32034b(this.mPlayEndPageListener);
        if (C10484b.m25742cz(this.mAdTemplate)) {
            c7907g.f26533oN = new C7951j(c7907g, this.mReportExtData, null);
        }
        if (C10483a.m25900bH(this.mAdInfo)) {
            c7907g.f26531oL = new C8874a((KsAdWebView) findViewById(C9659R.C9662id.ksad_playable_webview));
        }
        c7907g.f26544oY = false;
        if (C10483a.m25900bH(this.mAdInfo)) {
            m25923am = C10483a.m25918ar(this.mAdInfo);
        } else {
            m25923am = C10483a.m25923am(this.mAdInfo);
        }
        c7907g.f26572pu = m25923am;
        c7907g.mTimerHelper = getTimerHelper();
        c7907g.f26529oJ = new C8025e(c7907g);
        return c7907g;
    }
}
