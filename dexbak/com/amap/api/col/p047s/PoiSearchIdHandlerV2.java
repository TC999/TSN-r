package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearchV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PoiSearchIdHandlerV2 extends PoiHandler<String, PoiItemV2> {

    /* renamed from: t */
    private PoiSearchV2.Query f6110t;

    public PoiSearchIdHandlerV2(Context context, String str, PoiSearchV2.Query query) {
        super(context, str);
        this.f6110t = query;
    }

    /* renamed from: Q */
    private String m53014Q() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.f5880n);
        sb.append("&output=json");
        PoiSearchV2.Query query = this.f6110t;
        String m53099U = (query == null || query.getShowFields() == null) ? null : PoiHandler.m53099U(this.f6110t.getShowFields());
        if (m53099U != null) {
            sb.append("&show_fields=");
            sb.append(m53099U);
        }
        sb.append("&key=" + C2199x0.m52327i(this.f5883q));
        String channel = this.f6110t.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = this.f6110t.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        return sb.toString();
    }

    /* renamed from: W */
    private static PoiItemV2 m53013W(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return JSONHelper.m52511h0(optJSONObject);
    }

    /* renamed from: X */
    private static PoiItemV2 m53012X(String str) throws AMapException {
        try {
            return m53013W(new JSONObject(str));
        } catch (JSONException e) {
            C2082j4.m52825i(e, "PoiSearchIdHandlerV2", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "PoiSearchIdHandlerV2", "paseJSONException");
            return null;
        }
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m53012X(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return m53014Q();
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
        return C2077i4.m52892d() + "/place/detail?";
    }
}
