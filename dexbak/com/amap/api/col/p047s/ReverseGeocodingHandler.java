package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.col.p047s.RequestCacheWorkerCheckDistance;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.github.mikephil.charting.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ReverseGeocodingHandler extends BasicLBSRestHandler<RegeocodeQuery, RegeocodeAddress> {
    public ReverseGeocodingHandler(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    /* renamed from: U */
    private String m52641U(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(C2082j4.m52833a(((RegeocodeQuery) this.f5880n).getPoint().getLongitude()));
            sb.append(",");
            sb.append(C2082j4.m52833a(((RegeocodeQuery) this.f5880n).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f5880n).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) this.f5880n).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f5880n).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) this.f5880n).getMode());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f5880n).getExtensions())) {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) this.f5880n).getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) this.f5880n).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) this.f5880n).getLatLonType());
        sb.append("&key=");
        sb.append(C2199x0.m52327i(this.f5883q));
        return sb.toString();
    }

    /* renamed from: V */
    private static RegeocodeAddress m52640V(String str) throws AMapException {
        JSONObject optJSONObject;
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            optJSONObject = new JSONObject(str).optJSONObject("regeocode");
        } catch (JSONException e) {
            C2082j4.m52825i(e, "ReverseGeocodingHandler", "paseJSON");
        }
        if (optJSONObject == null) {
            return regeocodeAddress;
        }
        regeocodeAddress.setFormatAddress(JSONHelper.m52484v(optJSONObject, "formatted_address"));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
        if (optJSONObject2 != null) {
            JSONHelper.m52558J(optJSONObject2, regeocodeAddress);
        }
        regeocodeAddress.setPois(JSONHelper.m52536U(optJSONObject));
        JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
        if (optJSONArray != null) {
            JSONHelper.m52542R(optJSONArray, regeocodeAddress);
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
        if (optJSONArray2 != null) {
            JSONHelper.m52562H(optJSONArray2, regeocodeAddress);
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
        if (optJSONArray3 != null) {
            JSONHelper.m52530X(optJSONArray3, regeocodeAddress);
        }
        return regeocodeAddress;
    }

    /* renamed from: W */
    private static RequestCacheWorkerCheckDistance m52639W() {
        RequestCacheWorker m52763c = RequestCacheControl.m52764b().m52763c("regeo");
        if (m52763c == null) {
            return null;
        }
        return (RequestCacheWorkerCheckDistance) m52763c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52640V(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return m52641U(true);
    }

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: P */
    protected final RequestCacheControl.C2097b mo52642P() {
        RequestCacheWorkerCheckDistance m52639W = m52639W();
        double m52707l = m52639W != null ? m52639W.m52707l() : Utils.DOUBLE_EPSILON;
        RequestCacheControl.C2097b c2097b = new RequestCacheControl.C2097b();
        c2097b.f6300a = mo52180h() + m52641U(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t = this.f5880n;
        if (t != 0 && ((RegeocodeQuery) t).getPoint() != null) {
            c2097b.f6301b = new RequestCacheWorkerCheckDistance.C2110a(((RegeocodeQuery) this.f5880n).getPoint().getLatitude(), ((RegeocodeQuery) this.f5880n).getPoint().getLongitude(), m52707l);
        }
        return c2097b;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/geocode/regeo?";
    }
}
