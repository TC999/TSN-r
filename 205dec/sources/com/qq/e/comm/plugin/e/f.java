package com.qq.e.comm.plugin.e;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42709a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static int f42710b = -999;

    /* renamed from: c  reason: collision with root package name */
    public static int f42711c = -999;

    /* renamed from: d  reason: collision with root package name */
    private static long f42712d;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject.putOpt("g", jSONObject2.optString("g"));
            jSONObject.putOpt("sc", jSONObject2.optString("sc"));
            jSONObject.putOpt("ec", jSONObject2.optString("ec"));
            jSONObject.putOpt("aa", jSONObject2.optString("aa"));
            jSONObject.putOpt("ab", jSONObject2.optString("ab"));
            jSONObject.putOpt("ba", jSONObject2.optString("ba"));
            jSONObject.putOpt("bb", jSONObject2.optString("bb"));
            jSONObject.putOpt("vp", jSONObject2.optString("vp"));
            jSONObject.putOpt("d", jSONObject2.optString("d"));
            jSONObject.putOpt("p", jSONObject2.optString("p"));
            jSONObject.putOpt("f", jSONObject2.optString("f"));
            jSONObject.putOpt("x", jSONObject2.optString("x"));
            jSONObject.putOpt("sz", jSONObject2.optString("sz"));
            jSONObject.putOpt("tid", jSONObject2.optString("tid"));
            jSONObject.putOpt("da", jSONObject2.optString("da"));
            jSONObject.putOpt("db", jSONObject2.optString("db"));
            jSONObject.putOpt("click_area", jSONObject2.optString("click_area"));
            jSONObject.putOpt("sm", jSONObject2.optString("sm"));
            jSONObject.putOpt("in", jSONObject2.optString("in"));
            jSONObject.putOpt("pcs", jSONObject2.optString("pcs"));
            jSONObject.putOpt("se", jSONObject2.optString("se"));
            jSONObject.putOpt(CampaignUnit.JSON_KEY_DO, jSONObject2.optString(CampaignUnit.JSON_KEY_DO));
            jSONObject.putOpt("ac", jSONObject2.optString("ac"));
            jSONObject.putOpt("ot", jSONObject2.optString("ot"));
            jSONObject.putOpt("rwd", jSONObject2.optString("rwd"));
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e4) {
            d1.a(f42709a, e4.getMessage());
            return str;
        }
    }

    public static void b(String str) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("gasi", 999);
        if (a4 == -1) {
            return;
        }
        if (a4 == 999) {
            if (f42710b >= 0 && f42711c >= 0) {
                return;
            }
        } else if (a4 > 0 && System.currentTimeMillis() - f42712d < a4 * 60 * 1000) {
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("accessibility");
        f42712d = System.currentTimeMillis();
        if (accessibilityManager == null) {
            f42710b = -999;
            f42711c = -999;
            return;
        }
        try {
            List<AccessibilityServiceInfo> installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList();
            if (installedAccessibilityServiceList == null) {
                f42710b = 0;
            } else {
                int i4 = 0;
                for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                    if (accessibilityServiceInfo != null) {
                        if (accessibilityServiceInfo.packageNames == null) {
                            i4++;
                        } else {
                            for (String str2 : accessibilityServiceInfo.packageNames) {
                                if (TextUtils.equals(str, str2)) {
                                    i4++;
                                }
                            }
                        }
                    }
                }
                f42710b = i4;
            }
        } catch (Throwable unused) {
            f42710b = -999;
        }
        try {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1);
            if (enabledAccessibilityServiceList == null) {
                f42711c = 0;
            } else {
                f42711c = enabledAccessibilityServiceList.size();
            }
        } catch (Throwable unused2) {
            f42711c = -999;
        }
    }

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            String[] split = com.qq.e.comm.plugin.d0.a.d().f().b("poudw", "user_id#100").split("#");
            for (int i4 = 0; i4 < split.length / 2; i4++) {
                int i5 = i4 * 2;
                hashMap.put(split[i5], Integer.valueOf(split[i5 + 1]));
            }
        } catch (Exception unused) {
            hashMap.put("user_id", 100);
        }
        JSONObject optJSONObject = GlobalSetting.getSettings().optJSONObject("media_ext");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Integer num = (Integer) hashMap.get(next);
                if (num != null) {
                    String optString = optJSONObject.optString(next);
                    if (optString != null && optString.getBytes().length <= num.intValue()) {
                        try {
                            jSONObject.put(next, optString);
                        } catch (JSONException unused2) {
                            GDTLogger.e("GlobalSetting.mediaExtData\u53c2\u6570\u62fc\u63a5\u5f02\u5e38\uff0c\u53c2\u6570\u5df2\u4e22\u5f03\uff0c\u8bf7\u68c0\u67e5\uff01");
                        }
                    } else {
                        GDTLogger.e("GlobalSetting.mediaExtData\u53c2\u6570value\u503c\u8fc7\u957f\uff0c\u53c2\u6570\u5df2\u4e22\u5f03\uff0c\u8bf7\u68c0\u67e5\uff01");
                    }
                }
            }
        }
        return jSONObject.toString();
    }
}
