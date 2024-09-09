package com.bytedance.msdk.core.corelogic;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TTRequestLoadingStatus.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Boolean> f27910a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, AtomicInteger> f27911b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f27912c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f27913d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f27914e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f27915f = new AtomicInteger();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f27916g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private final List<Integer> f27917h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f27918i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f27919j = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f27913d.get() != 0) {
            this.f27913d.decrementAndGet();
        } else {
            Logger.e("TTMediationSDK", "decrementBidingWaterfall--\u5f53\u524d\u6b63\u5728\u8bf7\u6c42\u7684\u7ade\u4ef7waterfall\u6570\u636e\u51cf\u4e00 ---\u4e0d\u7528\u518d\u51cf\u4e86\u4e0d\u7136\u5c31\u53d8\u6210-1\u4e86");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4) {
        AtomicInteger atomicInteger = this.f27911b.get(Integer.valueOf(i4));
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return;
        }
        atomicInteger.decrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4, int i5) {
        this.f27911b.put(Integer.valueOf(i4), new AtomicInteger(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i4, boolean z3) {
        synchronized (this) {
            Boolean bool = this.f27910a.get(Integer.valueOf(i4));
            if (bool != null && !bool.booleanValue()) {
                this.f27910a.put(Integer.valueOf(i4), Boolean.valueOf(z3));
                this.f27912c.decrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                this.f27918i.add(str);
            }
            if (this.f27915f.get() != 0) {
                this.f27915f.decrementAndGet();
            } else {
                Logger.e("TTMediationSDK", "decrementTotalWaterFall--waterfall\u6570\u91cf\u51cf\u5c11\u4e00\u4e2a ---\u4e0d\u7528\u518d\u51cf\u4e86\u4e0d\u7136\u5c31\u53d8\u6210-1\u4e86");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(List<Integer> list) {
        if (list != null) {
            this.f27912c.set(list.size());
            for (Integer num : list) {
                this.f27910a.put(num, Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z3) {
        this.f27916g.set(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f27913d.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i4) {
        AtomicInteger atomicInteger = this.f27911b.get(Integer.valueOf(i4));
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            AtomicInteger atomicInteger = new AtomicInteger();
            for (Integer num : list) {
                Boolean bool = this.f27910a.get(num);
                if (bool == null || !bool.booleanValue()) {
                    atomicInteger.incrementAndGet();
                }
            }
            this.f27912c.set(atomicInteger.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(boolean z3) {
        this.f27914e.set(z3);
    }

    int l() {
        int i4;
        synchronized (this) {
            i4 = this.f27912c.get();
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(List<h> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            int size = list.size();
            for (String str : this.f27918i) {
                Iterator<h> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        h next = it.next();
                        if (!TextUtils.isEmpty(str) && next != null && str.equals(next.c())) {
                            size--;
                            break;
                        }
                    }
                }
            }
            this.f27915f.set(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(boolean z3) {
        this.f27919j.set(z3);
    }

    public boolean o(int i4) {
        Map<Integer, Boolean> map = this.f27910a;
        return (map == null || map.get(Integer.valueOf(i4)) == null || !this.f27910a.get(Integer.valueOf(i4)).booleanValue()) ? false : true;
    }

    int p() {
        int i4;
        synchronized (this) {
            i4 = this.f27915f.get();
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i4) {
        this.f27917h.add(Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i4) {
        this.f27915f.set(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f27919j.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i4) {
        this.f27913d.set(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return l() == 0 && p() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        return this.f27916g.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f27914e.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        for (Map.Entry<Integer, Boolean> entry : this.f27910a.entrySet()) {
            this.f27910a.put(entry.getKey(), Boolean.TRUE);
        }
        for (Map.Entry<Integer, AtomicInteger> entry2 : this.f27911b.entrySet()) {
            this.f27911b.put(entry2.getKey(), new AtomicInteger(0));
        }
        this.f27913d.set(0);
        this.f27912c.set(0);
        this.f27915f.set(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        this.f27915f.set(0);
        this.f27912c.set(0);
        this.f27910a.clear();
        this.f27911b.clear();
        this.f27913d.set(0);
        this.f27914e.set(false);
        this.f27916g.set(false);
        this.f27918i.clear();
        this.f27917h.clear();
        this.f27919j.set(false);
    }
}
