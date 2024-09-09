package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearchV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PoiSearchIdHandlerV2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f extends d<String, PoiItemV2> {

    /* renamed from: t  reason: collision with root package name */
    private PoiSearchV2.Query f9838t;

    public f(Context context, String str, PoiSearchV2.Query query) {
        super(context, str);
        this.f9838t = query;
    }

    private String Q() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.f9630n);
        sb.append("&output=json");
        PoiSearchV2.Query query = this.f9838t;
        String U = (query == null || query.getShowFields() == null) ? null : d.U(this.f9838t.getShowFields());
        if (U != null) {
            sb.append("&show_fields=");
            sb.append(U);
        }
        sb.append("&key=" + x0.i(this.f9633q));
        String channel = this.f9838t.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = this.f9838t.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        return sb.toString();
    }

    private static PoiItemV2 W(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return r4.h0(optJSONObject);
    }

    private static PoiItemV2 X(String str) throws AMapException {
        try {
            return W(new JSONObject(str));
        } catch (JSONException e4) {
            j4.i(e4, "PoiSearchIdHandlerV2", "paseJSONJSONException");
            return null;
        } catch (Exception e5) {
            j4.i(e5, "PoiSearchIdHandlerV2", "paseJSONException");
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
        return i4.d() + "/place/detail?";
    }
}
