package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.CacheBase;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.AdCacheCannotUseInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.TTBaseAdCache;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ExtraParam;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.TTExtraModel;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTNetworkRequestInfo;
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdCacheManager extends CacheBase {

    /* renamed from: k */
    private static volatile AdCacheManager f377k;

    /* renamed from: c */
    private final String[] f378c = {"unity", "ks"};

    /* renamed from: d */
    private final Map<String, Integer> f379d = new HashMap();

    /* renamed from: e */
    private final Map<String, Integer> f380e = new HashMap();

    /* renamed from: f */
    private final Map<String, CopyOnWriteArrayList<TTBaseAdCache>> f381f = new ConcurrentHashMap();

    /* renamed from: g */
    private final Map<String, WaterFallConfig> f382g = new HashMap();

    /* renamed from: h */
    private final Map<String, String> f383h = new HashMap();

    /* renamed from: i */
    private final Map<String, String> f384i = new HashMap();

    /* renamed from: j */
    private final Map<String, Integer> f385j = new HashMap();

    /* compiled from: AdCacheManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class RunnableC0958a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f386a;

        /* renamed from: b */
        final /* synthetic */ boolean f387b;

        /* renamed from: c */
        final /* synthetic */ AdSlot f388c;

        /* renamed from: d */
        final /* synthetic */ Map f389d;

        /* renamed from: e */
        final /* synthetic */ Context f390e;

        /* renamed from: f */
        final /* synthetic */ TTNetworkRequestInfo f391f;

        /* renamed from: g */
        final /* synthetic */ TTExtraModel f392g;

        RunnableC0958a(String str, boolean z, AdSlot adSlot, Map map, Context context, TTNetworkRequestInfo tTNetworkRequestInfo, TTExtraModel tTExtraModel) {
            this.f386a = str;
            this.f387b = z;
            this.f388c = adSlot;
            this.f389d = map;
            this.f390e = context;
            this.f391f = tTNetworkRequestInfo;
            this.f392g = tTExtraModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            TTBaseAdCache tTBaseAdCache;
            List<TTBaseAdCache> list = (List) AdCacheManager.this.f381f.get(this.f386a);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (TTBaseAdCache tTBaseAdCache2 : list) {
                    if (tTBaseAdCache2 != null && tTBaseAdCache2.f425a.isHasShown()) {
                        list.remove(tTBaseAdCache2);
                        arrayList.add(tTBaseAdCache2);
                    }
                }
            }
            if (Logger.isDebug()) {
                String str2 = "";
                if (arrayList.size() <= 0 || (tTBaseAdCache = (TTBaseAdCache) arrayList.get(0)) == null) {
                    str = "";
                } else {
                    String m37436b = C6031a.m37436b(tTBaseAdCache.f425a.getAdType());
                    str2 = tTBaseAdCache.f425a.getAdNetWorkName();
                    str = m37436b;
                }
                Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时缓存移除 -----：" + str2 + ", " + str + ", " + this.f386a);
            }
            if (this.f387b && AdCacheManager.this.m59697d(this.f386a)) {
                AdCacheManager.this.m59707a(this.f386a, this.f388c, this.f389d, this.f390e, this.f391f, this.f392g);
                return;
            }
            Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载 --: " + this.f386a);
        }
    }

    private AdCacheManager() {
    }

    /* renamed from: b */
    public synchronized int m59701b(String str, AdSlot adSlot) {
        if (m59714b(str) == 0) {
            return m59698c(str, adSlot);
        }
        CopyOnWriteArrayList<TTBaseAdCache> copyOnWriteArrayList = this.f381f.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            TTBaseAdCache tTBaseAdCache = null;
            boolean z = false;
            for (TTBaseAdCache tTBaseAdCache2 : copyOnWriteArrayList) {
                int m59719a = m59719a(tTBaseAdCache2, tTBaseAdCache2.m59657a(), adSlot, "广告复用");
                if (m59719a == -1) {
                    z = true;
                } else {
                    if (m59719a != 6) {
                        copyOnWriteArrayList.remove(tTBaseAdCache2);
                    }
                    if (tTBaseAdCache == null) {
                        tTBaseAdCache = tTBaseAdCache2;
                    }
                    AdCacheCannotUseInfo adCacheCannotUseInfo = new AdCacheCannotUseInfo();
                    adCacheCannotUseInfo.m59689c(tTBaseAdCache2.f425a.getLoadSort());
                    adCacheCannotUseInfo.m59687e(tTBaseAdCache2.f425a.getShowSort());
                    adCacheCannotUseInfo.m59690b(tTBaseAdCache2.f425a.getAdNetworkSlotId());
                    adCacheCannotUseInfo.m59688d(m59719a);
                    adCacheCannotUseInfo.m59691b(tTBaseAdCache2.f425a.isHasShown() ? 1 : 0);
                    arrayList.add(adCacheCannotUseInfo);
                }
            }
            if (z) {
                return 3;
            }
            if (tTBaseAdCache != null) {
                AdEventUtil.m59314a(adSlot, tTBaseAdCache.f425a, m59703a(arrayList));
            }
            return 2;
        }
        Logger.m37562d("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    /* renamed from: c */
    public boolean m59699c(String str, int i) {
        Integer num;
        return (i == 2 || (num = this.f379d.get(str)) == null || num.intValue() != 1) ? false : true;
    }

    /* renamed from: d */
    public void m59696d(String str, int i) {
        this.f380e.put(str, Integer.valueOf(i));
    }

    /* renamed from: e */
    public void m59695e(String str, int i) {
        this.f379d.put(str, Integer.valueOf(i));
    }

    /* renamed from: d */
    public boolean m59697d(String str) {
        Integer num = this.f380e.get(str);
        return num != null && num.intValue() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdCacheManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0959b implements TTAbsAdLoaderAdapter.AdapterLoaderListener {

        /* renamed from: a */
        private AdSlot f394a;

        C0959b(AdSlot adSlot) {
            this.f394a = adSlot;
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdFailed(AdError adError, ExtraParam extraParam) {
            if (adError == null || extraParam == null) {
                return;
            }
            Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求广告缓存失败 --- " + extraParam.m59522c() + ", " + extraParam.m59520d() + ", " + C6031a.m37436b(extraParam.m59525b()) + ", errCode: " + adError.thirdSdkErrorCode + ",msg=" + adError.thirdSdkErrorMessage);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(TTBaseAd tTBaseAd, ExtraParam extraParam) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tTBaseAd);
            onAdLoaded(arrayList, extraParam);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdVideoCache() {
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(List<TTBaseAd> list, ExtraParam extraParam) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    arrayList.add(new TTBaseAdCache(tTBaseAd, extraParam, 0L, SystemClock.elapsedRealtime(), this.f394a));
                }
            }
            if (arrayList.size() > 0) {
                TTBaseAd tTBaseAd2 = ((TTBaseAdCache) arrayList.get(0)).f425a;
                Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求广告缓存成功 --- " + tTBaseAd2.getAdNetWorkName() + ", adType: " + C6031a.m37436b(tTBaseAd2.getAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
                AdCacheManager.this.m59704a(tTBaseAd2.getAdNetworkSlotId(), arrayList);
            }
        }
    }

    /* renamed from: a */
    public static AdCacheManager m59712a() {
        if (f377k == null) {
            synchronized (AdCacheManager.class) {
                if (f377k == null) {
                    f377k = new AdCacheManager();
                }
            }
        }
        return f377k;
    }

    /* renamed from: c */
    public String m59700c(String str) {
        return this.f384i.get(str);
    }

    /* renamed from: c */
    private int m59698c(String str, AdSlot adSlot) {
        int i;
        CopyOnWriteArrayList<TTBaseAdCache> copyOnWriteArrayList = this.f381f.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            TTBaseAdCache tTBaseAdCache = null;
            boolean z = false;
            Iterator<TTBaseAdCache> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TTBaseAdCache next = it.next();
                if (!m59720a(next)) {
                    if (CacheBase.m59718a(next.m59657a(), adSlot)) {
                        Logger.m37562d("TTMediationSDK", "--==-- 广告复用:复用成功：--------" + next.f425a.getAdNetWorkName() + ", adSlotId: " + str);
                        z = true;
                    } else {
                        i = 6;
                        Logger.m37562d("TTMediationSDK", "--==-- 广告复用:AdSlot不符合 -------: " + next.f425a.getAdNetWorkName() + ", adSlotId: " + str);
                    }
                } else {
                    copyOnWriteArrayList.remove(next);
                    i = next.f425a.adnHasAdExpiredApi() ? 1 : 2;
                    Logger.m37562d("TTMediationSDK", "--==-- 广告复用:广告过期了 -------: " + next.f425a.getAdNetWorkName() + ", adSlotId: " + str);
                }
                if (tTBaseAdCache == null) {
                    tTBaseAdCache = next;
                }
                AdCacheCannotUseInfo adCacheCannotUseInfo = new AdCacheCannotUseInfo();
                adCacheCannotUseInfo.m59689c(next.f425a.getLoadSort());
                adCacheCannotUseInfo.m59687e(next.f425a.getShowSort());
                adCacheCannotUseInfo.m59690b(next.f425a.getAdNetworkSlotId());
                adCacheCannotUseInfo.m59688d(i);
                adCacheCannotUseInfo.m59691b(next.f425a.isHasShown() ? 1 : 0);
                arrayList.add(adCacheCannotUseInfo);
            }
            if (z) {
                return 3;
            }
            if (tTBaseAdCache != null) {
                AdEventUtil.m59314a(adSlot, tTBaseAdCache.f425a, m59703a(arrayList));
            }
            return 2;
        }
        Logger.m37562d("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    /* renamed from: a */
    public void m59709a(String str, WaterFallConfig waterFallConfig, String str2, int i) {
        if (waterFallConfig != null) {
            this.f382g.put(str, waterFallConfig);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f383h.put(str, str2);
        }
        this.f385j.put(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m59705a(String str, String str2) {
        this.f384i.put(str, str2);
    }

    /* renamed from: a */
    public void m59706a(String str, AdSlot adSlot, Map<String, Object> map, boolean z, TTNetworkRequestInfo tTNetworkRequestInfo, TTExtraModel tTExtraModel, Context context) {
        ThreadHelper.runOnMSDKThread(new RunnableC0958a(str, z, adSlot, map, context, tTNetworkRequestInfo, tTExtraModel));
    }

    /* renamed from: a */
    public void m59704a(String str, List<TTBaseAdCache> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<TTBaseAdCache> copyOnWriteArrayList = this.f381f.get(str);
        if (copyOnWriteArrayList != null) {
            for (TTBaseAdCache tTBaseAdCache : list) {
                if (!m59702a(copyOnWriteArrayList, tTBaseAdCache)) {
                    copyOnWriteArrayList.add(tTBaseAdCache);
                }
            }
            return;
        }
        this.f381f.put(str, new CopyOnWriteArrayList<>(list));
    }

    /* renamed from: a */
    private boolean m59702a(List<TTBaseAdCache> list, TTBaseAdCache tTBaseAdCache) {
        for (TTBaseAdCache tTBaseAdCache2 : list) {
            if (tTBaseAdCache2 != null && tTBaseAdCache != null && tTBaseAdCache2.f425a == tTBaseAdCache.f425a) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public synchronized List<TTBaseAdCache> m59708a(String str, AdSlot adSlot) {
        CopyOnWriteArrayList<TTBaseAdCache> copyOnWriteArrayList = this.f381f.get(str);
        if (copyOnWriteArrayList == null) {
            return null;
        }
        int adCount = adSlot != null ? adSlot.getAdCount() : 1;
        ArrayList<TTBaseAdCache> arrayList = new ArrayList();
        for (int i = 0; arrayList.size() < adCount && i < copyOnWriteArrayList.size(); i++) {
            if (!copyOnWriteArrayList.get(i).m59652d() && CacheBase.m59718a(copyOnWriteArrayList.get(i).m59657a(), adSlot)) {
                arrayList.add(copyOnWriteArrayList.get(i));
            }
        }
        for (int i2 = 0; arrayList.size() < adCount && i2 < copyOnWriteArrayList.size(); i2++) {
            if (copyOnWriteArrayList.get(i2).m59652d() && CacheBase.m59718a(copyOnWriteArrayList.get(i2).m59657a(), adSlot)) {
                arrayList.add(copyOnWriteArrayList.get(i2));
            }
        }
        for (TTBaseAdCache tTBaseAdCache : arrayList) {
            tTBaseAdCache.m59655a(true);
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m59703a(List<AdCacheCannotUseInfo> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).m59694a());
                if (i == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e) {
                Logger.m37562d("TTMediationSDK", "--==-- 广告复用：adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m59707a(String str, AdSlot adSlot, Map<String, Object> map, Context context, TTNetworkRequestInfo tTNetworkRequestInfo, TTExtraModel tTExtraModel) {
        String[] strArr;
        if (adSlot == null) {
            Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求取消，adSlot为空 -------: " + str);
            return;
        }
        WaterFallConfig waterFallConfig = this.f382g.get(str);
        String str2 = this.f383h.get(str);
        if (!TextUtils.isEmpty(str2) && waterFallConfig != null) {
            for (String str3 : this.f378c) {
                if (TextUtils.equals(str3, waterFallConfig.m59477d())) {
                    Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求取消，" + str3 + "为单例模式 -------: " + str);
                    return;
                }
            }
            int intValue = this.f385j.get(str) != null ? this.f385j.get(str).intValue() : -1;
            Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求开始 -------: " + str);
            TTAbsAdLoaderAdapter m37319d = TTLoaderUtil.m37319d(null, waterFallConfig, str2);
            if (m37319d != null) {
                m37319d.setAdapterListener(new C0959b(adSlot));
                m37319d.loadAdInter(context, waterFallConfig, TTLoaderUtil.m37317f(waterFallConfig, adSlot, map, null, tTNetworkRequestInfo, 4, 1), adSlot, tTExtraModel, intValue);
                Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求已发完 -------: " + str);
                return;
            }
            AdEventUtil.m59328a(waterFallConfig, adSlot, 4, 1);
            return;
        }
        Logger.m37562d("TTMediationSDK", "--==-- 广告复用:show时预请求取消，className或wfcBean为空 --: " + str);
    }
}
