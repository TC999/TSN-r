package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p595g2.MDCAdapter;

/* renamed from: org.slf4j.helpers.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class BasicMDCAdapter implements MDCAdapter {

    /* renamed from: a */
    private InheritableThreadLocal<Map<String, String>> f44342a = new C15427a();

    /* compiled from: BasicMDCAdapter.java */
    /* renamed from: org.slf4j.helpers.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15427a extends InheritableThreadLocal<Map<String, String>> {
        C15427a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.InheritableThreadLocal
        /* renamed from: a */
        public Map<String, String> childValue(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            return new HashMap(map);
        }
    }

    @Override // p595g2.MDCAdapter
    /* renamed from: a */
    public void mo2583a(String str, String str2) {
        if (str != null) {
            Map<String, String> map = this.f44342a.get();
            if (map == null) {
                map = new HashMap<>();
                this.f44342a.set(map);
            }
            map.put(str, str2);
            return;
        }
        throw new IllegalArgumentException("key cannot be null");
    }

    @Override // p595g2.MDCAdapter
    /* renamed from: b */
    public Map<String, String> mo2582b() {
        Map<String, String> map = this.f44342a.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @Override // p595g2.MDCAdapter
    /* renamed from: c */
    public void mo2581c(Map<String, String> map) {
        this.f44342a.set(new HashMap(map));
    }

    @Override // p595g2.MDCAdapter
    public void clear() {
        Map<String, String> map = this.f44342a.get();
        if (map != null) {
            map.clear();
            this.f44342a.remove();
        }
    }

    /* renamed from: d */
    public Set<String> m2611d() {
        Map<String, String> map = this.f44342a.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override // p595g2.MDCAdapter
    public String get(String str) {
        Map<String, String> map = this.f44342a.get();
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // p595g2.MDCAdapter
    public void remove(String str) {
        Map<String, String> map = this.f44342a.get();
        if (map != null) {
            map.remove(str);
        }
    }
}
