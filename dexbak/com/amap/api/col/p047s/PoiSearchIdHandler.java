package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PoiSearchIdHandler extends PoiHandler<String, PoiItem> {

    /* renamed from: t */
    private PoiSearch.Query f6081t;

    public PoiSearchIdHandler(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.f6081t = query;
    }

    /* renamed from: Q */
    private String m53043Q() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.f5880n);
        sb.append("&output=json");
        PoiSearch.Query query = this.f6081t;
        if (query != null && !PoiHandler.m53098V(query.getExtensions())) {
            sb.append("&extensions=");
            sb.append(this.f6081t.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&children=1");
        sb.append("&key=" + C2199x0.m52327i(this.f5883q));
        return sb.toString();
    }

    /* renamed from: W */
    private static PoiItem m53042W(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return JSONHelper.m52519d0(optJSONObject);
    }

    /* renamed from: X */
    private static PoiItem m53041X(String str) throws AMapException {
        try {
            return m53042W(new JSONObject(str));
        } catch (JSONException e) {
            C2082j4.m52825i(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53041X(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return m53043Q();
    }

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: P */
    protected final RequestCacheControl.C2097b mo52642P() {
        RequestCacheControl.C2097b c2097b = new RequestCacheControl.C2097b();
        c2097b.f6300a = mo52180h() + mo52182M() + "language=" + ServiceSettings.getInstance().getLanguage();
        return c2097b;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/place/detail?";
    }
}
