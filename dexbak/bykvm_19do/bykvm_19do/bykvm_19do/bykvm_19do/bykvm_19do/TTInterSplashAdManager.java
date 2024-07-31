package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdCacheManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.TTBaseAdCache;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTCollectionUtils;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.TTNetworkRequestInfo;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.splash.TTSplashAdListener;
import com.bytedance.msdk.api.splash.TTSplashAdLoadCallback;
import com.bytedance.msdk.api.splash.TTSplashMinWindowListener;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTInterSplashAdManager extends TTAdHeaderBidingRequestCore implements ITTAdapterSplashAdListener {

    /* renamed from: O */
    private TTSplashAdLoadCallback f294O;

    /* renamed from: P */
    private TTSplashAdListener f295P;

    /* renamed from: Q */
    private TTSplashMinWindowListener f296Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterSplashAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.f$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0942a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdError f297a;

        RunnableC0942a(AdError adError) {
            this.f297a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTInterSplashAdManager.this.f295P != null) {
                TTInterSplashAdManager.this.f295P.onAdShowFail(this.f297a);
            }
        }
    }

    public TTInterSplashAdManager(Activity activity, View view, String str) {
        super(activity, str);
    }

    public TTInterSplashAdManager(Activity activity, String str) {
        super(activity, str);
    }

    /* renamed from: D */
    private List<TTBaseAd> m59847D() {
        if (TTCollectionUtils.m59112a(this.f21803p)) {
            if (TTCollectionUtils.m59112a(this.f21802o) && TTCollectionUtils.m59112a(this.f21801n)) {
                return null;
            }
            if (TTCollectionUtils.m59112a(this.f21802o) || !TTCollectionUtils.m59112a(this.f21801n)) {
                if (TTCollectionUtils.m59112a(this.f21801n) || !TTCollectionUtils.m59112a(this.f21802o)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f21801n);
                    arrayList.addAll(this.f21802o);
                    if (m37340h()) {
                        Collections.sort(arrayList, TTLoaderUtil.m37307p());
                    }
                    return arrayList;
                }
                return this.f21801n;
            }
            return this.f21802o;
        }
        return this.f21803p;
    }

    /* renamed from: a */
    private void m59840a(TTBaseAd tTBaseAd, ViewGroup viewGroup) {
        this.f21752B = tTBaseAd;
        tTBaseAd.setHasShown(true);
        this.f21752B.setTTAdatperCallback(this.f21751A);
        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(tTBaseAd.getRit(), TTLogUtil.TAG_EVENT_SHOW) + "展示的广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()) + ",slotId：" + this.f21752B.getAdNetworkSlotId() + ",slotType:" + this.f21752B.getAdNetworkSlotType());
        IntervalShowControl m59587b = IntervalShowControl.m59587b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f21793f);
        sb.append("");
        m59587b.m59589a(sb.toString());
        IntervalShowControl m59587b2 = IntervalShowControl.m59587b();
        m59587b2.m59575j(this.f21793f + "");
        this.f21752B.showSplashAd(viewGroup);
    }

    /* renamed from: b */
    private void m59839b(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0942a(adError));
    }

    /* renamed from: A */
    public int[] m59850A() {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd != null) {
            tTBaseAd.getMinWindowSize();
            return null;
        }
        return null;
    }

    /* renamed from: B */
    public Bitmap m59849B() {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd != null) {
            tTBaseAd.getSplashBitMap();
            return null;
        }
        return null;
    }

    /* renamed from: C */
    public void m59848C() {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd != null) {
            tTBaseAd.splashMinWindowAnimationFinish();
        }
    }

    /* renamed from: a */
    public void m59845a(ViewGroup viewGroup) {
        AdError adError;
        boolean z;
        List<TTBaseAdCache> m59708a;
        TTBaseAd tTBaseAd;
        List<TTBaseAd> m59847D = m59847D();
        AdEventUtil.m59322a(this.f21795h);
        if (viewGroup == null || this.f21789b.get()) {
            AdEventUtil.m59308a(m59847D, this.f21795h);
            adError = new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD));
        } else {
            List<WaterFallConfig> list = null;
            try {
                list = m37377t();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean z2 = false;
            boolean z3 = true;
            if (list != null && list.size() > 0) {
                HashMap<String, TTBaseAd> m37400b = m37400b(m59847D);
                for (WaterFallConfig waterFallConfig : list) {
                    if (waterFallConfig != null) {
                        String m59480c = waterFallConfig.m59480c();
                        TTBaseAd tTBaseAd2 = m37400b.get(m59480c);
                        if (tTBaseAd2 != null && tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                            m59840a(tTBaseAd2, viewGroup);
                        } else if (waterFallConfig.m59474e() != 2 && AdCacheManager.m59712a().m59699c(m59480c, m37363a()) && AdCacheManager.m59712a().m59701b(m59480c, this.f21795h) == 3 && (m59708a = AdCacheManager.m59712a().m59708a(m59480c, this.f21795h)) != null && m59708a.size() > 0 && (tTBaseAd = m59708a.get(0).f425a) != null && tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd.isReady());
                            m37402b(tTBaseAd);
                            m59840a(tTBaseAd, viewGroup);
                        }
                        z = true;
                        z2 = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z2 && m59847D != null && m59847D.size() > 0) {
                for (TTBaseAd tTBaseAd3 : m59847D) {
                    if (tTBaseAd3 != null && tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                        m59840a(tTBaseAd3, viewGroup);
                        break;
                    }
                }
            }
            z3 = z;
            if (z3) {
                if (m37338j()) {
                    AdEventUtil.m59301c(this.f21752B, this.f21795h);
                }
                AdEventUtil.m59299e(this.f21752B, this.f21795h);
                if (this.f21752B.isServerBiddingAd() || !AdCacheManager.m59712a().m59699c(this.f21752B.getAdNetworkSlotId(), m37363a())) {
                    return;
                }
                AdCacheManager.m59712a().m59706a(this.f21752B.getAdNetworkSlotId(), this.f21795h, this.f21804q, true, this.f21757G, this.f21808u, this.f21769z);
                return;
            }
            AdEventUtil.m59308a(m59847D, this.f21795h);
            adError = new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD));
        }
        m59839b(adError);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    protected void mo37415a(AdError adError) {
        TTSplashAdLoadCallback tTSplashAdLoadCallback = this.f294O;
        if (tTSplashAdLoadCallback != null) {
            if (adError.code == 4011) {
                tTSplashAdLoadCallback.onAdLoadTimeout();
            } else {
                tTSplashAdLoadCallback.onSplashAdLoadFail(adError);
            }
        }
    }

    /* renamed from: a */
    public void m59843a(AdSlot adSlot, TTNetworkRequestInfo tTNetworkRequestInfo, TTSplashAdLoadCallback tTSplashAdLoadCallback, int i) {
        AdSlot shallowCopy = AdSlotInner.getShallowCopy(adSlot);
        this.f21795h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(3);
            this.f21795h.setAdCount(1);
        }
        this.f21757G = tTNetworkRequestInfo;
        this.f294O = tTSplashAdLoadCallback;
        this.f21804q.put(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT, Integer.valueOf(i));
        this.f21751A = this;
        m37373x();
    }

    /* renamed from: a */
    public void m59842a(TTSplashAdListener tTSplashAdListener) {
        this.f295P = tTSplashAdListener;
    }

    /* renamed from: a */
    public void m59841a(TTSplashMinWindowListener tTSplashMinWindowListener) {
        this.f296Q = tTSplashMinWindowListener;
    }

    /* renamed from: a */
    public boolean m59846a(Rect rect, ITTAdatperCallback iTTAdatperCallback) {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() != 7) {
            return false;
        }
        this.f21752B.showMinWindow(rect, iTTAdatperCallback);
        return true;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: o */
    public void mo37382o() {
        super.mo37382o();
        this.f295P = null;
        this.f294O = null;
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdClicked() {
        TTSplashAdListener tTSplashAdListener = this.f295P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdClicked();
        }
        AdEventUtil.m59300d(this.f21752B, this.f21795h);
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdDismiss() {
        TTSplashAdListener tTSplashAdListener = this.f295P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdDismiss();
        }
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdShow() {
        TTSplashAdListener tTSplashAdListener = this.f295P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdShow();
        }
        if (this.f21752B != null) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.f21752B.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()));
        }
        AdEventUtil.m59298f(this.f21752B, this.f21795h);
        TTLoaderUtil.m37308o(this.f21752B);
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdShowFail(AdError adError) {
        AdEventUtil.m59309a(this.f21752B, this.f21795h, adError, 1);
        m59839b(adError);
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdSkip() {
        TTSplashAdListener tTSplashAdListener = this.f295P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdSkip();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onMinWindowPlayFinish() {
        TTSplashMinWindowListener tTSplashMinWindowListener = this.f296Q;
        if (tTSplashMinWindowListener != null) {
            tTSplashMinWindowListener.onMinWindowPlayFinish();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onMinWindowStart() {
        TTSplashMinWindowListener tTSplashMinWindowListener = this.f296Q;
        if (tTSplashMinWindowListener != null) {
            tTSplashMinWindowListener.onMinWindowStart();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: q */
    public int mo37380q() {
        TTBaseAd tTBaseAd = this.f21752B;
        if (tTBaseAd != null && tTBaseAd.getLoadSort() == -4 && this.f21752B.getShowSort() == -4) {
            return this.f21752B.getAdNetworkPlatformId();
        }
        if (InternalContainer.m59943f().m59734m()) {
            return super.mo37380q();
        }
        return -3;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: r */
    public String mo37379r() {
        TTBaseAd tTBaseAd = this.f21752B;
        return (tTBaseAd != null && tTBaseAd.getLoadSort() == -4 && this.f21752B.getShowSort() == -4) ? this.f21752B.getAdNetworkSlotId() : !InternalContainer.m59943f().m59734m() ? NetworkPlatformConst.AD_NETWORK_NO_PERMISSION : super.mo37379r();
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: s */
    public String mo37378s() {
        TTBaseAd tTBaseAd = this.f21752B;
        return (tTBaseAd != null && tTBaseAd.getLoadSort() == -4 && this.f21752B.getShowSort() == -4) ? this.f21752B.getNetWorkPlatFormCpm() : !InternalContainer.m59943f().m59734m() ? NetworkPlatformConst.AD_NETWORK_NO_PERMISSION : super.mo37378s();
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: u */
    protected void mo37376u() {
        TTSplashAdLoadCallback tTSplashAdLoadCallback = this.f294O;
        if (tTSplashAdLoadCallback != null) {
            tTSplashAdLoadCallback.onSplashAdLoadSuccess();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: v */
    protected void mo37375v() {
    }
}
