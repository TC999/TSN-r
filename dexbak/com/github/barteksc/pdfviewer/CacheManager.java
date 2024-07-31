package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.github.barteksc.pdfviewer.util.C6663b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import p616l0.PagePart;

/* renamed from: com.github.barteksc.pdfviewer.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
class CacheManager {

    /* renamed from: a */
    private final PriorityQueue<PagePart> f23641a;

    /* renamed from: b */
    private final PriorityQueue<PagePart> f23642b;

    /* renamed from: c */
    private final List<PagePart> f23643c;

    /* renamed from: d */
    private final Object f23644d = new Object();

    /* renamed from: e */
    private final C6654a f23645e;

    /* compiled from: CacheManager.java */
    /* renamed from: com.github.barteksc.pdfviewer.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6654a implements Comparator<PagePart> {
        C6654a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PagePart pagePart, PagePart pagePart2) {
            if (pagePart.m3469a() == pagePart2.m3469a()) {
                return 0;
            }
            return pagePart.m3469a() > pagePart2.m3469a() ? 1 : -1;
        }
    }

    public CacheManager() {
        C6654a c6654a = new C6654a();
        this.f23645e = c6654a;
        this.f23642b = new PriorityQueue<>(C6663b.C6664a.f23738a, c6654a);
        this.f23641a = new PriorityQueue<>(C6663b.C6664a.f23738a, c6654a);
        this.f23643c = new ArrayList();
    }

    /* renamed from: a */
    private void m35385a(Collection<PagePart> collection, PagePart pagePart) {
        for (PagePart pagePart2 : collection) {
            if (pagePart2.equals(pagePart)) {
                pagePart.m3466d().recycle();
                return;
            }
        }
        collection.add(pagePart);
    }

    @Nullable
    /* renamed from: e */
    private static PagePart m35381e(PriorityQueue<PagePart> priorityQueue, PagePart pagePart) {
        Iterator<PagePart> it = priorityQueue.iterator();
        while (it.hasNext()) {
            PagePart next = it.next();
            if (next.equals(pagePart)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: h */
    private void m35378h() {
        synchronized (this.f23644d) {
            while (this.f23642b.size() + this.f23641a.size() >= C6663b.C6664a.f23738a && !this.f23641a.isEmpty()) {
                this.f23641a.poll().m3466d().recycle();
            }
            while (this.f23642b.size() + this.f23641a.size() >= C6663b.C6664a.f23738a && !this.f23642b.isEmpty()) {
                this.f23642b.poll().m3466d().recycle();
            }
        }
    }

    /* renamed from: b */
    public void m35384b(PagePart pagePart) {
        synchronized (this.f23644d) {
            m35378h();
            this.f23642b.offer(pagePart);
        }
    }

    /* renamed from: c */
    public void m35383c(PagePart pagePart) {
        synchronized (this.f23643c) {
            while (this.f23643c.size() >= C6663b.C6664a.f23739b) {
                this.f23643c.remove(0).m3466d().recycle();
            }
            m35385a(this.f23643c, pagePart);
        }
    }

    /* renamed from: d */
    public boolean m35382d(int i, RectF rectF) {
        PagePart pagePart = new PagePart(i, null, rectF, true, 0);
        synchronized (this.f23643c) {
            for (PagePart pagePart2 : this.f23643c) {
                if (pagePart2.equals(pagePart)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: f */
    public List<PagePart> m35380f() {
        ArrayList arrayList;
        synchronized (this.f23644d) {
            arrayList = new ArrayList(this.f23641a);
            arrayList.addAll(this.f23642b);
        }
        return arrayList;
    }

    /* renamed from: g */
    public List<PagePart> m35379g() {
        List<PagePart> list;
        synchronized (this.f23643c) {
            list = this.f23643c;
        }
        return list;
    }

    /* renamed from: i */
    public void m35377i() {
        synchronized (this.f23644d) {
            this.f23641a.addAll(this.f23642b);
            this.f23642b.clear();
        }
    }

    /* renamed from: j */
    public void m35376j() {
        synchronized (this.f23644d) {
            Iterator<PagePart> it = this.f23641a.iterator();
            while (it.hasNext()) {
                it.next().m3466d().recycle();
            }
            this.f23641a.clear();
            Iterator<PagePart> it2 = this.f23642b.iterator();
            while (it2.hasNext()) {
                it2.next().m3466d().recycle();
            }
            this.f23642b.clear();
        }
        synchronized (this.f23643c) {
            for (PagePart pagePart : this.f23643c) {
                pagePart.m3466d().recycle();
            }
            this.f23643c.clear();
        }
    }

    /* renamed from: k */
    public boolean m35375k(int i, RectF rectF, int i2) {
        PagePart pagePart = new PagePart(i, null, rectF, false, 0);
        synchronized (this.f23644d) {
            PagePart m35381e = m35381e(this.f23641a, pagePart);
            boolean z = true;
            if (m35381e != null) {
                this.f23641a.remove(m35381e);
                m35381e.m3464f(i2);
                this.f23642b.offer(m35381e);
                return true;
            }
            if (m35381e(this.f23642b, pagePart) == null) {
                z = false;
            }
            return z;
        }
    }
}
