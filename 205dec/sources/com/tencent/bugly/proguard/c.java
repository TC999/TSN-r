package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f51219a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    protected HashMap<String, Object> f51220b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f51223e = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    protected String f51221c = "GBK";

    /* renamed from: d  reason: collision with root package name */
    k f51222d = new k();

    public void a(String str) {
        this.f51221c = str;
    }

    public <T> void a(String str, T t3) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t3 != null) {
            if (!(t3 instanceof Set)) {
                l lVar = new l();
                lVar.a(this.f51221c);
                lVar.a(t3, 0);
                byte[] a4 = n.a(lVar.f51252a);
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList arrayList = new ArrayList(1);
                a(arrayList, t3);
                hashMap.put(a.a(arrayList), a4);
                this.f51223e.remove(str);
                this.f51219a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    private static void a(ArrayList<String> arrayList, Object obj) {
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

    public byte[] a() {
        l lVar = new l(0);
        lVar.a(this.f51221c);
        lVar.a((Map) this.f51219a, 0);
        return n.a(lVar.f51252a);
    }

    public void a(byte[] bArr) {
        this.f51222d.a(bArr);
        this.f51222d.a(this.f51221c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f51219a = this.f51222d.a((Map) hashMap, 0, false);
    }
}
