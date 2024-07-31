package com.amap.api.col.p0463l;

import android.content.Context;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.c3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LinkLogManager {

    /* renamed from: a */
    private static Map<String, LinkLogStrategy> f3722a = new ConcurrentHashMap();

    /* renamed from: b */
    private static String f3723b = "";

    /* renamed from: a */
    public static void m55493a() {
        try {
            if (LinkLogConfig.f3643a) {
                for (Map.Entry<String, LinkLogStrategy> entry : f3722a.entrySet()) {
                    entry.getValue().mo54939a();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static void m55492b(int i, String str, String str2) {
        if (i == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    /* renamed from: c */
    private static void m55491c(int i, String str, String str2, String str3, String str4) {
        Map<String, LinkLogStrategy> map;
        LinkLogStrategy linkLogStrategy;
        try {
            String str5 = str3 + str4;
            if (LinkLogConfig.f3644b) {
                m55492b(i, str2, str5);
            }
            if (!LinkLogConfig.f3643a || (map = f3722a) == null || (linkLogStrategy = map.get(str)) == null) {
                return;
            }
            linkLogStrategy.mo54938a(i, str2, str5);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static void m55490d(Context context) {
        if (context == null) {
            return;
        }
        try {
            m55483k();
            AMapLogManager.m55679c(C1732a3.m55691s()).m55675g(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    public static void m55489e(String str, String str2) {
        m55491c(0, PrerollVideoResponse.NORMAL, f3723b, str, str2);
    }

    /* renamed from: f */
    public static void m55488f(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions != null) {
            m55480n(str, str2 + " " + markerOptions.getPosition() + " " + markerOptions.getIcons());
            return;
        }
        m55480n(str, str2);
    }

    /* renamed from: g */
    public static void m55487g(String str, String str2, PolygonOptions polygonOptions) {
        if (polygonOptions != null) {
            StringBuilder sb = new StringBuilder();
            List<LatLng> points = polygonOptions.getPoints();
            if (points != null) {
                sb.append("points size =");
                sb.append(points.size());
            }
            sb.append(";width=");
            sb.append(polygonOptions.getStrokeWidth());
            sb.append(";fillColor=");
            sb.append(polygonOptions.getFillColor());
            sb.append(";strokeColor=");
            sb.append(polygonOptions.getStrokeColor());
            sb.append(";visible=");
            sb.append(polygonOptions.isVisible());
            m55480n(str, str2 + " " + sb.toString());
            return;
        }
        m55480n(str, str2);
    }

    /* renamed from: h */
    public static void m55486h(String str, String str2, PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            StringBuilder sb = new StringBuilder();
            List<LatLng> points = polylineOptions.getPoints();
            if (points != null) {
                sb.append("points size =");
                sb.append(points.size());
            }
            sb.append(";width=");
            sb.append(polylineOptions.getWidth());
            sb.append(";color=");
            sb.append(polylineOptions.getColor());
            sb.append(";visible=");
            sb.append(polylineOptions.isVisible());
            m55480n(str, str2 + " " + sb.toString());
            return;
        }
        m55480n(str, str2);
    }

    /* renamed from: i */
    public static void m55485i(String str, String str2, List<MarkerOptions> list) {
        if (list != null) {
            for (MarkerOptions markerOptions : list) {
                m55488f(str, str2, markerOptions);
            }
        }
    }

    /* renamed from: j */
    public static void m55484j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean m55040x = AuthConfigManager.m55040x(jSONObject.optString("able", ""), false);
            boolean m55040x2 = AuthConfigManager.m55040x(jSONObject.optString("mobile", ""), false);
            boolean m55040x3 = AuthConfigManager.m55040x(jSONObject.optString("debugupload", ""), false);
            boolean m55040x4 = AuthConfigManager.m55040x(jSONObject.optString("debugwrite", ""), false);
            boolean m55040x5 = AuthConfigManager.m55040x(jSONObject.optString("forcedUpload", ""), false);
            LinkLogConfig.f3643a = m55040x;
            boolean m55040x6 = AuthConfigManager.m55040x(jSONObject.optString("di", ""), false);
            String optString = jSONObject.optString("dis", "");
            if (!m55040x6 || C1925p4.m54209B(optString)) {
                AMapLogManager.m55679c(C1732a3.m55691s()).m55671k(m55040x, m55040x2, m55040x4, m55040x3, Arrays.asList(jSONObject.optString("filter", "").split("&")));
                if (m55040x5) {
                    AMapLogManager.m55679c(C1732a3.m55691s()).m55672j(m55040x5);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: k */
    private static void m55483k() {
        try {
            f3722a.put("overlay", new OverlayerStrategy());
            f3722a.put(PrerollVideoResponse.NORMAL, new NormalStratege());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: l */
    public static void m55482l(String str, String str2) {
        m55491c(1, PrerollVideoResponse.NORMAL, f3723b, str, str2);
    }

    /* renamed from: m */
    public static void m55481m(String str, String str2) {
        m55491c(0, "overlay", f3723b, str, str2);
    }

    /* renamed from: n */
    private static void m55480n(String str, String str2) {
        m55491c(1, "overlay", f3723b, str, str2);
    }
}
