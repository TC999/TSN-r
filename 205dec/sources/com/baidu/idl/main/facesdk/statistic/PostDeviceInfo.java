package com.baidu.idl.main.facesdk.statistic;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PostDeviceInfo {
    public static void uploadDeviceInfo(final Context context, final Callback callback) {
        new Thread(new Runnable() { // from class: com.baidu.idl.main.facesdk.statistic.PostDeviceInfo.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String deviceId = AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                String systemVersion = DeviceInfoUtil.getSystemVersion();
                float longValue = (float) ((Long.valueOf(DeviceInfoUtil.getRamInfo(context)).longValue() / 1024) / 1024);
                float deviceBasicFrequency = DeviceInfoUtil.getDeviceBasicFrequency() / 1000;
                int numberOfCPUCores = DeviceInfoUtil.getNumberOfCPUCores();
                int intValue = DeviceInfoUtil.getCPUBit().intValue();
                Integer networkState = NetWorkUtil.getNetworkState(context);
                String str2 = null;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("analysisType", "offline_Sdk");
                    jSONObject.put("deviceId", deviceId);
                    jSONObject.put("cpuCore", numberOfCPUCores);
                    jSONObject.put("cpuBit", intValue);
                    jSONObject.put("ghz", Math.round(deviceBasicFrequency));
                    jSONObject.put("ram", Math.round(longValue));
                    jSONObject.put("networkType", networkState);
                    if (networkState.intValue() == 1) {
                        str = "WIFI\u7f51\u7edc";
                    } else if (networkState.intValue() == 2) {
                        str = "2G\u7f51\u7edc";
                    } else if (networkState.intValue() == 3) {
                        str = "3G\u7f51\u7edc";
                    } else if (networkState.intValue() == 4) {
                        str = "4G\u7f51\u7edc";
                    } else {
                        str = networkState.intValue() == 5 ? "\u6709\u7ebf\u7f51\u5361" : "\u5176\u4ed6\u7f51\u7edc\u6a21\u5757";
                    }
                    jSONObject.put("networkDesc", str);
                    jSONObject.put("os", 1);
                    jSONObject.put("osVersion", systemVersion);
                    jSONObject.put("sdk", 1);
                    jSONObject.put("sdkVersion", "4.1");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("mh", "offlineSdkStatistic");
                    jSONObject2.put("dt", jSONObject);
                    str2 = jSONObject2.toString();
                    Log.i("bdface", "\u53c2\u6570\u662f\uff1a" + str2);
                } catch (JSONException e4) {
                    e4.getStackTrace();
                }
                HttpStatus requestPost = HttpUtils.requestPost("http://brain.baidu.com/record/api", str2, "application/json", "zxq");
                if (requestPost == null) {
                    callback.onResponse(-1, "\u8bf7\u6c42\u5931\u8d25");
                    return;
                }
                String str3 = requestPost.responseStr;
                Log.i("bdface", "response\u7ed3\u679c\uff1a" + str3);
                try {
                    if (TextUtils.isEmpty(str3)) {
                        callback.onResponse(-1, "request error");
                    } else {
                        JSONObject jSONObject3 = new JSONObject(str3);
                        callback.onResponse(jSONObject3.optInt("code"), jSONObject3.optString("msg"));
                    }
                } catch (JSONException e5) {
                    e5.getStackTrace();
                    callback.onResponse(-1, "request error = " + e5.getMessage());
                } catch (Exception e6) {
                    e6.getStackTrace();
                    callback.onResponse(-1, "request error = " + e6.getMessage());
                }
            }
        }).start();
    }
}
