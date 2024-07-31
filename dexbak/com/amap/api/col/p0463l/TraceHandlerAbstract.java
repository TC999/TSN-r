package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.a4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TraceHandlerAbstract extends AbstractBasicLbsRestHandler<List<TraceLocation>, List<LatLng>> implements Runnable {

    /* renamed from: r */
    private List<TraceLocation> f3528r;

    /* renamed from: s */
    private Handler f3529s;

    /* renamed from: t */
    private int f3530t;

    /* renamed from: u */
    private int f3531u;

    /* renamed from: v */
    private String f3532v;

    public TraceHandlerAbstract(Context context, Handler handler, List<TraceLocation> list, String str, int i, int i2) {
        super(context, list);
        this.f3528r = list;
        this.f3529s = handler;
        this.f3531u = i;
        this.f3530t = i2;
        this.f3532v = str;
    }

    /* renamed from: p */
    private static List<LatLng> m55683p(String str) throws AMapException {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
            }
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicLbsRestHandler, com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: e */
    protected final /* synthetic */ Object mo53402e(String str) throws AMapException {
        return m55683p(str);
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getIPV6URL() {
        return C1732a3.m55685y(getURL());
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final String getURL() {
        String str = "key=" + C1780e4.m55240j(this.f5673k);
        String m54933a = ClientInfo.m54933a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(String.valueOf(m54933a)) + "&scode=".concat(String.valueOf(ClientInfo.m54931c(this.f5673k, m54933a, str)));
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0463l.AbstractBasicLbsRestHandler, com.amap.api.col.p0463l.AbstractBasicHandler
    /* renamed from: m */
    protected final String mo53401m() {
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        for (int i = 0; i < this.f3528r.size(); i++) {
            TraceLocation traceLocation = this.f3528r.get(i);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != 0) {
                        long j2 = time - j;
                        if (j2 >= 1000) {
                            jSONObject.put("tm", j2 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.f5674p = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        new ArrayList();
        try {
            try {
                TraceResultPool.m55478b().m55475e(this.f3532v, this.f3530t, m53534n());
                TraceResultPool.m55478b().m55479a(this.f3532v).m55473b(this.f3529s);
            } catch (AMapException e) {
                TraceResultPool.m55478b();
                TraceResultPool.m55477c(this.f3529s, this.f3531u, e.m55010a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
