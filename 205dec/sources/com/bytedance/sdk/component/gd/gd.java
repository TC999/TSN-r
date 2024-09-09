package com.bytedance.sdk.component.gd;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd<V> extends FutureTask<V> implements Comparable<gd<V>> {

    /* renamed from: c  reason: collision with root package name */
    private int f29841c;

    /* renamed from: w  reason: collision with root package name */
    private int f29842w;

    public gd(Callable<V> callable, int i4, int i5) {
        super(callable);
        this.f29841c = i4 == -1 ? 5 : i4;
        this.f29842w = i5;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(gd gdVar) {
        if (c() < gdVar.c()) {
            return 1;
        }
        return c() > gdVar.c() ? -1 : 0;
    }

    public int c() {
        return this.f29841c;
    }

    public gd(Runnable runnable, V v3, int i4, int i5) {
        super(runnable, v3);
        this.f29841c = i4 == -1 ? 5 : i4;
        this.f29842w = i5;
    }
}
