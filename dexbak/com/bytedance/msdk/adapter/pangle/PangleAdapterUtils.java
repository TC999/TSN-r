package com.bytedance.msdk.adapter.pangle;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PangleAdapterUtils {
    public static final double CPM_DEFLAUT_VALUE = 0.0d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.adapter.pangle.PangleAdapterUtils$1 */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static /* synthetic */ class C59911 {

        /* renamed from: a */
        static final /* synthetic */ int[] f21422a;

        static {
            int[] iArr = new int[TTAdConstant.GroMoreRitScenes.values().length];
            f21422a = iArr;
            try {
                iArr[TTAdConstant.GroMoreRitScenes.CUSTOMIZE_SCENES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.HOME_OPEN_BONUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.HOME_SVIP_BONUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.HOME_GET_PROPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.HOME_TRY_PROPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.HOME_GET_BONUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.HOME_GIFT_BONUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.GAME_START_BONUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.GAME_REDUCE_WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.GAME_MORE_KLLKRTUNITIES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.GAME_FINISH_REWARDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f21422a[TTAdConstant.GroMoreRitScenes.GAME_GIFT_BONUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* renamed from: a */
    private static TTAdConstant.RitScenes m37729a(TTAdConstant.GroMoreRitScenes groMoreRitScenes) {
        if (groMoreRitScenes == null) {
            return null;
        }
        switch (C59911.f21422a[groMoreRitScenes.ordinal()]) {
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

    /* renamed from: b */
    static JSONArray m37728b(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static AdError buildAdError(int i, String str) {
        return new AdError(i, str, i, str);
    }

    public static long getAdId(Map<String, Object> map) {
        if (map == null || map.get(MediationConstant.EXTRA_ADID) == null) {
            return 0L;
        }
        return ((Long) map.get(MediationConstant.EXTRA_ADID)).longValue();
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
        if (map == null || map.get("request_id") == null) {
            return null;
        }
        return (String) map.get("request_id");
    }

    public static TTAdConstant.RitScenes getRitScenes(Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get(TTAdConstant.GroMoreExtraKey.RIT_SCENES);
        if (obj instanceof TTAdConstant.GroMoreRitScenes) {
            return m37729a((TTAdConstant.GroMoreRitScenes) obj);
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
        return obj instanceof Float ? ((Double) obj).doubleValue() : Utils.DOUBLE_EPSILON;
    }

    public static void setPanglePreviewParam(AdSlot.Builder builder) {
        if (builder != null && SdkGlobalInfo.m59939B().m59940A()) {
            try {
                SPUtils m59131a = SPUtils.m59131a("tt_mediation_ppe_info", InternalContainer.m59945d());
                String m59120d = m59131a.m59120d("tt_pangle_preview_ad_id");
                String m59120d2 = m59131a.m59120d("tt_pangle_preview_creative_id");
                String m59120d3 = m59131a.m59120d("tt_pangle_preview_ext");
                if (TextUtils.isEmpty(m59120d) || TextUtils.isEmpty(m59120d2) || TextUtils.isEmpty(m59120d3)) {
                    return;
                }
                builder.setAdId(m59120d).setCreativeId(m59120d2).setExt(m59120d3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void updateData(AdSlot.Builder builder, String str, String str2, boolean z) {
        String m37571k = TTPangleSDKInitManager.m37571k();
        Map<String, String> m37572j = TTPangleSDKInitManager.m37572j();
        try {
            JSONArray m37728b = m37728b(m37571k);
            if (m37572j != null && m37572j.size() > 0) {
                for (String str3 : m37572j.keySet()) {
                    String str4 = m37572j.get(str3);
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str3);
                        jSONObject.putOpt(DomainCampaignEx.LOOPBACK_VALUE, str4);
                        m37728b.put(jSONObject);
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_sdk_version");
            jSONObject2.putOpt(DomainCampaignEx.LOOPBACK_VALUE, "2.9.2.1");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("name", "mediation_req_type");
            jSONObject3.putOpt(DomainCampaignEx.LOOPBACK_VALUE, "1");
            JSONObject jSONObject4 = null;
            if (!TextUtils.isEmpty(str)) {
                jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "waterfall_abtest");
                jSONObject4.putOpt(DomainCampaignEx.LOOPBACK_VALUE, str);
            }
            m37728b.put(jSONObject3);
            m37728b.put(jSONObject2);
            if (jSONObject4 != null) {
                m37728b.put(jSONObject4);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt("name", "m_req_id");
                jSONObject5.putOpt(DomainCampaignEx.LOOPBACK_VALUE, str2);
                m37728b.put(jSONObject5);
            }
            m37571k = m37728b.toString();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z) {
            setPanglePreviewParam(builder);
        }
        TTPangleSDKInitManager.m37576f(builder, m37571k);
    }
}
