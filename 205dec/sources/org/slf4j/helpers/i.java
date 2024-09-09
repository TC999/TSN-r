package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SubstituteLoggerFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i implements org.slf4j.a {

    /* renamed from: a  reason: collision with root package name */
    boolean f61760a = false;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, h> f61761b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final LinkedBlockingQueue<org.slf4j.event.d> f61762c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.a
    public synchronized org.slf4j.c a(String str) {
        h hVar;
        hVar = this.f61761b.get(str);
        if (hVar == null) {
            hVar = new h(str, this.f61762c, this.f61760a);
            this.f61761b.put(str, hVar);
        }
        return hVar;
    }

    public void b() {
        this.f61761b.clear();
        this.f61762c.clear();
    }

    public LinkedBlockingQueue<org.slf4j.event.d> c() {
        return this.f61762c;
    }

    public List<String> d() {
        return new ArrayList(this.f61761b.keySet());
    }

    public List<h> e() {
        return new ArrayList(this.f61761b.values());
    }

    public void f() {
        this.f61760a = true;
    }
}
