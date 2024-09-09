package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineInitHandlerAbstract.java */
/* renamed from: com.amap.api.col.3l.e0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e0 extends a1<String, c0> {
    public e0(Context context, String str) {
        super(context, str);
    }

    private static c0 h(JSONObject jSONObject) throws AMapException {
        c0 c0Var = new c0();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                c0Var.b(false);
            } else if (optString.equals("1")) {
                c0Var.b(true);
            }
            c0Var.a(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            u5.p(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return c0Var;
    }

    @Override // com.amap.api.col.p0003l.a1
    protected final /* synthetic */ c0 a(JSONObject jSONObject) throws AMapException {
        return h(jSONObject);
    }

    @Override // com.amap.api.col.p0003l.a1
    protected final String b() {
        return "016";
    }

    @Override // com.amap.api.col.p0003l.a1
    protected final JSONObject c(g4.c cVar) {
        JSONObject jSONObject;
        if (cVar == null || (jSONObject = cVar.f7844f) == null) {
            return null;
        }
        return jSONObject.optJSONObject("016");
    }

    @Override // com.amap.api.col.p0003l.a1
    protected final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f7083a);
        return hashtable;
    }
}
