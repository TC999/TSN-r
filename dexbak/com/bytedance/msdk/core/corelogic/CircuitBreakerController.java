package com.bytedance.msdk.core.corelogic;

import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.bytedance.msdk.core.corelogic.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CircuitBreakerController {

    /* renamed from: d */
    private static volatile CircuitBreakerController f21784d;

    /* renamed from: a */
    private long f21785a;

    /* renamed from: b */
    private long f21786b;

    /* renamed from: c */
    private final Queue<Long> f21787c = new LinkedList();

    private CircuitBreakerController() {
    }

    /* renamed from: c */
    public static CircuitBreakerController m37366c() {
        if (f21784d == null) {
            synchronized (CircuitBreakerController.class) {
                if (f21784d == null) {
                    f21784d = new CircuitBreakerController();
                }
            }
        }
        return f21784d;
    }

    /* renamed from: a */
    public void m37368a(long j, long j2) {
        synchronized (CircuitBreakerController.class) {
            if (this.f21785a != j || this.f21786b != j2) {
                this.f21785a = j;
                this.f21786b = j2;
                this.f21787c.clear();
            }
        }
    }

    /* renamed from: b */
    public boolean m37367b() {
        synchronized (CircuitBreakerController.class) {
            if (this.f21785a > 0 && this.f21786b > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f21787c.size() >= this.f21785a) {
                    while (this.f21787c.size() > this.f21785a) {
                        this.f21787c.poll();
                    }
                    if (Math.abs(currentTimeMillis - this.f21787c.peek().longValue()) <= this.f21786b) {
                        return true;
                    }
                    this.f21787c.poll();
                    this.f21787c.offer(Long.valueOf(currentTimeMillis));
                } else {
                    this.f21787c.offer(Long.valueOf(currentTimeMillis));
                }
                return false;
            }
            return false;
        }
    }
}
