package com.kwad.sdk.crash.report;

/* renamed from: com.kwad.sdk.crash.report.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10718f extends AbstractC10715d {
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
    @Override // com.kwad.sdk.crash.report.AbstractC10715d
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.kwad.sdk.crash.model.message.ExceptionMessage mo25035a(@androidx.annotation.NonNull java.io.File r7, java.io.File r8, java.io.File r9, java.lang.String r10) {
        /*
            r6 = this;
            java.lang.String r8 = "\n"
            r0 = 0
            java.lang.String r1 = com.kwad.sdk.utils.C11122q.m23738V(r7)     // Catch: java.lang.Exception -> L8
            goto L20
        L8:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.mErrorMessage
            r2.append(r3)
            r2.append(r1)
            r2.append(r8)
            java.lang.String r1 = r2.toString()
            r6.mErrorMessage = r1
            r1 = r0
        L20:
            if (r1 == 0) goto L4d
            com.kwad.sdk.crash.model.message.JavaExceptionMessage r2 = new com.kwad.sdk.crash.model.message.JavaExceptionMessage     // Catch: java.lang.Exception -> L32
            r2.<init>()     // Catch: java.lang.Exception -> L32
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L30
            r0.<init>(r1)     // Catch: java.lang.Exception -> L30
            r2.parseJson(r0)     // Catch: java.lang.Exception -> L30
            goto L4c
        L30:
            r0 = move-exception
            goto L36
        L32:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L36:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r6.mErrorMessage
            r3.append(r4)
            r3.append(r0)
            r3.append(r8)
            java.lang.String r0 = r3.toString()
            r6.mErrorMessage = r0
        L4c:
            r0 = r2
        L4d:
            if (r0 != 0) goto L5c
            com.kwad.sdk.crash.model.message.JavaExceptionMessage r0 = new com.kwad.sdk.crash.model.message.JavaExceptionMessage
            r0.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L5c
            r0.mCrashDetail = r1
        L5c:
            java.lang.String r1 = r7.getName()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = com.kwad.sdk.crash.utils.C10745g.m24964fG(r1)     // Catch: java.lang.Throwable -> Laf
            r0.mLogUUID = r1     // Catch: java.lang.Throwable -> Laf
            r0.toString()     // Catch: java.lang.Throwable -> Laf
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r2.<init>()     // Catch: java.lang.Throwable -> Laf
            r2.append(r10)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r3 = ".jtrace"
            r2.append(r3)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Laf
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Laf
            com.kwad.sdk.crash.report.AbstractC10715d.m25045a(r1, r0)     // Catch: java.lang.Throwable -> Laf
            r6.m25043b(r9, r0)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = r0.toString()     // Catch: java.lang.Throwable -> Laf
            com.kwad.sdk.crash.utils.C10745g.m24983a(r7, r1)     // Catch: java.lang.Throwable -> Laf
            com.kwad.sdk.crash.utils.C10745g.m24966d(r9, r7)     // Catch: java.lang.Throwable -> Laf
            r7.renameTo(r9)     // Catch: java.lang.Throwable -> Laf
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r9.<init>()     // Catch: java.lang.Throwable -> Laf
            r9.append(r10)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r10 = ".minfo"
            r9.append(r10)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Laf
            r7.<init>(r9)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r7 = com.kwad.sdk.utils.C11122q.m23738V(r7)     // Catch: java.lang.Throwable -> Laf
            r0.mDumpsys = r7     // Catch: java.lang.Throwable -> Laf
            goto Lc9
        Laf:
            r7 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r6.mErrorMessage
            r9.append(r10)
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r6.mErrorMessage = r8
            com.kwad.sdk.core.p397e.C10331c.printStackTraceOnly(r7)
        Lc9:
            java.lang.String r7 = r6.mErrorMessage
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto Le6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r0.mErrorMessage
            r7.append(r8)
            java.lang.String r8 = r6.mErrorMessage
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r0.mErrorMessage = r7
        Le6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.C10718f.mo25035a(java.io.File, java.io.File, java.io.File, java.lang.String):com.kwad.sdk.crash.model.message.ExceptionMessage");
    }
}
