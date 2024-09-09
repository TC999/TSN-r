package com.tencent.open.b;

import com.tencent.open.utils.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected static e f51706a;

    protected e() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f51706a == null) {
                f51706a = new e();
            }
            eVar = f51706a;
        }
        return eVar;
    }

    public void a(int i4, String str, String str2, String str3, String str4, Long l4, int i5, int i6, String str5) {
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        h.a().a(m.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        h.a().a(m.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        h.a().a(m.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }
}
