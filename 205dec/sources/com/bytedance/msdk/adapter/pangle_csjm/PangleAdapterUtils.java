package com.bytedance.msdk.adapter.pangle_csjm;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.api.sr.gd;
import com.bytedance.msdk.c.sr;
import com.bytedance.sdk.openadsdk.mediation.c.w.c;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleAdapterUtils {
    public static final double CPM_DEFLAUT_VALUE = 0.0d;
    public static final String KEY_PANGLE_PREVIEW_AD_ID = "tt_pangle_preview_ad_id";
    public static final String KEY_PANGLE_PREVIEW_CREATIVE_ID = "tt_pangle_preview_creative_id";
    public static final String KEY_PANGLE_PREVIEW_EXT = "tt_pangle_preview_ext";
    public static final String MEDIA_EXTRA_COUPON = "coupon";
    public static final String MEDIA_EXTRA_LIVE_ROOM = "live_room";
    public static final String MEDIA_EXTRA_PRODUCT = "product";
    public static final String VERSION_00 = "0.0";
    public static final String VERSION_5100 = "5.1.0.0";
    public static final String VERSION_5403 = "5.4.0.3";

    public static w.c buildPangleAdSlot(com.bytedance.msdk.api.c.w wVar, String str, String str2, String str3, String str4, boolean z3) {
        w.c xv = new w.c().sr(str).xv(1);
        c cVar = null;
        r0 = null;
        int[] iArr = null;
        if (wVar != null) {
            c s3 = wVar.s();
            Map<String, Object> yu = wVar.yu();
            if (yu != null) {
                try {
                    iArr = (int[]) yu.get("pangle_vid");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            xv.f(wVar.w()).r(wVar.u()).w(wVar.n());
            if (iArr != null && iArr.length > 0) {
                xv.c(iArr);
            }
            if (5 == wVar.fz() || 9 == wVar.fz()) {
                xv.xv(wVar.ls());
            }
            cVar = s3;
        }
        if (!TextUtils.isEmpty(str4)) {
            xv.ev(str4);
        }
        c(xv, str2, str3, z3, cVar);
        return xv;
    }

    private static Map<String, String> c() {
        return gd.ev();
    }

    public static boolean currentSdkVerGreaterThanOrEqual(String str) {
        String w3 = w();
        return (TextUtils.isEmpty(w3) || TextUtils.isEmpty(str) || w3.compareTo(str) < 0) ? false : true;
    }

    public static int dp2px(@NonNull Context context, int i4) {
        return (int) TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
    }

    public static long getAdId(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.get("ad_id") != null) {
                    return ((Long) map.get("ad_id")).longValue();
                }
                return 0L;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static long getCreativeId(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.get(CampaignEx.JSON_KEY_CREATIVE_ID) != null) {
                    return ((Long) map.get(CampaignEx.JSON_KEY_CREATIVE_ID)).longValue();
                }
                return 0L;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static String getPangleData() {
        return gd.r();
    }

    public static JSONArray getPangleDataAndExtraData(c cVar) {
        JSONArray c4 = c(getPangleData());
        try {
            Map<String, String> c5 = c();
            if (c5 != null && c5.size() > 0) {
                for (String str : c5.keySet()) {
                    String str2 = c5.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str);
                        jSONObject.putOpt("value", str2);
                        c4.put(jSONObject);
                    }
                }
            }
            JSONArray c6 = c(cVar);
            if (c6 != null) {
                for (int i4 = 0; i4 < c6.length(); i4++) {
                    JSONObject optJSONObject = c6.optJSONObject(i4);
                    if (optJSONObject != null && !TextUtils.equals("personal_ads_type", optJSONObject.optString("name"))) {
                        c4.put(optJSONObject);
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return c4;
    }

    public static String getReqId(Map<String, Object> map) {
        if (map == null || map.get(ConstantAd.KEY_CACHE_AD) == null) {
            return null;
        }
        return (String) map.get(ConstantAd.KEY_CACHE_AD);
    }

    public static double getValue(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        try {
            if (obj instanceof String) {
                return Double.valueOf((String) obj).doubleValue();
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static boolean isExpressNativeAutoHeight(com.bytedance.msdk.api.c.w wVar) {
        if (wVar != null && wVar.yu() != null) {
            Object obj = wVar.yu().get("banner_native_exp_auto_height");
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void setPangleData(String str) {
        gd.w(str);
    }

    public static void setPanglePreviewParam(w.c cVar) {
        if (cVar != null && gd.gd()) {
            try {
                String xv = gd.xv(KEY_PANGLE_PREVIEW_AD_ID);
                String xv2 = gd.xv(KEY_PANGLE_PREVIEW_CREATIVE_ID);
                String xv3 = gd.xv(KEY_PANGLE_PREVIEW_EXT);
                xv.c("TTMediationSDK", "pangle preview adId:" + xv + " creativeId:" + xv2 + " ext" + xv3);
                if (!TextUtils.isEmpty(xv) && !TextUtils.isEmpty(xv2)) {
                    cVar.c(xv).w(xv2);
                }
                if (TextUtils.isEmpty(xv3)) {
                    return;
                }
                cVar.xv(xv3);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String updateJsonArrayStr(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                boolean z3 = false;
                int i4 = 0;
                while (true) {
                    if (i4 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                        if (optJSONObject != null && str2.equals(optJSONObject.getString("name"))) {
                            optJSONObject.put("value", str3);
                            z3 = true;
                            break;
                        }
                        i4++;
                    } else {
                        break;
                    }
                }
                if (!z3) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", str2);
                    jSONObject.put("value", str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return str;
    }

    private static String w() {
        try {
            return com.bytedance.sdk.gromore.init.c.xv();
        } catch (Throwable unused) {
            return "0.0";
        }
    }

    private static JSONArray c(c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.ls())) {
            return null;
        }
        try {
            return new JSONArray(cVar.ls());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static void c(w.c cVar, String str, String str2, boolean z3, c cVar2) {
        JSONArray pangleDataAndExtraData = getPangleDataAndExtraData(cVar2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", "mediation_sdk_version");
            jSONObject.putOpt("value", sr.w());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_req_type");
            jSONObject2.putOpt("value", "1");
            JSONObject jSONObject3 = null;
            if (!TextUtils.isEmpty(str)) {
                jSONObject3 = new JSONObject();
                jSONObject3.putOpt("name", "waterfall_abtest");
                jSONObject3.putOpt("value", str);
            }
            pangleDataAndExtraData.put(jSONObject2);
            pangleDataAndExtraData.put(jSONObject);
            if (jSONObject3 != null) {
                pangleDataAndExtraData.put(jSONObject3);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "m_req_id");
                jSONObject4.putOpt("value", str2);
                pangleDataAndExtraData.put(jSONObject4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z3) {
            setPanglePreviewParam(cVar);
        }
        com.bytedance.sdk.gromore.init.c.c(gd.f());
        if (cVar != null) {
            cVar.gd(pangleDataAndExtraData.toString());
        }
    }

    static JSONArray c(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }
}
