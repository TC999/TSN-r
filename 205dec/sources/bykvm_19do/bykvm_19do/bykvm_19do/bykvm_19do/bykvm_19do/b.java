package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.u;
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
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: TTInterBannerAdManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b extends TTAdHeaderBidingRequestCore implements ITTAdapterBannerAdListener {
    private TTAdBannerListener O;
    private TTAdBannerLoadCallBack P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterBannerAdManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements TTDislikeCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f285a;

        a(b bVar, View view) {
            this.f285a = view;
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onCancel() {
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onRefuse() {
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onSelected(int i4, String str) {
            View view = this.f285a;
            if (view != null) {
                View view2 = (View) view.getParent();
                if (view2 instanceof ViewGroup) {
                    ((ViewGroup) view2).removeViewInLayout(this.f285a);
                }
            }
        }

        @Override // com.bytedance.msdk.api.TTDislikeCallback
        public void onShow() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterBannerAdManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class RunnableC0017b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdError f286a;

        RunnableC0017b(AdError adError) {
            this.f286a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.O != null) {
                b.this.O.onAdShowFail(this.f286a);
            }
        }
    }

    public b(Context context, String str) {
        super(context, str);
    }

    private List<TTBaseAd> B() {
        if (u.a(this.f27893p)) {
            if (u.a(this.f27892o) && u.a(this.f27891n)) {
                return null;
            }
            if (u.a(this.f27892o) || !u.a(this.f27891n)) {
                if (u.a(this.f27891n) || !u.a(this.f27892o)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f27891n);
                    arrayList.addAll(this.f27892o);
                    if (h()) {
                        Collections.sort(arrayList, com.bytedance.msdk.core.corelogic.f.p());
                    }
                    return arrayList;
                }
                return this.f27891n;
            }
            return this.f27892o;
        }
        return this.f27893p;
    }

    private void b(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0017b(adError));
    }

    private View c(TTBaseAd tTBaseAd) {
        this.B = tTBaseAd;
        tTBaseAd.setHasShown(true);
        this.B.setTTAdatperCallback(this.A);
        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.B.getRit(), "show") + "\u5c55\u793a\u7684\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()) + ",slotId\uff1a" + this.B.getAdNetworkSlotId() + ",slotType:" + this.B.getAdNetworkSlotType());
        View adView = this.B.getAdView();
        if (this.B.hasDislike()) {
            this.B.setDislikeCallback((Activity) this.f27859z, new a(this, adView));
        }
        return adView;
    }

    public View A() {
        List<h> list;
        View view;
        TTBaseAd tTBaseAd;
        TTBaseAd next;
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> a4;
        TTBaseAd tTBaseAd2;
        g.a(this.f27885h);
        TTBaseAd tTBaseAd3 = this.B;
        if (tTBaseAd3 != null) {
            g.e(tTBaseAd3, this.f27885h);
            return this.B.getAdView();
        } else if (this.f27879b.get()) {
            g.a((List<TTBaseAd>) null, this.f27885h);
            b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            return null;
        } else {
            List<TTBaseAd> B = B();
            try {
                list = t();
            } catch (Throwable th) {
                th.printStackTrace();
                list = null;
            }
            if (list != null && list.size() > 0) {
                HashMap<String, TTBaseAd> b4 = b(B);
                view = null;
                for (h hVar : list) {
                    if (hVar != null) {
                        String c4 = hVar.c();
                        TTBaseAd tTBaseAd4 = b4.get(c4);
                        if (tTBaseAd4 != null && !tTBaseAd4.isHasShown() && (view = c(tTBaseAd4)) != null) {
                            break;
                        } else if (hVar.e() != 2 && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(c4, a()) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().b(c4, this.f27885h) == 3 && (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(c4, this.f27885h)) != null && a4.size() > 0 && (tTBaseAd2 = a4.get(0).f418a) != null && !tTBaseAd2.isHasShown()) {
                            b(tTBaseAd2);
                            view = c(tTBaseAd2);
                            if (view != null) {
                                break;
                            }
                        }
                    }
                }
            } else {
                view = null;
            }
            if (view == null && B != null && B.size() > 0) {
                Iterator<TTBaseAd> it = B.iterator();
                while (it.hasNext() && ((next = it.next()) == null || next.isHasShown() || (view = c(next)) == null)) {
                }
            }
            if (view == null) {
                g.a(B, this.f27885h);
                b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
                return null;
            }
            if (this.B != null && j()) {
                g.c(this.B, this.f27885h);
            }
            g.e(this.B, this.f27885h);
            if (this.O != null && (tTBaseAd = this.B) != null && tTBaseAd.getAdNetworkPlatformId() == 2) {
                Logger.d("ADMOB_EVENT", TTLogUtil.getTagThirdLevelById(this.B.getRit(), this.B.getAdNetworkSlotId()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                this.O.onAdShow();
                if (this.B != null) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.B.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()));
                }
                g.f(this.B, this.f27885h);
                com.bytedance.msdk.core.corelogic.f.o(this.B);
            }
            TTBaseAd tTBaseAd5 = this.B;
            if (tTBaseAd5 != null && !tTBaseAd5.isServerBiddingAd() && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.B.getAdNetworkSlotId(), a())) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.B.getAdNetworkSlotId(), this.f27885h, this.f27894q, true, this.G, this.f27898u, this.f27859z);
            }
            return view;
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void a(AdError adError) {
        TTAdBannerLoadCallBack tTAdBannerLoadCallBack = this.P;
        if (tTAdBannerLoadCallBack != null) {
            tTAdBannerLoadCallBack.onAdFailedToLoad(adError);
        }
    }

    public void a(AdSlot adSlot, TTAdBannerLoadCallBack tTAdBannerLoadCallBack) {
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(adSlot);
        this.f27885h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(1);
            this.f27885h.setAdCount(1);
        }
        this.P = tTAdBannerLoadCallBack;
        this.A = this;
        x();
    }

    public void a(TTAdBannerListener tTAdBannerListener) {
        this.O = tTAdBannerListener;
    }

    public void b(boolean z3) {
        this.f27894q.put(TTRequestExtraParams.PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN, Boolean.valueOf(z3));
    }

    public void c(int i4) {
        this.f27894q.put(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME, Integer.valueOf(i4));
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void o() {
        super.o();
        this.O = null;
        this.P = null;
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdClicked() {
        TTAdBannerListener tTAdBannerListener = this.O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdClicked();
        }
        g.d(this.B, this.f27885h);
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdClosed() {
        TTAdBannerListener tTAdBannerListener = this.O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdLeftApplication() {
        TTAdBannerListener tTAdBannerListener = this.O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdOpened() {
        TTAdBannerListener tTAdBannerListener = this.O;
        if (tTAdBannerListener != null) {
            tTAdBannerListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdShow() {
        if (this.O != null) {
            i b4 = i.b();
            b4.a(this.f27883f + "");
            i b5 = i.b();
            b5.j(this.f27883f + "");
            this.O.onAdShow();
        }
        if (this.B != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.B.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()));
        }
        g.f(this.B, this.f27885h);
        com.bytedance.msdk.core.corelogic.f.o(this.B);
    }

    @Override // com.bytedance.msdk.api.banner.TTAdBannerListener
    public void onAdShowFail(AdError adError) {
        g.a(this.B, this.f27885h, adError, 1);
        b(adError);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void u() {
        TTAdBannerLoadCallBack tTAdBannerLoadCallBack = this.P;
        if (tTAdBannerLoadCallBack != null) {
            tTAdBannerLoadCallBack.onAdLoaded();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void v() {
    }
}
