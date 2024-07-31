package com.mbridge.msdk.out;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.MappingFile;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ApkDisplayInfo implements NoProGuard, Serializable {
    private static String JSON_KEY_APP_NAME = "app_name";
    private static String JSON_KEY_APP_VER = "app_ver";
    private static String JSON_KEY_DEV_NAME = "dev_name";
    private static String JSON_KEY_PERM_DESC = "perm_desc";
    private static String JSON_KEY_PERM_DESC_ALL = "ori_perm_all";
    private static String JSON_KEY_PERM_DESC_ORI = "ori_perm_desc";
    private static String JSON_KEY_PRI_URL = "pri_url";
    private static String JSON_KEY_UPD_TIME = "upd_time";
    private String appName;
    private String appVersion;
    private String devName;
    private String priUrl;
    private String updateTime;
    private ArrayList<String> permDescList = new ArrayList<>();
    private ArrayList<String> permDescOriList = new ArrayList<>();
    private ArrayList<String> permDescAllList = new ArrayList<>();

    public static JSONArray arrayListArrayCovertToJsonArray(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray;
    }

    private static ApkDisplayInfo checkApkDisplayInfoIfNullWillInit(ApkDisplayInfo apkDisplayInfo) {
        return apkDisplayInfo == null ? new ApkDisplayInfo() : apkDisplayInfo;
    }

    public static ArrayList<String> jsonArrayCovertToArrayList(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    public static ApkDisplayInfo parse(JSONObject jSONObject) {
        ApkDisplayInfo apkDisplayInfo = null;
        if (jSONObject != null) {
            if (jSONObject.has(JSON_KEY_APP_NAME)) {
                apkDisplayInfo = checkApkDisplayInfoIfNullWillInit(null);
                apkDisplayInfo.setAppName(jSONObject.optString(JSON_KEY_APP_NAME));
            }
            if (jSONObject.has(JSON_KEY_PERM_DESC)) {
                apkDisplayInfo = checkApkDisplayInfoIfNullWillInit(apkDisplayInfo);
                JSONArray optJSONArray = jSONObject.optJSONArray(JSON_KEY_PERM_DESC);
                if (optJSONArray != null) {
                    apkDisplayInfo.setPermDescList(jsonArrayCovertToArrayList(optJSONArray));
                    ArrayList<String> permDescAllList = apkDisplayInfo.getPermDescAllList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        try {
                            Object obj = optJSONArray.get(i);
                            if (obj instanceof String) {
                                permDescAllList.add(MappingFile.m21817a((String) obj));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    apkDisplayInfo.setPermDescAllList(permDescAllList);
                }
            }
            if (jSONObject.has(JSON_KEY_PERM_DESC_ORI)) {
                apkDisplayInfo = checkApkDisplayInfoIfNullWillInit(apkDisplayInfo);
                JSONArray optJSONArray2 = jSONObject.optJSONArray(JSON_KEY_PERM_DESC_ORI);
                if (optJSONArray2 != null) {
                    apkDisplayInfo.setPermDescOriList(jsonArrayCovertToArrayList(optJSONArray2));
                    ArrayList<String> permDescAllList2 = apkDisplayInfo.getPermDescAllList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        try {
                            Object obj2 = optJSONArray2.get(i2);
                            if (obj2 instanceof String) {
                                permDescAllList2.add((String) obj2);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    apkDisplayInfo.setPermDescAllList(permDescAllList2);
                }
            }
            if (jSONObject.has(JSON_KEY_PRI_URL)) {
                apkDisplayInfo = checkApkDisplayInfoIfNullWillInit(apkDisplayInfo);
                apkDisplayInfo.setPriUrl(jSONObject.optString(JSON_KEY_PRI_URL));
            }
            if (jSONObject.has(JSON_KEY_UPD_TIME)) {
                apkDisplayInfo = checkApkDisplayInfoIfNullWillInit(apkDisplayInfo);
                apkDisplayInfo.setUpdateTime(jSONObject.optString(JSON_KEY_UPD_TIME));
            }
            if (jSONObject.has(JSON_KEY_APP_VER)) {
                apkDisplayInfo = checkApkDisplayInfoIfNullWillInit(apkDisplayInfo);
                apkDisplayInfo.setAppVersion(jSONObject.optString(JSON_KEY_APP_VER));
            }
            if (jSONObject.has(JSON_KEY_DEV_NAME)) {
                ApkDisplayInfo checkApkDisplayInfoIfNullWillInit = checkApkDisplayInfoIfNullWillInit(apkDisplayInfo);
                checkApkDisplayInfoIfNullWillInit.setDevName(jSONObject.optString(JSON_KEY_DEV_NAME));
                return checkApkDisplayInfoIfNullWillInit;
            }
            return apkDisplayInfo;
        }
        return null;
    }

    public static ApkDisplayInfo parseByString(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return parse(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDevName() {
        return this.devName;
    }

    public ArrayList<String> getPermDescAllList() {
        return this.permDescAllList;
    }

    public ArrayList<String> getPermDescList() {
        return this.permDescList;
    }

    public ArrayList<String> getPermDescOriList() {
        return this.permDescOriList;
    }

    public String getPriUrl() {
        return this.priUrl;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDevName(String str) {
        this.devName = str;
    }

    public void setPermDescAllList(ArrayList<String> arrayList) {
        this.permDescAllList = arrayList;
    }

    public void setPermDescList(ArrayList<String> arrayList) {
        this.permDescList = arrayList;
    }

    public void setPermDescOriList(ArrayList<String> arrayList) {
        this.permDescOriList = arrayList;
    }

    public void setPriUrl(String str) {
        this.priUrl = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.appName)) {
                jSONObject.put(JSON_KEY_APP_NAME, this.appName);
            }
            ArrayList<String> arrayList = this.permDescList;
            if (arrayList != null && arrayList.size() > 0) {
                jSONObject.put(JSON_KEY_PERM_DESC, arrayListArrayCovertToJsonArray(this.permDescList));
            }
            ArrayList<String> arrayList2 = this.permDescOriList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                jSONObject.put(JSON_KEY_PERM_DESC_ORI, arrayListArrayCovertToJsonArray(this.permDescOriList));
            }
            ArrayList<String> arrayList3 = this.permDescAllList;
            if (arrayList3 != null && arrayList3.size() > 0) {
                jSONObject.put(JSON_KEY_PERM_DESC_ALL, arrayListArrayCovertToJsonArray(this.permDescAllList));
            }
            if (!TextUtils.isEmpty(this.priUrl)) {
                jSONObject.put(JSON_KEY_PRI_URL, this.priUrl);
            }
            if (!TextUtils.isEmpty(this.updateTime)) {
                jSONObject.put(JSON_KEY_UPD_TIME, this.updateTime);
            }
            if (!TextUtils.isEmpty(this.appVersion)) {
                jSONObject.put(JSON_KEY_APP_VER, this.appVersion);
            }
            if (!TextUtils.isEmpty(this.devName)) {
                jSONObject.put(JSON_KEY_DEV_NAME, this.devName);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject.length() > 0) {
            return jSONObject;
        }
        return null;
    }

    public String toString() {
        return "ApkDisplayInfo{appName='" + this.appName + "', permDescJArray=" + this.permDescList + ", permDescOriJArray=" + this.permDescOriList + ", permDescAll=" + this.permDescAllList + ", priUrl='" + this.priUrl + "', updateTime='" + this.updateTime + "', appVersion='" + this.appVersion + "', devName='" + this.devName + "'}";
    }
}
