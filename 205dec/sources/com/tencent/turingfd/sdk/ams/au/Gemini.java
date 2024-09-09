package com.tencent.turingfd.sdk.ams.au;

import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Gemini implements LocationListener {

    /* renamed from: c  reason: collision with root package name */
    public static final Bryony<Gemini> f52067c = new Cdo();

    /* renamed from: a  reason: collision with root package name */
    public final Cif[] f52068a = new Cif[3];

    /* renamed from: b  reason: collision with root package name */
    public volatile int f52069b = 0;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Gemini$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo extends Bryony<Gemini> {
        @Override // com.tencent.turingfd.sdk.ams.au.Bryony
        public Gemini a() {
            return new Gemini();
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Gemini$if  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cif {

        /* renamed from: a  reason: collision with root package name */
        public long f52070a;

        /* renamed from: b  reason: collision with root package name */
        public String f52071b;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f52068a) {
            int i4 = this.f52069b;
            do {
                Cif cif = this.f52068a[this.f52069b];
                if (cif == null) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(cif.f52070a);
                sb.append(":");
                sb.append(cif.f52071b);
                i4 = (i4 + 1) % this.f52068a.length;
            } while (i4 != this.f52069b);
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (Build.VERSION.SDK_INT >= 18 && location != null && location.isFromMockProvider()) {
            synchronized (this.f52068a) {
                Cif cif = this.f52068a[this.f52069b];
                if (cif == null) {
                    cif = new Cif();
                    this.f52068a[this.f52069b] = cif;
                }
                this.f52069b = (this.f52069b + 1) % this.f52068a.length;
                cif.f52070a = System.currentTimeMillis();
                cif.f52071b = location.getProvider();
            }
        }
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
