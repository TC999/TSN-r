package com.bytedance.msdk.core.r;

import java.util.LinkedList;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f28091c;
    private final Queue<Long> sr = new LinkedList();

    /* renamed from: w  reason: collision with root package name */
    private long f28092w;
    private long xv;

    private c() {
    }

    public static c c() {
        if (f28091c == null) {
            synchronized (c.class) {
                if (f28091c == null) {
                    f28091c = new c();
                }
            }
        }
        return f28091c;
    }

    public boolean w() {
        synchronized (c.class) {
            if (this.f28092w > 0 && this.xv > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.sr.size() >= this.f28092w) {
                    while (this.sr.size() > this.f28092w) {
                        this.sr.poll();
                    }
                    if (Math.abs(currentTimeMillis - this.sr.peek().longValue()) <= this.xv) {
                        return true;
                    }
                    this.sr.poll();
                    this.sr.offer(Long.valueOf(currentTimeMillis));
                } else {
                    this.sr.offer(Long.valueOf(currentTimeMillis));
                }
                return false;
            }
            return false;
        }
    }

    public boolean xv() {
        synchronized (c.class) {
            if (this.f28092w > 0 && this.xv > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.sr.size() >= this.f28092w) {
                    while (this.sr.size() > this.f28092w) {
                        this.sr.poll();
                    }
                    if (Math.abs(currentTimeMillis - this.sr.peek().longValue()) <= this.xv) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public void c(long j4, long j5) {
        synchronized (c.class) {
            if (this.f28092w != j4 || this.xv != j5) {
                this.f28092w = j4;
                this.xv = j5;
                this.sr.clear();
            }
        }
    }
}
