package com.amap.api.col.p047s;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;

/* compiled from: ConstConfig.java */
/* renamed from: com.amap.api.col.s.s1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2139s1 {

    /* renamed from: a */
    public static String f6466a = "9aj&#k81";

    /* renamed from: b */
    public static String f6467b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* renamed from: c */
    private static String f6468c = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09";

    /* renamed from: d */
    static byte[] f6469d;

    /* renamed from: e */
    public static boolean f6470e;

    /* renamed from: f */
    public static boolean f6471f;

    /* renamed from: g */
    private static volatile ConcurrentHashMap<String, String> f6472g = new ConcurrentHashMap<>(8);

    /* renamed from: h */
    public static final Integer f6473h = 1;

    /* renamed from: i */
    public static final Integer f6474i = 2;

    /* renamed from: j */
    public static final Integer f6475j = 3;

    /* renamed from: k */
    public static final Integer f6476k = 4;

    /* renamed from: l */
    public static final Integer f6477l = 5;

    /* renamed from: a */
    public static String m52470a(String str) {
        String str2 = "";
        try {
            synchronized (f6472g) {
                if (f6472g != null && f6472g.containsKey(str)) {
                    str2 = f6472g.get(str);
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    /* renamed from: b */
    public static void m52469b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f6472g) {
                    if (f6472g == null) {
                        f6472g = new ConcurrentHashMap<>(8);
                    }
                    if (!f6472g.containsKey(str)) {
                        f6472g.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static byte[] m52468c() {
        if (f6469d == null) {
            f6469d = C2040d1.m53090g(f6468c);
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f6469d, 40, bArr, 0, 4);
        int i = ((bArr[0] & UByte.f41242c) * 256) + (bArr[1] & UByte.f41242c);
        int i2 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(f6469d, i, bArr2, 0, i2);
        return bArr2;
    }
}
