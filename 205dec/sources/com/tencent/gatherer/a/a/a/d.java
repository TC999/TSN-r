package com.tencent.gatherer.a.a.a;

import android.util.Log;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f51543a = "Gatherer";

    /* renamed from: b  reason: collision with root package name */
    private static e f51544b = new a();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements e {
        a() {
        }

        @Override // com.tencent.gatherer.a.a.a.e
        public void a(String str, String str2) {
        }

        @Override // com.tencent.gatherer.a.a.a.e
        public void a(String str, String str2, Throwable th) {
        }

        @Override // com.tencent.gatherer.a.a.a.e
        public void b(String str, String str2) {
        }
    }

    public static void a(String str) {
        e eVar = f51544b;
        if (eVar != null) {
            eVar.b(f51543a, str);
        } else {
            Log.d(f51543a, str);
        }
    }

    public static void b(String str) {
        e eVar = f51544b;
        if (eVar != null) {
            eVar.a(f51543a, str);
        } else {
            Log.e(f51543a, str);
        }
    }

    public static void a(String str, Throwable th) {
        e eVar = f51544b;
        if (eVar != null) {
            eVar.a(f51543a, str, th);
        } else {
            Log.e(f51543a, str, th);
        }
    }
}
