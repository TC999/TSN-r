package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PreLoadManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.reward.TTRewardedAdListener;
import com.bytedance.msdk.api.reward.TTRewardedAdLoadCallback;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingManagerWrapper;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTInterRewardVideoAdManager extends TTAdHeaderBidingManagerWrapper implements ITTAdapterRewardedAdListener {

    /* renamed from: O */
    private TTRewardedAdLoadCallback f289O;

    /* renamed from: P */
    private TTRewardedAdListener f290P;

    /* compiled from: TTInterRewardVideoAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C0940a implements TTAdHeaderBidingManagerWrapper.InterfaceC6049c {
        C0940a() {
        }

        @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingManagerWrapper.InterfaceC6049c
        /* renamed from: a */
        public void mo37323a() {
            TTInterRewardVideoAdManager.this.m59851b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterRewardVideoAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0941b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdError f292a;

        RunnableC0941b(AdError adError) {
            this.f292a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTInterRewardVideoAdManager.this.f290P != null) {
                TTInterRewardVideoAdManager.this.f290P.onRewardedAdShowFail(this.f292a);
            }
        }
    }

    public TTInterRewardVideoAdManager(Context context, String str) {
        super(context, str);
    }

    /* renamed from: B */
    private void m59856B() {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() == 4) {
            return;
        }
        PreLoadManager.m59686a().m59685a(this.f21769z, this.f21793f, m37363a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m59851b(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0941b(adError));
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: o */
    public void mo37382o() {
        super.mo37382o();
        this.f289O = null;
        this.f290P = null;
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardClick() {
        TTRewardedAdListener tTRewardedAdListener = this.f290P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardClick();
        }
        AdEventUtil.m59300d(this.f21752B, this.f21795h);
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardVerify(RewardItem rewardItem) {
        TTRewardedAdListener tTRewardedAdListener = this.f290P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardVerify(rewardItem);
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardedAdClosed() {
        m59856B();
        TTRewardedAdListener tTRewardedAdListener = this.f290P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardedAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardedAdShow() {
        TTRewardedAdListener tTRewardedAdListener = this.f290P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardedAdShow();
        }
        if (this.f21752B != null) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.f21752B.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()));
        }
        AdEventUtil.m59298f(this.f21752B, this.f21795h);
        TTLoaderUtil.m37308o(this.f21752B);
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardedAdShowFail(AdError adError) {
        AdEventUtil.m59309a(this.f21752B, this.f21795h, adError, 1);
        m59851b(adError);
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onSkippedVideo() {
        m59856B();
        TTRewardedAdListener tTRewardedAdListener = this.f290P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onSkippedVideo();
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onVideoComplete() {
        m59856B();
        TTRewardedAdListener tTRewardedAdListener = this.f290P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onVideoComplete();
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onVideoError() {
        AdEventUtil.m59309a(this.f21752B, this.f21795h, (AdError) null, 2);
        TTRewardedAdListener tTRewardedAdListener = this.f290P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onVideoError();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: u */
    protected void mo37376u() {
        TTRewardedAdLoadCallback tTRewardedAdLoadCallback = this.f289O;
        if (tTRewardedAdLoadCallback != null) {
            tTRewardedAdLoadCallback.onRewardVideoAdLoad();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: v */
    protected void mo37375v() {
        TTRewardedAdLoadCallback tTRewardedAdLoadCallback = this.f289O;
        if (tTRewardedAdLoadCallback != null) {
            tTRewardedAdLoadCallback.onRewardVideoCached();
        }
    }

    /* renamed from: a */
    public void m59852a(AdSlot adSlot, @NonNull TTRewardedAdLoadCallback tTRewardedAdLoadCallback) {
        this.f289O = tTRewardedAdLoadCallback;
        AdSlot shallowCopy = AdSlotInner.getShallowCopy(adSlot);
        this.f21795h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(7);
            this.f21795h.setAdCount(1);
            TTVideoOptionUtil.setRewardTTVideoOptionIfNeed(this.f21795h);
        }
        this.f21751A = this;
        m37373x();
    }

    @MainThread
    /* renamed from: a */
    public void m59855a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTRewardedAdListener tTRewardedAdListener) {
        this.f290P = tTRewardedAdListener;
        super.m37327a(activity, map, new C0940a());
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    protected void mo37415a(AdError adError) {
        TTRewardedAdLoadCallback tTRewardedAdLoadCallback = this.f289O;
        if (tTRewardedAdLoadCallback != null) {
            tTRewardedAdLoadCallback.onRewardVideoLoadFail(adError);
        }
    }
}
