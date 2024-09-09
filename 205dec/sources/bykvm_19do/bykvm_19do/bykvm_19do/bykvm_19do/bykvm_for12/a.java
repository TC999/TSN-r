package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: CacheBase.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Integer> f372a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Integer> f373b = new HashMap();

    public void a(String str, int i4) {
        this.f372a.put(str, Integer.valueOf(i4));
    }

    public void b(String str, int i4) {
        this.f373b.put(str, Integer.valueOf(i4));
    }

    public int a(String str) {
        Integer num = this.f372a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public int b(String str) {
        Integer num = this.f373b.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public int a(f fVar, AdSlot adSlot, AdSlot adSlot2, String str) {
        TTBaseAd tTBaseAd;
        if (fVar == null || (tTBaseAd = fVar.f418a) == null) {
            return 4;
        }
        String adNetWorkName = tTBaseAd.getAdNetWorkName();
        String adNetworkSlotId = fVar.f418a.getAdNetworkSlotId();
        if (fVar.f418a.adnHasAdExpiredApi()) {
            if (a(fVar)) {
                Logger.d("TTMediationSDK", "--==-- " + str + ":\u5e7f\u544a\u8fc7\u671f\u4e86(adn api) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 1;
            } else if (fVar.f418a.isAdCacheReady() && !fVar.f418a.isHasShown()) {
                if (!a(adSlot, adSlot2)) {
                    Logger.d("TTMediationSDK", "--==-- " + str + ":AdSlot\u4e0d\u7b26\u5408 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                    return 6;
                }
                Logger.d("TTMediationSDK", "--==-- " + str + ":\u590d\u7528\u6210\u529f\uff1a---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return -1;
            } else {
                Logger.d("TTMediationSDK", "--==-- " + str + ":isReady\u662ffalse\u6216\u5df2show\u8fc7 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 5;
            }
        } else if (fVar.f418a.isAdCacheReady() && !fVar.f418a.isHasShown()) {
            if (a(fVar)) {
                Logger.d("TTMediationSDK", "--==-- " + str + ":\u5e7f\u544a\u8fc7\u671f\u4e86(M\u914d\u7f6e) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 2;
            } else if (!a(adSlot, adSlot2)) {
                Logger.d("TTMediationSDK", "--==-- " + str + ":AdSlot\u4e0d\u7b26\u5408 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 6;
            } else {
                Logger.d("TTMediationSDK", "--==-- " + str + ":\u590d\u7528\u6210\u529f\uff1a---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return -1;
            }
        } else {
            Logger.d("TTMediationSDK", "--==-- " + str + ":isReady\u662ffalse\u6216\u5df2show\u8fc7 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 5;
        }
    }

    public boolean a(f fVar) {
        TTBaseAd tTBaseAd;
        if (fVar != null && (tTBaseAd = fVar.f418a) != null && !tTBaseAd.hasDestroyed()) {
            if (fVar.f418a.adnHasAdExpiredApi()) {
                boolean isAdExpired = fVar.f418a.isAdExpired();
                Logger.d("TTMediationSDK", "--==-- \u4f7f\u7528\u4e86adn\u7684\u8fc7\u671f\u63a5\u53e3 ------");
                return isAdExpired;
            }
            boolean z3 = SystemClock.elapsedRealtime() > fVar.b() + ((long) a(fVar.f418a.getAdNetworkSlotId()));
            Logger.d("TTMediationSDK", "--==-- \u4f7f\u7528\u4e86\u914d\u7f6e\u7684\u8fc7\u671f\u65f6\u95f4\u8fdb\u884c\u5224\u65ad ------");
            return z3;
        }
        Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u5df2\u7ecfdestroy\u4e86\uff0c\u89c6\u4e3a\u8fc7\u671f ------");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r7.getRewardName() == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.bytedance.msdk.api.AdSlot r6, com.bytedance.msdk.api.AdSlot r7) {
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
            boolean r6 = a(r6, r7)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdSlot):boolean");
    }

    public static boolean a(Map<String, String> map, Map<String, String> map2) {
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
