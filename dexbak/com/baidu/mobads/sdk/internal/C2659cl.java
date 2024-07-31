package com.baidu.mobads.sdk.internal;

import com.github.mikephil.charting.utils.Utils;

/* renamed from: com.baidu.mobads.sdk.internal.cl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2659cl {

    /* renamed from: a */
    public static final String f8837a = "9.332";

    /* renamed from: b */
    public static final String f8838b = "";

    /* renamed from: c */
    public static final Boolean f8839c;

    /* renamed from: d */
    public static final Boolean f8840d;

    /* renamed from: e */
    public static final String f8841e = "9.332";

    /* renamed from: f */
    public static final int f8842f = 5000;

    /* renamed from: g */
    public static final Boolean f8843g;

    /* renamed from: h */
    public static String f8844h;

    static {
        Boolean bool = Boolean.FALSE;
        f8839c = bool;
        f8840d = Boolean.TRUE;
        f8843g = bool;
        f8844h = "adserv_0";
    }

    /* renamed from: a */
    public static String m50636a() {
        return f8844h;
    }

    /* renamed from: b */
    public static double m50635b() {
        try {
            return Double.parseDouble("9.332");
        } catch (Exception unused) {
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* renamed from: c */
    public static double m50634c() {
        try {
            return Double.parseDouble("9.332");
        } catch (Exception unused) {
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* renamed from: d */
    public static int m50633d() {
        try {
            return Integer.valueOf("9.332".split("\\.")[0]).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
