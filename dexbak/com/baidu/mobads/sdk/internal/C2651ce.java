package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.C2594an;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.ce */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2651ce implements C2594an.InterfaceC2596b {

    /* renamed from: a */
    final /* synthetic */ double f8803a;

    /* renamed from: b */
    final /* synthetic */ C2640by f8804b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2651ce(C2640by c2640by, double d) {
        this.f8804b = c2640by;
        this.f8803a = d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0055, code lost:
        if (r9 == java.lang.Math.floor(r4.m50713b())) goto L8;
     */
    @Override // com.baidu.mobads.sdk.internal.C2594an.InterfaceC2596b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo50652a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            com.baidu.mobads.sdk.internal.by r10 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r0 = new com.baidu.mobads.sdk.internal.bw
            r0.<init>(r9)
            com.baidu.mobads.sdk.internal.C2640by.m50697a(r10, r0)
            double r9 = com.baidu.mobads.sdk.internal.C2659cl.m50635b()
            com.baidu.mobads.sdk.internal.by r0 = r8.f8804b
            android.content.SharedPreferences r0 = com.baidu.mobads.sdk.internal.C2640by.m50668f(r0)
            java.lang.String r1 = "__badApkVersion__9.332"
            r2 = 0
            float r0 = r0.getFloat(r1, r2)
            com.baidu.mobads.sdk.internal.by r1 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r1 = com.baidu.mobads.sdk.internal.C2640by.m50666g(r1)
            double r1 = r1.m50713b()
            float r1 = (float) r1
            r2 = 1
            r3 = 0
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L2e
            r1 = 1
            goto L2f
        L2e:
            r1 = 0
        L2f:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            com.baidu.mobads.sdk.internal.by r4 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r4 = com.baidu.mobads.sdk.internal.C2640by.m50666g(r4)
            double r4 = r4.m50713b()
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 > 0) goto L58
            double r9 = java.lang.Math.floor(r9)
            com.baidu.mobads.sdk.internal.by r4 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r4 = com.baidu.mobads.sdk.internal.C2640by.m50666g(r4)
            double r4 = r4.m50713b()
            double r4 = java.lang.Math.floor(r4)
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 != 0) goto L58
            goto L59
        L58:
            r2 = 0
        L59:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
            com.baidu.mobads.sdk.internal.by r10 = r8.f8804b
            com.baidu.mobads.sdk.internal.bs r10 = com.baidu.mobads.sdk.internal.C2640by.m50670e(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "try to download apk badVer="
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = ", isBad="
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = ", compatible="
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "ApkLoader"
            r10.m50740a(r2, r0)
            double r4 = r8.f8803a
            com.baidu.mobads.sdk.internal.by r10 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.C2640by.m50666g(r10)
            double r6 = r10.m50713b()
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 >= 0) goto Lc7
            com.baidu.mobads.sdk.internal.by r10 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.C2640by.m50666g(r10)
            if (r10 == 0) goto Lc7
            com.baidu.mobads.sdk.internal.by r10 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.C2640by.m50666g(r10)
            java.lang.Boolean r10 = r10.m50714a()
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lc7
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lc7
            boolean r9 = r1.booleanValue()
            if (r9 != 0) goto Lc7
            com.baidu.mobads.sdk.internal.by r9 = r8.f8804b
            com.baidu.mobads.sdk.internal.bw r10 = com.baidu.mobads.sdk.internal.C2640by.m50666g(r9)
            com.baidu.mobads.sdk.internal.C2640by.m50685b(r9, r10)
            goto Ldb
        Lc7:
            com.baidu.mobads.sdk.internal.by r9 = r8.f8804b
            boolean r9 = com.baidu.mobads.sdk.internal.C2640by.m50678c(r9)
            if (r9 == 0) goto Ldb
            com.baidu.mobads.sdk.internal.by r9 = r8.f8804b
            com.baidu.mobads.sdk.internal.C2640by.m50695a(r9, r3)
            com.baidu.mobads.sdk.internal.by r9 = r8.f8804b
            java.lang.String r10 = "Refused to download remote for version..."
            com.baidu.mobads.sdk.internal.C2640by.m50694a(r9, r3, r10)
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.C2651ce.mo50652a(java.lang.String, java.lang.String):void");
    }

    @Override // com.baidu.mobads.sdk.internal.C2594an.InterfaceC2596b
    /* renamed from: a */
    public void mo50653a(String str, int i) {
        boolean z;
        z = this.f8804b.f8784A;
        if (z) {
            this.f8804b.f8784A = false;
            this.f8804b.m50691a(false, "remote update Network access failed");
        }
    }
}
