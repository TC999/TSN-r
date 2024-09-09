package com.qq.e.comm.plugin.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class p2<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private Map<K, List<WeakReference<V>>> f46569a = new HashMap();

    public synchronized Collection<V> a(K k4) {
        List<WeakReference<V>> list = this.f46569a.get(k4);
        if (list != null && !list.isEmpty()) {
            Iterator<WeakReference<V>> it = list.iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                V v3 = it.next().get();
                if (v3 == null) {
                    it.remove();
                } else {
                    arrayList.add(v3);
                }
            }
            if (arrayList.isEmpty()) {
                this.f46569a.remove(k4);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public synchronized void a(K k4, V v3) {
        List<WeakReference<V>> list = this.f46569a.get(k4);
        if (list == null) {
            list = new ArrayList<>();
            this.f46569a.put(k4, list);
        }
        list.add(new WeakReference<>(v3));
    }

    public synchronized void a(String str, V v3) {
        List<WeakReference<V>> list = this.f46569a.get(str);
        if (list != null) {
            Iterator<WeakReference<V>> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().get() == v3) {
                    it.remove();
                }
            }
        }
    }
}
