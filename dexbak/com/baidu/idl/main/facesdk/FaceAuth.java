package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseAuthInfo;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseLocalInfo;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.statistic.PostDeviceInfo;
import com.baidu.idl.main.facesdk.utils.PreferencesUtil;
import com.baidu.mobads.sdk.internal.C2594an;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.BDLicenseAuthInfo;
import com.baidu.vis.unified.license.BDLicenseLocalInfo;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FaceAuth {
    private static int ALGORITHM_ID = 3;
    private static final String LICENSE_FILE_NAME = "idl-license.face-android";
    private static final String TAG = "FaceSDK";

    static {
        try {
            System.loadLibrary("bdface_sdk");
            System.loadLibrary("bd_unifylicense");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCreatInstance();

    private native void nativeSetActiveLog(int i, int i2);

    private native void nativeSetCoreConfigure(int i, int i2);

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

    public void initLicense(final Context context, final String str, final String str2, final boolean z, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() { // from class: com.baidu.idl.main.facesdk.FaceAuth.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                    AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, str2, z, FaceAuth.ALGORITHM_ID);
                    if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                        if (authGetLocalInfo != null) {
                            Log.i(FaceAuth.TAG, authGetLocalInfo.toString());
                        }
                    } else {
                        int nativeCreatInstance = FaceAuth.this.nativeCreatInstance();
                        Log.v(FaceAuth.TAG, "bdface_create_instance status " + nativeCreatInstance);
                    }
                    callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                } else {
                    callback.onResponse(2, "license 关键字为空");
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
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                PreferencesUtil.initPrefs(context2);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() { // from class: com.baidu.idl.main.facesdk.FaceAuth.3.1
                        @Override // com.baidu.idl.main.facesdk.callback.Callback
                        public void onResponse(int i, String str2) {
                            if (i == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(FaceAuth.LICENSE_FILE_NAME)) {
                    AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                    AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, FaceAuth.LICENSE_FILE_NAME, true, FaceAuth.ALGORITHM_ID);
                    if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                        if (authGetLocalInfo != null) {
                            Log.i(FaceAuth.TAG, authGetLocalInfo.toString());
                        }
                    } else {
                        int nativeCreatInstance = FaceAuth.this.nativeCreatInstance();
                        Log.v(FaceAuth.TAG, "bdface_create_instance status " + nativeCreatInstance);
                    }
                    callback.onResponse(authFromFile.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                    return;
                }
                callback.onResponse(2, "license 关键字为空");
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
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                PreferencesUtil.initPrefs(context2);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() { // from class: com.baidu.idl.main.facesdk.FaceAuth.2.1
                        @Override // com.baidu.idl.main.facesdk.callback.Callback
                        public void onResponse(int i, String str2) {
                            if (i == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(FaceAuth.LICENSE_FILE_NAME)) {
                    AndroidLicenser androidLicenser = AndroidLicenser.getInstance();
                    AndroidLicenser.ErrorCode authFromFile = androidLicenser.authFromFile(context, str, FaceAuth.LICENSE_FILE_NAME, false, FaceAuth.ALGORITHM_ID);
                    Log.e(FaceAuth.TAG, "errCode = " + authFromFile);
                    if (authFromFile == AndroidLicenser.ErrorCode.SUCCESS) {
                        int nativeCreatInstance = FaceAuth.this.nativeCreatInstance();
                        Log.v(FaceAuth.TAG, "bdface_create_instance status " + nativeCreatInstance);
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
                        jSONObject.put(ConstantHelper.LOG_VS, 5);
                        str2 = jSONObject.toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str2, C2594an.f8583d, FaceAuth.TAG);
                    if (requestPost == null) {
                        callback.onResponse(-1, "在线激活失败");
                        return;
                    }
                    String str3 = requestPost.responseStr;
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.optInt("error_code") != 0) {
                            String optString = jSONObject2.optString("error_msg");
                            Log.i(FaceAuth.TAG, "error_msg->" + optString);
                            callback.onResponse(-1, optString);
                        } else {
                            JSONObject optJSONObject = jSONObject2.optJSONObject(CommonNetImpl.RESULT);
                            if (optJSONObject != null) {
                                String optString2 = optJSONObject.optString("license");
                                if (!TextUtils.isEmpty(optString2) && (split = optString2.split(",")) != null && split.length == 2) {
                                    PreferencesUtil.putString("activate_online_key", str);
                                    AndroidLicenser.ErrorCode authFromMemory = androidLicenser.authFromMemory(context, str, split, FaceAuth.LICENSE_FILE_NAME, FaceAuth.ALGORITHM_ID);
                                    if (authFromMemory != AndroidLicenser.ErrorCode.SUCCESS) {
                                        BDLicenseLocalInfo authGetLocalInfo = androidLicenser.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                                        if (authGetLocalInfo != null) {
                                            Log.i(FaceAuth.TAG, authGetLocalInfo.toString());
                                        }
                                    } else {
                                        int nativeCreatInstance2 = FaceAuth.this.nativeCreatInstance();
                                        Log.v(FaceAuth.TAG, "bdface_create_instance status " + nativeCreatInstance2);
                                    }
                                    callback.onResponse(authFromMemory.ordinal(), androidLicenser.getErrorMsg(FaceAuth.ALGORITHM_ID));
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    Log.i(FaceAuth.TAG, "netRequest->" + str3);
                    return;
                }
                callback.onResponse(2, "license 关键字为空");
            }
        });
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i) {
        nativeSetActiveLog(bDFaceLogInfo.ordinal(), i);
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i) {
        nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i);
    }
}
