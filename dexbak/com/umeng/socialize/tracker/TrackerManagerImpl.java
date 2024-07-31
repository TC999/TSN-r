package com.umeng.socialize.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.C2594an;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.socialize.tracker.utils.Errors;
import com.umeng.socialize.tracker.utils.HttpClient;
import com.umeng.socialize.tracker.utils.HttpRequestListener;
import com.umeng.socialize.tracker.utils.TaskPool;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.umeng.socialize.tracker.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class TrackerManagerImpl {

    /* renamed from: a */
    private static final String f39598a = "TrackerManagerImpl";

    /* renamed from: b */
    private static final int f39599b = 3000;

    /* renamed from: c */
    private static final String f39600c = "_$";

    /* renamed from: d */
    private static final int f39601d = 16;

    /* renamed from: e */
    private static final int f39602e = 64;

    /* renamed from: f */
    private static final String f39603f = "自定义属性名长度不能超过16个字符。";

    /* renamed from: g */
    private static final String f39604g = "自定义属性值长度不能超过64个字符。";

    /* compiled from: TrackerManagerImpl.java */
    /* renamed from: com.umeng.socialize.tracker.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13463a {

        /* renamed from: a */
        private static final TrackerManagerImpl f39610a = new TrackerManagerImpl();

        private C13463a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m13223d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.has("code") ? jSONObject.optInt("code") : 0;
            String optString = jSONObject.has("msg") ? jSONObject.optString("msg") : "";
            return "错误详情 [" + optInt + "]: " + optString;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static String m13222e(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has(TrackerConstant.f39596l)) {
                return optJSONObject.optString(TrackerConstant.f39596l);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static boolean m13221f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("code") ? jSONObject.getInt("code") : 0) == 200;
        } catch (Throwable unused) {
            return false;
        }
    }

    private TrackerManagerImpl() {
    }

    /* renamed from: a */
    public static TrackerManagerImpl m13228a() {
        return C13463a.f39610a;
    }

    /* renamed from: a */
    public void m13227a(Context context, String str, String str2, String str3, String str4, Map<String, String> map, final int i, final TrackerResultHandler trackerResultHandler) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (String str5 : map.keySet()) {
                String str6 = map.get(str5);
                if (!TextUtils.isEmpty(str5)) {
                    if (str5.length() > 16) {
                        Log.e("UMLog", f39603f);
                    } else if (TextUtils.isEmpty(str6)) {
                        Log.e("UMLog", "自定义属性[" + str5 + "]值为null或者空字符串。");
                    } else if (str6.length() > 64) {
                        Log.e("UMLog", f39604g);
                    } else {
                        hashMap.put(str5, str6);
                    }
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            for (String str7 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str7)) {
                    jSONObject3.put(str7, hashMap.get(str7));
                }
            }
            jSONObject2.put(TrackerConstant.f39588d, str);
            jSONObject2.put(TrackerConstant.f39589e, str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put(TrackerConstant.f39591g, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put(TrackerConstant.f39590f, str3);
            } else {
                jSONObject2.put(TrackerConstant.f39590f, (Object) null);
            }
            jSONObject.put(TrackerConstant.f39587c, jSONObject2);
            jSONObject.put(TrackerConstant.f39592h, jSONObject3);
            final String jSONObject4 = jSONObject.toString();
            context.getApplicationContext();
            TaskPool.m13213a(new Runnable() { // from class: com.umeng.socialize.tracker.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str8 = jSONObject4;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Content-Type", C2594an.f8583d);
                    HttpClient httpClient = new HttpClient(TrackerConstant.f39585a, HttpClient.EnumC13464a.POST, hashMap2, new HttpRequestListener() { // from class: com.umeng.socialize.tracker.b.1.1
                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        /* renamed from: a */
                        public void mo13219a() {
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        /* renamed from: a */
                        public void mo13218a(String str9) {
                            if (TextUtils.isEmpty(str9)) {
                                trackerResultHandler.codeGenerateFailed(new Throwable(Errors.EmptyResponse.m13216a()));
                                return;
                            }
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> utc:onRequestSuccess: " + str9);
                            if (TrackerManagerImpl.m13221f(str9)) {
                                String m13222e = TrackerManagerImpl.m13222e(str9);
                                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> utc:success:rootTrackCode: " + m13222e);
                                trackerResultHandler.codeGenerateSuccess(m13222e);
                                return;
                            }
                            String m13223d = TrackerManagerImpl.m13223d(str9);
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> utc:failed:error: " + m13223d);
                            trackerResultHandler.codeGenerateFailed(new Throwable(m13223d));
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        /* renamed from: a */
                        public void mo13217a(Throwable th) {
                            trackerResultHandler.codeGenerateFailed(th);
                        }
                    });
                    int i2 = i;
                    httpClient.m13214a((i2 <= 0 || i2 > 10) ? 3000 : i2 * 1000, str8);
                }
            });
        } catch (Throwable unused) {
            trackerResultHandler.codeGenerateFailed(new Throwable(Errors.ErrorMakeRequestBody.m13216a()));
        }
    }
}
