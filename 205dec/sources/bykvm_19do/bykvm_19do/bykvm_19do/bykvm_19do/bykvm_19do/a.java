package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.interstitial.TTInterstitialAdListener;
import com.bytedance.msdk.api.interstitial.TTInterstitialAdLoadCallback;
import com.bytedance.msdk.core.corelogic.e;

/* compiled from: TTInterAdInterstitialManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a extends com.bytedance.msdk.core.corelogic.e implements ITTAdapterInterstitialListener {
    private TTInterstitialAdLoadCallback O;
    private TTInterstitialAdListener P;

    /* compiled from: TTInterAdInterstitialManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class C0016a implements e.c {
        C0016a() {
        }

        @Override // com.bytedance.msdk.core.corelogic.e.c
        public void a() {
            a.this.b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterAdInterstitialManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdError f283a;

        b(AdError adError) {
            this.f283a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.P != null) {
                a.this.P.onInterstitialShowFail(this.f283a);
            }
        }
    }

    public a(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdError adError) {
        ThreadHelper.runOnUiThread(new b(adError));
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void o() {
        super.o();
        this.P = null;
        this.O = null;
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onAdLeftApplication() {
        TTInterstitialAdListener tTInterstitialAdListener = this.P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onAdOpened() {
        TTInterstitialAdListener tTInterstitialAdListener = this.P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialAdClick() {
        TTInterstitialAdListener tTInterstitialAdListener = this.P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onInterstitialAdClick();
        }
        g.d(this.B, this.f27885h);
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialClosed() {
        TTInterstitialAdListener tTInterstitialAdListener = this.P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onInterstitialClosed();
        }
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialShow() {
        TTInterstitialAdListener tTInterstitialAdListener = this.P;
        if (tTInterstitialAdListener != null) {
            tTInterstitialAdListener.onInterstitialShow();
        }
        if (this.B != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.B.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()));
        }
        g.f(this.B, this.f27885h);
        com.bytedance.msdk.core.corelogic.f.o(this.B);
    }

    @Override // com.bytedance.msdk.api.interstitial.TTInterstitialAdListener
    public void onInterstitialShowFail(AdError adError) {
        g.a(this.B, this.f27885h, adError, 1);
        b(adError);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void u() {
        TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback = this.O;
        if (tTInterstitialAdLoadCallback != null) {
            tTInterstitialAdLoadCallback.onInterstitialLoad();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void v() {
    }

    public void a(AdSlot adSlot, TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback) {
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(adSlot);
        this.f27885h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(2);
            this.f27885h.setAdCount(1);
        }
        this.O = tTInterstitialAdLoadCallback;
        this.A = this;
        x();
    }

    public void a(Activity activity) {
        super.a(activity, new C0016a());
    }

    public void a(TTInterstitialAdListener tTInterstitialAdListener) {
        this.P = tTInterstitialAdListener;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void a(AdError adError) {
        TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback = this.O;
        if (tTInterstitialAdLoadCallback != null) {
            tTInterstitialAdLoadCallback.onInterstitialLoadFail(adError);
        }
    }
}
