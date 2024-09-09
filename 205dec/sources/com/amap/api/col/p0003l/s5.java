package com.amap.api.col.p0003l;

import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.amap.api.col.p0003l.Cif;
import com.autonavi.aps.amapapi.utils.d;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LogUpdateRequest.java */
/* renamed from: com.amap.api.col.3l.s5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s5 extends l4 {

    /* renamed from: i  reason: collision with root package name */
    private byte[] f8940i;

    /* renamed from: j  reason: collision with root package name */
    private String f8941j;

    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.s5$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class a extends GnssStatus.Callback {
        a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i4) {
            s5.I();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            s5.k(s5.this, gnssStatus);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            s5.H();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            s5.i(s5.this);
        }
    }

    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.s5$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class b implements GpsStatus.Listener {
        b() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i4) {
            try {
                s5 s5Var = s5.this;
                LocationManager locationManager = s5Var.c;
                if (locationManager == null) {
                    return;
                }
                s5.a(s5Var, locationManager.getGpsStatus(s5.s(s5Var)));
                if (i4 == 1) {
                    s5.H();
                } else if (i4 == 2) {
                    s5.i(s5.this);
                } else if (i4 == 3) {
                    s5.I();
                } else if (i4 != 4) {
                } else {
                    s5.y(s5.this);
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                d.a();
                com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.s5$c */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class c implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private s5 f8944a;

        c(s5 s5Var) {
            this.f8944a = s5Var;
        }

        final void a() {
            this.f8944a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                d.a();
                s5 s5Var = this.f8944a;
                if (s5Var != null) {
                    s5.l(s5Var, location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                s5 s5Var = this.f8944a;
                if (s5Var != null) {
                    s5.m(s5Var, str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i4, Bundle bundle) {
            try {
                s5 s5Var = this.f8944a;
                if (s5Var != null) {
                    s5.j(s5Var, i4);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public s5(byte[] bArr, String str) {
        this.f8941j = "1";
        this.f8940i = (byte[]) bArr.clone();
        this.f8941j = str;
        setDegradeAbility(Cif.a.SINGLE);
        setHttpProtocol(Cif.c.HTTP);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        return this.f8940i;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f8940i.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        String u3 = q4.u(f5.f7707b);
        byte[] o4 = q4.o(f5.f7706a);
        byte[] bArr = new byte[o4.length + 50];
        System.arraycopy(this.f8940i, 0, bArr, 0, 50);
        System.arraycopy(o4, 0, bArr, 50, o4.length);
        return String.format(u3, "1", this.f8941j, "1", "open", m4.b(bArr));
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isHostToIP() {
        return false;
    }
}
