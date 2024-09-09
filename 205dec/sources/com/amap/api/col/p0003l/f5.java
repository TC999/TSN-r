package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ConstConfig.java */
/* renamed from: com.amap.api.col.3l.f5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f5 {

    /* renamed from: a  reason: collision with root package name */
    public static String f7706a = "9aj&#k81";

    /* renamed from: b  reason: collision with root package name */
    public static String f7707b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* renamed from: c  reason: collision with root package name */
    private static String f7708c = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09";

    /* renamed from: d  reason: collision with root package name */
    static byte[] f7709d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f7710e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f7711f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f7712g = new ConcurrentHashMap<>(8);

    /* renamed from: h  reason: collision with root package name */
    public static final Integer f7713h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final Integer f7714i = 2;

    /* renamed from: j  reason: collision with root package name */
    public static final Integer f7715j = 3;

    /* renamed from: k  reason: collision with root package name */
    public static final Integer f7716k = 4;

    /* renamed from: l  reason: collision with root package name */
    public static final Integer f7717l = 5;

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f7712g) {
                if (f7712g != null && f7712g.containsKey(str)) {
                    str2 = f7712g.get(str);
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    public static void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f7712g) {
                    if (f7712g == null) {
                        f7712g = new ConcurrentHashMap<>(8);
                    }
                    if (!f7712g.containsKey(str)) {
                        f7712g.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static byte[] c() {
        if (f7709d == null) {
            f7709d = j4.g(f7708c);
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f7709d, 40, bArr, 0, 4);
        int i4 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i5 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i5];
        System.arraycopy(f7709d, i4, bArr2, 0, i5);
        return bArr2;
    }
}
