package cn.jpush.android.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f4253a;

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager, boolean z3) {
        boolean z4 = !z3 || System.currentTimeMillis() - f4253a < PolicyConfig.mServerBusyRetryBaseInternal;
        if (locationManager != null && a(context, locationManager) && z4) {
            f4253a = System.currentTimeMillis();
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
            Location lastKnownLocation3 = locationManager.getLastKnownLocation("passive");
            Logger.v("GeoLocHelper", "gpsLocation:" + lastKnownLocation);
            Logger.v("GeoLocHelper", "netLocation:" + lastKnownLocation2);
            Logger.v("GeoLocHelper", "passLocation:" + lastKnownLocation3);
            long time = lastKnownLocation == null ? 0L : lastKnownLocation.getTime();
            long time2 = lastKnownLocation2 == null ? 0L : lastKnownLocation2.getTime();
            long time3 = lastKnownLocation3 != null ? lastKnownLocation3.getTime() : 0L;
            if (time > time2) {
                if (time > time3) {
                    return lastKnownLocation;
                }
            } else if (time2 > time3) {
                return lastKnownLocation2;
            }
            return lastKnownLocation3;
        }
        return null;
    }

    public static boolean a(Context context, LocationManager locationManager) {
        if (!cn.jpush.android.ad.a.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            Logger.w("GeoLocHelper", "Require the permissionandroid.permission.ACCESS_FINE_LOCATION");
            Logger.dd("GeoLocHelper", "No location permission!");
            return false;
        } else if (!JPushConstants.canGetLbsInBackGround(context)) {
            Logger.ww("GeoLocHelper", "can not get lbs in background");
            return false;
        } else if (!cn.jpush.android.cache.a.n(context)) {
            Logger.ww("GeoLocHelper", "lbs is disable by user");
            return false;
        } else {
            if (locationManager != null) {
                try {
                    if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
                        if (!locationManager.isProviderEnabled("passive")) {
                            return false;
                        }
                    }
                    return true;
                } catch (IllegalArgumentException unused) {
                    Logger.ww("GeoLocHelper", "The provider [gps] is illegal argument!");
                    return false;
                } catch (SecurityException unused2) {
                    Logger.ww("GeoLocHelper", "No suitable permission is present when get GPS_PROVIDER!");
                } catch (Throwable th) {
                    Logger.ww("GeoLocHelper", "Check GPS enable failed:" + th);
                    return false;
                }
            }
            return false;
        }
    }
}
