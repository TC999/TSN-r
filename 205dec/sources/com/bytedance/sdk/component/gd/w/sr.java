package com.bytedance.sdk.component.gd.w;

import com.bytedance.sdk.component.gd.w.xv;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr<T extends xv> {

    /* renamed from: c  reason: collision with root package name */
    private int f29877c;

    /* renamed from: w  reason: collision with root package name */
    private BlockingQueue<T> f29878w = new LinkedBlockingQueue();

    private sr(int i4) {
        this.f29877c = i4;
    }

    public static sr c(int i4) {
        return new sr(i4);
    }

    public T c() {
        return this.f29878w.poll();
    }

    public boolean c(T t3) {
        if (t3 == null) {
            return false;
        }
        t3.c();
        if (this.f29878w.size() >= this.f29877c) {
            return false;
        }
        return this.f29878w.offer(t3);
    }
}
