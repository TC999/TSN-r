package com.bytedance.msdk.core.corelogic;

import java.util.LinkedList;
import java.util.Queue;

/* compiled from: CircuitBreakerController.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f27874d;

    /* renamed from: a  reason: collision with root package name */
    private long f27875a;

    /* renamed from: b  reason: collision with root package name */
    private long f27876b;

    /* renamed from: c  reason: collision with root package name */
    private final Queue<Long> f27877c = new LinkedList();

    private a() {
    }

    public static a c() {
        if (f27874d == null) {
            synchronized (a.class) {
                if (f27874d == null) {
                    f27874d = new a();
                }
            }
        }
        return f27874d;
    }

    public void a(long j4, long j5) {
        synchronized (a.class) {
            if (this.f27875a != j4 || this.f27876b != j5) {
                this.f27875a = j4;
                this.f27876b = j5;
                this.f27877c.clear();
            }
        }
    }

    public boolean b() {
        synchronized (a.class) {
            if (this.f27875a > 0 && this.f27876b > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f27877c.size() >= this.f27875a) {
                    while (this.f27877c.size() > this.f27875a) {
                        this.f27877c.poll();
                    }
                    if (Math.abs(currentTimeMillis - this.f27877c.peek().longValue()) <= this.f27876b) {
                        return true;
                    }
                    this.f27877c.poll();
                    this.f27877c.offer(Long.valueOf(currentTimeMillis));
                } else {
                    this.f27877c.offer(Long.valueOf(currentTimeMillis));
                }
                return false;
            }
            return false;
        }
    }
}
