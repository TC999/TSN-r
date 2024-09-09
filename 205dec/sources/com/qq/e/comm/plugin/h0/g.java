package com.qq.e.comm.plugin.h0;

import android.os.Handler;
import android.os.Looper;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: e  reason: collision with root package name */
    private static final String f44031e = "g";

    /* renamed from: f  reason: collision with root package name */
    private static volatile g f44032f;

    /* renamed from: a  reason: collision with root package name */
    private final Looper f44033a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f44034b;

    /* renamed from: c  reason: collision with root package name */
    private h f44035c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<d> f44036d = new CopyOnWriteArraySet();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f44037c;

        a(d dVar) {
            this.f44037c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f44036d.add(this.f44037c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f44039c;

        b(d dVar) {
            this.f44039c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f44036d.remove(this.f44039c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f44036d.clear();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d {
        void a();

        void b();
    }

    private g(Looper looper) {
        this.f44033a = looper;
        this.f44034b = new Handler(this.f44033a);
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            r5 = this;
            android.os.Looper r0 = r5.f44033a
            java.lang.Class r0 = r0.getClass()
            java.lang.String r1 = "mLogging"
            r2 = 0
            java.lang.reflect.Field r0 = com.qq.e.comm.plugin.util.j1.a(r0, r1, r2)
            r1 = 0
            if (r0 == 0) goto L57
            r2 = 1
            r0.setAccessible(r2)     // Catch: java.lang.ClassCastException -> L48 java.lang.IllegalAccessException -> L4d
            android.os.Looper r2 = r5.f44033a     // Catch: java.lang.ClassCastException -> L48 java.lang.IllegalAccessException -> L4d
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.ClassCastException -> L48 java.lang.IllegalAccessException -> L4d
            android.util.Printer r0 = (android.util.Printer) r0     // Catch: java.lang.ClassCastException -> L48 java.lang.IllegalAccessException -> L4d
            com.qq.e.comm.plugin.h0.h r1 = r5.f44035c     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            if (r0 != r1) goto L25
            com.qq.e.comm.plugin.h0.h r1 = r5.f44035c     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            if (r1 == 0) goto L25
            return
        L25:
            if (r0 == 0) goto L56
            com.qq.e.comm.plugin.h0.h r1 = r5.f44035c     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            if (r1 == 0) goto L56
            java.lang.Class r1 = r0.getClass()     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.String r1 = r1.getName()     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            com.qq.e.comm.plugin.h0.h r2 = r5.f44035c     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Class r2 = r2.getClass()     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.String r2 = r2.getName()     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L44 java.lang.IllegalAccessException -> L46
            if (r1 == 0) goto L56
            return
        L44:
            r1 = move-exception
            goto L4f
        L46:
            r1 = move-exception
            goto L4f
        L48:
            r0 = move-exception
        L49:
            r4 = r1
            r1 = r0
            r0 = r4
            goto L4f
        L4d:
            r0 = move-exception
            goto L49
        L4f:
            java.lang.String r2 = com.qq.e.comm.plugin.h0.g.f44031e
            java.lang.String r3 = "resetPrinter: failed"
            com.qq.e.comm.plugin.util.d1.a(r2, r3, r1)
        L56:
            r1 = r0
        L57:
            com.qq.e.comm.plugin.h0.h r0 = r5.f44035c
            if (r0 == 0) goto L62
            java.lang.String r0 = com.qq.e.comm.plugin.h0.g.f44031e
            java.lang.String r2 = "resetPrinter"
            com.qq.e.comm.plugin.util.d1.a(r0, r2)
        L62:
            com.qq.e.comm.plugin.h0.h r0 = new com.qq.e.comm.plugin.h0.h
            r0.<init>(r5, r1)
            r5.f44035c = r0
            android.os.Looper r1 = r5.f44033a
            r1.setMessageLogging(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.h0.g.c():void");
    }

    public Set<d> b() {
        return this.f44036d;
    }

    public static g a(Looper looper) {
        if (f44032f == null) {
            synchronized (g.class) {
                if (f44032f == null) {
                    f44032f = new g(looper);
                }
            }
        }
        return f44032f;
    }

    public void b(d dVar) {
        if (Thread.currentThread() != this.f44033a.getThread()) {
            this.f44034b.post(new b(dVar));
        } else {
            this.f44036d.remove(dVar);
        }
    }

    public void a(d dVar) {
        if (Thread.currentThread() != this.f44033a.getThread()) {
            this.f44034b.post(new a(dVar));
        } else {
            this.f44036d.add(dVar);
        }
    }

    public void a() {
        h hVar = this.f44035c;
        if (hVar != null) {
            this.f44033a.setMessageLogging(hVar.c());
        }
        if (Thread.currentThread() != this.f44033a.getThread()) {
            this.f44034b.post(new c());
        } else {
            this.f44036d.clear();
        }
        f44032f = null;
    }
}
