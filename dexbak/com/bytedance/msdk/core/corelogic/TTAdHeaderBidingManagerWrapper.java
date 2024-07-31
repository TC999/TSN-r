package com.bytedance.msdk.core.corelogic;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdCacheManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.PreLoadManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.TTBaseAdCache;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.NetworkUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTCollectionUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.msdk.core.corelogic.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class TTAdHeaderBidingManagerWrapper extends TTAdHeaderBidingRequestCore {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTAdHeaderBidingManagerWrapper.java */
    /* renamed from: com.bytedance.msdk.core.corelogic.e$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6047a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ TTBaseAd f21811a;

        RunnableC6047a(TTBaseAd tTBaseAd) {
            this.f21811a = tTBaseAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd = this.f21811a;
            if (tTBaseAd != null && tTBaseAd.adnHasAdVideoCachedApi() && this.f21811a.isCacheSuccess()) {
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(TTAdHeaderBidingManagerWrapper.this.f21793f, this.f21811a.getAdNetworkSlotId()) + "在show时触发了预加载【" + this.f21811a.getAdNetWorkName() + "】, loadSort: " + this.f21811a.getLoadSort() + ", showSort: " + this.f21811a.getShowSort());
                PreLoadManager m59686a = PreLoadManager.m59686a();
                TTAdHeaderBidingManagerWrapper tTAdHeaderBidingManagerWrapper = TTAdHeaderBidingManagerWrapper.this;
                m59686a.m59675b(tTAdHeaderBidingManagerWrapper.f21769z, tTAdHeaderBidingManagerWrapper.f21793f, tTAdHeaderBidingManagerWrapper.m37363a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTAdHeaderBidingManagerWrapper.java */
    /* renamed from: com.bytedance.msdk.core.corelogic.e$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6048b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ TTBaseAd f21813a;

        /* renamed from: b */
        final /* synthetic */ Activity f21814b;

        /* renamed from: c */
        final /* synthetic */ Map f21815c;

        RunnableC6048b(TTBaseAd tTBaseAd, Activity activity, Map map) {
            this.f21813a = tTBaseAd;
            this.f21814b = activity;
            this.f21815c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            TTBaseAd tTBaseAd = this.f21813a;
            if (tTBaseAd != null) {
                TTAdHeaderBidingManagerWrapper.this.f21752B = tTBaseAd;
                boolean z2 = true;
                tTBaseAd.setHasShown(true);
                TTAdHeaderBidingManagerWrapper tTAdHeaderBidingManagerWrapper = TTAdHeaderBidingManagerWrapper.this;
                tTAdHeaderBidingManagerWrapper.f21752B.setTTAdatperCallback(tTAdHeaderBidingManagerWrapper.f21751A);
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(TTAdHeaderBidingManagerWrapper.this.f21793f, TTLogUtil.TAG_EVENT_SHOW) + "展示的广告类型：" + C6031a.m37434d(TTAdHeaderBidingManagerWrapper.this.f21752B.getAdNetworkPlatformId()) + ",slotId：" + TTAdHeaderBidingManagerWrapper.this.f21752B.getAdNetworkSlotId() + ",slotType:" + TTAdHeaderBidingManagerWrapper.this.f21752B.getAdNetworkSlotType() + ",isReady()：" + TTAdHeaderBidingManagerWrapper.this.f21752B.isReady() + "，是否为缓存广告:" + TTAdHeaderBidingManagerWrapper.this.f21752B.isCacheSuccess());
                TTAdHeaderBidingManagerWrapper.this.f21752B.showAd(this.f21814b, this.f21815c);
                if (TTAdHeaderBidingManagerWrapper.this.m37338j()) {
                    TTAdHeaderBidingManagerWrapper tTAdHeaderBidingManagerWrapper2 = TTAdHeaderBidingManagerWrapper.this;
                    AdEventUtil.m59301c(tTAdHeaderBidingManagerWrapper2.f21752B, tTAdHeaderBidingManagerWrapper2.f21795h);
                }
                IntervalShowControl m59587b = IntervalShowControl.m59587b();
                m59587b.m59589a(TTAdHeaderBidingManagerWrapper.this.f21793f + "");
                IntervalShowControl m59587b2 = IntervalShowControl.m59587b();
                m59587b2.m59575j(TTAdHeaderBidingManagerWrapper.this.f21793f + "");
                TTAdHeaderBidingManagerWrapper tTAdHeaderBidingManagerWrapper3 = TTAdHeaderBidingManagerWrapper.this;
                AdEventUtil.m59299e(tTAdHeaderBidingManagerWrapper3.f21752B, tTAdHeaderBidingManagerWrapper3.f21795h);
                TTAdHeaderBidingManagerWrapper.this.f21756F.set(true);
                if (this.f21813a.getAdType() == 8 || this.f21813a.getAdType() == 7) {
                    if (this.f21813a.adnHasAdVideoCachedApi() && this.f21813a.isCacheSuccess()) {
                        PreLoadManager m59686a = PreLoadManager.m59686a();
                        TTAdHeaderBidingManagerWrapper tTAdHeaderBidingManagerWrapper4 = TTAdHeaderBidingManagerWrapper.this;
                        if (m59686a.m59672c(tTAdHeaderBidingManagerWrapper4.f21793f, tTAdHeaderBidingManagerWrapper4.m37363a()) != 0) {
                            z2 = false;
                        }
                    }
                    z = this.f21813a.getAdNetworkPlatformId() == 4 ? false : z2;
                } else {
                    z = true;
                }
                if (this.f21813a.isServerBiddingAd() || !AdCacheManager.m59712a().m59699c(this.f21813a.getAdNetworkSlotId(), TTAdHeaderBidingManagerWrapper.this.m37363a())) {
                    return;
                }
                AdCacheManager m59712a = AdCacheManager.m59712a();
                String adNetworkSlotId = TTAdHeaderBidingManagerWrapper.this.f21752B.getAdNetworkSlotId();
                TTAdHeaderBidingManagerWrapper tTAdHeaderBidingManagerWrapper5 = TTAdHeaderBidingManagerWrapper.this;
                m59712a.m59706a(adNetworkSlotId, tTAdHeaderBidingManagerWrapper5.f21795h, tTAdHeaderBidingManagerWrapper5.f21804q, z, tTAdHeaderBidingManagerWrapper5.f21757G, tTAdHeaderBidingManagerWrapper5.f21808u, tTAdHeaderBidingManagerWrapper5.f21769z);
            }
        }
    }

    /* compiled from: TTAdHeaderBidingManagerWrapper.java */
    /* renamed from: com.bytedance.msdk.core.corelogic.e$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC6049c {
        /* renamed from: a */
        void mo37323a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TTAdHeaderBidingManagerWrapper(Context context, String str) {
        super(context, str);
    }

    /* renamed from: B */
    private boolean m37330B() {
        boolean m59166e = NetworkUtils.m59166e(InternalContainer.m59945d());
        boolean m59165f = NetworkUtils.m59165f(InternalContainer.m59945d());
        Logger.m37554i("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f21793f) + "setting 下发是否为弱网执行：" + InternalContainer.m59943f().m59770A() + "，当前网络环境：2G-type=" + m59166e + ",3G-type=" + m59165f);
        return InternalContainer.m59943f().m59770A() && (m59166e || m59165f);
    }

    /* renamed from: C */
    private List<TTBaseAd> m37329C() {
        List<TTBaseAd> list;
        while (true) {
            char c = 'X';
            char c2 = 65494;
            while (true) {
                switch (c) {
                    case 'W':
                        c = 'Y';
                        c2 = 31;
                    case 'X':
                        c = 'Y';
                        c2 = 31;
                    case 'Y':
                        while (true) {
                            switch (c2) {
                                case 29:
                                    break;
                                case 30:
                                    break;
                                case 31:
                                    ArrayList arrayList = new ArrayList();
                                    if (!TTCollectionUtils.m59112a(this.f21802o) || !TTCollectionUtils.m59112a(this.f21801n)) {
                                        if (!TTCollectionUtils.m59112a(this.f21802o) && TTCollectionUtils.m59112a(this.f21801n)) {
                                            list = this.f21802o;
                                        } else if (TTCollectionUtils.m59112a(this.f21801n) || !TTCollectionUtils.m59112a(this.f21802o)) {
                                            arrayList.addAll(this.f21801n);
                                            arrayList.addAll(this.f21802o);
                                            if (m37340h()) {
                                                Collections.sort(arrayList, TTLoaderUtil.m37307p());
                                            }
                                        } else {
                                            list = this.f21801n;
                                        }
                                        arrayList.addAll(list);
                                    }
                                    if (!TTCollectionUtils.m59112a(this.f21803p)) {
                                        arrayList.addAll(0, this.f21803p);
                                    }
                                    return arrayList;
                                default:
                                    c2 = 29;
                            }
                        }
                        c = 'Y';
                        c2 = 31;
                        break;
                    default:
                        c = 'W';
                }
            }
        }
    }

    /* renamed from: a */
    private void m37326a(TTBaseAd tTBaseAd, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        ThreadHelper.runOnUiThread(new RunnableC6048b(tTBaseAd, activity, map));
    }

    /* renamed from: a */
    private boolean m37325a(List<WaterFallConfig> list, List<TTBaseAd> list2, boolean z, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        List<TTBaseAdCache> m59708a;
        TTBaseAd tTBaseAd;
        List<TTBaseAdCache> m59708a2;
        TTBaseAd tTBaseAd2;
        HashMap<String, TTBaseAd> m37400b = m37400b(list2);
        for (WaterFallConfig waterFallConfig : list) {
            if (waterFallConfig != null) {
                String m59480c = waterFallConfig.m59480c();
                TTBaseAd tTBaseAd3 = m37400b.get(m59480c);
                if (tTBaseAd3 != null) {
                    if (z) {
                        if (tTBaseAd3.isCacheSuccess()) {
                            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd3.getAdNetworkSlotId()) + "弱网情况下已缓存好的广告，广告类型：" + C6031a.m37434d(tTBaseAd3.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd3.isReady());
                            if (tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                                m37326a(tTBaseAd3, activity, map);
                                m37324c(tTBaseAd3);
                                return true;
                            }
                        }
                    } else if (tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                        m37326a(tTBaseAd3, activity, map);
                        m37324c(tTBaseAd3);
                        return true;
                    }
                }
                if (waterFallConfig.m59474e() != 2 && AdCacheManager.m59712a().m59699c(m59480c, m37363a()) && AdCacheManager.m59712a().m59701b(m59480c, this.f21795h) == 3 && (m59708a2 = AdCacheManager.m59712a().m59708a(m59480c, this.f21795h)) != null && m59708a2.size() > 0 && (tTBaseAd2 = m59708a2.get(0).f425a) != null) {
                    if (z) {
                        if (tTBaseAd2.isCacheSuccess()) {
                            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd2.getAdNetworkSlotId()) + "弱网情况下已缓存好的广告，广告类型：" + C6031a.m37434d(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd2.isReady());
                            if (tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                                m37402b(tTBaseAd2);
                                m37326a(tTBaseAd2, activity, map);
                                m37324c(tTBaseAd2);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else if (tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                        m37402b(tTBaseAd2);
                        m37326a(tTBaseAd2, activity, map);
                        m37324c(tTBaseAd2);
                        return true;
                    }
                }
            }
        }
        if (z && this.f21752B == null) {
            for (WaterFallConfig waterFallConfig2 : list) {
                if (waterFallConfig2 != null) {
                    String m59480c2 = waterFallConfig2.m59480c();
                    TTBaseAd tTBaseAd4 = m37400b.get(m59480c2);
                    if (tTBaseAd4 != null && tTBaseAd4.isReady() && !tTBaseAd4.isHasShown()) {
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd4.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + C6031a.m37434d(tTBaseAd4.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd4.isReady());
                        m37326a(tTBaseAd4, activity, map);
                        m37324c(tTBaseAd4);
                        return true;
                    } else if (waterFallConfig2.m59474e() != 2 && AdCacheManager.m59712a().m59699c(m59480c2, m37363a()) && AdCacheManager.m59712a().m59701b(m59480c2, this.f21795h) == 3 && (m59708a = AdCacheManager.m59712a().m59708a(m59480c2, this.f21795h)) != null && m59708a.size() > 0 && (tTBaseAd = m59708a.get(0).f425a) != null && tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + C6031a.m37434d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd.isReady());
                        m37402b(tTBaseAd);
                        m37326a(tTBaseAd, activity, map);
                        m37324c(tTBaseAd);
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: c */
    private void m37324c(TTBaseAd tTBaseAd) {
        ThreadHelper.runOnUiThread(new RunnableC6047a(tTBaseAd));
    }

    /* renamed from: A */
    public boolean m37331A() {
        AdEventUtil.m59307a(this.f21803p, this.f21802o, this.f21801n, this.f21795h);
        if (this.f21803p.size() > 0) {
            for (TTBaseAd tTBaseAd : this.f21803p) {
                if (tTBaseAd != null) {
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd.getAdNetworkSlotId()) + "isReady-》广告类型：" + C6031a.m37434d(tTBaseAd.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + tTBaseAd.isReady());
                    if (tTBaseAd.isReady()) {
                        return true;
                    }
                }
            }
        }
        TTBaseAd tTBaseAd2 = null;
        TTBaseAd tTBaseAd3 = this.f21802o.size() > 0 ? this.f21802o.get(0) : null;
        List<TTBaseAd> list = this.f21801n;
        if (list != null && list.size() > 0) {
            Iterator<TTBaseAd> it = this.f21801n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TTBaseAd next = it.next();
                if (next != null) {
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, next.getAdNetworkSlotId()) + "isReady-》广告类型：" + C6031a.m37434d(next.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + next.isReady());
                    if (next.isReady()) {
                        tTBaseAd2 = next;
                        break;
                    }
                }
            }
        } else if (tTBaseAd3 != null) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd3.getAdNetworkSlotId()) + "isReady--->biding-->广告类型：" + C6031a.m37434d(tTBaseAd3.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + tTBaseAd3.isReady());
            if (tTBaseAd3.isReady()) {
                tTBaseAd2 = tTBaseAd3;
            }
        }
        return tTBaseAd2 != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m37328a(Activity activity, InterfaceC6049c interfaceC6049c) {
        List<WaterFallConfig> list;
        List<TTBaseAdCache> m59708a;
        TTBaseAd tTBaseAd;
        AdEventUtil.m59322a(this.f21795h);
        if (this.f21756F.get() || this.f21789b.get()) {
            AdEventUtil.m59308a((List<TTBaseAd>) null, this.f21795h);
            if (interfaceC6049c != null) {
                interfaceC6049c.mo37323a();
                return;
            }
            return;
        }
        List<TTBaseAd> m37329C = m37329C();
        try {
            list = m37377t();
        } catch (Throwable th) {
            th.printStackTrace();
            list = null;
        }
        if (list != null && list.size() > 0) {
            HashMap<String, TTBaseAd> m37400b = m37400b(m37329C);
            for (WaterFallConfig waterFallConfig : list) {
                if (waterFallConfig != null) {
                    String m59480c = waterFallConfig.m59480c();
                    TTBaseAd tTBaseAd2 = m37400b.get(m59480c);
                    if (tTBaseAd2 != null && tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd2.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd2.isReady());
                        m37326a(tTBaseAd2, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                        return;
                    } else if (waterFallConfig.m59474e() != 2 && AdCacheManager.m59712a().m59699c(m59480c, m37363a()) && AdCacheManager.m59712a().m59701b(m59480c, this.f21795h) == 3 && (m59708a = AdCacheManager.m59712a().m59708a(m59480c, this.f21795h)) != null && m59708a.size() > 0 && (tTBaseAd = m59708a.get(0).f425a) != null && tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd.isReady());
                        m37402b(tTBaseAd);
                        m37326a(tTBaseAd, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                        return;
                    }
                }
            }
        }
        if (m37329C != null && m37329C.size() > 0) {
            for (TTBaseAd tTBaseAd3 : m37329C) {
                if (tTBaseAd3 != null && tTBaseAd3.isReady() && !tTBaseAd3.isHasShown()) {
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f21793f, TTLogUtil.TAG_EVENT_SHOW) + "adSlotId：" + tTBaseAd3.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(tTBaseAd3.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd3.isReady());
                    m37326a(tTBaseAd3, activity, (Map<TTAdConstant.GroMoreExtraKey, Object>) null);
                    return;
                }
            }
        }
        AdEventUtil.m59308a(m37329C, this.f21795h);
        if (interfaceC6049c != null) {
            interfaceC6049c.mo37323a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m37327a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, InterfaceC6049c interfaceC6049c) {
        AdEventUtil.m59322a(this.f21795h);
        List<WaterFallConfig> list = null;
        if (this.f21756F.get() || this.f21789b.get()) {
            AdEventUtil.m59308a((List<TTBaseAd>) null, this.f21795h);
            if (interfaceC6049c != null) {
                interfaceC6049c.mo37323a();
                return;
            }
            return;
        }
        boolean m37330B = m37330B();
        List<TTBaseAd> m37329C = m37329C();
        try {
            list = m37377t();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        List<WaterFallConfig> list2 = list;
        if (list2 == null || list2.size() <= 0 || !m37325a(list2, m37329C, m37330B, activity, map)) {
            if (m37329C != null && m37329C.size() > 0) {
                for (TTBaseAd tTBaseAd : m37329C) {
                    if (tTBaseAd != null) {
                        if (m37330B) {
                            if (tTBaseAd.isCacheSuccess()) {
                                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd.getAdNetworkSlotId()) + "弱网情况下已缓存好的广告，广告类型：" + C6031a.m37434d(tTBaseAd.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd.isReady());
                            } else {
                                continue;
                            }
                        }
                        if (tTBaseAd.isReady() && !tTBaseAd.isHasShown()) {
                            m37326a(tTBaseAd, activity, map);
                            m37324c(tTBaseAd);
                            return;
                        }
                    }
                }
                if (m37330B && this.f21752B == null) {
                    for (TTBaseAd tTBaseAd2 : m37329C) {
                        if (tTBaseAd2 != null && tTBaseAd2.isReady() && !tTBaseAd2.isHasShown()) {
                            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelById(this.f21793f, tTBaseAd2.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + C6031a.m37434d(tTBaseAd2.getAdNetworkPlatformId()) + ",isReady()：" + tTBaseAd2.isReady());
                            m37326a(tTBaseAd2, activity, map);
                            m37324c(tTBaseAd2);
                            return;
                        }
                    }
                }
            }
            AdEventUtil.m59308a(m37329C, this.f21795h);
            if (interfaceC6049c != null) {
                interfaceC6049c.mo37323a();
            }
        }
    }
}
