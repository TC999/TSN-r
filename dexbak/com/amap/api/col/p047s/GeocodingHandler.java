package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.p4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GeocodingHandler extends BasicLBSRestHandler<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public GeocodingHandler(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    /* renamed from: U */
    private static ArrayList<GeocodeAddress> m52691U(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("count") && jSONObject.getInt("count") > 0) ? JSONHelper.m52491r0(jSONObject) : arrayList;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52691U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(BasicLBSRestHandler.m53218i(((GeocodeQuery) this.f5880n).getLocationName()));
        String city = ((GeocodeQuery) this.f5880n).getCity();
        if (!JSONHelper.m52489s0(city)) {
            String m53218i = BasicLBSRestHandler.m53218i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(m53218i);
        }
        if (!JSONHelper.m52489s0(((GeocodeQuery) this.f5880n).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(BasicLBSRestHandler.m53218i(((GeocodeQuery) this.f5880n).getCountry()));
        }
        stringBuffer.append("&key=" + C2199x0.m52327i(this.f5883q));
        return stringBuffer.toString();
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
        return C2077i4.m52894b() + "/geocode/geo?";
    }
}
