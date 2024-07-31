package com.baidu.idl.main.facesdk.statistic;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.mobads.sdk.internal.C2594an;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
                        str = "WIFI网络";
                    } else if (networkState.intValue() == 2) {
                        str = "2G网络";
                    } else if (networkState.intValue() == 3) {
                        str = "3G网络";
                    } else if (networkState.intValue() == 4) {
                        str = "4G网络";
                    } else {
                        str = networkState.intValue() == 5 ? "有线网卡" : "其他网络模块";
                    }
                    jSONObject.put("networkDesc", str);
                    jSONObject.put("os", 1);
                    jSONObject.put("osVersion", systemVersion);
                    jSONObject.put("sdk", 1);
                    jSONObject.put("sdkVersion", "4.1");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("mh", "offlineSdkStatistic");
                    jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_DT, jSONObject);
                    str2 = jSONObject2.toString();
                    Log.i("bdface", "参数是：" + str2);
                } catch (JSONException e) {
                    e.getStackTrace();
                }
                HttpStatus requestPost = HttpUtils.requestPost("http://brain.baidu.com/record/api", str2, C2594an.f8583d, "zxq");
                if (requestPost == null) {
                    callback.onResponse(-1, "请求失败");
                    return;
                }
                String str3 = requestPost.responseStr;
                Log.i("bdface", "response结果：" + str3);
                try {
                    if (TextUtils.isEmpty(str3)) {
                        callback.onResponse(-1, "request error");
                    } else {
                        JSONObject jSONObject3 = new JSONObject(str3);
                        callback.onResponse(jSONObject3.optInt("code"), jSONObject3.optString("msg"));
                    }
                } catch (JSONException e2) {
                    e2.getStackTrace();
                    callback.onResponse(-1, "request error = " + e2.getMessage());
                } catch (Exception e3) {
                    e3.getStackTrace();
                    callback.onResponse(-1, "request error = " + e3.getMessage());
                }
            }
        }).start();
    }
}
