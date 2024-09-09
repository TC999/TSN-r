package com.amap.api.col.p0003l;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.autonavi.aps.amapapi.utils.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDConfig.java */
/* renamed from: com.amap.api.col.3l.s4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s4 {

    /* renamed from: a  reason: collision with root package name */
    public static long f8935a = 86400000;

    /* renamed from: b  reason: collision with root package name */
    public static long f8936b = 86400000;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8937c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f8938d = true;

    /* compiled from: CoarseLocation.java */
    /* renamed from: com.amap.api.col.3l.s4$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class a implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private s4 f8939a;

        a(s4 s4Var) {
            this.f8939a = s4Var;
        }

        final void a() {
            this.f8939a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                s4 s4Var = this.f8939a;
                if (s4Var != null) {
                    s4.i(s4Var, location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                s4 s4Var = this.f8939a;
                if (s4Var != null) {
                    s4.g(s4Var);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            if ("gps".equalsIgnoreCase(str)) {
                d.a();
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i4, Bundle bundle) {
            try {
                s4 s4Var = this.f8939a;
                if (s4Var != null) {
                    s4.h(s4Var, i4);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
