package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdCacheManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.TTBaseAdCache;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTCollectionUtils;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTDislikeCallback;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.banner.TTAdBannerListener;
import com.bytedance.msdk.api.banner.TTAdBannerLoadCallBack;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTInterBannerAdManager extends TTAdHeaderBidingRequestCore implements ITTAdapterBannerAdListener {

    /* renamed from: O */
    private TTAdBannerListener f278O;

    /* renamed from: P */
    private TTAdBannerLoadCallBack f279P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterBannerAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0936a implements TTDislikeCallback {

        /* renamed from: a */
        final /* synthetic */ View f280a;

        C0936a(TTInterBannerAdManager tTInterBannerAdManager, View view) {
            this.f280a = view;
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onCancel() {
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onRefuse() {
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onSelected(int i, String str) {
            View view = this.f280a;
            if (view != null) {
                View view2 = (View) view.getParent();
                if (view2 instanceof ViewGroup) {
                    ((ViewGroup) view2).removeViewInLayout(this.f280a);
                }
            }
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onShow() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterBannerAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0937b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdError f281a;

        RunnableC0937b(AdError adError) {
            this.f281a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTInterBannerAdManager.this.f278O != null) {
                TTInterBannerAdManager.this.f278O.onAdShowFail(this.f281a);
            }
        }
    }

    public TTInterBannerAdManager(Context context, String str) {
        super(context, str);
    }

    /* renamed from: B */
    private List<TTBaseAd> m59879B() {
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

    /* renamed from: b */
    private void m59875b(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0937b(adError));
    }

    /* renamed from: c */
    private View m59872c(TTBaseAd tTBaseAd) {
        this.f21752B = tTBaseAd;
        tTBaseAd.setHasShown(true);
        this.f21752B.setTTAdatperCallback(this.f21751A);
        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21752B.getRit(), TTLogUtil.TAG_EVENT_SHOW) + "展示的广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()) + ",slotId：" + this.f21752B.getAdNetworkSlotId() + ",slotType:" + this.f21752B.getAdNetworkSlotType());
        View adView = this.f21752B.getAdView();
        if (this.f21752B.hasDislike()) {
            this.f21752B.setDislikeCallback((Activity) this.f21769z, new C0936a(this, adView));
        }
        return adView;
    }

    /* renamed from: A */
    public View m59880A() {
        List<WaterFallConfig> list;
        View view;
        TTBaseAd tTBaseAd;
        TTBaseAd next;
        List<TTBaseAdCache> m59708a;
        TTBaseAd tTBaseAd2;
        AdEventUtil.m59322a(this.f21795h);
        TTBaseAd tTBaseAd3 = this.f21752B;
        if (tTBaseAd3 != null) {
            AdEventUtil.m59299e(tTBaseAd3, this.f21795h);
            return this.f21752B.getAdView();
        } else if (this.f21789b.get()) {
            AdEventUtil.m59308a((List<TTBaseAd>) null, this.f21795h);
            m59875b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            return null;
        } else {
            List<TTBaseAd> m59879B = m59879B();
            try {
                list = m37377t();
            } catch (Throwable th) {
                th.printStackTrace();
                list = null;
            }
            if (list != null && list.size() > 0) {
                HashMap<String, TTBaseAd> m37400b = m37400b(m59879B);
                view = null;
                for (WaterFallConfig waterFallConfig : list) {
                    if (waterFallConfig != null) {
                        String m59480c = waterFallConfig.m59480c();
                        TTBaseAd tTBaseAd4 = m37400b.get(m59480c);
                        if (tTBaseAd4 != null && !tTBaseAd4.isHasShown() && (view = m59872c(tTBaseAd4)) != null) {
                            break;
                        } else if (waterFallConfig.m59474e() != 2 && AdCacheManager.m59712a().m59699c(m59480c, m37363a()) && AdCacheManager.m59712a().m59701b(m59480c, this.f21795h) == 3 && (m59708a = AdCacheManager.m59712a().m59708a(m59480c, this.f21795h)) != null && m59708a.size() > 0 && (tTBaseAd2 = m59708a.get(0).f425a) != null && !tTBaseAd2.isHasShown()) {
                            m37402b(tTBaseAd2);
                            view = m59872c(tTBaseAd2);
                            if (view != null) {
                                break;
                            }
                        }
                    }
                }
            } else {
                view = null;
            }
            if (view == null && m59879B != null && m59879B.size() > 0) {
                Iterator<TTBaseAd> it = m59879B.iterator();
                while (it.hasNext() && ((next = it.next()) == null || next.isHasShown() || (view = m59872c(next)) == null)) {
                }
            }
            if (view == null) {
                AdEventUtil.m59308a(m59879B, this.f21795h);
                m59875b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
                return null;
            }
            if (this.f21752B != null && m37338j()) {
                AdEventUtil.m59301c(this.f21752B, this.f21795h);
            }
            AdEventUtil.m59299e(this.f21752B, this.f21795h);
            if (this.f278O != null && (tTBaseAd = this.f21752B) != null && tTBaseAd.getAdNetworkPlatformId() == 2) {
                Logger.m37562d("ADMOB_EVENT", TTLogUtil.getTagThirdLevelById(this.f21752B.getRit(), this.f21752B.getAdNetworkSlotId()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                this.f278O.onAdShow();
                if (this.f21752B != null) {
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.f21752B.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()));
                }
                AdEventUtil.m59298f(this.f21752B, this.f21795h);
                TTLoaderUtil.m37308o(this.f21752B);
            }
            TTBaseAd tTBaseAd5 = this.f21752B;
            if (tTBaseAd5 != null && !tTBaseAd5.isServerBiddingAd() && AdCacheManager.m59712a().m59699c(this.f21752B.getAdNetworkSlotId(), m37363a())) {
                AdCacheManager.m59712a().m59706a(this.f21752B.getAdNetworkSlotId(), this.f21795h, this.f21804q, true, this.f21757G, this.f21808u, this.f21769z);
            }
            return view;
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    protected void mo37415a(AdError adError) {
        TTAdBannerLoadCallBack tTAdBannerLoadCallBack = this.f279P;
        if (tTAdBannerLoadCallBack != null) {
            tTAdBannerLoadCallBack.onAdFailedToLoad(adError);
        }
    }

    /* renamed from: a */
    public void m59877a(AdSlot adSlot, TTAdBannerLoadCallBack tTAdBannerLoadCallBack) {
        AdSlot shallowCopy = AdSlotInner.getShallowCopy(adSlot);
        this.f21795h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(1);
            this.f21795h.setAdCount(1);
        }
        this.f279P = tTAdBannerLoadCallBack;
        this.f21751A = this;
        m37373x();
    }

    /* renamed from: a */
    public void m59876a(TTAdBannerListener tTAdBannerListener) {
        this.f278O = tTAdBannerListener;
    }

    /* renamed from: b */
    public void m59874b(boolean z) {
        this.f21804q.put(TTRequestExtraParams.PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN, Boolean.valueOf(z));
    }

    /* renamed from: c */
    public void m59873c(int i) {
        this.f21804q.put(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME, Integer.valueOf(i));
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: o */
    public void mo37382o() {
        super.mo37382o();
        this.f278O = null;
        this.f279P = null;
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdClicked() {
        TTAdBannerListener tTAdBannerListener = this.f278O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdClicked();
        }
        AdEventUtil.m59300d(this.f21752B, this.f21795h);
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdClosed() {
        TTAdBannerListener tTAdBannerListener = this.f278O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdLeftApplication() {
        TTAdBannerListener tTAdBannerListener = this.f278O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdOpened() {
        TTAdBannerListener tTAdBannerListener = this.f278O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdShow() {
        if (this.f278O != null) {
            IntervalShowControl m59587b = IntervalShowControl.m59587b();
            m59587b.m59589a(this.f21793f + "");
            IntervalShowControl m59587b2 = IntervalShowControl.m59587b();
            m59587b2.m59575j(this.f21793f + "");
            this.f278O.onAdShow();
        }
        if (this.f21752B != null) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.f21752B.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(this.f21752B.getAdNetworkPlatformId()));
        }
        AdEventUtil.m59298f(this.f21752B, this.f21795h);
        TTLoaderUtil.m37308o(this.f21752B);
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdShowFail(AdError adError) {
        AdEventUtil.m59309a(this.f21752B, this.f21795h, adError, 1);
        m59875b(adError);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: u */
    protected void mo37376u() {
        TTAdBannerLoadCallBack tTAdBannerLoadCallBack = this.f279P;
        if (tTAdBannerLoadCallBack != null) {
            tTAdBannerLoadCallBack.onAdLoaded();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: v */
    protected void mo37375v() {
    }
}
