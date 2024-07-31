package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class RunnableC12872bf implements Runnable {

    /* renamed from: a */
    final Handler f36724a;

    /* renamed from: d */
    long f36727d;

    /* renamed from: e */
    private final String f36728e;

    /* renamed from: f */
    private final List<C12867ba> f36729f = new LinkedList();

    /* renamed from: b */
    long f36725b = 5000;

    /* renamed from: g */
    private final long f36730g = 5000;

    /* renamed from: c */
    boolean f36726c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC12872bf(Handler handler, String str) {
        this.f36724a = handler;
        this.f36728e = str;
    }

    /* renamed from: e */
    private Thread m15675e() {
        return this.f36724a.getLooper().getThread();
    }

    /* renamed from: a */
    public final boolean m15679a() {
        return !this.f36726c && SystemClock.uptimeMillis() >= this.f36727d + this.f36725b;
    }

    /* renamed from: b */
    public final long m15678b() {
        return SystemClock.uptimeMillis() - this.f36727d;
    }

    /* renamed from: c */
    public final List<C12867ba> m15677c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f36729f) {
            arrayList = new ArrayList(this.f36729f.size());
            for (int i = 0; i < this.f36729f.size(); i++) {
                C12867ba c12867ba = this.f36729f.get(i);
                if (!c12867ba.f36705e && currentTimeMillis - c12867ba.f36702b < 200000) {
                    arrayList.add(c12867ba);
                    c12867ba.f36705e = true;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public final void m15676d() {
        StringBuilder sb = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = m15675e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement);
                    sb.append(ShellAdbUtils.f33810d);
                }
            }
        } catch (SecurityException e) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e.getMessage());
            sb.append(ShellAdbUtils.f33810d);
            C12820al.m15877a(e);
        }
        long nanoTime2 = System.nanoTime();
        C12867ba c12867ba = new C12867ba(sb.toString(), System.currentTimeMillis());
        c12867ba.f36704d = nanoTime2 - nanoTime;
        String name = m15675e().getName();
        if (name == null) {
            name = "";
        }
        c12867ba.f36701a = name;
        synchronized (this.f36729f) {
            while (this.f36729f.size() >= 32) {
                this.f36729f.remove(0);
            }
            this.f36729f.add(c12867ba);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36726c = true;
        this.f36725b = this.f36730g;
    }
}
