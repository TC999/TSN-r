package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.col.p047s.RequestCacheWorkerCheckDistance;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResultV2;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PoiSearchKeywordsHandlerV2 extends PoiHandler<QueryInternalV2, PoiResultV2> {

    /* renamed from: t */
    private int f6141t;

    /* renamed from: u */
    private boolean f6142u;

    public PoiSearchKeywordsHandlerV2(Context context, QueryInternalV2 queryInternalV2) {
        super(context, queryInternalV2);
        this.f6141t = 0;
        this.f6142u = false;
    }

    /* renamed from: W */
    private String m52965W(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = this.f5880n;
        if (((QueryInternalV2) t).f6258b != null) {
            if (((QueryInternalV2) t).f6258b.getShape().equals("Bound")) {
                if (z) {
                    double m52833a = C2082j4.m52833a(((QueryInternalV2) this.f5880n).f6258b.getCenter().getLongitude());
                    double m52833a2 = C2082j4.m52833a(((QueryInternalV2) this.f5880n).f6258b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(m52833a + "," + m52833a2);
                }
                sb.append("&radius=");
                sb.append(((QueryInternalV2) this.f5880n).f6258b.getRange());
                sb.append("&sortrule=");
                sb.append(m52964X(((QueryInternalV2) this.f5880n).f6258b.isDistanceSort()));
            } else if (((QueryInternalV2) this.f5880n).f6258b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((QueryInternalV2) this.f5880n).f6258b.getLowerLeft();
                LatLonPoint upperRight = ((QueryInternalV2) this.f5880n).f6258b.getUpperRight();
                double m52833a3 = C2082j4.m52833a(lowerLeft.getLatitude());
                double m52833a4 = C2082j4.m52833a(lowerLeft.getLongitude());
                double m52833a5 = C2082j4.m52833a(upperRight.getLatitude());
                double m52833a6 = C2082j4.m52833a(upperRight.getLongitude());
                sb.append("&polygon=" + m52833a4 + "," + m52833a3 + ";" + m52833a6 + "," + m52833a5);
            } else if (((QueryInternalV2) this.f5880n).f6258b.getShape().equals("Polygon") && (polyGonList = ((QueryInternalV2) this.f5880n).f6258b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + C2082j4.m52828f(polyGonList));
            }
        }
        String city = ((QueryInternalV2) this.f5880n).f6257a.getCity();
        if (!PoiHandler.m53098V(city)) {
            String m53218i = BasicLBSRestHandler.m53218i(city);
            sb.append("&region=");
            sb.append(m53218i);
        }
        String m53218i2 = BasicLBSRestHandler.m53218i(((QueryInternalV2) this.f5880n).f6257a.getQueryString());
        if (!PoiHandler.m53098V(m53218i2)) {
            sb.append("&keywords=");
            sb.append(m53218i2);
        }
        sb.append("&page_size=");
        sb.append(((QueryInternalV2) this.f5880n).f6257a.getPageSize());
        sb.append("&page_num=");
        sb.append(((QueryInternalV2) this.f5880n).f6257a.getPageNum());
        String building = ((QueryInternalV2) this.f5880n).f6257a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((QueryInternalV2) this.f5880n).f6257a.getBuilding());
        }
        String m53218i3 = BasicLBSRestHandler.m53218i(((QueryInternalV2) this.f5880n).f6257a.getCategory());
        if (!PoiHandler.m53098V(m53218i3)) {
            sb.append("&types=");
            sb.append(m53218i3);
        }
        String m53099U = PoiHandler.m53099U(((QueryInternalV2) this.f5880n).f6257a.getShowFields());
        if (m53099U != null) {
            sb.append("&show_fields=");
            sb.append(m53099U);
        }
        sb.append("&key=");
        sb.append(C2199x0.m52327i(this.f5883q));
        if (((QueryInternalV2) this.f5880n).f6257a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (this.f6142u) {
            if (((QueryInternalV2) this.f5880n).f6257a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        String channel = ((QueryInternalV2) this.f5880n).f6257a.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = ((QueryInternalV2) this.f5880n).f6257a.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        T t2 = this.f5880n;
        if (((QueryInternalV2) t2).f6258b == null && ((QueryInternalV2) t2).f6257a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(m52964X(((QueryInternalV2) this.f5880n).f6257a.isDistanceSort()));
            double m52833a7 = C2082j4.m52833a(((QueryInternalV2) this.f5880n).f6257a.getLocation().getLongitude());
            double m52833a8 = C2082j4.m52833a(((QueryInternalV2) this.f5880n).f6257a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(m52833a7 + "," + m52833a8);
        }
        return sb.toString();
    }

    /* renamed from: X */
    private static String m52964X(boolean z) {
        return z ? "distance" : "weight";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: Y */
    public PoiResultV2 mo52183I(String str) throws AMapException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        if (str == null) {
            T t = this.f5880n;
            return PoiResultV2.createPagedResult(((QueryInternalV2) t).f6257a, ((QueryInternalV2) t).f6258b, this.f6141t, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f6141t = jSONObject.optInt("count");
            arrayList = JSONHelper.m52527Z(jSONObject);
        } catch (JSONException e) {
            C2082j4.m52825i(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
        T t2 = this.f5880n;
        return PoiResultV2.createPagedResult(((QueryInternalV2) t2).f6257a, ((QueryInternalV2) t2).f6258b, this.f6141t, arrayList);
    }

    /* renamed from: Z */
    private static RequestCacheWorkerCheckDistance m52962Z() {
        RequestCacheWorker m52763c = RequestCacheControl.m52764b().m52763c("regeo");
        if (m52763c == null) {
            return null;
        }
        return (RequestCacheWorkerCheckDistance) m52763c;
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return m52965W(true);
    }

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: P */
    protected final RequestCacheControl.C2097b mo52642P() {
        RequestCacheControl.C2097b c2097b = new RequestCacheControl.C2097b();
        if (this.f6142u) {
            RequestCacheWorkerCheckDistance m52962Z = m52962Z();
            double d = Utils.DOUBLE_EPSILON;
            if (m52962Z != null) {
                d = m52962Z.m52707l();
            }
            double d2 = d;
            c2097b.f6300a = mo52180h() + m52965W(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((QueryInternalV2) this.f5880n).f6258b.getShape().equals("Bound")) {
                c2097b.f6301b = new RequestCacheWorkerCheckDistance.C2110a(C2082j4.m52833a(((QueryInternalV2) this.f5880n).f6258b.getCenter().getLatitude()), C2082j4.m52833a(((QueryInternalV2) this.f5880n).f6258b.getCenter().getLongitude()), d2);
            }
        } else {
            c2097b.f6300a = mo52180h() + mo52182M() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return c2097b;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        String str = C2077i4.m52892d() + "/place";
        T t = this.f5880n;
        if (((QueryInternalV2) t).f6258b == null) {
            return str + "/text?";
        } else if (((QueryInternalV2) t).f6258b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f6142u = true;
            return str2;
        } else if (((QueryInternalV2) this.f5880n).f6258b.getShape().equals("Rectangle") || ((QueryInternalV2) this.f5880n).f6258b.getShape().equals("Polygon")) {
            return str + "/polygon?";
        } else {
            return str;
        }
    }
}
