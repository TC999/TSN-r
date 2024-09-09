package com.qq.e.comm.plugin.i0.l;

import com.qq.e.comm.plugin.util.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44246a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<g0> f44247b;

    /* renamed from: c  reason: collision with root package name */
    public long f44248c;

    /* renamed from: d  reason: collision with root package name */
    public long f44249d;

    /* renamed from: e  reason: collision with root package name */
    public int f44250e;

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<g0> copyOnWriteArrayList = this.f44247b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<g0> it = this.f44247b.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f46449a);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "DnsCacheObj{host='" + this.f44246a + "', ipList=" + this.f44247b + ", ttl=" + this.f44248c + ", updateTime=" + this.f44249d + ", from=" + this.f44250e + '}';
    }
}
