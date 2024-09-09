package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PreFillQueue.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<d, Integer> f17201a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f17202b;

    /* renamed from: c  reason: collision with root package name */
    private int f17203c;

    /* renamed from: d  reason: collision with root package name */
    private int f17204d;

    public c(Map<d, Integer> map) {
        this.f17201a = map;
        this.f17202b = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.f17203c += num.intValue();
        }
    }

    public int a() {
        return this.f17203c;
    }

    public boolean b() {
        return this.f17203c == 0;
    }

    public d c() {
        d dVar = this.f17202b.get(this.f17204d);
        Integer num = this.f17201a.get(dVar);
        if (num.intValue() == 1) {
            this.f17201a.remove(dVar);
            this.f17202b.remove(this.f17204d);
        } else {
            this.f17201a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f17203c--;
        this.f17204d = this.f17202b.isEmpty() ? 0 : (this.f17204d + 1) % this.f17202b.size();
        return dVar;
    }
}
