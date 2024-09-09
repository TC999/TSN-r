package com.bytedance.msdk.f;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static long f28317c = 1800000;

    /* renamed from: w  reason: collision with root package name */
    private static Handler f28318w = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Callable<Location> {

        /* renamed from: c  reason: collision with root package name */
        private LocationManager f28325c;

        /* renamed from: w  reason: collision with root package name */
        private String f28326w;

        public c(LocationManager locationManager, String str) {
            this.f28325c = locationManager;
            this.f28326w = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f28325c.getLastKnownLocation(this.f28326w);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.bytedance.msdk.adapter.sr.xv.c("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + currentTimeMillis2);
            return lastKnownLocation;
        }
    }

    private static ux sr(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        ux uxVar = null;
        if (locationManager != null) {
            try {
                Location c4 = c(locationManager);
                if (c4 != null && w(c4)) {
                    w(context, c4);
                    uxVar = new ux((float) c4.getLatitude(), (float) c4.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.msdk.f.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.w(context, locationManager);
                        }
                    });
                } else {
                    w(context, locationManager);
                }
            } catch (Throwable th) {
                if (com.bytedance.msdk.adapter.sr.xv.w()) {
                    th.printStackTrace();
                }
            }
        }
        return uxVar;
    }

    private static boolean w(Context context) {
        long w3 = wv.c((String) null, context).w("lbstime", -1L);
        return w3 == -1 || System.currentTimeMillis() - w3 > f28317c;
    }

    @Nullable
    private static ux xv(Context context) {
        wv c4 = wv.c((String) null, context);
        float w3 = c4.w("latitude", -1.0f);
        float w4 = c4.w("longitude", -1.0f);
        if (w3 == -1.0f || w4 == -1.0f) {
            return null;
        }
        return new ux(w3, w4);
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

    @Nullable
    public static ux c(Context context) {
        if (com.bytedance.msdk.core.w.k().y().c()) {
            Context context2 = context == null ? com.bytedance.msdk.core.c.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (context2 == null) {
                return null;
            }
            ux xv = xv(context2);
            if (w(context2)) {
                int c4 = com.bytedance.msdk.core.t.xv.c(context2, "android.permission.ACCESS_FINE_LOCATION");
                int c5 = com.bytedance.msdk.core.t.xv.c(context2, "android.permission.ACCESS_COARSE_LOCATION");
                if (c4 == 0 || c5 == 0) {
                    return sr(context2);
                }
                return null;
            }
            return xv;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(final Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.msdk.f.f.2
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null && f.w(location)) {
                    f.w(context, location);
                }
                f.w(locationManager, this);
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
            String w3 = w(locationManager);
            if (TextUtils.isEmpty(w3)) {
                return;
            }
            locationManager.requestSingleUpdate(w3, locationListener, Looper.getMainLooper());
            f28318w.postDelayed(new Runnable() { // from class: com.bytedance.msdk.f.f.3
                @Override // java.lang.Runnable
                public void run() {
                    f.w(locationManager, locationListener);
                }
            }, PolicyConfig.mServerBusyRetryBaseInternal);
        } catch (Throwable th) {
            if (com.bytedance.msdk.adapter.sr.xv.w()) {
                th.printStackTrace();
            }
            w(locationManager, locationListener);
        }
    }

    private static Location c(LocationManager locationManager) {
        Location c4 = c(locationManager, "gps");
        if (c4 == null) {
            c4 = c(locationManager, "network");
        }
        return c4 == null ? c(locationManager, "passive") : c4;
    }

    private static Location c(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new c(locationManager, str));
            com.bytedance.msdk.adapter.sr.f.sr(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            com.bytedance.msdk.adapter.sr.xv.c("AdLocationUtils", "location:" + location);
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.msdk.adapter.sr.xv.w()) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Context context, Location location) {
        if (w(location)) {
            wv c4 = wv.c((String) null, context);
            c4.c("latitude", (float) location.getLatitude());
            c4.c("longitude", (float) location.getLongitude());
            c4.c("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
