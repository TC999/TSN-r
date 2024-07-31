package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.j0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineUpdateCityHandlerAbstract extends AbstractProtocalHandler<String, List<OfflineMapProvince>> {

    /* renamed from: d */
    private Context f4548d;

    public OfflineUpdateCityHandlerAbstract(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: i */
    public List<OfflineMapProvince> mo54692a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.f4548d != null) {
                Utility.m53338p(jSONObject.toString(), this.f4548d);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            Context context = this.f4548d;
            if (context != null) {
                return Utility.m53347g(jSONObject, context);
            }
            return null;
        } catch (JSONException e) {
            SDKLogHandler.m53863p(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: b */
    protected final String mo54691b() {
        return "015";
    }

    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: c */
    protected final JSONObject mo54690c(AuthConfigManager.C1801c c1801c) {
        JSONObject jSONObject;
        if (c1801c == null || (jSONObject = c1801c.f4132f) == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("015");
        if (!optJSONObject.has(CommonNetImpl.RESULT)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CommonNetImpl.RESULT, new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return optJSONObject;
    }

    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: e */
    protected final Map<String, String> mo54689e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f3517a);
        return hashtable;
    }

    /* renamed from: h */
    public final void m54688h(Context context) {
        this.f4548d = context;
    }
}
