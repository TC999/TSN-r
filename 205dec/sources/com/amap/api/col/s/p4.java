package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GeocodingHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p4 extends b4<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public p4(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> U(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("count") && jSONObject.getInt("count") > 0) ? r4.r0(jSONObject) : arrayList;
        } catch (JSONException e4) {
            j4.i(e4, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e5) {
            j4.i(e5, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(b4.i(((GeocodeQuery) this.f9630n).getLocationName()));
        String city = ((GeocodeQuery) this.f9630n).getCity();
        if (!r4.s0(city)) {
            String i4 = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(i4);
        }
        if (!r4.s0(((GeocodeQuery) this.f9630n).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(b4.i(((GeocodeQuery) this.f9630n).getCountry()));
        }
        stringBuffer.append("&key=" + x0.i(this.f9633q));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        n.b bVar = new n.b();
        bVar.f10028a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/geocode/geo?";
    }
}
