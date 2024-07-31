package com.bytedance.msdk.core.corelogic;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.msdk.core.corelogic.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTRequestLoadingStatus {

    /* renamed from: a */
    private final Map<Integer, Boolean> f21820a = new HashMap();

    /* renamed from: b */
    private final Map<Integer, AtomicInteger> f21821b = new HashMap();

    /* renamed from: c */
    private final AtomicInteger f21822c = new AtomicInteger();

    /* renamed from: d */
    private final AtomicInteger f21823d = new AtomicInteger();

    /* renamed from: e */
    private final AtomicBoolean f21824e = new AtomicBoolean(false);

    /* renamed from: f */
    private final AtomicInteger f21825f = new AtomicInteger();

    /* renamed from: g */
    private final AtomicBoolean f21826g = new AtomicBoolean(false);

    /* renamed from: h */
    private final List<Integer> f21827h = new ArrayList();

    /* renamed from: i */
    private final List<String> f21828i = new CopyOnWriteArrayList();

    /* renamed from: j */
    private final AtomicBoolean f21829j = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m37304a() {
        if (this.f21823d.get() != 0) {
            this.f21823d.decrementAndGet();
        } else {
            Logger.m37557e("TTMediationSDK", "decrementBidingWaterfall--当前正在请求的竞价waterfall数据减一 ---不用再减了不然就变成-1了");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m37303b(int i) {
        AtomicInteger atomicInteger = this.f21821b.get(Integer.valueOf(i));
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return;
        }
        atomicInteger.decrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m37302c(int i, int i2) {
        this.f21821b.put(Integer.valueOf(i), new AtomicInteger(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m37301d(int i, boolean z) {
        synchronized (this) {
            Boolean bool = this.f21820a.get(Integer.valueOf(i));
            if (bool != null && !bool.booleanValue()) {
                this.f21820a.put(Integer.valueOf(i), Boolean.valueOf(z));
                this.f21822c.decrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m37300e(String str) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                this.f21828i.add(str);
            }
            if (this.f21825f.get() != 0) {
                this.f21825f.decrementAndGet();
            } else {
                Logger.m37557e("TTMediationSDK", "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m37299f(List<Integer> list) {
        if (list != null) {
            this.f21822c.set(list.size());
            for (Integer num : list) {
                this.f21820a.put(num, Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m37298g(boolean z) {
        this.f21826g.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public int m37297h() {
        return this.f21823d.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public int m37296i(int i) {
        AtomicInteger atomicInteger = this.f21821b.get(Integer.valueOf(i));
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m37295j(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            AtomicInteger atomicInteger = new AtomicInteger();
            for (Integer num : list) {
                Boolean bool = this.f21820a.get(num);
                if (bool == null || !bool.booleanValue()) {
                    atomicInteger.incrementAndGet();
                }
            }
            this.f21822c.set(atomicInteger.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m37294k(boolean z) {
        this.f21824e.set(z);
    }

    /* renamed from: l */
    int m37293l() {
        int i;
        synchronized (this) {
            i = this.f21822c.get();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public void m37292m(List<WaterFallConfig> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            int size = list.size();
            for (String str : this.f21828i) {
                Iterator<WaterFallConfig> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        WaterFallConfig next = it.next();
                        if (!TextUtils.isEmpty(str) && next != null && str.equals(next.m59480c())) {
                            size--;
                            break;
                        }
                    }
                }
            }
            this.f21825f.set(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public void m37291n(boolean z) {
        this.f21829j.set(z);
    }

    /* renamed from: o */
    public boolean m37290o(int i) {
        Map<Integer, Boolean> map = this.f21820a;
        return (map == null || map.get(Integer.valueOf(i)) == null || !this.f21820a.get(Integer.valueOf(i)).booleanValue()) ? false : true;
    }

    /* renamed from: p */
    int m37289p() {
        int i;
        synchronized (this) {
            i = this.f21825f.get();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public void m37288q(int i) {
        this.f21827h.add(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public void m37287r(int i) {
        this.f21825f.set(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean m37286s() {
        return this.f21829j.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public void m37285t(int i) {
        this.f21823d.set(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean m37284u() {
        return m37293l() == 0 && m37289p() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public boolean m37283v() {
        return this.f21826g.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public boolean m37282w() {
        return this.f21824e.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public void m37281x() {
        for (Map.Entry<Integer, Boolean> entry : this.f21820a.entrySet()) {
            this.f21820a.put(entry.getKey(), Boolean.TRUE);
        }
        for (Map.Entry<Integer, AtomicInteger> entry2 : this.f21821b.entrySet()) {
            this.f21821b.put(entry2.getKey(), new AtomicInteger(0));
        }
        this.f21823d.set(0);
        this.f21822c.set(0);
        this.f21825f.set(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public void m37280y() {
        this.f21825f.set(0);
        this.f21822c.set(0);
        this.f21820a.clear();
        this.f21821b.clear();
        this.f21823d.set(0);
        this.f21824e.set(false);
        this.f21826g.set(false);
        this.f21828i.clear();
        this.f21827h.clear();
        this.f21829j.set(false);
    }
}
