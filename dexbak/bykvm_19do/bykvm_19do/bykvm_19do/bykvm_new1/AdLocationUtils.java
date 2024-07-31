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
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionActivityCompat;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.msdk.adapter.util.Logger;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdLocationUtils {

    /* renamed from: a */
    private static long f640a = 1800000;

    /* renamed from: b */
    private static Handler f641b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static ExecutorService f642c = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdLocationUtils.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.e$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class RunnableC0982a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f643a;

        /* renamed from: b */
        final /* synthetic */ LocationManager f644b;

        RunnableC0982a(Context context, LocationManager locationManager) {
            this.f643a = context;
            this.f644b = locationManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdLocationUtils.m59241b(this.f643a, this.f644b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdLocationUtils.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.e$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C0983b implements LocationListener {

        /* renamed from: a */
        final /* synthetic */ Context f645a;

        /* renamed from: b */
        final /* synthetic */ LocationManager f646b;

        C0983b(Context context, LocationManager locationManager) {
            this.f645a = context;
            this.f646b = locationManager;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null && AdLocationUtils.m59240b(location)) {
                AdLocationUtils.m59242b(this.f645a, location);
            }
            AdLocationUtils.m59238b(this.f646b, this);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdLocationUtils.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.e$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class RunnableC0984c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ LocationManager f647a;

        /* renamed from: b */
        final /* synthetic */ LocationListener f648b;

        RunnableC0984c(LocationManager locationManager, LocationListener locationListener) {
            this.f647a = locationManager;
            this.f648b = locationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdLocationUtils.m59238b(this.f647a, this.f648b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdLocationUtils.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.e$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class CallableC0985d implements Callable<Location> {

        /* renamed from: a */
        private LocationManager f649a;

        /* renamed from: b */
        private String f650b;

        public CallableC0985d(LocationManager locationManager, String str) {
            this.f649a = locationManager;
            this.f650b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f649a.getLastKnownLocation(this.f650b);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Logger.m37562d("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + currentTimeMillis2);
            return lastKnownLocation;
        }
    }

    @Nullable
    /* renamed from: b */
    public static AdLocation m59243b(Context context) {
        if (SdkGlobalInfo.m59939B().m59897p().isCanUseLocation()) {
            Context m59945d = context == null ? InternalContainer.m59945d() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (m59945d == null) {
                return null;
            }
            AdLocation m59250a = m59250a(m59945d);
            if (m59237c(m59945d)) {
                int m59825a = PermissionActivityCompat.m59825a(m59945d, C7282g.f24949g);
                int m59825a2 = PermissionActivityCompat.m59825a(m59945d, C7282g.f24950h);
                if (m59825a == 0 || m59825a2 == 0) {
                    return m59236d(m59945d);
                }
                return null;
            }
            return m59250a;
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m59237c(Context context) {
        long m59132a = SPUtils.m59131a((String) null, context).m59132a("lbstime", -1L);
        return m59132a == -1 || System.currentTimeMillis() - m59132a > f640a;
    }

    /* renamed from: d */
    private static AdLocation m59236d(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        AdLocation adLocation = null;
        if (locationManager != null) {
            try {
                Location m59246a = m59246a(locationManager);
                if (m59246a != null && m59240b(m59246a)) {
                    m59242b(context, m59246a);
                    adLocation = new AdLocation((float) m59246a.getLatitude(), (float) m59246a.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0982a(context, locationManager));
                } else {
                    m59241b(context, locationManager);
                }
            } catch (Throwable th) {
                if (Logger.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
        return adLocation;
    }

    @Nullable
    /* renamed from: a */
    private static AdLocation m59250a(Context context) {
        SPUtils m59131a = SPUtils.m59131a((String) null, context);
        float m59134a = m59131a.m59134a("latitude", -1.0f);
        float m59134a2 = m59131a.m59134a("longitude", -1.0f);
        if (m59134a == -1.0f || m59134a2 == -1.0f) {
            return null;
        }
        return new AdLocation(m59134a, m59134a2);
    }

    /* renamed from: b */
    private static String m59239b(LocationManager locationManager) {
        if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
            return GeocodeSearch.GPS;
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* renamed from: a */
    private static Location m59246a(LocationManager locationManager) {
        Location m59244a = m59244a(locationManager, GeocodeSearch.GPS);
        if (m59244a == null) {
            m59244a = m59244a(locationManager, "network");
        }
        return m59244a == null ? m59244a(locationManager, "passive") : m59244a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m59241b(Context context, LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        C0983b c0983b = new C0983b(context, locationManager);
        try {
            String m59239b = m59239b(locationManager);
            if (TextUtils.isEmpty(m59239b)) {
                return;
            }
            locationManager.requestSingleUpdate(m59239b, c0983b, Looper.getMainLooper());
            f641b.postDelayed(new RunnableC0984c(locationManager, c0983b), 30000L);
        } catch (Throwable th) {
            if (Logger.isDebug()) {
                th.printStackTrace();
            }
            m59238b(locationManager, c0983b);
        }
    }

    /* renamed from: a */
    private static Location m59244a(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new CallableC0985d(locationManager, str));
            f642c.execute(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            Logger.m37562d("AdLocationUtils", "location:" + location);
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m59238b(LocationManager locationManager, LocationListener locationListener) {
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
    /* renamed from: b */
    public static void m59242b(Context context, Location location) {
        if (m59240b(location)) {
            SPUtils m59131a = SPUtils.m59131a((String) null, context);
            m59131a.m59126b("latitude", (float) location.getLatitude());
            m59131a.m59126b("longitude", (float) location.getLongitude());
            m59131a.m59124b("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m59240b(Location location) {
        return (location.getLatitude() == Utils.DOUBLE_EPSILON || location.getLongitude() == Utils.DOUBLE_EPSILON) ? false : true;
    }
}
