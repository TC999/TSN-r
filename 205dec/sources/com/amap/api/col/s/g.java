package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.n;
import com.amap.api.col.s.p;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PoiSearchKeywordsHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g extends d<k, PoiResult> {

    /* renamed from: t  reason: collision with root package name */
    private int f9850t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9851u;

    /* renamed from: v  reason: collision with root package name */
    private List<String> f9852v;

    /* renamed from: w  reason: collision with root package name */
    private List<SuggestionCity> f9853w;

    public g(Context context, k kVar) {
        super(context, kVar);
        this.f9850t = 0;
        this.f9851u = false;
        this.f9852v = new ArrayList();
        this.f9853w = new ArrayList();
    }

    private String W(boolean z3) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        Object obj = this.f9630n;
        if (((k) obj).f9955b != null) {
            if (((k) obj).f9955b.getShape().equals("Bound")) {
                if (z3) {
                    double a4 = j4.a(((k) this.f9630n).f9955b.getCenter().getLongitude());
                    double a5 = j4.a(((k) this.f9630n).f9955b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a4 + "," + a5);
                }
                sb.append("&radius=");
                sb.append(((k) this.f9630n).f9955b.getRange());
                sb.append("&sortrule=");
                sb.append(X(((k) this.f9630n).f9955b.isDistanceSort()));
            } else if (((k) this.f9630n).f9955b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((k) this.f9630n).f9955b.getLowerLeft();
                LatLonPoint upperRight = ((k) this.f9630n).f9955b.getUpperRight();
                double a6 = j4.a(lowerLeft.getLatitude());
                double a7 = j4.a(lowerLeft.getLongitude());
                double a8 = j4.a(upperRight.getLatitude());
                double a9 = j4.a(upperRight.getLongitude());
                sb.append("&polygon=" + a7 + "," + a6 + ";" + a9 + "," + a8);
            } else if (((k) this.f9630n).f9955b.getShape().equals("Polygon") && (polyGonList = ((k) this.f9630n).f9955b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + j4.f(polyGonList));
            }
        }
        String city = ((k) this.f9630n).f9954a.getCity();
        if (!d.V(city)) {
            String i4 = b4.i(city);
            sb.append("&city=");
            sb.append(i4);
        }
        String i5 = b4.i(((k) this.f9630n).f9954a.getQueryString());
        if (!d.V(i5)) {
            sb.append("&keywords=");
            sb.append(i5);
        }
        sb.append("&offset=");
        sb.append(((k) this.f9630n).f9954a.getPageSize());
        sb.append("&page=");
        sb.append(((k) this.f9630n).f9954a.getPageNum());
        String building = ((k) this.f9630n).f9954a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((k) this.f9630n).f9954a.getBuilding());
        }
        String i6 = b4.i(((k) this.f9630n).f9954a.getCategory());
        if (!d.V(i6)) {
            sb.append("&types=");
            sb.append(i6);
        }
        if (!d.V(((k) this.f9630n).f9954a.getExtensions())) {
            sb.append("&extensions=");
            sb.append(((k) this.f9630n).f9954a.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&key=");
        sb.append(x0.i(this.f9633q));
        if (((k) this.f9630n).f9954a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((k) this.f9630n).f9954a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.f9851u) {
            if (((k) this.f9630n).f9954a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        Object obj2 = this.f9630n;
        if (((k) obj2).f9955b == null && ((k) obj2).f9954a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(X(((k) this.f9630n).f9954a.isDistanceSort()));
            double a10 = j4.a(((k) this.f9630n).f9954a.getLocation().getLongitude());
            double a11 = j4.a(((k) this.f9630n).f9954a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a10 + "," + a11);
        }
        return sb.toString();
    }

    private static String X(boolean z3) {
        return z3 ? "distance" : "weight";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: Y */
    public PoiResult I(String str) throws AMapException {
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            Object obj = this.f9630n;
            return PoiResult.createPagedResult(((k) obj).f9954a, ((k) obj).f9955b, this.f9852v, this.f9853w, ((k) obj).f9954a.getPageSize(), this.f9850t, arrayList);
        }
        try {
            jSONObject = new JSONObject(str);
            this.f9850t = jSONObject.optInt("count");
            arrayList = r4.U(jSONObject);
        } catch (JSONException e4) {
            j4.i(e4, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e5) {
            j4.i(e5, "PoiSearchKeywordHandler", "paseJSONException");
        }
        if (!jSONObject.has("suggestion")) {
            Object obj2 = this.f9630n;
            return PoiResult.createPagedResult(((k) obj2).f9954a, ((k) obj2).f9955b, this.f9852v, this.f9853w, ((k) obj2).f9954a.getPageSize(), this.f9850t, arrayList);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            Object obj3 = this.f9630n;
            return PoiResult.createPagedResult(((k) obj3).f9954a, ((k) obj3).f9955b, this.f9852v, this.f9853w, ((k) obj3).f9954a.getPageSize(), this.f9850t, arrayList);
        }
        this.f9853w = r4.w(optJSONObject);
        this.f9852v = r4.M(optJSONObject);
        Object obj4 = this.f9630n;
        return PoiResult.createPagedResult(((k) obj4).f9954a, ((k) obj4).f9955b, this.f9852v, this.f9853w, ((k) obj4).f9954a.getPageSize(), this.f9850t, arrayList);
    }

    private static p Z() {
        o c4 = n.b().c("regeo");
        if (c4 == null) {
            return null;
        }
        return (p) c4;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return W(true);
    }

    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        n.b bVar = new n.b();
        if (this.f9851u) {
            p Z = Z();
            double l4 = Z != null ? Z.l() : 0.0d;
            bVar.f10028a = h() + W(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((k) this.f9630n).f9955b.getShape().equals("Bound")) {
                bVar.f10029b = new p.a(j4.a(((k) this.f9630n).f9955b.getCenter().getLatitude()), j4.a(((k) this.f9630n).f9955b.getCenter().getLongitude()), l4);
            }
        } else {
            bVar.f10028a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        String str = i4.b() + "/place";
        Object obj = this.f9630n;
        if (((k) obj).f9955b == null) {
            return str + "/text?";
        } else if (((k) obj).f9955b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f9851u = true;
            return str2;
        } else if (((k) this.f9630n).f9955b.getShape().equals("Rectangle") || ((k) this.f9630n).f9955b.getShape().equals("Polygon")) {
            return str + "/polygon?";
        } else {
            return str;
        }
    }
}
