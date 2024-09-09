package com.amap.api.col.p0003l;

import android.content.Context;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: LinkLogManager.java */
/* renamed from: com.amap.api.col.3l.c3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c3 {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, e3> f7304a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static String f7305b = "";

    public static void a() {
        try {
            if (b3.f7204a) {
                for (Map.Entry<String, e3> entry : f7304a.entrySet()) {
                    entry.getValue().a();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(int i4, String str, String str2) {
        if (i4 == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    private static void c(int i4, String str, String str2, String str3, String str4) {
        Map<String, e3> map;
        e3 e3Var;
        try {
            String str5 = str3 + str4;
            if (b3.f7205b) {
                b(i4, str2, str5);
            }
            if (!b3.f7204a || (map = f7304a) == null || (e3Var = map.get(str)) == null) {
                return;
            }
            e3Var.a(i4, str2, str5);
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            k();
            b5.c(a3.s()).g(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (Throwable unused) {
        }
    }

    public static void e(String str, String str2) {
        c(0, "normal", f7305b, str, str2);
    }

    public static void f(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions != null) {
            n(str, str2 + " " + markerOptions.getPosition() + " " + markerOptions.getIcons());
            return;
        }
        n(str, str2);
    }

    public static void g(String str, String str2, PolygonOptions polygonOptions) {
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
            n(str, str2 + " " + sb.toString());
            return;
        }
        n(str, str2);
    }

    public static void h(String str, String str2, PolylineOptions polylineOptions) {
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
            n(str, str2 + " " + sb.toString());
            return;
        }
        n(str, str2);
    }

    public static void i(String str, String str2, List<MarkerOptions> list) {
        if (list != null) {
            for (MarkerOptions markerOptions : list) {
                f(str, str2, markerOptions);
            }
        }
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean x3 = g4.x(jSONObject.optString("able", ""), false);
            boolean x4 = g4.x(jSONObject.optString("mobile", ""), false);
            boolean x5 = g4.x(jSONObject.optString("debugupload", ""), false);
            boolean x6 = g4.x(jSONObject.optString("debugwrite", ""), false);
            boolean x7 = g4.x(jSONObject.optString("forcedUpload", ""), false);
            b3.f7204a = x3;
            boolean x8 = g4.x(jSONObject.optString("di", ""), false);
            String optString = jSONObject.optString("dis", "");
            if (!x8 || q4.B(optString)) {
                b5.c(a3.s()).k(x3, x4, x6, x5, Arrays.asList(jSONObject.optString("filter", "").split("&")));
                if (x7) {
                    b5.c(a3.s()).j(x7);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void k() {
        try {
            f7304a.put("overlay", new g3());
            f7304a.put("normal", new f3());
        } catch (Throwable unused) {
        }
    }

    public static void l(String str, String str2) {
        c(1, "normal", f7305b, str, str2);
    }

    public static void m(String str, String str2) {
        c(0, "overlay", f7305b, str, str2);
    }

    private static void n(String str, String str2) {
        c(1, "overlay", f7305b, str, str2);
    }
}
