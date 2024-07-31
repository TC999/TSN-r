package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12890c {

    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f36852a = new HashMap<>();

    /* renamed from: b */
    protected HashMap<String, Object> f36853b = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, Object> f36856e = new HashMap<>();

    /* renamed from: c */
    protected String f36854c = "GBK";

    /* renamed from: d */
    C12898k f36855d = new C12898k();

    /* renamed from: a */
    public void mo15665a(String str) {
        this.f36854c = str;
    }

    /* renamed from: a */
    public <T> void mo15661a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t != null) {
            if (!(t instanceof Set)) {
                C12900l c12900l = new C12900l();
                c12900l.m15594a(this.f36854c);
                c12900l.m15595a(t, 0);
                byte[] m15573a = C12902n.m15573a(c12900l.f36885a);
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList arrayList = new ArrayList(1);
                m15666a(arrayList, t);
                hashMap.put(C12785a.m16019a(arrayList), m15573a);
                this.f36856e.remove(str);
                this.f36852a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    /* renamed from: a */
    private static void m15666a(ArrayList<String> arrayList, Object obj) {
        while (true) {
            if (obj.getClass().isArray()) {
                if (obj.getClass().getComponentType().toString().equals("byte")) {
                    if (Array.getLength(obj) > 0) {
                        arrayList.add("java.util.List");
                        obj = Array.get(obj, 0);
                    } else {
                        arrayList.add("Array");
                        arrayList.add("?");
                        return;
                    }
                } else {
                    throw new IllegalArgumentException("only byte[] is supported");
                }
            } else if (!(obj instanceof Array)) {
                if (obj instanceof List) {
                    arrayList.add("java.util.List");
                    List list = (List) obj;
                    if (list.size() > 0) {
                        obj = list.get(0);
                    } else {
                        arrayList.add("?");
                        return;
                    }
                } else if (obj instanceof Map) {
                    arrayList.add("java.util.Map");
                    Map map = (Map) obj;
                    if (map.size() > 0) {
                        Object next = map.keySet().iterator().next();
                        obj = map.get(next);
                        arrayList.add(next.getClass().getName());
                    } else {
                        arrayList.add("?");
                        arrayList.add("?");
                        return;
                    }
                } else {
                    arrayList.add(obj.getClass().getName());
                    return;
                }
            } else {
                throw new IllegalArgumentException("can not support Array, please use List");
            }
        }
    }

    /* renamed from: a */
    public byte[] mo15662a() {
        C12900l c12900l = new C12900l(0);
        c12900l.m15594a(this.f36854c);
        c12900l.m15591a((Map) this.f36852a, 0);
        return C12902n.m15573a(c12900l.f36885a);
    }

    /* renamed from: a */
    public void mo15660a(byte[] bArr) {
        this.f36855d.m15615a(bArr);
        this.f36855d.m15620a(this.f36854c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f36852a = this.f36855d.m15618a((Map) hashMap, 0, false);
    }
}
