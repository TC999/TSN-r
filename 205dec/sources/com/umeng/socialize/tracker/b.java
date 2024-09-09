package com.umeng.socialize.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.socialize.tracker.utils.HttpRequestListener;
import com.umeng.socialize.tracker.utils.b;
import com.umeng.socialize.tracker.utils.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TrackerManagerImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54172a = "TrackerManagerImpl";

    /* renamed from: b  reason: collision with root package name */
    private static final int f54173b = 3000;

    /* renamed from: c  reason: collision with root package name */
    private static final String f54174c = "_$";

    /* renamed from: d  reason: collision with root package name */
    private static final int f54175d = 16;

    /* renamed from: e  reason: collision with root package name */
    private static final int f54176e = 64;

    /* renamed from: f  reason: collision with root package name */
    private static final String f54177f = "\u81ea\u5b9a\u4e49\u5c5e\u6027\u540d\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc716\u4e2a\u5b57\u7b26\u3002";

    /* renamed from: g  reason: collision with root package name */
    private static final String f54178g = "\u81ea\u5b9a\u4e49\u5c5e\u6027\u503c\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc764\u4e2a\u5b57\u7b26\u3002";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TrackerManagerImpl.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f54184a = new b();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.has("code") ? jSONObject.optInt("code") : 0;
            String optString = jSONObject.has("msg") ? jSONObject.optString("msg") : "";
            return "\u9519\u8bef\u8be6\u60c5 [" + optInt + "]: " + optString;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has("rootTrackCode")) {
                return optJSONObject.optString("rootTrackCode");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("code") ? jSONObject.getInt("code") : 0) == 200;
        } catch (Throwable unused) {
            return false;
        }
    }

    private b() {
    }

    public static b a() {
        return a.f54184a;
    }

    public void a(Context context, String str, String str2, String str3, String str4, Map<String, String> map, final int i4, final TrackerResultHandler trackerResultHandler) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (String str5 : map.keySet()) {
                String str6 = map.get(str5);
                if (!TextUtils.isEmpty(str5)) {
                    if (str5.length() > 16) {
                        Log.e("UMLog", "\u81ea\u5b9a\u4e49\u5c5e\u6027\u540d\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc716\u4e2a\u5b57\u7b26\u3002");
                    } else if (TextUtils.isEmpty(str6)) {
                        Log.e("UMLog", "\u81ea\u5b9a\u4e49\u5c5e\u6027[" + str5 + "]\u503c\u4e3anull\u6216\u8005\u7a7a\u5b57\u7b26\u4e32\u3002");
                    } else if (str6.length() > 64) {
                        Log.e("UMLog", "\u81ea\u5b9a\u4e49\u5c5e\u6027\u503c\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc764\u4e2a\u5b57\u7b26\u3002");
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
            jSONObject2.put("_$appkey", str);
            jSONObject2.put("_$umid", str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put("_$uid", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("_$url", str3);
            } else {
                jSONObject2.put("_$url", (Object) null);
            }
            jSONObject.put("initData", jSONObject2);
            jSONObject.put("userData", jSONObject3);
            final String jSONObject4 = jSONObject.toString();
            context.getApplicationContext();
            c.a(new Runnable() { // from class: com.umeng.socialize.tracker.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str8 = jSONObject4;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Content-Type", "application/json");
                    com.umeng.socialize.tracker.utils.b bVar = new com.umeng.socialize.tracker.utils.b("https://c.umsns.com/ulink/getRTC", b.a.POST, hashMap2, new HttpRequestListener() { // from class: com.umeng.socialize.tracker.b.1.1
                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a() {
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a(String str9) {
                            if (TextUtils.isEmpty(str9)) {
                                trackerResultHandler.codeGenerateFailed(new Throwable(com.umeng.socialize.tracker.utils.a.EmptyResponse.a()));
                                return;
                            }
                            UMRTLog.i("MobclickRT", "--->>> utc:onRequestSuccess: " + str9);
                            if (b.f(str9)) {
                                String e4 = b.e(str9);
                                UMRTLog.i("MobclickRT", "--->>> utc:success:rootTrackCode: " + e4);
                                trackerResultHandler.codeGenerateSuccess(e4);
                                return;
                            }
                            String d4 = b.d(str9);
                            UMRTLog.i("MobclickRT", "--->>> utc:failed:error: " + d4);
                            trackerResultHandler.codeGenerateFailed(new Throwable(d4));
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a(Throwable th) {
                            trackerResultHandler.codeGenerateFailed(th);
                        }
                    });
                    int i5 = i4;
                    bVar.a((i5 <= 0 || i5 > 10) ? 3000 : i5 * 1000, str8);
                }
            });
        } catch (Throwable unused) {
            trackerResultHandler.codeGenerateFailed(new Throwable(com.umeng.socialize.tracker.utils.a.ErrorMakeRequestBody.a()));
        }
    }
}
