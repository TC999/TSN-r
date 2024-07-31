package com.mbridge.msdk.splash.p501a.p502a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignClickDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.tools.SameTool;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.splash.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SplashUtils {

    /* renamed from: a */
    private static final String f31713a = "a";

    /* renamed from: a */
    public static String m21295a(Context context, String str) {
        if (context != null) {
            try {
                CommonSDKDBHelper m22721a = CommonSDKDBHelper.m22721a(context);
                if (m22721a != null) {
                    CampaignClickDao m22799a = CampaignClickDao.m22799a(m22721a);
                    m22799a.m22800a();
                    return m22799a.m22797a(str);
                }
                return "";
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    /* renamed from: a */
    public static String m21297a() {
        try {
            JSONArray jSONArray = new JSONArray();
            List<Long> m22862i = MBSDKContext.m22865f().m22862i();
            if (m22862i != null && m22862i.size() > 0) {
                for (Long l : m22862i) {
                    jSONArray.put(l.longValue());
                }
            }
            return jSONArray.length() > 0 ? SameTool.m22007a(jSONArray) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static CampaignEx m21294a(String str, CampaignEx campaignEx) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (!str.contains("notice")) {
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                if (parseCampaignWithBackData == null) {
                    parseCampaignWithBackData = campaignEx;
                }
                if (!TextUtils.isEmpty(str)) {
                    String optString = campaignToJsonObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                    if (!TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                    }
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject(CommonConst.f30592o);
                    if (optJSONObject != null) {
                        String string = optJSONObject.getString(CommonConst.f30590m);
                        String string2 = optJSONObject.getString(CommonConst.f30591n);
                        if (TextUtils.isEmpty(string)) {
                            string = "-999";
                        }
                        int parseInt = Integer.parseInt(string);
                        if (TextUtils.isEmpty(string2)) {
                            string2 = "-999";
                        }
                        int parseInt2 = Integer.parseInt(string2);
                        str2 = parseInt != -999 ? String.valueOf(SameTool.m22001b(MBSDKContext.m22865f().m22861j(), parseInt)) : "-999";
                        str3 = parseInt2 != -999 ? String.valueOf(SameTool.m22001b(MBSDKContext.m22865f().m22861j(), parseInt2)) : "-999";
                    } else {
                        str2 = "-999";
                        str3 = str2;
                    }
                    parseCampaignWithBackData.setClickURL(CommonClickUtil.m23071a(parseCampaignWithBackData.getClickURL(), str2, str3));
                    String noticeUrl = parseCampaignWithBackData.getNoticeUrl();
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        StringBuilder sb = new StringBuilder();
                        while (keys.hasNext()) {
                            sb.append("&");
                            String next = keys.next();
                            String optString2 = optJSONObject.optString(next);
                            if (CommonConst.f30590m.equals(next) || CommonConst.f30591n.equals(next)) {
                                if (TextUtils.isEmpty(optString2)) {
                                    optString2 = "-999";
                                }
                                int parseInt3 = Integer.parseInt(optString2);
                                optString2 = parseInt3 != -999 ? String.valueOf(SameTool.m22001b(MBSDKContext.m22865f().m22861j(), parseInt3)) : "-999";
                            }
                            sb.append(next);
                            sb.append("=");
                            sb.append(optString2);
                        }
                        parseCampaignWithBackData.setNoticeUrl(noticeUrl + ((Object) sb));
                    }
                }
                return parseCampaignWithBackData;
            } catch (Throwable unused) {
                return campaignEx;
            }
        }
        try {
            JSONObject campaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                    campaignToJsonObject2.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                }
            } catch (Exception unused2) {
            }
            Iterator<String> keys2 = jSONObject.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                campaignToJsonObject2.put(next2, jSONObject.getString(next2));
            }
            CampaignEx parseCampaignWithBackData2 = CampaignEx.parseCampaignWithBackData(campaignToJsonObject2);
            String optString3 = campaignToJsonObject2.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (!TextUtils.isEmpty(optString3)) {
                parseCampaignWithBackData2.setCampaignUnitId(optString3);
            }
            return parseCampaignWithBackData2;
        } catch (JSONException e) {
            e.printStackTrace();
            return campaignEx;
        }
    }

    /* renamed from: a */
    public static String m21296a(int i, float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (i == 4) {
                jSONObject2.put(CommonConst.f30590m, -999);
                jSONObject2.put(CommonConst.f30591n, -999);
            } else {
                jSONObject2.put(CommonConst.f30590m, SameTool.m22021a(MBSDKContext.m22865f().m22861j(), f));
                jSONObject2.put(CommonConst.f30591n, SameTool.m22021a(MBSDKContext.m22865f().m22861j(), f2));
            }
            jSONObject2.put(CommonConst.f30593p, i);
            jSONObject2.put(CommonConst.f30594q, MBSDKContext.m22865f().m22861j().getResources().getConfiguration().orientation);
            jSONObject2.put(CommonConst.f30595r, SameTool.m21988d(MBSDKContext.m22865f().m22861j()));
            jSONObject.put(CommonConst.f30592o, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
