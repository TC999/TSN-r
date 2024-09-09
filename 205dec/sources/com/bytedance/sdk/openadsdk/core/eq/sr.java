package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static long f33311c = 1800000;
    private static volatile long sr = 0;
    private static volatile long ux = 0;

    /* renamed from: w  reason: collision with root package name */
    private static long f33312w = 60000;
    private static volatile xv xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Callable<com.bytedance.sdk.openadsdk.ys.w.xv.xv> {
        private c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.sdk.openadsdk.ys.w.xv.xv call() throws Exception {
            return com.bytedance.sdk.openadsdk.core.k.sr().ux().ev();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w implements Callable<Location> {

        /* renamed from: c  reason: collision with root package name */
        private LocationManager f33322c;

        /* renamed from: w  reason: collision with root package name */
        private String f33323w;

        public w(LocationManager locationManager, String str) {
            this.f33322c = locationManager;
            this.f33323w = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f33322c.getLastKnownLocation(this.f33323w);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.bytedance.sdk.component.utils.a.w("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + currentTimeMillis2);
            return lastKnownLocation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static xv sr(final Context context) {
        xv xvVar = null;
        if (!com.bytedance.sdk.openadsdk.core.k.sr().ux().c()) {
            try {
                com.bytedance.sdk.openadsdk.ys.w.xv.xv xv2 = xv();
                if (xv2 != null) {
                    return new xv(Double.valueOf(xv2.c()).floatValue(), Double.valueOf(xv2.w()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager ux2 = ux(context);
        if (ux2 != null) {
            try {
                Location c4 = c(ux2);
                if (c4 != null && w(c4)) {
                    xvVar = new xv((float) c4.getLatitude(), (float) c4.getLongitude(), System.currentTimeMillis());
                }
                com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.sr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        sr.w(context, ux2);
                    }
                });
            } catch (Throwable th) {
                if (com.bytedance.sdk.component.utils.a.xv()) {
                    th.printStackTrace();
                }
            }
        }
        return xvVar;
    }

    private static LocationManager ux(Context context) {
        try {
            return (LocationManager) context.getSystemService("location");
        } catch (Exception unused) {
            return null;
        }
    }

    public static xv w(Context context) {
        if ((xv != null && !c()) || !w()) {
            return xv;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = com.bytedance.sdk.openadsdk.core.k.sr().ux();
        if (!ux2.c()) {
            com.bytedance.sdk.openadsdk.ys.w.xv.xv ev = ux2.ev();
            if (ev == null) {
                return null;
            }
            ux = System.currentTimeMillis();
            xv = new xv((float) ev.c(), (float) ev.w(), System.currentTimeMillis());
            return xv;
        }
        xv xvVar = xv;
        String xv2 = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("sdk_ad_location", f33311c);
        if (!TextUtils.isEmpty(xv2)) {
            try {
                JSONObject jSONObject = new JSONObject(xv2);
                String string = jSONObject.getString("latitude");
                String string2 = jSONObject.getString("longitude");
                long j4 = jSONObject.getLong("lbstime");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    xv = new xv(Float.valueOf(string).floatValue(), Float.valueOf(string2).floatValue(), j4);
                    ux = j4;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (c()) {
            ux = System.currentTimeMillis();
            final Context context2 = context == null ? com.bytedance.sdk.openadsdk.core.ls.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("getLocation c") { // from class: com.bytedance.sdk.openadsdk.core.eq.sr.1
                @Override // java.lang.Runnable
                public void run() {
                    xv sr2 = sr.sr(context2);
                    if (sr2 != null) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("latitude", Float.toString(sr2.f33369c));
                            jSONObject2.put("longitude", Float.toString(sr2.f33370w));
                            jSONObject2.put("lbstime", sr2.xv);
                            com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("sdk_ad_location", jSONObject2.toString());
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        xv unused = sr.xv = sr2;
                    }
                    long unused2 = sr.sr = System.currentTimeMillis();
                }
            });
        } else {
            sr = ux;
        }
        if (xv == null) {
            xv = xvVar;
            com.bytedance.sdk.component.utils.a.xv("AdLocationUtils", "Use the last valid location");
        }
        return xv;
    }

    private static com.bytedance.sdk.openadsdk.ys.w.xv.xv xv() {
        try {
            final com.bytedance.sdk.component.gd.gd gdVar = new com.bytedance.sdk.component.gd.gd(new c(), 1, 2);
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.eq.sr.5
                @Override // java.lang.Runnable
                public void run() {
                    gdVar.run();
                }
            });
            com.bytedance.sdk.openadsdk.ys.w.xv.xv xvVar = (com.bytedance.sdk.openadsdk.ys.w.xv.xv) gdVar.get(1L, TimeUnit.SECONDS);
            com.bytedance.sdk.component.utils.a.w("AdLocationUtils", "location dev:" + xvVar);
            return xvVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static xv c(Context context) {
        return c(context, -1);
    }

    public static xv c(Context context, int i4) {
        return com.bytedance.sdk.openadsdk.core.xv.sr.c().f(i4) ? c(context, !com.bytedance.sdk.openadsdk.core.xv.c.w()) : w(context);
    }

    public static xv c(Context context, boolean z3) {
        if ((xv != null && !c()) || !w()) {
            return xv;
        }
        String xv2 = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("sdk_ad_location", 2147483647L);
        if (xv2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(xv2);
                String optString = jSONObject.optString("latitude");
                String optString2 = jSONObject.optString("longitude");
                long optLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    xv = new xv(Float.valueOf(optString).floatValue(), Float.valueOf(optString2).floatValue(), optLong);
                    ux = optLong;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z3) {
                return xv;
            }
        }
        if (xv != null && !c()) {
            return xv;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = com.bytedance.sdk.openadsdk.core.k.sr().ux();
        if (!ux2.c()) {
            com.bytedance.sdk.openadsdk.ys.w.xv.xv ev = ux2.ev();
            if (ev != null) {
                ux = System.currentTimeMillis();
                xv = new xv((float) ev.c(), (float) ev.w(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (xv != null) {
                    jSONObject2.put("latitude", Float.toString(xv.f33369c));
                    jSONObject2.put("longitude", Float.toString(xv.f33370w));
                    jSONObject2.put("lbstime", xv.xv);
                }
                com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("sdk_ad_location", jSONObject2.toString());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return xv;
        }
        ux = System.currentTimeMillis();
        sr = System.currentTimeMillis();
        final Context context2 = context == null ? com.bytedance.sdk.openadsdk.core.ls.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("getLocation c") { // from class: com.bytedance.sdk.openadsdk.core.eq.sr.2
            @Override // java.lang.Runnable
            public void run() {
                xv sr2 = sr.sr(context2);
                long unused = sr.sr = 0L;
                if (sr2 != null) {
                    xv unused2 = sr.xv = sr2;
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("latitude", Float.toString(sr2.f33369c));
                        jSONObject3.put("longitude", Float.toString(sr2.f33370w));
                        jSONObject3.put("lbstime", sr2.xv);
                        com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("sdk_ad_location", jSONObject3.toString());
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                }
            }
        });
        return xv;
    }

    private static boolean w() {
        return System.currentTimeMillis() - sr > f33312w;
    }

    private static String w(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.core.eq.sr.6
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    sr.w(location);
                }
                sr.w(locationManager, this);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i4, Bundle bundle) {
            }
        };
        try {
            if (TextUtils.isEmpty(w(locationManager))) {
                return;
            }
            locationManager.requestSingleUpdate("network", locationListener, Looper.myLooper());
            com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.sr.7
                @Override // java.lang.Runnable
                public void run() {
                    sr.w(locationManager, locationListener);
                }
            }, PolicyConfig.mServerBusyRetryBaseInternal);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.a.xv()) {
                th.printStackTrace();
            }
            w(locationManager, locationListener);
        }
    }

    private static boolean c() {
        return System.currentTimeMillis() - ux > f33311c;
    }

    private static Location c(LocationManager locationManager) {
        Location c4 = c(locationManager, "gps");
        if (c4 == null) {
            c4 = c(locationManager, "network");
        }
        return c4 == null ? c(locationManager, "passive") : c4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.a.xv()) {
                th.printStackTrace();
            }
        }
    }

    private static Location c(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.component.gd.gd gdVar = new com.bytedance.sdk.component.gd.gd(new w(locationManager, str), 1, 2);
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.eq.sr.4
                @Override // java.lang.Runnable
                public void run() {
                    gdVar.run();
                }
            });
            return (Location) gdVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
