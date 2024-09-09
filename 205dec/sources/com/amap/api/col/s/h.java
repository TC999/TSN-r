package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.col.s.p;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResultV2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PoiSearchKeywordsHandlerV2.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h extends d<l, PoiResultV2> {

    /* renamed from: t  reason: collision with root package name */
    private int f9869t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9870u;

    public h(Context context, l lVar) {
        super(context, lVar);
        this.f9869t = 0;
        this.f9870u = false;
    }

    private String W(boolean z3) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        Object obj = this.f9630n;
        if (((l) obj).f9986b != null) {
            if (((l) obj).f9986b.getShape().equals("Bound")) {
                if (z3) {
                    double a4 = j4.a(((l) this.f9630n).f9986b.getCenter().getLongitude());
                    double a5 = j4.a(((l) this.f9630n).f9986b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a4 + "," + a5);
                }
                sb.append("&radius=");
                sb.append(((l) this.f9630n).f9986b.getRange());
                sb.append("&sortrule=");
                sb.append(X(((l) this.f9630n).f9986b.isDistanceSort()));
            } else if (((l) this.f9630n).f9986b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((l) this.f9630n).f9986b.getLowerLeft();
                LatLonPoint upperRight = ((l) this.f9630n).f9986b.getUpperRight();
                double a6 = j4.a(lowerLeft.getLatitude());
                double a7 = j4.a(lowerLeft.getLongitude());
                double a8 = j4.a(upperRight.getLatitude());
                double a9 = j4.a(upperRight.getLongitude());
                sb.append("&polygon=" + a7 + "," + a6 + ";" + a9 + "," + a8);
            } else if (((l) this.f9630n).f9986b.getShape().equals("Polygon") && (polyGonList = ((l) this.f9630n).f9986b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + j4.f(polyGonList));
            }
        }
        String city = ((l) this.f9630n).f9985a.getCity();
        if (!d.V(city)) {
            String i4 = b4.i(city);
            sb.append("&region=");
            sb.append(i4);
        }
        String i5 = b4.i(((l) this.f9630n).f9985a.getQueryString());
        if (!d.V(i5)) {
            sb.append("&keywords=");
            sb.append(i5);
        }
        sb.append("&page_size=");
        sb.append(((l) this.f9630n).f9985a.getPageSize());
        sb.append("&page_num=");
        sb.append(((l) this.f9630n).f9985a.getPageNum());
        String building = ((l) this.f9630n).f9985a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((l) this.f9630n).f9985a.getBuilding());
        }
        String i6 = b4.i(((l) this.f9630n).f9985a.getCategory());
        if (!d.V(i6)) {
            sb.append("&types=");
            sb.append(i6);
        }
        String U = d.U(((l) this.f9630n).f9985a.getShowFields());
        if (U != null) {
            sb.append("&show_fields=");
            sb.append(U);
        }
        sb.append("&key=");
        sb.append(x0.i(this.f9633q));
        if (((l) this.f9630n).f9985a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (this.f9870u) {
            if (((l) this.f9630n).f9985a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        String channel = ((l) this.f9630n).f9985a.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb.append("&channel=");
            sb.append(channel);
        }
        String premium = ((l) this.f9630n).f9985a.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb.append("&permium=");
            sb.append(premium);
        }
        Object obj2 = this.f9630n;
        if (((l) obj2).f9986b == null && ((l) obj2).f9985a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(X(((l) this.f9630n).f9985a.isDistanceSort()));
            double a10 = j4.a(((l) this.f9630n).f9985a.getLocation().getLongitude());
            double a11 = j4.a(((l) this.f9630n).f9985a.getLocation().getLatitude());
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
    public PoiResultV2 I(String str) throws AMapException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        if (str == null) {
            Object obj = this.f9630n;
            return PoiResultV2.createPagedResult(((l) obj).f9985a, ((l) obj).f9986b, this.f9869t, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f9869t = jSONObject.optInt("count");
            arrayList = r4.Z(jSONObject);
        } catch (JSONException e4) {
            j4.i(e4, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e5) {
            j4.i(e5, "PoiSearchKeywordHandler", "paseJSONException");
        }
        Object obj2 = this.f9630n;
        return PoiResultV2.createPagedResult(((l) obj2).f9985a, ((l) obj2).f9986b, this.f9869t, arrayList);
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
        if (this.f9870u) {
            p Z = Z();
            double l4 = Z != null ? Z.l() : 0.0d;
            bVar.f10028a = h() + W(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((l) this.f9630n).f9986b.getShape().equals("Bound")) {
                bVar.f10029b = new p.a(j4.a(((l) this.f9630n).f9986b.getCenter().getLatitude()), j4.a(((l) this.f9630n).f9986b.getCenter().getLongitude()), l4);
            }
        } else {
            bVar.f10028a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        String str = i4.d() + "/place";
        Object obj = this.f9630n;
        if (((l) obj).f9986b == null) {
            return str + "/text?";
        } else if (((l) obj).f9986b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.f9870u = true;
            return str2;
        } else if (((l) this.f9630n).f9986b.getShape().equals("Rectangle") || ((l) this.f9630n).f9986b.getShape().equals("Polygon")) {
            return str + "/polygon?";
        } else {
            return str;
        }
    }
}
