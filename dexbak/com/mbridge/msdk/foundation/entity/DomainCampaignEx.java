package com.mbridge.msdk.foundation.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.out.ApkDisplayInfo;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DomainCampaignEx extends Campaign implements NoProGuard, Serializable {
    public static final String JSON_KEY_ADV_ID = "adv_id";
    public static final String JSON_KEY_AD_TRACKING_APK_END = "apk_download_end";
    public static final String JSON_KEY_AD_TRACKING_APK_INSTALL = "apk_install";
    public static final String JSON_KEY_AD_TRACKING_APK_START = "apk_download_start";
    public static final String JSON_KEY_AKDLUI = "akdlui";
    public static final String JSON_KEY_APK_ALT = "apk_alt";
    public static final String JSON_KEY_APK_INFO = "apk_info";
    public static final String JSON_KEY_ATAT_TYPE = "atat_type";
    public static final String JSON_KEY_DISPLAY_APK_ALT = "disableApkAlt";
    public static final String JSON_KEY_NTBARPASBL = "ntbarpasbl";
    public static final String JSON_KEY_NTBARPT = "ntbarpt";
    public static final String JSON_KEY_PRE_CLICK = "ttc";
    public static final String JSON_KEY_PRE_CLICK_ERROR_INTERVAL = "ttc_pe";
    public static final String JSON_KEY_PRE_CLICK_INTERVAL = "ttc_ct";
    public static final String JSON_KEY_PRE_CLICK_OTHER_INTERVAL = "ttc_po";
    public static final String JSON_KEY_TTC_CT2 = "ttc_ct2";
    public static final String JSON_KEY_TTC_TYPE = "ttc_type";
    public static final String KEY_BIND_ID = "bind_id";
    public static final String KEY_GH_ID = "gh_id";
    public static final String KEY_GH_PATH = "gh_path";
    public static final String LOOPBACK = "loopback";
    public static final String LOOPBACK_DOMAIN = "domain";
    public static final String LOOPBACK_KEY = "key";
    public static final String LOOPBACK_VALUE = "value";
    public static final String ROVER_KEY_IS_POST = "isPost";
    public static final String ROVER_KEY_MARK = "mark";
    public static final String TAG = DomainCampaignEx.class.getSimpleName();
    public static final int TTC_CT2_DEFAULT_VALUE = 1800;
    public static final int TTC_CT_DEFAULT_VALUE = 604800;
    private static final long serialVersionUID = 1;
    private String advId;
    private String bindId;
    private String ghId;
    private String ghPath;
    private CommonJumpLoader.JumpLoaderResult jumpResult;
    private Map<String, String> loopbackMap;
    private String loopbackString;
    private int preClickInterval;
    private int roverIsPost;
    private String roverMark;
    private int ttc_ct2;
    private int ttc_type;
    private int apk_alt = 0;
    private int displayApkAlt = 0;
    private int ntbarpt = 0;
    private int ntbarpasbl = 0;
    private int atatType = 0;
    private String akdlui = "";
    private boolean preClick = false;

    public static JSONObject campaignToJsonObject(JSONObject jSONObject, CampaignEx campaignEx) throws JSONException {
        if (campaignEx == null) {
            return jSONObject;
        }
        jSONObject.put(JSON_KEY_PRE_CLICK, campaignEx.isPreClick());
        jSONObject.put(JSON_KEY_PRE_CLICK_INTERVAL, campaignEx.getPreClickInterval());
        jSONObject.put(JSON_KEY_ADV_ID, campaignEx.getAdvId());
        jSONObject.put(JSON_KEY_TTC_TYPE, campaignEx.getTtc_type());
        jSONObject.put(JSON_KEY_TTC_CT2, campaignEx.getTtc_ct2());
        jSONObject.put(KEY_GH_ID, campaignEx.getGhId());
        jSONObject.put(KEY_GH_PATH, SameBase64Tool.m21813a(campaignEx.getGhPath()));
        jSONObject.put(KEY_BIND_ID, campaignEx.getBindId());
        jSONObject.put(JSON_KEY_APK_ALT, campaignEx.getApkAlt());
        jSONObject.put(JSON_KEY_DISPLAY_APK_ALT, campaignEx.getDisplayApkAlt());
        if (campaignEx.getApkDisplayInfo() != null) {
            jSONObject.put(JSON_KEY_APK_INFO, campaignEx.getApkDisplayInfo().toJson());
        }
        jSONObject.put(ROVER_KEY_MARK, campaignEx.getRoverMark());
        jSONObject.put(ROVER_KEY_IS_POST, campaignEx.getRoverIsPost());
        jSONObject.put(CampaignEx.JSON_KEY_NV_T2, campaignEx.getNvT2());
        jSONObject.put(JSON_KEY_NTBARPASBL, campaignEx.getNtbarpasbl());
        jSONObject.put(JSON_KEY_NTBARPT, campaignEx.getNtbarpt());
        jSONObject.put(JSON_KEY_ATAT_TYPE, campaignEx.getAtatType());
        jSONObject.put(JSON_KEY_AKDLUI, campaignEx.getAkdlui());
        return jSONObject;
    }

    public static Map<String, String> loopbackStrToMap(String str) {
        HashMap hashMap = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap2.put(LOOPBACK_DOMAIN, jSONObject.getString(LOOPBACK_DOMAIN));
                hashMap2.put(LOOPBACK_KEY, jSONObject.getString(LOOPBACK_KEY));
                hashMap2.put(LOOPBACK_VALUE, jSONObject.getString(LOOPBACK_VALUE));
                return hashMap2;
            } catch (Throwable unused) {
                hashMap = hashMap2;
                SameLogTool.m21733d("", "loopbackStrToMap error");
                return hashMap;
            }
        } catch (Throwable unused2) {
        }
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, CampaignEx campaignEx) {
        if (jSONObject == null || campaignEx == null) {
            return null;
        }
        try {
            campaignEx.setPreClick(jSONObject.optBoolean(JSON_KEY_PRE_CLICK));
            campaignEx.setPreClickInterval(jSONObject.optInt(JSON_KEY_PRE_CLICK_INTERVAL, TTC_CT_DEFAULT_VALUE));
            campaignEx.setAdvId(jSONObject.optString(JSON_KEY_ADV_ID));
            campaignEx.setTtc_type(jSONObject.optInt(JSON_KEY_TTC_TYPE, 3));
            campaignEx.setTtc_ct2(jSONObject.optInt(JSON_KEY_TTC_CT2, 1800));
            campaignEx.setRoverMark(jSONObject.optString(ROVER_KEY_MARK));
            campaignEx.setRoverIsPost(jSONObject.optInt(ROVER_KEY_IS_POST));
            try {
                if (jSONObject.has(LOOPBACK)) {
                    String optString = jSONObject.optString(LOOPBACK);
                    if (!TextUtils.isEmpty(optString)) {
                        campaignEx.setLoopbackString(optString);
                        campaignEx.setLoopbackMap(loopbackStrToMap(optString));
                    }
                }
            } catch (Exception unused) {
                SameLogTool.m21733d("", "loopback parser error");
            }
            String optString2 = jSONObject.optString(KEY_GH_ID);
            if (!TextUtils.isEmpty(optString2)) {
                campaignEx.setGhId(optString2);
                String optString3 = jSONObject.optString(KEY_GH_PATH);
                if (!TextUtils.isEmpty(optString3)) {
                    campaignEx.setGhPath(SameBase64Tool.m21812b(optString3));
                }
                campaignEx.setBindId(jSONObject.optString(KEY_BIND_ID));
            }
            campaignEx.setBannerHtml(jSONObject.optString("cam_html"));
            campaignEx.setAdHtml(jSONObject.optString("cam_html"));
            campaignEx.setApkAlt(jSONObject.optInt(JSON_KEY_APK_ALT, 0));
            campaignEx.setDisplayApkAlt(jSONObject.optInt(JSON_KEY_DISPLAY_APK_ALT, 0));
            campaignEx.setApkDisplayInfo(ApkDisplayInfo.parseByString(jSONObject.optString(JSON_KEY_APK_INFO)));
            campaignEx.setNtbarpasbl(jSONObject.optInt(JSON_KEY_NTBARPASBL, 0));
            campaignEx.setNtbarpt(jSONObject.optInt(JSON_KEY_NTBARPT, 0));
            campaignEx.setAtatType(jSONObject.optInt(JSON_KEY_ATAT_TYPE, 0));
            campaignEx.setAkdlui(jSONObject.optString(JSON_KEY_AKDLUI, ""));
            return campaignEx;
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            SameLogTool.m21733d(str, "parse campaign json exception: " + e.getLocalizedMessage());
            return campaignEx;
        }
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject, CampaignEx campaignEx) {
        if (jSONObject == null || campaignEx == null) {
            return null;
        }
        try {
            campaignEx.setPreClick(jSONObject.optBoolean(JSON_KEY_PRE_CLICK));
            campaignEx.setPreClickInterval(jSONObject.optInt(JSON_KEY_PRE_CLICK_INTERVAL, TTC_CT_DEFAULT_VALUE));
            campaignEx.setAdvId(jSONObject.optString(JSON_KEY_ADV_ID));
            campaignEx.setTtc_type(jSONObject.optInt(JSON_KEY_TTC_TYPE, 3));
            campaignEx.setTtc_ct2(jSONObject.optInt(JSON_KEY_TTC_CT2, 1800));
            campaignEx.setTimestamp(System.currentTimeMillis());
            campaignEx.setHtmlUrl(jSONObject.optString("html_url"));
            campaignEx.setEndScreenUrl(jSONObject.optString("end_screen_url"));
            campaignEx.setRoverMark(jSONObject.optString(ROVER_KEY_MARK));
            campaignEx.setRoverIsPost(jSONObject.optInt(ROVER_KEY_IS_POST));
            try {
                if (jSONObject.has(LOOPBACK)) {
                    String optString = jSONObject.optString(LOOPBACK);
                    if (!TextUtils.isEmpty(optString)) {
                        campaignEx.setLoopbackString(optString);
                        campaignEx.setLoopbackMap(loopbackStrToMap(optString));
                    }
                }
            } catch (Exception unused) {
                SameLogTool.m21733d("", "loopback parser error");
            }
            String optString2 = jSONObject.optString(KEY_GH_ID);
            if (!TextUtils.isEmpty(optString2)) {
                campaignEx.setGhId(optString2);
                String optString3 = jSONObject.optString(KEY_GH_PATH);
                if (!TextUtils.isEmpty(optString3)) {
                    campaignEx.setGhPath(SameBase64Tool.m21812b(optString3));
                }
                campaignEx.setBindId(jSONObject.optString(KEY_BIND_ID));
            }
            campaignEx.setApkAlt(jSONObject.optInt(JSON_KEY_APK_ALT, 0));
            campaignEx.setDisplayApkAlt(jSONObject.optInt(JSON_KEY_DISPLAY_APK_ALT, 0));
            campaignEx.setApkDisplayInfo(ApkDisplayInfo.parseByString(jSONObject.optString(JSON_KEY_APK_INFO)));
            campaignEx.setNtbarpasbl(jSONObject.optInt(JSON_KEY_NTBARPASBL, 0));
            campaignEx.setNtbarpt(jSONObject.optInt(JSON_KEY_NTBARPT, 0));
            campaignEx.setAtatType(jSONObject.optInt(JSON_KEY_ATAT_TYPE, 0));
            campaignEx.setAkdlui(jSONObject.optString(JSON_KEY_AKDLUI, ""));
            return campaignEx;
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            SameLogTool.m21733d(str, "parse campaign json exception: " + e.getLocalizedMessage());
            return campaignEx;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String replaceValueByKey(CampaignUnit campaignUnit, CampaignEx campaignEx, String str) {
        if (campaignUnit != null && !TextUtils.isEmpty(str) && campaignEx != null) {
            try {
                HashMap<String, String> rks = campaignUnit.getRks();
                if (rks != null) {
                    rks.entrySet().iterator();
                    for (Map.Entry<String, String> entry : rks.entrySet()) {
                        str = str.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
                    }
                }
                HashMap<String, String> aks = campaignEx.getAks();
                if (aks != null) {
                    aks.entrySet().iterator();
                    for (Map.Entry<String, String> entry2 : aks.entrySet()) {
                        str = str.replaceAll("\\{" + entry2.getKey() + "\\}", entry2.getValue());
                    }
                }
                HashMap<String, String> epMap = campaignUnit.getEpMap();
                if (epMap != null) {
                    for (Map.Entry<String, String> entry3 : epMap.entrySet()) {
                        str = str.replaceAll("\\{" + entry3.getKey() + "\\}", entry3.getValue());
                    }
                }
                str = str.replaceAll("\\{c\\}", URLEncoder.encode(campaignUnit.assembCParams(), "utf-8"));
                Matcher matcher = Pattern.compile("=\\{.*?\\}").matcher(str);
                while (matcher.find()) {
                    str = str.replace(matcher.group(0), "=");
                }
            } catch (Throwable th) {
                SameLogTool.m21735b(TAG, th.getMessage(), th);
            }
        }
        return str;
    }

    public static NativeVideoTracking trackingStr2Object(JSONObject jSONObject, NativeVideoTracking nativeVideoTracking) {
        if (jSONObject == null || nativeVideoTracking == null) {
            return null;
        }
        nativeVideoTracking.m22512c(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_APK_START)));
        nativeVideoTracking.m22510d(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_APK_END)));
        nativeVideoTracking.m22508e(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_APK_INSTALL)));
        return nativeVideoTracking;
    }

    public String getAdvId() {
        return this.advId;
    }

    public String getAkdlui() {
        return this.akdlui;
    }

    public int getApkAlt() {
        return this.apk_alt;
    }

    public int getAtatType() {
        return this.atatType;
    }

    public String getBindId() {
        return this.bindId;
    }

    public int getDisplayApkAlt() {
        return this.displayApkAlt;
    }

    public String getGhId() {
        return this.ghId;
    }

    public String getGhPath() {
        return this.ghPath;
    }

    public CommonJumpLoader.JumpLoaderResult getJumpResult() {
        return this.jumpResult;
    }

    public Map<String, String> getLoopbackMap() {
        return this.loopbackMap;
    }

    public String getLoopbackString() {
        return this.loopbackString;
    }

    public int getNtbarpasbl() {
        return this.ntbarpasbl;
    }

    public int getNtbarpt() {
        return this.ntbarpt;
    }

    public int getPreClickInterval() {
        return this.preClickInterval;
    }

    public int getRoverIsPost() {
        return this.roverIsPost;
    }

    public String getRoverMark() {
        return this.roverMark;
    }

    public int getTtc_ct2() {
        return this.ttc_ct2;
    }

    public int getTtc_type() {
        return this.ttc_type;
    }

    public boolean isPreClick() {
        return this.preClick;
    }

    public String matchLoopback(String str) {
        Map<String, String> loopbackMap;
        try {
            if (TextUtils.isEmpty(str) || (loopbackMap = getLoopbackMap()) == null || loopbackMap.size() <= 0) {
                return str;
            }
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            String str2 = loopbackMap.get(LOOPBACK_DOMAIN);
            if (TextUtils.isEmpty(host) || !host.contains(str2)) {
                return str;
            }
            String str3 = loopbackMap.get(LOOPBACK_KEY);
            String str4 = loopbackMap.get(LOOPBACK_VALUE);
            if (!str.contains(str3) && TextUtils.isEmpty(parse.getQueryParameter(str3)) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                return str + "&" + str3 + "=" + str4;
            } else if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return str;
            } else {
                return str.replace(str3 + "=" + (!TextUtils.isEmpty(parse.getQueryParameter(str3)) ? parse.getQueryParameter(str3) : ""), str3 + "=" + str4);
            }
        } catch (Throwable unused) {
            SameLogTool.m21733d("", "matchLoopback error");
            return str;
        }
    }

    public boolean needShowIDialog(CampaignEx campaignEx) {
        boolean z = true;
        z = (this.apk_alt == 1 && campaignEx.getLinkType() == 3 && campaignEx.getDisplayApkAlt() != 1) ? false : false;
        if (z) {
            try {
                return SameTool.m21992c(MBSDKContext.m22865f().m22861j(), getPackageName()) ? false : z;
            } catch (Throwable th) {
                SameLogTool.m21738a(TAG, th.getMessage());
                return z;
            }
        }
        return z;
    }

    public void setAdvId(String str) {
        this.advId = str;
    }

    public void setAkdlui(String str) {
        this.akdlui = str;
    }

    public void setApkAlt(int i) {
        this.apk_alt = i;
    }

    public void setAtatType(int i) {
        this.atatType = i;
    }

    public void setBindId(String str) {
        this.bindId = str;
    }

    public void setDisplayApkAlt(int i) {
        this.displayApkAlt = i;
    }

    public void setGhId(String str) {
        this.ghId = str;
    }

    public void setGhPath(String str) {
        this.ghPath = str;
    }

    public void setJumpResult(CommonJumpLoader.JumpLoaderResult jumpLoaderResult) {
        this.jumpResult = jumpLoaderResult;
    }

    public void setLoopbackMap(Map<String, String> map) {
        this.loopbackMap = map;
    }

    public void setLoopbackString(String str) {
        this.loopbackString = str;
    }

    public void setNtbarpasbl(int i) {
        this.ntbarpasbl = i;
    }

    public void setNtbarpt(int i) {
        this.ntbarpt = i;
    }

    public void setPreClick(boolean z) {
        this.preClick = z;
    }

    public void setPreClickInterval(int i) {
        this.preClickInterval = i;
    }

    public void setRoverIsPost(int i) {
        this.roverIsPost = i;
    }

    public void setRoverMark(String str) {
        this.roverMark = str;
    }

    public void setTtc_ct2(int i) {
        this.ttc_ct2 = i;
    }

    public void setTtc_type(int i) {
        this.ttc_type = i;
    }
}
