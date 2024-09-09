package com.baidu.vis.unified.license;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BDLicenseActivator {
    public static final String TAG = "BDLicenseActivator";

    public static int initLicenseOnLine(Context context, String str, String str2, int i4) {
        if (context == null) {
            Log.e("BDLicenseActivator", "initLicenseOnLine parameter error context == null");
            return -1;
        } else if (TextUtils.isEmpty(str)) {
            Log.e("BDLicenseActivator", "initLicenseOnLine parameter error licenseID is empty");
            return -1;
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
            if (androidLicenser.authFromFile(context, str, str2, true, i4) == AndroidLicenser.ErrorCode.SUCCESS) {
                return 0;
            }
            String deviceId = AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            String str3 = null;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("deviceId", deviceId);
                jSONObject.put(DomainCampaignEx.LOOPBACK_KEY, str);
                jSONObject.put("platformType", 2);
                jSONObject.put("version", 1);
                str3 = jSONObject.toString();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str3, "application/json", "BDLicenseActivator");
            if (requestPost == null) {
                Log.e("BDLicenseActivator", "initLicenseOnLine.HttpUtils.requestPost error httpStatus == null ");
                return -2;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(requestPost.responseStr);
                if (jSONObject2.optInt("error_code") != 0) {
                    String optString = jSONObject2.optString("error_msg");
                    Log.e("BDLicenseActivator", "initLicenseOnLine.requestPost.response.error_code -> " + optString);
                    return -3;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                if (optJSONObject == null) {
                    Log.e("BDLicenseActivator", "initLicenseOnLine.requestPost.response error result == null");
                    return -3;
                }
                String optString2 = optJSONObject.optString("license");
                if (TextUtils.isEmpty(optString2)) {
                    Log.e("BDLicenseActivator", "initLicenseOnLine.requestPost.response error license is empty");
                    return -3;
                }
                String[] split = optString2.split(",");
                if (split != null && split.length == 2) {
                    if (androidLicenser.authFromMemory(context, str, split, str2, i4) != AndroidLicenser.ErrorCode.SUCCESS) {
                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, i4);
                        Log.e("BDLicenseActivator", "BDLicenseLocalInfo -> " + authGetLocalInfo.toString());
                        String errorMsg = androidLicenser.getErrorMsg(i4);
                        Log.e("BDLicenseActivator", "errMsg ->" + errorMsg);
                        return -4;
                    }
                    return 0;
                }
                Log.e("BDLicenseActivator", "initLicenseOnLine.requestPost.response error licenses == null || licenses.length != 2");
                return -3;
            } catch (JSONException e5) {
                e5.printStackTrace();
                Log.i("BDLicenseActivator", "httpStatus.responseStr error");
                return -5;
            }
        }
    }
}
