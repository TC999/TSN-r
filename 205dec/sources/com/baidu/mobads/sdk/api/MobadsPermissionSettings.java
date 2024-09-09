package com.baidu.mobads.sdk.api;

import android.os.Bundle;
import com.baidu.mobads.sdk.internal.aa;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.az;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MobadsPermissionSettings {
    private static final String PERMISSION_APP_LIST = "permission_app_list";
    private static final String PERMISSION_APP_UPDATE = "permission_app_update";
    private static final String PERMISSION_DEVICE_INFO = "permission_device_info";
    private static final String PERMISSION_LIMIT_STATE = "permission_limitpersonalads";
    private static final String PERMISSION_LOCATION = "permission_location";
    private static final String PERMISSION_OAID = "permission_oaid";
    private static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    private static final String PERMISSION_RUNNING_APP = "permission_running_app";
    private static final String PERMISSION_STORAGE = "permission_storage";
    private static boolean mAccessAppListGranted = false;
    private static boolean mAccessLocationGranted = false;
    private static boolean mAppUpdateGranted = true;
    private static boolean mCheckSPLimit = false;
    private static boolean mDeviceInfoGranted = true;
    private static boolean mExternalStorageGranted = false;
    private static boolean mLimitPrivacyAds = false;
    private static boolean mOAIDGranted = true;
    private static boolean mReadPhoneStateGranted = false;
    private static boolean mRunningAppGranted = true;

    public static JSONObject getLimitInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permission_limitpersonalads", mLimitPrivacyAds);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean getLimitPersonalAdsStatus() {
        updateSPLimitTag();
        return mLimitPrivacyAds;
    }

    public static JSONObject getPermissionInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permission_location", "" + mAccessLocationGranted);
            jSONObject.put("permission_storage", "" + mExternalStorageGranted);
            jSONObject.put("permission_app_list", "" + mAccessAppListGranted);
            jSONObject.put("permission_read_phone_state", "" + mReadPhoneStateGranted);
            jSONObject.put("permission_oaid", "" + mOAIDGranted);
            jSONObject.put("permission_app_update", "" + mAppUpdateGranted);
            jSONObject.put("permission_running_app", "" + mRunningAppGranted);
            jSONObject.put("permission_device_info", "" + mDeviceInfoGranted);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean handleIntegrationInfo(Bundle bundle) {
        try {
            switchDebugLog(bundle);
            IXAdContainerFactory c4 = aa.a().c();
            if (c4 != null) {
                c4.getRemoteParam("integrationInfo", bundle);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private static void postLimitInfoRemote() {
        IXAdContainerFactory c4 = aa.a().c();
        if (c4 != null) {
            c4.onTaskDistribute("limitpersonalads_module", getLimitInfo());
        }
    }

    private static void postPermissionInfoRemote() {
        IXAdContainerFactory c4 = aa.a().c();
        if (c4 != null) {
            c4.onTaskDistribute("permission_module", getPermissionInfo());
        }
    }

    public static void setLimitPersonalAds(boolean z3) {
        mLimitPrivacyAds = z3;
        postLimitInfoRemote();
    }

    public static void setPermissionAppList(boolean z3) {
        mAccessAppListGranted = z3;
        postPermissionInfoRemote();
    }

    public static void setPermissionAppUpdate(boolean z3) {
        mAppUpdateGranted = z3;
        postPermissionInfoRemote();
    }

    public static void setPermissionDeviceInfo(boolean z3) {
        mDeviceInfoGranted = z3;
        postPermissionInfoRemote();
    }

    public static void setPermissionLocation(boolean z3) {
        mAccessLocationGranted = z3;
        postPermissionInfoRemote();
    }

    public static void setPermissionOAID(boolean z3) {
        mOAIDGranted = z3;
        postPermissionInfoRemote();
    }

    public static void setPermissionReadDeviceID(boolean z3) {
        mReadPhoneStateGranted = z3;
        postPermissionInfoRemote();
    }

    public static void setPermissionRunningApp(boolean z3) {
        mRunningAppGranted = z3;
        postPermissionInfoRemote();
    }

    public static void setPermissionStorage(boolean z3) {
        mExternalStorageGranted = z3;
        postPermissionInfoRemote();
    }

    private static void switchDebugLog(Bundle bundle) {
        if (bundle != null && bundle.containsKey("debug_mode")) {
            if (bundle.getBoolean("debug_mode")) {
                az.a(true);
            } else {
                az.a();
            }
        } else if (bundle == null || !bundle.containsKey("logout")) {
        } else {
            if (bundle.getBoolean("logout")) {
                az.a((az.a) new ay());
            } else {
                az.i("logout");
            }
        }
    }

    private static void updateSPLimitTag() {
        aa a4;
        IXAdContainerFactory c4;
        try {
            if (mCheckSPLimit || (a4 = aa.a()) == null || (c4 = a4.c()) == null) {
                return;
            }
            Object remoteParam = c4.getRemoteParam("limitPersonalAds", new Object[0]);
            if (remoteParam instanceof Boolean) {
                mLimitPrivacyAds = ((Boolean) remoteParam).booleanValue();
                mCheckSPLimit = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
