package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.p452c.C11078a;
import com.umeng.socialize.common.SocializeConstants;

/* renamed from: com.kwad.sdk.utils.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11123r {
    private static boolean aPa;
    private static C11078a aPb = new C11078a();

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    private static Location m23713a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, C7282g.f24949g) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
                if (lastKnownLocation == null) {
                    aPa = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aPa = true;
            C10331c.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private static Location m23712b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, C7282g.f24949g) == 0 || ContextCompat.checkSelfPermission(context, C7282g.f24950h) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation == null) {
                    aPa = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aPa = true;
            C10331c.printStackTraceOnly(e);
            return null;
        }
    }

    @Nullable
    /* renamed from: bV */
    public static C11078a m23711bV(Context context) {
        C11078a c11078a;
        C11078a c11078a2 = new C11078a();
        if (C11028au.m24075Mh() && C11028au.m24074Mi() != null) {
            c11078a2.aSm = C11028au.m24074Mi();
            c11078a2.type = 1;
            return c11078a2;
        } else if (!aPa && (((c11078a = aPb) == null || c11078a.aSm == null) && context != null)) {
            if (!C11028au.m24075Mh() && !((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(64L)) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
                    if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
                        aPb.aSm = m23713a(context, locationManager);
                    }
                    if (aPb == null && locationManager.isProviderEnabled("network")) {
                        aPb.aSm = m23712b(context, locationManager);
                    }
                    if (aPb == null && locationManager.isProviderEnabled("passive")) {
                        aPb.aSm = m23710c(context, locationManager);
                    }
                    C11078a c11078a3 = aPb;
                    c11078a3.type = 0;
                    return c11078a3;
                } catch (Exception e) {
                    aPa = true;
                    C10331c.printStackTraceOnly(e);
                }
            }
            return null;
        } else {
            return aPb;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: c */
    private static Location m23710c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, C7282g.f24950h) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation == null) {
                    aPa = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aPa = true;
            C10331c.printStackTraceOnly(e);
            return null;
        }
    }
}
