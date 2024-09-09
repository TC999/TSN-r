package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PoiSearchIdHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e extends d<String, PoiItem> {

    /* renamed from: t  reason: collision with root package name */
    private PoiSearch.Query f9809t;

    public e(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.f9809t = query;
    }

    private String Q() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.f9630n);
        sb.append("&output=json");
        PoiSearch.Query query = this.f9809t;
        if (query != null && !d.V(query.getExtensions())) {
            sb.append("&extensions=");
            sb.append(this.f9809t.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&children=1");
        sb.append("&key=" + x0.i(this.f9633q));
        return sb.toString();
    }

    private static PoiItem W(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return r4.d0(optJSONObject);
    }

    private static PoiItem X(String str) throws AMapException {
        try {
            return W(new JSONObject(str));
        } catch (JSONException e4) {
            j4.i(e4, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e5) {
            j4.i(e5, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return X(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return Q();
    }

    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        n.b bVar = new n.b();
        bVar.f10028a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/place/detail?";
    }
}
