package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.col.s.p;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ReverseGeocodingHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r extends b4<RegeocodeQuery, RegeocodeAddress> {
    public r(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    private String U(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z3) {
            sb.append(j4.a(((RegeocodeQuery) this.f9630n).getPoint().getLongitude()));
            sb.append(",");
            sb.append(j4.a(((RegeocodeQuery) this.f9630n).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f9630n).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) this.f9630n).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f9630n).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) this.f9630n).getMode());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f9630n).getExtensions())) {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) this.f9630n).getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) this.f9630n).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) this.f9630n).getLatLonType());
        sb.append("&key=");
        sb.append(x0.i(this.f9633q));
        return sb.toString();
    }

    private static RegeocodeAddress V(String str) throws AMapException {
        JSONObject optJSONObject;
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            optJSONObject = new JSONObject(str).optJSONObject("regeocode");
        } catch (JSONException e4) {
            j4.i(e4, "ReverseGeocodingHandler", "paseJSON");
        }
        if (optJSONObject == null) {
            return regeocodeAddress;
        }
        regeocodeAddress.setFormatAddress(r4.v(optJSONObject, "formatted_address"));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
        if (optJSONObject2 != null) {
            r4.J(optJSONObject2, regeocodeAddress);
        }
        regeocodeAddress.setPois(r4.U(optJSONObject));
        JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
        if (optJSONArray != null) {
            r4.R(optJSONArray, regeocodeAddress);
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
        if (optJSONArray2 != null) {
            r4.H(optJSONArray2, regeocodeAddress);
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
        if (optJSONArray3 != null) {
            r4.X(optJSONArray3, regeocodeAddress);
        }
        return regeocodeAddress;
    }

    private static p W() {
        o c4 = n.b().c("regeo");
        if (c4 == null) {
            return null;
        }
        return (p) c4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return V(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return U(true);
    }

    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        p W = W();
        double l4 = W != null ? W.l() : 0.0d;
        n.b bVar = new n.b();
        bVar.f10028a = h() + U(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        Object obj = this.f9630n;
        if (obj != null && ((RegeocodeQuery) obj).getPoint() != null) {
            bVar.f10029b = new p.a(((RegeocodeQuery) this.f9630n).getPoint().getLatitude(), ((RegeocodeQuery) this.f9630n).getPoint().getLongitude(), l4);
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/geocode/regeo?";
    }
}
