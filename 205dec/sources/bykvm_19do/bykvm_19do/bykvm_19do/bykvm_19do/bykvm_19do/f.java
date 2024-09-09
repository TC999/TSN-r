package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.u;
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
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: TTInterSplashAdManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f extends TTAdHeaderBidingRequestCore implements ITTAdapterSplashAdListener {
    private TTSplashAdLoadCallback O;
    private TTSplashAdListener P;
    private TTSplashMinWindowListener Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterSplashAdManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdError f294a;

        a(AdError adError) {
            this.f294a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.P != null) {
                f.this.P.onAdShowFail(this.f294a);
            }
        }
    }

    public f(Activity activity, View view, String str) {
        super(activity, str);
    }

    public f(Activity activity, String str) {
        super(activity, str);
    }

    private List<TTBaseAd> D() {
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

    private void a(TTBaseAd tTBaseAd, ViewGroup viewGroup) {
        this.B = tTBaseAd;
        tTBaseAd.setHasShown(true);
        this.B.setTTAdatperCallback(this.A);
        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(tTBaseAd.getRit(), "show") + "\u5c55\u793a\u7684\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()) + ",slotId\uff1a" + this.B.getAdNetworkSlotId() + ",slotType:" + this.B.getAdNetworkSlotType());
        i b4 = i.b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27883f);
        sb.append("");
        b4.a(sb.toString());
        i b5 = i.b();
        b5.j(this.f27883f + "");
        this.B.showSplashAd(viewGroup);
    }

    private void b(AdError adError) {
        ThreadHelper.runOnUiThread(new a(adError));
    }

    public int[] A() {
        TTBaseAd tTBaseAd = this.B;
        if (tTBaseAd != null) {
            tTBaseAd.getMinWindowSize();
            return null;
        }
        return null;
    }

    public Bitmap B() {
        TTBaseAd tTBaseAd = this.B;
        if (tTBaseAd != null) {
            tTBaseAd.getSplashBitMap();
            return null;
        }
        return null;
    }

    public void C() {
        TTBaseAd tTBaseAd = this.B;
        if (tTBaseAd != null) {
            tTBaseAd.splashMinWindowAnimationFinish();
        }
    }

    public void a(ViewGroup viewGroup) {
        AdError adError;
        boolean z3;
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> a4;
        TTBaseAd tTBaseAd;
        List<TTBaseAd> D = D();
        g.a(this.f27885h);
        if (viewGroup == null || this.f27879b.get()) {
            g.a(D, this.f27885h);
            adError = new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD));
        } else {
            List<h> list = null;
            try {
                list = t();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean z4 = false;
            boolean z5 = true;
            if (list != null && list.size() > 0) {
                HashMap<String, TTBaseAd> b4 = b(D);
                for (h hVar : list) {
                    if (hVar != null) {
                        String c4 = hVar.c();
                        TTBaseAd tTBaseAd2 = b4.get(c4);
                        if (tTBaseAd2 != null && tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                            a(tTBaseAd2, viewGroup);
                        } else if (hVar.e() != 2 && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(c4, a()) && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().b(c4, this.f27885h) == 3 && (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(c4, this.f27885h)) != null && a4.size() > 0 && (tTBaseAd = a4.get(0).f418a) != null && tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, "show") + "adSlotId\uff1a" + tTBaseAd.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()\uff1a" + tTBaseAd.isReady());
                            b(tTBaseAd);
                            a(tTBaseAd, viewGroup);
                        }
                        z3 = true;
                        z4 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (!z4 && D != null && D.size() > 0) {
                for (TTBaseAd tTBaseAd3 : D) {
                    if (tTBaseAd3 != null && tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                        a(tTBaseAd3, viewGroup);
                        break;
                    }
                }
            }
            z5 = z3;
            if (z5) {
                if (j()) {
                    g.c(this.B, this.f27885h);
                }
                g.e(this.B, this.f27885h);
                if (this.B.isServerBiddingAd() || !bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.B.getAdNetworkSlotId(), a())) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.B.getAdNetworkSlotId(), this.f27885h, this.f27894q, true, this.G, this.f27898u, this.f27859z);
                return;
            }
            g.a(D, this.f27885h);
            adError = new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD));
        }
        b(adError);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void a(AdError adError) {
        TTSplashAdLoadCallback tTSplashAdLoadCallback = this.O;
        if (tTSplashAdLoadCallback != null) {
            if (adError.code == 4011) {
                tTSplashAdLoadCallback.onAdLoadTimeout();
            } else {
                tTSplashAdLoadCallback.onSplashAdLoadFail(adError);
            }
        }
    }

    public void a(AdSlot adSlot, TTNetworkRequestInfo tTNetworkRequestInfo, TTSplashAdLoadCallback tTSplashAdLoadCallback, int i4) {
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(adSlot);
        this.f27885h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(3);
            this.f27885h.setAdCount(1);
        }
        this.G = tTNetworkRequestInfo;
        this.O = tTSplashAdLoadCallback;
        this.f27894q.put(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT, Integer.valueOf(i4));
        this.A = this;
        x();
    }

    public void a(TTSplashAdListener tTSplashAdListener) {
        this.P = tTSplashAdListener;
    }

    public void a(TTSplashMinWindowListener tTSplashMinWindowListener) {
        this.Q = tTSplashMinWindowListener;
    }

    public boolean a(Rect rect, ITTAdatperCallback iTTAdatperCallback) {
        TTBaseAd tTBaseAd = this.B;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() != 7) {
            return false;
        }
        this.B.showMinWindow(rect, iTTAdatperCallback);
        return true;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void o() {
        super.o();
        this.P = null;
        this.O = null;
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdClicked() {
        TTSplashAdListener tTSplashAdListener = this.P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdClicked();
        }
        g.d(this.B, this.f27885h);
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdDismiss() {
        TTSplashAdListener tTSplashAdListener = this.P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdDismiss();
        }
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdShow() {
        TTSplashAdListener tTSplashAdListener = this.P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdShow();
        }
        if (this.B != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.B.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()));
        }
        g.f(this.B, this.f27885h);
        com.bytedance.msdk.core.corelogic.f.o(this.B);
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdShowFail(AdError adError) {
        g.a(this.B, this.f27885h, adError, 1);
        b(adError);
    }

    @Override // com.bytedance.msdk.api.splash.TTSplashAdListener
    public void onAdSkip() {
        TTSplashAdListener tTSplashAdListener = this.P;
        if (tTSplashAdListener != null) {
            tTSplashAdListener.onAdSkip();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onMinWindowPlayFinish() {
        TTSplashMinWindowListener tTSplashMinWindowListener = this.Q;
        if (tTSplashMinWindowListener != null) {
            tTSplashMinWindowListener.onMinWindowPlayFinish();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onMinWindowStart() {
        TTSplashMinWindowListener tTSplashMinWindowListener = this.Q;
        if (tTSplashMinWindowListener != null) {
            tTSplashMinWindowListener.onMinWindowStart();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public int q() {
        TTBaseAd tTBaseAd = this.B;
        if (tTBaseAd != null && tTBaseAd.getLoadSort() == -4 && this.B.getShowSort() == -4) {
            return this.B.getAdNetworkPlatformId();
        }
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().m()) {
            return super.q();
        }
        return -3;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public String r() {
        TTBaseAd tTBaseAd = this.B;
        return (tTBaseAd != null && tTBaseAd.getLoadSort() == -4 && this.B.getShowSort() == -4) ? this.B.getAdNetworkSlotId() : !bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().m() ? NetworkPlatformConst.AD_NETWORK_NO_PERMISSION : super.r();
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public String s() {
        TTBaseAd tTBaseAd = this.B;
        return (tTBaseAd != null && tTBaseAd.getLoadSort() == -4 && this.B.getShowSort() == -4) ? this.B.getNetWorkPlatFormCpm() : !bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().m() ? NetworkPlatformConst.AD_NETWORK_NO_PERMISSION : super.s();
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void u() {
        TTSplashAdLoadCallback tTSplashAdLoadCallback = this.O;
        if (tTSplashAdLoadCallback != null) {
            tTSplashAdLoadCallback.onSplashAdLoadSuccess();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void v() {
    }
}
