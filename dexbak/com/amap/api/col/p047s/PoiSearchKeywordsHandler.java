package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.col.p047s.RequestCacheWorkerCheckDistance;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PoiSearchKeywordsHandler extends PoiHandler<QueryInternal, PoiResult> {

    /* renamed from: t */
    private int f6122t;

    /* renamed from: u */
    private boolean f6123u;

    /* renamed from: v */
    private List<String> f6124v;

    /* renamed from: w */
    private List<SuggestionCity> f6125w;

    public PoiSearchKeywordsHandler(Context context, QueryInternal queryInternal) {
        super(context, queryInternal);
        this.f6122t = 0;
        this.f6123u = false;
        this.f6124v = new ArrayList();
        this.f6125w = new ArrayList();
    }

    /* renamed from: W */
    private String m53000W(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = this.f5880n;
        if (((QueryInternal) t).f6227b != null) {
            if (((QueryInternal) t).f6227b.getShape().equals("Bound")) {
                if (z) {
                    double m52833a = C2082j4.m52833a(((QueryInternal) this.f5880n).f6227b.getCenter().getLongitude());
                    double m52833a2 = C2082j4.m52833a(((QueryInternal) this.f5880n).f6227b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(m52833a + "," + m52833a2);
                }
                sb.append("&radius=");
                sb.append(((QueryInternal) this.f5880n).f6227b.getRange());
                sb.append("&sortrule=");
                sb.append(m52999X(((QueryInternal) this.f5880n).f6227b.isDistanceSort()));
            } else if (((QueryInternal) this.f5880n).f6227b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((QueryInternal) this.f5880n).f6227b.getLowerLeft();
                LatLonPoint upperRight = ((QueryInternal) this.f5880n).f6227b.getUpperRight();
                double m52833a3 = C2082j4.m52833a(lowerLeft.getLatitude());
                double m52833a4 = C2082j4.m52833a(lowerLeft.getLongitude());
                double m52833a5 = C2082j4.m52833a(upperRight.getLatitude());
                double m52833a6 = C2082j4.m52833a(upperRight.getLongitude());
                sb.append("&polygon=" + m52833a4 + "," + m52833a3 + ";" + m52833a6 + "," + m52833a5);
            } else if (((QueryInternal) this.f5880n).f6227b.getShape().equals("Polygon") && (polyGonList = ((QueryInternal) this.f5880n).f6227b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + C2082j4.m52828f(polyGonList));
            }
        }
        String city = ((QueryInternal) this.f5880n).f6226a.getCity();
        if (!PoiHandler.m53098V(city)) {
            String m53218i = BasicLBSRestHandler.m53218i(city);
            sb.append("&city=");
            sb.append(m53218i);
        }
        String m53218i2 = BasicLBSRestHandler.m53218i(((QueryInternal) this.f5880n).f6226a.getQueryString());
        if (!PoiHandler.m53098V(m53218i2)) {
            sb.append("&keywords=");
            sb.append(m53218i2);
        }
        sb.append("&offset=");
        sb.append(((QueryInternal) this.f5880n).f6226a.getPageSize());
        sb.append("&page=");
        sb.append(((QueryInternal) this.f5880n).f6226a.getPageNum());
        String building = ((QueryInternal) this.f5880n).f6226a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((QueryInternal) this.f5880n).f6226a.getBuilding());
        }
        String m53218i3 = BasicLBSRestHandler.m53218i(((QueryInternal) this.f5880n).f6226a.getCategory());
        if (!PoiHandler.m53098V(m53218i3)) {
            sb.append("&types=");
            sb.append(m53218i3);
        }
        if (!PoiHandler.m53098V(((QueryInternal) this.f5880n).f6226a.getExtensions())) {
            sb.append("&extensions=");
            sb.append(((QueryInternal) this.f5880n).f6226a.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&key=");
        sb.append(C2199x0.m52327i(this.f5883q));
        if (((QueryInternal) this.f5880n).f6226a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((QueryInternal) this.f5880n).f6226a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.f6123u) {
            if (((QueryInternal) this.f5880n).f6226a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        T t2 = this.f5880n;
        if (((QueryInternal) t2).f6227b == null && ((QueryInternal) t2).f6226a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(m52999X(((QueryInternal) this.f5880n).f6226a.isDistanceSort()));
            double m52833a7 = C2082j4.m52833a(((QueryInternal) this.f5880n).f6226a.getLocation().getLongitude());
            double m52833a8 = C2082j4.m52833a(((QueryInternal) this.f5880n).f6226a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(m52833a7 + "," + m52833a8);
        }
        return sb.toString();
    }

    /* renamed from: X */
    private static String m52999X(boolean z) {
        return z ? "distance" : "weight";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: Y */
    public PoiResult mo52183I(String str) throws AMapException {
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            T t = this.f5880n;
            return PoiResult.createPagedResult(((QueryInternal) t).f6226a, ((QueryInternal) t).f6227b, this.f6124v, this.f6125w, ((QueryInternal) t).f6226a.getPageSize(), this.f6122t, arrayList);
        }
        try {
            jSONObject = new JSONObject(str);
            this.f6122t = jSONObject.optInt("count");
            arrayList = JSONHelper.m52536U(jSONObject);
        } catch (JSONException e) {
            C2082j4.m52825i(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
        if (!jSONObject.has("suggestion")) {
            T t2 = this.f5880n;
            return PoiResult.createPagedResult(((QueryInternal) t2).f6226a, ((QueryInternal) t2).f6227b, this.f6124v, this.f6125w, ((QueryInternal) t2).f6226a.getPageSize(), this.f6122t, arrayList);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            T t3 = this.f5880n;
            return PoiResult.createPagedResult(((QueryInternal) t3).f6226a, ((QueryInternal) t3).f6227b, this.f6124v, this.f6125w, ((QueryInternal) t3).f6226a.getPageSize(), this.f6122t, arrayList);
        }
        this.f6125w = JSONHelper.m52482w(optJSONObject);
        this.f6124v = JSONHelper.m52552M(optJSONObject);
        T t4 = this.f5880n;
        return PoiResult.createPagedResult(((QueryInternal) t4).f6226a, ((QueryInternal) t4).f6227b, this.f6124v, this.f6125w, ((QueryInternal) t4).f6226a.getPageSize(), this.f6122t, arrayList);
    }

    /* renamed from: Z */
    private static RequestCacheWorkerCheckDistance m52997Z() {
        RequestCacheWorker m52763c = RequestCacheControl.m52764b().m52763c("regeo");
        if (m52763c == null) {
            return null;
        }
        return (RequestCacheWorkerCheckDistance) m52763c;
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return m53000W(true);
    }

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: P */
    protected final RequestCacheControl.C2097b mo52642P() {
        RequestCacheControl.C2097b c2097b = new RequestCacheControl.C2097b();
        if (this.f6123u) {
            RequestCacheWorkerCheckDistance m52997Z = m52997Z();
            double d = Utils.DOUBLE_EPSILON;
            if (m52997Z != null) {
                d = m52997Z.m52707l();
            }
            double d2 = d;
            c2097b.f6300a = mo52180h() + m53000W(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((QueryInternal) this.f5880n).f6227b.getShape().equals("Bound")) {
                c2097b.f6301b = new RequestCacheWorkerCheckDistance.C2110a(C2082j4.m52833a(((QueryInternal) this.f5880n).f6227b.getCenter().getLatitude()), C2082j4.m52833a(((QueryInternal) this.f5880n).f6227b.getCenter().getLongitude()), d2);
            }
        } else {
            c2097b.f6300a = mo52180h() + mo52182M() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return c2097b;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        String str = C2077i4.m52894b() + "/place";
        T t = this.f5880n;
        if (((QueryInternal) t).f6227b == null) {
            return str + "/text?";
        } else if (((QueryInternal) t).f6227b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f6123u = true;
            return str2;
        } else if (((QueryInternal) this.f5880n).f6227b.getShape().equals("Rectangle") || ((QueryInternal) this.f5880n).f6227b.getShape().equals("Polygon")) {
            return str + "/polygon?";
        } else {
            return str;
        }
    }
}
