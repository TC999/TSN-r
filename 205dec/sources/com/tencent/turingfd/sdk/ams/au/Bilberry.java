package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import com.tencent.turingfd.sdk.ams.au.Longan;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Bilberry {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Longan f51926a;

    public static Longan a(String str) {
        Longan longan;
        try {
            longan = new Longan(str);
            try {
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 14 && i4 < 20) {
                    synchronized (longan) {
                        synchronized (longan) {
                            longan.a(new Longan.Cfor("export LD_LIBRARY_PATH=/vendor/lib:/system/lib", "export LD_LIBRARY_PATH=/vendor/lib:/system/lib", 5000L));
                        }
                    }
                }
            } catch (Exception unused) {
                if (longan != null) {
                    try {
                        longan.a();
                        return null;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                return longan;
            }
        } catch (Exception unused3) {
            longan = null;
        }
        return longan;
    }

    public static Longan.Cif b(String str) {
        Longan.Cfor cfor = new Longan.Cfor(str, str, 5000L);
        Longan.Cif cif = null;
        try {
            if (f51926a == null) {
                synchronized (Bilberry.class) {
                    if (f51926a == null) {
                        f51926a = a("sh");
                    }
                }
            }
            cif = f51926a.a(cfor);
        } catch (Exception e4) {
            if (((e4 instanceof IOException) || (e4 instanceof InterruptedException)) && f51926a != null) {
                synchronized (Bilberry.class) {
                    if (f51926a != null) {
                        Longan longan = f51926a;
                        longan.getClass();
                        try {
                            longan.a();
                        } catch (Throwable unused) {
                        }
                        f51926a = null;
                    }
                }
            }
        }
        return cif == null ? new Longan.Cif(cfor.f52135a, 2, "", "e") : cif;
    }
}
