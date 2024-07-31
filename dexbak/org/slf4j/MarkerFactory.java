package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.C15428j;
import org.slf4j.impl.StaticMarkerBinder;

/* renamed from: org.slf4j.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MarkerFactory {

    /* renamed from: a */
    static IMarkerFactory f44341a;

    static {
        try {
            f44341a = m2615a();
        } catch (Exception e) {
            C15428j.m2565d("Unexpected failure while binding MarkerFactory", e);
        } catch (NoClassDefFoundError unused) {
            f44341a = new BasicMarkerFactory();
        }
    }

    private MarkerFactory() {
    }

    /* renamed from: a */
    private static IMarkerFactory m2615a() throws NoClassDefFoundError {
        try {
            return StaticMarkerBinder.m2546c().mo2548a();
        } catch (NoSuchMethodError unused) {
            return StaticMarkerBinder.f44373b.mo2548a();
        }
    }

    /* renamed from: b */
    public static Marker m2614b(String str) {
        return f44341a.mo2607c(str);
    }

    /* renamed from: c */
    public static IMarkerFactory m2613c() {
        return f44341a;
    }

    /* renamed from: d */
    public static Marker m2612d(String str) {
        return f44341a.mo2609a(str);
    }
}
