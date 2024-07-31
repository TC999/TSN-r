package com.p518qq.p519e.comm.managers.setting;

import android.text.TextUtils;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.GlobalSetting */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    /* renamed from: a */
    private static volatile Integer f32943a = null;

    /* renamed from: b */
    private static volatile boolean f32944b = false;

    /* renamed from: c */
    private static volatile boolean f32945c = true;

    /* renamed from: d */
    private static volatile Integer f32946d;

    /* renamed from: e */
    private static volatile Boolean f32947e;

    /* renamed from: f */
    private static volatile Boolean f32948f;

    /* renamed from: g */
    private static volatile Boolean f32949g;

    /* renamed from: h */
    private static volatile Map<String, String> f32950h = new HashMap();

    /* renamed from: i */
    private static volatile Map<String, String> f32951i = new HashMap();

    /* renamed from: j */
    private static final Map<String, String> f32952j = new HashMap();

    /* renamed from: k */
    private static final JSONObject f32953k = new JSONObject();

    /* renamed from: l */
    private static volatile String f32954l = null;

    /* renamed from: m */
    private static volatile String f32955m = null;

    /* renamed from: n */
    private static volatile String f32956n = null;

    /* renamed from: o */
    private static volatile String f32957o = null;

    /* renamed from: p */
    private static volatile String f32958p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f32949g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f32948f;
    }

    public static Integer getChannel() {
        return f32943a;
    }

    public static String getCustomADActivityClassName() {
        return f32954l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f32957o;
    }

    public static String getCustomPortraitActivityClassName() {
        return f32955m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f32958p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f32956n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f32950h);
    }

    public static Integer getPersonalizedState() {
        return f32946d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f32952j;
    }

    public static JSONObject getSettings() {
        return f32953k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f32947e == null || f32947e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f32949g == null) {
            return true;
        }
        return f32949g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f32948f == null) {
            return true;
        }
        return f32948f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f32944b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f32945c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f32947e == null) {
            f32947e = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z) {
        f32949g = Boolean.valueOf(z);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z) {
        f32948f = Boolean.valueOf(z);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f32953k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e) {
            GDTLogger.m20307e("setAgreeReadPrivacyInfo错误：" + e.toString());
        }
    }

    public static void setChannel(int i) {
        if (f32943a == null) {
            f32943a = Integer.valueOf(i);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f32953k.putOpt(CONV_OPTIMIZE_KEY, new JSONObject(map));
        } catch (Exception e) {
            GDTLogger.m20307e("setConvOptimizeInfo错误：" + e.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f32954l = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f32957o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f32955m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f32958p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f32956n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            f32953k.putOpt("ecais", Boolean.valueOf(z));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        f32944b = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f32945c = z;
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
            java.lang.String r3 = "参数key和value不能为空！"
            com.p518qq.p519e.comm.util.GDTLogger.m20307e(r3)
            return
        L35:
            com.p518qq.p519e.comm.managers.setting.GlobalSetting.f32950h = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p518qq.p519e.comm.managers.setting.GlobalSetting.setExtraUserData(java.util.Map):void");
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            f32951i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f32951i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f32953k.putOpt("media_ext", new JSONObject(f32951i));
        } catch (JSONException unused) {
            GDTLogger.m20307e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i) {
        f32946d = Integer.valueOf(i);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f32952j.putAll(map);
    }
}
