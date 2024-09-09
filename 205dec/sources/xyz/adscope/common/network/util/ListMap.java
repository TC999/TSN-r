package xyz.adscope.common.network.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ListMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public Map<K, List<V>> f65034a;

    public ListMap(Map<K, List<V>> map) {
        this.f65034a = map;
    }

    public void add(K k4, V v3) {
        if (!this.f65034a.containsKey(k4)) {
            this.f65034a.put(k4, new ArrayList(1));
        }
        this.f65034a.get(k4).add(v3);
    }

    public void add(K k4, List<V> list) {
        for (V v3 : list) {
            add((ListMap<K, V>) k4, (K) v3);
        }
    }

    public void clear() {
        this.f65034a.clear();
    }

    public boolean containsKey(K k4) {
        return this.f65034a.containsKey(k4);
    }

    public Set<Map.Entry<K, List<V>>> entrySet() {
        return this.f65034a.entrySet();
    }

    public List<V> get(K k4) {
        return this.f65034a.get(k4);
    }

    public V getFirst(K k4) {
        List<V> list = this.f65034a.get(k4);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return this.f65034a.isEmpty();
    }

    public Set<K> keySet() {
        return this.f65034a.keySet();
    }

    public List<V> remove(K k4) {
        return this.f65034a.remove(k4);
    }

    public void set(K k4, V v3) {
        this.f65034a.remove(k4);
        add((ListMap<K, V>) k4, (K) v3);
    }

    public void set(K k4, List<V> list) {
        this.f65034a.put(k4, list);
    }

    public int size() {
        return this.f65034a.size();
    }

    public Map<K, List<V>> toMap() {
        return this.f65034a;
    }
}
