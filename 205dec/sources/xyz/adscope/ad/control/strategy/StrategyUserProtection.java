package xyz.adscope.ad.control.strategy;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.ad.model.http.request.config.ConfigRequestInfo;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StrategyUserProtection {
    private static StrategyUserProtection mInstance;
    private Map<String, Long> mData = new HashMap();
    private String userProtectionKey = "user_time";
    private String splashCoolKey = "splash_cool_";
    private String nativeCoolKey = "native_cool_";
    private String bannerCoolKey = "banner_cool_";
    private String interstitialCoolKey = "interstitial_cool_";
    private String rewardVideoCoolKey = "reward_video_cool_";

    public static StrategyUserProtection getInstance() {
        if (mInstance == null) {
            synchronized (ConfigRequestInfo.class) {
                if (mInstance == null) {
                    mInstance = new StrategyUserProtection();
                }
            }
        }
        return mInstance;
    }

    private void putUserCoolData(String str) {
        if (TextUtils.isEmpty(str) || !AdScopeSpUtil.contains(str)) {
            return;
        }
        long longValue = ((Long) AdScopeSpUtil.get(str, 0L)).longValue();
        if (longValue != 0) {
            this.mData.put(str, Long.valueOf(longValue));
        }
    }

    public void init(String str) {
        long longValue;
        try {
            if (!AdScopeSpUtil.contains(this.userProtectionKey)) {
                longValue = System.currentTimeMillis();
                AdScopeSpUtil.put(this.userProtectionKey, Long.valueOf(longValue));
            } else {
                longValue = ((Long) AdScopeSpUtil.get(this.userProtectionKey, 0L)).longValue();
            }
            this.mData.put(this.userProtectionKey, Long.valueOf(longValue));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            putUserCoolData(this.splashCoolKey + str);
            putUserCoolData(this.nativeCoolKey + str);
            putUserCoolData(this.bannerCoolKey + str);
            putUserCoolData(this.interstitialCoolKey + str);
            putUserCoolData(this.rewardVideoCoolKey + str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isInCooling(java.lang.String r4, java.lang.String r5, long r6) {
        /*
            r3 = this;
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> Lcf
            if (r1 != 0) goto Lce
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> Lcf
            if (r1 == 0) goto Lf
            goto Lce
        Lf:
            r1 = 0
            xyz.adscope.ad.advertisings.model.AdType r2 = xyz.adscope.ad.advertisings.model.AdType.SPLASH     // Catch: java.lang.Exception -> Lcf
            java.lang.String r2 = r2.getValue()     // Catch: java.lang.Exception -> Lcf
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch: java.lang.Exception -> Lcf
            if (r2 == 0) goto L30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcf
            r5.<init>()     // Catch: java.lang.Exception -> Lcf
            java.lang.String r1 = r3.splashCoolKey     // Catch: java.lang.Exception -> Lcf
            r5.append(r1)     // Catch: java.lang.Exception -> Lcf
            r5.append(r4)     // Catch: java.lang.Exception -> Lcf
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Exception -> Lcf
        L2d:
            r1 = r4
            goto La8
        L30:
            xyz.adscope.ad.advertisings.model.AdType r2 = xyz.adscope.ad.advertisings.model.AdType.NATIVE     // Catch: java.lang.Exception -> Lcf
            java.lang.String r2 = r2.getValue()     // Catch: java.lang.Exception -> Lcf
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch: java.lang.Exception -> Lcf
            if (r2 == 0) goto L4e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcf
            r5.<init>()     // Catch: java.lang.Exception -> Lcf
            java.lang.String r1 = r3.nativeCoolKey     // Catch: java.lang.Exception -> Lcf
            r5.append(r1)     // Catch: java.lang.Exception -> Lcf
            r5.append(r4)     // Catch: java.lang.Exception -> Lcf
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Exception -> Lcf
            goto L2d
        L4e:
            xyz.adscope.ad.advertisings.model.AdType r2 = xyz.adscope.ad.advertisings.model.AdType.BANNER     // Catch: java.lang.Exception -> Lcf
            java.lang.String r2 = r2.getValue()     // Catch: java.lang.Exception -> Lcf
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch: java.lang.Exception -> Lcf
            if (r2 == 0) goto L6c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcf
            r5.<init>()     // Catch: java.lang.Exception -> Lcf
            java.lang.String r1 = r3.bannerCoolKey     // Catch: java.lang.Exception -> Lcf
            r5.append(r1)     // Catch: java.lang.Exception -> Lcf
            r5.append(r4)     // Catch: java.lang.Exception -> Lcf
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Exception -> Lcf
            goto L2d
        L6c:
            xyz.adscope.ad.advertisings.model.AdType r2 = xyz.adscope.ad.advertisings.model.AdType.INTERSTITIAL     // Catch: java.lang.Exception -> Lcf
            java.lang.String r2 = r2.getValue()     // Catch: java.lang.Exception -> Lcf
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch: java.lang.Exception -> Lcf
            if (r2 == 0) goto L8a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcf
            r5.<init>()     // Catch: java.lang.Exception -> Lcf
            java.lang.String r1 = r3.interstitialCoolKey     // Catch: java.lang.Exception -> Lcf
            r5.append(r1)     // Catch: java.lang.Exception -> Lcf
            r5.append(r4)     // Catch: java.lang.Exception -> Lcf
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Exception -> Lcf
            goto L2d
        L8a:
            xyz.adscope.ad.advertisings.model.AdType r2 = xyz.adscope.ad.advertisings.model.AdType.REWARDEDVIDEO     // Catch: java.lang.Exception -> Lcf
            java.lang.String r2 = r2.getValue()     // Catch: java.lang.Exception -> Lcf
            boolean r5 = r2.equalsIgnoreCase(r5)     // Catch: java.lang.Exception -> Lcf
            if (r5 == 0) goto La8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcf
            r5.<init>()     // Catch: java.lang.Exception -> Lcf
            java.lang.String r1 = r3.rewardVideoCoolKey     // Catch: java.lang.Exception -> Lcf
            r5.append(r1)     // Catch: java.lang.Exception -> Lcf
            r5.append(r4)     // Catch: java.lang.Exception -> Lcf
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Exception -> Lcf
            goto L2d
        La8:
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lcf
            if (r4 == 0) goto Laf
            return r0
        Laf:
            java.util.Map<java.lang.String, java.lang.Long> r4 = r3.mData     // Catch: java.lang.Exception -> Lcf
            boolean r4 = r4.containsKey(r1)     // Catch: java.lang.Exception -> Lcf
            if (r4 == 0) goto Ld3
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Lcf
            java.util.Map<java.lang.String, java.lang.Long> r2 = r3.mData     // Catch: java.lang.Exception -> Lcf
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Exception -> Lcf
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.Exception -> Lcf
            long r1 = r1.longValue()     // Catch: java.lang.Exception -> Lcf
            long r4 = r4 - r1
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto Ld3
            r4 = 1
            return r4
        Lce:
            return r0
        Lcf:
            r4 = move-exception
            r4.printStackTrace()
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.strategy.StrategyUserProtection.isInCooling(java.lang.String, java.lang.String, long):boolean");
    }

    public boolean isNewUser(long j4) {
        try {
            if (this.mData.containsKey(this.userProtectionKey)) {
                return System.currentTimeMillis() - this.mData.get(this.userProtectionKey).longValue() < j4;
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: Exception -> 0x00c4, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c4, blocks: (B:2:0x0000, B:4:0x0006, B:7:0x000e, B:9:0x001b, B:23:0x00a7, B:26:0x00ae, B:11:0x002f, B:13:0x003b, B:14:0x004d, B:16:0x0059, B:17:0x006b, B:19:0x0077, B:20:0x0089, B:22:0x0095), top: B:32:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void putUserCoolData(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> Lc4
            if (r0 != 0) goto Lc3
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> Lc4
            if (r0 == 0) goto Le
            goto Lc3
        Le:
            r0 = 0
            xyz.adscope.ad.advertisings.model.AdType r1 = xyz.adscope.ad.advertisings.model.AdType.SPLASH     // Catch: java.lang.Exception -> Lc4
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Exception -> Lc4
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> Lc4
            if (r1 == 0) goto L2f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc4
            r4.<init>()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r0 = r2.splashCoolKey     // Catch: java.lang.Exception -> Lc4
            r4.append(r0)     // Catch: java.lang.Exception -> Lc4
            r4.append(r3)     // Catch: java.lang.Exception -> Lc4
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> Lc4
        L2c:
            r0 = r3
            goto La7
        L2f:
            xyz.adscope.ad.advertisings.model.AdType r1 = xyz.adscope.ad.advertisings.model.AdType.NATIVE     // Catch: java.lang.Exception -> Lc4
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Exception -> Lc4
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> Lc4
            if (r1 == 0) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc4
            r4.<init>()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r0 = r2.nativeCoolKey     // Catch: java.lang.Exception -> Lc4
            r4.append(r0)     // Catch: java.lang.Exception -> Lc4
            r4.append(r3)     // Catch: java.lang.Exception -> Lc4
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> Lc4
            goto L2c
        L4d:
            xyz.adscope.ad.advertisings.model.AdType r1 = xyz.adscope.ad.advertisings.model.AdType.BANNER     // Catch: java.lang.Exception -> Lc4
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Exception -> Lc4
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> Lc4
            if (r1 == 0) goto L6b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc4
            r4.<init>()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r0 = r2.bannerCoolKey     // Catch: java.lang.Exception -> Lc4
            r4.append(r0)     // Catch: java.lang.Exception -> Lc4
            r4.append(r3)     // Catch: java.lang.Exception -> Lc4
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> Lc4
            goto L2c
        L6b:
            xyz.adscope.ad.advertisings.model.AdType r1 = xyz.adscope.ad.advertisings.model.AdType.INTERSTITIAL     // Catch: java.lang.Exception -> Lc4
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Exception -> Lc4
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> Lc4
            if (r1 == 0) goto L89
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc4
            r4.<init>()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r0 = r2.interstitialCoolKey     // Catch: java.lang.Exception -> Lc4
            r4.append(r0)     // Catch: java.lang.Exception -> Lc4
            r4.append(r3)     // Catch: java.lang.Exception -> Lc4
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> Lc4
            goto L2c
        L89:
            xyz.adscope.ad.advertisings.model.AdType r1 = xyz.adscope.ad.advertisings.model.AdType.REWARDEDVIDEO     // Catch: java.lang.Exception -> Lc4
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Exception -> Lc4
            boolean r4 = r1.equalsIgnoreCase(r4)     // Catch: java.lang.Exception -> Lc4
            if (r4 == 0) goto La7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc4
            r4.<init>()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r0 = r2.rewardVideoCoolKey     // Catch: java.lang.Exception -> Lc4
            r4.append(r0)     // Catch: java.lang.Exception -> Lc4
            r4.append(r3)     // Catch: java.lang.Exception -> Lc4
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> Lc4
            goto L2c
        La7:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lae
            return
        Lae:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Lc4
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Exception -> Lc4
            xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil.put(r0, r1)     // Catch: java.lang.Exception -> Lc4
            java.util.Map<java.lang.String, java.lang.Long> r1 = r2.mData     // Catch: java.lang.Exception -> Lc4
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Exception -> Lc4
            r1.put(r0, r3)     // Catch: java.lang.Exception -> Lc4
            goto Lc8
        Lc3:
            return
        Lc4:
            r3 = move-exception
            r3.printStackTrace()
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.strategy.StrategyUserProtection.putUserCoolData(java.lang.String, java.lang.String):void");
    }
}
