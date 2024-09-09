package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ch implements an.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ double f12622a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cb f12623b;

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(bw bwVar);

        void b(bw bwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cb cbVar, double d4) {
        this.f12623b = cbVar;
        this.f12622a = d4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0055, code lost:
        if (r9 == java.lang.Math.floor(r4.b())) goto L8;
     */
    @Override // com.baidu.mobads.sdk.internal.an.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            com.baidu.mobads.sdk.internal.cb r10 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r0 = new com.baidu.mobads.sdk.internal.bz
            r0.<init>(r9)
            com.baidu.mobads.sdk.internal.cb.a(r10, r0)
            double r9 = com.baidu.mobads.sdk.internal.co.b()
            com.baidu.mobads.sdk.internal.cb r0 = r8.f12623b
            android.content.SharedPreferences r0 = com.baidu.mobads.sdk.internal.cb.f(r0)
            java.lang.String r1 = "__badApkVersion__9.35"
            r2 = 0
            float r0 = r0.getFloat(r1, r2)
            com.baidu.mobads.sdk.internal.cb r1 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r1 = com.baidu.mobads.sdk.internal.cb.g(r1)
            double r1 = r1.b()
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
            com.baidu.mobads.sdk.internal.cb r4 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r4 = com.baidu.mobads.sdk.internal.cb.g(r4)
            double r4 = r4.b()
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 > 0) goto L58
            double r9 = java.lang.Math.floor(r9)
            com.baidu.mobads.sdk.internal.cb r4 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r4 = com.baidu.mobads.sdk.internal.cb.g(r4)
            double r4 = r4.b()
            double r4 = java.lang.Math.floor(r4)
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 != 0) goto L58
            goto L59
        L58:
            r2 = 0
        L59:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)
            com.baidu.mobads.sdk.internal.cb r10 = r8.f12623b
            com.baidu.mobads.sdk.internal.bv r10 = com.baidu.mobads.sdk.internal.cb.e(r10)
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
            r10.a(r2, r0)
            double r4 = r8.f12622a
            com.baidu.mobads.sdk.internal.cb r10 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r10 = com.baidu.mobads.sdk.internal.cb.g(r10)
            double r6 = r10.b()
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 >= 0) goto Lc7
            com.baidu.mobads.sdk.internal.cb r10 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r10 = com.baidu.mobads.sdk.internal.cb.g(r10)
            if (r10 == 0) goto Lc7
            com.baidu.mobads.sdk.internal.cb r10 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r10 = com.baidu.mobads.sdk.internal.cb.g(r10)
            java.lang.Boolean r10 = r10.a()
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lc7
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lc7
            boolean r9 = r1.booleanValue()
            if (r9 != 0) goto Lc7
            com.baidu.mobads.sdk.internal.cb r9 = r8.f12623b
            com.baidu.mobads.sdk.internal.bz r10 = com.baidu.mobads.sdk.internal.cb.g(r9)
            com.baidu.mobads.sdk.internal.cb.b(r9, r10)
            goto Ldb
        Lc7:
            com.baidu.mobads.sdk.internal.cb r9 = r8.f12623b
            boolean r9 = com.baidu.mobads.sdk.internal.cb.c(r9)
            if (r9 == 0) goto Ldb
            com.baidu.mobads.sdk.internal.cb r9 = r8.f12623b
            com.baidu.mobads.sdk.internal.cb.a(r9, r3)
            com.baidu.mobads.sdk.internal.cb r9 = r8.f12623b
            java.lang.String r10 = "Refused to download remote for version..."
            com.baidu.mobads.sdk.internal.cb.a(r9, r3, r10)
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.ch.a(java.lang.String, java.lang.String):void");
    }

    @Override // com.baidu.mobads.sdk.internal.an.b
    public void a(String str, int i4) {
        boolean z3;
        z3 = this.f12623b.A;
        if (z3) {
            this.f12623b.A = false;
            this.f12623b.a(false, "remote update Network access failed");
        }
    }
}
