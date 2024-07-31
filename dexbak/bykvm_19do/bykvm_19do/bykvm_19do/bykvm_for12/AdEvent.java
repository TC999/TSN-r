package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.DeviceUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.NetworkUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ToolUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEvent implements EventFace {

    /* renamed from: a */
    public final String f560a;

    /* renamed from: b */
    public final JSONObject f561b;

    public AdEvent(String str, JSONObject jSONObject) {
        this.f560a = str;
        this.f561b = jSONObject;
    }

    /* renamed from: a */
    public static AdEvent m59442a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!TextUtils.isEmpty(str) && str2 != null) {
                return (!jSONObject.has("params") || jSONObject.has("tag")) ? new AdEvent(str, jSONObject) : new AdEventV3(str, jSONObject);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static JSONObject m59443a(Context context, AdEventModel adEventModel, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (adEventModel != null) {
            try {
                jSONObject2.putOpt("type", adEventModel.f576a);
                jSONObject2.putOpt("link_id", adEventModel.f577b);
                jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, adEventModel.f578c);
                jSONObject2.putOpt("ad_sdk_version", adEventModel.f579d);
                jSONObject2.putOpt("rit_cpm", adEventModel.f582g);
                jSONObject2.putOpt("mediation_rit", adEventModel.f581f);
                jSONObject2.putOpt("adtype", Integer.valueOf(adEventModel.f592q));
                jSONObject2.putOpt("error_msg", adEventModel.f586k);
                jSONObject2.putOpt("error_code", Integer.valueOf(adEventModel.f589n));
                jSONObject2.putOpt(CampaignEx.JSON_KEY_CREATIVE_ID, adEventModel.f587l);
                jSONObject2.putOpt("exchange_rate", adEventModel.f596u);
                jSONObject2.putOpt("event_id", UUID.randomUUID().toString());
                if (InternalContainer.m59943f().m59745e() != null) {
                    jSONObject2.putOpt("app_abtest", InternalContainer.m59943f().m59745e());
                }
                int i = adEventModel.f594s;
                if (i != -1) {
                    jSONObject2.putOpt(CommonNetImpl.RESULT, Integer.valueOf(i));
                }
                int i2 = adEventModel.f595t;
                if (i2 != -1) {
                    jSONObject2.putOpt("status_code", Integer.valueOf(i2));
                }
                String str = adEventModel.f591p;
                if (str != null) {
                    jSONObject2.putOpt("show_sort", str);
                }
                String str2 = adEventModel.f590o;
                if (str2 != null) {
                    jSONObject2.putOpt("load_sort", str2);
                }
                String str3 = adEventModel.f588m;
                if (str3 != null) {
                    jSONObject2.putOpt("req_bidding_type", str3);
                }
                jSONObject2.putOpt(MediationConstant.KEY_GM_PRIME_RIT, adEventModel.f583h);
                if ("media_fill_fail".equals(adEventModel.f576a) || "media_fill".equals(adEventModel.f576a) || "mediation_fill".equals(adEventModel.f576a) || "mediation_request_end".equals(adEventModel.f576a) || "mediation_video_cached".equals(adEventModel.f576a) || "get_config_final".equals(adEventModel.f576a) || "sdk_init_end".equals(adEventModel.f576a) || "return_bidding_result".equals(adEventModel.f576a)) {
                    jSONObject2.putOpt("duration", Long.valueOf(adEventModel.f593r));
                }
                if (!"total_load_fail".equalsIgnoreCase(adEventModel.f576a) && !"adapter_request_fail".equalsIgnoreCase(adEventModel.f576a)) {
                    jSONObject2.putOpt("req_id", TextUtils.isEmpty(adEventModel.f580e) ? adEventModel.f577b + "_" + adEventModel.f581f : adEventModel.f580e);
                }
                jSONObject2.putOpt("country", InternalContainer.m59943f().m59740g());
                jSONObject2.putOpt("app_id", InternalContainer.m59943f().m59763a("pangle") != null ? InternalContainer.m59943f().m59763a("pangle").m59573a() : SdkGlobalInfo.m59939B().m59921c());
                long j = adEventModel.f584i;
                if (j != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(j));
                }
                if (!TextUtils.isEmpty(adEventModel.f585j)) {
                    jSONObject2.putOpt(ConstantHelper.LOG_VS, adEventModel.f585j);
                }
                Map<String, Object> map = adEventModel.f597v;
                if (map != null && map.size() > 0) {
                    for (String str4 : adEventModel.f597v.keySet()) {
                        Object obj = adEventModel.f597v.get(str4);
                        if (!TextUtils.isEmpty(str4) && obj != null) {
                            jSONObject2.putOpt(str4, obj);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        jSONObject2.putOpt("event_extra", jSONObject != null ? jSONObject.toString() : null);
        jSONObject2.putOpt("app_version", ToolUtils.m59252e());
        jSONObject2.putOpt("conn_type", Integer.valueOf(NetworkUtils.m59168c(context)));
        jSONObject2.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        jSONObject2.putOpt("mediation_sdk_version", "2.9.2.1");
        if (adEventModel != null && "get_config_start".equals(adEventModel.f576a)) {
            jSONObject2.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() - 3000));
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static AdEvent m59441b(Context context, AdEventModel adEventModel, JSONObject jSONObject) {
        return new AdEvent(UUID.randomUUID().toString(), m59440c(context, adEventModel, jSONObject));
    }

    /* renamed from: c */
    protected static JSONObject m59440c(Context context, AdEventModel adEventModel, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2 = m59443a(context, adEventModel, jSONObject);
            jSONObject2.putOpt("device_info", DeviceUtils.m59217b(context));
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.EventFace
    /* renamed from: a */
    public String mo59295a() {
        return this.f560a;
    }

    public String toString() {
        return "AdEvent{localId='" + this.f560a + "', event=" + this.f561b + '}';
    }
}
