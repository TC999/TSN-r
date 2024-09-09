package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {
    public static void a(Context context, d dVar, Map<String, Object> map) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().n()) {
            if (context == null) {
                context = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d();
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
            int j4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().j();
            if (j4 == 0 || j4 == 2) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.c().a(h.b(context, dVar, jSONObject));
            }
            if (j4 == 0 || j4 == 1) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.a().a(a.b(context, dVar, jSONObject));
            }
        }
    }
}
