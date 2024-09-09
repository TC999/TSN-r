package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TraceHandlerAbstract.java */
/* renamed from: com.amap.api.col.3l.a4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a4 extends y3<List<TraceLocation>, List<LatLng>> implements Runnable {

    /* renamed from: r  reason: collision with root package name */
    private List<TraceLocation> f7094r;

    /* renamed from: s  reason: collision with root package name */
    private Handler f7095s;

    /* renamed from: t  reason: collision with root package name */
    private int f7096t;

    /* renamed from: u  reason: collision with root package name */
    private int f7097u;

    /* renamed from: v  reason: collision with root package name */
    private String f7098v;

    public a4(Context context, Handler handler, List<TraceLocation> list, String str, int i4, int i5) {
        super(context, list);
        this.f7094r = list;
        this.f7095s = handler;
        this.f7097u = i4;
        this.f7096t = i5;
        this.f7098v = str;
    }

    private static List<LatLng> p(String str) throws fc {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null && optJSONArray.length() != 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
            }
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.amap.api.col.p0003l.y3, com.amap.api.col.p0003l.x3
    protected final /* synthetic */ Object e(String str) throws fc {
        return p(str);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return a3.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        String str = "key=" + e4.j(this.f9404k);
        String a4 = h4.a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(String.valueOf(a4)) + "&scode=".concat(String.valueOf(h4.c(this.f9404k, a4, str)));
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0003l.y3, com.amap.api.col.p0003l.x3
    protected final String m() {
        JSONArray jSONArray = new JSONArray();
        long j4 = 0;
        for (int i4 = 0; i4 < this.f7094r.size(); i4++) {
            TraceLocation traceLocation = this.f7094r.get(i4);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i4 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != 0) {
                        long j5 = time - j4;
                        if (j5 >= 1000) {
                            jSONObject.put("tm", j5 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j4 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.f9405p = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        new ArrayList();
        try {
            try {
                c4.b().e(this.f7098v, this.f7096t, n());
                c4.b().a(this.f7098v).b(this.f7095s);
            } catch (fc e4) {
                c4.b();
                c4.c(this.f7095s, this.f7097u, e4.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
