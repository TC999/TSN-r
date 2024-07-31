package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.CacheBase;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PreLoadManager extends CacheBase {

    /* renamed from: l */
    private static volatile PreLoadManager f403l;

    /* renamed from: c */
    private final Map<String, Integer> f404c = new HashMap();

    /* renamed from: d */
    private final Map<String, Integer> f405d = new HashMap();

    /* renamed from: e */
    private final Map<String, Integer> f406e = new HashMap();

    /* renamed from: f */
    private final Map<String, Long> f407f = new HashMap();

    /* renamed from: g */
    private final Map<String, AdSlot> f408g = new HashMap();

    /* renamed from: h */
    private final Map<String, Map<String, TTBaseAdCache>> f409h = new HashMap();

    /* renamed from: i */
    private final Map<String, Map<String, AdError>> f410i = new HashMap();

    /* renamed from: j */
    private final Map<String, Boolean> f411j = new HashMap();

    /* renamed from: k */
    private final Map<String, PreLoadRequestCore> f412k = new HashMap();

    /* compiled from: PreLoadManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class RunnableC0960a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f413a;

        /* renamed from: b */
        final /* synthetic */ String f414b;

        /* renamed from: c */
        final /* synthetic */ int f415c;

        RunnableC0960a(Context context, String str, int i) {
            this.f413a = context;
            this.f414b = str;
            this.f415c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            PreLoadManager.this.m59684a(this.f413a, this.f414b, 2, this.f415c);
        }
    }

    /* compiled from: PreLoadManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class RunnableC0961b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f417a;

        /* renamed from: b */
        final /* synthetic */ String f418b;

        /* renamed from: c */
        final /* synthetic */ int f419c;

        RunnableC0961b(Context context, String str, int i) {
            this.f417a = context;
            this.f418b = str;
            this.f419c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            PreLoadManager.this.m59684a(this.f417a, this.f418b, 4, this.f419c);
        }
    }

    private PreLoadManager() {
    }

    /* renamed from: b */
    public void m59674b(String str, AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f408g.put(str, adSlot);
    }

    /* renamed from: c */
    public int m59672c(String str, int i) {
        Integer num;
        if (i == 2 || (num = this.f406e.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: d */
    public void m59669d(String str, int i) {
        this.f404c.put(str, Integer.valueOf(i));
    }

    /* renamed from: e */
    public void m59667e(String str, int i) {
        this.f405d.put(str, Integer.valueOf(i));
    }

    /* renamed from: f */
    public void m59665f(String str, int i) {
        this.f406e.put(str, Integer.valueOf(i));
    }

    /* renamed from: g */
    public Long m59664g(String str) {
        return this.f407f.get(str);
    }

    /* renamed from: h */
    public List<TTBaseAdCache> m59663h(String str) {
        ArrayList arrayList = new ArrayList();
        Map<String, TTBaseAdCache> map = this.f409h.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                TTBaseAdCache tTBaseAdCache = map.get(str2);
                if (tTBaseAdCache != null) {
                    arrayList.add(tTBaseAdCache);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static PreLoadManager m59686a() {
        if (f403l == null) {
            synchronized (PreLoadManager.class) {
                if (f403l == null) {
                    f403l = new PreLoadManager();
                }
            }
        }
        return f403l;
    }

    /* renamed from: d */
    public PreLoadRequestCore m59670d(String str) {
        return this.f412k.get(str);
    }

    /* renamed from: e */
    public int m59668e(String str) {
        Integer num = this.f404c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    /* renamed from: f */
    public int m59666f(String str) {
        Integer num = this.f405d.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 3;
    }

    /* renamed from: b */
    public void m59675b(Context context, String str, int i) {
        ThreadHelper.runOnMSDKThread(new RunnableC0961b(context, str, i));
    }

    /* renamed from: c */
    public AdSlot m59673c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f408g.get(str);
    }

    /* renamed from: c */
    private void m59671c(String str, AdSlot adSlot) {
        Map<String, TTBaseAdCache> map = this.f409h.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                TTBaseAdCache tTBaseAdCache = map.get(str2);
                if (tTBaseAdCache != null && tTBaseAdCache.f425a != null) {
                    if (m59720a(tTBaseAdCache)) {
                        map.put(str2, null);
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存：广告过期了 ---: " + tTBaseAdCache.f425a.getAdNetWorkName() + ", loadSort: " + tTBaseAdCache.f425a.getLoadSort() + ", showSort: " + tTBaseAdCache.f425a.getShowSort());
                    } else if (!CacheBase.m59718a(this.f408g.get(str), adSlot)) {
                        map.put(str2, null);
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存：广告AdSlot不符合 ---: " + tTBaseAdCache.f425a.getAdNetWorkName() + ", loadSort: " + tTBaseAdCache.f425a.getLoadSort() + ", showSort: " + tTBaseAdCache.f425a.getShowSort());
                    } else if (m59714b(str2) != 0 && (!tTBaseAdCache.f425a.isAdCacheReady() || tTBaseAdCache.f425a.isHasShown())) {
                        map.put(str2, null);
                        Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存：isReady为false ---: " + tTBaseAdCache.f425a.getAdNetWorkName() + ", loadSort: " + tTBaseAdCache.f425a.getLoadSort() + ", showSort: " + tTBaseAdCache.f425a.getShowSort());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m59682a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f407f.put(str, Long.valueOf(j));
    }

    /* renamed from: a */
    public void m59678a(String str, String str2, long j, AdError adError) {
        if (m59664g(str) == null || m59664g(str).longValue() == j) {
            Map<String, AdError> map = this.f410i.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f410i.put(str, map);
            }
            map.put(str2, adError);
        }
    }

    /* renamed from: a */
    public void m59681a(String str, TTBaseAdCache tTBaseAdCache) {
        if (m59664g(str) == null || m59664g(str).longValue() == tTBaseAdCache.m59653c()) {
            Map<String, TTBaseAdCache> map = this.f409h.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f409h.put(str, map);
            }
            map.put(tTBaseAdCache.f425a.getAdNetworkSlotId(), tTBaseAdCache);
        }
    }

    /* renamed from: a */
    public boolean m59680a(String str, AdSlot adSlot) {
        this.f411j.put(str, Boolean.FALSE);
        PreLoadRequestCore preLoadRequestCore = this.f412k.get(str);
        if (preLoadRequestCore != null) {
            List<WaterFallConfig> m37377t = preLoadRequestCore.m37377t();
            if (Logger.isDebug()) {
                for (WaterFallConfig waterFallConfig : m37377t) {
                    Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "waterfall: " + waterFallConfig.m59477d() + ", loadSort: " + waterFallConfig.m59459l() + ", showSort: " + waterFallConfig.m59452s() + ", eCpm: " + waterFallConfig.m59471f());
                }
            }
            m59677a(m37377t, str, adSlot, preLoadRequestCore);
            m59671c(str, adSlot);
            Map<String, TTBaseAdCache> map = this.f409h.get(str);
            if (map != null) {
                if (preLoadRequestCore.mo37349b() == 1) {
                    for (int i = 0; i < m59666f(str) && i < m37377t.size(); i++) {
                        if (map.get(m37377t.get(i).m59480c()) != null) {
                            return true;
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < m37377t.size(); i2++) {
                        if (map.get(m37377t.get(i2).m59480c()) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m59677a(List<WaterFallConfig> list, String str, AdSlot adSlot, PreLoadRequestCore preLoadRequestCore) {
        TTBaseAdCache tTBaseAdCache;
        if (list.size() <= 0) {
            return;
        }
        Map<String, TTBaseAdCache> map = this.f409h.get(str);
        if (map != null && (tTBaseAdCache = map.get(list.get(0).m59480c())) != null && !m59720a(tTBaseAdCache) && tTBaseAdCache.f425a.isAdCacheReady() && !tTBaseAdCache.f425a.isHasShown()) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 命中最优广告： " + tTBaseAdCache.f425a.getAdNetWorkName() + ", loadSort: " + tTBaseAdCache.f425a.getLoadSort() + ", showSort: " + tTBaseAdCache.f425a.getShowSort());
            return;
        }
        List<AdCacheCannotUseInfo> m59676a = m59676a(list, str, map, adSlot, preLoadRequestCore);
        if (m59676a.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < m59676a.size(); i++) {
                sb.append(m59676a.get(i).m59694a());
                if (i == m59676a.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                JSONArray jSONArray = new JSONArray(sb.toString());
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "adCannotUseInfo: " + jSONArray.toString());
                AdEventUtil.m59313a(this.f408g.get(str), jSONArray.toString());
            } catch (JSONException e) {
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "adCannotUseInfo json err: " + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private List<AdCacheCannotUseInfo> m59676a(List<WaterFallConfig> list, String str, Map<String, TTBaseAdCache> map, AdSlot adSlot, PreLoadRequestCore preLoadRequestCore) {
        int m59666f;
        TTBaseAd tTBaseAd;
        ArrayList arrayList = new ArrayList();
        if (preLoadRequestCore.mo37349b() == 2 && (preLoadRequestCore instanceof PreLoadRequestCoreV2)) {
            m59666f = ((PreLoadRequestCoreV2) preLoadRequestCore).m59659A();
        } else {
            m59666f = m59666f(str);
        }
        for (int i = 0; i < list.size() && i < m59666f; i++) {
            String m59480c = list.get(i).m59480c();
            AdCacheCannotUseInfo adCacheCannotUseInfo = new AdCacheCannotUseInfo();
            adCacheCannotUseInfo.m59690b(m59480c);
            adCacheCannotUseInfo.m59687e(list.get(i).m59452s());
            adCacheCannotUseInfo.m59689c(list.get(i).m59459l());
            TTBaseAdCache tTBaseAdCache = map != null ? map.get(m59480c) : null;
            if (tTBaseAdCache != null && (tTBaseAd = tTBaseAdCache.f425a) != null) {
                adCacheCannotUseInfo.m59691b(tTBaseAd.isHasShown() ? 1 : 0);
                int m59719a = m59719a(tTBaseAdCache, this.f408g.get(str), adSlot, "预缓存");
                if (m59719a != -1) {
                    adCacheCannotUseInfo.m59688d(m59719a);
                    arrayList.add(adCacheCannotUseInfo);
                }
            } else {
                Map<String, AdError> map2 = this.f410i.get(str);
                AdError adError = map2 != null ? map2.get(m59480c) : null;
                if (adError != null) {
                    adCacheCannotUseInfo.m59688d(3);
                    adCacheCannotUseInfo.m59693a(adError.thirdSdkErrorCode);
                    adCacheCannotUseInfo.m59692a(adError.thirdSdkErrorMessage);
                } else {
                    adCacheCannotUseInfo.m59688d(4);
                }
                arrayList.add(adCacheCannotUseInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public TTBaseAdCache m59679a(String str, String str2) {
        Map<String, TTBaseAdCache> map = this.f409h.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    /* renamed from: a */
    public void m59685a(Context context, String str, int i) {
        ThreadHelper.runOnMSDKThread(new RunnableC0960a(context, str, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m59684a(Context context, String str, int i, int i2) {
        PreLoadRequestCore preLoadRequestCoreV2;
        int m59672c = m59672c(str, i2);
        if (m59672c == 0) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 配置未开启预加载缓存 ----");
        } else if (this.f411j.get(str) == null || !this.f411j.get(str).booleanValue()) {
            Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存开始请求, req_type: " + m59672c);
            Map<String, TTBaseAdCache> map = this.f409h.get(str);
            if (map != null) {
                map.clear();
            }
            Map<String, AdError> map2 = this.f410i.get(str);
            if (map2 != null) {
                map2.clear();
            }
            if (m59672c == 1) {
                preLoadRequestCoreV2 = new PreLoadRequestCoreV1(context, str);
            } else if (m59672c == 2) {
                preLoadRequestCoreV2 = new PreLoadRequestCoreV2(context, str);
            } else {
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预加载配置错误，req_type：" + m59672c);
                return;
            }
            this.f412k.put(str, preLoadRequestCoreV2);
            this.f411j.put(str, Boolean.TRUE);
            AdSlot shallowCopy = AdSlotInner.getShallowCopy(this.f408g.get(str));
            if (shallowCopy == null) {
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- preload fail，adslot为null，rit：" + str);
                return;
            }
            shallowCopy.setPrimeRitReqType(i);
            preLoadRequestCoreV2.m59661a(shallowCopy);
        }
    }
}
