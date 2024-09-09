package com.ss.android.socialbase.appdownloader.f.c;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private int[] f49082c;

    /* renamed from: w  reason: collision with root package name */
    private int[] f49083w;

    private f() {
    }

    public static f c(sr srVar) throws IOException {
        w.c(srVar, 1835009);
        int w3 = srVar.w();
        int w4 = srVar.w();
        int w5 = srVar.w();
        srVar.w();
        int w6 = srVar.w();
        int w7 = srVar.w();
        f fVar = new f();
        fVar.f49082c = srVar.w(w4);
        if (w5 != 0) {
            srVar.w(w5);
        }
        int i4 = (w7 == 0 ? w3 : w7) - w6;
        if (i4 % 4 == 0) {
            fVar.f49083w = srVar.w(i4 / 4);
            if (w7 != 0) {
                int i5 = w3 - w7;
                if (i5 % 4 == 0) {
                    srVar.w(i5 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i5 + ").");
                }
            }
            return fVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i4 + ").");
    }

    public String c(int i4) {
        int[] iArr;
        if (i4 < 0 || (iArr = this.f49082c) == null || i4 >= iArr.length) {
            return null;
        }
        int i5 = iArr[i4];
        int c4 = c(this.f49083w, i5);
        StringBuilder sb = new StringBuilder(c4);
        while (c4 != 0) {
            i5 += 2;
            sb.append((char) c(this.f49083w, i5));
            c4--;
        }
        return sb.toString();
    }

    private static final int c(int[] iArr, int i4) {
        int i5 = iArr[i4 / 4];
        return (i4 % 4) / 2 == 0 ? i5 & 65535 : i5 >>> 16;
    }
}
