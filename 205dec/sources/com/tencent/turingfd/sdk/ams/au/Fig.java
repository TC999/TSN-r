package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Fig implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f52041c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f52042d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f52043e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Foxnut f52044f;

    public Fig(Foxnut foxnut, Context context, boolean z3, int i4) {
        this.f52044f = foxnut;
        this.f52041c = context;
        this.f52042d = z3;
        this.f52043e = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r10 = this;
            com.tencent.turingfd.sdk.ams.au.Foxnut r0 = r10.f52044f
            android.content.Context r1 = r10.f52041c
            boolean r2 = r10.f52042d
            int r3 = r10.f52043e
            com.tencent.turingfd.sdk.ams.au.Ginkgo r4 = r0.f52058d
            r4.getClass()
            java.lang.String r4 = "403"
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.Ginkgo.b(r1, r4)
            r5 = 1
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L1b
            goto L24
        L1b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L24
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L24
            goto L25
        L24:
            r4 = 1
        L25:
            r6 = 0
            r7 = 0
        L27:
            com.tencent.turingfd.sdk.ams.au.Cumquat r8 = r0.f52055a
            int r8 = r8.f52004x
            if (r7 >= r8) goto L41
            com.tencent.turingfd.sdk.ams.au.Date r8 = r0.a(r1, r2, r4, r3)
            r0.a(r8, r5)
            int r8 = r8.f52019c
            if (r8 != 0) goto L39
            goto L41
        L39:
            r9 = -30014(0xffffffffffff8ac2, float:NaN)
            if (r8 != r9) goto L3e
            goto L41
        L3e:
            int r7 = r7 + 1
            goto L27
        L41:
            if (r4 == 0) goto L5e
            com.tencent.turingfd.sdk.ams.au.Ginkgo r2 = r0.f52058d
            r2.getClass()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "403"
            r2.a(r1, r4, r3, r5)
        L5e:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r0.f52061g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r2 = r0.f52061g     // Catch: java.lang.Throwable -> L6f
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L6f
            r2.set(r3)     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r0.f52061g     // Catch: java.lang.Throwable -> L6f
            r0.notifyAll()     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6f
            return
        L6f:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6f
            goto L73
        L72:
            throw r0
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Fig.run():void");
    }
}
