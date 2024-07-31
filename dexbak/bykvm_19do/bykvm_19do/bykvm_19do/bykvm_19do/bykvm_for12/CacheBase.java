package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.TTBaseAdCache;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CacheBase {

    /* renamed from: a */
    private final Map<String, Integer> f375a = new HashMap();

    /* renamed from: b */
    private final Map<String, Integer> f376b = new HashMap();

    /* renamed from: a */
    public void m59716a(String str, int i) {
        this.f375a.put(str, Integer.valueOf(i));
    }

    /* renamed from: b */
    public void m59713b(String str, int i) {
        this.f376b.put(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    public int m59717a(String str) {
        Integer num = this.f375a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    /* renamed from: b */
    public int m59714b(String str) {
        Integer num = this.f376b.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    /* renamed from: a */
    public int m59719a(TTBaseAdCache tTBaseAdCache, AdSlot adSlot, AdSlot adSlot2, String str) {
        TTBaseAd tTBaseAd;
        if (tTBaseAdCache == null || (tTBaseAd = tTBaseAdCache.f425a) == null) {
            return 4;
        }
        String adNetWorkName = tTBaseAd.getAdNetWorkName();
        String adNetworkSlotId = tTBaseAdCache.f425a.getAdNetworkSlotId();
        if (tTBaseAdCache.f425a.adnHasAdExpiredApi()) {
            if (m59720a(tTBaseAdCache)) {
                Logger.m37562d("TTMediationSDK", "--==-- " + str + ":广告过期了(adn api) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 1;
            } else if (tTBaseAdCache.f425a.isAdCacheReady() && !tTBaseAdCache.f425a.isHasShown()) {
                if (!m59718a(adSlot, adSlot2)) {
                    Logger.m37562d("TTMediationSDK", "--==-- " + str + ":AdSlot不符合 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                    return 6;
                }
                Logger.m37562d("TTMediationSDK", "--==-- " + str + ":复用成功：---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return -1;
            } else {
                Logger.m37562d("TTMediationSDK", "--==-- " + str + ":isReady是false或已show过 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 5;
            }
        } else if (tTBaseAdCache.f425a.isAdCacheReady() && !tTBaseAdCache.f425a.isHasShown()) {
            if (m59720a(tTBaseAdCache)) {
                Logger.m37562d("TTMediationSDK", "--==-- " + str + ":广告过期了(M配置) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 2;
            } else if (!m59718a(adSlot, adSlot2)) {
                Logger.m37562d("TTMediationSDK", "--==-- " + str + ":AdSlot不符合 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 6;
            } else {
                Logger.m37562d("TTMediationSDK", "--==-- " + str + ":复用成功：---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return -1;
            }
        } else {
            Logger.m37562d("TTMediationSDK", "--==-- " + str + ":isReady是false或已show过 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 5;
        }
    }

    /* renamed from: a */
    public boolean m59720a(TTBaseAdCache tTBaseAdCache) {
        TTBaseAd tTBaseAd;
        if (tTBaseAdCache != null && (tTBaseAd = tTBaseAdCache.f425a) != null && !tTBaseAd.hasDestroyed()) {
            if (tTBaseAdCache.f425a.adnHasAdExpiredApi()) {
                boolean isAdExpired = tTBaseAdCache.f425a.isAdExpired();
                Logger.m37562d("TTMediationSDK", "--==-- 使用了adn的过期接口 ------");
                return isAdExpired;
            }
            boolean z = SystemClock.elapsedRealtime() > tTBaseAdCache.m59654b() + ((long) m59717a(tTBaseAdCache.f425a.getAdNetworkSlotId()));
            Logger.m37562d("TTMediationSDK", "--==-- 使用了配置的过期时间进行判断 ------");
            return z;
        }
        Logger.m37562d("TTMediationSDK", "--==-- 广告已经destroy了，视为过期 ------");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r7.getRewardName() == null) goto L42;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m59718a(com.bytedance.msdk.api.AdSlot r6, com.bytedance.msdk.api.AdSlot r7) {
        /*
            r0 = 0
            if (r6 == 0) goto Le7
            if (r7 != 0) goto L7
            goto Le7
        L7:
            int r1 = r6.getOrientation()
            int r2 = r7.getOrientation()
            if (r1 == r2) goto L12
            return r0
        L12:
            com.bytedance.msdk.api.TTVideoOption r1 = r6.getTTVideoOption()
            com.bytedance.msdk.api.TTVideoOption r2 = r7.getTTVideoOption()
            if (r1 != 0) goto L1f
            if (r2 != 0) goto L1f
            goto L2e
        L1f:
            if (r1 == 0) goto Le7
            if (r2 == 0) goto Le7
            boolean r1 = r1.isMuted()
            boolean r2 = r2.isMuted()
            if (r1 == r2) goto L2e
            return r0
        L2e:
            int r1 = r6.getBannerSize()
            int r2 = r7.getBannerSize()
            if (r1 == r2) goto L39
            return r0
        L39:
            int r1 = r6.getAdCount()
            int r2 = r7.getAdCount()
            if (r1 == r2) goto L44
            return r0
        L44:
            int r1 = r6.getImgAcceptedWidth()
            int r2 = r7.getImgAcceptedWidth()
            if (r1 == r2) goto L4f
            return r0
        L4f:
            int r1 = r6.getImgAcceptedHeight()
            int r2 = r7.getImgAcceptedHeight()
            if (r1 == r2) goto L5a
            return r0
        L5a:
            int r1 = r6.getAdStyleType()
            int r2 = r7.getAdStyleType()
            if (r1 == r2) goto L65
            return r0
        L65:
            int r1 = r6.getSegmentId()
            int r2 = r7.getSegmentId()
            if (r1 == r2) goto L70
            return r0
        L70:
            java.lang.String r1 = r6.getSegmentVersion()
            java.lang.String r2 = r7.getSegmentVersion()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L7f
            return r0
        L7f:
            long r1 = r6.getWaterfallId()
            long r3 = r7.getWaterfallId()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L8c
            return r0
        L8c:
            java.lang.String r1 = r6.getRewardName()
            if (r1 == 0) goto La7
            java.lang.String r1 = r7.getRewardName()
            if (r1 == 0) goto La7
            java.lang.String r1 = r6.getRewardName()
            java.lang.String r2 = r7.getRewardName()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Lb3
            return r0
        La7:
            java.lang.String r1 = r6.getRewardName()
            if (r1 != 0) goto Le7
            java.lang.String r1 = r7.getRewardName()
            if (r1 != 0) goto Le7
        Lb3:
            int r1 = r6.getRewardAmount()
            int r2 = r7.getRewardAmount()
            if (r1 == r2) goto Lbe
            return r0
        Lbe:
            java.util.Map r1 = r6.getCustomData()
            if (r1 == 0) goto Ld9
            java.util.Map r1 = r7.getCustomData()
            if (r1 == 0) goto Ld9
            java.util.Map r6 = r6.getCustomData()
            java.util.Map r7 = r7.getCustomData()
            boolean r6 = m59715a(r6, r7)
            if (r6 != 0) goto Le5
            return r0
        Ld9:
            java.util.Map r6 = r6.getCustomData()
            if (r6 != 0) goto Le7
            java.util.Map r6 = r7.getCustomData()
            if (r6 != 0) goto Le7
        Le5:
            r6 = 1
            return r6
        Le7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.CacheBase.m59718a(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdSlot):boolean");
    }

    /* renamed from: a */
    public static boolean m59715a(Map<String, String> map, Map<String, String> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<String> keySet = map.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                if (str != null) {
                    String str2 = map.get(str);
                    String str3 = map2.get(str);
                    if (str2 != null || str3 != null) {
                        if (!TextUtils.equals(str2, str3)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
