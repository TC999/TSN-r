package com.bytedance.sdk.openadsdk.core.bk;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f32032c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f32033w;
    private static volatile long xv;
    private final Queue<C0473c> sr = new LinkedList();
    private Handler ux;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.bk.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0473c {

        /* renamed from: c  reason: collision with root package name */
        private final long f32035c;

        /* renamed from: w  reason: collision with root package name */
        private final String f32036w;

        private C0473c(long j4, String str) {
            this.f32035c = j4;
            this.f32036w = str;
        }
    }

    private c() {
    }

    private synchronized boolean w(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int xv2 = ux.c().xv();
        long w3 = ux.c().w();
        if (this.sr.size() > 0 && this.sr.size() >= xv2) {
            long abs = Math.abs(currentTimeMillis - this.sr.peek().f32035c);
            if (abs <= w3) {
                w(w3 - abs);
                return true;
            }
            this.sr.poll();
            this.sr.offer(new C0473c(currentTimeMillis, str));
        } else {
            this.sr.offer(new C0473c(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String xv() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0473c c0473c : this.sr) {
            if (hashMap.containsKey(c0473c.f32036w)) {
                hashMap.put(c0473c.f32036w, Integer.valueOf(((Integer) hashMap.get(c0473c.f32036w)).intValue() + 1));
            } else {
                hashMap.put(c0473c.f32036w, 1);
            }
        }
        int i4 = Integer.MIN_VALUE;
        str = "";
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i4 < intValue) {
                str = str2;
                i4 = intValue;
            }
        }
        return str;
    }

    public static c c() {
        if (f32032c == null) {
            synchronized (c.class) {
                if (f32032c == null) {
                    f32032c = new c();
                }
            }
        }
        return f32032c;
    }

    public synchronized boolean c(String str) {
        if (w(str)) {
            c(true);
            c(xv);
        } else {
            c(false);
        }
        return f32033w;
    }

    private void c(long j4) {
        if (this.ux == null) {
            this.ux = new Handler(Looper.getMainLooper());
        }
        this.ux.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bk.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.c(false);
            }
        }, j4);
    }

    public boolean w() {
        return f32033w;
    }

    private synchronized void w(long j4) {
        xv = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(boolean z3) {
        f32033w = z3;
    }
}
