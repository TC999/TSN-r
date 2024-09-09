package com.qq.e.comm.plugin.n0;

import android.content.Context;
import com.qq.e.comm.plugin.n0.o;
import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a<T extends o> {

    /* renamed from: a  reason: collision with root package name */
    Context f44725a;

    /* renamed from: b  reason: collision with root package name */
    List<T> f44726b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private long f44727c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f44728d;

    public a(Context context) {
        this.f44725a = context;
    }

    private void e(List<T> list) {
        pro.getVresult(484, 0, this, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        d1.a("Start commit stat data", new Object[0]);
        List<T> arrayList = new ArrayList<>(this.f44726b);
        List<T> b4 = b();
        if (b4 != null && b4.size() > 0) {
            arrayList.addAll(b4);
        }
        if (arrayList.size() > 0) {
            e(arrayList);
        }
    }

    abstract void a(Set<Integer> set);

    abstract List<T> b();

    void b(List<T> list) {
        d1.a("Send stat success", new Object[0]);
        this.f44727c = System.currentTimeMillis() / 1000;
        HashSet hashSet = new HashSet();
        for (T t3 : list) {
            if (t3 != null) {
                if (t3.getId() >= 0) {
                    hashSet.add(Integer.valueOf(t3.getId()));
                }
                this.f44726b.remove(t3);
            }
        }
        a(hashSet);
    }

    long c() {
        return this.f44727c;
    }

    abstract void c(List<T> list);

    abstract void d(List<T> list);

    protected boolean d() {
        return this.f44728d;
    }

    abstract boolean e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (e()) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        ArrayList arrayList = new ArrayList(this.f44726b);
        this.f44726b.clear();
        c(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(T t3) {
        if (t3 == null) {
            return;
        }
        if (this.f44726b.size() >= 1000) {
            Iterator<T> it = this.f44726b.iterator();
            for (int size = (this.f44726b.size() - 1000) + 1; size > 0 && it.hasNext(); size--) {
                it.next();
                it.remove();
            }
        }
        this.f44726b.add(t3);
        d1.a("Add stat data: " + t3 + ", total: " + this.f44726b.size(), new Object[0]);
    }

    void a(List<T> list) {
        d1.a("Send stat failed", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        this.f44728d = z3;
    }
}
