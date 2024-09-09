package com.ss.android.socialbase.appdownloader.kf.ok;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {

    /* renamed from: a  reason: collision with root package name */
    private int[] f49129a;
    private int[] ok;

    private kf() {
    }

    public static kf ok(s sVar) throws IOException {
        a.ok(sVar, 1835009);
        int a4 = sVar.a();
        int a5 = sVar.a();
        int a6 = sVar.a();
        sVar.a();
        int a7 = sVar.a();
        int a8 = sVar.a();
        kf kfVar = new kf();
        kfVar.ok = sVar.a(a5);
        if (a6 != 0) {
            sVar.a(a6);
        }
        int i4 = (a8 == 0 ? a4 : a8) - a7;
        if (i4 % 4 == 0) {
            kfVar.f49129a = sVar.a(i4 / 4);
            if (a8 != 0) {
                int i5 = a4 - a8;
                if (i5 % 4 == 0) {
                    sVar.a(i5 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i5 + ").");
                }
            }
            return kfVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i4 + ").");
    }

    public String ok(int i4) {
        int[] iArr;
        if (i4 < 0 || (iArr = this.ok) == null || i4 >= iArr.length) {
            return null;
        }
        int i5 = iArr[i4];
        int ok = ok(this.f49129a, i5);
        StringBuilder sb = new StringBuilder(ok);
        while (ok != 0) {
            i5 += 2;
            sb.append((char) ok(this.f49129a, i5));
            ok--;
        }
        return sb.toString();
    }

    private static final int ok(int[] iArr, int i4) {
        int i5 = iArr[i4 / 4];
        return (i4 % 4) / 2 == 0 ? i5 & 65535 : i5 >>> 16;
    }
}
