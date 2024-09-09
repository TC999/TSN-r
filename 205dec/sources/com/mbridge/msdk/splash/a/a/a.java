package com.mbridge.msdk.splash.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.c;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SplashUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40485a = "a";

    public static String a(Context context, String str) {
        if (context != null) {
            try {
                i a4 = i.a(context);
                if (a4 != null) {
                    c a5 = c.a(a4);
                    a5.a();
                    return a5.a(str);
                }
                return "";
            } catch (Exception e4) {
                e4.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String a() {
        try {
            JSONArray jSONArray = new JSONArray();
            List<Long> i4 = com.mbridge.msdk.foundation.controller.a.f().i();
            if (i4 != null && i4.size() > 0) {
                for (Long l4 : i4) {
                    jSONArray.put(l4.longValue());
                }
            }
            return jSONArray.length() > 0 ? ac.a(jSONArray) : "";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static CampaignEx a(String str, CampaignEx campaignEx) {
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
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.f39387o);
                    if (optJSONObject != null) {
                        String string = optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f39385m);
                        String string2 = optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f39386n);
                        if (TextUtils.isEmpty(string)) {
                            string = "-999";
                        }
                        int parseInt = Integer.parseInt(string);
                        if (TextUtils.isEmpty(string2)) {
                            string2 = "-999";
                        }
                        int parseInt2 = Integer.parseInt(string2);
                        str2 = parseInt != -999 ? String.valueOf(ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), parseInt)) : "-999";
                        str3 = parseInt2 != -999 ? String.valueOf(ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), parseInt2)) : "-999";
                    } else {
                        str2 = "-999";
                        str3 = str2;
                    }
                    parseCampaignWithBackData.setClickURL(com.mbridge.msdk.click.c.a(parseCampaignWithBackData.getClickURL(), str2, str3));
                    String noticeUrl = parseCampaignWithBackData.getNoticeUrl();
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        StringBuilder sb = new StringBuilder();
                        while (keys.hasNext()) {
                            sb.append("&");
                            String next = keys.next();
                            String optString2 = optJSONObject.optString(next);
                            if (com.mbridge.msdk.foundation.same.a.f39385m.equals(next) || com.mbridge.msdk.foundation.same.a.f39386n.equals(next)) {
                                if (TextUtils.isEmpty(optString2)) {
                                    optString2 = "-999";
                                }
                                int parseInt3 = Integer.parseInt(optString2);
                                optString2 = parseInt3 != -999 ? String.valueOf(ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), parseInt3)) : "-999";
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
        } catch (JSONException e4) {
            e4.printStackTrace();
            return campaignEx;
        }
    }

    public static String a(int i4, float f4, float f5) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (i4 == 4) {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39385m, -999);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39386n, -999);
            } else {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39385m, ac.a(com.mbridge.msdk.foundation.controller.a.f().j(), f4));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39386n, ac.a(com.mbridge.msdk.foundation.controller.a.f().j(), f5));
            }
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39388p, i4);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39389q, com.mbridge.msdk.foundation.controller.a.f().j().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39390r, ac.d(com.mbridge.msdk.foundation.controller.a.f().j()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f39387o, jSONObject2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }
}
