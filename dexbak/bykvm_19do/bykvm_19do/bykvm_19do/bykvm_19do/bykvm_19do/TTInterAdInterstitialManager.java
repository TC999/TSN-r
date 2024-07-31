package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.interstitial.TTInterstitialAdListener;
import com.bytedance.msdk.api.interstitial.TTInterstitialAdLoadCallback;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingManagerWrapper;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTInterAdInterstitialManager extends TTAdHeaderBidingManagerWrapper implements ITTAdapterInterstitialListener {

    /* renamed from: O */
    private TTInterstitialAdLoadCallback f273O;

    /* renamed from: P */
    private TTInterstitialAdListener f274P;

    /* compiled from: TTInterAdInterstitialManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C0934a implements TTAdHeaderBidingManagerWrapper.InterfaceC6049c {
        C0934a() {
        }

        @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingManagerWrapper.InterfaceC6049c
        /* renamed from: a */
        public void mo37323a() {
            TTInterAdInterstitialManager.this.m59881b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterAdInterstitialManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0935b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdError f276a;

        RunnableC0935b(AdError adError) {
            this.f276a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTInterAdInterstitialManager.this.f274P != null) {
                TTInterAdInterstitialManager.this.f274P.onInterstitialShowFail(this.f276a);
            }
        }
    }

    public TTInterAdInterstitialManager(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m59881b(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0935b(adError));
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: o */
    public void mo37382o() {
        super.mo37382o();
        this.f274P = null;
        this.f273O = null;
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onAdLeftApplication() {
        TTInterstitialAdListener tTInterstitialAdListener = this.f274P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onAdOpened() {
        TTInterstitialAdListener tTInterstitialAdListener = this.f274P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialAdClick() {
        TTInterstitialAdListener tTInterstitialAdListener = this.f274P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onInterstitialAdClick();
        }
        AdEventUtil.m59300d(this.f21752B, this.f21795h);
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialClosed() {
        TTInterstitialAdListener tTInterstitialAdListener = this.f274P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onInterstitialClosed();
        }
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialShow() {
        TTInterstitialAdListener tTInterstitialAdListener = this.f274P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onInterstitialShow();
        }
        if (this.f21752B != null) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.f21752B.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()));
        }
        AdEventUtil.m59298f(this.f21752B, this.f21795h);
        TTLoaderUtil.m37308o(this.f21752B);
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialShowFail(AdError adError) {
        AdEventUtil.m59309a(this.f21752B, this.f21795h, adError, 1);
        m59881b(adError);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: u */
    protected void mo37376u() {
        TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback = this.f273O;
        if (tTInterstitialAdLoadCallback != null) {
            tTInterstitialAdLoadCallback.onInterstitialLoad();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: v */
    protected void mo37375v() {
    }

    /* renamed from: a */
    public void m59883a(AdSlot adSlot, TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback) {
        AdSlot shallowCopy = AdSlotInner.getShallowCopy(adSlot);
        this.f21795h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(2);
            this.f21795h.setAdCount(1);
        }
        this.f273O = tTInterstitialAdLoadCallback;
        this.f21751A = this;
        m37373x();
    }

    /* renamed from: a */
    public void m59886a(Activity activity) {
        super.m37328a(activity, new C0934a());
    }

    /* renamed from: a */
    public void m59882a(TTInterstitialAdListener tTInterstitialAdListener) {
        this.f274P = tTInterstitialAdListener;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    protected void mo37415a(AdError adError) {
        TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback = this.f273O;
        if (tTInterstitialAdLoadCallback != null) {
            tTInterstitialAdLoadCallback.onInterstitialLoadFail(adError);
        }
    }
}
