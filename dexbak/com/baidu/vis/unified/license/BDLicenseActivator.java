package com.baidu.vis.unified.license;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2594an;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDLicenseActivator {
    public static final String TAG = "BDLicenseActivator";

    public static int initLicenseOnLine(Context context, String str, String str2, int i) {
        if (context == null) {
            Log.e(TAG, "initLicenseOnLine parameter error context == null");
            return -1;
        } else if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "initLicenseOnLine parameter error licenseID is empty");
            return -1;
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
            if (androidLicenser.authFromFile(context, str, str2, true, i) == AndroidLicenser.ErrorCode.SUCCESS) {
                return 0;
            }
            String deviceId = AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            String str3 = null;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("deviceId", deviceId);
                jSONObject.put(DomainCampaignEx.LOOPBACK_KEY, str);
                jSONObject.put("platformType", 2);
                jSONObject.put(ConstantHelper.LOG_VS, 1);
                str3 = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str3, C2594an.f8583d, TAG);
            if (requestPost == null) {
                Log.e(TAG, "initLicenseOnLine.HttpUtils.requestPost error httpStatus == null ");
                return -2;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(requestPost.responseStr);
                if (jSONObject2.optInt("error_code") != 0) {
                    String optString = jSONObject2.optString("error_msg");
                    Log.e(TAG, "initLicenseOnLine.requestPost.response.error_code -> " + optString);
                    return -3;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject(CommonNetImpl.RESULT);
                if (optJSONObject == null) {
                    Log.e(TAG, "initLicenseOnLine.requestPost.response error result == null");
                    return -3;
                }
                String optString2 = optJSONObject.optString("license");
                if (TextUtils.isEmpty(optString2)) {
                    Log.e(TAG, "initLicenseOnLine.requestPost.response error license is empty");
                    return -3;
                }
                String[] split = optString2.split(",");
                if (split != null && split.length == 2) {
                    if (androidLicenser.authFromMemory(context, str, split, str2, i) != AndroidLicenser.ErrorCode.SUCCESS) {
                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, i);
                        Log.e(TAG, "BDLicenseLocalInfo -> " + authGetLocalInfo.toString());
                        String errorMsg = androidLicenser.getErrorMsg(i);
                        Log.e(TAG, "errMsg ->" + errorMsg);
                        return -4;
                    }
                    return 0;
                }
                Log.e(TAG, "initLicenseOnLine.requestPost.response error licenses == null || licenses.length != 2");
                return -3;
            } catch (JSONException e2) {
                e2.printStackTrace();
                Log.i(TAG, "httpStatus.responseStr error");
                return -5;
            }
        }
    }
}
