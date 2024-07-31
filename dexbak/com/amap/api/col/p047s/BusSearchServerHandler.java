package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.e4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BusSearchServerHandler<T> extends BasicLBSRestHandler<T, Object> {

    /* renamed from: t */
    private int f6107t;

    /* renamed from: u */
    private List<String> f6108u;

    /* renamed from: v */
    private List<SuggestionCity> f6109v;

    public BusSearchServerHandler(Context context, T t) {
        super(context, t);
        this.f6107t = 0;
        this.f6108u = new ArrayList();
        this.f6109v = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final Object mo52183I(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.f6109v = JSONHelper.m52482w(optJSONObject);
                this.f6108u = JSONHelper.m52552M(optJSONObject);
            }
            this.f6107t = jSONObject.optInt("count");
            if (this.f5880n instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.f5880n, this.f6107t, this.f6109v, this.f6108u, JSONHelper.m52495p0(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.f5880n, this.f6107t, this.f6109v, this.f6108u, JSONHelper.m52501m0(jSONObject));
        } catch (Exception e) {
            C2082j4.m52825i(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = this.f5880n;
        if (t instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t;
            if (!TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            } else {
                sb.append("&extensions=base");
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(BasicLBSRestHandler.m53218i(((BusLineQuery) this.f5880n).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!JSONHelper.m52489s0(city)) {
                    String m53218i = BasicLBSRestHandler.m53218i(city);
                    sb.append("&city=");
                    sb.append(m53218i);
                }
                sb.append("&keywords=" + BasicLBSRestHandler.m53218i(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t;
            String city2 = busStationQuery.getCity();
            if (!JSONHelper.m52489s0(city2)) {
                String m53218i2 = BasicLBSRestHandler.m53218i(city2);
                sb.append("&city=");
                sb.append(m53218i2);
            }
            sb.append("&keywords=" + BasicLBSRestHandler.m53218i(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + C2199x0.m52327i(this.f5883q));
        return sb.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        String str;
        T t = this.f5880n;
        if (!(t instanceof BusLineQuery)) {
            str = "stopname";
        } else if (((BusLineQuery) t).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
            str = "lineid";
        } else {
            str = ((BusLineQuery) this.f5880n).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "";
        }
        return C2077i4.m52894b() + "/bus/" + str + "?";
    }
}
