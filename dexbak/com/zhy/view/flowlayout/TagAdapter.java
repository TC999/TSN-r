package com.zhy.view.flowlayout;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.zhy.view.flowlayout.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class TagAdapter<T> {

    /* renamed from: a */
    private List<T> f40088a;

    /* renamed from: b */
    private InterfaceC13568a f40089b;

    /* renamed from: c */
    private HashSet<Integer> f40090c = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TagAdapter.java */
    /* renamed from: com.zhy.view.flowlayout.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13568a {
        /* renamed from: a */
        void mo12847a();
    }

    public TagAdapter(List<T> list) {
        this.f40088a = list;
    }

    /* renamed from: a */
    public int m12856a() {
        List<T> list = this.f40088a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: b */
    public T m12855b(int i) {
        return this.f40088a.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public HashSet<Integer> m12854c() {
        return this.f40090c;
    }

    /* renamed from: d */
    public abstract View mo12853d(FlowLayout flowLayout, int i, T t);

    /* renamed from: e */
    public void m12852e() {
        this.f40089b.mo12847a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m12851f(InterfaceC13568a interfaceC13568a) {
        this.f40089b = interfaceC13568a;
    }

    /* renamed from: g */
    public boolean m12850g(int i, T t) {
        return false;
    }

    /* renamed from: h */
    public void m12849h(Set<Integer> set) {
        this.f40090c.clear();
        if (set != null) {
            this.f40090c.addAll(set);
        }
        m12852e();
    }

    /* renamed from: i */
    public void m12848i(int... iArr) {
        for (int i : iArr) {
            this.f40090c.add(Integer.valueOf(i));
        }
        m12852e();
    }

    public TagAdapter(T[] tArr) {
        this.f40088a = new ArrayList(Arrays.asList(tArr));
    }
}
