package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import com.beizi.fusion.widget.ScrollClickView;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.p470b.FeedbackManager;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.p497d.ShakeCacheManager;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbsFeedBackForH5 extends WindVanePlugin {
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
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            SameLogTool.m21738a(this.TAG, e.getMessage());
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", SUCCESS);
            jSONObject.put("message", "");
            jSONObject.put("data", new JSONObject());
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            callbackExcep(obj, e.getMessage());
            SameLogTool.m21738a(this.TAG, e.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", SUCCESS);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e) {
            callbackExcep(obj, e.getMessage());
            SameLogTool.m21738a(this.TAG, e.getMessage());
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                CallMethodContext callMethodContext = (CallMethodContext) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("width", -1);
                int optInt2 = jSONObject.optInt("height", -1);
                int optInt3 = jSONObject.optInt("radius", 20);
                int optInt4 = jSONObject.optInt(ScrollClickView.DIR_LEFT, -1);
                int optInt5 = jSONObject.optInt("top", -1);
                double optDouble = jSONObject.optDouble("opacity", 1.0d);
                double optDouble2 = jSONObject.optDouble("fontSize", -1.0d);
                JSONArray optJSONArray = jSONObject.optJSONArray("padding");
                String optString = jSONObject.optString("fontColor", "");
                String optString2 = jSONObject.optString("bgColor", "");
                FeedbackManager.m22907a().m22902a(jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY, ""), optInt, optInt2, optInt3, optInt4, optInt5, (float) optDouble, optString, optString2, (float) optDouble2, optJSONArray);
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
                CallMethodContext callMethodContext = (CallMethodContext) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                FeedbackManager.m22907a().m22900a(jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY, ""), optInt == 1 ? 8 : 0, callMethodContext.f31554a);
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
                CallMethodContext callMethodContext = (CallMethodContext) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                FeedbackManager.m22907a().m22903a(jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY, ""), optInt);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void getCacheKey(Object obj, String str) {
        try {
            ShakeCacheManager.m21436a().m21435a(obj);
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
                ShakeCacheManager.m21436a().m21433a(obj, ((CallMethodContext) obj).f31554a, jSONObject.optString("oldCache", ""), jSONObject.optString("cache", ""), optInt);
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
                ShakeCacheManager.m21436a().m21434a(obj, ((CallMethodContext) obj).f31554a, new JSONObject(str).optString("cache", ""));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }
}
