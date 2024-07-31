package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PreLoadManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener;
import com.bytedance.msdk.api.fullVideo.TTFullVideoAdLoadCallback;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingManagerWrapper;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTInterFullVideoAdManager extends TTAdHeaderBidingManagerWrapper implements ITTAdapterFullVideoAdListener {

    /* renamed from: O */
    private TTFullVideoAdLoadCallback f283O;

    /* renamed from: P */
    private TTFullVideoAdListener f284P;

    /* compiled from: TTInterFullVideoAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C0938a implements TTAdHeaderBidingManagerWrapper.InterfaceC6049c {
        C0938a() {
        }

        @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingManagerWrapper.InterfaceC6049c
        /* renamed from: a */
        public void mo37323a() {
            TTInterFullVideoAdManager.this.m59866b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterFullVideoAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0939b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdError f286a;

        RunnableC0939b(AdError adError) {
            this.f286a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTInterFullVideoAdManager.this.f284P != null) {
                TTInterFullVideoAdManager.this.f284P.onFullVideoAdShowFail(this.f286a);
            }
        }
    }

    public TTInterFullVideoAdManager(Context context, String str) {
        super(context, str);
    }

    /* renamed from: B */
    private void m59871B() {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() == 4) {
            return;
        }
        PreLoadManager.m59686a().m59685a(this.f21769z, this.f21793f, m37363a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m59866b(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0939b(adError));
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: o */
    public void mo37382o() {
        super.mo37382o();
        this.f284P = null;
        this.f283O = null;
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdClick() {
        TTFullVideoAdListener tTFullVideoAdListener = this.f284P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onFullVideoAdClick();
        }
        AdEventUtil.m59300d(this.f21752B, this.f21795h);
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdClosed() {
        m59871B();
        TTFullVideoAdListener tTFullVideoAdListener = this.f284P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onFullVideoAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdShow() {
        TTFullVideoAdListener tTFullVideoAdListener = this.f284P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onFullVideoAdShow();
        }
        if (this.f21752B != null) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.f21752B.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()));
        }
        AdEventUtil.m59298f(this.f21752B, this.f21795h);
        TTLoaderUtil.m37308o(this.f21752B);
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdShowFail(AdError adError) {
        AdEventUtil.m59309a(this.f21752B, this.f21795h, adError, 1);
        m59866b(adError);
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onSkippedVideo() {
        m59871B();
        TTFullVideoAdListener tTFullVideoAdListener = this.f284P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onSkippedVideo();
        }
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onVideoComplete() {
        m59871B();
        TTFullVideoAdListener tTFullVideoAdListener = this.f284P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onVideoComplete();
        }
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onVideoError() {
        AdEventUtil.m59309a(this.f21752B, this.f21795h, (AdError) null, 2);
        TTFullVideoAdListener tTFullVideoAdListener = this.f284P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onVideoError();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: u */
    protected void mo37376u() {
        TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback = this.f283O;
        if (tTFullVideoAdLoadCallback != null) {
            tTFullVideoAdLoadCallback.onFullVideoAdLoad();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: v */
    protected void mo37375v() {
        TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback = this.f283O;
        if (tTFullVideoAdLoadCallback != null) {
            tTFullVideoAdLoadCallback.onFullVideoCached();
        }
    }

    /* renamed from: a */
    public void m59867a(AdSlot adSlot, @NonNull TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback) {
        this.f283O = tTFullVideoAdLoadCallback;
        AdSlot shallowCopy = AdSlotInner.getShallowCopy(adSlot);
        this.f21795h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(8);
            this.f21795h.setAdCount(1);
            TTVideoOptionUtil.setFullTTVideoOptionIfNeed(this.f21795h);
        }
        this.f21751A = this;
        m37373x();
    }

    @MainThread
    /* renamed from: a */
    public void m59870a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTFullVideoAdListener tTFullVideoAdListener) {
        this.f284P = tTFullVideoAdListener;
        super.m37327a(activity, map, new C0938a());
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    protected void mo37415a(AdError adError) {
        TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback = this.f283O;
        if (tTFullVideoAdLoadCallback != null) {
            tTFullVideoAdLoadCallback.onFullVideoLoadFail(adError);
        }
    }
}
