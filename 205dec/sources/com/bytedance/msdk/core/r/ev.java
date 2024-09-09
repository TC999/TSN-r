package com.bytedance.msdk.core.r;

import android.text.TextUtils;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.yu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, Boolean> f28097c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private final Map<Integer, AtomicInteger> f28100w = new HashMap();
    private final AtomicInteger xv = new AtomicInteger();
    private final AtomicBoolean sr = new AtomicBoolean(false);
    private final AtomicInteger ux = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    private final List<Integer> f28098f = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private final AtomicInteger f28099r = new AtomicInteger();
    private final List<String> ev = new CopyOnWriteArrayList();
    private final AtomicBoolean gd = new AtomicBoolean(false);

    public void c(boolean z3) {
        this.sr.set(z3);
    }

    public synchronized boolean ev() {
        return this.gd.get();
    }

    int f() {
        int i4;
        synchronized (this) {
            i4 = this.xv.get();
        }
        return i4;
    }

    public synchronized boolean r() {
        boolean z3;
        if (f() == 0) {
            z3 = sr() == 0;
        }
        return z3;
    }

    int sr() {
        int i4;
        synchronized (this) {
            i4 = this.ux.get();
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void ux() {
        this.ux.set(0);
        this.xv.set(0);
        this.f28097c.clear();
        this.f28100w.clear();
        this.sr.set(false);
        this.ev.clear();
        this.f28098f.clear();
        this.gd.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i4) {
        this.f28099r.set(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv() {
        synchronized (this) {
            if (this.f28099r.get() != 0) {
                this.f28099r.decrementAndGet();
            }
        }
    }

    public boolean c() {
        return this.sr.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w() {
        return this.f28099r.get();
    }

    public void c(int i4) {
        this.ux.set(i4);
    }

    public synchronized void w(boolean z3) {
        this.gd.set(z3);
    }

    public void c(String str) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                this.ev.add(str);
            }
            if (this.ux.get() != 0) {
                this.ux.decrementAndGet();
            } else {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "decrementTotalWaterFall--waterfall\u6570\u91cf\u51cf\u5c11\u4e00\u4e2a ---\u4e0d\u7528\u518d\u51cf\u4e86\u4e0d\u7136\u5c31\u53d8\u6210-1\u4e86");
            }
        }
    }

    public synchronized void f(int i4) {
        this.f28098f.add(Integer.valueOf(i4));
    }

    public synchronized int sr(int i4) {
        AtomicInteger atomicInteger;
        atomicInteger = this.f28100w.get(Integer.valueOf(i4));
        return atomicInteger != null ? atomicInteger.get() : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            AtomicInteger atomicInteger = new AtomicInteger();
            for (Integer num : list) {
                Boolean bool = this.f28097c.get(num);
                if (bool == null || !bool.booleanValue()) {
                    atomicInteger.incrementAndGet();
                }
            }
            this.xv.set(atomicInteger.get());
        }
    }

    public synchronized void xv(int i4) {
        AtomicInteger atomicInteger = this.f28100w.get(Integer.valueOf(i4));
        if (atomicInteger != null && atomicInteger.get() != 0) {
            atomicInteger.decrementAndGet();
        }
    }

    public synchronized boolean ux(int i4) {
        boolean z3;
        Map<Integer, Boolean> map = this.f28097c;
        if (map != null && map.get(Integer.valueOf(i4)) != null) {
            z3 = this.f28097c.get(Integer.valueOf(i4)).booleanValue();
        }
        return z3;
    }

    public synchronized void c(int i4, int i5) {
        this.f28100w.put(Integer.valueOf(i4), new AtomicInteger(i5));
    }

    public synchronized void c(List<Integer> list) {
        if (list != null) {
            this.xv.set(list.size());
            for (Integer num : list) {
                this.f28097c.put(num, Boolean.FALSE);
            }
        }
    }

    public void c(int i4, boolean z3) {
        synchronized (this) {
            Boolean bool = this.f28097c.get(Integer.valueOf(i4));
            if (bool != null && !bool.booleanValue()) {
                this.f28097c.put(Integer.valueOf(i4), Boolean.valueOf(z3));
                this.xv.decrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(List<p> list, List<p> list2, List<p> list3) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            int size = list.size();
            if (list2 != null) {
                size += list2.size();
            }
            if (list3 != null) {
                size += list3.size();
            }
            for (p pVar : list) {
                Iterator<String> it = this.ev.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && pVar != null && next.equals(pVar.ia())) {
                            size--;
                            break;
                        }
                    }
                }
            }
            if (!yu.c(list2)) {
                for (p pVar2 : list2) {
                    Iterator<String> it2 = this.ev.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!TextUtils.isEmpty(next2) && pVar2 != null && next2.equals(pVar2.ia())) {
                                size--;
                                break;
                            }
                        }
                    }
                }
            }
            if (!yu.c(list3)) {
                for (p pVar3 : list3) {
                    Iterator<String> it3 = this.ev.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            String next3 = it3.next();
                            if (!TextUtils.isEmpty(next3) && pVar3 != null && next3.equals(pVar3.ia())) {
                                size--;
                                break;
                            }
                        }
                    }
                }
            }
            if (size < 0) {
                size = 0;
            }
            this.ux.set(size);
        }
    }
}
