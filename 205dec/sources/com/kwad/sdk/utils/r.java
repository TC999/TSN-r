package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class r {
    private static boolean aPa;
    private static com.kwad.sdk.utils.c.a aPb = new com.kwad.sdk.utils.c.a();

    @SuppressLint({"MissingPermission"})
    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    aPa = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e4) {
            aPa = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation == null) {
                    aPa = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e4) {
            aPa = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            return null;
        }
    }

    @Nullable
    public static com.kwad.sdk.utils.c.a bV(Context context) {
        com.kwad.sdk.utils.c.a aVar;
        com.kwad.sdk.utils.c.a aVar2 = new com.kwad.sdk.utils.c.a();
        if (au.Mh() && au.Mi() != null) {
            aVar2.aSm = au.Mi();
            aVar2.type = 1;
            return aVar2;
        } else if (!aPa && (((aVar = aPb) == null || aVar.aSm == null) && context != null)) {
            if (!au.Mh() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(64L)) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        aPb.aSm = a(context, locationManager);
                    }
                    if (aPb == null && locationManager.isProviderEnabled("network")) {
                        aPb.aSm = b(context, locationManager);
                    }
                    if (aPb == null && locationManager.isProviderEnabled("passive")) {
                        aPb.aSm = c(context, locationManager);
                    }
                    com.kwad.sdk.utils.c.a aVar3 = aPb;
                    aVar3.type = 0;
                    return aVar3;
                } catch (Exception e4) {
                    aPa = true;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                }
            }
            return null;
        } else {
            return aPb;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation == null) {
                    aPa = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e4) {
            aPa = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            return null;
        }
    }
}
