package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.u;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.nativeAd.TTNativeAd;
import com.bytedance.msdk.api.nativeAd.TTNativeAdLoadCallback;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TTInterNativeAdManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d extends TTAdHeaderBidingRequestCore {
    private TTNativeAdLoadCallback O;

    public d(Context context, String str) {
        super(context, str);
    }

    private void A() {
        List<TTBaseAd> list;
        try {
            List<h> t3 = t();
            if (t3 == null || t3.size() <= 0) {
                return;
            }
            for (h hVar : t3) {
                if (hVar != null) {
                    String c4 = hVar.c();
                    if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(c4, a())) {
                        if (hVar.e() == 100) {
                            list = this.f27893p;
                        } else if (hVar.e() == 0) {
                            list = this.f27891n;
                        } else if (hVar.e() == 1) {
                            list = this.f27892o;
                        }
                        a(c4, list);
                    }
                }
            }
            com.bytedance.msdk.core.corelogic.f.i(this.f27893p, null);
            com.bytedance.msdk.core.corelogic.f.i(this.f27891n, null);
            com.bytedance.msdk.core.corelogic.f.i(this.f27892o, com.bytedance.msdk.core.corelogic.f.p());
            Logger.d("TMe", "--==-- sorted ok");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean B() {
        for (TTBaseAd tTBaseAd : this.f27892o) {
            if (tTBaseAd != null && tTBaseAd.getCpm() != 0.0d) {
                return false;
            }
        }
        return true;
    }

    private List<TTNativeAd> C() {
        AdSlot adSlot = this.f27885h;
        if (adSlot == null) {
            return null;
        }
        int adCount = adSlot.getAdCount();
        c(this.f27893p);
        c(this.f27892o);
        c(this.f27891n);
        A();
        List<TTBaseAd> arrayList = new ArrayList<>();
        if (!u.a(this.f27893p)) {
            arrayList.addAll(this.f27893p);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd : arrayList) {
                    Logger.e("TTMediationSDK", "");
                    Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(tTBaseAd.getRit(), tTBaseAd.getAdNetworkSlotId()) + "00-\u5408\u5e76\u6392\u5e8f\u540e\uff1a" + this.f27893p.size() + "\uff0ccpm=" + tTBaseAd.getCpm() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(tTBaseAd.getAdNetworkPlatformId()) + ",ImageMode=" + tTBaseAd.getImageMode() + ",showSort=" + tTBaseAd.getShowSort());
                }
            }
        }
        if (arrayList.size() >= adCount) {
            return a(arrayList, adCount);
        }
        List<TTBaseAd> c4 = c(adCount - arrayList.size());
        if (!u.a(c4)) {
            arrayList.addAll(c4);
        }
        return a(arrayList, adCount);
    }

    private List<TTNativeAd> a(List<TTBaseAd> list, int i4) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        if (list.get(0) != null && j()) {
            g.c(list.get(0), this.f27885h);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTBaseAd> it = list.iterator();
        while (it.hasNext() && arrayList.size() < i4) {
            TTBaseAd next = it.next();
            if (Logger.isDebug()) {
                Logger.e("TTMediationSDK", "");
                Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(next.getRit(), "show") + "\u8fd4\u56de\u7ed9\u5f00\u53d1\u8005\u6700\u7ec8\u5e7f\u544a\uff1aslotId=" + next.getAdNetworkSlotId() + ",slotType:" + next.getAdNetworkSlotType() + ",cpm=" + next.getCpm() + ",\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(next.getAdNetworkPlatformId()) + ",ImageMode=" + next.getImageMode() + ",showSort=" + next.getShowSort() + ",isExpressAd=" + next.isExpressAd());
            }
            arrayList.add(new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b.a(next, this.f27885h));
            it.remove();
        }
        return arrayList;
    }

    private void a(String str, List<TTBaseAd> list) {
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f> a4;
        TTBaseAd tTBaseAd;
        if (b(str, list) || bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().b(str, this.f27885h) != 3 || (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(str, this.f27885h)) == null || a4.size() <= 0) {
            return;
        }
        for (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f fVar : a4) {
            if (fVar != null && (tTBaseAd = fVar.f418a) != null && !tTBaseAd.isHasShown()) {
                list.add(fVar.f418a);
                b(fVar.f418a);
            }
        }
    }

    private boolean b(String str, List<TTBaseAd> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (TTBaseAd tTBaseAd : list) {
            if (tTBaseAd != null && TextUtils.equals(str, tTBaseAd.getAdNetworkSlotId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.bytedance.msdk.base.TTBaseAd> c(int r18) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d.c(int):java.util.List");
    }

    private void c(List<TTBaseAd> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<TTBaseAd> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (TTBaseAd tTBaseAd : arrayList) {
            if (tTBaseAd != null && !tTBaseAd.isHasShown()) {
                list.add(tTBaseAd);
            }
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void a(AdError adError) {
        TTNativeAdLoadCallback tTNativeAdLoadCallback = this.O;
        if (tTNativeAdLoadCallback != null) {
            tTNativeAdLoadCallback.onAdLoadedFial(adError);
        }
    }

    public void a(AdSlot adSlot, TTNativeAdLoadCallback tTNativeAdLoadCallback) {
        int i4;
        AdSlot adSlot2;
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(adSlot);
        this.f27885h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(5);
            if (this.f27885h.getAdCount() <= 0) {
                adSlot2 = this.f27885h;
                i4 = 1;
            } else {
                i4 = 3;
                if (this.f27885h.getAdCount() > 3) {
                    adSlot2 = this.f27885h;
                }
                TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f27885h);
            }
            adSlot2.setAdCount(i4);
            TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f27885h);
        }
        this.O = tTNativeAdLoadCallback;
        x();
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void o() {
        super.o();
        this.O = null;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void u() {
        List<TTNativeAd> C;
        if (this.O == null || (C = C()) == null || C.size() <= 0) {
            return;
        }
        if (Logger.isDebug()) {
            Logger.e("TTMediationSDK", "\u8fd4\u56de\u7ed9\u5916\u90e8\u5f00\u53d1\u8005\u7684\u5e7f\u544a\u6570\u91cf\uff1asumList.size=" + C.size());
        }
        for (TTNativeAd tTNativeAd : C) {
            tTNativeAd.setHasShown(true);
            tTNativeAd.setTTAdatperCallback(this.A);
        }
        this.O.onAdLoaded(C);
        int i4 = 0;
        while (i4 < C.size()) {
            TTNativeAd tTNativeAd2 = C.get(i4);
            if (tTNativeAd2 != null && !tTNativeAd2.isServerBidding() && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(tTNativeAd2.getAdNetworkRitId(), a())) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(tTNativeAd2.getAdNetworkRitId(), this.f27885h, this.f27894q, i4 == 0, this.G, this.f27898u, this.f27859z);
            }
            i4++;
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void v() {
    }
}
