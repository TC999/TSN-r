package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b0;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.n;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: AdEvent.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public final String f553a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f554b;

    public a(String str, JSONObject jSONObject) {
        this.f553a = str;
        this.f554b = jSONObject;
    }

    public static a a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!TextUtils.isEmpty(str) && str2 != null) {
                return (!jSONObject.has(EventMonitor.V3_PARAMS) || jSONObject.has("tag")) ? new a(str, jSONObject) : new h(str, jSONObject);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONObject a(Context context, d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (dVar != null) {
            try {
                jSONObject2.putOpt("type", dVar.f569a);
                jSONObject2.putOpt("link_id", dVar.f570b);
                jSONObject2.putOpt("adn_name", dVar.f571c);
                jSONObject2.putOpt("ad_sdk_version", dVar.f572d);
                jSONObject2.putOpt("rit_cpm", dVar.f575g);
                jSONObject2.putOpt("mediation_rit", dVar.f574f);
                jSONObject2.putOpt("adtype", Integer.valueOf(dVar.f585q));
                jSONObject2.putOpt("error_msg", dVar.f579k);
                jSONObject2.putOpt("error_code", Integer.valueOf(dVar.f582n));
                jSONObject2.putOpt(CampaignEx.JSON_KEY_CREATIVE_ID, dVar.f580l);
                jSONObject2.putOpt("exchange_rate", dVar.f589u);
                jSONObject2.putOpt("event_id", UUID.randomUUID().toString());
                if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().e() != null) {
                    jSONObject2.putOpt("app_abtest", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().e());
                }
                int i4 = dVar.f587s;
                if (i4 != -1) {
                    jSONObject2.putOpt("result", Integer.valueOf(i4));
                }
                int i5 = dVar.f588t;
                if (i5 != -1) {
                    jSONObject2.putOpt("status_code", Integer.valueOf(i5));
                }
                String str = dVar.f584p;
                if (str != null) {
                    jSONObject2.putOpt("show_sort", str);
                }
                String str2 = dVar.f583o;
                if (str2 != null) {
                    jSONObject2.putOpt("load_sort", str2);
                }
                String str3 = dVar.f581m;
                if (str3 != null) {
                    jSONObject2.putOpt("req_bidding_type", str3);
                }
                jSONObject2.putOpt("prime_rit", dVar.f576h);
                if ("media_fill_fail".equals(dVar.f569a) || "media_fill".equals(dVar.f569a) || "mediation_fill".equals(dVar.f569a) || "mediation_request_end".equals(dVar.f569a) || "mediation_video_cached".equals(dVar.f569a) || "get_config_final".equals(dVar.f569a) || "sdk_init_end".equals(dVar.f569a) || "return_bidding_result".equals(dVar.f569a)) {
                    jSONObject2.putOpt("duration", Long.valueOf(dVar.f586r));
                }
                if (!"total_load_fail".equalsIgnoreCase(dVar.f569a) && !"adapter_request_fail".equalsIgnoreCase(dVar.f569a)) {
                    jSONObject2.putOpt("req_id", TextUtils.isEmpty(dVar.f573e) ? dVar.f570b + "_" + dVar.f574f : dVar.f573e);
                }
                jSONObject2.putOpt("country", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().g());
                jSONObject2.putOpt("app_id", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("pangle") != null ? bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("pangle").a() : bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c());
                long j4 = dVar.f577i;
                if (j4 != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(j4));
                }
                if (!TextUtils.isEmpty(dVar.f578j)) {
                    jSONObject2.putOpt("version", dVar.f578j);
                }
                Map<String, Object> map = dVar.f590v;
                if (map != null && map.size() > 0) {
                    for (String str4 : dVar.f590v.keySet()) {
                        Object obj = dVar.f590v.get(str4);
                        if (!TextUtils.isEmpty(str4) && obj != null) {
                            jSONObject2.putOpt(str4, obj);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        jSONObject2.putOpt(EventMonitor.EVENT_EXTRA, jSONObject != null ? jSONObject.toString() : null);
        jSONObject2.putOpt("app_version", b0.e());
        jSONObject2.putOpt("conn_type", Integer.valueOf(n.c(context)));
        jSONObject2.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        jSONObject2.putOpt("mediation_sdk_version", "2.9.2.1");
        if (dVar != null && "get_config_start".equals(dVar.f569a)) {
            jSONObject2.putOpt(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() - 3000));
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static a b(Context context, d dVar, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), c(context, dVar, jSONObject));
    }

    protected static JSONObject c(Context context, d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2 = a(context, dVar, jSONObject);
            jSONObject2.putOpt("device_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.b(context));
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.i
    public String a() {
        return this.f553a;
    }

    public String toString() {
        return "AdEvent{localId='" + this.f553a + "', event=" + this.f554b + '}';
    }
}
