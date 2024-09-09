package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseAuthInfo;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseLocalInfo;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.statistic.PostDeviceInfo;
import com.baidu.idl.main.facesdk.utils.PreferencesUtil;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.BDLicenseAuthInfo;
import com.baidu.vis.unified.license.BDLicenseLocalInfo;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FaceAuth {
    private static int ALGORITHM_ID = 3;
    private static final String LICENSE_FILE_NAME = "idl-license.face-android";
    private static final String TAG = "FaceSDK";

    static {
        try {
            System.loadLibrary("bdface_sdk");
            System.loadLibrary("bd_unifylicense");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCreatInstance();

    private native void nativeSetActiveLog(int i4, int i5);

    private native void nativeSetCoreConfigure(int i4, int i5);

    public BDFaceLicenseAuthInfo getAuthInfo(Context context) {
        BDLicenseAuthInfo authGetAuthInfo = AndroidLicenser.getInstance().authGetAuthInfo(context, ALGORITHM_ID);
        BDFaceLicenseAuthInfo bDFaceLicenseAuthInfo = new BDFaceLicenseAuthInfo();
        bDFaceLicenseAuthInfo.algorithmId = authGetAuthInfo.algorithmId;
        bDFaceLicenseAuthInfo.deviceId = authGetAuthInfo.deviceId;
        bDFaceLicenseAuthInfo.expireTime = authGetAuthInfo.expireTime;
        bDFaceLicenseAuthInfo.functionList = authGetAuthInfo.functionList;
        bDFaceLicenseAuthInfo.licenseKey = authGetAuthInfo.licenseKey;
        bDFaceLicenseAuthInfo.md5 = authGetAuthInfo.md5;
        bDFaceLicenseAuthInfo.packageName = authGetAuthInfo.packageName;
        return bDFaceLicenseAuthInfo;
    }

    public String getDeviceId(Context context) {
        return AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public BDFaceLicenseLocalInfo getLocalInfo(Context context) {
        BDLicenseLocalInfo authGetLocalInfo = AndroidLicenser.getInstance().authGetLocalInfo(context, ALGORITHM_ID);
        BDFaceLicenseLocalInfo bDFaceLicenseLocalInfo = new BDFaceLicenseLocalInfo();
        bDFaceLicenseLocalInfo.algorithmId = authGetLocalInfo.algorithmId;
        bDFaceLicenseLocalInfo.deviceId = authGetLocalInfo.deviceId;
        bDFaceLicenseLocalInfo.fingerVersion = authGetLocalInfo.fingerVersion;
        bDFaceLicenseLocalInfo.licenseSdkVersion = authGetLocalInfo.licenseSdkVersion;
        bDFaceLicenseLocalInfo.licenseKey = authGetLocalInfo.licenseKey;
        bDFaceLicenseLocalInfo.md5 = authGetLocalInfo.md5;
        bDFaceLicenseLocalInfo.packageName = authGetLocalInfo.packageName;
        return bDFaceLicenseLocalInfo;
    }

    public void initLicense(final Context context, final String str, final String str2, final boolean z3, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceAuth.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                    AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, str2, z3, FaceAuth.ALGORITHM_ID);
                    if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                        if (authGetLocalInfo != null) {
                            Log.i("FaceSDK", authGetLocalInfo.toString());
                        }
                    } else {
                        int nativeCreatInstance = FaceAuth.this.nativeCreatInstance();
                        Log.v("FaceSDK", "bdface_create_instance status " + nativeCreatInstance);
                    }
                    callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                } else {
                    callback.onResponse(2, "license \u5173\u952e\u5b57\u4e3a\u7a7a");
                }
            }
        });
    }

    public void initLicenseBatchLine(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceAuth.3
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                PreferencesUtil.initPrefs(context2);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() { // from class: com.baidu.idl.main.facesdk.FaceAuth.3.1
                        @Override // com.baidu.idl.main.facesdk.callback.Callback
                        public void onResponse(int i4, String str2) {
                            if (i4 == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty("idl-license.face-android")) {
                    AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                    AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, "idl-license.face-android", true, FaceAuth.ALGORITHM_ID);
                    if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                        if (authGetLocalInfo != null) {
                            Log.i("FaceSDK", authGetLocalInfo.toString());
                        }
                    } else {
                        int nativeCreatInstance = FaceAuth.this.nativeCreatInstance();
                        Log.v("FaceSDK", "bdface_create_instance status " + nativeCreatInstance);
                    }
                    callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                    return;
                }
                callback.onResponse(2, "license \u5173\u952e\u5b57\u4e3a\u7a7a");
            }
        });
    }

    public void initLicenseOnLine(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceAuth.2
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                Context context2 = context;
                if (context2 == null) {
                    callback.onResponse(1, "\u6ca1\u6709\u521d\u59cb\u5316\u4e0a\u4e0b\u6587");
                    return;
                }
                PreferencesUtil.initPrefs(context2);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() { // from class: com.baidu.idl.main.facesdk.FaceAuth.2.1
                        @Override // com.baidu.idl.main.facesdk.callback.Callback
                        public void onResponse(int i4, String str2) {
                            if (i4 == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty("idl-license.face-android")) {
                    AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                    AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, "idl-license.face-android", false, FaceAuth.ALGORITHM_ID);
                    Log.e("FaceSDK", "errCode = " + authFromFile);
                    if (authFromFile == AndroidLicenser.ErrorCode.SUCCESS) {
                        int nativeCreatInstance = FaceAuth.this.nativeCreatInstance();
                        Log.v("FaceSDK", "bdface_create_instance status " + nativeCreatInstance);
                        callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                        return;
                    }
                    String deviceId = AndroidLicenser.getDeviceId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    String str2 = null;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", deviceId);
                        jSONObject.put(DomainCampaignEx.LOOPBACK_KEY, str);
                        jSONObject.put("platformType", 2);
                        jSONObject.put("version", 5);
                        str2 = jSONObject.toString();
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str2, "application/json", "FaceSDK");
                    if (requestPost == null) {
                        callback.onResponse(-1, "\u5728\u7ebf\u6fc0\u6d3b\u5931\u8d25");
                        return;
                    }
                    String str3 = requestPost.responseStr;
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.optInt("error_code") != 0) {
                            String optString = jSONObject2.optString("error_msg");
                            Log.i("FaceSDK", "error_msg->" + optString);
                            callback.onResponse(-1, optString);
                        } else {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                            if (optJSONObject != null) {
                                String optString2 = optJSONObject.optString("license");
                                if (!TextUtils.isEmpty(optString2) && (split = optString2.split(",")) != null && split.length == 2) {
                                    PreferencesUtil.putString("activate_online_key", str);
                                    AndroidLicenser.ErrorCode authFromMemory = androidLicenser.authFromMemory(context, str, split, "idl-license.face-android", FaceAuth.ALGORITHM_ID);
                                    if (authFromMemory != AndroidLicenser.ErrorCode.SUCCESS) {
                                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                                        if (authGetLocalInfo != null) {
                                            Log.i("FaceSDK", authGetLocalInfo.toString());
                                        }
                                    } else {
                                        int nativeCreatInstance2 = FaceAuth.this.nativeCreatInstance();
                                        Log.v("FaceSDK", "bdface_create_instance status " + nativeCreatInstance2);
                                    }
                                    callback.onResponse(authFromMemory.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                                }
                            }
                        }
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    Log.i("FaceSDK", "netRequest->" + str3);
                    return;
                }
                callback.onResponse(2, "license \u5173\u952e\u5b57\u4e3a\u7a7a");
            }
        });
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i4) {
        nativeSetActiveLog(bDFaceLogInfo.ordinal(), i4);
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i4) {
        nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i4);
    }
}
