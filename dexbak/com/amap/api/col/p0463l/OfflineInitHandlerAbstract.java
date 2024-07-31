package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.maps.AMapException;
import com.baidu.idl.face.platform.common.ConstantHelper;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.e0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OfflineInitHandlerAbstract extends AbstractProtocalHandler<String, OfflineInitBean> {
    public OfflineInitHandlerAbstract(Context context, String str) {
        super(context, str);
    }

    /* renamed from: h */
    private static OfflineInitBean m55254h(JSONObject jSONObject) throws AMapException {
        OfflineInitBean offlineInitBean = new OfflineInitBean();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                offlineInitBean.m55517b(false);
            } else if (optString.equals("1")) {
                offlineInitBean.m55517b(true);
            }
            offlineInitBean.m55518a(jSONObject.optString(ConstantHelper.LOG_VS, ""));
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return offlineInitBean;
    }

    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: a */
    protected final /* synthetic */ OfflineInitBean mo54692a(JSONObject jSONObject) throws AMapException {
        return m55254h(jSONObject);
    }

    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: b */
    protected final String mo54691b() {
        return "016";
    }

    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: c */
    protected final JSONObject mo54690c(AuthConfigManager.C1801c c1801c) {
        JSONObject jSONObject;
        if (c1801c == null || (jSONObject = c1801c.f4132f) == null) {
            return null;
        }
        return jSONObject.optJSONObject("016");
    }

    @Override // com.amap.api.col.p0463l.AbstractProtocalHandler
    /* renamed from: e */
    protected final Map<String, String> mo54689e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f3517a);
        return hashtable;
    }
}
