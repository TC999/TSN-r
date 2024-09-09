package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class AbsFeedBackForH5 extends j {
    private static int FAILED = 1;
    private static int SUCCESS = 0;
    public static final String WEBVIEW_EVENT_DIALOG_METHOD_NAME = "onFeedbackAlertStatusNotify";
    public static final String WEBVIEW_EVENT_DIALOG_PARAMS_KEY_STATUS = "status";
    public static final int WEBVIEW_EVENT_METHOD_DIALOG_STATUS_DISMISS = 2;
    public static final int WEBVIEW_EVENT_METHOD_DIALOG_STATUS_SHOWED = 1;
    private String TAG = "AbsFeedBackForH5";

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", FAILED);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e4) {
            x.a(this.TAG, e4.getMessage());
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", SUCCESS);
            jSONObject.put("message", "");
            jSONObject.put("data", new JSONObject());
            h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e4) {
            callbackExcep(obj, e4.getMessage());
            x.a(this.TAG, e4.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", SUCCESS);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e4) {
            callbackExcep(obj, e4.getMessage());
            x.a(this.TAG, e4.getMessage());
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("width", -1);
                int optInt2 = jSONObject.optInt("height", -1);
                int optInt3 = jSONObject.optInt("radius", 20);
                int optInt4 = jSONObject.optInt("left", -1);
                int optInt5 = jSONObject.optInt("top", -1);
                double optDouble = jSONObject.optDouble("opacity", 1.0d);
                double optDouble2 = jSONObject.optDouble("fontSize", -1.0d);
                JSONArray optJSONArray = jSONObject.optJSONArray("padding");
                String optString = jSONObject.optString("fontColor", "");
                String optString2 = jSONObject.optString("bgColor", "");
                com.mbridge.msdk.foundation.b.b.a().a(jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY, ""), optInt, optInt2, optInt3, optInt4, optInt5, (float) optDouble, optString, optString2, (float) optDouble2, optJSONArray);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                com.mbridge.msdk.foundation.b.b.a().a(jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY, ""), optInt == 1 ? 8 : 0, aVar.f40326a);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                com.mbridge.msdk.foundation.b.b.a().a(jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY, ""), optInt);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void getCacheKey(Object obj, String str) {
        try {
            com.mbridge.msdk.mbjscommon.d.a.a().a(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void startShake(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("deviceMotionUpdateInterval", 1);
                com.mbridge.msdk.mbjscommon.d.a.a().a(obj, ((a) obj).f40326a, jSONObject.optString("oldCache", ""), jSONObject.optString("cache", ""), optInt);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void stopShake(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.mbjscommon.d.a.a().a(obj, ((a) obj).f40326a, new JSONObject(str).optString("cache", ""));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }
}
