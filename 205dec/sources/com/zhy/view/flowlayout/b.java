package com.zhy.view.flowlayout;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TagAdapter.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private List<T> f54594a;

    /* renamed from: b  reason: collision with root package name */
    private a f54595b;

    /* renamed from: c  reason: collision with root package name */
    private HashSet<Integer> f54596c = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TagAdapter.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a();
    }

    public b(List<T> list) {
        this.f54594a = list;
    }

    public int a() {
        List<T> list = this.f54594a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T b(int i4) {
        return this.f54594a.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<Integer> c() {
        return this.f54596c;
    }

    public abstract View d(FlowLayout flowLayout, int i4, T t3);

    public void e() {
        this.f54595b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        this.f54595b = aVar;
    }

    public boolean g(int i4, T t3) {
        return false;
    }

    public void h(Set<Integer> set) {
        this.f54596c.clear();
        if (set != null) {
            this.f54596c.addAll(set);
        }
        e();
    }

    public void i(int... iArr) {
        for (int i4 : iArr) {
            this.f54596c.add(Integer.valueOf(i4));
        }
        e();
    }

    public b(T[] tArr) {
        this.f54594a = new ArrayList(Arrays.asList(tArr));
    }
}
