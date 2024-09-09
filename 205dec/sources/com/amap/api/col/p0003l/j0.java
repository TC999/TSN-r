package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OfflineUpdateCityHandlerAbstract.java */
/* renamed from: com.amap.api.col.3l.j0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j0 extends a1<String, List<OfflineMapProvince>> {

    /* renamed from: d  reason: collision with root package name */
    private Context f8192d;

    public j0(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.a1
    /* renamed from: i */
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.f8192d != null) {
                z0.p(jSONObject.toString(), this.f8192d);
            }
        } catch (Throwable th) {
            u5.p(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            Context context = this.f8192d;
            if (context != null) {
                return z0.g(jSONObject, context);
            }
            return null;
        } catch (JSONException e4) {
            u5.p(e4, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.a1
    protected final String b() {
        return "015";
    }

    @Override // com.amap.api.col.p0003l.a1
    protected final JSONObject c(g4.c cVar) {
        JSONObject jSONObject;
        if (cVar == null || (jSONObject = cVar.f7844f) == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject2;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return optJSONObject;
    }

    @Override // com.amap.api.col.p0003l.a1
    protected final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f7083a);
        return hashtable;
    }

    public final void h(Context context) {
        this.f8192d = context;
    }
}
