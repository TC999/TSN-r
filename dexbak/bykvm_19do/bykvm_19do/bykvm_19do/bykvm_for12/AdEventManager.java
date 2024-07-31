package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEventManager {
    /* renamed from: a */
    public static void m59381a(Context context, AdEventModel adEventModel, Map<String, Object> map) {
        if (InternalContainer.m59943f().m59733n()) {
            if (context == null) {
                context = InternalContainer.m59945d();
            }
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            int m59737j = InternalContainer.m59943f().m59737j();
            if (m59737j == 0 || m59737j == 2) {
                InternalContainer.m59946c().m59438a(AdEventV3.m59297b(context, adEventModel, jSONObject));
            }
            if (m59737j == 0 || m59737j == 1) {
                InternalContainer.m59950a().m59438a(AdEvent.m59441b(context, adEventModel, jSONObject));
            }
        }
    }
}
