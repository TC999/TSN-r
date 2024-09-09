package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CollectController.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Boolean> f53297a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Object f53298b = new Object();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: CollectController.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f53299a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f53299a;
    }

    public void a() {
        synchronized (f53298b) {
            f53297a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (d.a(str)) {
            synchronized (f53298b) {
                if (f53297a.containsKey(str)) {
                    return f53297a.get(str).booleanValue();
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f53298b) {
                Map<String, Boolean> map = f53297a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
