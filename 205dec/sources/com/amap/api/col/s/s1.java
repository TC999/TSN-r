package com.amap.api.col.s;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ConstConfig.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    public static String f10194a = "9aj&#k81";

    /* renamed from: b  reason: collision with root package name */
    public static String f10195b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* renamed from: c  reason: collision with root package name */
    private static String f10196c = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09";

    /* renamed from: d  reason: collision with root package name */
    static byte[] f10197d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f10198e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f10199f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f10200g = new ConcurrentHashMap<>(8);

    /* renamed from: h  reason: collision with root package name */
    public static final Integer f10201h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final Integer f10202i = 2;

    /* renamed from: j  reason: collision with root package name */
    public static final Integer f10203j = 3;

    /* renamed from: k  reason: collision with root package name */
    public static final Integer f10204k = 4;

    /* renamed from: l  reason: collision with root package name */
    public static final Integer f10205l = 5;

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f10200g) {
                if (f10200g != null && f10200g.containsKey(str)) {
                    str2 = f10200g.get(str);
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    public static void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f10200g) {
                    if (f10200g == null) {
                        f10200g = new ConcurrentHashMap<>(8);
                    }
                    if (!f10200g.containsKey(str)) {
                        f10200g.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static byte[] c() {
        if (f10197d == null) {
            f10197d = d1.g(f10196c);
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f10197d, 40, bArr, 0, 4);
        int i4 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i5 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i5];
        System.arraycopy(f10197d, i4, bArr2, 0, i5);
        return bArr2;
    }
}
