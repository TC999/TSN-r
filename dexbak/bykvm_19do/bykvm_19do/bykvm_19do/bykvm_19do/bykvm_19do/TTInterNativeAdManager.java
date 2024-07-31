package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b.TTNativeAdImpl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdCacheManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.TTBaseAdCache;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTCollectionUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.nativeAd.TTNativeAd;
import com.bytedance.msdk.api.nativeAd.TTNativeAdLoadCallback;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTInterNativeAdManager extends TTAdHeaderBidingRequestCore {

    /* renamed from: O */
    private TTNativeAdLoadCallback f288O;

    public TTInterNativeAdManager(Context context, String str) {
        super(context, str);
    }

    /* renamed from: A */
    private void m59865A() {
        List<TTBaseAd> list;
        try {
            List<WaterFallConfig> m37377t = m37377t();
            if (m37377t == null || m37377t.size() <= 0) {
                return;
            }
            for (WaterFallConfig waterFallConfig : m37377t) {
                if (waterFallConfig != null) {
                    String m59480c = waterFallConfig.m59480c();
                    if (AdCacheManager.m59712a().m59699c(m59480c, m37363a())) {
                        if (waterFallConfig.m59474e() == 100) {
                            list = this.f21803p;
                        } else if (waterFallConfig.m59474e() == 0) {
                            list = this.f21801n;
                        } else if (waterFallConfig.m59474e() == 1) {
                            list = this.f21802o;
                        }
                        m59861a(m59480c, list);
                    }
                }
            }
            TTLoaderUtil.m37314i(this.f21803p, null);
            TTLoaderUtil.m37314i(this.f21801n, null);
            TTLoaderUtil.m37314i(this.f21802o, TTLoaderUtil.m37307p());
            Logger.m37562d("TMe", "--==-- sorted ok");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: B */
    private boolean m59864B() {
        for (TTBaseAd tTBaseAd : this.f21802o) {
            if (tTBaseAd != null && tTBaseAd.getCpm() != Utils.DOUBLE_EPSILON) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: C */
    private List<TTNativeAd> m59863C() {
        AdSlot adSlot = this.f21795h;
        if (adSlot == null) {
            return null;
        }
        int adCount = adSlot.getAdCount();
        m59857c(this.f21803p);
        m59857c(this.f21802o);
        m59857c(this.f21801n);
        m59865A();
        List<TTBaseAd> arrayList = new ArrayList<>();
        if (!TTCollectionUtils.m59112a(this.f21803p)) {
            arrayList.addAll(this.f21803p);
            if (Logger.isDebug()) {
                for (TTBaseAd tTBaseAd : arrayList) {
                    Logger.m37557e("TTMediationSDK", "");
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(tTBaseAd.getRit(), tTBaseAd.getAdNetworkSlotId()) + "00-合并排序后：" + this.f21803p.size() + "，cpm=" + tTBaseAd.getCpm() + ",广告类型：" + C6031a.m37434d(tTBaseAd.getAdNetworkPlatformId()) + ",ImageMode=" + tTBaseAd.getImageMode() + ",showSort=" + tTBaseAd.getShowSort());
                }
            }
        }
        if (arrayList.size() >= adCount) {
            return m59860a(arrayList, adCount);
        }
        List<TTBaseAd> m59858c = m59858c(adCount - arrayList.size());
        if (!TTCollectionUtils.m59112a(m59858c)) {
            arrayList.addAll(m59858c);
        }
        return m59860a(arrayList, adCount);
    }

    /* renamed from: a */
    private List<TTNativeAd> m59860a(List<TTBaseAd> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        if (list.get(0) != null && m37338j()) {
            AdEventUtil.m59301c(list.get(0), this.f21795h);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTBaseAd> it = list.iterator();
        while (it.hasNext() && arrayList.size() < i) {
            TTBaseAd next = it.next();
            if (Logger.isDebug()) {
                Logger.m37557e("TTMediationSDK", "");
                Logger.m37557e("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(next.getRit(), TTLogUtil.TAG_EVENT_SHOW) + "返回给开发者最终广告：slotId=" + next.getAdNetworkSlotId() + ",slotType:" + next.getAdNetworkSlotType() + ",cpm=" + next.getCpm() + ",广告类型：" + C6031a.m37434d(next.getAdNetworkPlatformId()) + ",ImageMode=" + next.getImageMode() + ",showSort=" + next.getShowSort() + ",isExpressAd=" + next.isExpressAd());
            }
            arrayList.add(new TTNativeAdImpl(next, this.f21795h));
            it.remove();
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m59861a(String str, List<TTBaseAd> list) {
        List<TTBaseAdCache> m59708a;
        TTBaseAd tTBaseAd;
        if (m59859b(str, list) || AdCacheManager.m59712a().m59701b(str, this.f21795h) != 3 || (m59708a = AdCacheManager.m59712a().m59708a(str, this.f21795h)) == null || m59708a.size() <= 0) {
            return;
        }
        for (TTBaseAdCache tTBaseAdCache : m59708a) {
            if (tTBaseAdCache != null && (tTBaseAd = tTBaseAdCache.f425a) != null && !tTBaseAd.isHasShown()) {
                list.add(tTBaseAdCache.f425a);
                m37402b(tTBaseAdCache.f425a);
            }
        }
    }

    /* renamed from: b */
    private boolean m59859b(String str, List<TTBaseAd> list) {
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
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.bytedance.msdk.base.TTBaseAd> m59858c(int r18) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.TTInterNativeAdManager.m59858c(int):java.util.List");
    }

    /* renamed from: c */
    private void m59857c(List<TTBaseAd> list) {
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
    /* renamed from: a */
    protected void mo37415a(AdError adError) {
        TTNativeAdLoadCallback tTNativeAdLoadCallback = this.f288O;
        if (tTNativeAdLoadCallback != null) {
            tTNativeAdLoadCallback.onAdLoadedFial(adError);
        }
    }

    /* renamed from: a */
    public void m59862a(AdSlot adSlot, TTNativeAdLoadCallback tTNativeAdLoadCallback) {
        int i;
        AdSlot adSlot2;
        AdSlot shallowCopy = AdSlotInner.getShallowCopy(adSlot);
        this.f21795h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(5);
            if (this.f21795h.getAdCount() <= 0) {
                adSlot2 = this.f21795h;
                i = 1;
            } else {
                i = 3;
                if (this.f21795h.getAdCount() > 3) {
                    adSlot2 = this.f21795h;
                }
                TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f21795h);
            }
            adSlot2.setAdCount(i);
            TTVideoOptionUtil.setFeedTTVideoOptionIfNeed(this.f21795h);
        }
        this.f288O = tTNativeAdLoadCallback;
        m37373x();
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: o */
    public void mo37382o() {
        super.mo37382o();
        this.f288O = null;
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: u */
    protected void mo37376u() {
        List<TTNativeAd> m59863C;
        if (this.f288O == null || (m59863C = m59863C()) == null || m59863C.size() <= 0) {
            return;
        }
        if (Logger.isDebug()) {
            Logger.m37557e("TTMediationSDK", "返回给外部开发者的广告数量：sumList.size=" + m59863C.size());
        }
        for (TTNativeAd tTNativeAd : m59863C) {
            tTNativeAd.setHasShown(true);
            tTNativeAd.setTTAdatperCallback(this.f21751A);
        }
        this.f288O.onAdLoaded(m59863C);
        int i = 0;
        while (i < m59863C.size()) {
            TTNativeAd tTNativeAd2 = m59863C.get(i);
            if (tTNativeAd2 != null && !tTNativeAd2.isServerBidding() && AdCacheManager.m59712a().m59699c(tTNativeAd2.getAdNetworkRitId(), m37363a())) {
                AdCacheManager.m59712a().m59706a(tTNativeAd2.getAdNetworkRitId(), this.f21795h, this.f21804q, i == 0, this.f21757G, this.f21808u, this.f21769z);
            }
            i++;
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: v */
    protected void mo37375v() {
    }
}
