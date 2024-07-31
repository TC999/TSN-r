package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.ccg.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CcgSwitch {

    /* renamed from: a */
    private static volatile boolean f38550a = true;

    /* renamed from: b */
    private static volatile boolean f38551b = true;

    /* renamed from: c */
    private static volatile boolean f38552c = true;

    /* renamed from: d */
    private static volatile boolean f38553d = true;

    /* renamed from: f */
    private static Map<String, Boolean> f38555f = new HashMap();

    /* renamed from: e */
    private static Object f38554e = new Object();

    /* renamed from: a */
    public static boolean m14107a() {
        boolean z;
        synchronized (f38554e) {
            z = f38550a;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m14104b() {
        boolean z;
        synchronized (f38554e) {
            z = f38551b;
        }
        return z;
    }

    /* renamed from: c */
    public static boolean m14103c() {
        boolean z;
        synchronized (f38554e) {
            z = f38552c;
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m14102d() {
        boolean z;
        synchronized (f38554e) {
            z = f38553d;
        }
        return z;
    }

    /* renamed from: a */
    public static void m14105a(boolean z) {
        synchronized (f38554e) {
            f38553d = z;
            f38555f.put(CcgConstant.f38534e, Boolean.valueOf(z));
        }
    }

    /* renamed from: a */
    public static boolean m14106a(String str) {
        boolean booleanValue;
        synchronized (f38554e) {
            booleanValue = f38555f.containsKey(str) ? f38555f.get(str).booleanValue() : true;
        }
        return booleanValue;
    }
}
