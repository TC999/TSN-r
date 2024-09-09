package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final String COPPA = "coppa";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String TT_SDK_WRAPPER = "TT";

    /* renamed from: a  reason: collision with root package name */
    private static volatile Integer f41677a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f41678b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f41679c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile Integer f41680d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile Boolean f41681e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile Boolean f41682f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Boolean f41683g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile Map<String, String> f41684h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private static volatile Map<String, String> f41685i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private static final Map<String, String> f41686j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private static final JSONObject f41687k = new JSONObject();

    /* renamed from: l  reason: collision with root package name */
    private static volatile String f41688l = null;

    /* renamed from: m  reason: collision with root package name */
    private static volatile String f41689m = null;

    /* renamed from: n  reason: collision with root package name */
    private static volatile String f41690n = null;

    /* renamed from: o  reason: collision with root package name */
    private static volatile String f41691o = null;

    /* renamed from: p  reason: collision with root package name */
    private static volatile String f41692p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f41683g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f41682f;
    }

    public static Integer getChannel() {
        return f41677a;
    }

    public static String getCustomADActivityClassName() {
        return f41688l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f41691o;
    }

    public static String getCustomPortraitActivityClassName() {
        return f41689m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f41692p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f41690n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f41684h);
    }

    public static Integer getPersonalizedState() {
        return f41680d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f41686j;
    }

    public static JSONObject getSettings() {
        return f41687k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f41681e == null || f41681e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f41683g == null) {
            return true;
        }
        return f41683g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f41682f == null) {
            return true;
        }
        return f41682f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f41678b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f41679c;
    }

    public static void setAgreePrivacyStrategy(boolean z3) {
        if (f41681e == null) {
            f41681e = Boolean.valueOf(z3);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z3) {
        f41683g = Boolean.valueOf(z3);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z3) {
        f41682f = Boolean.valueOf(z3);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f41687k.putOpt("agree_privacy", new JSONObject(map));
        } catch (Exception e4) {
            GDTLogger.e("setAgreeReadPrivacyInfo\u9519\u8bef\uff1a" + e4.toString());
        }
    }

    public static void setChannel(int i4) {
        if (f41677a == null) {
            f41677a = Integer.valueOf(i4);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f41687k.putOpt("conv_opt_info", new JSONObject(map));
        } catch (Exception e4) {
            GDTLogger.e("setConvOptimizeInfo\u9519\u8bef\uff1a" + e4.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f41688l = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f41691o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f41689m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f41692p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f41690n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z3) {
        try {
            f41687k.putOpt("ecais", Boolean.valueOf(z3));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z3) {
        f41678b = z3;
    }

    public static void setEnableVideoDownloadingCache(boolean z3) {
        f41679c = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setExtraUserData(java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            if (r3 != 0) goto L3
            return
        L3:
            java.util.Set r0 = r3.entrySet()
            java.util.Iterator r0 = r0.iterator()
        Lb:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L35
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L2f
            java.lang.Object r1 = r1.getValue()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Lb
        L2f:
            java.lang.String r3 = "\u53c2\u6570key\u548cvalue\u4e0d\u80fd\u4e3a\u7a7a\uff01"
            com.qq.e.comm.util.GDTLogger.e(r3)
            return
        L35:
            com.qq.e.comm.managers.setting.GlobalSetting.f41684h = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.GlobalSetting.setExtraUserData(java.util.Map):void");
    }

    public static void setMediaExtData(Map<String, String> map, boolean z3) {
        if (map == null) {
            return;
        }
        if (z3) {
            f41685i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f41685i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f41687k.putOpt("media_ext", new JSONObject(f41685i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5");
        }
    }

    public static void setPersonalizedState(int i4) {
        f41680d = Integer.valueOf(i4);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f41686j.putAll(map);
    }
}
