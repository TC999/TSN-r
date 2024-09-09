package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final Handler f51094a;

    /* renamed from: d  reason: collision with root package name */
    long f51097d;

    /* renamed from: e  reason: collision with root package name */
    private final String f51098e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ba> f51099f = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    long f51095b = 5000;

    /* renamed from: g  reason: collision with root package name */
    private final long f51100g = 5000;

    /* renamed from: c  reason: collision with root package name */
    boolean f51096c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(Handler handler, String str) {
        this.f51094a = handler;
        this.f51098e = str;
    }

    private Thread e() {
        return this.f51094a.getLooper().getThread();
    }

    public final boolean a() {
        return !this.f51096c && SystemClock.uptimeMillis() >= this.f51097d + this.f51095b;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.f51097d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f51099f) {
            arrayList = new ArrayList(this.f51099f.size());
            for (int i4 = 0; i4 < this.f51099f.size(); i4++) {
                ba baVar = this.f51099f.get(i4);
                if (!baVar.f51075e && currentTimeMillis - baVar.f51072b < 200000) {
                    arrayList.add(baVar);
                    baVar.f51075e = true;
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement);
                    sb.append("\n");
                }
            }
        } catch (SecurityException e4) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e4.getMessage());
            sb.append("\n");
            al.a(e4);
        }
        long nanoTime2 = System.nanoTime();
        ba baVar = new ba(sb.toString(), System.currentTimeMillis());
        baVar.f51074d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.f51071a = name;
        synchronized (this.f51099f) {
            while (this.f51099f.size() >= 32) {
                this.f51099f.remove(0);
            }
            this.f51099f.add(baVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f51096c = true;
        this.f51095b = this.f51100g;
    }
}
