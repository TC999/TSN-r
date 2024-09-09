package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ModelHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class al {
    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            ak akVar = new ak();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            akVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            akVar.b(appkey);
            akVar.c(UMUtils.getAppVersionName(context));
            akVar.d("9.6.5");
            akVar.e(UMUtils.getChannel(context));
            akVar.f(Build.VERSION.SDK_INT + "");
            akVar.g(Build.BRAND);
            akVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            akVar.i(localeInfo[1]);
            akVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            akVar.b(Integer.valueOf(resolutionArray[1]));
            akVar.a(Integer.valueOf(resolutionArray[0]));
            akVar.k(ap.a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ak.f52512a, akVar.a());
                    jSONObject2.put(ak.f52514c, akVar.c());
                    jSONObject2.put(ak.f52513b, akVar.b());
                    jSONObject2.put(ak.f52515d, akVar.d());
                    jSONObject2.put(ak.f52516e, akVar.e());
                    jSONObject2.put(ak.f52517f, akVar.f());
                    jSONObject2.put(ak.f52518g, akVar.g());
                    jSONObject2.put(ak.f52519h, akVar.h());
                    jSONObject2.put(ak.f52522k, akVar.k());
                    jSONObject2.put(ak.f52521j, akVar.j());
                    jSONObject2.put(ak.f52523l, akVar.l());
                    jSONObject2.put(ak.f52520i, akVar.i());
                    jSONObject2.put(ak.f52524m, akVar.m());
                    jSONObject2.put("zid", UMUtils.getZid(context));
                    jSONObject2.put("platform", "android");
                    jSONObject2.put("optional", new JSONObject(ap.a()));
                    String[] split = str.split("@");
                    if (split.length == 4) {
                        try {
                            long parseLong = Long.parseLong(split[0]);
                            String str2 = split[1];
                            jSONObject2.put("s1", parseLong);
                            jSONObject2.put("s2", str2);
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        String str3 = Build.BRAND;
                        String a4 = aq.a(str3);
                        String b4 = aq.b(str3);
                        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(b4)) {
                            jSONObject2.put(ak.f52525n, a4);
                            jSONObject2.put(ak.f52526o, b4);
                        } else {
                            jSONObject2.put(ak.f52525n, "Android");
                            jSONObject2.put(ak.f52526o, Build.VERSION.RELEASE);
                        }
                    } catch (Throwable unused2) {
                    }
                    return jSONObject2;
                } catch (JSONException e4) {
                    e = e4;
                    jSONObject = jSONObject2;
                    UMRTLog.e("MobclickRT", "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                    UMRTLog.e("MobclickRT", "[getCloudConfigParam] error " + th.getMessage());
                    return jSONObject;
                }
            } catch (JSONException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject a(Context context, int i4, JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        try {
            String zid = UMUtils.getZid(context);
            if (TextUtils.isEmpty(zid)) {
                return jSONObject;
            }
            jSONObject.put("atoken", zid);
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject.put("device_token", deviceToken);
            }
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("os", "android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("hit_sdk", str);
            jSONObject.put("sdk", jSONArray);
            jSONObject.put("e", i4);
            return jSONObject;
        } catch (Throwable unused2) {
            jSONObject2 = jSONObject;
            return jSONObject2;
        }
    }
}
