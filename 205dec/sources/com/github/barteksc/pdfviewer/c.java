package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.github.barteksc.pdfviewer.util.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: CacheManager.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private final PriorityQueue<f1.b> f37210a;

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<f1.b> f37211b;

    /* renamed from: c  reason: collision with root package name */
    private final List<f1.b> f37212c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f37213d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final a f37214e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: CacheManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a implements Comparator<f1.b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f1.b bVar, f1.b bVar2) {
            if (bVar.a() == bVar2.a()) {
                return 0;
            }
            return bVar.a() > bVar2.a() ? 1 : -1;
        }
    }

    public c() {
        a aVar = new a();
        this.f37214e = aVar;
        this.f37211b = new PriorityQueue<>(b.a.f37307a, aVar);
        this.f37210a = new PriorityQueue<>(b.a.f37307a, aVar);
        this.f37212c = new ArrayList();
    }

    private void a(Collection<f1.b> collection, f1.b bVar) {
        for (f1.b bVar2 : collection) {
            if (bVar2.equals(bVar)) {
                bVar.d().recycle();
                return;
            }
        }
        collection.add(bVar);
    }

    @Nullable
    private static f1.b e(PriorityQueue<f1.b> priorityQueue, f1.b bVar) {
        Iterator<f1.b> it = priorityQueue.iterator();
        while (it.hasNext()) {
            f1.b next = it.next();
            if (next.equals(bVar)) {
                return next;
            }
        }
        return null;
    }

    private void h() {
        synchronized (this.f37213d) {
            while (this.f37211b.size() + this.f37210a.size() >= b.a.f37307a && !this.f37210a.isEmpty()) {
                this.f37210a.poll().d().recycle();
            }
            while (this.f37211b.size() + this.f37210a.size() >= b.a.f37307a && !this.f37211b.isEmpty()) {
                this.f37211b.poll().d().recycle();
            }
        }
    }

    public void b(f1.b bVar) {
        synchronized (this.f37213d) {
            h();
            this.f37211b.offer(bVar);
        }
    }

    public void c(f1.b bVar) {
        synchronized (this.f37212c) {
            while (this.f37212c.size() >= b.a.f37308b) {
                this.f37212c.remove(0).d().recycle();
            }
            a(this.f37212c, bVar);
        }
    }

    public boolean d(int i4, RectF rectF) {
        f1.b bVar = new f1.b(i4, null, rectF, true, 0);
        synchronized (this.f37212c) {
            for (f1.b bVar2 : this.f37212c) {
                if (bVar2.equals(bVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<f1.b> f() {
        ArrayList arrayList;
        synchronized (this.f37213d) {
            arrayList = new ArrayList(this.f37210a);
            arrayList.addAll(this.f37211b);
        }
        return arrayList;
    }

    public List<f1.b> g() {
        List<f1.b> list;
        synchronized (this.f37212c) {
            list = this.f37212c;
        }
        return list;
    }

    public void i() {
        synchronized (this.f37213d) {
            this.f37210a.addAll(this.f37211b);
            this.f37211b.clear();
        }
    }

    public void j() {
        synchronized (this.f37213d) {
            Iterator<f1.b> it = this.f37210a.iterator();
            while (it.hasNext()) {
                it.next().d().recycle();
            }
            this.f37210a.clear();
            Iterator<f1.b> it2 = this.f37211b.iterator();
            while (it2.hasNext()) {
                it2.next().d().recycle();
            }
            this.f37211b.clear();
        }
        synchronized (this.f37212c) {
            for (f1.b bVar : this.f37212c) {
                bVar.d().recycle();
            }
            this.f37212c.clear();
        }
    }

    public boolean k(int i4, RectF rectF, int i5) {
        f1.b bVar = new f1.b(i4, null, rectF, false, 0);
        synchronized (this.f37213d) {
            f1.b e4 = e(this.f37210a, bVar);
            boolean z3 = true;
            if (e4 != null) {
                this.f37210a.remove(e4);
                e4.f(i5);
                this.f37211b.offer(e4);
                return true;
            }
            if (e(this.f37211b, bVar) == null) {
                z3 = false;
            }
            return z3;
        }
    }
}
