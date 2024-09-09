package org.slf4j;

import org.slf4j.helpers.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MarkerFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static b f61741a;

    static {
        try {
            f61741a = a();
        } catch (Exception e4) {
            j.d("Unexpected failure while binding MarkerFactory", e4);
        } catch (NoClassDefFoundError unused) {
            f61741a = new org.slf4j.helpers.b();
        }
    }

    private f() {
    }

    private static b a() throws NoClassDefFoundError {
        try {
            return org.slf4j.impl.e.c().a();
        } catch (NoSuchMethodError unused) {
            return org.slf4j.impl.e.f61773b.a();
        }
    }

    public static Marker b(String str) {
        return f61741a.c(str);
    }

    public static b c() {
        return f61741a;
    }

    public static Marker d(String str) {
        return f61741a.a(str);
    }
}
