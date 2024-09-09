package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BasicMDCAdapter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a implements l3.c {

    /* renamed from: a  reason: collision with root package name */
    private InheritableThreadLocal<Map<String, String>> f61742a = new C1252a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BasicMDCAdapter.java */
    /* renamed from: org.slf4j.helpers.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class C1252a extends InheritableThreadLocal<Map<String, String>> {
        C1252a() {
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

    @Override // l3.c
    public void a(String str, String str2) {
        if (str != null) {
            Map<String, String> map = this.f61742a.get();
            if (map == null) {
                map = new HashMap<>();
                this.f61742a.set(map);
            }
            map.put(str, str2);
            return;
        }
        throw new IllegalArgumentException("key cannot be null");
    }

    @Override // l3.c
    public Map<String, String> b() {
        Map<String, String> map = this.f61742a.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @Override // l3.c
    public void c(Map<String, String> map) {
        this.f61742a.set(new HashMap(map));
    }

    @Override // l3.c
    public void clear() {
        Map<String, String> map = this.f61742a.get();
        if (map != null) {
            map.clear();
            this.f61742a.remove();
        }
    }

    public Set<String> d() {
        Map<String, String> map = this.f61742a.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override // l3.c
    public String get(String str) {
        Map<String, String> map = this.f61742a.get();
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // l3.c
    public void remove(String str) {
        Map<String, String> map = this.f61742a.get();
        if (map != null) {
            map.remove(str);
        }
    }
}
