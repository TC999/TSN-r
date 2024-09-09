package com.ss.android.socialbase.appdownloader.f.c;

import java.io.PrintStream;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev extends Exception {

    /* renamed from: c  reason: collision with root package name */
    protected Throwable f49080c;

    /* renamed from: w  reason: collision with root package name */
    protected int f49081w;
    protected int xv;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ev(java.lang.String r4, com.ss.android.socialbase.appdownloader.f.c.r r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r4 != 0) goto Lb
            r4 = r1
            goto L1c
        Lb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
        L1c:
            r0.append(r4)
            if (r5 != 0) goto L23
            r4 = r1
            goto L3d
        L23:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "(position:"
            r4.append(r2)
            java.lang.String r2 = r5.sr()
            r4.append(r2)
            java.lang.String r2 = ") "
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L3d:
            r0.append(r4)
            if (r6 != 0) goto L43
            goto L54
        L43:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "caused by: "
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
        L54:
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            r4 = -1
            r3.f49081w = r4
            r3.xv = r4
            if (r5 == 0) goto L71
            int r4 = r5.xv()
            r3.f49081w = r4
            int r4 = r5.f()
            r3.xv = r4
        L71:
            r3.f49080c = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.c.ev.<init>(java.lang.String, com.ss.android.socialbase.appdownloader.f.c.r, java.lang.Throwable):void");
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.f49080c == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.f49080c.printStackTrace();
        }
    }
}
