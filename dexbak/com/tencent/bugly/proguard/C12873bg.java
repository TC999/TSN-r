package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bg */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12873bg extends Thread {

    /* renamed from: a */
    public RunnableC12872bf f36731a;

    /* renamed from: g */
    private InterfaceC12874a f36737g;

    /* renamed from: c */
    private boolean f36733c = false;

    /* renamed from: d */
    private boolean f36734d = true;

    /* renamed from: e */
    private boolean f36735e = false;

    /* renamed from: f */
    private int f36736f = 1;

    /* renamed from: b */
    public boolean f36732b = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.bg$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12874a {
    }

    /* renamed from: a */
    public final boolean m15674a() {
        this.f36733c = true;
        if (isAlive()) {
            try {
                interrupt();
            } catch (Exception e) {
                C12820al.m15875b(e);
            }
            C12820al.m15873d("MainHandlerChecker is reset to null.", new Object[0]);
            this.f36731a = null;
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m15672b() {
        Handler handler = new Handler(Looper.getMainLooper());
        RunnableC12872bf runnableC12872bf = this.f36731a;
        if (runnableC12872bf != null) {
            runnableC12872bf.f36725b = 5000L;
        } else {
            this.f36731a = new RunnableC12872bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e) {
            C12820al.m15875b(e);
            return false;
        }
    }

    /* renamed from: c */
    public final synchronized void m15671c() {
        this.f36734d = false;
        C12820al.m15874c("Record stack trace is disabled.", new Object[0]);
    }

    /* renamed from: d */
    public final synchronized void m15670d() {
        this.f36735e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        r2.m15676d();
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
        L4:
            boolean r2 = r10.f36733c
            if (r2 != 0) goto L99
            com.tencent.bugly.proguard.bf r2 = r10.f36731a     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r3 = 0
            if (r2 != 0) goto L15
            java.lang.String r2 = "Main handler checker is null. Stop thread monitor."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            com.tencent.bugly.proguard.C12820al.m15874c(r2, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            return
        L15:
            boolean r4 = r2.f36726c     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r4 == 0) goto L26
            r2.f36726c = r3     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r2.f36727d = r4     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            android.os.Handler r4 = r2.f36724a     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r4.post(r2)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L26:
            r10.m15673a(r2)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            boolean r4 = r10.f36732b     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r5 = 1
            if (r4 == 0) goto L6c
            boolean r4 = r10.f36734d     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r4 != 0) goto L33
            goto L6c
        L33:
            long r6 = r2.m15678b()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r8 = 1510(0x5e6, double:7.46E-321)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L6c
            r8 = 199990(0x30d36, double:9.8808E-319)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L45
            goto L6c
        L45:
            r8 = 5010(0x1392, double:2.4753E-320)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 > 0) goto L56
            r10.f36736f = r5     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            java.lang.String r4 = "timeSinceMsgSent in [2s, 5s], record stack"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            com.tencent.bugly.proguard.C12820al.m15874c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r3 = 1
            goto L6c
        L56:
            int r4 = r10.f36736f     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            int r4 = r4 + r5
            r10.f36736f = r4     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            int r6 = r4 + (-1)
            r4 = r4 & r6
            if (r4 != 0) goto L61
            goto L62
        L61:
            r5 = 0
        L62:
            if (r5 == 0) goto L6b
            java.lang.String r4 = "timeSinceMsgSent in (5s, 200s), should record stack:true"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            com.tencent.bugly.proguard.C12820al.m15874c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L6b:
            r3 = r5
        L6c:
            if (r3 == 0) goto L71
            r2.m15676d()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L71:
            com.tencent.bugly.proguard.bg$a r3 = r10.f36737g     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r3 == 0) goto L7f
            boolean r3 = r10.f36734d     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r3 == 0) goto L7f
            r2.m15679a()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r2.m15678b()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L7f:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            long r2 = r2 - r0
            r4 = 500(0x1f4, double:2.47E-321)
            long r2 = r2 % r4
            long r4 = r4 - r2
            com.tencent.bugly.proguard.C12828ap.m15822b(r4)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            goto L4
        L8d:
            r2 = move-exception
            com.tencent.bugly.proguard.C12820al.m15875b(r2)
            goto L4
        L93:
            r2 = move-exception
            com.tencent.bugly.proguard.C12820al.m15875b(r2)
            goto L4
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12873bg.run():void");
    }

    /* renamed from: a */
    private synchronized void m15673a(RunnableC12872bf runnableC12872bf) {
        if (this.f36734d) {
            return;
        }
        if (this.f36735e && !runnableC12872bf.m15679a()) {
            C12820al.m15874c("Restart getting main stack trace.", new Object[0]);
            this.f36734d = true;
            this.f36735e = false;
        }
    }
}
