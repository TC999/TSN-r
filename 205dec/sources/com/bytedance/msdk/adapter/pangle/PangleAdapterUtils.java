package com.bytedance.msdk.adapter.pangle;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PangleAdapterUtils {
    public static final double CPM_DEFLAUT_VALUE = 0.0d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.adapter.pangle.PangleAdapterUtils$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27032a;

        static {
            int[] iArr = new int[TTAdConstant.GroMoreRitScenes.values().length];
            f27032a = iArr;
            try {
                iArr[TTAdConstant.GroMoreRitScenes.CUSTOMIZE_SCENES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.HOME_OPEN_BONUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.HOME_SVIP_BONUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.HOME_GET_PROPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.HOME_TRY_PROPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.HOME_GET_BONUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.HOME_GIFT_BONUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.GAME_START_BONUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.GAME_REDUCE_WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.GAME_MORE_KLLKRTUNITIES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.GAME_FINISH_REWARDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f27032a[TTAdConstant.GroMoreRitScenes.GAME_GIFT_BONUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static TTAdConstant.RitScenes a(TTAdConstant.GroMoreRitScenes groMoreRitScenes) {
        if (groMoreRitScenes == null) {
            return null;
        }
        switch (AnonymousClass1.f27032a[groMoreRitScenes.ordinal()]) {
            case 1:
                return TTAdConstant.RitScenes.CUSTOMIZE_SCENES;
            case 2:
                return TTAdConstant.RitScenes.HOME_OPEN_BONUS;
            case 3:
                return TTAdConstant.RitScenes.HOME_SVIP_BONUS;
            case 4:
                return TTAdConstant.RitScenes.HOME_GET_PROPS;
            case 5:
                return TTAdConstant.RitScenes.HOME_TRY_PROPS;
            case 6:
                return TTAdConstant.RitScenes.HOME_GET_BONUS;
            case 7:
                return TTAdConstant.RitScenes.HOME_GIFT_BONUS;
            case 8:
                return TTAdConstant.RitScenes.GAME_START_BONUS;
            case 9:
                return TTAdConstant.RitScenes.GAME_REDUCE_WAITING;
            case 10:
                return TTAdConstant.RitScenes.GAME_MORE_KLLKRTUNITIES;
            case 11:
                return TTAdConstant.RitScenes.GAME_FINISH_REWARDS;
            case 12:
                return TTAdConstant.RitScenes.GAME_GIFT_BONUS;
            default:
                return null;
        }
    }

    static JSONArray b(String str) {
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

    public static AdError buildAdError(int i4, String str) {
        return new AdError(i4, str, i4, str);
    }

    public static long getAdId(Map<String, Object> map) {
        if (map == null || map.get("ad_id") == null) {
            return 0L;
        }
        return ((Long) map.get("ad_id")).longValue();
    }

    public static long getCreativeId(Map<String, Object> map) {
        if (map == null || map.get(CampaignEx.JSON_KEY_CREATIVE_ID) == null) {
            return 0L;
        }
        return ((Long) map.get(CampaignEx.JSON_KEY_CREATIVE_ID)).longValue();
    }

    public static String getCustomRitScenes(Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(TTAdConstant.GroMoreExtraKey.CUSTOMIZE_RIT_SCENES);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static String getReqId(Map<String, Object> map) {
        if (map == null || map.get(ConstantAd.KEY_CACHE_AD) == null) {
            return null;
        }
        return (String) map.get(ConstantAd.KEY_CACHE_AD);
    }

    public static TTAdConstant.RitScenes getRitScenes(Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(TTAdConstant.GroMoreExtraKey.RIT_SCENES);
        if (obj instanceof TTAdConstant.GroMoreRitScenes) {
            return a((TTAdConstant.GroMoreRitScenes) obj);
        }
        return null;
    }

    public static double getValue(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            return Double.valueOf((String) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }

    public static void setPanglePreviewParam(AdSlot.Builder builder) {
        if (builder != null && b.B().A()) {
            try {
                r a4 = r.a("tt_mediation_ppe_info", a.d());
                String d4 = a4.d(com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils.KEY_PANGLE_PREVIEW_AD_ID);
                String d5 = a4.d(com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils.KEY_PANGLE_PREVIEW_CREATIVE_ID);
                String d6 = a4.d(com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils.KEY_PANGLE_PREVIEW_EXT);
                if (TextUtils.isEmpty(d4) || TextUtils.isEmpty(d5) || TextUtils.isEmpty(d6)) {
                    return;
                }
                builder.setAdId(d4).setCreativeId(d5).setExt(d6);
            } catch (Throwable unused) {
            }
        }
    }

    public static void updateData(AdSlot.Builder builder, String str, String str2, boolean z3) {
        String k4 = TTPangleSDKInitManager.k();
        Map<String, String> j4 = TTPangleSDKInitManager.j();
        try {
            JSONArray b4 = b(k4);
            if (j4 != null && j4.size() > 0) {
                for (String str3 : j4.keySet()) {
                    String str4 = j4.get(str3);
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str3);
                        jSONObject.putOpt("value", str4);
                        b4.put(jSONObject);
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_sdk_version");
            jSONObject2.putOpt("value", "2.9.2.1");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("name", "mediation_req_type");
            jSONObject3.putOpt("value", "1");
            JSONObject jSONObject4 = null;
            if (!TextUtils.isEmpty(str)) {
                jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "waterfall_abtest");
                jSONObject4.putOpt("value", str);
            }
            b4.put(jSONObject3);
            b4.put(jSONObject2);
            if (jSONObject4 != null) {
                b4.put(jSONObject4);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt("name", "m_req_id");
                jSONObject5.putOpt("value", str2);
                b4.put(jSONObject5);
            }
            k4 = b4.toString();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z3) {
            setPanglePreviewParam(builder);
        }
        TTPangleSDKInitManager.f(builder, k4);
    }
}
