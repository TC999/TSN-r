package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bg extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public bf f51101a;

    /* renamed from: g  reason: collision with root package name */
    private a f51107g;

    /* renamed from: c  reason: collision with root package name */
    private boolean f51103c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f51104d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f51105e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f51106f = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51102b = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
    }

    public final boolean a() {
        this.f51103c = true;
        if (isAlive()) {
            try {
                interrupt();
            } catch (Exception e4) {
                al.b(e4);
            }
            al.d("MainHandlerChecker is reset to null.", new Object[0]);
            this.f51101a = null;
            return true;
        }
        return false;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.f51101a;
        if (bfVar != null) {
            bfVar.f51095b = 5000L;
        } else {
            this.f51101a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e4) {
            al.b(e4);
            return false;
        }
    }

    public final synchronized void c() {
        this.f51104d = false;
        al.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.f51105e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        r2.d();
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
            boolean r2 = r10.f51103c
            if (r2 != 0) goto L99
            com.tencent.bugly.proguard.bf r2 = r10.f51101a     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r3 = 0
            if (r2 != 0) goto L15
            java.lang.String r2 = "Main handler checker is null. Stop thread monitor."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            com.tencent.bugly.proguard.al.c(r2, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            return
        L15:
            boolean r4 = r2.f51096c     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r4 == 0) goto L26
            r2.f51096c = r3     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r2.f51097d = r4     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            android.os.Handler r4 = r2.f51094a     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r4.post(r2)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L26:
            r10.a(r2)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            boolean r4 = r10.f51102b     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r5 = 1
            if (r4 == 0) goto L6c
            boolean r4 = r10.f51104d     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r4 != 0) goto L33
            goto L6c
        L33:
            long r6 = r2.b()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
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
            r10.f51106f = r5     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            java.lang.String r4 = "timeSinceMsgSent in [2s, 5s], record stack"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            com.tencent.bugly.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r3 = 1
            goto L6c
        L56:
            int r4 = r10.f51106f     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            int r4 = r4 + r5
            r10.f51106f = r4     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
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
            com.tencent.bugly.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L6b:
            r3 = r5
        L6c:
            if (r3 == 0) goto L71
            r2.d()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L71:
            com.tencent.bugly.proguard.bg$a r3 = r10.f51107g     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r3 == 0) goto L7f
            boolean r3 = r10.f51104d     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            if (r3 == 0) goto L7f
            r2.a()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            r2.b()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
        L7f:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            long r2 = r2 - r0
            r4 = 500(0x1f4, double:2.47E-321)
            long r2 = r2 % r4
            long r4 = r4 - r2
            com.tencent.bugly.proguard.ap.b(r4)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L93
            goto L4
        L8d:
            r2 = move-exception
            com.tencent.bugly.proguard.al.b(r2)
            goto L4
        L93:
            r2 = move-exception
            com.tencent.bugly.proguard.al.b(r2)
            goto L4
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bg.run():void");
    }

    private synchronized void a(bf bfVar) {
        if (this.f51104d) {
            return;
        }
        if (this.f51105e && !bfVar.a()) {
            al.c("Restart getting main stack trace.", new Object[0]);
            this.f51104d = true;
            this.f51105e = false;
        }
    }
}
