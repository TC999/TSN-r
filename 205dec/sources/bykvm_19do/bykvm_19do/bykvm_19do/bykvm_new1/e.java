package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* compiled from: AdLocationUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static long f633a = 1800000;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f634b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private static ExecutorService f635c = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdLocationUtils.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f636a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LocationManager f637b;

        a(Context context, LocationManager locationManager) {
            this.f636a = context;
            this.f637b = locationManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b(this.f636a, this.f637b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdLocationUtils.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f638a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LocationManager f639b;

        b(Context context, LocationManager locationManager) {
            this.f638a = context;
            this.f639b = locationManager;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null && e.b(location)) {
                e.b(this.f638a, location);
            }
            e.b(this.f639b, this);
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdLocationUtils.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LocationManager f640a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LocationListener f641b;

        c(LocationManager locationManager, LocationListener locationListener) {
            this.f640a = locationManager;
            this.f641b = locationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b(this.f640a, this.f641b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdLocationUtils.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class d implements Callable<Location> {

        /* renamed from: a  reason: collision with root package name */
        private LocationManager f642a;

        /* renamed from: b  reason: collision with root package name */
        private String f643b;

        public d(LocationManager locationManager, String str) {
            this.f642a = locationManager;
            this.f643b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f642a.getLastKnownLocation(this.f643b);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Logger.d("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + currentTimeMillis2);
            return lastKnownLocation;
        }
    }

    @Nullable
    public static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d b(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseLocation()) {
            Context d4 = context == null ? bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (d4 == null) {
                return null;
            }
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d a4 = a(d4);
            if (c(d4)) {
                int a5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.c.a(d4, "android.permission.ACCESS_FINE_LOCATION");
                int a6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.c.a(d4, "android.permission.ACCESS_COARSE_LOCATION");
                if (a5 == 0 || a6 == 0) {
                    return d(d4);
                }
                return null;
            }
            return a4;
        }
        return null;
    }

    private static boolean c(Context context) {
        long a4 = r.a((String) null, context).a("lbstime", -1L);
        return a4 == -1 || System.currentTimeMillis() - a4 > f633a;
    }

    private static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d d(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d dVar = null;
        if (locationManager != null) {
            try {
                Location a4 = a(locationManager);
                if (a4 != null && b(a4)) {
                    b(context, a4);
                    dVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d((float) a4.getLatitude(), (float) a4.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new a(context, locationManager));
                } else {
                    b(context, locationManager);
                }
            } catch (Throwable th) {
                if (Logger.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
        return dVar;
    }

    @Nullable
    private static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d a(Context context) {
        r a4 = r.a((String) null, context);
        float a5 = a4.a("latitude", -1.0f);
        float a6 = a4.a("longitude", -1.0f);
        if (a5 == -1.0f || a6 == -1.0f) {
            return null;
        }
        return new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.d(a5, a6);
    }

    private static String b(LocationManager locationManager) {
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

    private static Location a(LocationManager locationManager) {
        Location a4 = a(locationManager, "gps");
        if (a4 == null) {
            a4 = a(locationManager, "network");
        }
        return a4 == null ? a(locationManager, "passive") : a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        b bVar = new b(context, locationManager);
        try {
            String b4 = b(locationManager);
            if (TextUtils.isEmpty(b4)) {
                return;
            }
            locationManager.requestSingleUpdate(b4, bVar, Looper.getMainLooper());
            f634b.postDelayed(new c(locationManager, bVar), PolicyConfig.mServerBusyRetryBaseInternal);
        } catch (Throwable th) {
            if (Logger.isDebug()) {
                th.printStackTrace();
            }
            b(locationManager, bVar);
        }
    }

    private static Location a(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new d(locationManager, str));
            f635c.execute(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            Logger.d("AdLocationUtils", "location:" + location);
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (Logger.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Location location) {
        if (b(location)) {
            r a4 = r.a((String) null, context);
            a4.b("latitude", (float) location.getLatitude());
            a4.b("longitude", (float) location.getLongitude());
            a4.b("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
