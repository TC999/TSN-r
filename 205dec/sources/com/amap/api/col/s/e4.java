package com.amap.api.col.s;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BusSearchServerHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e4<T> extends b4<T, Object> {

    /* renamed from: t  reason: collision with root package name */
    private int f9835t;

    /* renamed from: u  reason: collision with root package name */
    private List<String> f9836u;

    /* renamed from: v  reason: collision with root package name */
    private List<SuggestionCity> f9837v;

    public e4(Context context, T t3) {
        super(context, t3);
        this.f9835t = 0;
        this.f9836u = new ArrayList();
        this.f9837v = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final Object I(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.f9837v = r4.w(optJSONObject);
                this.f9836u = r4.M(optJSONObject);
            }
            this.f9835t = jSONObject.optInt("count");
            if (this.f9630n instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.f9630n, this.f9835t, this.f9837v, this.f9836u, r4.p0(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.f9630n, this.f9835t, this.f9837v, this.f9836u, r4.m0(jSONObject));
        } catch (Exception e4) {
            j4.i(e4, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t3 = this.f9630n;
        if (t3 instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t3;
            if (!TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            } else {
                sb.append("&extensions=base");
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(b4.i(((BusLineQuery) this.f9630n).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!r4.s0(city)) {
                    String i4 = b4.i(city);
                    sb.append("&city=");
                    sb.append(i4);
                }
                sb.append("&keywords=" + b4.i(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t3;
            String city2 = busStationQuery.getCity();
            if (!r4.s0(city2)) {
                String i5 = b4.i(city2);
                sb.append("&city=");
                sb.append(i5);
            }
            sb.append("&keywords=" + b4.i(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + x0.i(this.f9633q));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        String str;
        T t3 = this.f9630n;
        if (!(t3 instanceof BusLineQuery)) {
            str = "stopname";
        } else if (((BusLineQuery) t3).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
            str = "lineid";
        } else {
            str = ((BusLineQuery) this.f9630n).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "";
        }
        return i4.b() + "/bus/" + str + "?";
    }
}
