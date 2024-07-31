package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.tencent.connect.common.Constants;
import com.umeng.ccg.CcgConstant;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.al */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ModelHelper {
    /* renamed from: a */
    public static JSONObject m14720a(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            CloudConfig cloudConfig = new CloudConfig();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            cloudConfig.m14745a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            cloudConfig.m14742b(appkey);
            cloudConfig.m14740c(UMUtils.getAppVersionName(context));
            cloudConfig.m14738d("9.6.5");
            cloudConfig.m14736e(UMUtils.getChannel(context));
            cloudConfig.m14734f(Build.VERSION.SDK_INT + "");
            cloudConfig.m14732g(Build.BRAND);
            cloudConfig.m14730h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            cloudConfig.m14728i(localeInfo[1]);
            cloudConfig.m14726j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            cloudConfig.m14743b(Integer.valueOf(resolutionArray[1]));
            cloudConfig.m14746a(Integer.valueOf(resolutionArray[0]));
            cloudConfig.m14724k(Misc.m14712a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(CloudConfig.f37618a, cloudConfig.m14747a());
                    jSONObject2.put(CloudConfig.f37620c, cloudConfig.m14741c());
                    jSONObject2.put(CloudConfig.f37619b, cloudConfig.m14744b());
                    jSONObject2.put(CloudConfig.f37621d, cloudConfig.m14739d());
                    jSONObject2.put(CloudConfig.f37622e, cloudConfig.m14737e());
                    jSONObject2.put(CloudConfig.f37623f, cloudConfig.m14735f());
                    jSONObject2.put(CloudConfig.f37624g, cloudConfig.m14733g());
                    jSONObject2.put(CloudConfig.f37625h, cloudConfig.m14731h());
                    jSONObject2.put(CloudConfig.f37628k, cloudConfig.m14725k());
                    jSONObject2.put(CloudConfig.f37627j, cloudConfig.m14727j());
                    jSONObject2.put(CloudConfig.f37629l, cloudConfig.m14723l());
                    jSONObject2.put(CloudConfig.f37626i, cloudConfig.m14729i());
                    jSONObject2.put(CloudConfig.f37630m, cloudConfig.m14722m());
                    jSONObject2.put(UMCommonContent.f37808al, UMUtils.getZid(context));
                    jSONObject2.put(Constants.PARAM_PLATFORM, FaceEnvironment.f8430OS);
                    jSONObject2.put("optional", new JSONObject(Misc.m14714a()));
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
                        String m14708a = C13111aq.m14708a(str3);
                        String m14707b = C13111aq.m14707b(str3);
                        if (!TextUtils.isEmpty(m14708a) && !TextUtils.isEmpty(m14707b)) {
                            jSONObject2.put(CloudConfig.f37631n, m14708a);
                            jSONObject2.put(CloudConfig.f37632o, m14707b);
                        } else {
                            jSONObject2.put(CloudConfig.f37631n, "Android");
                            jSONObject2.put(CloudConfig.f37632o, Build.VERSION.RELEASE);
                        }
                    } catch (Throwable unused2) {
                    }
                    return jSONObject2;
                } catch (JSONException e) {
                    e = e;
                    jSONObject = jSONObject2;
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                    return jSONObject;
                }
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static JSONObject m14721a(Context context, int i, JSONArray jSONArray, String str) {
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
            jSONObject.put(C2624bk.f8685i, Build.MODEL);
            jSONObject.put("os", FaceEnvironment.f8430OS);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put(CcgConstant.f38544o, str);
            jSONObject.put("sdk", jSONArray);
            jSONObject.put("e", i);
            return jSONObject;
        } catch (Throwable unused2) {
            jSONObject2 = jSONObject;
            return jSONObject2;
        }
    }
}
