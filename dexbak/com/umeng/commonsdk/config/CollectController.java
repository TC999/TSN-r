package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.commonsdk.config.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CollectController implements IFieldWatcher {

    /* renamed from: a */
    private static Map<String, Boolean> f38626a = new HashMap();

    /* renamed from: b */
    private static Object f38627b = new Object();

    /* compiled from: CollectController.java */
    /* renamed from: com.umeng.commonsdk.config.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13207a {

        /* renamed from: a */
        private static final CollectController f38628a = new CollectController();

        private C13207a() {
        }
    }

    /* renamed from: b */
    public static CollectController m14022b() {
        return C13207a.f38628a;
    }

    /* renamed from: a */
    public void m14024a() {
        synchronized (f38627b) {
            f38626a.clear();
        }
    }

    private CollectController() {
    }

    /* renamed from: a */
    public static boolean m14023a(String str) {
        if (FieldTable.m14020a(str)) {
            synchronized (f38627b) {
                if (f38626a.containsKey(str)) {
                    return f38626a.get(str).booleanValue();
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.umeng.commonsdk.config.IFieldWatcher
    /* renamed from: a */
    public void mo14018a(String str, Boolean bool) {
        if (FieldTable.m14020a(str)) {
            synchronized (f38627b) {
                Map<String, Boolean> map = f38626a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
