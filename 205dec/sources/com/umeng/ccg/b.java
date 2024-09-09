package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CcgSwitch.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f53221a = true;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f53222b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f53223c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f53224d = true;

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, Boolean> f53226f = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private static Object f53225e = new Object();

    public static boolean a() {
        boolean z3;
        synchronized (f53225e) {
            z3 = f53221a;
        }
        return z3;
    }

    public static boolean b() {
        boolean z3;
        synchronized (f53225e) {
            z3 = f53222b;
        }
        return z3;
    }

    public static boolean c() {
        boolean z3;
        synchronized (f53225e) {
            z3 = f53223c;
        }
        return z3;
    }

    public static boolean d() {
        boolean z3;
        synchronized (f53225e) {
            z3 = f53224d;
        }
        return z3;
    }

    public static void a(boolean z3) {
        synchronized (f53225e) {
            f53224d = z3;
            f53226f.put("col_apl", Boolean.valueOf(z3));
        }
    }

    public static boolean a(String str) {
        boolean booleanValue;
        synchronized (f53225e) {
            booleanValue = f53226f.containsKey(str) ? f53226f.get(str).booleanValue() : true;
        }
        return booleanValue;
    }
}
